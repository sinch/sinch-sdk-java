package com.sinch.sdk.domains.voice.models.v2.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Event destination configuration */
@JsonDeserialize(builder = EventDestinationConfigurationImpl.Builder.class)
public interface EventDestinationConfiguration {

  /**
   * Event destination URL
   *
   * <p>Field is required
   *
   * @return url
   */
  String getUrl();

  /**
   * Fallback event destination URL used when the primary URL fails.
   *
   * <p>A failed request is re-sent to this URL immediately. After repeated consecutive failures of
   * the primary URL, requests are sent only here until the primary URL recovers.
   *
   * <p>See <em>Timeouts and failover</em> in the <strong>Webhooks</strong> section for the
   * authoritative algorithm.
   *
   * @return fallbackUrl
   */
  String getFallbackUrl();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new EventDestinationConfigurationImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param url see getter
     * @return Current builder
     * @see #getUrl
     */
    Builder setUrl(String url);

    /**
     * see getter
     *
     * @param fallbackUrl see getter
     * @return Current builder
     * @see #getFallbackUrl
     */
    Builder setFallbackUrl(String fallbackUrl);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    EventDestinationConfiguration build();
  }
}
