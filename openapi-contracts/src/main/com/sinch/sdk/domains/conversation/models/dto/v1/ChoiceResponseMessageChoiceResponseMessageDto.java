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

/** ChoiceResponseMessageChoiceResponseMessageDto */
@JsonPropertyOrder({
  ChoiceResponseMessageChoiceResponseMessageDto.JSON_PROPERTY_MESSAGE_ID,
  ChoiceResponseMessageChoiceResponseMessageDto.JSON_PROPERTY_POSTBACK_DATA
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceResponseMessageChoiceResponseMessageDto {
  public static final String JSON_PROPERTY_MESSAGE_ID = "message_id";
  private String messageId;
  private boolean messageIdDefined = false;

  public static final String JSON_PROPERTY_POSTBACK_DATA = "postback_data";
  private String postbackData;
  private boolean postbackDataDefined = false;

  public ChoiceResponseMessageChoiceResponseMessageDto() {}

  public ChoiceResponseMessageChoiceResponseMessageDto messageId(String messageId) {
    this.messageId = messageId;
    this.messageIdDefined = true;
    return this;
  }

  /**
   * The message id containing the choice.
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

  public ChoiceResponseMessageChoiceResponseMessageDto postbackData(String postbackData) {
    this.postbackData = postbackData;
    this.postbackDataDefined = true;
    return this;
  }

  /**
   * The postback_data defined in the selected choice.
   *
   * @return postbackData
   */
  @JsonProperty(JSON_PROPERTY_POSTBACK_DATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getPostbackData() {
    return postbackData;
  }

  @JsonIgnore
  public boolean getPostbackDataDefined() {
    return postbackDataDefined;
  }

  @JsonProperty(JSON_PROPERTY_POSTBACK_DATA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPostbackData(String postbackData) {
    this.postbackData = postbackData;
    this.postbackDataDefined = true;
  }

  /** Return true if this ChoiceResponseMessage_choice_response_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceResponseMessageChoiceResponseMessageDto choiceResponseMessageChoiceResponseMessage =
        (ChoiceResponseMessageChoiceResponseMessageDto) o;
    return Objects.equals(this.messageId, choiceResponseMessageChoiceResponseMessage.messageId)
        && Objects.equals(
            this.postbackData, choiceResponseMessageChoiceResponseMessage.postbackData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageId, postbackData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceResponseMessageChoiceResponseMessageDto {\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    postbackData: ").append(toIndentedString(postbackData)).append("\n");
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
