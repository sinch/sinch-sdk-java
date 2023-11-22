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

  @GivenTextResource("/domains/verification/v1/VerificationReportCalloutRequestDto.json")
  String jsonVerificationReportCallout;

  public static VerificationReportRequestResourceDto verificationReportCalloutDto =
      new VerificationReportRequestResourceDto()
          .method(VerificationMethodDto.CALLOUT)
          .callout(
              new VerificationReportRequestResourceCalloutDto(
                  new CalloutVerificationReportRequestDto().code("foo code")));

  @GivenTextResource("/domains/verification/v1/VerificationReportFlashCallRequestDto.json")
  String jsonVerificationReportFlashCall;

  public static VerificationReportRequestResourceDto verificationReportFlashCallDto =
      new VerificationReportRequestResourceDto()
          .method(VerificationMethodDto.FLASHCALL)
          .flashcall(
              new VerificationReportRequestResourceFlashcallDto(
                  new FlashcallVerificationReportRequestDto().cli("foo cli")));

  @GivenTextResource("/domains/verification/v1/VerificationReportSMSRequestDto.json")
  String jsonVerificationReportSMS;

  public static VerificationReportRequestResourceDto verificationReportSMSDto =
      new VerificationReportRequestResourceDto()
          .method(VerificationMethodDto.SMS)
          .sms(
              new VerificationReportRequestResourceSmsDto(
                  new SmsVerificationReportRequestDto().code("foo code").cli("foo cli")));

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
