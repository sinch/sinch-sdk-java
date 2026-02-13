package com.sinch.sdk.domains.verification.models.v1.start.response;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.verification.models.v1.start.response.internal.VerificationStartResponseInternalImpl;
import java.io.IOException;

public class VerificationStartResponseMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(VerificationStartResponse.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<VerificationStartResponse> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<VerificationStartResponse> vc) {
      super(vc);
    }

    @Override
    public VerificationStartResponse deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationStartResponseInternalImpl deserialized =
          jp.readValueAs(VerificationStartResponseInternalImpl.class);
      return (VerificationStartResponse) deserialized.getActualInstance();
    }
  }
}
