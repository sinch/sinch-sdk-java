package com.sinch.sdk.domains.conversation.templates.models.v2;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.templates.models.TemplateVariable;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  TemplateTranslationBaseImpl.JSON_PROPERTY_LANGUAGE_CODE,
  TemplateTranslationBaseImpl.JSON_PROPERTY_VERSION,
  TemplateTranslationBaseImpl.JSON_PROPERTY_CHANNEL_TEMPLATE_OVERRIDES,
  TemplateTranslationBaseImpl.JSON_PROPERTY_VARIABLES,
  TemplateTranslationBaseImpl.JSON_PROPERTY_CREATE_TIME,
  TemplateTranslationBaseImpl.JSON_PROPERTY_UPDATE_TIME,
  TemplateTranslationBaseImpl.JSON_PROPERTY_CARD_MESSAGE,
  TemplateTranslationBaseImpl.JSON_PROPERTY_CAROUSEL_MESSAGE,
  TemplateTranslationBaseImpl.JSON_PROPERTY_CHOICE_MESSAGE,
  TemplateTranslationBaseImpl.JSON_PROPERTY_LOCATION_MESSAGE,
  TemplateTranslationBaseImpl.JSON_PROPERTY_MEDIA_MESSAGE,
  TemplateTranslationBaseImpl.JSON_PROPERTY_TEMPLATE_MESSAGE,
  TemplateTranslationBaseImpl.JSON_PROPERTY_TEXT_MESSAGE,
  TemplateTranslationBaseImpl.JSON_PROPERTY_LIST_MESSAGE,
  TemplateTranslationBaseImpl.JSON_PROPERTY_CONTACT_INFO_MESSAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class TemplateTranslationBaseImpl implements TemplateTranslationBase {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_LANGUAGE_CODE = "language_code";

  private OptionalValue<String> languageCode;

  public static final String JSON_PROPERTY_VERSION = "version";

  private OptionalValue<String> version;

  public static final String JSON_PROPERTY_CHANNEL_TEMPLATE_OVERRIDES =
      "channel_template_overrides";

  private OptionalValue<Map<ConversationChannel, ChannelTemplateOverride>> channelTemplateOverrides;

  public static final String JSON_PROPERTY_VARIABLES = "variables";

  private OptionalValue<List<TemplateVariable>> variables;

  public static final String JSON_PROPERTY_CREATE_TIME = "create_time";

  private OptionalValue<Instant> createTime;

  public static final String JSON_PROPERTY_UPDATE_TIME = "update_time";

  private OptionalValue<Instant> updateTime;

  public static final String JSON_PROPERTY_CARD_MESSAGE = "card_message";

  private OptionalValue<CardMessage> cardMessage;

  public static final String JSON_PROPERTY_CAROUSEL_MESSAGE = "carousel_message";

  private OptionalValue<CarouselMessage> carouselMessage;

  public static final String JSON_PROPERTY_CHOICE_MESSAGE = "choice_message";

  private OptionalValue<ChoiceMessage> choiceMessage;

  public static final String JSON_PROPERTY_LOCATION_MESSAGE = "location_message";

  private OptionalValue<LocationMessage> locationMessage;

  public static final String JSON_PROPERTY_MEDIA_MESSAGE = "media_message";

  private OptionalValue<MediaMessage> mediaMessage;

  public static final String JSON_PROPERTY_TEMPLATE_MESSAGE = "template_message";

  private OptionalValue<TemplateMessage> templateMessage;

  public static final String JSON_PROPERTY_TEXT_MESSAGE = "text_message";

  private OptionalValue<TextMessage> textMessage;

  public static final String JSON_PROPERTY_LIST_MESSAGE = "list_message";

  private OptionalValue<ListMessage> listMessage;

  public static final String JSON_PROPERTY_CONTACT_INFO_MESSAGE = "contact_info_message";

  private OptionalValue<ContactInfoMessage> contactInfoMessage;

  public TemplateTranslationBaseImpl() {}

  protected TemplateTranslationBaseImpl(
      OptionalValue<String> languageCode,
      OptionalValue<String> version,
      OptionalValue<Map<ConversationChannel, ChannelTemplateOverride>> channelTemplateOverrides,
      OptionalValue<List<TemplateVariable>> variables,
      OptionalValue<Instant> createTime,
      OptionalValue<Instant> updateTime,
      OptionalValue<CardMessage> cardMessage,
      OptionalValue<CarouselMessage> carouselMessage,
      OptionalValue<ChoiceMessage> choiceMessage,
      OptionalValue<LocationMessage> locationMessage,
      OptionalValue<MediaMessage> mediaMessage,
      OptionalValue<TemplateMessage> templateMessage,
      OptionalValue<TextMessage> textMessage,
      OptionalValue<ListMessage> listMessage,
      OptionalValue<ContactInfoMessage> contactInfoMessage) {
    this.languageCode = languageCode;
    this.version = version;
    this.channelTemplateOverrides = channelTemplateOverrides;
    this.variables = variables;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.cardMessage = cardMessage;
    this.carouselMessage = carouselMessage;
    this.choiceMessage = choiceMessage;
    this.locationMessage = locationMessage;
    this.mediaMessage = mediaMessage;
    this.templateMessage = templateMessage;
    this.textMessage = textMessage;
    this.listMessage = listMessage;
    this.contactInfoMessage = contactInfoMessage;
  }

  @JsonIgnore
  public String getLanguageCode() {
    return languageCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LANGUAGE_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> languageCode() {
    return languageCode;
  }

  @JsonIgnore
  public String getVersion() {
    return version.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> version() {
    return version;
  }

  @JsonIgnore
  public Map<ConversationChannel, ChannelTemplateOverride> getChannelTemplateOverrides() {
    return channelTemplateOverrides.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_TEMPLATE_OVERRIDES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<ConversationChannel, ChannelTemplateOverride>>
      channelTemplateOverrides() {
    return channelTemplateOverrides;
  }

  @JsonIgnore
  public List<TemplateVariable> getVariables() {
    return variables.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VARIABLES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<TemplateVariable>> variables() {
    return variables;
  }

  @JsonIgnore
  public Instant getCreateTime() {
    return createTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CREATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> createTime() {
    return createTime;
  }

  @JsonIgnore
  public Instant getUpdateTime() {
    return updateTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> updateTime() {
    return updateTime;
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
  public ChoiceMessage getChoiceMessage() {
    return choiceMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChoiceMessage> choiceMessage() {
    return choiceMessage;
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
  public MediaMessage getMediaMessage() {
    return mediaMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<MediaMessage> mediaMessage() {
    return mediaMessage;
  }

  @JsonIgnore
  public TemplateMessage getTemplateMessage() {
    return templateMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TemplateMessage> templateMessage() {
    return templateMessage;
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
  public ListMessage getListMessage() {
    return listMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ListMessage> listMessage() {
    return listMessage;
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

  /** Return true if this v2TemplateTranslation object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateTranslationBaseImpl v2TemplateTranslation = (TemplateTranslationBaseImpl) o;
    return Objects.equals(this.languageCode, v2TemplateTranslation.languageCode)
        && Objects.equals(this.version, v2TemplateTranslation.version)
        && Objects.equals(
            this.channelTemplateOverrides, v2TemplateTranslation.channelTemplateOverrides)
        && Objects.equals(this.variables, v2TemplateTranslation.variables)
        && Objects.equals(this.createTime, v2TemplateTranslation.createTime)
        && Objects.equals(this.updateTime, v2TemplateTranslation.updateTime)
        && Objects.equals(this.cardMessage, v2TemplateTranslation.cardMessage)
        && Objects.equals(this.carouselMessage, v2TemplateTranslation.carouselMessage)
        && Objects.equals(this.choiceMessage, v2TemplateTranslation.choiceMessage)
        && Objects.equals(this.locationMessage, v2TemplateTranslation.locationMessage)
        && Objects.equals(this.mediaMessage, v2TemplateTranslation.mediaMessage)
        && Objects.equals(this.templateMessage, v2TemplateTranslation.templateMessage)
        && Objects.equals(this.textMessage, v2TemplateTranslation.textMessage)
        && Objects.equals(this.listMessage, v2TemplateTranslation.listMessage)
        && Objects.equals(this.contactInfoMessage, v2TemplateTranslation.contactInfoMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        languageCode,
        version,
        channelTemplateOverrides,
        variables,
        createTime,
        updateTime,
        cardMessage,
        carouselMessage,
        choiceMessage,
        locationMessage,
        mediaMessage,
        templateMessage,
        textMessage,
        listMessage,
        contactInfoMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemplateTranslationBaseImpl {\n");
    sb.append("    languageCode: ").append(toIndentedString(languageCode)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    channelTemplateOverrides: ")
        .append(toIndentedString(channelTemplateOverrides))
        .append("\n");
    sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    cardMessage: ").append(toIndentedString(cardMessage)).append("\n");
    sb.append("    carouselMessage: ").append(toIndentedString(carouselMessage)).append("\n");
    sb.append("    choiceMessage: ").append(toIndentedString(choiceMessage)).append("\n");
    sb.append("    locationMessage: ").append(toIndentedString(locationMessage)).append("\n");
    sb.append("    mediaMessage: ").append(toIndentedString(mediaMessage)).append("\n");
    sb.append("    templateMessage: ").append(toIndentedString(templateMessage)).append("\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
    sb.append("    listMessage: ").append(toIndentedString(listMessage)).append("\n");
    sb.append("    contactInfoMessage: ").append(toIndentedString(contactInfoMessage)).append("\n");
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
  static class Builder<B extends Builder<B>> implements TemplateTranslationBase.Builder<B> {
    OptionalValue<String> languageCode = OptionalValue.empty();
    OptionalValue<String> version = OptionalValue.empty();
    OptionalValue<Map<ConversationChannel, ChannelTemplateOverride>> channelTemplateOverrides =
        OptionalValue.empty();
    OptionalValue<List<TemplateVariable>> variables = OptionalValue.empty();
    OptionalValue<Instant> createTime = OptionalValue.empty();
    OptionalValue<Instant> updateTime = OptionalValue.empty();
    OptionalValue<CardMessage> cardMessage = OptionalValue.empty();
    OptionalValue<CarouselMessage> carouselMessage = OptionalValue.empty();
    OptionalValue<ChoiceMessage> choiceMessage = OptionalValue.empty();
    OptionalValue<LocationMessage> locationMessage = OptionalValue.empty();
    OptionalValue<MediaMessage> mediaMessage = OptionalValue.empty();
    OptionalValue<TemplateMessage> templateMessage = OptionalValue.empty();
    OptionalValue<TextMessage> textMessage = OptionalValue.empty();
    OptionalValue<ListMessage> listMessage = OptionalValue.empty();
    OptionalValue<ContactInfoMessage> contactInfoMessage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LANGUAGE_CODE)
    public B setLanguageCode(String languageCode) {
      this.languageCode = OptionalValue.of(languageCode);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    public B setVersion(String version) {
      this.version = OptionalValue.of(version);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_TEMPLATE_OVERRIDES)
    public B setChannelTemplateOverrides(
        Map<ConversationChannel, ChannelTemplateOverride> channelTemplateOverrides) {
      this.channelTemplateOverrides = OptionalValue.of(channelTemplateOverrides);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_VARIABLES)
    public B setVariables(List<TemplateVariable> variables) {
      this.variables = OptionalValue.of(variables);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_CREATE_TIME)
    public B setCreateTime(Instant createTime) {
      this.createTime = OptionalValue.of(createTime);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_UPDATE_TIME)
    public B setUpdateTime(Instant updateTime) {
      this.updateTime = OptionalValue.of(updateTime);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_CARD_MESSAGE)
    public B setCardMessage(CardMessage cardMessage) {
      this.cardMessage = OptionalValue.of(cardMessage);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_CAROUSEL_MESSAGE)
    public B setCarouselMessage(CarouselMessage carouselMessage) {
      this.carouselMessage = OptionalValue.of(carouselMessage);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
    public B setChoiceMessage(ChoiceMessage choiceMessage) {
      this.choiceMessage = OptionalValue.of(choiceMessage);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
    public B setLocationMessage(LocationMessage locationMessage) {
      this.locationMessage = OptionalValue.of(locationMessage);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
    public B setMediaMessage(MediaMessage mediaMessage) {
      this.mediaMessage = OptionalValue.of(mediaMessage);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_TEMPLATE_MESSAGE)
    public B setTemplateMessage(TemplateMessage templateMessage) {
      this.templateMessage = OptionalValue.of(templateMessage);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public B setTextMessage(TextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
    public B setListMessage(ListMessage listMessage) {
      this.listMessage = OptionalValue.of(listMessage);
      return self();
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_INFO_MESSAGE)
    public B setContactInfoMessage(ContactInfoMessage contactInfoMessage) {
      this.contactInfoMessage = OptionalValue.of(contactInfoMessage);
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    public TemplateTranslationBase build() {
      return new TemplateTranslationBaseImpl(
          languageCode,
          version,
          channelTemplateOverrides,
          variables,
          createTime,
          updateTime,
          cardMessage,
          carouselMessage,
          choiceMessage,
          locationMessage,
          mediaMessage,
          templateMessage,
          textMessage,
          listMessage,
          contactInfoMessage);
    }
  }
}
