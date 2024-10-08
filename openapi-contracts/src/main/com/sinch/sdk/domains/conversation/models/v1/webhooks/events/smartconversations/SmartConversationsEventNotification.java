/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;

/** SmartConversationsEventNotification */
@JsonDeserialize(builder = SmartConversationsEventNotificationImpl.Builder.class)
public interface SmartConversationsEventNotification {

  /**
   * The unique ID of the contact that sent the message.
   *
   * @return contactId
   */
  String getContactId();

  /**
   * The channel-specific identifier for the contact.
   *
   * @return channelIdentity
   */
  String getChannelIdentity();

  /**
   * Get channel
   *
   * @return channel
   */
  ConversationChannel getChannel();

  /**
   * The unique ID of the corresponding message.
   *
   * @return messageId
   */
  String getMessageId();

  /**
   * The ID of the conversation the app message is part of.
   *
   * @return conversationId
   */
  String getConversationId();

  /**
   * Get analysisResults
   *
   * @return analysisResults
   */
  AnalysisResult getAnalysisResults();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new SmartConversationsEventNotificationImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param contactId see getter
     * @return Current builder
     * @see #getContactId
     */
    Builder setContactId(String contactId);

    /**
     * see getter
     *
     * @param channelIdentity see getter
     * @return Current builder
     * @see #getChannelIdentity
     */
    Builder setChannelIdentity(String channelIdentity);

    /**
     * see getter
     *
     * @param channel see getter
     * @return Current builder
     * @see #getChannel
     */
    Builder setChannel(ConversationChannel channel);

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
     * @param conversationId see getter
     * @return Current builder
     * @see #getConversationId
     */
    Builder setConversationId(String conversationId);

    /**
     * see getter
     *
     * @param analysisResults see getter
     * @return Current builder
     * @see #getAnalysisResults
     */
    Builder setAnalysisResults(AnalysisResult analysisResults);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    SmartConversationsEventNotification build();
  }
}
