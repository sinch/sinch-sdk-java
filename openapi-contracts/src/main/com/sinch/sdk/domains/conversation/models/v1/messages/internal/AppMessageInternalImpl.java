package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.Agent;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  AppMessageInternalImpl.JSON_PROPERTY_CARD_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_CAROUSEL_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_CHOICE_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_LOCATION_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_MEDIA_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_TEMPLATE_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_TEXT_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_LIST_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_CONTACT_INFO_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_EXPLICIT_CHANNEL_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_EXPLICIT_CHANNEL_OMNI_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE,
  AppMessageInternalImpl.JSON_PROPERTY_AGENT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AppMessageInternalImpl implements AppMessageInternal {
  private static final long serialVersionUID = 1L;

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

  public static final String JSON_PROPERTY_EXPLICIT_CHANNEL_MESSAGE = "explicit_channel_message";

  private OptionalValue<Map<ConversationChannel, String>> explicitChannelMessage;

  public static final String JSON_PROPERTY_EXPLICIT_CHANNEL_OMNI_MESSAGE =
      "explicit_channel_omni_message";

  private OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
      explicitChannelOmniMessage;

  public static final String JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE = "channel_specific_message";

  private OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>> channelSpecificMessage;

  public static final String JSON_PROPERTY_AGENT = "agent";

  private OptionalValue<Agent> agent;

  public AppMessageInternalImpl() {}

  protected AppMessageInternalImpl(
      OptionalValue<CardMessage> cardMessage,
      OptionalValue<CarouselMessage> carouselMessage,
      OptionalValue<ChoiceMessage> choiceMessage,
      OptionalValue<LocationMessage> locationMessage,
      OptionalValue<MediaMessage> mediaMessage,
      OptionalValue<TemplateMessage> templateMessage,
      OptionalValue<TextMessage> textMessage,
      OptionalValue<ListMessage> listMessage,
      OptionalValue<ContactInfoMessage> contactInfoMessage,
      OptionalValue<Map<ConversationChannel, String>> explicitChannelMessage,
      OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
          explicitChannelOmniMessage,
      OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>> channelSpecificMessage,
      OptionalValue<Agent> agent) {
    this.cardMessage = cardMessage;
    this.carouselMessage = carouselMessage;
    this.choiceMessage = choiceMessage;
    this.locationMessage = locationMessage;
    this.mediaMessage = mediaMessage;
    this.templateMessage = templateMessage;
    this.textMessage = textMessage;
    this.listMessage = listMessage;
    this.contactInfoMessage = contactInfoMessage;
    this.explicitChannelMessage = explicitChannelMessage;
    this.explicitChannelOmniMessage = explicitChannelOmniMessage;
    this.channelSpecificMessage = channelSpecificMessage;
    this.agent = agent;
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

  @JsonIgnore
  public Map<ConversationChannel, String> getExplicitChannelMessage() {
    return explicitChannelMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPLICIT_CHANNEL_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<ConversationChannel, String>> explicitChannelMessage() {
    return explicitChannelMessage;
  }

  @JsonIgnore
  public Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>
      getExplicitChannelOmniMessage() {
    return explicitChannelOmniMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPLICIT_CHANNEL_OMNI_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
      explicitChannelOmniMessage() {
    return explicitChannelOmniMessage;
  }

  @JsonIgnore
  public Map<ConversationChannel, ChannelSpecificMessage> getChannelSpecificMessage() {
    return channelSpecificMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>> channelSpecificMessage() {
    return channelSpecificMessage;
  }

  @JsonIgnore
  public Agent getAgent() {
    return agent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AGENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Agent> agent() {
    return agent;
  }

  /** Return true if this AppMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppMessageInternalImpl appMessage = (AppMessageInternalImpl) o;
    return Objects.equals(this.cardMessage, appMessage.cardMessage)
        && Objects.equals(this.carouselMessage, appMessage.carouselMessage)
        && Objects.equals(this.choiceMessage, appMessage.choiceMessage)
        && Objects.equals(this.locationMessage, appMessage.locationMessage)
        && Objects.equals(this.mediaMessage, appMessage.mediaMessage)
        && Objects.equals(this.templateMessage, appMessage.templateMessage)
        && Objects.equals(this.textMessage, appMessage.textMessage)
        && Objects.equals(this.listMessage, appMessage.listMessage)
        && Objects.equals(this.contactInfoMessage, appMessage.contactInfoMessage)
        && Objects.equals(this.explicitChannelMessage, appMessage.explicitChannelMessage)
        && Objects.equals(this.explicitChannelOmniMessage, appMessage.explicitChannelOmniMessage)
        && Objects.equals(this.channelSpecificMessage, appMessage.channelSpecificMessage)
        && Objects.equals(this.agent, appMessage.agent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cardMessage,
        carouselMessage,
        choiceMessage,
        locationMessage,
        mediaMessage,
        templateMessage,
        textMessage,
        listMessage,
        contactInfoMessage,
        explicitChannelMessage,
        explicitChannelOmniMessage,
        channelSpecificMessage,
        agent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppMessageInternalImpl {\n");
    sb.append("    cardMessage: ").append(toIndentedString(cardMessage)).append("\n");
    sb.append("    carouselMessage: ").append(toIndentedString(carouselMessage)).append("\n");
    sb.append("    choiceMessage: ").append(toIndentedString(choiceMessage)).append("\n");
    sb.append("    locationMessage: ").append(toIndentedString(locationMessage)).append("\n");
    sb.append("    mediaMessage: ").append(toIndentedString(mediaMessage)).append("\n");
    sb.append("    templateMessage: ").append(toIndentedString(templateMessage)).append("\n");
    sb.append("    textMessage: ").append(toIndentedString(textMessage)).append("\n");
    sb.append("    listMessage: ").append(toIndentedString(listMessage)).append("\n");
    sb.append("    contactInfoMessage: ").append(toIndentedString(contactInfoMessage)).append("\n");
    sb.append("    explicitChannelMessage: ")
        .append(toIndentedString(explicitChannelMessage))
        .append("\n");
    sb.append("    explicitChannelOmniMessage: ")
        .append(toIndentedString(explicitChannelOmniMessage))
        .append("\n");
    sb.append("    channelSpecificMessage: ")
        .append(toIndentedString(channelSpecificMessage))
        .append("\n");
    sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
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
  static class Builder implements AppMessageInternal.Builder {
    OptionalValue<CardMessage> cardMessage = OptionalValue.empty();
    OptionalValue<CarouselMessage> carouselMessage = OptionalValue.empty();
    OptionalValue<ChoiceMessage> choiceMessage = OptionalValue.empty();
    OptionalValue<LocationMessage> locationMessage = OptionalValue.empty();
    OptionalValue<MediaMessage> mediaMessage = OptionalValue.empty();
    OptionalValue<TemplateMessage> templateMessage = OptionalValue.empty();
    OptionalValue<TextMessage> textMessage = OptionalValue.empty();
    OptionalValue<ListMessage> listMessage = OptionalValue.empty();
    OptionalValue<ContactInfoMessage> contactInfoMessage = OptionalValue.empty();
    OptionalValue<Map<ConversationChannel, String>> explicitChannelMessage = OptionalValue.empty();
    OptionalValue<Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>>
        explicitChannelOmniMessage = OptionalValue.empty();
    OptionalValue<Map<ConversationChannel, ChannelSpecificMessage>> channelSpecificMessage =
        OptionalValue.empty();
    OptionalValue<Agent> agent = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_CHOICE_MESSAGE)
    public Builder setChoiceMessage(ChoiceMessage choiceMessage) {
      this.choiceMessage = OptionalValue.of(choiceMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LOCATION_MESSAGE)
    public Builder setLocationMessage(LocationMessage locationMessage) {
      this.locationMessage = OptionalValue.of(locationMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MEDIA_MESSAGE)
    public Builder setMediaMessage(MediaMessage mediaMessage) {
      this.mediaMessage = OptionalValue.of(mediaMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEMPLATE_MESSAGE)
    public Builder setTemplateMessage(TemplateMessage templateMessage) {
      this.templateMessage = OptionalValue.of(templateMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEXT_MESSAGE)
    public Builder setTextMessage(TextMessage textMessage) {
      this.textMessage = OptionalValue.of(textMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LIST_MESSAGE)
    public Builder setListMessage(ListMessage listMessage) {
      this.listMessage = OptionalValue.of(listMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_INFO_MESSAGE)
    public Builder setContactInfoMessage(ContactInfoMessage contactInfoMessage) {
      this.contactInfoMessage = OptionalValue.of(contactInfoMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXPLICIT_CHANNEL_MESSAGE)
    public Builder setExplicitChannelMessage(
        Map<ConversationChannel, String> explicitChannelMessage) {
      this.explicitChannelMessage = OptionalValue.of(explicitChannelMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXPLICIT_CHANNEL_OMNI_MESSAGE)
    public Builder setExplicitChannelOmniMessage(
        Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>
            explicitChannelOmniMessage) {
      this.explicitChannelOmniMessage = OptionalValue.of(explicitChannelOmniMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_SPECIFIC_MESSAGE)
    public Builder setChannelSpecificMessage(
        Map<ConversationChannel, ChannelSpecificMessage> channelSpecificMessage) {
      this.channelSpecificMessage = OptionalValue.of(channelSpecificMessage);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AGENT)
    public Builder setAgent(Agent agent) {
      this.agent = OptionalValue.of(agent);
      return this;
    }

    public AppMessageInternal build() {
      return new AppMessageInternalImpl(
          cardMessage,
          carouselMessage,
          choiceMessage,
          locationMessage,
          mediaMessage,
          templateMessage,
          textMessage,
          listMessage,
          contactInfoMessage,
          explicitChannelMessage,
          explicitChannelOmniMessage,
          channelSpecificMessage,
          agent);
    }
  }
}
