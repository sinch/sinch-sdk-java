package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.FlowChannelSpecificMessageHeaderInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeader;
import java.io.IOException;

public class WhatsAppInteractiveHeaderMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(WhatsAppInteractiveHeader.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<WhatsAppInteractiveHeader> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<WhatsAppInteractiveHeader> vc) {
      super(vc);
    }

    @Override
    public WhatsAppInteractiveHeader deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      FlowChannelSpecificMessageHeaderInternalImpl deserialized =
          jp.readValueAs(FlowChannelSpecificMessageHeaderInternalImpl.class);
      return (WhatsAppInteractiveHeader) deserialized.getActualInstance();
    }
  }
}
