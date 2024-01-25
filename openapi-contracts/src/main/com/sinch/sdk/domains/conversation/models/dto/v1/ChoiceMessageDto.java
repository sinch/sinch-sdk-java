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

/** Message containing choices/actions. */
@JsonPropertyOrder({ChoiceMessageDto.JSON_PROPERTY_CHOICE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceMessageDto {
  public static final String JSON_PROPERTY_CHOICE_MESSAGE = "choice_message";
  private ChoiceMessageChoiceMessageDto choiceMessage;
  private boolean choiceMessageDefined = false;

  public ChoiceMessageDto() {}

  public ChoiceMessageDto choiceMessage(ChoiceMessageChoiceMessageDto choiceMessage) {
    this.choiceMessage = choiceMessage;
    this.choiceMessageDefined = true;
    return this;
  }

  /**
   * Get choiceMessage
   *
   * @return choiceMessage
   */
  @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ChoiceMessageChoiceMessageDto getChoiceMessage() {
    return choiceMessage;
  }

  @JsonIgnore
  public boolean getChoiceMessageDefined() {
    return choiceMessageDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChoiceMessage(ChoiceMessageChoiceMessageDto choiceMessage) {
    this.choiceMessage = choiceMessage;
    this.choiceMessageDefined = true;
  }

  /** Return true if this ChoiceMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceMessageDto choiceMessage = (ChoiceMessageDto) o;
    return Objects.equals(this.choiceMessage, choiceMessage.choiceMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choiceMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceMessageDto {\n");
    sb.append("    choiceMessage: ").append(toIndentedString(choiceMessage)).append("\n");
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
