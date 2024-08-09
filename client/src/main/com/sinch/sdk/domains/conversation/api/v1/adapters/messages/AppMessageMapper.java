package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.AppMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.AppMessageInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.io.IOException;
import java.util.logging.Logger;

public class AppMessageMapper {

  private static final Logger LOGGER = Logger.getLogger(AppMessageMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addSerializer(AppMessage.class, new Serializer())
            .addDeserializer(AppMessage.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<AppMessage<?>> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<AppMessage> vc) {
      super(vc);
    }

    @Override
    public AppMessage<?> deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      AppMessageInternalImpl deserialized =
          (AppMessageInternalImpl) jp.readValueAs(AppMessageInternal.class);

      AppMessage.Builder internal = AppMessage.builder();
      deserialized.explicitChannelMessage().ifPresent(internal::setExplicitChannelMessage);
      deserialized.explicitChannelOmniMessage().ifPresent(internal::setExplicitChannelOmniMessage);
      deserialized.channelSpecificMessage().ifPresent(internal::setChannelSpecificMessage);
      deserialized.agent().ifPresent(internal::setAgent);
      deserialized.cardMessage().ifPresent(internal::setMessage);
      deserialized.carouselMessage().ifPresent(internal::setMessage);
      deserialized.choiceMessage().ifPresent(internal::setMessage);
      deserialized.contactInfoMessage().ifPresent(internal::setMessage);
      deserialized.listMessage().ifPresent(internal::setMessage);
      deserialized.locationMessage().ifPresent(internal::setMessage);
      deserialized.mediaMessage().ifPresent(internal::setMessage);
      deserialized.templateMessage().ifPresent(internal::setMessage);
      deserialized.textMessage().ifPresent(internal::setMessage);
      return internal.build();
    }
  }

  static class Serializer extends StdSerializer<AppMessage> {

    public Serializer() {
      this(null);
    }

    public Serializer(Class<AppMessage> t) {
      super(t);
    }

    @Override
    public void serialize(AppMessage raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      AppMessageImpl<?> value = (AppMessageImpl<?>) raw;
      AppMessageInternal.Builder internal = AppMessageInternal.builder();

      value.explicitChannelMessage().ifPresent(internal::setExplicitChannelMessage);
      value.explicitChannelOmniMessage().ifPresent(internal::setExplicitChannelOmniMessage);
      value.channelSpecificMessage().ifPresent(internal::setChannelSpecificMessage);
      value.agent().ifPresent(internal::setAgent);
      value
          .message()
          .ifPresent(
              message -> {
                if (message instanceof CardMessage) {
                  internal.setCardMessage((CardMessage) message);
                } else if (message instanceof CarouselMessage) {
                  internal.setCarouselMessage((CarouselMessage) message);
                } else if (message instanceof ChoiceMessage) {
                  internal.setChoiceMessage((ChoiceMessage) message);
                } else if (message instanceof ContactInfoMessage) {
                  internal.setContactInfoMessage((ContactInfoMessage) message);
                } else if (message instanceof ListMessage) {
                  internal.setListMessage((ListMessage) message);
                } else if (message instanceof LocationMessage) {
                  internal.setLocationMessage((LocationMessage) message);
                } else if (message instanceof MediaMessage) {
                  internal.setMediaMessage((MediaMessage) message);
                } else if (message instanceof TemplateMessage) {
                  internal.setTemplateMessage((TemplateMessage) message);
                } else if (message instanceof TextMessage) {
                  internal.setTextMessage((TextMessage) message);
                } else {
                  LOGGER.severe("Unexpected class '" + message.getClass() + "'");
                }
              });

      jgen.writeObject(internal.build());
    }
  }
}
