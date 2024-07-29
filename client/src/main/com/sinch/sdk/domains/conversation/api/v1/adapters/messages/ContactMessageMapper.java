package com.sinch.sdk.domains.conversation.api.v1.adapters.messages;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ContactMessageInternalImpl;
import java.io.IOException;

public class ContactMessageMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(ContactMessage.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<ContactMessage> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<ContactMessage> vc) {
      super(vc);
    }

    @Override
    public ContactMessage deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      Object deserialized = jp.readValueAs(ContactMessageInternalImpl.class).getActualInstance();
      return (ContactMessage) deserialized;
    }
  }
}
