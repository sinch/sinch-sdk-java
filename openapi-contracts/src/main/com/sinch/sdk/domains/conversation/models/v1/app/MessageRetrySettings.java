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

package com.sinch.sdk.domains.conversation.models.v1.app;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** This object contains settings related to message retry mechanism. */
@JsonDeserialize(builder = MessageRetrySettingsImpl.Builder.class)
public interface MessageRetrySettings {

  /**
   * The maximum duration, in seconds, during which the system will retry sending a message in the
   * event of a temporary processing failure. Time is counted after the first message processing
   * failure. At least one retry is guaranteed. Subsequent retry instances are randomized with
   * exponential backoff. If the next retry timestamp exceeds the configured time, one final retry
   * will be performed on the cut-off time. The valid values for this field are [30 - 3600].
   *
   * @return retryDuration
   */
  Integer getRetryDuration();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MessageRetrySettingsImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param retryDuration see getter
     * @return Current builder
     * @see #getRetryDuration
     */
    Builder setRetryDuration(Integer retryDuration);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MessageRetrySettings build();
  }
}