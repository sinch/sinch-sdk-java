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

/** Represents a response to a choice message. */
@JsonPropertyOrder({ChoiceResponseMessageDto.JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceResponseMessageDto {
  public static final String JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE = "choice_response_message";
  private ChoiceResponseMessageChoiceResponseMessageDto choiceResponseMessage;
  private boolean choiceResponseMessageDefined = false;

  public ChoiceResponseMessageDto() {}

  public ChoiceResponseMessageDto choiceResponseMessage(
      ChoiceResponseMessageChoiceResponseMessageDto choiceResponseMessage) {
    this.choiceResponseMessage = choiceResponseMessage;
    this.choiceResponseMessageDefined = true;
    return this;
  }

  /**
   * Get choiceResponseMessage
   *
   * @return choiceResponseMessage
   */
  @JsonProperty(JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ChoiceResponseMessageChoiceResponseMessageDto getChoiceResponseMessage() {
    return choiceResponseMessage;
  }

  @JsonIgnore
  public boolean getChoiceResponseMessageDefined() {
    return choiceResponseMessageDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChoiceResponseMessage(
      ChoiceResponseMessageChoiceResponseMessageDto choiceResponseMessage) {
    this.choiceResponseMessage = choiceResponseMessage;
    this.choiceResponseMessageDefined = true;
  }

  /** Return true if this ChoiceResponseMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceResponseMessageDto choiceResponseMessage = (ChoiceResponseMessageDto) o;
    return Objects.equals(this.choiceResponseMessage, choiceResponseMessage.choiceResponseMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choiceResponseMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceResponseMessageDto {\n");
    sb.append("    choiceResponseMessage: ")
        .append(toIndentedString(choiceResponseMessage))
        .append("\n");
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
