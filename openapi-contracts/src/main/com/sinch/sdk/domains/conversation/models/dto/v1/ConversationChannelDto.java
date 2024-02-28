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

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/** The identifier of the channel you want to include. Must be one of the enum values. */
public enum ConversationChannelDto {
  WHATSAPP("WHATSAPP"),

  RCS("RCS"),

  SMS("SMS"),

  MESSENGER("MESSENGER"),

  VIBER("VIBER"),

  VIBERBM("VIBERBM"),

  MMS("MMS"),

  INSTAGRAM("INSTAGRAM"),

  TELEGRAM("TELEGRAM"),

  KAKAOTALK("KAKAOTALK"),

  KAKAOTALKCHAT("KAKAOTALKCHAT"),

  LINE("LINE"),

  WECHAT("WECHAT"),

  APPLEBC("APPLEBC"),

  CHANNEL_UNSPECIFIED("CHANNEL_UNSPECIFIED"),

  UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

  private String value;

  ConversationChannelDto(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ConversationChannelDto fromValue(String value) {
    for (ConversationChannelDto b : ConversationChannelDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    return UNKNOWN_DEFAULT_OPEN_API;
  }
}