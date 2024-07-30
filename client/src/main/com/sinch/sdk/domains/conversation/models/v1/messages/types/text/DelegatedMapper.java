package com.sinch.sdk.domains.conversation.models.v1.messages.types.text;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sinch.sdk.core.models.OptionalValue;
import java.io.IOException;

public class DelegatedMapper {

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
