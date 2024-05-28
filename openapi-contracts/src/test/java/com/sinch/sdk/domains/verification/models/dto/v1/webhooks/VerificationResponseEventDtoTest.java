package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.webhooks.CalloutRequestEventResponse;
import com.sinch.sdk.domains.verification.models.v1.webhooks.CalloutRequestEventResponseCalloutContent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.CalloutRequestEventResponseCalloutSpeechContent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.FlashCallRequestEventResponse;
import com.sinch.sdk.domains.verification.models.v1.webhooks.FlashCallRequestEventResponseFlashCallContent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.SMSRequestEventResponse;
import com.sinch.sdk.domains.verification.models.v1.webhooks.SMSRequestEventResponseSMSContent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEventResponseAction;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationResponseEventDtoTest extends BaseTest {

  public static CalloutRequestEventResponse expectedCalloutRequestEventResponseDto =
      CalloutRequestEventResponse.builder()
          .setAction(VerificationEventResponseAction.DENY)
          .setCallout(
              CalloutRequestEventResponseCalloutContent.builder()
                  .setCode("4567")
                  .setSpeech(
                      CalloutRequestEventResponseCalloutSpeechContent.builder()
                          .setLocale("the locale")
                          .build())
                  .build())
          .build();
  public static FlashCallRequestEventResponse expectedFlashCallRequestEventResponseDto =
      FlashCallRequestEventResponse.builder()
          .setAction(VerificationEventResponseAction.DENY)
          .setFlashCall(
              FlashCallRequestEventResponseFlashCallContent.builder()
                  .setCli("cli code")
                  .setDialTimeout(123)
                  .build())
          .build();
  public static SMSRequestEventResponse expectedSMSRequestEventResponseDto =
      SMSRequestEventResponse.builder()
          .setAction(VerificationEventResponseAction.DENY)
          .setSms(
              SMSRequestEventResponseSMSContent.builder()
                  .setCode("5666")
                  .setAcceptLanguage(Collections.singletonList("a language"))
                  .build())
          .build();

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

    SMSRequestEventResponse value =
        SMSRequestEventResponse.builder().setAction(VerificationEventResponseAction.ALLOW).build();

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

    FlashCallRequestEventResponse value =
        FlashCallRequestEventResponse.builder()
            .setAction(VerificationEventResponseAction.ALLOW)
            .build();

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

    CalloutRequestEventResponse value =
        CalloutRequestEventResponse.builder()
            .setAction(VerificationEventResponseAction.ALLOW)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseCalloutEmptyCallout, serializedString, true);
  }
}
