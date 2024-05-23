package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutRequestEventResponseCalloutDto;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutRequestEventResponseCalloutSpeechDto;
import com.sinch.sdk.domains.verification.models.dto.v1.CalloutRequestEventResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashCallRequestEventResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.FlashCallRequestEventResponseFlashCallDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SMSRequestEventResponseDto;
import com.sinch.sdk.domains.verification.models.dto.v1.SMSRequestEventResponseSmsDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationEventResponseActionDto;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationResponseEventDtoTest extends BaseTest {

  public static CalloutRequestEventResponseDto expectedCalloutRequestEventResponseDto =
      new CalloutRequestEventResponseDto()
          .action(VerificationEventResponseActionDto.DENY)
          .callout(
              new CalloutRequestEventResponseCalloutDto()
                  .code("4567")
                  .speech(new CalloutRequestEventResponseCalloutSpeechDto().locale("the locale")));
  public static FlashCallRequestEventResponseDto expectedFlashCallRequestEventResponseDto =
      new FlashCallRequestEventResponseDto()
          .action(VerificationEventResponseActionDto.DENY)
          .flashCall(
              new FlashCallRequestEventResponseFlashCallDto().cli("cli code").dialTimeout(123));
  public static SMSRequestEventResponseDto expectedSMSRequestEventResponseDto =
      new SMSRequestEventResponseDto()
          .action(VerificationEventResponseActionDto.DENY)
          .sms(
              new SMSRequestEventResponseSmsDto()
                  .code("5666")
                  .acceptLanguage(Collections.singletonList("a language")));

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponseSMS.json")
  String jsonResponseSMS;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponseSMSEmptySMS.json")
  String jsonResponseSMSEmptySMS;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponseFlashCall.json")
  String jsonResponseFlashCall;

  @GivenTextResource(
      "/domains/verification/v1/webhooks/VerificationResponseFlashCallEmptyFlashCall.json")
  String jsonResponseFlashCallEmptyFlashCall;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponseCallout.json")
  String jsonResponseCallout;

  @GivenTextResource(
      "/domains/verification/v1/webhooks/VerificationResponseCalloutEmptyCallout.json")
  String jsonResponseCalloutEmptyCallout;

  @Test
  void serializeSMSResponse() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(expectedSMSRequestEventResponseDto);

    JSONAssert.assertEquals(jsonResponseSMS, serializedString, true);
  }

  @Test
  void serializeSMSResponseEmptySms() throws JsonProcessingException, JSONException {

    FlashCallRequestEventResponseDto value =
        new FlashCallRequestEventResponseDto().action(VerificationEventResponseActionDto.ALLOW);

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseSMSEmptySMS, serializedString, true);
  }

  @Test
  void serializeFlashCallResponse() throws JsonProcessingException, JSONException {

    String serializedString =
        objectMapper.writeValueAsString(expectedFlashCallRequestEventResponseDto);

    JSONAssert.assertEquals(jsonResponseFlashCall, serializedString, true);
  }

  @Test
  void serializeFlashCallResponseEmptyFlashCall() throws JsonProcessingException, JSONException {

    FlashCallRequestEventResponseDto value =
        new FlashCallRequestEventResponseDto().action(VerificationEventResponseActionDto.ALLOW);

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseFlashCallEmptyFlashCall, serializedString, true);
  }

  @Test
  void serializeCalloutResponse() throws JsonProcessingException, JSONException {

    String serializedString =
        objectMapper.writeValueAsString(expectedCalloutRequestEventResponseDto);

    JSONAssert.assertEquals(jsonResponseCallout, serializedString, true);
  }

  @Test
  void serializeCalloutResponseEmptyCallout() throws JsonProcessingException, JSONException {

    CalloutRequestEventResponseDto value =
        new CalloutRequestEventResponseDto().action(VerificationEventResponseActionDto.ALLOW);

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseCalloutEmptyCallout, serializedString, true);
  }
}
