package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.internal.VoiceConfigurationInternalImpl;
import java.io.IOException;
import java.util.logging.Logger;

public class VoiceConfigurationMapper {
  private static final Logger LOGGER = Logger.getLogger(VoiceConfigurationMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addDeserializer(VoiceConfiguration.class, new VoiceConfigurationDeserializer());
    Mapper.getInstance().registerModule(module);
  }

  private static final class VoiceConfigurationDeserializer
      extends StdDeserializer<VoiceConfiguration> {

    private static final long serialVersionUID = 1L;

    public VoiceConfigurationDeserializer() {
      this(VoiceConfiguration.class);
    }

    public VoiceConfigurationDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public VoiceConfiguration deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VoiceConfigurationInternalImpl internal =
          Mapper.getInstance().readValue(jp, VoiceConfigurationInternalImpl.class);
      return (VoiceConfiguration) internal.getActualInstance();
    }
  }
}
