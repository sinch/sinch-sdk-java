package com.sinch.sdk.domains.verification.models.dto.v1.report;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersFlashCallOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersPhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersPhoneCallOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSms;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestParametersSmsOptions;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestParametersInternal;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestParametersInternalImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationReportRequestDtoTest extends BaseTest {

  public static VerificationReportRequestParametersInternal verificationReportPhoneCallDto =
      new VerificationReportRequestParametersInternalImpl(
          (VerificationReportRequestParametersPhoneCallImpl)
              VerificationReportRequestParametersPhoneCall.builder()
                  .setMethod(VerificationReportRequestParametersPhoneCall.MethodEnum.CALLOUT)
                  .setCallout(
                      VerificationReportRequestParametersPhoneCallOptions.builder()
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
  public static VerificationReportRequestParametersInternal verificationReportSmsDto =
      new VerificationReportRequestParametersInternalImpl(
          (VerificationReportRequestParametersSmsImpl)
              VerificationReportRequestParametersSms.builder()
                  .setMethod(VerificationReportRequestParametersSms.MethodEnum.SMS)
                  .setSms(
                      VerificationReportRequestParametersSmsOptions.builder()
                          .setCode("foo code")
                          .setCli("foo cli")
                          .build())
                  .build());

  @GivenTextResource("/domains/verification/v1/report/VerificationReportPhoneCallRequestDto.json")
  String jsonVerificationReportPhoneCall;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportFlashCallRequestDto.json")
  String jsonVerificationReportFlashCall;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportSmsRequestDto.json")
  String jsonVerificationReportSms;

  @Test
  void serializePhoneCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(verificationReportPhoneCallDto);

    JSONAssert.assertEquals(jsonVerificationReportPhoneCall, serializedString, true);
  }

  @Test
  void serializeFlashCall() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(verificationReportFlashCallDto);

    JSONAssert.assertEquals(jsonVerificationReportFlashCall, serializedString, true);
  }

  @Test
  void serializeSms() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(verificationReportSmsDto);

    JSONAssert.assertEquals(jsonVerificationReportSms, serializedString, true);
  }
}
