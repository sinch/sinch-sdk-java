package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequestImpl;
import java.io.IOException;

public class SendMessageRequestMapper {

  public static void initMapper() {
    Mapper.getInstance()
        .addMixIn(SendMessageRequestImpl.class, SendMessageRequestMapperMixin.class);
  }

  public static class SendMessageRequestMapperMixin<T extends AppMessage>
      extends SendMessageRequestImpl<T> {

    @Override
    @JsonSerialize(using = TTLSerializer.class)
    public OptionalValue<Integer> ttl() {
      return super.ttl();
    }

    /**
     * Serializer TTL value ttl values are defined as Integer for ease of use from SDK but unto
     * serialize/deserialize: it had to be managed as String with a trailing `s` as "seconds"
     */
    static class TTLSerializer extends JsonSerializer<OptionalValue<Integer>> {

      public TTLSerializer() {
        super();
      }

      @Override
      public void serialize(
          OptionalValue<Integer> value, JsonGenerator jgen, SerializerProvider provider)
          throws IOException {
        if (value.isPresent()) {
          jgen.writeObject(String.format("%ds", value.get()));
        }
      }
    }
  }
}
