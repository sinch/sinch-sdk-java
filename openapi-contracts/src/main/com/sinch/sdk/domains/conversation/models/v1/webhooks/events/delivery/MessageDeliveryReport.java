/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.Reason;

/** MessageDeliveryReport */
@JsonDeserialize(builder = MessageDeliveryReportImpl.Builder.class)
public interface MessageDeliveryReport {

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
   * Get status
   *
   * @return status
   */
  DeliveryStatus getStatus();

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
   * Get reason
   *
   * @return reason
   */
  Reason getReason();

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
    return new MessageDeliveryReportImpl.Builder();
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
     * @param status see getter
     * @return Current builder
     * @see #getStatus
     */
    Builder setStatus(DeliveryStatus status);

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
     * @param reason see getter
     * @return Current builder
     * @see #getReason
     */
    Builder setReason(Reason reason);

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
    MessageDeliveryReport build();
  }
}
