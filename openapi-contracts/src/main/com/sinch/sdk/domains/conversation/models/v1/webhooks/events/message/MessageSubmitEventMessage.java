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

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;

/** MessageSubmitEventMessage */
@JsonDeserialize(builder = MessageSubmitEventMessageImpl.Builder.class)
public interface MessageSubmitEventMessage {

  /**
   * The ID of the app message.
   *
   * @return messageId
   */
  String getMessageId();

  /**
   * The ID of the conversation the app message is part of. Will be empty if processing_mode is
   * DISPATCH.
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
   * The ID of the contact. Will be empty if processing_mode is DISPATCH.
   *
   * @return contactId
   */
  String getContactId();

  /**
   * Get submittedMessage
   *
   * @return submittedMessage
   */
  ContactMessage getSubmittedMessage();

  /**
   * Metadata specified in the message_metadata field of a Send Message request, if any.
   *
   * @return metadata
   */
  String getMetadata();

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
    return new MessageSubmitEventMessageImpl.Builder();
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
     * @param submittedMessage see getter
     * @return Current builder
     * @see #getSubmittedMessage
     */
    Builder setSubmittedMessage(ContactMessage submittedMessage);

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
    MessageSubmitEventMessage build();
  }
}