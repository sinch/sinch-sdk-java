/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.conversation.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;

/** ConversationRecentMessage */
@JsonDeserialize(builder = ConversationRecentMessageImpl.Builder.class)
public interface ConversationRecentMessage {

  /**
   * Get conversation
   *
   * @return conversation
   */
  Conversation getConversation();

  /**
   * Get lastMessage
   *
   * @return lastMessage
   */
  ConversationMessage getLastMessage();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ConversationRecentMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param conversation see getter
     * @return Current builder
     * @see #getConversation
     */
    Builder setConversation(Conversation conversation);

    /**
     * see getter
     *
     * @param lastMessage see getter
     * @return Current builder
     * @see #getLastMessage
     */
    Builder setLastMessage(ConversationMessage lastMessage);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ConversationRecentMessage build();
  }
}
