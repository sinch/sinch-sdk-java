/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Represents a response to a choice message. */
@JsonDeserialize(builder = ChoiceResponseMessageImpl.Builder.class)
public interface ChoiceResponseMessage
    extends com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessageBody {

  /**
   * The message id containing the choice.
   *
   * @return messageId
   */
  String getMessageId();

  /**
   * The postback_data defined in the selected choice.
   *
   * @return postbackData
   */
  String getPostbackData();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ChoiceResponseMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param messageId see getter
     * @return Current builder
     * @see #getMessageId
     */
    Builder setMessageId(String messageId);

    /**
     * see getter
     *
     * @param postbackData see getter
     * @return Current builder
     * @see #getPostbackData
     */
    Builder setPostbackData(String postbackData);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ChoiceResponseMessage build();
  }
}