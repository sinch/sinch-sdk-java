package com.sinch.sdk.auth.adapters;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.http.DefaultRetryManager;
import com.sinch.sdk.http.RetryCapable;
import com.sinch.sdk.models.RetryConfiguration;
import com.sinch.sdk.models.RetryPolicy;
import com.sinch.sdk.models.UnifiedCredentials;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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
  class RateLimitedTokenRequest {

    private HttpResponse rateLimited() {
      Map<String, List<String>> headers = new HashMap<>();
      headers.put("Retry-After", Collections.singletonList("0"));
      return new HttpResponse(429, "Too Many Requests", headers, null);
    }

    private HttpResponse ok() {
      return new HttpResponse(
          200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void retriesARateLimitedTokenRequestThenSucceeds() {
      when(httpClient.invokeAPI(any(), any(), any()))
          .thenReturn(rateLimited(), rateLimited(), ok());

      Collection<Pair<String, String>> headers =
          authManager.getAuthorizationHeaders(null, null, null, null);

      assertEquals("Bearer token value", headers.iterator().next().getRight());
      verify(httpClient, times(3)).invokeAPI(any(), any(), any());
    }

    @Test
    void reportsTheRateLimitOnceTheBudgetIsSpent() {
      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(rateLimited());

      ApiException exception =
          assertThrows(
              ApiException.class,
              () -> authManager.getAuthorizationHeaders(null, null, null, null));

      assertEquals(
          429,
          exception.getCode(),
          "a spent budget on the token exchange must surface the status the server sent,"
              + " the same one a domain endpoint reports");
      assertTrue(
          exception.getMessage().contains("rate limited by the authentication service (HTTP 429)"),
          "expected the failure to name the rate limit, got: " + exception.getMessage());
      verify(httpClient, times(RetryConfiguration.DEFAULT_MAX_RETRY_COUNT + 1))
          .invokeAPI(any(), any(), any());
    }

    @Test
    void takesThePolicyFromATransportThatCarriesOne() {
      HttpClient capable =
          mock(HttpClient.class, withSettings().extraInterfaces(RetryCapable.class));
      when(capable.invokeAPI(any(), any(), any())).thenReturn(rateLimited());
      when(((RetryCapable) capable).getRetryManager())
          .thenReturn(
              Optional.of(
                  new DefaultRetryManager(
                      RetryConfiguration.builder().setRetryPolicy(RetryPolicy.NONE).build())));
      AuthManager manager =
          new OAuthManager(
              credentials,
              new ServerConfiguration("OAuth url"),
              HttpMapper.getInstance(),
              () -> capable);

      assertThrows(
          ApiException.class, () -> manager.getAuthorizationHeaders(null, null, null, null));

      verify(capable, times(1)).invokeAPI(any(), any(), any());
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
          exception.getMessage().startsWith("OAuth request failed: network or client error"),
          "expected a network/client-error cause, got: " + exception.getMessage());

      verify(httpClient, times(1)).invokeAPI(any(), any(), any());
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
          exception.getMessage().startsWith("Unable to extract token with HTTP 503"),
          "expected an HTTP-status cause, got: " + exception.getMessage());

      verify(httpClient, times(1)).invokeAPI(any(), any(), any());
    }

    @Test
    void successWithoutAccessTokenThrowsWithoutRetryOrBackoff() {
      HttpResponse noToken =
          new HttpResponse(
              200, "foo message", null, "{\"expires_in\":3600}".getBytes(StandardCharsets.UTF_8));
      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(noToken);

      ApiAuthException exception =
          assertThrows(
              ApiAuthException.class,
              () -> spyAuthManager.getAuthorizationHeaders(null, null, null, null));
      assertTrue(
          exception.getMessage().contains("carries no access_token"),
          "expected the missing-token cause, got: " + exception.getMessage());

      verify(httpClient, times(1)).invokeAPI(any(), any(), any());
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
          exception.getMessage().startsWith("Unable to extract token: could not deserialize"),
          "expected a deserialization cause, got: " + exception.getMessage());

      verify(httpClient, times(1)).invokeAPI(any(), any(), any());
    }
  }

  @Nested
  class ConcurrentRefresh {

    @Test
    void concurrentCallersShareASingleRefresh() throws Exception {
      Map<String, List<String>> retryAfterNow = new HashMap<>();
      retryAfterNow.put("Retry-After", Collections.singletonList("0"));
      OAuthManager spyAuthManager =
          spy(
              new OAuthManager(
                  credentials,
                  new ServerConfiguration("OAuth url"),
                  HttpMapper.getInstance(),
                  () -> httpClient));
      HttpResponse rateLimited = new HttpResponse(429, "Too Many Requests", retryAfterNow, null);
      HttpResponse ok =
          new HttpResponse(200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8));
      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(rateLimited, ok);

      int callers = 10;
      ExecutorService pool = Executors.newFixedThreadPool(callers);
      CountDownLatch startTogether = new CountDownLatch(1);
      List<Future<Collection<Pair<String, String>>>> results = new ArrayList<>();
      try {
        for (int i = 0; i < callers; i++) {
          results.add(
              pool.submit(
                  () -> {
                    startTogether.await();
                    return spyAuthManager.getAuthorizationHeaders(null, null, null, null);
                  }));
        }
        startTogether.countDown();

        for (Future<Collection<Pair<String, String>>> result : results) {
          Collection<Pair<String, String>> headers = result.get(10, TimeUnit.SECONDS);
          assertEquals("Bearer token value", headers.iterator().next().getRight());
        }
      } finally {
        pool.shutdownNow();
      }

      // one shared sequence for all ten callers: the 429, then the retry that succeeded
      verify(httpClient, times(2)).invokeAPI(any(), any(), any());
    }
  }
}
