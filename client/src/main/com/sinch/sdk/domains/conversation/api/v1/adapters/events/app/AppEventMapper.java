package com.sinch.sdk.domains.conversation.api.v1.adapters.events.app;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.events.app.AppEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.app.internal.AppEventInternalImpl;
import java.io.IOException;

public class AppEventMapper {

  public static void initMapper() {
    SimpleModule module = new SimpleModule().addDeserializer(AppEvent.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<AppEvent> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<AppEvent> vc) {
      super(vc);
    }

    @Override
    public AppEvent deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      AppEventInternalImpl deserialized = jp.readValueAs(AppEventInternalImpl.class);
      return (AppEvent) deserialized.getActualInstance();
    }
  }
}
