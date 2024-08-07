package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessageContent;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.internal.ChannelSpecificContactMessageMessageMessageInternalImpl;
import java.io.IOException;

public class ChannelSpecificContactMessageMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addDeserializer(ChannelSpecificContactMessageContent.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<ChannelSpecificContactMessageContent> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<ChannelSpecificContactMessage> vc) {
      super(vc);
    }

    @Override
    public ChannelSpecificContactMessageContent deserialize(
        JsonParser jp, DeserializationContext ctxt) throws IOException {

      ChannelSpecificContactMessageMessageMessageInternalImpl deserialized =
          jp.readValueAs(ChannelSpecificContactMessageMessageMessageInternalImpl.class);
      return (ChannelSpecificContactMessageContent) deserialized.getActualInstance();
    }
  }
}
