/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.unsupported;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;

/** UnsupportedCallbackEventCallback */
@JsonDeserialize(builder = UnsupportedCallbackEventCallbackImpl.Builder.class)
public interface UnsupportedCallbackEventCallback {

  /**
   * Get channel
   *
   * @return channel
   */
  ConversationChannel getChannel();

  /**
   * Normally a JSON payload as sent by the channel.
   *
   * @return payload
   */
  String getPayload();

  /**
   * Get processingMode
   *
   * @return processingMode
   */
  ProcessingMode getProcessingMode();

  /**
   * The message ID.
   *
   * @return id
   */
  String getId();

  /**
   * The ID of the contact. This field is blank if not supported.
   *
   * @return contactId
   */
  String getContactId();

  /**
   * The ID of the conversation this message is part of. This field is blank if not supported.
   *
   * @return conversationId
   */
  String getConversationId();

  /**
   * Get channelIdentity
   *
   * @return channelIdentity
   */
  ChannelIdentity getChannelIdentity();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new UnsupportedCallbackEventCallbackImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param payload see getter
     * @return Current builder
     * @see #getPayload
     */
    Builder setPayload(String payload);

    /**
     * see getter
     *
     * @param processingMode see getter
     * @return Current builder
     * @see #getProcessingMode
     */
    Builder setProcessingMode(ProcessingMode processingMode);

    /**
     * see getter
     *
     * @param id see getter
     * @return Current builder
     * @see #getId
     */
    Builder setId(String id);

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
     * @param conversationId see getter
     * @return Current builder
     * @see #getConversationId
     */
    Builder setConversationId(String conversationId);

    /**
     * see getter
     *
     * @param channelIdentity see getter
     * @return Current builder
     * @see #getChannelIdentity
     */
    Builder setChannelIdentity(ChannelIdentity channelIdentity);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    UnsupportedCallbackEventCallback build();
  }
}
