package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  OmniMessageOverrideMessageImpl.JSON_PROPERTY_TEXT_MESSAGE,
  OmniMessageOverrideMessageImpl.JSON_PROPERTY_MEDIA_MESSAGE,
  OmniMessageOverrideMessageImpl.JSON_PROPERTY_TEMPLATE_REFERENCE,
  OmniMessageOverrideMessageImpl.JSON_PROPERTY_CHOICE_MESSAGE,
  OmniMessageOverrideMessageImpl.JSON_PROPERTY_CARD_MESSAGE,
  OmniMessageOverrideMessageImpl.JSON_PROPERTY_CAROUSEL_MESSAGE,
  OmniMessageOverrideMessageImpl.JSON_PROPERTY_LOCATION_MESSAGE,
  OmniMessageOverrideMessageImpl.JSON_PROPERTY_CONTACT_INFO_MESSAGE,
  OmniMessageOverrideMessageImpl.JSON_PROPERTY_LIST_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OmniMessageOverrideMessageImpl implements OmniMessageOverrideMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessage> textMessage;

  public static final String JSON_PROPERTY_MEDIA_MESSAGE = "media_message";

  private OptionalValue<MediaMessage> mediaMessage;

  public static final String JSON_PROPERTY_TEMPLATE_REFERENCE = "template_reference";

  private OptionalValue<TemplateReference> templateReference;

  public static final String JSON_PROPERTY_CHOICE_MESSAGE = "choice_message";

  private OptionalValue<ChoiceMessage> choiceMessage;

  public static final String JSON_PROPERTY_CARD_MESSAGE = "card_message";

  private OptionalValue<CardMessage> cardMessage;

  public static final String JSON_PROPERTY_CAROUSEL_MESSAGE = "carousel_message";

  private OptionalValue<CarouselMessage> carouselMessage;

  public static final String JSON_PROPERTY_LOCATION_MESSAGE = "location_message";

  private OptionalValue<LocationMessage> locationMessage;

  public static final String JSON_PROPERTY_CONTACT_INFO_MESSAGE = "contact_info_message";

  private OptionalValue<ContactInfoMessage> contactInfoMessage;

  public static final String JSON_PROPERTY_LIST_MESSAGE = "list_message";

  private OptionalValue<ListMessage> listMessage;

  public OmniMessageOverrideMessageImpl() {}

  protected OmniMessageOverrideMessageImpl(
      OptionalValue<TextMessage> textMessage,
      OptionalValue<MediaMessage> mediaMessage,
      OptionalValue<TemplateReference> templateReference,
      OptionalValue<ChoiceMessage> choiceMessage,
      OptionalValue<CardMessage> cardMessage,
      OptionalValue<CarouselMessage> carouselMessage,
      OptionalValue<LocationMessage> locationMessage,
      OptionalValue<ContactInfoMessage> contactInfoMessage,
      OptionalValue<ListMessage> listMessage) {
    this.textMessage = textMessage;
    this.mediaMessage = mediaMessage;
    this.templateReference = templateReference;
    this.choiceMessage = choiceMessage;
    this.cardMessage = cardMessage;
    this.carouselMessage = carouselMessage;
    this.locationMessage = locationMessage;
    this.contactInfoMessage = contactInfoMessage;
    this.listMessage = listMessage;
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
  public MediaMessage getMediaMessage() {
    return mediaMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaMessage> mediaMessage() {
    return mediaMessage;
  }

  @JsonIgnore
  public TemplateReference getTemplateReference() {
    return templateReference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateReference> templateReference() {
    return templateReference;
  }

  @JsonIgnore
  public ChoiceMessage getChoiceMessage() {
    return choiceMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChoiceMessage> choiceMessage() {
    return choiceMessage;
  }

  @JsonIgnore
  public CardMessage getCardMessage() {
    return cardMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CARD_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CardMessage> cardMessage() {
    return cardMessage;
  }

  @JsonIgnore
  public CarouselMessage getCarouselMessage() {
    return carouselMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAROUSEL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CarouselMessage> carouselMessage() {
    return carouselMessage;
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
  public ContactInfoMessage getContactInfoMessage() {
    return contactInfoMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_INFO_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ContactInfoMessage> contactInfoMessage() {
    return contactInfoMessage;
  }

  @JsonIgnore
  public ListMessage getListMessage() {
    return listMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ListMessage> listMessage() {
    return listMessage;
  }

  /** Return true if this OmniMessageOverride_message object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OmniMessageOverrideMessageImpl omniMessageOverrideMessage = (OmniMessageOverrideMessageImpl) o;
    return Objects.equals(this.textMessage, omniMessageOverrideMessage.textMessage)
        && Objects.equals(this.mediaMessage, omniMessageOverrideMessage.mediaMessage)
        && Objects.equals(this.templateReference, omniMessageOverrideMessage.templateReference)
        && Objects.equals(this.choiceMessage, omniMessageOverrideMessage.choiceMessage)
        && Objects.equals(this.cardMessage, omniMessageOverrideMessage.cardMessage)
        && Objects.equals(this.carouselMessage, omniMessageOverrideMessage.carouselMessage)
        && Objects.equals(this.locationMessage, omniMessageOverrideMessage.locationMessage)
        && Objects.equals(this.contactInfoMessage, omniMessageOverrideMessage.contactInfoMessage)
        && Objects.equals(this.listMessage, omniMessageOverrideMessage.listMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        textMessage,
        mediaMessage,
        templateReference,
        choiceMessage,
        cardMessage,
        carouselMessage,
        locationMessage,
        contactInfoMessage,
        listMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OmniMessageOverrideMessageImpl {\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
    sb.append("    mediaMessage: ").append(toIndentedString(mediaMessage)).append("\n");
    sb.append("    templateReference: ").append(toIndentedString(templateReference)).append("\n");
    sb.append("    choiceMessage: ").append(toIndentedString(choiceMessage)).append("\n");
    sb.append("    cardMessage: ").append(toIndentedString(cardMessage)).append("\n");
    sb.append("    carouselMessage: ").append(toIndentedString(carouselMessage)).append("\n");
    sb.append("    locationMessage: ").append(toIndentedString(locationMessage)).append("\n");
    sb.append("    contactInfoMessage: ").append(toIndentedString(contactInfoMessage)).append("\n");
    sb.append("    listMessage: ").append(toIndentedString(listMessage)).append("\n");
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
  static class Builder implements OmniMessageOverrideMessage.Builder {
    OptionalValue<TextMessage> textMessage = OptionalValue.empty();
    OptionalValue<MediaMessage> mediaMessage = OptionalValue.empty();
    OptionalValue<TemplateReference> templateReference = OptionalValue.empty();
    OptionalValue<ChoiceMessage> choiceMessage = OptionalValue.empty();
    OptionalValue<CardMessage> cardMessage = OptionalValue.empty();
    OptionalValue<CarouselMessage> carouselMessage = OptionalValue.empty();
    OptionalValue<LocationMessage> locationMessage = OptionalValue.empty();
    OptionalValue<ContactInfoMessage> contactInfoMessage = OptionalValue.empty();
    OptionalValue<ListMessage> listMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
    public Builder setMediaMessage(MediaMessage mediaMessage) {
      this.mediaMessage = OptionalValue.of(mediaMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEMPLATE_REFERENCE)
    public Builder setTemplateReference(TemplateReference templateReference) {
      this.templateReference = OptionalValue.of(templateReference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
    public Builder setChoiceMessage(ChoiceMessage choiceMessage) {
      this.choiceMessage = OptionalValue.of(choiceMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CARD_MESSAGE)
    public Builder setCardMessage(CardMessage cardMessage) {
      this.cardMessage = OptionalValue.of(cardMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CAROUSEL_MESSAGE)
    public Builder setCarouselMessage(CarouselMessage carouselMessage) {
      this.carouselMessage = OptionalValue.of(carouselMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
    public Builder setLocationMessage(LocationMessage locationMessage) {
      this.locationMessage = OptionalValue.of(locationMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_INFO_MESSAGE)
    public Builder setContactInfoMessage(ContactInfoMessage contactInfoMessage) {
      this.contactInfoMessage = OptionalValue.of(contactInfoMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
    public Builder setListMessage(ListMessage listMessage) {
      this.listMessage = OptionalValue.of(listMessage);
      return this;
    }

    public OmniMessageOverrideMessage build() {
      return new OmniMessageOverrideMessageImpl(
          textMessage,
          mediaMessage,
          templateReference,
          choiceMessage,
          cardMessage,
          carouselMessage,
          locationMessage,
          contactInfoMessage,
          listMessage);
    }
  }
}
