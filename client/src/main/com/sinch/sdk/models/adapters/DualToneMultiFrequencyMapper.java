package com.sinch.sdk.models.adapters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.models.DualToneMultiFrequency;
import java.io.IOException;
import java.util.logging.Logger;

public class DualToneMultiFrequencyMapper {
  private static final Logger LOGGER =
      Logger.getLogger(DualToneMultiFrequencyMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addSerializer(DualToneMultiFrequency.class, new Serializer())
            .addDeserializer(DualToneMultiFrequency.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Serializer extends StdSerializer<DualToneMultiFrequency> {

    public Serializer() {
      this(null);
    }

    public Serializer(Class<DualToneMultiFrequency> t) {
      super(t);
    }

    @Override
    public void serialize(
        DualToneMultiFrequency raw, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {
      if (null == raw) {
        // avoid exception
        LOGGER.severe("Unexpected type'" + raw + "'");
        return;
      }
      jgen.writeObject(raw.stringValue());
    }
  }

  static final class Deserializer extends StdDeserializer<DualToneMultiFrequency> {

    private static final long serialVersionUID = 1L;

    public Deserializer() {
      this(DualToneMultiFrequency.class);
    }

    public Deserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public DualToneMultiFrequency deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      String strValue = Mapper.getInstance().readValue(jp, String.class);
      return DualToneMultiFrequency.valueOf(strValue);
    }
  }
}
