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

package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;

/** SendMessageResponse */
@JsonDeserialize(builder = SendMessageResponseImpl.Builder.class)
public interface SendMessageResponse {

  /**
   * Timestamp when the Conversation API accepted the message for delivery to the referenced
   * contact.
   *
   * @return acceptedTime
   */
  Instant getAcceptedTime();

  /**
   * The ID of the message.
   *
   * @return messageId
   */
  String getMessageId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SendMessageResponseImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param acceptedTime see getter
     * @return Current builder
     * @see #getAcceptedTime
     */
    Builder setAcceptedTime(Instant acceptedTime);

    /**
     * see getter
     *
     * @param messageId see getter
     * @return Current builder
     * @see #getMessageId
     */
    Builder setMessageId(String messageId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SendMessageResponse build();
  }
}
