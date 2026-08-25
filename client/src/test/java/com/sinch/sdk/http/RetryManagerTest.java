package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.models.RetryConfiguration;
import com.sinch.sdk.models.RetryPolicy;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.OptionalLong;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RetryManagerTest extends BaseTest {

  private static HttpResponse rateLimitedNow() {
    return rateLimited("Retry-After", "0");
  }

  private static HttpResponse rateLimited(String headerName, String headerValue) {
    Map<String, List<String>> headers = new HashMap<>();
    if (null != headerName && null != headerValue) {
      headers.put(headerName, Collections.singletonList(headerValue));
    }
    return new HttpResponse(429, "Too Many Requests", headers, null);
  }

  private static HttpResponse rateLimited() {
    return rateLimited(null, null);
  }

  private static HttpResponse ok() {
    return new HttpResponse(200, "OK", Collections.emptyMap(), null);
  }

  private static DefaultRetryManager manager(RetryPolicy policy) {
    return new DefaultRetryManager(RetryConfiguration.builder().setRetryPolicy(policy).build());
  }

  private static final class ScriptedCall implements Callable<HttpResponse> {

    private final List<HttpResponse> script;
    private final AtomicInteger callsCount = new AtomicInteger();

    private ScriptedCall(HttpResponse... responses) {
      this.script = new ArrayList<>(Arrays.asList(responses));
    }

    @Override
    public HttpResponse call() {
      int n = callsCount.incrementAndGet();
      return script.get(Math.min(n, script.size()) - 1);
    }

    private int callsCount() {
      return callsCount.get();
    }
  }

  private static boolean isLoopActive() {
    return Boolean.TRUE.equals(DefaultRetryManager.LOOP_ACTIVE.get());
  }

  @AfterEach
  void loopFlagMustNotLeakBetweenTests() {
    assertFalse(isLoopActive(), "a retry loop must never outlive the call that opened it");
  }

  @Nested
  class RetryLoop {

    @Test
    void retriesUntilTheRequestSucceeds() throws Exception {
      ScriptedCall call = new ScriptedCall(rateLimitedNow(), rateLimitedNow(), ok());

      HttpResponse response = new DefaultRetryManager(RetryConfiguration.DEFAULTS).execute(call);

      assertEquals(200, response.getCode());
      assertEquals(3, call.callsCount());
    }

    @Test
    void returnsTheRateLimitedResponseOnceTheBudgetIsSpent() throws Exception {
      ScriptedCall call = new ScriptedCall(rateLimitedNow());

      HttpResponse response = new DefaultRetryManager(RetryConfiguration.DEFAULTS).execute(call);

      assertEquals(
          429, response.getCode(), "the caller must see the response the server actually sent");
      assertEquals(RetryConfiguration.DEFAULT_MAX_RETRY_COUNT + 1, call.callsCount());
    }

    @Test
    void honorsAConfiguredRetryCount() throws Exception {
      ScriptedCall call = new ScriptedCall(rateLimitedNow());

      HttpResponse response =
          new DefaultRetryManager(RetryConfiguration.builder().setMaxRetryCount(5).build())
              .execute(call);

      assertEquals(429, response.getCode());
      assertEquals(6, call.callsCount());
    }

    @Test
    void aRetryCountOfZeroDisablesRetrying() throws Exception {
      ScriptedCall call = new ScriptedCall(rateLimitedNow());

      HttpResponse response =
          new DefaultRetryManager(RetryConfiguration.builder().setMaxRetryCount(0).build())
              .execute(call);

      assertEquals(429, response.getCode());
      assertEquals(1, call.callsCount());
    }

    @Test
    void doesNotRetryASuccessfulResponse() throws Exception {
      ScriptedCall call = new ScriptedCall(ok());

      assertEquals(
          200, new DefaultRetryManager(RetryConfiguration.DEFAULTS).execute(call).getCode());
      assertEquals(1, call.callsCount());
    }

    @Test
    void doesNotRetryOtherErrorStatuses() throws Exception {
      // 429 is the only status this ticket puts under retry: a 5xx must reach the caller untouched
      for (int status : new int[] {400, 401, 403, 404, 500, 502, 503}) {
        ScriptedCall call =
            new ScriptedCall(new HttpResponse(status, "error", Collections.emptyMap(), null));

        HttpResponse response = new DefaultRetryManager(RetryConfiguration.DEFAULTS).execute(call);

        assertEquals(status, response.getCode());
        assertEquals(1, call.callsCount());
      }
    }

    @Test
    void aNullResponseIsHandedBackUntouched() throws Exception {
      AtomicInteger callsCount = new AtomicInteger();

      HttpResponse response =
          new DefaultRetryManager(RetryConfiguration.DEFAULTS)
              .execute(
                  () -> {
                    callsCount.incrementAndGet();
                    return null;
                  });

      assertNull(response);
      assertEquals(1, callsCount.get());
    }

    @Test
    void propagatesAFailureWithoutRetrying() {
      AtomicInteger callsCount = new AtomicInteger();

      assertThrows(
          ApiException.class,
          () ->
              new DefaultRetryManager(RetryConfiguration.DEFAULTS)
                  .execute(
                      () -> {
                        callsCount.incrementAndGet();
                        throw new ApiException("connection reset");
                      }));

      assertEquals(
          1, callsCount.get(), "a transport failure is final, only a 429 response is retried");
    }

    @Test
    void stopsWhenThePolicyDeclinesToProvideADelay() throws Exception {
      // RETRY_AFTER with no header: nothing to wait on, so the response goes straight back
      ScriptedCall call = new ScriptedCall(rateLimited());

      HttpResponse response = manager(RetryPolicy.RETRY_AFTER).execute(call);

      assertEquals(429, response.getCode());
      assertEquals(1, call.callsCount());
    }
  }

  /**
   * One call can reach the manager twice — OAuthManager wraps the token exchange, and the transport
   * performing it wraps the exchange in turn. The budget belongs to the logical request, so it must
   * not multiply across those levels.
   */
  @Nested
  class NestedCalls {

    @Test
    void anInnerCallDefersToTheLoopThatOwnsTheBudget() throws Exception {
      DefaultRetryManager manager = new DefaultRetryManager(RetryConfiguration.DEFAULTS);
      AtomicInteger requests = new AtomicInteger();

      HttpResponse response =
          manager.execute(
              () ->
                  manager.execute(
                      () -> {
                        requests.incrementAndGet();
                        return rateLimitedNow();
                      }));

      assertEquals(429, response.getCode());
      assertEquals(
          RetryConfiguration.DEFAULT_MAX_RETRY_COUNT + 1,
          requests.get(),
          "nesting must not square the budget: 4 attempts, not 16");
    }

    @Test
    void anInnerCallDefersEvenToADifferentManager() throws Exception {
      DefaultRetryManager outer = new DefaultRetryManager(RetryConfiguration.DEFAULTS);
      RetryManager inner =
          new DefaultRetryManager(RetryConfiguration.builder().setMaxRetryCount(9).build());
      AtomicInteger requests = new AtomicInteger();

      outer.execute(
          () ->
              inner.execute(
                  () -> {
                    requests.incrementAndGet();
                    return rateLimitedNow();
                  }));

      assertEquals(
          RetryConfiguration.DEFAULT_MAX_RETRY_COUNT + 1,
          requests.get(),
          "the outermost loop owns the policy; the inner one performs the request once");
    }

    @Test
    void aRequestSeesTheLoopAsActive() throws Exception {
      new DefaultRetryManager(RetryConfiguration.DEFAULTS)
          .execute(
              () -> {
                assertTrue(isLoopActive());
                return ok();
              });

      assertFalse(isLoopActive());
    }

    @Test
    void theLoopIsClosedEvenWhenTheRequestFails() {
      assertThrows(
          ApiException.class,
          () ->
              new DefaultRetryManager(RetryConfiguration.DEFAULTS)
                  .execute(
                      () -> {
                        throw new ApiException("boom");
                      }));

      assertFalse(isLoopActive(), "a failure must not leave the loop flag set");
    }

    @Test
    void aSeparateThreadGetsItsOwnBudget() throws Exception {
      DefaultRetryManager manager = new DefaultRetryManager(RetryConfiguration.DEFAULTS);
      AtomicInteger requests = new AtomicInteger();

      manager.execute(
          () -> {
            // A concurrent caller must not be starved of retries by this thread's loop
            Thread other =
                new Thread(
                    () -> {
                      try {
                        manager.execute(
                            () -> {
                              requests.incrementAndGet();
                              return rateLimitedNow();
                            });
                      } catch (Exception e) {
                        throw new IllegalStateException(e);
                      }
                    });
            other.start();
            other.join();
            return ok();
          });

      assertEquals(RetryConfiguration.DEFAULT_MAX_RETRY_COUNT + 1, requests.get());
    }
  }

  @Nested
  class PolicyResolution {

    @Test
    void aNullConfigurationMeansTheDefaults() {
      assertEquals(
          RetryConfiguration.DEFAULTS.getRetryPolicy(),
          new DefaultRetryManager(null).getRetryConfiguration().getRetryPolicy());
    }
  }

  @Nested
  class Policies {

    @Test
    void defaultHonorsTheHeaderAndFallsBackToBackoff() {
      DefaultRetryManager manager = new DefaultRetryManager(RetryConfiguration.DEFAULTS);

      assertBetween(5_000, 5_250, manager.computeBackoffMillis(rateLimited("Retry-After", "5"), 0));
      assertBetween(0, 1_000, manager.computeBackoffMillis(rateLimited(), 0));
    }

    @Test
    void retryAfterHonorsTheHeaderAndOtherwiseGivesUp() {
      DefaultRetryManager manager = manager(RetryPolicy.RETRY_AFTER);

      assertBetween(5_000, 5_250, manager.computeBackoffMillis(rateLimited("Retry-After", "5"), 0));
      assertFalse(
          manager.computeBackoffMillis(rateLimited(), 0).isPresent(),
          "RETRY_AFTER has no fallback: without a usable header there is nothing to wait on");
    }

    @Test
    void backoffIgnoresTheHeaderEntirely() {
      // A header asking for an hour must not stretch the first backoff beyond its one-second
      // ceiling
      assertBetween(
          0,
          1_000,
          manager(RetryPolicy.BACKOFF).computeBackoffMillis(rateLimited("Retry-After", "3600"), 0));
    }

    @Test
    void noneDeclinesEveryDelay() throws Exception {
      DefaultRetryManager manager = manager(RetryPolicy.NONE);
      ScriptedCall call = new ScriptedCall(rateLimited("Retry-After", "5"), ok());

      assertEquals(429, manager.execute(call).getCode());
      assertEquals(1, call.callsCount());
      assertFalse(manager.computeBackoffMillis(rateLimited("Retry-After", "5"), 0).isPresent());
    }
  }

  @Nested
  class RetryAfterParsing {

    private final DefaultRetryManager manager =
        new DefaultRetryManager(RetryConfiguration.DEFAULTS);

    @Test
    void honorsBothFormsAllowedByTheSpec() {
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
    void fallsBackToExponentialBackoffWhenTheHeaderIsUnusable() {
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

    @Test
    void exponentialBackoffFollowsTheConfiguredGrowthFactor() {
      DefaultRetryManager doubling =
          new DefaultRetryManager(RetryConfiguration.builder().setExponentialBackoff(2).build());

      assertBetween(0, 1_000, doubling.computeBackoffMillis(rateLimited(), 0));
      assertBetween(0, 2_000, doubling.computeBackoffMillis(rateLimited(), 1));
      assertBetween(0, 4_000, doubling.computeBackoffMillis(rateLimited(), 2));
    }

    @Test
    void anExtremeRetryBudgetStillYieldsAFiniteDelay() {
      // growth^attempt overflows to infinity long before this; the delay must stay a real number
      assertBetween(0, 3_600_000, manager.computeBackoffMillis(rateLimited(), 5_000));
    }

    private OptionalLong backoff(String headerName, String headerValue, int attempt) {
      return manager.computeBackoffMillis(rateLimited(headerName, headerValue), attempt);
    }

    /** Formats "five seconds from now" in one of the two obsolete HTTP-date forms. */
    private String obsoleteDate(String form) {
      ZonedDateTime when = ZonedDateTime.ofInstant(Instant.now().plusSeconds(5), ZoneOffset.UTC);
      String pattern =
          "RFC850".equals(form) ? "EEEE, dd-MMM-yy HH:mm:ss 'GMT'" : "EEE MMM ppd HH:mm:ss yyyy";
      return DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH).format(when);
    }
  }

  private static void assertBetween(long lowInclusive, long highInclusive, OptionalLong actual) {
    assertTrue(actual.isPresent(), "expected a delay, got none");
    assertBetween(lowInclusive, highInclusive, actual.getAsLong());
  }

  private static void assertBetween(long lowInclusive, long highInclusive, long actual) {
    assertTrue(
        actual >= lowInclusive && actual <= highInclusive,
        "expected a value in [" + lowInclusive + ", " + highInclusive + "], got: " + actual);
  }
}
