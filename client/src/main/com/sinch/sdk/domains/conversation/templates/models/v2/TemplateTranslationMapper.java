package com.sinch.sdk.domains.conversation.templates.models.v2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessageMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageImpl;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslationBaseImpl.Builder;

public class TemplateTranslationMapper {

  public static void initMapper() {

    Mapper.getInstance()
        .addMixIn(
            TemplateTranslationBase.class, TemplateTranslationInternalMapperMixinSerializer.class)
        .addMixIn(
            TemplateTranslationBase.Builder.class,
            TemplateTranslationInternalBuilderMapperMixin.class);
  }

  static class TemplateTranslationInternalMapperMixinSerializer
      extends TemplateTranslationBaseImpl {

    @Override
    @JsonSerialize(using = CardMessageImpl.DelegatedSerializer.class)
    public OptionalValue<CardMessage> cardMessage() {
      return super.cardMessage();
    }

    @Override
    @JsonSerialize(using = CarouselMessageMapper.DelegatedSerializer.class)
    public OptionalValue<CarouselMessage> carouselMessage() {
      return super.carouselMessage();
    }

    @Override
    @JsonSerialize(using = ChoiceMessageImpl.DelegatedSerializer.class)
    public OptionalValue<ChoiceMessage> choiceMessage() {
      return super.choiceMessage();
    }

    @Override
    @JsonSerialize(using = ContactInfoMessageImpl.DelegatedSerializer.class)
    public OptionalValue<ContactInfoMessage> contactInfoMessage() {
      return super.contactInfoMessage();
    }

    @Override
    @JsonSerialize(using = ListMessageImpl.DelegatedSerializer.class)
    public OptionalValue<ListMessage> listMessage() {
      return super.listMessage();
    }

    @Override
    @JsonSerialize(using = LocationMessageImpl.DelegatedSerializer.class)
    public OptionalValue<LocationMessage> locationMessage() {
      return super.locationMessage();
    }

    @Override
    @JsonSerialize(using = MediaMessageImpl.DelegatedSerializer.class)
    public OptionalValue<MediaMessage> mediaMessage() {
      return super.mediaMessage();
    }

    @Override
    @JsonSerialize(
        using =
            com.sinch.sdk.domains.conversation.models.v1.messages.types.template
                .TemplateMessageMapper.DelegatedSerializer.class)
    public OptionalValue<TemplateMessage> templateMessage() {
      return super.templateMessage();
    }

    @Override
    @JsonSerialize(using = TextMessageImpl.DelegatedSerializer.class)
    public OptionalValue<TextMessage> textMessage() {
      return super.textMessage();
    }
  }

  static class TemplateTranslationInternalBuilderMapperMixin<B extends Builder<B>>
      extends TemplateTranslationBaseImpl.Builder<B> {

    @Override
    @JsonDeserialize(using = CardMessageImpl.DelegatedDeSerializer.class)
    public B setCardMessage(CardMessage cardMessage) {
      return super.setCardMessage(cardMessage);
    }

    @Override
    @JsonDeserialize(using = CarouselMessageMapper.DelegatedDeSerializer.class)
    public B setCarouselMessage(CarouselMessage carouselMessage) {
      return super.setCarouselMessage(carouselMessage);
    }

    @Override
    @JsonDeserialize(using = ChoiceMessageImpl.DelegatedDeSerializer.class)
    public B setChoiceMessage(ChoiceMessage choiceMessage) {
      return super.setChoiceMessage(choiceMessage);
    }

    @Override
    @JsonDeserialize(using = ContactInfoMessageImpl.DelegatedDeSerializer.class)
    public B setContactInfoMessage(ContactInfoMessage contactInfoMessage) {
      return super.setContactInfoMessage(contactInfoMessage);
    }

    @Override
    @JsonDeserialize(using = ListMessageImpl.DelegatedDeSerializer.class)
    public B setListMessage(ListMessage listMessage) {
      return super.setListMessage(listMessage);
    }

    @Override
    @JsonDeserialize(using = LocationMessageImpl.DelegatedDeSerializer.class)
    public B setLocationMessage(LocationMessage locationMessage) {
      return super.setLocationMessage(locationMessage);
    }

    @Override
    @JsonDeserialize(using = MediaMessageImpl.DelegatedDeSerializer.class)
    public B setMediaMessage(MediaMessage mediaMessage) {
      return super.setMediaMessage(mediaMessage);
    }

    @Override
    @JsonDeserialize(using = TextMessageImpl.DelegatedDeSerializer.class)
    public B setTextMessage(TextMessage textMessage) {
      return super.setTextMessage(textMessage);
    }

    @Override
    @JsonDeserialize(
        using =
            com.sinch.sdk.domains.conversation.models.v1.messages.types.template
                .TemplateMessageMapper.DelegatedDeSerializer.class)
    public B setTemplateMessage(TemplateMessage templateMessage) {
      return super.setTemplateMessage(templateMessage);
    }
  }
}
