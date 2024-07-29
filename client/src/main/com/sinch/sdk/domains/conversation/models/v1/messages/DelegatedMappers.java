package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.LocationMessageInternalImpl;
import java.io.IOException;

public class DelegatedMappers {

  public static class DelegatedLocationSerializer
      extends JsonSerializer<OptionalValue<LocationMessage>> {

    @Override
    public void serialize(
        OptionalValue<LocationMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      LocationMessageImpl impl = (LocationMessageImpl) value.get();
      jgen.writeObject(impl.getLocationMessage());
    }
  }

  public static class DelegatedLocationDeSerializer extends JsonDeserializer<LocationMessage> {

    @Override
    public LocationMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      LocationMessageImpl.Builder builder = new LocationMessageImpl.Builder();
      LocationMessageInternalImpl deserialized = jp.readValueAs(LocationMessageInternalImpl.class);
      builder.setLocationMessage(deserialized);
      return builder.build();
    }
  }

  public static class DelegatedMediaSerializer extends JsonSerializer<OptionalValue<MediaMessage>> {

    @Override
    public void serialize(
        OptionalValue<MediaMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      MediaMessageImpl impl = (MediaMessageImpl) value.get();
      jgen.writeObject(impl.getMediaMessage());
    }
  }

  public static class DelegatedTextSerializer extends JsonSerializer<OptionalValue<TextMessage>> {

    @Override
    public void serialize(
        OptionalValue<TextMessage> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      TextMessageImpl impl = (TextMessageImpl) value.get();
      jgen.writeObject(impl.getTextMessage());
    }
  }
}
