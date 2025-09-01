package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardHeight;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.MessageProperties;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  CardMessageInternalImpl.JSON_PROPERTY_CHOICES,
  CardMessageInternalImpl.JSON_PROPERTY_DESCRIPTION,
  CardMessageInternalImpl.JSON_PROPERTY_HEIGHT,
  CardMessageInternalImpl.JSON_PROPERTY_TITLE,
  CardMessageInternalImpl.JSON_PROPERTY_MEDIA_MESSAGE,
  CardMessageInternalImpl.JSON_PROPERTY_MESSAGE_PROPERTIES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CardMessageInternalImpl implements CardMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICES = "choices";

  private OptionalValue<List<Choice<?>>> choices;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public static final String JSON_PROPERTY_HEIGHT = "height";

  private OptionalValue<CardHeight> height;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_MEDIA_MESSAGE = "media_message";

  private OptionalValue<MediaMessage> media;

  public static final String JSON_PROPERTY_MESSAGE_PROPERTIES = "message_properties";

  private OptionalValue<MessageProperties> messageProperties;

  public CardMessageInternalImpl() {}

  protected CardMessageInternalImpl(
      OptionalValue<List<Choice<?>>> choices,
      OptionalValue<String> description,
      OptionalValue<CardHeight> height,
      OptionalValue<String> title,
      OptionalValue<MediaMessage> media,
      OptionalValue<MessageProperties> messageProperties) {
    this.choices = choices;
    this.description = description;
    this.height = height;
    this.title = title;
    this.media = media;
    this.messageProperties = messageProperties;
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
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> title() {
    return title;
  }

  @JsonIgnore
  public MediaMessage getMedia() {
    return media.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaMessage> media() {
    return media;
  }

  @JsonIgnore
  public MessageProperties getMessageProperties() {
    return messageProperties.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_PROPERTIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MessageProperties> messageProperties() {
    return messageProperties;
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
    CardMessageInternalImpl cardMessage = (CardMessageInternalImpl) o;
    return Objects.equals(this.choices, cardMessage.choices)
        && Objects.equals(this.description, cardMessage.description)
        && Objects.equals(this.height, cardMessage.height)
        && Objects.equals(this.title, cardMessage.title)
        && Objects.equals(this.media, cardMessage.media)
        && Objects.equals(this.messageProperties, cardMessage.messageProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choices, description, height, title, media, messageProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardMessageInternalImpl {\n");
    sb.append("    choices: ").append(toIndentedString(choices)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    media: ").append(toIndentedString(media)).append("\n");
    sb.append("    messageProperties: ").append(toIndentedString(messageProperties)).append("\n");
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
  static class Builder implements CardMessageInternal.Builder {
    OptionalValue<List<Choice<?>>> choices = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();
    OptionalValue<CardHeight> height = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<MediaMessage> media = OptionalValue.empty();
    OptionalValue<MessageProperties> messageProperties = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
    public Builder setMedia(MediaMessage media) {
      this.media = OptionalValue.of(media);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_PROPERTIES)
    public Builder setMessageProperties(MessageProperties messageProperties) {
      this.messageProperties = OptionalValue.of(messageProperties);
      return this;
    }

    public CardMessageInternal build() {
      return new CardMessageInternalImpl(
          choices, description, height, title, media, messageProperties);
    }
  }
}
