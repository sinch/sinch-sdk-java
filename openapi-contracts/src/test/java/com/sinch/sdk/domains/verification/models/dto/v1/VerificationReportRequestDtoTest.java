package com.sinch.sdk.domains.verification.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationReportRequestDtoTest extends BaseTest {

  public static VerificationReportRequestResourceDto verificationReportCalloutDto =
      new VerificationReportRequestResourceDto(
          new CalloutVerificationReportRequestDto()
              .method(VerificationMethodDto.CALLOUT.getValue())
              .callout(new CalloutVerificationReportRequestCalloutDto().code("foo code")));
  public static VerificationReportRequestResourceDto verificationReportFlashCallDto =
      new VerificationReportRequestResourceDto(
          new FlashcallVerificationReportRequestDto()
              .method(VerificationMethodDto.FLASHCALL.getValue())
              .flashCall(new FlashcallVerificationReportRequestFlashCallDto().cli("foo cli")));
  public static VerificationReportRequestResourceDto verificationReportSMSDto =
      new VerificationReportRequestResourceDto(
          new SmsVerificationReportRequestDto()
              .method(VerificationMethodDto.SMS.getValue())
              .sms(new SmsVerificationReportRequestSmsDto().code("foo code").cli("foo cli")));

  @GivenTextResource("/domains/verification/v1/VerificationReportCalloutRequestDto.json")
  String jsonVerificationReportCallout;

  @GivenTextResource("/domains/verification/v1/VerificationReportFlashCallRequestDto.json")
  String jsonVerificationReportFlashCall;

  @GivenTextResource("/domains/verification/v1/VerificationReportSMSRequestDto.json")
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
