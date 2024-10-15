package com.sinch.sdk.domains.voice.api.v1.adapters.mapper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.models.v1.destination.Destination;
import com.sinch.sdk.domains.voice.models.v1.destination.internal.DestinationInternalImpl;
import java.io.IOException;
import java.util.logging.Logger;

public class DestinationMapper {

  private static final Logger LOGGER = Logger.getLogger(DestinationMapper.class.getName());

  public static void initMapper() {

    SimpleModule module = new SimpleModule();
    module.addDeserializer(Destination.class, new DestinationDeserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class DestinationDeserializer extends StdDeserializer<Destination> {

    public DestinationDeserializer() {
      this(null);
    }

    public DestinationDeserializer(Class<Destination> vc) {
      super(vc);
    }

    @Override
    public Destination deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

      DestinationInternalImpl read = jp.readValueAs(DestinationInternalImpl.class);

      if (null == read) {
        return null;
      }
      return (Destination) read.getActualInstance();
    }
  }
}
