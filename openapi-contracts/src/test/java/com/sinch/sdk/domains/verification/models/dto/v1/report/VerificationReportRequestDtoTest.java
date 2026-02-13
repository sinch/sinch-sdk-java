package com.sinch.sdk.domains.verification.models.dto.v1.report;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestWhatsApp;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationReportRequestDtoTest extends BaseTest {

  public static VerificationReportRequestPhoneCall verificationReportPhoneCallDto =
      VerificationReportRequestPhoneCall.builder().setCode("foo code").build();

  public static VerificationReportRequestFlashCall verificationReportFlashCallDto =
      VerificationReportRequestFlashCall.builder().setCli("foo cli").build();

  public static VerificationReportRequestSms verificationReportSmsDto =
      VerificationReportRequestSms.builder().setCode("foo code").build();

  public static VerificationReportRequestWhatsApp verificationReportWhatsAppDto =
      VerificationReportRequestWhatsApp.builder().setCode("foo code").build();

  @GivenTextResource("/domains/verification/v1/report/VerificationReportRequestPhoneCallDto.json")
  String jsonVerificationReportPhoneCall;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportRequestFlashCallDto.json")
  String jsonVerificationReportFlashCall;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportRequestSmsDto.json")
  String jsonVerificationReportSms;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportRequestWhatsAppDto.json")
  String jsonVerificationReportWhatsApp;

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

  @Test
  void serializeWhatsApp() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(verificationReportWhatsAppDto);

    JSONAssert.assertEquals(jsonVerificationReportWhatsApp, serializedString, true);
  }
}
