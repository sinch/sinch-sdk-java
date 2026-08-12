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
import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.UnifiedCredentials;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
      doReturn(0L).when(spyAuthManager).computeBackoffMillis(any(), anyInt());
      HttpResponse rateLimited =
          new HttpResponse(429, "Too Many Requests", Collections.emptyMap(), null);
      HttpResponse ok =
          new HttpResponse(200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8));

      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(rateLimited, rateLimited, ok);

      Collection<Pair<String, String>> headers =
          spyAuthManager.getAuthorizationHeaders(null, null, null, null);

      assertNotNull(headers);
      verify(httpClient, times(3)).invokeAPI(any(), any(), any());
    }

    @Test
    void givesUpAfterMaxRetries() {
      doReturn(0L).when(spyAuthManager).computeBackoffMillis(any(), anyInt());
      HttpResponse rateLimited =
          new HttpResponse(429, "Too Many Requests", Collections.emptyMap(), null);
      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(rateLimited);
      ApiAuthException exception =
          assertThrows(
              ApiAuthException.class,
              () -> spyAuthManager.getAuthorizationHeaders(null, null, null, null));
      assertTrue(
          exception.getMessage().contains("rate limited by the authentication service (HTTP 429)"),
          "expected the give-up message to name the rate limit, got: " + exception.getMessage());
      verify(httpClient, times(OAuthManager.MAX_RATE_LIMIT_RETRIES + 1))
          .invokeAPI(any(), any(), any());
      verify(spyAuthManager, times(OAuthManager.MAX_RATE_LIMIT_RETRIES))
          .computeBackoffMillis(any(), anyInt());
    }

    @Test
    void feedsTheRateLimitedResponseToTheBackoff() {
      doReturn(0L).when(spyAuthManager).computeBackoffMillis(any(), anyInt());
      Map<String, List<String>> headers = new HashMap<>();
      headers.put("Retry-After", Collections.singletonList("5"));
      HttpResponse rateLimited = new HttpResponse(429, "Too Many Requests", headers, null);
      HttpResponse ok =
          new HttpResponse(200, "foo message", null, jsonResponse.getBytes(StandardCharsets.UTF_8));
      when(httpClient.invokeAPI(any(), any(), any())).thenReturn(rateLimited, ok);
      spyAuthManager.getAuthorizationHeaders(null, null, null, null);
      ArgumentCaptor<HttpResponse> captor = ArgumentCaptor.forClass(HttpResponse.class);
      verify(spyAuthManager).computeBackoffMillis(captor.capture(), eq(0));
      assertSame(rateLimited, captor.getValue());
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
      verify(spyAuthManager, never()).computeBackoffMillis(any(), anyInt());
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
      verify(spyAuthManager, never()).computeBackoffMillis(any(), anyInt());
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
      verify(spyAuthManager, never()).computeBackoffMillis(any(), anyInt());
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
      verify(spyAuthManager, never()).computeBackoffMillis(any(), anyInt());
    }
  }

  @Nested
  class ConcurrentRefresh {

    @Test
    void concurrentCallersShareASingleRefresh() throws Exception {
      OAuthManager spyAuthManager =
          spy(
              new OAuthManager(
                  credentials,
                  new ServerConfiguration("OAuth url"),
                  HttpMapper.getInstance(),
                  () -> httpClient));
      doReturn(0L).when(spyAuthManager).computeBackoffMillis(any(), anyInt());
      HttpResponse rateLimited =
          new HttpResponse(429, "Too Many Requests", Collections.emptyMap(), null);
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

  @Nested
  class ComputeBackoff {

    private OAuthManager manager;

    @BeforeEach
    void setup() {
      manager =
          new OAuthManager(
              credentials,
              new ServerConfiguration("OAuth url"),
              HttpMapper.getInstance(),
              () -> httpClient);
    }

    @Test
    void honorsRetryAfter() {
      assertBetween(5_000, 5_250, backoff("Retry-After", "5", 0));
      assertBetween(
          4_000,
          5_250,
          backoff("Retry-After", DateUtil.instantToRFC822String(Instant.now().plusSeconds(5)), 0));

      // A zero delay is still a delay, and a date already past means the window has reopened.
      assertBetween(0, 250, backoff("Retry-After", "0", 0));
      assertBetween(
          0,
          250,
          backoff(
              "Retry-After", DateUtil.instantToRFC822String(Instant.now().minusSeconds(3600)), 0));

      // HTTP/2 lower-cases header names, HTTP/1.1 servers usually do not; both must be honored.
      assertBetween(5_000, 5_250, backoff("retry-after", "5", 0));

      // The two obsolete formats a recipient must still accept (RFC 7231 section 7.1.1.1)
      assertBetween(4_000, 5_250, backoff("Retry-After", obsoleteDate("RFC850"), 0));
      assertBetween(4_000, 5_250, backoff("Retry-After", obsoleteDate("asctime"), 0));
    }

    @Test
    void fallsBackToExponentialBackoffWhenRetryAfterIsUnusable() {
      for (String value : new String[] {"", "   ", "abc", "-3", "NaN", "Infinity", "1e30"}) {
        assertBetween(0, 1_000, backoff("Retry-After", value, 0));
      }
    }

    @Test
    void exponentialBackoffGrowsWithEachAttempt() {
      assertBetween(0, 1_000, backoff(null, null, 0));
      assertBetween(0, 4_000, backoff(null, null, 1));
      assertBetween(0, 16_000, backoff(null, null, 2));
    }

    private long backoff(String headerName, String headerValue, int attempt) {
      Map<String, List<String>> headers = new HashMap<>();
      if (null != headerName && null != headerValue) {
        headers.put(headerName, Collections.singletonList(headerValue));
      }
      return manager.computeBackoffMillis(
          new HttpResponse(429, "Too Many Requests", headers, null), attempt);
    }

    /** Formats "five seconds from now" in one of the two obsolete HTTP-date forms. */
    private String obsoleteDate(String form) {
      ZonedDateTime when = ZonedDateTime.ofInstant(Instant.now().plusSeconds(5), ZoneOffset.UTC);
      String pattern =
          "RFC850".equals(form) ? "EEEE, dd-MMM-yy HH:mm:ss 'GMT'" : "EEE MMM ppd HH:mm:ss yyyy";
      return DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH).format(when);
    }

    private void assertBetween(long lowInclusive, long highInclusive, long actual) {
      assertTrue(
          actual >= lowInclusive && actual <= highInclusive,
          "expected a value in [" + lowInclusive + ", " + highInclusive + "], got: " + actual);
    }
  }
}
