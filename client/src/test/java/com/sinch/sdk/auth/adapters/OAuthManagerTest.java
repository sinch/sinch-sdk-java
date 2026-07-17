package com.sinch.sdk.auth.adapters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.UnifiedCredentials;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class OAuthManagerTest extends BaseTest {
  static final String KEY = "fooKey";
  static final String SECRET = "fooSecret";
  static final String PROJECT = "fooProject";

  @GivenTextResource("/client/auth/BearerAuthResponse.json")
  String jsonResponse;

  @Mock HttpClient httpClient;
  @Captor ArgumentCaptor<ServerConfiguration> serverConfigurationCaptor;
  @Captor ArgumentCaptor<HttpRequest> httpRequestCaptor;
  UnifiedCredentials credentials =
      UnifiedCredentials.builder().setKeyId(KEY).setKeySecret(SECRET).setProjectId(PROJECT).build();

  AuthManager authManager;

  @BeforeEach
  public void initEach() {
    authManager =
        new OAuthManager(
            credentials,
            new ServerConfiguration("OAuth url"),
            HttpMapper.getInstance(),
            () -> httpClient);
  }

  @Test
  void getSchema() {
    assertEquals("Bearer", authManager.getSchema());
  }

  @Test
  void getAuthorizationHeaders() {
    Collection<Pair<String, String>> expectedHeaders =
        Collections.singletonList(new Pair<>("Authorization", "Bearer token value"));

    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8)));

    Collection<Pair<String, String>> headers =
        authManager.getAuthorizationHeaders(null, null, null, null);

    Assertions.assertThat(headers).usingRecursiveComparison().isEqualTo(expectedHeaders);
  }

  @Test
  void callToOAuthServer() {
    when(httpClient.invokeAPI(
            serverConfigurationCaptor.capture(), any(), httpRequestCaptor.capture()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8)));

    authManager.getAuthorizationHeaders(null, null, null, null);

    ServerConfiguration serverConfigurationValue = serverConfigurationCaptor.getValue();
    assertEquals("OAuth url", serverConfigurationValue.getUrl());

    HttpRequest httpRequestCaptorValue = httpRequestCaptor.getValue();
    assertEquals(HttpMethod.POST, httpRequestCaptorValue.getMethod());
    assertTrue(httpRequestCaptorValue.getAuthNames().stream().anyMatch(e -> e.equals("Basic")));
    assertTrue(
        httpRequestCaptorValue.getContentType().stream()
            .anyMatch(e -> e.equals("application/x-www-form-urlencoded")));
    assertEquals("grant_type=client_credentials", httpRequestCaptorValue.getBody());
  }

  @Test
  void resetToken() {
    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8)));

    authManager.resetToken();
    authManager.getAuthorizationHeaders(null, null, null, null);

    verify(httpClient, times(1)).invokeAPI(any(), any(), any());
  }

  @Test
  void noInfiniteLoopAndException() {
    ApiAuthException exception =
        assertThrows(
            ApiAuthException.class,
            () -> authManager.getAuthorizationHeaders(null, null, null, null));
    assertEquals(exception.getCode(), 401);
  }

  @Nested
  class RetryOn429WithBackoff {

    private OAuthManager spyAuthManager;

    @BeforeEach
    void setup() {
      spyAuthManager =
          spy(
              new OAuthManager(
                  credentials,
                  new ServerConfiguration("OAuth url"),
                  HttpMapper.getInstance(),
                  () -> httpClient));
    }

    @Test
    void retriesOn429ThenSucceeds() {
      doReturn(0L).when(spyAuthManager).computeBackoffMillis(anyInt());
      HttpResponse rateLimited =
          new HttpResponse(429, "Too Many Requests", Collections.emptyMap(), null);
      HttpResponse ok =
          new HttpResponse(200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8));

      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(rateLimited, rateLimited, ok);

      Collection<Pair<String, String>> headers =
          spyAuthManager.getAuthorizationHeaders(null, null, null, null);

      assertNotNull(headers);
      verify(httpClient, times(OAuthManager.MAX_REFRESH_ATTEMPT)).invokeAPI(any(), any(), any());
    }

    @Test
    void givesUpAfterMaxRetries() {
      doReturn(0L).when(spyAuthManager).computeBackoffMillis(anyInt());
      HttpResponse rateLimited =
          new HttpResponse(429, "Too Many Requests", Collections.emptyMap(), null);

      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(rateLimited);

      ApiAuthException exception =
          assertThrows(
              ApiAuthException.class,
              () -> spyAuthManager.getAuthorizationHeaders(null, null, null, null));
      assertTrue(
          exception.getMessage().startsWith("Unable to get new token"),
          "expected the give-up message, got: " + exception.getMessage());

      verify(httpClient, times(OAuthManager.MAX_REFRESH_ATTEMPT)).invokeAPI(any(), any(), any());
    }

    @Test
    void noBackoffOnNon429Failure() {
      HttpResponse serverError =
          new HttpResponse(500, "Internal Server Error", Collections.emptyMap(), new byte[0]);
      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(serverError);

      assertThrows(
          ApiAuthException.class,
          () -> spyAuthManager.getAuthorizationHeaders(null, null, null, null));

      verify(spyAuthManager, never()).computeBackoffMillis(anyInt());
    }
  }

  @Nested
  class FailFastErrors {

    private OAuthManager spyAuthManager;

    @BeforeEach
    void setup() {
      spyAuthManager =
          spy(
              new OAuthManager(
                  credentials,
                  new ServerConfiguration("OAuth url"),
                  HttpMapper.getInstance(),
                  () -> httpClient));
    }

    @Test
    void networkErrorThrowsWithoutRetryOrBackoff() {
      when(httpClient.invokeAPI(any(), any(), any()))
          .thenThrow(new RuntimeException("connection refused"));

      ApiAuthException exception =
          assertThrows(
              ApiAuthException.class,
              () -> spyAuthManager.getAuthorizationHeaders(null, null, null, null));
      assertTrue(
          exception.getMessage().startsWith("Token refresh failed: network or client error"),
          "expected a network/client-error cause, got: " + exception.getMessage());

      verify(httpClient, times(1)).invokeAPI(any(), any(), any());
      verify(spyAuthManager, never()).computeBackoffMillis(anyInt());
    }

    @Test
    void nonSuccessfulStatusThrowsWithoutRetryOrBackoff() {
      HttpResponse serverError =
          new HttpResponse(503, "Service Unavailable", Collections.emptyMap(), new byte[0]);
      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(serverError);

      ApiAuthException exception =
          assertThrows(
              ApiAuthException.class,
              () -> spyAuthManager.getAuthorizationHeaders(null, null, null, null));
      assertTrue(
          exception.getMessage().startsWith("Token refresh failed with HTTP 503"),
          "expected an HTTP-status cause, got: " + exception.getMessage());

      verify(httpClient, times(1)).invokeAPI(any(), any(), any());
      verify(spyAuthManager, never()).computeBackoffMillis(anyInt());
    }

    @Test
    void deserializationFailureThrowsWithoutRetryOrBackoff() {
      HttpResponse invalidBody =
          new HttpResponse(200, "foo message", null, "not-json".getBytes(StandardCharsets.UTF_8));
      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(invalidBody);

      ApiAuthException exception =
          assertThrows(
              ApiAuthException.class,
              () -> spyAuthManager.getAuthorizationHeaders(null, null, null, null));
      assertTrue(
          exception.getMessage().startsWith("Token refresh failed: could not deserialize response"),
          "expected a deserialization cause, got: " + exception.getMessage());

      verify(httpClient, times(1)).invokeAPI(any(), any(), any());
      verify(spyAuthManager, never()).computeBackoffMillis(anyInt());
    }
  }

  @Nested
  class ComputeBackoff {

    @Test
    void exponentialGrowth() {
      OAuthManager manager =
          new OAuthManager(
              credentials,
              new ServerConfiguration("OAuth url"),
              HttpMapper.getInstance(),
              () -> httpClient);

      long b0 = manager.computeBackoffMillis(0);
      assertTrue(b0 >= 0 && b0 <= 1000);

      long b1 = manager.computeBackoffMillis(1);
      assertTrue(b1 >= 0 && b1 <= 4000);

      long b2 = manager.computeBackoffMillis(2);
      assertTrue(b2 >= 0 && b2 <= 16000);
    }
  }
}
