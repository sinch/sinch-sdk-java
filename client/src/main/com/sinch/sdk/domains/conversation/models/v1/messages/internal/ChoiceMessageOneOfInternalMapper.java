package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.CallMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.Choice;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceCallMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceLocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceTextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceURLMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.DelegatedMappers.DelegatedLocationDeSerializer;
import com.sinch.sdk.domains.conversation.models.v1.messages.DelegatedMappers.DelegatedLocationSerializer;
import com.sinch.sdk.domains.conversation.models.v1.messages.DelegatedMappers.DelegatedTextSerializer;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.UrlMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ChoiceMessageOneOfInternalImpl.Builder;
import java.io.IOException;
import java.util.logging.Logger;

public class ChoiceMessageOneOfInternalMapper {

  private static final Logger LOGGER =
      Logger.getLogger(ChoiceMessageOneOfInternalMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addSerializer(ChoiceImpl.class, new ChoiceSerializer())
            .addDeserializer(Choice.class, new ChoiceDeserializer());
    Mapper.getInstance()
        .addMixIn(ChoiceMessage.class, ChoiceMessageMixinSerializer.class)
        .addMixIn(ChoiceMessage.Builder.class, ChoiceMessageMixinDeserializer.class)
        .addMixIn(ChoiceMessageOneOfInternalImpl.class, ChoiceMixinSerializer.class)
        .addMixIn(Builder.class, ChoiceMixinDeserializer.class)
        .registerModule(module);
  }

  static class ChoiceMixinSerializer extends ChoiceMessageOneOfInternalImpl {

    @Override
    @JsonSerialize(using = DelegatedTextSerializer.class)
    public OptionalValue<TextMessage> textMessage() {
      return super.textMessage();
    }

    @Override
    @JsonSerialize(using = DelegatedLocationSerializer.class)
    public OptionalValue<LocationMessage> locationMessage() {
      return super.locationMessage();
    }
  }

  static class ChoiceMessageMixinSerializer extends ChoiceMessageImpl {

    @Override
    @JsonSerialize(using = DelegatedTextSerializer.class)
    public OptionalValue<TextMessage> textMessage() {
      return super.textMessage();
    }
  }

  static class ChoiceMixinDeserializer extends Builder {

    @Override
    @JsonDeserialize(using = ChoiceMixinTextDeSerializer.class)
    public Builder setTextMessage(TextMessage message) {
      return super.setTextMessage(message);
    }

    @Override
    @JsonDeserialize(using = DelegatedLocationDeSerializer.class)
    public Builder setLocationMessage(LocationMessage message) {
      return super.setLocationMessage(message);
    }
  }

  static class ChoiceMessageMixinDeserializer extends Builder {

    @Override
    @JsonDeserialize(using = ChoiceMixinTextDeSerializer.class)
    public Builder setTextMessage(TextMessage message) {
      return super.setTextMessage(message);
    }
  }

  static class ChoiceSerializer extends StdSerializer<ChoiceImpl> {

    public ChoiceSerializer() {
      this(null);
    }

    public ChoiceSerializer(Class<ChoiceImpl> t) {
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

  static class ChoiceDeserializer extends StdDeserializer<Choice<?>> {

    public ChoiceDeserializer() {
      this(null);
    }

    public ChoiceDeserializer(Class<Choice> vc) {
      super(vc);
    }

    @Override
    public Choice<?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      ChoiceMessageOneOfInternalImpl deserialized;

      try {
        deserialized = jp.readValueAs(ChoiceMessageOneOfInternalImpl.class);
      } catch (Exception e) {
        LOGGER.info("error " + e);
        return null;
      }

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

  static class ChoiceMixinTextDeSerializer extends JsonDeserializer<TextMessage> {

    @Override
    public TextMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      TextMessage.Builder builder = TextMessage.builder();
      TextMessageInternalImpl deserialized = jp.readValueAs(TextMessageInternalImpl.class);
      deserialized.text().ifPresent(builder::setText);
      return builder.build();
    }
  }
}
