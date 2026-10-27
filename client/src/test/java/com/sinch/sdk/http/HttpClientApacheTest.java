package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.transport.BufferedHttpContentParser;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpTransport;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.RetryConfiguration;
import com.sinch.sdk.models.RetryPolicy;
import com.sinch.sdk.models.TransportSettings;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class HttpClientApacheTest {

  private static final ServerConfiguration SERVER =
      new ServerConfiguration("https://api.example.com");

  private HttpTransport transport;
  private HttpClientApache client;
  private AuthManager mockAuthManager;
  private Map<String, AuthManager> authManagers;

  @BeforeEach
  void setup() {
    transport = mock(HttpTransport.class);
    client = new HttpClientApache(transport, null);

    mockAuthManager = mock(AuthManager.class);
    when(mockAuthManager.getSchema()).thenReturn(OAuthManager.SCHEMA_KEYWORD_BEARER);
    when(mockAuthManager.getAuthorizationHeaders(any(), any(), any(), any()))
        .thenReturn(Collections.emptyList());
    authManagers = new HashMap<>();
    authManagers.put(OAuthManager.SCHEMA_KEYWORD_BEARER, mockAuthManager);
  }

  @Test
  void testInvokeApiHandles401WithEmptyHeaders() throws Exception {
    // GIVEN: a simulated 401 response with empty headers
    when(transport.send(any()))
        .thenReturn(transportResponse(401, "Unauthorized", new HttpHeaders()));

    // WHEN: invokeAPI is called
    HttpResponse response = client.invokeAPI(SERVER, authManagers, bearerRequest());

    // THEN: response is returned (no crash)
    assertEquals(401, response.getCode());
    assertEquals("Unauthorized", response.getMessage());

    // AND: resetToken() is not called (no headers to check)
    verify(mockAuthManager, never()).resetToken();
    verify(transport, times(1)).send(any());
  }

  @Test
  void testInvokeApi401ExpiredResetsTokenAndSendsAgain() throws Exception {
    HttpHeaders expired =
        new HttpHeaders()
            .add(
                OAuthManager.BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD,
                "Bearer error=\"invalid_token\", error_description=\"expired\"");
    when(transport.send(any()))
        .thenReturn(transportResponse(401, "Unauthorized", expired))
        .thenReturn(transportResponse(200, "OK", new HttpHeaders()));
    when(mockAuthManager.getAuthorizationHeaders(any(), any(), any(), any()))
        .thenReturn(Collections.singletonList(new Pair<>("Authorization", "Bearer old")))
        .thenReturn(Collections.singletonList(new Pair<>("Authorization", "Bearer new")));

    HttpResponse response = client.invokeAPI(SERVER, authManagers, bearerRequest());

    assertEquals(200, response.getCode());
    verify(mockAuthManager, times(1)).resetToken();
    ArgumentCaptor<com.sinch.sdk.core.http.transport.HttpRequest> sent =
        ArgumentCaptor.forClass(com.sinch.sdk.core.http.transport.HttpRequest.class);
    verify(transport, times(2)).send(sent.capture());
    assertEquals(
        Arrays.asList("Bearer old", "Bearer new"),
        Arrays.asList(
            sent.getAllValues().get(0).getHeaders().getFirst("authorization").orElse(null),
            sent.getAllValues().get(1).getHeaders().getFirst("authorization").orElse(null)));
  }

  @Test
  void testInvokeApi407DoesNotTriggerOAuthRefresh() throws Exception {
    HttpHeaders proxyHeaders =
        new HttpHeaders()
            .add(
                OAuthManager.BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD,
                "Bearer realm=\"proxy\", error=\"expired\"");
    when(transport.send(any()))
        .thenReturn(transportResponse(407, "Proxy Authentication Required", proxyHeaders));

    HttpResponse response = client.invokeAPI(SERVER, authManagers, bearerRequest());

    assertEquals(407, response.getCode());
    verify(mockAuthManager, never()).resetToken();
    verify(transport, times(1)).send(any());
  }

  @Test
  void authorizationIsComputedOntoTheRequestSent() throws Exception {
    when(transport.send(any())).thenReturn(transportResponse(200, "OK", new HttpHeaders()));
    when(mockAuthManager.getAuthorizationHeaders(any(), any(), any(), any()))
        .thenReturn(Collections.singletonList(new Pair<>("Authorization", "Bearer token")));

    HttpRequest request =
        new HttpRequest(
            "/v1/a%20b",
            HttpMethod.POST,
            Collections.emptyList(),
            "{\"foo\":\"bar\"}",
            null,
            Collections.singletonList("application/json"),
            Collections.singletonList("application/json; charset=utf-8"),
            Collections.singletonList(OAuthManager.SCHEMA_KEYWORD_BEARER));

    client.invokeAPI(SERVER, authManagers, request);

    verify(mockAuthManager)
        .getAuthorizationHeaders(
            "POST", "application/json; charset=utf-8", "/v1/a%20b", "{\"foo\":\"bar\"}");
    ArgumentCaptor<com.sinch.sdk.core.http.transport.HttpRequest> sent =
        ArgumentCaptor.forClass(com.sinch.sdk.core.http.transport.HttpRequest.class);
    verify(transport).send(sent.capture());
    assertEquals(
        Optional.of("Bearer token"), sent.getValue().getHeaders().getFirst("Authorization"));
  }

  @Test
  void responseIsMappedOntoTheServiceResponse() throws Exception {
    HttpHeaders headers = new HttpHeaders().add("X-Multi", "a").add("x-multi", "b");
    byte[] content = "Ünïcödé".getBytes(StandardCharsets.UTF_8);
    when(transport.send(any()))
        .thenReturn(
            new com.sinch.sdk.core.http.transport.HttpResponse(
                200, "OK", headers, new BufferedHttpContentParser(content, null)));

    HttpResponse response = client.invokeAPI(SERVER, authManagers, bearerRequest());

    assertEquals(200, response.getCode());
    assertEquals("OK", response.getMessage());
    assertEquals(Arrays.asList("a", "b"), response.getHeaders().get("X-Multi"));
    assertArrayEquals(content, readAll(response));
  }

  @Test
  void transportFailureIsReportedAsApiException() throws Exception {
    when(transport.send(any())).thenThrow(new IOException("connection reset"));

    ApiException e =
        assertThrows(
            ApiException.class, () -> client.invokeAPI(SERVER, authManagers, bearerRequest()));
    assertTrue(e.getMessage().contains("connection reset"));
  }

  @Test
  void closeClosesTheTransport() throws Exception {
    client.close();

    assertTrue(client.isClosed());
    verify(transport).close();
    assertThrows(ApiException.class, () -> client.invokeAPI(SERVER, authManagers, bearerRequest()));
  }

  @Test
  void aClientCarryingNoManagerRetriesNothing() throws Exception {
    try (HttpClientApache noRetries =
        new HttpClientApache(null, null, TransportSettings.DEFAULT_TIMEOUT_SECONDS)) {
      assertSame(RetryManager.NO_RETRY, noRetries.getRetryManager().get());
    }
  }

  @Test
  void exposesTheManagerItWasBuiltWith() throws Exception {
    RetryConfiguration configured =
        RetryConfiguration.builder().setRetryPolicy(RetryPolicy.BACKOFF).build();

    try (HttpClientApache configuredClient =
        new HttpClientApache(
            null, new DefaultRetryManager(configured), TransportSettings.DEFAULT_TIMEOUT_SECONDS)) {
      assertEquals(
          RetryPolicy.BACKOFF,
          configuredClient.getRetryManager().get().getRetryConfiguration().getRetryPolicy());
    }
  }

  private static HttpRequest bearerRequest() {
    return new HttpRequest(
        "https://api.example.com/v1/test",
        HttpMethod.GET,
        null,
        Collections.emptyMap(),
        Collections.emptyList(),
        Collections.emptyList(),
        Collections.singletonList(OAuthManager.SCHEMA_KEYWORD_BEARER));
  }

  private static com.sinch.sdk.core.http.transport.HttpResponse transportResponse(
      int status, String reasonPhrase, HttpHeaders headers) {
    return new com.sinch.sdk.core.http.transport.HttpResponse(
        status, reasonPhrase, headers, new BufferedHttpContentParser(null, null));
  }

  private static byte[] readAll(HttpResponse response) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    InputStream in = response.getContent();
    byte[] buffer = new byte[256];
    int read;
    while ((read = in.read(buffer)) != -1) {
      out.write(buffer, 0, read);
    }
    return out.toByteArray();
  }
}
