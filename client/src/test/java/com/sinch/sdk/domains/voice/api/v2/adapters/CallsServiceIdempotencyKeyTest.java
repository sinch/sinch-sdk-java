package com.sinch.sdk.domains.voice.api.v2.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.voice.api.v2.CallsService;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommandDtoTest;
import com.sinch.sdk.http.DefaultRetryManager;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.models.RetryConfiguration;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The Idempotency-Key must be the same on every attempt the SDK makes for one call, whether the
 * caller set it or the SDK generated it. Otherwise a retry after a rate limit or a token refresh
 * could start a second call.
 */
class CallsServiceIdempotencyKeyTest {

  static final String START_CALL_RESPONSE =
      "{\"projectId\": \"p\", \"serviceId\": \"s\", \"sessionId\": \"x\"}";

  /** Stands in for OAuthManager: a bearer scheme, so an expired token triggers a retry. */
  static final AuthManager BEARER =
      new AuthManager() {
        @Override
        public String getSchema() {
          return AuthManager.SCHEMA_KEYWORD_BEARER;
        }

        @Override
        public void resetToken() {}

        @Override
        public Collection<Pair<String, String>> getAuthorizationHeaders(
            String timestamp, String method, String httpContentType, String path, String body) {
          return Collections.singletonList(new Pair<>("Authorization", "Bearer token"));
        }

        @Override
        public boolean validateAuthenticatedRequest(
            String method, String path, Map<String, String> headers, String jsonPayload) {
          return false;
        }
      };

  MockWebServer server;
  HttpClientApache httpClient;
  CallsService service;

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    server.start();
    httpClient =
        new HttpClientApache(
            null,
            new DefaultRetryManager(RetryConfiguration.builder().setMaxRetryCount(1).build()));
    service =
        new CallsServiceImpl(
            httpClient,
            new ServerConfiguration("http://" + server.getHostName() + ":" + server.getPort()),
            Collections.singletonMap("SinchOAuth2", BEARER),
            HttpMapper.getInstance(),
            "project");
  }

  @AfterEach
  void tearDown() throws Exception {
    httpClient.close();
    server.shutdown();
  }

  StartCallRequest.Builder request() {
    return StartCallRequest.builder()
        .setCommands(Collections.singletonList(DialCommandDtoTest.expectedDialCommand));
  }

  MockResponse created() {
    return new MockResponse()
        .setResponseCode(201)
        .addHeader("Content-Type", "application/json")
        .setBody(START_CALL_RESPONSE);
  }

  String takeIdempotencyKey() throws InterruptedException {
    return server.takeRequest().getHeader("Idempotency-Key");
  }

  @Test
  void generatedKeyIsReusedWhenRateLimitedCallIsRetried() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(429).addHeader("Retry-After", "1"));
    server.enqueue(created());

    service.start(request().build());

    assertEquals(2, server.getRequestCount(), "expected the 429 to be retried once");
    String first = takeIdempotencyKey();
    assertDoesNotThrow(() -> UUID.fromString(first), "generated key is not a UUID: " + first);
    assertEquals(first, takeIdempotencyKey());
  }

  @Test
  void callerKeyIsReusedWhenRateLimitedCallIsRetried() throws Exception {
    server.enqueue(new MockResponse().setResponseCode(429).addHeader("Retry-After", "1"));
    server.enqueue(created());

    service.start(request().setIdempotencyKey("caller-key-0123456789").build());

    assertEquals(2, server.getRequestCount(), "expected the 429 to be retried once");
    assertEquals("caller-key-0123456789", takeIdempotencyKey());
    assertEquals("caller-key-0123456789", takeIdempotencyKey());
  }

  @Test
  void generatedKeyIsReusedWhenCallIsRetriedAfterTokenRefresh() throws Exception {
    server.enqueue(
        new MockResponse()
            .setResponseCode(401)
            .addHeader("www-authenticate", "Bearer error=\"expired\""));
    server.enqueue(created());

    service.start(request().build());

    assertEquals(2, server.getRequestCount(), "expected the 401 to be retried once");
    assertEquals(takeIdempotencyKey(), takeIdempotencyKey());
  }

  @Test
  void eachCallGetsItsOwnGeneratedKey() throws Exception {
    server.enqueue(created());
    server.enqueue(created());

    service.start(request().build());
    service.start(request().build());

    assertNotEquals(takeIdempotencyKey(), takeIdempotencyKey());
  }
}
