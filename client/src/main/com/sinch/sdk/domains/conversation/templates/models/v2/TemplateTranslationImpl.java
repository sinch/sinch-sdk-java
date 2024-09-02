package com.sinch.sdk.domains.conversation.templates.models.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageBody;
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
import java.util.logging.Logger;

public class TemplateTranslationImpl extends TemplateTranslationBaseImpl
    implements TemplateTranslation {

  private static final Logger LOGGER = Logger.getLogger(TemplateTranslationImpl.class.getName());

  TemplateTranslationImpl(TemplateTranslationBase _from) {
    super(
        ((TemplateTranslationBaseImpl) _from).languageCode(),
        ((TemplateTranslationBaseImpl) _from).version(),
        ((TemplateTranslationBaseImpl) _from).channelTemplateOverrides(),
        ((TemplateTranslationBaseImpl) _from).variables(),
        ((TemplateTranslationBaseImpl) _from).createTime(),
        ((TemplateTranslationBaseImpl) _from).updateTime(),
        ((TemplateTranslationBaseImpl) _from).cardMessage(),
        ((TemplateTranslationBaseImpl) _from).carouselMessage(),
        ((TemplateTranslationBaseImpl) _from).choiceMessage(),
        ((TemplateTranslationBaseImpl) _from).locationMessage(),
        ((TemplateTranslationBaseImpl) _from).mediaMessage(),
        ((TemplateTranslationBaseImpl) _from).templateMessage(),
        ((TemplateTranslationBaseImpl) _from).textMessage(),
        ((TemplateTranslationBaseImpl) _from).listMessage(),
        ((TemplateTranslationBaseImpl) _from).contactInfoMessage());
  }

  @JsonIgnore
  public AppMessageBody getMessage() {

    if (cardMessage().isPresent()) {
      return cardMessage().get();
    } else if (carouselMessage().isPresent()) {
      return carouselMessage().get();
    } else if (choiceMessage().isPresent()) {
      return choiceMessage().get();
    } else if (contactInfoMessage().isPresent()) {
      return contactInfoMessage().get();
    } else if (listMessage().isPresent()) {
      return listMessage().get();
    } else if (locationMessage().isPresent()) {
      return locationMessage().get();
    } else if (mediaMessage().isPresent()) {
      return mediaMessage().get();
    } else if (templateMessage().isPresent()) {
      return templateMessage().get();
    } else if (textMessage().isPresent()) {
      return textMessage().get();
    }
    return null;
  }

  protected TemplateTranslationImpl(
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
    super(
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

  static class Builder<B extends Builder<B>> extends TemplateTranslationBaseImpl.Builder<B>
      implements TemplateTranslation.Builder<B> {

    @JsonIgnore
    public B setMessage(AppMessageBody message) {

      if (message instanceof CardMessage) {
        this.cardMessage = OptionalValue.of((CardMessage) message);
      } else if (message instanceof CarouselMessage) {
        this.carouselMessage = OptionalValue.of((CarouselMessage) message);
      } else if (message instanceof ChoiceMessage) {
        this.choiceMessage = OptionalValue.of((ChoiceMessage) message);
      } else if (message instanceof ContactInfoMessage) {
        this.contactInfoMessage = OptionalValue.of((ContactInfoMessage) message);
      } else if (message instanceof ListMessage) {
        this.listMessage = OptionalValue.of((ListMessage) message);
      } else if (message instanceof LocationMessage) {
        this.locationMessage = OptionalValue.of((LocationMessage) message);
      } else if (message instanceof MediaMessage) {
        this.mediaMessage = OptionalValue.of((MediaMessage) message);
      } else if (message instanceof TemplateMessage) {
        this.templateMessage = OptionalValue.of((TemplateMessage) message);
      } else if (message instanceof TextMessage) {
        this.textMessage = OptionalValue.of((TextMessage) message);
      } else {
        LOGGER.severe("Unexpected message: " + message);
      }
      return self();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    public TemplateTranslation build() {
      return new TemplateTranslationImpl(
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
