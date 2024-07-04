package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning;
import com.sinch.sdk.domains.numbers.models.v1.internal.ScheduledVoiceProvisioningInternalImpl;
import java.io.IOException;
import java.util.logging.Logger;

public class ScheduledVoiceProvisioningMapper {
  private static final Logger LOGGER =
      Logger.getLogger(ScheduledVoiceProvisioningMapper.class.getName());

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule()
            .addDeserializer(
                ScheduledVoiceProvisioning.class, new ScheduledVoiceProvisioningDeserializer());
    Mapper.getInstance().registerModule(module);
  }

  private static final class ScheduledVoiceProvisioningDeserializer
      extends StdDeserializer<ScheduledVoiceProvisioning> {

    private static final long serialVersionUID = 1L;

    public ScheduledVoiceProvisioningDeserializer() {
      this(ScheduledVoiceProvisioning.class);
    }

    public ScheduledVoiceProvisioningDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ScheduledVoiceProvisioning deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      ScheduledVoiceProvisioningInternalImpl internal =
          Mapper.getInstance().readValue(jp, ScheduledVoiceProvisioningInternalImpl.class);
      return (ScheduledVoiceProvisioning) internal.getActualInstance();
    }
  }
}
