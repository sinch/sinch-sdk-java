package com.sinch.sdk.domains.verification.models.dto.v1.report;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestInternalImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationReportRequestDtoTest extends BaseTest {

  public static VerificationReportRequestInternalImpl verificationReportPhoneCallDto =
      new VerificationReportRequestInternalImpl(
          (VerificationReportRequestPhoneCallImpl)
              VerificationReportRequestPhoneCall.builder().setCode("foo code").build());

  public static VerificationReportRequestInternalImpl verificationReportFlashCallDto =
      new VerificationReportRequestInternalImpl(
          (VerificationReportRequestFlashCallImpl)
              VerificationReportRequestFlashCall.builder().setCli("foo cli").build());
  public static VerificationReportRequestInternalImpl verificationReportSmsDto =
      new VerificationReportRequestInternalImpl(
          (VerificationReportRequestSmsImpl)
              VerificationReportRequestSms.builder().setCode("foo code").setCli("foo cli").build());

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
