package com.sinch.sdk.domains.verification.adapters.converters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
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
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhooksDtoConverterTest extends VerificationBaseTest {

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
          .setAction(VerificationResponseActionType.ALLOW)
          .setCode("4567")
          .setSpeech(VerificationResponseCalloutSpeech.builder().setLocale("the locale").build())
          .build();

  public static VerificationResponse verificationResponseFlashCall =
      VerificationResponseFlashCall.builder()
          .setAction(VerificationResponseActionType.ALLOW)
          .setCli("cli code")
          .setDialTimeout(123)
          .build();

  public static VerificationResponse verificationResponseSms =
      VerificationResponseSMS.builder()
          .setAction(VerificationResponseActionType.ALLOW)
          .setCode("5666")
          .setAcceptLanguage(Collections.singletonList("a language"))
          .build();

  @Test
  void convertVerificationRequestEvent() {
    TestHelpers.recursiveEquals(
        verificationRequestEvent,
        WebHooksDtoConverter.convert(
            VerificationRequestEventDtoTest.expectedRequestEventDto
                .getVerificationRequestEventImpl()));
  }

  @Test
  void convertVerificationResultEvent() {
    TestHelpers.recursiveEquals(
        verificationResultEvent,
        WebHooksDtoConverter.convert(
            VerificationResultEventDtoTest.expectedResultEvent.getVerificationResultEventImpl()));
  }

  @Test
  void convertVerificationPhoneCallResponse() {
    TestHelpers.recursiveEquals(
        VerificationResponseEventDtoTest.expectedPhoneCallRequestEventResponseDto,
        WebHooksDtoConverter.convert(verificationResponsePhoneCall));
  }

  @Test
  void convertVerificationFlashCallResponse() {
    TestHelpers.recursiveEquals(
        VerificationResponseEventDtoTest.expectedFlashCallRequestEventResponseDto,
        WebHooksDtoConverter.convert(verificationResponseFlashCall));
  }

  @Test
  void convertVerificationSmsResponse() {
    TestHelpers.recursiveEquals(
        VerificationResponseEventDtoTest.expectedSmsRequestEventResponseDto,
        WebHooksDtoConverter.convert(verificationResponseSms));
  }
}
