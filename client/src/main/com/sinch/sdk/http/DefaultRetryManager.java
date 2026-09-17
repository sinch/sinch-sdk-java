package com.sinch.sdk.http;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.models.RetryConfiguration;
import com.sinch.sdk.models.RetryPolicy;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Retry policy for rate-limited (HTTP 429) responses: when to retry, how long to wait, and when to
 * stop. Only HTTP 429 is retried. Every other response — including {@code 5xx} — is handed straight
 * back, as is the final 429 once the retry budget is spent, so the caller's error handling sees the
 * response the server actually sent.
 *
 * @since 2.2
 */
public class DefaultRetryManager implements RetryManager {

  private static final Logger LOGGER = Logger.getLogger(DefaultRetryManager.class.getName());

  private static final String RETRY_AFTER_HEADER = "Retry-After";

  private static final double BACKOFF_BASE_MILLIS = 1000d;

  private static final long RETRY_AFTER_JITTER_MILLIS = 250L;

  private static final double MAX_BACKOFF_MILLIS = TimeUnit.HOURS.toMillis(1);

  static final ThreadLocal<Boolean> LOOP_ACTIVE = new ThreadLocal<>();

  private final RetryConfiguration configuration;

  /**
   * @param configuration Policy to apply, or {@code null} for {@link RetryConfiguration#DEFAULTS}
   * @since 2.2
   */
  public DefaultRetryManager(RetryConfiguration configuration) {
    this.configuration = null != configuration ? configuration : RetryConfiguration.DEFAULTS;
  }

  @Override
  public RetryConfiguration getRetryConfiguration() {
    return configuration;
  }

  @Override
  public HttpResponse execute(Callable<HttpResponse> call) throws Exception {

    if (Boolean.TRUE.equals(LOOP_ACTIVE.get())) {
      return call.call();
    }

    LOOP_ACTIVE.set(Boolean.TRUE);
    try {
      return executeWithRetries(call);
    } finally {
      LOOP_ACTIVE.remove();
    }
  }

  private HttpResponse executeWithRetries(Callable<HttpResponse> call) throws Exception {

    int maxRetryCount = configuration.getMaxRetryCount();

    for (int attempt = 0; ; attempt++) {

      HttpResponse response = call.call();

      if (null == response || response.getCode() != HttpStatus.TOO_MANY_REQUESTS) {
        return response;
      }
      if (attempt >= maxRetryCount) {
        LOGGER.fine(
            "Rate limited (HTTP 429) and the retry budget of "
                + maxRetryCount
                + " is spent, returning the response to the caller");
        return response;
      }

      OptionalLong delay = computeBackoffMillis(response, attempt);
      if (!delay.isPresent()) {
        return response;
      }

      long sleepMillis = delay.getAsLong();
      LOGGER.fine(
          "Rate limited (HTTP 429), attempt "
              + (attempt + 1)
              + "/"
              + (maxRetryCount + 1)
              + ", waiting "
              + sleepMillis
              + "ms before retrying");
      try {
        Thread.sleep(sleepMillis);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new ApiException("Interrupted while waiting to retry a rate-limited request", e);
      }
    }
  }

  /**
   * Delay to wait before the next attempt, or empty when the configured policy declines to retry
   * this response.
   */
  OptionalLong computeBackoffMillis(HttpResponse response, int attempt) {

    RetryPolicy policy = configuration.getRetryPolicy();

    if (RetryPolicy.NONE == policy) {
      return OptionalLong.empty();
    }

    if (RetryPolicy.BACKOFF != policy) {
      OptionalLong retryAfter = retryAfterMillis(response);
      if (retryAfter.isPresent()) {
        return OptionalLong.of(
            retryAfter.getAsLong()
                + ThreadLocalRandom.current().nextLong(RETRY_AFTER_JITTER_MILLIS + 1));
      }
      if (RetryPolicy.RETRY_AFTER == policy) {
        return OptionalLong.empty();
      }
    }

    double maxDelayMillis =
        Math.min(
            BACKOFF_BASE_MILLIS * Math.pow(configuration.getExponentialBackoff(), attempt),
            MAX_BACKOFF_MILLIS);
    return OptionalLong.of((long) ThreadLocalRandom.current().nextDouble(maxDelayMillis));
  }

  private static OptionalLong retryAfterMillis(HttpResponse response) {
    return retryAfterHeader(response)
        .map(DefaultRetryManager::parseRetryAfterMillis)
        .orElse(OptionalLong.empty());
  }

  private static Optional<String> retryAfterHeader(HttpResponse response) {
    return response.getHeaders().entrySet().stream()
        .filter(entry -> RETRY_AFTER_HEADER.equalsIgnoreCase(entry.getKey()))
        .map(Map.Entry::getValue)
        .filter(values -> null != values && !values.isEmpty())
        .map(values -> values.get(0))
        .findFirst();
  }

  private static OptionalLong parseRetryAfterMillis(String value) {

    String trimmed = null == value ? "" : value.trim();
    if (trimmed.isEmpty()) {
      return OptionalLong.empty();
    }

    try {
      double seconds = Double.parseDouble(trimmed);
      boolean usable = seconds >= 0 && seconds < Long.MAX_VALUE / 1000d;
      return usable ? OptionalLong.of((long) (seconds * 1000)) : OptionalLong.empty();
    } catch (NumberFormatException notDeltaSeconds) {
    }

    Instant retryAt = DateUtil.RFC7231StringToInstant(trimmed);
    if (null == retryAt) {
      return OptionalLong.empty();
    }
    try {
      return OptionalLong.of(Math.max(0, Duration.between(Instant.now(), retryAt).toMillis()));
    } catch (ArithmeticException tooFarInTheFuture) {
      return OptionalLong.empty();
    }
  }
}
