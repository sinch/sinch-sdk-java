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

package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChannelSpecificContactMessageMessage;
import java.util.Arrays;
import java.util.stream.Stream;

/** A contact message containing a channel specific message (not supported by OMNI types). */
@JsonDeserialize(builder = ChannelSpecificContactMessageInternalImpl.Builder.class)
public interface ChannelSpecificContactMessageInternal {

  /** The message type. */
  public class MessageTypeEnum extends EnumDynamic<String, MessageTypeEnum> {
    public static final MessageTypeEnum NFM_REPLY = new MessageTypeEnum("nfm_reply");

    private static final EnumSupportDynamic<String, MessageTypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            MessageTypeEnum.class, MessageTypeEnum::new, Arrays.asList(NFM_REPLY));

    private MessageTypeEnum(String value) {
      super(value);
    }

    public static Stream<MessageTypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static MessageTypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(MessageTypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * The message type.
   *
   * @return messageType
   */
  MessageTypeEnum getMessageType();

  /**
   * Get message
   *
   * @return message
   */
  ChannelSpecificContactMessageMessage getMessage();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ChannelSpecificContactMessageInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param messageType see getter
     * @return Current builder
     * @see #getMessageType
     */
    Builder setMessageType(MessageTypeEnum messageType);

    /**
     * see getter
     *
     * @param message see getter
     * @return Current builder
     * @see #getMessage
     */
    Builder setMessage(ChannelSpecificContactMessageMessage message);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ChannelSpecificContactMessageInternal build();
  }
}