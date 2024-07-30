package com.sinch.sdk.domains.conversation.models.v1.messages.types.media;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sinch.sdk.core.models.OptionalValue;
import java.io.IOException;

public class DelegatedMapper {

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
}
