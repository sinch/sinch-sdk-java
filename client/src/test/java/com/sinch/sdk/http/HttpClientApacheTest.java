package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Scanner;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpClientApacheTest {

  private HttpClientApache client;
  private AuthManager mockAuthManager;

  @BeforeEach
  void setup() throws Exception {
    CloseableHttpClient mockApacheClient = mock(CloseableHttpClient.class);
    mockAuthManager = mock(AuthManager.class);

    // Create an instance of HttpClientApache and inject the mock HTTP client
    client = spy(new HttpClientApache());
    Field clientField = HttpClientApache.class.getDeclaredField("client");
    clientField.setAccessible(true);
    clientField.set(client, mockApacheClient);
  }

  @Test
  void testInvokeApiHandles401WithEmptyHeaders() throws Exception {
    // GIVEN: a simulated 401 response with empty headers
    HttpResponse unauthorizedResponse =
        new HttpResponse(
            401,
            "Unauthorized",
            Collections.emptyMap(), // Empty headers
            null);

    // Spy on processRequest() to return the mocked 401 response
    doReturn(unauthorizedResponse).when(client).processRequest(any(), any());

    // Mock ServerConfiguration and HttpRequest
    ServerConfiguration serverConfig = mock(ServerConfiguration.class);
    when(serverConfig.getUrl()).thenReturn("https://api.example.com");

    HttpRequest request = mock(HttpRequest.class);
    when(request.getFullUrl()).thenReturn(Optional.of("https://api.example.com/v1/test"));
    when(request.getMethod()).thenReturn(HttpMethod.GET);
    when(request.getQueryParameters()).thenReturn(Collections.emptyList());
    when(request.getBody()).thenReturn(null);
    when(request.getFormParams()).thenReturn(Collections.emptyMap());
    when(request.getHeaderParams()).thenReturn(Collections.emptyMap());
    when(request.getAccept()).thenReturn(Collections.emptyList());
    when(request.getContentType()).thenReturn(Collections.emptyList());
    when(request.getAuthNames()).thenReturn(Collections.singletonList("Bearer"));

    // Mock AuthManagers map (bearer)
    Map<String, AuthManager> authManagers = new HashMap<>();
    authManagers.put(OAuthManager.SCHEMA_KEYWORD_BEARER, mockAuthManager);
    when(mockAuthManager.getSchema()).thenReturn(OAuthManager.SCHEMA_KEYWORD_BEARER);

    // WHEN: invokeAPI is called
    HttpResponse response = client.invokeAPI(serverConfig, authManagers, request);

    // THEN: response is returned (no crash)
    assertEquals(401, response.getCode());
    assertEquals("Unauthorized", response.getMessage());

    // AND: resetToken() is not called (no headers to check)
    verify(mockAuthManager, never()).resetToken();
  }

  @Test
  void processResponseDecodesBodyAsUtf8() throws Exception {
    String nonAscii = "Ünïcödé resülts";
    byte[] utf8Bytes = nonAscii.getBytes(StandardCharsets.UTF_8);

    HttpEntity entity = mock(HttpEntity.class);
    when(entity.getContent()).thenReturn(new ByteArrayInputStream(utf8Bytes));

    ClassicHttpResponse httpResponse = mock(ClassicHttpResponse.class);
    when(httpResponse.getCode()).thenReturn(200);
    when(httpResponse.getReasonPhrase()).thenReturn("OK");
    when(httpResponse.getHeaders()).thenReturn(new Header[0]);
    when(httpResponse.getEntity()).thenReturn(entity);

    Method processResponse =
        HttpClientApache.class.getDeclaredMethod("processResponse", ClassicHttpResponse.class);
    processResponse.setAccessible(true);

    HttpResponse result = (HttpResponse) processResponse.invoke(null, httpResponse);

    assertNotNull(result.getContent());
    try (Scanner s =
        new Scanner(result.getContent(), StandardCharsets.UTF_8.name()).useDelimiter("\\A")) {
      String decoded = s.hasNext() ? s.next() : "";
      assertEquals(nonAscii, decoded, "Response body must round-trip through UTF-8 correctly");
    }
  }
}
