/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.text;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** A message containing only text. */
@JsonDeserialize(builder = TextMessageImpl.Builder.class)
public interface TextMessage
    extends com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride,
        com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessageBody,
        com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageType {

  /**
   * The text to be sent.
   *
   * @return text
   */
  String getText();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new TextMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param text see getter
     * @return Current builder
     * @see #getText
     */
    Builder setText(String text);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    TextMessage build();
  }
}