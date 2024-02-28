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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** ChoiceMessageChoiceMessageDto */
@JsonPropertyOrder({
  ChoiceMessageChoiceMessageDto.JSON_PROPERTY_CHOICES,
  ChoiceMessageChoiceMessageDto.JSON_PROPERTY_TEXT_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ChoiceMessageChoiceMessageDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_CHOICES = "choices";
  private List<ChoiceDto> choices;
  private boolean choicesDefined = false;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";
  private TextMessageDto textMessage;
  private boolean textMessageDefined = false;

  public ChoiceMessageChoiceMessageDto() {}

  public ChoiceMessageChoiceMessageDto choices(List<ChoiceDto> choices) {
    this.choices = choices;
    this.choicesDefined = true;
    return this;
  }

  public ChoiceMessageChoiceMessageDto addChoicesItem(ChoiceDto choicesItem) {
    if (this.choices == null) {
      this.choices = new ArrayList<>();
    }
    this.choicesDefined = true;
    this.choices.add(choicesItem);
    return this;
  }

  /**
   * The number of choices is limited to 10.
   *
   * @return choices
   */
  @JsonProperty(JSON_PROPERTY_CHOICES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public List<ChoiceDto> getChoices() {
    return choices;
  }

  @JsonIgnore
  public boolean getChoicesDefined() {
    return choicesDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHOICES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setChoices(List<ChoiceDto> choices) {
    this.choices = choices;
    this.choicesDefined = true;
  }

  public ChoiceMessageChoiceMessageDto textMessage(TextMessageDto textMessage) {
    this.textMessage = textMessage;
    this.textMessageDefined = true;
    return this;
  }

  /**
   * Get textMessage
   *
   * @return textMessage
   */
  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TextMessageDto getTextMessage() {
    return textMessage;
  }

  @JsonIgnore
  public boolean getTextMessageDefined() {
    return textMessageDefined;
  }

  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTextMessage(TextMessageDto textMessage) {
    this.textMessage = textMessage;
    this.textMessageDefined = true;
  }

  /** Return true if this ChoiceMessage_choice_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoiceMessageChoiceMessageDto choiceMessageChoiceMessage = (ChoiceMessageChoiceMessageDto) o;
    return Objects.equals(this.choices, choiceMessageChoiceMessage.choices)
        && Objects.equals(this.textMessage, choiceMessageChoiceMessage.textMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choices, textMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoiceMessageChoiceMessageDto {\n");
    sb.append("    choices: ").append(toIndentedString(choices)).append("\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
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