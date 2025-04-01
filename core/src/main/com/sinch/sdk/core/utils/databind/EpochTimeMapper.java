package com.sinch.sdk.core.utils.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sinch.sdk.core.models.OptionalValue;
import java.io.IOException;
import java.time.Instant;

public class EpochTimeMapper {

  public static class InstantToEpochSecondsStringSerializer
      extends JsonSerializer<OptionalValue<Instant>> {

    @Override
    public void serialize(
        OptionalValue<Instant> value, JsonGenerator jgen, SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      Instant instant = value.get();
      if (null == instant) {
        jgen.writeObject(null);
        return;
      }
      jgen.writeObject(Long.valueOf(value.get().getEpochSecond()).toString());
    }
  }
}
