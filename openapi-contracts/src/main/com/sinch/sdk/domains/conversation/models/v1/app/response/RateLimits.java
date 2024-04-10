/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.app.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** declaration */
@JsonDeserialize(builder = RateLimitsImpl.Builder.class)
public interface RateLimits {

  /**
   * The number of inbound messages/events we process per second, from underlying channels to the
   * app. The default rate limit is 25.
   *
   * @return inbound
   */
  Long getInbound();

  /**
   * The number of messages/events we process per second, from the app to the underlying channels.
   * Note that underlying channels may have other rate limits. The default rate limit is 25.
   *
   * @return outbound
   */
  Long getOutbound();

  /**
   * The rate limit of callbacks sent to the webhooks registered for the app. Note that if you have
   * multiple webhooks with shared triggers, multiple callbacks will be sent out for each triggering
   * event. The default rate limit is 25.
   *
   * @return webhooks
   */
  Long getWebhooks();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new RateLimitsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param inbound see getter
     * @return Current builder
     * @see #getInbound
     */
    Builder setInbound(Long inbound);

    /**
     * see getter
     *
     * @param outbound see getter
     * @return Current builder
     * @see #getOutbound
     */
    Builder setOutbound(Long outbound);

    /**
     * see getter
     *
     * @param webhooks see getter
     * @return Current builder
     * @see #getWebhooks
     */
    Builder setWebhooks(Long webhooks);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    RateLimits build();
  }
}