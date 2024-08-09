package com.sinch.sdk.domains.conversation.models.v1.messages.types.choice;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.call.CallMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.call.CallMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice.Builder;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ChoiceMessageOneOfInternal;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ChoiceMessageOneOfInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.url.UrlMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.url.UrlMessageImpl;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

// @JsonFilter("uninitializedFilter")
@JsonSerialize(using = ChoiceImpl.ChoiceSerializer.class)
public class ChoiceImpl<T extends ChoiceMessageType> implements Choice<T> {

  private static final Logger LOGGER = Logger.getLogger(ChoiceImpl.class.getName());

  private final OptionalValue<T> message;

  private final OptionalValue<Object> postbackData;

  public ChoiceImpl(OptionalValue<T> message, OptionalValue<Object> postbackData) {
    this.message = message;
    this.postbackData = postbackData;
  }

  public T getMessage() {
    return message.orElse(null);
  }

  public OptionalValue<T> message() {
    return message;
  }

  public Object getPostbackData() {
    return postbackData.orElse(null);
  }

  public OptionalValue<Object> postbackData() {
    return postbackData;
  }

  @Override
  public String toString() {
    return "ChoiceImpl{" + "message=" + message + ", postbackData=" + postbackData + '}';
  }

  /** Dedicated Builder */
  static class Builder<T extends ChoiceMessageType> implements Choice.Builder<T> {

    OptionalValue<T> message = OptionalValue.empty();

    OptionalValue<Object> postbackData = OptionalValue.empty();

    public Builder<T> setMessage(T message) {
      this.message = OptionalValue.of(message);
      return this;
    }

    public Builder<T> setPostbackData(Object postbackData) {
      this.postbackData = OptionalValue.of(postbackData);
      return this;
    }

    public ChoiceImpl<T> build() {
      return new ChoiceImpl<>(message, postbackData);
    }
  }

  static class ChoiceSerializer extends StdSerializer<Choice<?>> {

    public ChoiceSerializer() {
      this(null);
    }

    public ChoiceSerializer(Class<Choice<?>> t) {
      super(t);
    }

    @Override
    public void serialize(Choice raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      ChoiceImpl<?> value = (ChoiceImpl<?>) raw;
      ChoiceMessageOneOfInternal.Builder internal = ChoiceMessageOneOfInternal.builder();

      value.postbackData().ifPresent(internal::setPostbackData);
      value
          .message()
          .ifPresent(
              m -> {
                if (m instanceof CallMessage) {
                  internal.setCallMessage(((CallMessageImpl) m).getCallMessage());
                } else if (m instanceof LocationMessage) {
                  internal.setLocationMessage(((LocationMessageImpl) m).getLocationMessage());
                } else if (m instanceof TextMessage) {
                  internal.setTextMessage(((TextMessageImpl) m).getTextMessage());
                } else if (m instanceof UrlMessage) {
                  internal.setUrlMessage(((UrlMessageImpl) m).getUrlMessage());
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

    public ChoiceDeserializer(Class<ChoiceImpl<?>> vc) {
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

      Choice.Builder<?> builder = null;
      if (deserialized.callMessage().isPresent()) {
        Optional<CallMessage> message =
            CallMessageImpl.delegatedConverter(deserialized.getCallMessage());
        if (message.isPresent()) {
          builder = Choice.<CallMessage>builder().setMessage(message.get());
        }
      } else if (deserialized.locationMessage().isPresent()) {
        Optional<LocationMessage> message =
            LocationMessageImpl.delegatedConverter(deserialized.getLocationMessage());
        if (message.isPresent()) {
          builder = Choice.<LocationMessage>builder().setMessage(message.get());
        }
      } else if (deserialized.textMessage().isPresent()) {
        Optional<TextMessage> message =
            TextMessageImpl.delegatedConverter(deserialized.getTextMessage());
        if (message.isPresent()) {
          builder = Choice.<TextMessage>builder().setMessage(message.get());
        }
      } else if (deserialized.urlMessage().isPresent()) {
        Optional<UrlMessage> message =
            UrlMessageImpl.delegatedConverter(deserialized.getUrlMessage());
        if (message.isPresent()) {
          builder = Choice.<UrlMessage>builder().setMessage(message.get());
        }
      } else {
        LOGGER.severe("Unexpected content'" + deserialized + "'");
        return null;
      }
      deserialized.postbackData().ifPresent(builder::setPostbackData);
      return builder.build();
    }
  }

  /*static class ChoiceDeserializerPOC extends StdDeserializer<Choice<?>> {

    public ChoiceDeserializerPOC() {
      this(null);
    }

    public ChoiceDeserializerPOC(Class<ChoiceImpl<?>> vc) {
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
        builder = Choice.<CallMessage>builder().setMessage(deserialized.getCallMessage());
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
  }*/
}
