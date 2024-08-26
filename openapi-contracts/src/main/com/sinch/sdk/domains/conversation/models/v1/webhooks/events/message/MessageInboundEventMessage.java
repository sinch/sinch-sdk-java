/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

/** MessageInboundEventMessage */
@JsonDeserialize(builder = MessageInboundEventMessageImpl.Builder.class)
public interface MessageInboundEventMessage {

  /**
   * The message ID.
   *
   * @return id
   */
  String getId();

  /** The direction of the message, it's always TO_APP for contact messages. */
  public class DirectionEnum extends EnumDynamic<String, DirectionEnum> {
    public static final DirectionEnum TO_APP = new DirectionEnum("TO_APP");

    private static final EnumSupportDynamic<String, DirectionEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(DirectionEnum.class, DirectionEnum::new, Arrays.asList(TO_APP));

    private DirectionEnum(String value) {
      super(value);
    }

    public static Stream<DirectionEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static DirectionEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(DirectionEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The direction of the message, it's always TO_APP for contact messages.
   *
   * @return direction
   */
  DirectionEnum getDirection();

  /**
   * Get contactMessage
   *
   * @return contactMessage
   */
  ContactMessage getContactMessage();

  /**
   * Get channelIdentity
   *
   * @return channelIdentity
   */
  ChannelIdentity getChannelIdentity();

  /**
   * The ID of the conversation this message is part of. Will be empty if processing_mode is
   * DISPATCH.
   *
   * @return conversationId
   */
  String getConversationId();

  /**
   * The ID of the contact. Will be empty if processing_mode is DISPATCH.
   *
   * @return contactId
   */
  String getContactId();

  /**
   * Usually, metadata specific to the underlying channel is provided in this field. Refer to the
   * individual channels' documentation for more information (for example, SMS delivery receipts).
   * Note that, for Choice message responses, this field is populated with the value of the
   * message_metadata field of the corresponding Send message request.
   *
   * @return metadata
   */
  String getMetadata();

  /**
   * Timestamp marking when the channel callback was received by the Conversation API.
   *
   * @return acceptTime
   */
  Instant getAcceptTime();

  /**
   * The sender ID to which the contact sent the message, if applicable. For example, originator
   * msisdn/short code for SMS and MMS.
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
   * Flag for whether this message was injected.
   *
   * @return injected
   */
  Boolean getInjected();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MessageInboundEventMessageImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

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
     * @param direction see getter
     * @return Current builder
     * @see #getDirection
     */
    Builder setDirection(DirectionEnum direction);

    /**
     * see getter
     *
     * @param contactMessage see getter
     * @return Current builder
     * @see #getContactMessage
     */
    Builder setContactMessage(ContactMessage contactMessage);

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
     * @param conversationId see getter
     * @return Current builder
     * @see #getConversationId
     */
    Builder setConversationId(String conversationId);

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
     * @param metadata see getter
     * @return Current builder
     * @see #getMetadata
     */
    Builder setMetadata(String metadata);

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
     * see getter
     *
     * @param injected see getter
     * @return Current builder
     * @see #getInjected
     */
    Builder setInjected(Boolean injected);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MessageInboundEventMessage build();
  }
}
