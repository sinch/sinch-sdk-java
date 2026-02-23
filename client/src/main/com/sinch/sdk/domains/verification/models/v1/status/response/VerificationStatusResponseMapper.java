package com.sinch.sdk.domains.verification.models.v1.status.response;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.verification.models.v1.status.response.internal.VerificationStatusResponseInternalImpl;
import java.io.IOException;

public class VerificationStatusResponseMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(VerificationStatusResponse.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<VerificationStatusResponse> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<VerificationStatusResponse> vc) {
      super(vc);
    }

    @Override
    public VerificationStatusResponse deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationStatusResponseInternalImpl deserialized =
          jp.readValueAs(VerificationStatusResponseInternalImpl.class);
      return (VerificationStatusResponse) deserialized.getActualInstance();
    }
  }
}
