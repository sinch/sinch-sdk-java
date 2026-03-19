package com.sinch.sdk.domains.verification.models.dto.v1.sinchevents;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.SmsCodeType;
import com.sinch.sdk.domains.verification.models.v1.WhatsAppCodeType;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventAction;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventResponseSms;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationStartEventResponseWhatsApp;
import com.sinch.sdk.domains.verification.models.v1.start.request.PhoneCallSpeech;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VerificationResponseEventDtoTest extends VerificationBaseTest {

  public static VerificationStartEventResponsePhoneCall expectedPhoneCallRequestEventResponseDto =
      VerificationStartEventResponsePhoneCall.builder()
          .setAction(VerificationStartEventAction.ALLOW)
          .setCode("4567")
          .setSpeech(PhoneCallSpeech.builder().setLocale("the locale").build())
          .putExtraOption("my key", "my value")
          .build();
  public static VerificationStartEventResponseFlashCall expectedFlashCallRequestEventResponseDto =
      VerificationStartEventResponseFlashCall.builder()
          .setAction(VerificationStartEventAction.ALLOW)
          .setCli("cli code")
          .setDialTimeout(123)
          .setInterceptionTimeout(456)
          .putExtraOption("my key", "my value")
          .build();
  public static VerificationStartEventResponseSms expectedSmsRequestEventResponseDto =
      VerificationStartEventResponseSms.builder()
          .setAction(VerificationStartEventAction.ALLOW)
          .setCode("5666")
          .setCodeType(SmsCodeType.NUMERIC)
          .setExpiry("01:02:03")
          .setAcceptLanguage(Collections.singletonList("a language"))
          .putExtraOption("my key", "my value")
          .build();

  public static VerificationStartEventResponseWhatsApp expectedWhatsAppRequestEventResponseDto =
      VerificationStartEventResponseWhatsApp.builder()
          .setAction(VerificationStartEventAction.ALLOW)
          .setCodeType(WhatsAppCodeType.NUMERIC)
          .setAcceptLanguage(Collections.singletonList("a language"))
          .putExtraOption("my key", "my value")
          .build();

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponseSmsDto.json")
  String verificationStartEventResponseSmsDto;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponseSmsEmptySmsDto.json")
  String verificationStartEventResponseSmsEmptySmsDto;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponseFlashCallDto.json")
  String verificationStartEventResponseFlashCallDto;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponseFlashCallEmptyFlashCallDto.json")
  String verificationStartEventResponseFlashCallEmptyFlashCallDto;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponsePhoneCallDto.json")
  String verificationStartEventResponsePhoneCallDto;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponsePhoneCallEmptyCalloutDto.json")
  String verificationStartEventResponsePhoneCallEmptyCalloutDto;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponseWhatsAppDto.json")
  String verificationStartEventResponseWhatsAppDto;

  @GivenTextResource(
      "/domains/verification/v1/sinchevents/VerificationStartEventResponseWhatsAppEmptyWhatsAppDto.json")
  String verificationStartEventResponseWhatsAppEmptyWhatsAppDto;

  @Test
  void serializeSmsResponse() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(expectedSmsRequestEventResponseDto);

    JSONAssert.assertEquals(verificationStartEventResponseSmsDto, serializedString, true);
  }

  @Test
  void serializeSmsResponseEmptySms() throws JsonProcessingException, JSONException {

    VerificationStartEventResponseSms value =
        VerificationStartEventResponseSms.builder()
            .setAction(VerificationStartEventAction.ALLOW)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(verificationStartEventResponseSmsEmptySmsDto, serializedString, true);
  }

  @Test
  void serializeFlashCallResponse() throws JsonProcessingException, JSONException {

    String serializedString =
        objectMapper.writeValueAsString(expectedFlashCallRequestEventResponseDto);

    JSONAssert.assertEquals(verificationStartEventResponseFlashCallDto, serializedString, true);
  }

  @Test
  void serializeFlashCallResponseEmptyFlashCall() throws JsonProcessingException, JSONException {

    VerificationStartEventResponseFlashCall value =
        VerificationStartEventResponseFlashCall.builder()
            .setAction(VerificationStartEventAction.ALLOW)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(
        verificationStartEventResponseFlashCallEmptyFlashCallDto, serializedString, true);
  }

  @Test
  void serializePhoneCallResponse() throws JsonProcessingException, JSONException {

    String serializedString =
        objectMapper.writeValueAsString(expectedPhoneCallRequestEventResponseDto);

    JSONAssert.assertEquals(verificationStartEventResponsePhoneCallDto, serializedString, true);
  }

  @Test
  void serializePhoneCallResponseEmptyCallout() throws JsonProcessingException, JSONException {

    VerificationStartEventResponsePhoneCall value =
        VerificationStartEventResponsePhoneCall.builder()
            .setAction(VerificationStartEventAction.ALLOW)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(
        verificationStartEventResponsePhoneCallEmptyCalloutDto, serializedString, true);
  }

  @Test
  void serializeWhatsAppResponse() throws JsonProcessingException, JSONException {

    String serializedString =
        objectMapper.writeValueAsString(expectedWhatsAppRequestEventResponseDto);

    JSONAssert.assertEquals(verificationStartEventResponseWhatsAppDto, serializedString, true);
  }

  @Test
  void serializeSmsResponseEmptyWhatsApp() throws JsonProcessingException, JSONException {

    VerificationStartEventResponseWhatsApp value =
        VerificationStartEventResponseWhatsApp.builder()
            .setAction(VerificationStartEventAction.ALLOW)
            .build();

    String serializedString = objectMapper.writeValueAsString(value);

    JSONAssert.assertEquals(
        verificationStartEventResponseWhatsAppEmptyWhatsAppDto, serializedString, true);
  }
}
