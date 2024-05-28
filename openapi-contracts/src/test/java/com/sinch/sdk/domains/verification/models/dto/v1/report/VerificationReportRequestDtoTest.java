package com.sinch.sdk.domains.verification.models.dto.v1.report;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersCallout;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersCalloutImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersCalloutOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCallOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSMS;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSMSImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSMSOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestParametersInternal;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestParametersInternalImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationReportRequestDtoTest extends BaseTest {

  public static VerificationReportRequestParametersInternal verificationReportCalloutDto =
      new VerificationReportRequestParametersInternalImpl(
          (VerificationReportRequestParametersCalloutImpl)
              VerificationReportRequestParametersCallout.builder()
                  .setMethod(VerificationReportRequestParametersCallout.MethodEnum.CALLOUT)
                  .setCallout(
                      VerificationReportRequestParametersCalloutOptions.builder()
                          .setCode("foo code")
                          .build())
                  .build());
  public static VerificationReportRequestParametersInternal verificationReportFlashCallDto =
      new VerificationReportRequestParametersInternalImpl(
          (VerificationReportRequestParametersFlashCallImpl)
              VerificationReportRequestParametersFlashCall.builder()
                  .setMethod(VerificationReportRequestParametersFlashCall.MethodEnum.FLASHCALL)
                  .setFlashCall(
                      VerificationReportRequestParametersFlashCallOptions.builder()
                          .setCli("foo cli")
                          .build())
                  .build());
  public static VerificationReportRequestParametersInternal verificationReportSMSDto =
      new VerificationReportRequestParametersInternalImpl(
          (VerificationReportRequestParametersSMSImpl)
              VerificationReportRequestParametersSMS.builder()
                  .setMethod(VerificationReportRequestParametersSMS.MethodEnum.SMS)
                  .setSms(
                      VerificationReportRequestParametersSMSOptions.builder()
                          .setCode("foo code")
                          .setCli("foo cli")
                          .build())
                  .build());

  @GivenTextResource("/domains/verification/v1/report/VerificationReportCalloutRequestDto.json")
  String jsonVerificationReportCallout;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportFlashCallRequestDto.json")
  String jsonVerificationReportFlashCall;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportSMSRequestDto.json")
  String jsonVerificationReportSMS;

  @Test
  void serializeCallout() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(verificationReportCalloutDto);

    JSONAssert.assertEquals(jsonVerificationReportCallout, serializedString, true);
  }

  @Test
  void serializeFlashCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(verificationReportFlashCallDto);

    JSONAssert.assertEquals(jsonVerificationReportFlashCall, serializedString, true);
  }

  @Test
  void serializeSMS() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(verificationReportSMSDto);

    JSONAssert.assertEquals(jsonVerificationReportSMS, serializedString, true);
  }
}
