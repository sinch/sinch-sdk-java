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

package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import java.time.Instant;

public interface ConversationMessage {

  ConversationMessageBody getBody();

  /**
   * The time Conversation API processed the message.
   *
   * @return acceptTime
   */
  Instant getAcceptTime();

  /**
   * Get channelIdentity
   *
   * @return channelIdentity
   */
  ChannelIdentity getChannelIdentity();

  /**
   * The ID of the contact.
   *
   * @return contactId
   */
  String getContactId();

  /**
   * The ID of the conversation.
   *
   * @return conversationId
   */
  String getConversationId();

  /**
   * Get direction
   *
   * @return direction
   */
  ConversationDirection getDirection();

  /**
   * The ID of the message.
   *
   * @return id
   */
  String getId();

  /**
   * Optional. Metadata associated with the contact. Up to 1024 characters long.
   *
   * @return metadata
   */
  String getMetadata();

  /**
   * Flag for whether this message was injected.
   *
   * @return injected
   */
  Boolean getInjected();

  /**
   * For Contact Messages the sender ID is the contact sent the message to. For App Messages the
   * sender that was used to send the message, if applicable.
   *
   * @return senderId
   */
  String getSenderId();

  /**
   * Get processingMode
   *
   * @return processingMode
   */
  ProcessingMode getProcessingMode();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ConversationMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param content see getter
     * @return Current builder
     * @see #getBody
     */
    Builder setContent(ConversationMessageBody content);

    /**
     * see getter
     *
     * @param acceptTime see getter
     * @return Current builder
     * @see #getAcceptTime
     */
    Builder setAcceptTime(Instant acceptTime);

    /**
     * see getter
     *
     * @param channelIdentity see getter
     * @return Current builder
     * @see #getChannelIdentity
     */
    Builder setChannelIdentity(ChannelIdentity channelIdentity);

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
     * @param direction see getter
     * @return Current builder
     * @see #getDirection
     */
    Builder setDirection(ConversationDirection direction);

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
     * @param metadata see getter
     * @return Current builder
     * @see #getMetadata
     */
    Builder setMetadata(String metadata);

    /**
     * see getter
     *
     * @param injected see getter
     * @return Current builder
     * @see #getInjected
     */
    Builder setInjected(Boolean injected);

    /**
     * see getter
     *
     * @param senderId see getter
     * @return Current builder
     * @see #getSenderId
     */
    Builder setSenderId(String senderId);

    /**
     * see getter
     *
     * @param processingMode see getter
     * @return Current builder
     * @see #getProcessingMode
     */
    Builder setProcessingMode(ProcessingMode processingMode);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ConversationMessage build();
  }
}
