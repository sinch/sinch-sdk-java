package com.sinch.sdk.domains.conversation.api.v1.adapters.events.contacts.internal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.events.contact.ContactEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.contact.internal.ContactEventInternalImpl;
import java.io.IOException;

public class ContactEventMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(ContactEvent.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<ContactEvent> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<ContactEvent> vc) {
      super(vc);
    }

    @Override
    public ContactEvent deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      ContactEventInternalImpl deserialized = jp.readValueAs(ContactEventInternalImpl.class);
      return (ContactEvent) deserialized.getActualInstance();
    }
  }
}
