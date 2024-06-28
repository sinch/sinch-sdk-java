package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEventResponseAction;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponseSms;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationResponseEventDtoTest extends VerificationBaseTest {

  public static VerificationRequestEventResponsePhoneCall expectedPhoneCallRequestEventResponseDto =
      VerificationRequestEventResponsePhoneCall.builder()
          .setAction(VerificationEventResponseAction.ALLOW)
          .setCode("4567")
          .setSpeech(PhoneCallSpeech.builder().setLocale("the locale").build())
          .build();
  public static VerificationRequestEventResponseFlashCall expectedFlashCallRequestEventResponseDto =
      VerificationRequestEventResponseFlashCall.builder()
          .setAction(VerificationEventResponseAction.ALLOW)
          .setCli("cli code")
          .setDialTimeout(123)
          .build();
  public static VerificationRequestEventResponseSms expectedSmsRequestEventResponseDto =
      VerificationRequestEventResponseSms.builder()
          .setAction(VerificationEventResponseAction.ALLOW)
          .setCode("5666")
          .setAcceptLanguage(Collections.singletonList("a language"))
          .build();

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponseSms.json")
  String jsonResponseSms;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponseSmsEmptySms.json")
  String jsonResponseSmsEmptySms;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponseFlashCall.json")
  String jsonResponseFlashCall;

  @GivenTextResource(
      "/domains/verification/v1/webhooks/VerificationResponseFlashCallEmptyFlashCall.json")
  String jsonResponseFlashCallEmptyFlashCall;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponsePhoneCall.json")
  String jsonResponsePhoneCall;

  @GivenTextResource(
      "/domains/verification/v1/webhooks/VerificationResponsePhoneCallEmptyCallout.json")
  String jsonResponsePhoneCallEmptyCallout;

  @Test
  void serializeSmsResponse() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(expectedSmsRequestEventResponseDto);

    JSONAssert.assertEquals(jsonResponseSms, serializedString, true);
  }

  @Test
  void serializeSmsResponseEmptySms() throws JsonProcessingException, JSONException {

    VerificationRequestEventResponseSms value =
        VerificationRequestEventResponseSms.builder()
            .setAction(VerificationEventResponseAction.ALLOW)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseSmsEmptySms, serializedString, true);
  }

  @Test
  void serializeFlashCallResponse() throws JsonProcessingException, JSONException {

    String serializedString =
        objectMapper.writeValueAsString(expectedFlashCallRequestEventResponseDto);

    JSONAssert.assertEquals(jsonResponseFlashCall, serializedString, true);
  }

  @Test
  void serializeFlashCallResponseEmptyFlashCall() throws JsonProcessingException, JSONException {

    VerificationRequestEventResponseFlashCall value =
        VerificationRequestEventResponseFlashCall.builder()
            .setAction(VerificationEventResponseAction.ALLOW)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponseFlashCallEmptyFlashCall, serializedString, true);
  }

  @Test
  void serializePhoneCallResponse() throws JsonProcessingException, JSONException {

    String serializedString =
        objectMapper.writeValueAsString(expectedPhoneCallRequestEventResponseDto);

    JSONAssert.assertEquals(jsonResponsePhoneCall, serializedString, true);
  }

  @Test
  void serializePhoneCallResponseEmptyCallout() throws JsonProcessingException, JSONException {

    VerificationRequestEventResponsePhoneCall value =
        VerificationRequestEventResponsePhoneCall.builder()
            .setAction(VerificationEventResponseAction.ALLOW)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(jsonResponsePhoneCallEmptyCallout, serializedString, true);
  }
}
