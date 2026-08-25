package com.sinch.sdk.models;

/**
 * Retry policy applied to rate-limited responses: which delay to use, how many times to retry, and
 * how fast the wait grows.
 *
 * @since 2.2
 */
public class RetryConfiguration {

  /** Policy applied when none is configured. */
  public static final RetryPolicy DEFAULT_RETRY_POLICY = RetryPolicy.DEFAULT;

  /** Number of retries performed when none is configured. */
  public static final int DEFAULT_MAX_RETRY_COUNT = 3;

  /** Exponential backoff growth factor used when none is configured. */
  public static final int DEFAULT_EXPONENTIAL_BACKOFF = 4;

  /**
   * Configuration holding the default of every field: {@link #DEFAULT_RETRY_POLICY}, {@link
   * #DEFAULT_MAX_RETRY_COUNT} and {@link #DEFAULT_EXPONENTIAL_BACKOFF}.
   *
   * <p>Built through the builder rather than the constructor, so the defaults are subject to the
   * same validation as any value a caller supplies.
   *
   * @since 2.2
   */
  public static final RetryConfiguration DEFAULTS =
      builder()
          .setRetryPolicy(DEFAULT_RETRY_POLICY)
          .setMaxRetryCount(DEFAULT_MAX_RETRY_COUNT)
          .setExponentialBackoff(DEFAULT_EXPONENTIAL_BACKOFF)
          .build();

  private final RetryPolicy retryPolicy;
  private final int maxRetryCount;
  private final int exponentialBackoff;

  private RetryConfiguration(RetryPolicy retryPolicy, int maxRetryCount, int exponentialBackoff) {
    this.retryPolicy = retryPolicy;
    this.maxRetryCount = maxRetryCount;
    this.exponentialBackoff = exponentialBackoff;
  }

  /**
   * Strategy used to compute the delay before a retry.
   *
   * @return Retry policy
   * @since 2.2
   */
  public RetryPolicy getRetryPolicy() {
    return retryPolicy;
  }

  /**
   * Maximum number of retries performed on top of the initial attempt. Zero disables retries.
   *
   * @return Maximum retry count
   * @since 2.2
   */
  public int getMaxRetryCount() {
    return maxRetryCount;
  }

  /**
   * Growth factor of the exponential backoff, unused when the delay comes from a {@code
   * Retry-After} header.
   *
   * @return Exponential backoff growth factor
   * @since 2.2
   */
  public int getExponentialBackoff() {
    return exponentialBackoff;
  }

  @Override
  public String toString() {
    return "RetryConfiguration{"
        + "retryPolicy="
        + retryPolicy
        + ", maxRetryCount="
        + maxRetryCount
        + ", exponentialBackoff="
        + exponentialBackoff
        + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 2.2
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder pre-populated from an existing instance
   *
   * @param configuration Source configuration to fill initial builder state
   * @return New Builder instance
   * @since 2.2
   */
  public static Builder builder(RetryConfiguration configuration) {
    return new Builder(configuration);
  }

  /**
   * Dedicated Builder
   *
   * @since 2.2
   */
  public static class Builder {

    private RetryPolicy retryPolicy;
    private Integer maxRetryCount;
    private Integer exponentialBackoff;

    protected Builder() {}

    protected Builder(RetryConfiguration configuration) {
      if (null == configuration) {
        return;
      }
      this.retryPolicy = configuration.retryPolicy;
      this.maxRetryCount = configuration.maxRetryCount;
      this.exponentialBackoff = configuration.exponentialBackoff;
    }

    /**
     * Set the strategy used to compute the delay before a retry
     *
     * @param retryPolicy Retry policy, or {@code null} to keep the default
     * @return Current builder
     * @see RetryConfiguration#getRetryPolicy() getter
     * @since 2.2
     */
    public Builder setRetryPolicy(RetryPolicy retryPolicy) {
      this.retryPolicy = retryPolicy;
      return this;
    }

    /**
     * Set the maximum number of retries performed on top of the initial attempt
     *
     * @param maxRetryCount Maximum retry count, zero or greater
     * @return Current builder
     * @see RetryConfiguration#getMaxRetryCount() getter
     * @since 2.2
     */
    public Builder setMaxRetryCount(int maxRetryCount) {
      this.maxRetryCount = maxRetryCount;
      return this;
    }

    /**
     * Set the growth factor of the exponential backoff
     *
     * @param exponentialBackoff Growth factor, one or greater
     * @return Current builder
     * @see RetryConfiguration#getExponentialBackoff() getter
     * @since 2.2
     */
    public Builder setExponentialBackoff(int exponentialBackoff) {
      this.exponentialBackoff = exponentialBackoff;
      return this;
    }

    /**
     * Build a {@link RetryConfiguration} instance from builder current state
     *
     * @return RetryConfiguration instance built from current builder state
     * @since 2.2
     */
    public RetryConfiguration build() {
      if (null != maxRetryCount && maxRetryCount < 0) {
        throw new IllegalArgumentException(
            "RetryConfiguration: maxRetryCount must be zero or greater, got: " + maxRetryCount);
      }
      if (null != exponentialBackoff && exponentialBackoff < 1) {
        throw new IllegalArgumentException(
            "RetryConfiguration: exponentialBackoff must be one or greater, got: "
                + exponentialBackoff);
      }
      return new RetryConfiguration(
          null != retryPolicy ? retryPolicy : DEFAULT_RETRY_POLICY,
          null != maxRetryCount ? maxRetryCount : DEFAULT_MAX_RETRY_COUNT,
          null != exponentialBackoff ? exponentialBackoff : DEFAULT_EXPONENTIAL_BACKOFF);
    }
  }
}
