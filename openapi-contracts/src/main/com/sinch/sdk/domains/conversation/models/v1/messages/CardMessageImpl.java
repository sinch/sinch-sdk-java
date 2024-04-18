package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  CardMessageImpl.JSON_PROPERTY_CHOICES,
  CardMessageImpl.JSON_PROPERTY_DESCRIPTION,
  CardMessageImpl.JSON_PROPERTY_HEIGHT,
  CardMessageImpl.JSON_PROPERTY_MEDIA_MESSAGE,
  CardMessageImpl.JSON_PROPERTY_TITLE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CardMessageImpl
    implements CardMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICES = "choices";

  private OptionalValue<List<Choice<?>>> choices;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_HEIGHT = "height";

  private OptionalValue<CardHeight> height;

  public static final String JSON_PROPERTY_MEDIA_MESSAGE = "media_message";

  private OptionalValue<CardMessageMediaMessage> mediaMessage;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public CardMessageImpl() {}

  protected CardMessageImpl(
      OptionalValue<List<Choice<?>>> choices,
      OptionalValue<String> description,
      OptionalValue<CardHeight> height,
      OptionalValue<CardMessageMediaMessage> mediaMessage,
      OptionalValue<String> title) {
    this.choices = choices;
    this.description = description;
    this.height = height;
    this.mediaMessage = mediaMessage;
    this.title = title;
  }

  @JsonIgnore
  public List<Choice<?>> getChoices() {
    return choices.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<Choice<?>>> choices() {
    return choices;
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> description() {
    return description;
  }

  @JsonIgnore
  public CardHeight getHeight() {
    return height.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CardHeight> height() {
    return height;
  }

  @JsonIgnore
  public CardMessageMediaMessage getMediaMessage() {
    return mediaMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CardMessageMediaMessage> mediaMessage() {
    return mediaMessage;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> title() {
    return title;
  }

  /** Return true if this CardMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CardMessageImpl cardMessage = (CardMessageImpl) o;
    return Objects.equals(this.choices, cardMessage.choices)
        && Objects.equals(this.description, cardMessage.description)
        && Objects.equals(this.height, cardMessage.height)
        && Objects.equals(this.mediaMessage, cardMessage.mediaMessage)
        && Objects.equals(this.title, cardMessage.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choices, description, height, mediaMessage, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardMessageImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements CardMessage.Builder {
    OptionalValue<List<Choice<?>>> choices = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<CardHeight> height = OptionalValue.empty();
    OptionalValue<CardMessageMediaMessage> mediaMessage = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHOICES)
    public Builder setChoices(List<Choice<?>> choices) {
      this.choices = OptionalValue.of(choices);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_HEIGHT)
    public Builder setHeight(CardHeight height) {
      this.height = OptionalValue.of(height);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
    public Builder setMediaMessage(CardMessageMediaMessage mediaMessage) {
      this.mediaMessage = OptionalValue.of(mediaMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    public CardMessage build() {
      return new CardMessageImpl(choices, description, height, mediaMessage, title);
    }
  }
}
