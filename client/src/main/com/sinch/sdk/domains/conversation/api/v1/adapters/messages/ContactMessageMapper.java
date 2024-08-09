package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage.Builder;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessageBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ContactMessageInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ContactMessageInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse.ChoiceResponseMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback.FallbackMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard.MediaCardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.productresponse.ProductResponseMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.io.IOException;
import java.util.logging.Logger;

public class ContactMessageMapper {

  private static final Logger LOGGER = Logger.getLogger(ContactMessageMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addSerializer(ContactMessage.class, new Serializer())
            .addDeserializer(ContactMessage.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<ContactMessage<?>> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<ContactMessage<?>> vc) {
      super(vc);
    }

    @Override
    public ContactMessage<?> deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ContactMessageInternalImpl deserialized =
          (ContactMessageInternalImpl) jp.readValueAs(ContactMessageInternal.class);
      Builder<ContactMessageBody> internal = ContactMessage.builder();

      deserialized.channelSpecificMessage().ifPresent(internal::setBody);
      deserialized.choiceResponseMessage().ifPresent(internal::setBody);
      deserialized.fallbackMessage().ifPresent(internal::setBody);
      deserialized.locationMessage().ifPresent(internal::setBody);
      deserialized.mediaCardMessage().ifPresent(internal::setBody);
      deserialized.mediaMessage().ifPresent(internal::setBody);
      deserialized.productResponseMessage().ifPresent(internal::setBody);
      deserialized.textMessage().ifPresent(internal::setBody);
      deserialized.replyTo().ifPresent(internal::setReplyTo);

      return internal.build();
    }
  }

  static class Serializer extends StdSerializer<ContactMessage> {

    public Serializer() {
      this(null);
    }

    public Serializer(Class<ContactMessage> t) {
      super(t);
    }

    @Override
    public void serialize(ContactMessage raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      ContactMessageImpl<?> value = (ContactMessageImpl<?>) raw;
      ContactMessageInternal.Builder internal = ContactMessageInternal.builder();

      value.replyTo().ifPresent(internal::setReplyTo);
      value
          .body()
          .ifPresent(
              message -> {
                if (message instanceof ChannelSpecificContactMessage) {
                  internal.setChannelSpecificMessage((ChannelSpecificContactMessage) message);
                } else if (message instanceof ChoiceResponseMessage) {
                  internal.setChoiceResponseMessage((ChoiceResponseMessage) message);
                } else if (message instanceof FallbackMessage) {
                  internal.setFallbackMessage((FallbackMessage) message);
                } else if (message instanceof LocationMessage) {
                  internal.setLocationMessage((LocationMessage) message);
                } else if (message instanceof MediaCardMessage) {
                  internal.setMediaCardMessage((MediaCardMessage) message);
                } else if (message instanceof MediaMessage) {
                  internal.setMediaMessage((MediaMessage) message);
                } else if (message instanceof ProductResponseMessage) {
                  internal.setProductResponseMessage((ProductResponseMessage) message);
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
