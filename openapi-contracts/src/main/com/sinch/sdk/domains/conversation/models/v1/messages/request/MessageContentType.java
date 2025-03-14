package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * This field classifies the message content for use with Sinch's <a
 * href="https://developers.sinch.com/docs/conversation/consent-management/">consent management
 * functionality</a>. Note that this field is currently only used with Sinch's consent management
 * functionality, and is not referenced elsewhere by the Conversation API.
 */
public class MessageContentType extends EnumDynamic<String, MessageContentType> {

  /**
   * The default content type, when the content is not clearly defined, can be any type of content.
   */
  public static final MessageContentType UNKNOWN = new MessageContentType("CONTENT_UNKNOWN");

  /**
   * Type that indicates that the content is related to Marketing, like marketing campaign messages.
   */
  public static final MessageContentType MARKETING = new MessageContentType("CONTENT_MARKETING");

  /** Type that indicates that the content is related to Notifications, like charges and alerts. */
  public static final MessageContentType NOTIFICATION =
      new MessageContentType("CONTENT_NOTIFICATION");

  private static final EnumSupportDynamic<String, MessageContentType> ENUM_SUPPORT =
      new EnumSupportDynamic<>(
          MessageContentType.class,
          MessageContentType::new,
          Arrays.asList(UNKNOWN, MARKETING, NOTIFICATION));

  private MessageContentType(String value) {
    super(value);
  }

  public static Stream<MessageContentType> values() {
    return ENUM_SUPPORT.values();
  }

  public static MessageContentType from(String value) {
    return ENUM_SUPPORT.from(value);
  }

  public static String valueOf(MessageContentType e) {
    return ENUM_SUPPORT.valueOf(e);
  }
}
