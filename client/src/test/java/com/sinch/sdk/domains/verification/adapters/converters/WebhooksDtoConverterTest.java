package com.sinch.sdk.domains.verification.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.dto.v1.webhooks.VerificationRequestEventDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.webhooks.VerificationResponseEventDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.webhooks.VerificationResultEventDtoTest;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponse;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseActionType;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseCalloutSpeech;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResultEvent;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhooksDtoConverterTest extends BaseTest {

  public static VerificationRequestEvent verificationRequestEvent =
      new VerificationRequestEvent(
          "1234567890",
          VerificationMethodType.SMS,
          NumberIdentity.valueOf("+11235551234"),
          Price.builder().setAmount(10.5F).setCurrencyId("USD").build(),
          VerificationReference.valueOf("reference string"),
          "custom string",
          Collections.singletonList("es-ES"));

  public static VerificationResultEvent verificationResultEvent =
      new VerificationResultEvent(
          "1234567890",
          VerificationMethodType.SMS,
          NumberIdentity.valueOf("+11235551234"),
          VerificationReference.valueOf("reference string"),
          "custom string",
          VerificationStatusType.DENIED,
          VerificationStatusReasonType.FRAUD,
          VerificationSourceType.MANUAL);

  public static VerificationResponse verificationResponsePhoneCall =
      VerificationResponseCallout.builder()
          .setAction(VerificationResponseActionType.DENY)
          .setCode("4567")
          .setSpeech(VerificationResponseCalloutSpeech.builder().setLocale("the locale").build())
          .build();

  public static VerificationResponse verificationResponseFlashCall =
      VerificationResponseFlashCall.builder()
          .setAction(VerificationResponseActionType.DENY)
          .setCli("cli code")
          .setDialTimeout(123)
          .build();

  public static VerificationResponse verificationResponseSms =
      VerificationResponseSMS.builder()
          .setAction(VerificationResponseActionType.DENY)
          .setCode("5666")
          .setAcceptLanguage(Collections.singletonList("a language"))
          .build();

  @Test
  void convertVerificationRequestEvent() {
    Assertions.assertThat(verificationRequestEvent)
        .usingRecursiveComparison()
        .isEqualTo(
            WebHooksDtoConverter.convert(VerificationRequestEventDtoTest.expectedRequestEventDto));
  }

  @Test
  void convertVerificationResultEvent() {
    Assertions.assertThat(verificationResultEvent)
        .usingRecursiveComparison()
        .isEqualTo(
            WebHooksDtoConverter.convert(VerificationResultEventDtoTest.expectedResultEvent));
  }

  @Test
  void convertVerificationPhoneCallResponse() {
    Assertions.assertThat(VerificationResponseEventDtoTest.expectedPhoneCallRequestEventResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(WebHooksDtoConverter.convert(verificationResponsePhoneCall));
  }

  @Test
  void convertVerificationFlashCallResponse() {
    Assertions.assertThat(VerificationResponseEventDtoTest.expectedFlashCallRequestEventResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(WebHooksDtoConverter.convert(verificationResponseFlashCall));
  }

  @Test
  void convertVerificationSmsResponse() {
    Assertions.assertThat(VerificationResponseEventDtoTest.expectedSmsRequestEventResponseDto)
        .usingRecursiveComparison()
        .isEqualTo(WebHooksDtoConverter.convert(verificationResponseSms));
  }
}