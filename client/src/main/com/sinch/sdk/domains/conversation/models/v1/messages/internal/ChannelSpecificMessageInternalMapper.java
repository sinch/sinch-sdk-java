package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificMessage;
import java.io.IOException;

public class ChannelSpecificMessageInternalMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(ChannelSpecificMessage.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<ChannelSpecificMessage> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<ChannelSpecificMessageInternal> vc) {
      super(vc);
    }

    @Override
    public ChannelSpecificMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ChannelSpecificMessageMessageInternalImpl deserialized =
          (ChannelSpecificMessageMessageInternalImpl)
              jp.readValueAs(ChannelSpecificMessageMessageInternal.class);
      return (ChannelSpecificMessage) deserialized.getActualInstance();
    }
  }
}
