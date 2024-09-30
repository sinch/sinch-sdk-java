package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.ReplyTo;
import com.sinch.sdk.domains.conversation.models.v1.messages.ReplyToImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse.ChoiceResponseMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse.ChoiceResponseMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback.FallbackMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback.FallbackMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard.MediaCardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard.MediaCardMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.productresponse.ProductResponseMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.productresponse.ProductResponseMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageImpl;

public class ContactMessageInternalMapper {

  public static void initMapper() {

    Mapper.getInstance()
        .addMixIn(ContactMessageInternal.class, ContactMessageInternalMapperMixinSerializer.class)
        .addMixIn(
            ContactMessageInternal.Builder.class, ContactMessageInternalBuilderMapperMixin.class);
  }

  static class ContactMessageInternalMapperMixinSerializer extends ContactMessageInternalImpl {

    @Override
    @JsonSerialize(using = ChannelSpecificContactMessageImpl.DelegatedSerializer.class)
    public OptionalValue<ChannelSpecificContactMessage> channelSpecificMessage() {
      return super.channelSpecificMessage();
    }

    @Override
    @JsonSerialize(using = ChoiceResponseMessageImpl.DelegatedSerializer.class)
    public OptionalValue<ChoiceResponseMessage> choiceResponseMessage() {
      return super.choiceResponseMessage();
    }

    @Override
    @JsonSerialize(using = FallbackMessageImpl.DelegatedSerializer.class)
    public OptionalValue<FallbackMessage> fallbackMessage() {
      return super.fallbackMessage();
    }

    @Override
    @JsonSerialize(using = LocationMessageImpl.DelegatedSerializer.class)
    public OptionalValue<LocationMessage> locationMessage() {
      return super.locationMessage();
    }

    @Override
    @JsonSerialize(using = MediaCardMessageImpl.DelegatedSerializer.class)
    public OptionalValue<MediaCardMessage> mediaCardMessage() {
      return super.mediaCardMessage();
    }

    @Override
    @JsonSerialize(using = MediaMessageImpl.DelegatedSerializer.class)
    public OptionalValue<MediaMessage> mediaMessage() {
      return super.mediaMessage();
    }

    @Override
    @JsonSerialize(using = ProductResponseMessageImpl.DelegatedSerializer.class)
    public OptionalValue<ProductResponseMessage> productResponseMessage() {
      return super.productResponseMessage();
    }

    @Override
    @JsonSerialize(using = TextMessageImpl.DelegatedSerializer.class)
    public OptionalValue<TextMessage> textMessage() {
      return super.textMessage();
    }

    @Override
    @JsonSerialize(using = ReplyToImpl.DelegatedSerializer.class)
    public OptionalValue<ReplyTo> replyTo() {
      return super.replyTo();
    }
  }

  static class ContactMessageInternalBuilderMapperMixin extends ContactMessageInternalImpl.Builder {

    @Override
    @JsonDeserialize(using = ChannelSpecificContactMessageImpl.DelegatedDeSerializer.class)
    public ContactMessageInternalImpl.Builder setChannelSpecificMessage(
        ChannelSpecificContactMessage channelSpecificMessage) {
      return super.setChannelSpecificMessage(channelSpecificMessage);
    }

    @Override
    @JsonDeserialize(using = ChoiceResponseMessageImpl.DelegatedDeSerializer.class)
    public ContactMessageInternalImpl.Builder setChoiceResponseMessage(
        ChoiceResponseMessage choiceResponseMessage) {
      return super.setChoiceResponseMessage(choiceResponseMessage);
    }

    @Override
    @JsonDeserialize(using = FallbackMessageImpl.DelegatedDeSerializer.class)
    public ContactMessageInternalImpl.Builder setFallbackMessage(FallbackMessage fallbackMessage) {
      return super.setFallbackMessage(fallbackMessage);
    }

    @Override
    @JsonDeserialize(using = LocationMessageImpl.DelegatedDeSerializer.class)
    public ContactMessageInternalImpl.Builder setLocationMessage(LocationMessage locationMessage) {
      return super.setLocationMessage(locationMessage);
    }

    @Override
    @JsonDeserialize(using = MediaCardMessageImpl.DelegatedDeSerializer.class)
    public ContactMessageInternalImpl.Builder setMediaCardMessage(
        MediaCardMessage mediaCardMessage) {
      return super.setMediaCardMessage(mediaCardMessage);
    }

    @Override
    @JsonDeserialize(using = MediaMessageImpl.DelegatedDeSerializer.class)
    public ContactMessageInternalImpl.Builder setMediaMessage(MediaMessage mediaMessage) {
      return super.setMediaMessage(mediaMessage);
    }

    @Override
    @JsonDeserialize(using = ProductResponseMessageImpl.DelegatedDeSerializer.class)
    public ContactMessageInternalImpl.Builder setProductResponseMessage(
        ProductResponseMessage productResponseMessage) {
      return super.setProductResponseMessage(productResponseMessage);
    }

    @Override
    @JsonDeserialize(using = TextMessageImpl.DelegatedDeSerializer.class)
    public ContactMessageInternalImpl.Builder setTextMessage(TextMessage textMessage) {
      return super.setTextMessage(textMessage);
    }

    @Override
    @JsonDeserialize(using = ReplyToImpl.DelegatedDeSerializer.class)
    public ContactMessageInternalImpl.Builder setReplyTo(ReplyTo replyTo) {
      return super.setReplyTo(replyTo);
    }
  }
}
