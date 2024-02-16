package com.sinch.sdk.domains.conversation.models;

/**
 * App rate limits
 *
 * @since 1.0
 */
public interface RateLimits {

  /**
   * The number of inbound messages/events we process per second, from underlying channels to the
   * app.
   *
   * <p>The default rate limit is 25.
   *
   * @return inbound rate
   * @since 1.0
   */
  Long getInBound();

  /**
   * The number of messages/events we process per second, from the app to the underlying channels.
   * Note that underlying channels may have other rate limits.
   *
   * <p>The default rate limit is 25.
   *
   * @return outbound rate
   * @since 1.0
   */
  Long getOutBound();

  /**
   * The rate limit of callbacks sent to the webhooks registered for the app. Note that if you have
   * multiple webhooks with shared triggers, multiple callbacks will be sent out for each triggering
   * event.
   *
   * <p>The default rate limit is 25.
   *
   * @return webhooks rate
   * @since 1.0
   */
  Long getWebhooks();

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  static Builder builder() {
    return BuildersDelegation.RateLimitsBuilder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  interface Builder {

    /**
     * see getter
     *
     * @param inBound see getter
     * @return Current builder
     * @see RateLimits#getInBound()
     * @since 1.0
     */
    Builder setInBound(Long inBound);

    /**
     * see getter
     *
     * @param outBound see getter
     * @return Current builder
     * @see RateLimits#getOutBound()
     * @since 1.0
     */
    Builder setOutBound(Long outBound);

    /**
     * see getter
     *
     * @param webhooks see getter
     * @return Current builder
     * @see RateLimits#getWebhooks()
     * @since 1.0
     */
    Builder setWebhooks(Long webhooks);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    RateLimits build();
  }
}
