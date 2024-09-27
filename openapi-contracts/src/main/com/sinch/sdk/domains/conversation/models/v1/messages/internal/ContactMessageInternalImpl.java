package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.ReplyTo;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse.ChoiceResponseMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback.FallbackMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard.MediaCardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.productresponse.ProductResponseMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.util.Objects;

@JsonPropertyOrder({
  ContactMessageInternalImpl.JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE,
  ContactMessageInternalImpl.JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE,
  ContactMessageInternalImpl.JSON_PROPERTY_FALLBACK_MESSAGE,
  ContactMessageInternalImpl.JSON_PROPERTY_LOCATION_MESSAGE,
  ContactMessageInternalImpl.JSON_PROPERTY_MEDIA_CARD_MESSAGE,
  ContactMessageInternalImpl.JSON_PROPERTY_MEDIA_MESSAGE,
  ContactMessageInternalImpl.JSON_PROPERTY_PRODUCT_RESPONSE_MESSAGE,
  ContactMessageInternalImpl.JSON_PROPERTY_TEXT_MESSAGE,
  ContactMessageInternalImpl.JSON_PROPERTY_REPLY_TO
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactMessageInternalImpl implements ContactMessageInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE = "channel_specific_message";

  private OptionalValue<ChannelSpecificContactMessage> channelSpecificMessage;

  public static final String JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE = "choice_response_message";

  private OptionalValue<ChoiceResponseMessage> choiceResponseMessage;

  public static final String JSON_PROPERTY_FALLBACK_MESSAGE = "fallback_message";

  private OptionalValue<FallbackMessage> fallbackMessage;

  public static final String JSON_PROPERTY_LOCATION_MESSAGE = "location_message";

  private OptionalValue<LocationMessage> locationMessage;

  public static final String JSON_PROPERTY_MEDIA_CARD_MESSAGE = "media_card_message";

  private OptionalValue<MediaCardMessage> mediaCardMessage;

  public static final String JSON_PROPERTY_MEDIA_MESSAGE = "media_message";

  private OptionalValue<MediaMessage> mediaMessage;

  public static final String JSON_PROPERTY_PRODUCT_RESPONSE_MESSAGE = "product_response_message";

  private OptionalValue<ProductResponseMessage> productResponseMessage;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessage> textMessage;

  public static final String JSON_PROPERTY_REPLY_TO = "reply_to";

  private OptionalValue<ReplyTo> replyTo;

  public ContactMessageInternalImpl() {}

  protected ContactMessageInternalImpl(
      OptionalValue<ChannelSpecificContactMessage> channelSpecificMessage,
      OptionalValue<ChoiceResponseMessage> choiceResponseMessage,
      OptionalValue<FallbackMessage> fallbackMessage,
      OptionalValue<LocationMessage> locationMessage,
      OptionalValue<MediaCardMessage> mediaCardMessage,
      OptionalValue<MediaMessage> mediaMessage,
      OptionalValue<ProductResponseMessage> productResponseMessage,
      OptionalValue<TextMessage> textMessage,
      OptionalValue<ReplyTo> replyTo) {
    this.channelSpecificMessage = channelSpecificMessage;
    this.choiceResponseMessage = choiceResponseMessage;
    this.fallbackMessage = fallbackMessage;
    this.locationMessage = locationMessage;
    this.mediaCardMessage = mediaCardMessage;
    this.mediaMessage = mediaMessage;
    this.productResponseMessage = productResponseMessage;
    this.textMessage = textMessage;
    this.replyTo = replyTo;
  }

  @JsonIgnore
  public ChannelSpecificContactMessage getChannelSpecificMessage() {
    return channelSpecificMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelSpecificContactMessage> channelSpecificMessage() {
    return channelSpecificMessage;
  }

  @JsonIgnore
  public ChoiceResponseMessage getChoiceResponseMessage() {
    return choiceResponseMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChoiceResponseMessage> choiceResponseMessage() {
    return choiceResponseMessage;
  }

  @JsonIgnore
  public FallbackMessage getFallbackMessage() {
    return fallbackMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FALLBACK_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FallbackMessage> fallbackMessage() {
    return fallbackMessage;
  }

  @JsonIgnore
  public LocationMessage getLocationMessage() {
    return locationMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LocationMessage> locationMessage() {
    return locationMessage;
  }

  @JsonIgnore
  public MediaCardMessage getMediaCardMessage() {
    return mediaCardMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_CARD_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaCardMessage> mediaCardMessage() {
    return mediaCardMessage;
  }

  @JsonIgnore
  public MediaMessage getMediaMessage() {
    return mediaMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaMessage> mediaMessage() {
    return mediaMessage;
  }

  @JsonIgnore
  public ProductResponseMessage getProductResponseMessage() {
    return productResponseMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRODUCT_RESPONSE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProductResponseMessage> productResponseMessage() {
    return productResponseMessage;
  }

  @JsonIgnore
  public TextMessage getTextMessage() {
    return textMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TextMessage> textMessage() {
    return textMessage;
  }

  @JsonIgnore
  public ReplyTo getReplyTo() {
    return replyTo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPLY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ReplyTo> replyTo() {
    return replyTo;
  }

  /** Return true if this ContactMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactMessageInternalImpl contactMessage = (ContactMessageInternalImpl) o;
    return Objects.equals(this.channelSpecificMessage, contactMessage.channelSpecificMessage)
        && Objects.equals(this.choiceResponseMessage, contactMessage.choiceResponseMessage)
        && Objects.equals(this.fallbackMessage, contactMessage.fallbackMessage)
        && Objects.equals(this.locationMessage, contactMessage.locationMessage)
        && Objects.equals(this.mediaCardMessage, contactMessage.mediaCardMessage)
        && Objects.equals(this.mediaMessage, contactMessage.mediaMessage)
        && Objects.equals(this.productResponseMessage, contactMessage.productResponseMessage)
        && Objects.equals(this.textMessage, contactMessage.textMessage)
        && Objects.equals(this.replyTo, contactMessage.replyTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channelSpecificMessage,
        choiceResponseMessage,
        fallbackMessage,
        locationMessage,
        mediaCardMessage,
        mediaMessage,
        productResponseMessage,
        textMessage,
        replyTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactMessageInternalImpl {\n");
    sb.append("    channelSpecificMessage: ")
        .append(toIndentedString(channelSpecificMessage))
        .append("\n");
    sb.append("    choiceResponseMessage: ")
        .append(toIndentedString(choiceResponseMessage))
        .append("\n");
    sb.append("    fallbackMessage: ").append(toIndentedString(fallbackMessage)).append("\n");
    sb.append("    locationMessage: ").append(toIndentedString(locationMessage)).append("\n");
    sb.append("    mediaCardMessage: ").append(toIndentedString(mediaCardMessage)).append("\n");
    sb.append("    mediaMessage: ").append(toIndentedString(mediaMessage)).append("\n");
    sb.append("    productResponseMessage: ")
        .append(toIndentedString(productResponseMessage))
        .append("\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements ContactMessageInternal.Builder {
    OptionalValue<ChannelSpecificContactMessage> channelSpecificMessage = OptionalValue.empty();
    OptionalValue<ChoiceResponseMessage> choiceResponseMessage = OptionalValue.empty();
    OptionalValue<FallbackMessage> fallbackMessage = OptionalValue.empty();
    OptionalValue<LocationMessage> locationMessage = OptionalValue.empty();
    OptionalValue<MediaCardMessage> mediaCardMessage = OptionalValue.empty();
    OptionalValue<MediaMessage> mediaMessage = OptionalValue.empty();
    OptionalValue<ProductResponseMessage> productResponseMessage = OptionalValue.empty();
    OptionalValue<TextMessage> textMessage = OptionalValue.empty();
    OptionalValue<ReplyTo> replyTo = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE)
    public Builder setChannelSpecificMessage(ChannelSpecificContactMessage channelSpecificMessage) {
      this.channelSpecificMessage = OptionalValue.of(channelSpecificMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE)
    public Builder setChoiceResponseMessage(ChoiceResponseMessage choiceResponseMessage) {
      this.choiceResponseMessage = OptionalValue.of(choiceResponseMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FALLBACK_MESSAGE)
    public Builder setFallbackMessage(FallbackMessage fallbackMessage) {
      this.fallbackMessage = OptionalValue.of(fallbackMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
    public Builder setLocationMessage(LocationMessage locationMessage) {
      this.locationMessage = OptionalValue.of(locationMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MEDIA_CARD_MESSAGE)
    public Builder setMediaCardMessage(MediaCardMessage mediaCardMessage) {
      this.mediaCardMessage = OptionalValue.of(mediaCardMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
    public Builder setMediaMessage(MediaMessage mediaMessage) {
      this.mediaMessage = OptionalValue.of(mediaMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PRODUCT_RESPONSE_MESSAGE)
    public Builder setProductResponseMessage(ProductResponseMessage productResponseMessage) {
      this.productResponseMessage = OptionalValue.of(productResponseMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REPLY_TO)
    public Builder setReplyTo(ReplyTo replyTo) {
      this.replyTo = OptionalValue.of(replyTo);
      return this;
    }

    public ContactMessageInternal build() {
      return new ContactMessageInternalImpl(
          channelSpecificMessage,
          choiceResponseMessage,
          fallbackMessage,
          locationMessage,
          mediaCardMessage,
          mediaMessage,
          productResponseMessage,
          textMessage,
          replyTo);
    }
  }
}
