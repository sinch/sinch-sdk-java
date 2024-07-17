package com.sinch.sdk.domains.conversation.api.v1.adapters.events.contactmessage.internal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.events.contactmessage.ContactMessageEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.contactmessage.internal.ContactMessageEventInternalImpl;
import java.io.IOException;

public class ContactMessageEventMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(ContactMessageEvent.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<ContactMessageEvent> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<ContactMessageEvent> vc) {
      super(vc);
    }

    @Override
    public ContactMessageEvent deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      Object deserialized =
          jp.readValueAs(ContactMessageEventInternalImpl.class).getActualInstance();
      return (ContactMessageEvent) deserialized;
    }
  }
}
