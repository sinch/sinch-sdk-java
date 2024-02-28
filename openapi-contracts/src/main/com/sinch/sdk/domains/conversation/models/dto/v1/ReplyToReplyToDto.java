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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** ReplyToReplyToDto */
@JsonPropertyOrder({ReplyToReplyToDto.JSON_PROPERTY_MESSAGE_ID})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReplyToReplyToDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";
  private String messageId;
  private boolean messageIdDefined = false;

  public ReplyToReplyToDto() {}

  public ReplyToReplyToDto messageId(String messageId) {
    this.messageId = messageId;
    this.messageIdDefined = true;
    return this;
  }

  /**
   * Required. The Id of the message that this is a response to
   *
   * @return messageId
   */
  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getMessageId() {
    return messageId;
  }

  @JsonIgnore
  public boolean getMessageIdDefined() {
    return messageIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMessageId(String messageId) {
    this.messageId = messageId;
    this.messageIdDefined = true;
  }

  /** Return true if this ReplyTo_reply_to object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReplyToReplyToDto replyToReplyTo = (ReplyToReplyToDto) o;
    return Objects.equals(this.messageId, replyToReplyTo.messageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplyToReplyToDto {\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}