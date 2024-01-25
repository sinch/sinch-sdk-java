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

/**
 * If the contact message was a response to a previous App message then this field contains
 * information about that.
 */
@JsonPropertyOrder({ReplyToDto.JSON_PROPERTY_REPLY_TO})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ReplyToDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_REPLY_TO = "reply_to";
  private ReplyToReplyToDto replyTo;
  private boolean replyToDefined = false;

  public ReplyToDto() {}

  public ReplyToDto replyTo(ReplyToReplyToDto replyTo) {
    this.replyTo = replyTo;
    this.replyToDefined = true;
    return this;
  }

  /**
   * Get replyTo
   *
   * @return replyTo
   */
  @JsonProperty(JSON_PROPERTY_REPLY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ReplyToReplyToDto getReplyTo() {
    return replyTo;
  }

  @JsonIgnore
  public boolean getReplyToDefined() {
    return replyToDefined;
  }

  @JsonProperty(JSON_PROPERTY_REPLY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReplyTo(ReplyToReplyToDto replyTo) {
    this.replyTo = replyTo;
    this.replyToDefined = true;
  }

  /** Return true if this ReplyTo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReplyToDto replyTo = (ReplyToDto) o;
    return Objects.equals(this.replyTo, replyTo.replyTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(replyTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReplyToDto {\n");
    sb.append("    replyTo: ").append(toIndentedString(replyTo)).append("\n");
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
