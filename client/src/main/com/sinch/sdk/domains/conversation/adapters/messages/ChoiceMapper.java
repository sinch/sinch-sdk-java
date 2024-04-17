package com.sinch.sdk.domains.conversation.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.CallMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.Choice;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceCallMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceLocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceTextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceURLMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.UrlMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChoiceMessageOneOfInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChoiceMessageOneOfInternalImpl;
import java.io.IOException;
import java.util.logging.Logger;

public class ChoiceMapper {

  private static final Logger LOGGER = Logger.getLogger(ChoiceMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addSerializer(ChoiceImpl.class, new Serializer())
            .addDeserializer(Choice.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Serializer extends StdSerializer<ChoiceImpl> {

    public Serializer() {
      this(null);
    }

    public Serializer(Class<ChoiceImpl> t) {
      super(t);
    }

    @Override
    public void serialize(ChoiceImpl raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      ChoiceImpl<?> value = (ChoiceImpl<?>) raw;
      ChoiceMessageOneOfInternal.Builder internal = ChoiceMessageOneOfInternal.builder();

      value.postbackData().ifPresent(internal::setPostbackData);
      value
          .message()
          .ifPresent(
              m -> {
                if (m instanceof CallMessage) {
                  internal.setCallMessage((CallMessage) m);
                } else if (m instanceof LocationMessage) {
                  internal.setLocationMessage((LocationMessage) m);
                } else if (m instanceof TextMessage) {
                  internal.setTextMessage((TextMessage) m);
                } else if (m instanceof UrlMessage) {
                  internal.setUrlMessage((UrlMessage) m);
                } else {
                  LOGGER.severe("Unexpected class '" + m.getClass() + "'");
                }
              });
      jgen.writeObject(internal.build());
    }
  }

  static class Deserializer extends StdDeserializer<Choice<?>> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<Choice> vc) {
      super(vc);
    }

    @Override
    public Choice<?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      ChoiceMessageOneOfInternalImpl deserialized =
          jp.readValueAs(ChoiceMessageOneOfInternalImpl.class);

      Choice.Builder<?> builder;
      if (deserialized.callMessage().isPresent()) {
        builder = ChoiceCallMessage.builder().setMessage(deserialized.getCallMessage());
      } else if (deserialized.locationMessage().isPresent()) {
        builder = ChoiceLocationMessage.builder().setMessage(deserialized.getLocationMessage());
      } else if (deserialized.textMessage().isPresent()) {
        builder = ChoiceTextMessage.builder().setMessage(deserialized.getTextMessage());
      } else if (deserialized.urlMessage().isPresent()) {
        builder = ChoiceURLMessage.builder().setMessage(deserialized.getUrlMessage());
      } else {
        LOGGER.severe("Unexpected content'" + deserialized + "'");
        return null;
      }

      deserialized.postbackData().ifPresent(builder::setPostbackData);
      return builder.build();
    }
  }
}
