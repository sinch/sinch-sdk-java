package com.sinch.sdk.domains.verification.models.v1.report.response;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.verification.models.v1.report.response.internal.VerificationReportResponseInternalImpl;
import java.io.IOException;

public class VerificationReportResponseMapper {

  public static void initMapper() {
    SimpleModule module =
        new SimpleModule().addDeserializer(VerificationReportResponse.class, new Deserializer());
    Mapper.getInstance().registerModule(module);
  }

  static class Deserializer extends StdDeserializer<VerificationReportResponse> {

    public Deserializer() {
      this(null);
    }

    public Deserializer(Class<VerificationReportResponse> vc) {
      super(vc);
    }

    @Override
    public VerificationReportResponse deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      VerificationReportResponseInternalImpl deserialized =
          jp.readValueAs(VerificationReportResponseInternalImpl.class);
      return (VerificationReportResponse) deserialized.getActualInstance();
    }
  }
}
