package com.sinch.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numberlookup.models.v2.request.NumberLookupRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.NumberLookupContext;
import com.sinch.sdk.models.RetryConfiguration;
import com.sinch.sdk.models.RetryPolicy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinchClientRetryTest extends BaseTest {

  private static final String AUTH_PATH = "/auth";
  private static final String TOKEN_JSON =
      "{\"access_token\":\"test-token\",\"expires_in\":3600,\"token_type\":\"Bearer\"}";

  private MockWebServer server;
  private final AtomicInteger lookupRequests = new AtomicInteger();
  private final List<Integer> lookupResponses = new ArrayList<>();
  private final AtomicInteger authRequests = new AtomicInteger();
  private final List<Integer> authResponses = new ArrayList<>();

  @BeforeEach
  void setUp() throws IOException {
    server = new MockWebServer();
    lookupRequests.set(0);
    authRequests.set(0);
    // Routed by path rather than queued, so the token exchange cannot consume a lookup response
    server.setDispatcher(
        new Dispatcher() {
          @Override
          public MockResponse dispatch(RecordedRequest request) {
            String path = null != request.getPath() ? request.getPath() : "";
            if (path.startsWith(AUTH_PATH)) {
              int n = authRequests.incrementAndGet();
              if (n <= authResponses.size() && 429 == authResponses.get(n - 1)) {
                return new MockResponse().setResponseCode(429).addHeader("Retry-After", "0");
              }
              return new MockResponse()
                  .setResponseCode(200)
                  .addHeader("Content-Type", "application/json")
                  .setBody(TOKEN_JSON);
            }
            int n = lookupRequests.incrementAndGet();
            int code = n <= lookupResponses.size() ? lookupResponses.get(n - 1) : 200;
            MockResponse response =
                new MockResponse()
                    .setResponseCode(code)
                    .addHeader("Content-Type", "application/json")
                    .setBody("{}");
            // Retry-After: 0 keeps the wait to jitter alone, so the test does not sleep
            return code == 429 ? response.addHeader("Retry-After", "0") : response;
          }
        });
    server.start();
  }

  @AfterEach
  void tearDown() throws IOException {
    server.shutdown();
  }

  private SinchClient clientWith(RetryPolicy policy) {
    Configuration.Builder builder =
        Configuration.builder()
            .setKeyId("key")
            .setKeySecret("secret")
            .setProjectId("project")
            .setOAuthUrl(server.url(AUTH_PATH).toString())
            .setNumberLookupContext(
                NumberLookupContext.builder()
                    .setNumberLookupUrl(server.url("/lookup").toString())
                    .build());
    if (null != policy) {
      builder.setRetryConfiguration(RetryConfiguration.builder().setRetryPolicy(policy).build());
    }
    return new SinchClient(builder.build());
  }

  private void lookup(SinchClient client) {
    client.lookup().v2().lookup(NumberLookupRequest.builder().setNumber("+46700000000").build());
  }

  @Test
  void aDomainEndpointIsRetriedJustLikeTheTokenExchange() {
    lookupResponses.add(429);
    lookupResponses.add(429);

    try (SinchClientCloser closer = new SinchClientCloser(clientWith(null))) {
      lookup(closer.client);
    }

    assertEquals(
        3, lookupRequests.get(), "the lookup endpoint itself must be retried, not only /auth");
  }

  @Test
  void aDomainEndpointStopsAtTheConfiguredBudget() {
    for (int i = 0; i < 10; i++) {
      lookupResponses.add(429);
    }

    try (SinchClientCloser closer = new SinchClientCloser(clientWith(null))) {
      // Budget spent, so the 429 surfaces to the caller through the usual error mapping
      ApiException thrown = assertThrows(ApiException.class, () -> lookup(closer.client));
      assertEquals(
          429, thrown.getCode(), "the caller must see the status the server actually sent");
    }

    assertEquals(4, lookupRequests.get(), "default policy allows 3 retries on top of the attempt");
  }

  @Test
  void aDomainEndpointHonorsADisabledPolicy() {
    lookupResponses.add(429);

    try (SinchClientCloser closer = new SinchClientCloser(clientWith(RetryPolicy.NONE))) {
      ApiException thrown = assertThrows(ApiException.class, () -> lookup(closer.client));
      assertEquals(429, thrown.getCode());
    }

    assertEquals(1, lookupRequests.get(), "NONE must reach the domain endpoints too");
  }

  /**
   * The token request travels through the same retrying client as the call that triggered it. One
   * retry loop must apply to it, not two nested ones — nesting would multiply the budgets and hit
   * the auth service {@code (maxRetryCount + 1)^2} times for a single domain call.
   */
  @Test
  void aRateLimitedTokenRequestIsRetriedOnceOverNotTwice() {
    for (int i = 0; i < 10; i++) {
      authResponses.add(429);
    }

    try (SinchClientCloser closer = new SinchClientCloser(clientWith(null))) {
      ApiException thrown = assertThrows(ApiException.class, () -> lookup(closer.client));
      assertEquals(
          429,
          thrown.getCode(),
          "a rate-limited token exchange must report 429, not an authentication failure");
    }

    assertEquals(
        4,
        authRequests.get(),
        "one retry budget must apply to the token request, not one budget per attempt");
    assertEquals(0, lookupRequests.get(), "the domain call cannot go out without a token");
  }

  @Test
  void aSuccessfulDomainCallIsSentOnce() {
    try (SinchClientCloser closer = new SinchClientCloser(clientWith(null))) {
      lookup(closer.client);
    }

    assertEquals(1, lookupRequests.get());
  }

  /**
   * {@link SinchClient#close()} does not throw, so it needs a small shim to be used in try-with.
   */
  private static final class SinchClientCloser implements AutoCloseable {
    private final SinchClient client;

    private SinchClientCloser(SinchClient client) {
      this.client = client;
    }

    @Override
    public void close() {
      client.close();
    }
  }
}
