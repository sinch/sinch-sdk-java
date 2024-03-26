package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ProductItem;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ContactMessageImpl.JSON_PROPERTY_CHOICE_RESPONSE_MESSAGE,
  ContactMessageImpl.JSON_PROPERTY_FALLBACK_MESSAGE,
  ContactMessageImpl.JSON_PROPERTY_LOCATION_MESSAGE,
  ContactMessageImpl.JSON_PROPERTY_MEDIA_CARD_MESSAGE,
  ContactMessageImpl.JSON_PROPERTY_MEDIA_MESSAGE,
  ContactMessageImpl.JSON_PROPERTY_REPLY_TO,
  ContactMessageImpl.JSON_PROPERTY_TEXT_MESSAGE,
  ContactMessageImpl.JSON_PROPERTY_PRODUCTS,
  ContactMessageImpl.JSON_PROPERTY_TITLE,
  ContactMessageImpl.JSON_PROPERTY_CATALOG_ID,
  ContactMessageImpl.JSON_PROPERTY_MESSAGE_TYPE,
  ContactMessageImpl.JSON_PROPERTY_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ContactMessageImpl implements ContactMessage {
  private static final long serialVersionUID = 1L;

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

  public static final String JSON_PROPERTY_REPLY_TO = "reply_to";

  private OptionalValue<ReplyToMessage> replyTo;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessage> textMessage;

  public static final String JSON_PROPERTY_PRODUCTS = "products";

  private OptionalValue<List<ProductItem>> products;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_CATALOG_ID = "catalog_id";

  private OptionalValue<String> catalogId;

  public static final String JSON_PROPERTY_MESSAGE_TYPE = "message_type";

  private OptionalValue<MessageTypeEnum> messageType;

  public static final String JSON_PROPERTY_MESSAGE = "message";

  private OptionalValue<ChannelSpecificContactMessageMessage> message;

  public ContactMessageImpl() {}

  protected ContactMessageImpl(
      OptionalValue<ChoiceResponseMessage> choiceResponseMessage,
      OptionalValue<FallbackMessage> fallbackMessage,
      OptionalValue<LocationMessage> locationMessage,
      OptionalValue<MediaCardMessage> mediaCardMessage,
      OptionalValue<MediaMessage> mediaMessage,
      OptionalValue<ReplyToMessage> replyTo,
      OptionalValue<TextMessage> textMessage,
      OptionalValue<List<ProductItem>> products,
      OptionalValue<String> title,
      OptionalValue<String> catalogId,
      OptionalValue<MessageTypeEnum> messageType,
      OptionalValue<ChannelSpecificContactMessageMessage> message) {
    this.choiceResponseMessage = choiceResponseMessage;
    this.fallbackMessage = fallbackMessage;
    this.locationMessage = locationMessage;
    this.mediaCardMessage = mediaCardMessage;
    this.mediaMessage = mediaMessage;
    this.replyTo = replyTo;
    this.textMessage = textMessage;
    this.products = products;
    this.title = title;
    this.catalogId = catalogId;
    this.messageType = messageType;
    this.message = message;
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
  public ReplyToMessage getReplyTo() {
    return replyTo.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REPLY_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ReplyToMessage> replyTo() {
    return replyTo;
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
  public List<ProductItem> getProducts() {
    return products.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRODUCTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<ProductItem>> products() {
    return products;
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
  public String getCatalogId() {
    return catalogId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CATALOG_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> catalogId() {
    return catalogId;
  }

  @JsonIgnore
  public MessageTypeEnum getMessageType() {
    return messageType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<MessageTypeEnum> messageType() {
    return messageType;
  }

  @JsonIgnore
  public ChannelSpecificContactMessageMessage getMessage() {
    return message.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<ChannelSpecificContactMessageMessage> message() {
    return message;
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
    ContactMessageImpl contactMessage = (ContactMessageImpl) o;
    return Objects.equals(this.choiceResponseMessage, contactMessage.choiceResponseMessage)
        && Objects.equals(this.fallbackMessage, contactMessage.fallbackMessage)
        && Objects.equals(this.locationMessage, contactMessage.locationMessage)
        && Objects.equals(this.mediaCardMessage, contactMessage.mediaCardMessage)
        && Objects.equals(this.mediaMessage, contactMessage.mediaMessage)
        && Objects.equals(this.replyTo, contactMessage.replyTo)
        && Objects.equals(this.textMessage, contactMessage.textMessage)
        && Objects.equals(this.products, contactMessage.products)
        && Objects.equals(this.title, contactMessage.title)
        && Objects.equals(this.catalogId, contactMessage.catalogId)
        && Objects.equals(this.messageType, contactMessage.messageType)
        && Objects.equals(this.message, contactMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        choiceResponseMessage,
        fallbackMessage,
        locationMessage,
        mediaCardMessage,
        mediaMessage,
        replyTo,
        textMessage,
        products,
        title,
        catalogId,
        messageType,
        message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactMessageImpl {\n");
    sb.append("    choiceResponseMessage: ")
        .append(toIndentedString(choiceResponseMessage))
        .append("\n");
    sb.append("    fallbackMessage: ").append(toIndentedString(fallbackMessage)).append("\n");
    sb.append("    locationMessage: ").append(toIndentedString(locationMessage)).append("\n");
    sb.append("    mediaCardMessage: ").append(toIndentedString(mediaCardMessage)).append("\n");
    sb.append("    mediaMessage: ").append(toIndentedString(mediaMessage)).append("\n");
    sb.append("    replyTo: ").append(toIndentedString(replyTo)).append("\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
    sb.append("    messageType: ").append(toIndentedString(messageType)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
  static class Builder implements ContactMessage.Builder {
    OptionalValue<ChoiceResponseMessage> choiceResponseMessage = OptionalValue.empty();
    OptionalValue<FallbackMessage> fallbackMessage = OptionalValue.empty();
    OptionalValue<LocationMessage> locationMessage = OptionalValue.empty();
    OptionalValue<MediaCardMessage> mediaCardMessage = OptionalValue.empty();
    OptionalValue<MediaMessage> mediaMessage = OptionalValue.empty();
    OptionalValue<ReplyToMessage> replyTo = OptionalValue.empty();
    OptionalValue<TextMessage> textMessage = OptionalValue.empty();
    OptionalValue<List<ProductItem>> products = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<String> catalogId = OptionalValue.empty();
    OptionalValue<MessageTypeEnum> messageType = OptionalValue.empty();
    OptionalValue<ChannelSpecificContactMessageMessage> message = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_REPLY_TO)
    public Builder setReplyTo(ReplyToMessage replyTo) {
      this.replyTo = OptionalValue.of(replyTo);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PRODUCTS)
    public Builder setProducts(List<ProductItem> products) {
      this.products = OptionalValue.of(products);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CATALOG_ID)
    public Builder setCatalogId(String catalogId) {
      this.catalogId = OptionalValue.of(catalogId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_TYPE)
    public Builder setMessageType(MessageTypeEnum messageType) {
      this.messageType = OptionalValue.of(messageType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    public Builder setMessage(ChannelSpecificContactMessageMessage message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    public ContactMessage build() {
      return new ContactMessageImpl(
          choiceResponseMessage,
          fallbackMessage,
          locationMessage,
          mediaCardMessage,
          mediaMessage,
          replyTo,
          textMessage,
          products,
          title,
          catalogId,
          messageType,
          message);
    }
  }
}
