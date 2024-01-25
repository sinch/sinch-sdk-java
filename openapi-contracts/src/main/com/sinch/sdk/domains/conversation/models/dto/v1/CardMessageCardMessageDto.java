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

/** CardMessageCardMessageDto */
@JsonPropertyOrder({
  CardMessageCardMessageDto.JSON_PROPERTY_CHOICES,
  CardMessageCardMessageDto.JSON_PROPERTY_DESCRIPTION,
  CardMessageCardMessageDto.JSON_PROPERTY_HEIGHT,
  CardMessageCardMessageDto.JSON_PROPERTY_MEDIA_MESSAGE,
  CardMessageCardMessageDto.JSON_PROPERTY_TITLE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CardMessageCardMessageDto {
  public static final String JSON_PROPERTY_CHOICES = "choices";
  private List<ChoiceDto> choices;
  private boolean choicesDefined = false;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;
  private boolean descriptionDefined = false;

  public static final String JSON_PROPERTY_HEIGHT = "height";
  private CardHeightDto height;
  private boolean heightDefined = false;

  public static final String JSON_PROPERTY_MEDIA_MESSAGE = "media_message";
  private MediaCarouselMessageDto mediaMessage;
  private boolean mediaMessageDefined = false;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;
  private boolean titleDefined = false;

  public CardMessageCardMessageDto() {}

  public CardMessageCardMessageDto choices(List<ChoiceDto> choices) {
    this.choices = choices;
    this.choicesDefined = true;
    return this;
  }

  public CardMessageCardMessageDto addChoicesItem(ChoiceDto choicesItem) {
    if (this.choices == null) {
      this.choices = new ArrayList<>();
    }
    this.choicesDefined = true;
    this.choices.add(choicesItem);
    return this;
  }

  /**
   * You may include choices in your Card Message. The number of choices is limited to 10.
   *
   * @return choices
   */
  @JsonProperty(JSON_PROPERTY_CHOICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<ChoiceDto> getChoices() {
    return choices;
  }

  @JsonIgnore
  public boolean getChoicesDefined() {
    return choicesDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHOICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChoices(List<ChoiceDto> choices) {
    this.choices = choices;
    this.choicesDefined = true;
  }

  public CardMessageCardMessageDto description(String description) {
    this.description = description;
    this.descriptionDefined = true;
    return this;
  }

  /**
   * This is an optional description field that is displayed below the title on the card.
   *
   * @return description
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  @JsonIgnore
  public boolean getDescriptionDefined() {
    return descriptionDefined;
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
    this.descriptionDefined = true;
  }

  public CardMessageCardMessageDto height(CardHeightDto height) {
    this.height = height;
    this.heightDefined = true;
    return this;
  }

  /**
   * Get height
   *
   * @return height
   */
  @JsonProperty(JSON_PROPERTY_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public CardHeightDto getHeight() {
    return height;
  }

  @JsonIgnore
  public boolean getHeightDefined() {
    return heightDefined;
  }

  @JsonProperty(JSON_PROPERTY_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHeight(CardHeightDto height) {
    this.height = height;
    this.heightDefined = true;
  }

  public CardMessageCardMessageDto mediaMessage(MediaCarouselMessageDto mediaMessage) {
    this.mediaMessage = mediaMessage;
    this.mediaMessageDefined = true;
    return this;
  }

  /**
   * Get mediaMessage
   *
   * @return mediaMessage
   */
  @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MediaCarouselMessageDto getMediaMessage() {
    return mediaMessage;
  }

  @JsonIgnore
  public boolean getMediaMessageDefined() {
    return mediaMessageDefined;
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMediaMessage(MediaCarouselMessageDto mediaMessage) {
    this.mediaMessage = mediaMessage;
    this.mediaMessageDefined = true;
  }

  public CardMessageCardMessageDto title(String title) {
    this.title = title;
    this.titleDefined = true;
    return this;
  }

  /**
   * The title of the card message.
   *
   * @return title
   */
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getTitle() {
    return title;
  }

  @JsonIgnore
  public boolean getTitleDefined() {
    return titleDefined;
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitle(String title) {
    this.title = title;
    this.titleDefined = true;
  }

  /** Return true if this CardMessage_card_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardMessageCardMessageDto cardMessageCardMessage = (CardMessageCardMessageDto) o;
    return Objects.equals(this.choices, cardMessageCardMessage.choices)
        && Objects.equals(this.description, cardMessageCardMessage.description)
        && Objects.equals(this.height, cardMessageCardMessage.height)
        && Objects.equals(this.mediaMessage, cardMessageCardMessage.mediaMessage)
        && Objects.equals(this.title, cardMessageCardMessage.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choices, description, height, mediaMessage, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardMessageCardMessageDto {\n");
    sb.append("    choices: ").append(toIndentedString(choices)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    mediaMessage: ").append(toIndentedString(mediaMessage)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
