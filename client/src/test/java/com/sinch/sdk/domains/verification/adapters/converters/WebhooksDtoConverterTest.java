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
import com.sinch.sdk.domains.verification.models.dto.v1.webhooks.VerificationResultEventDtoTest;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResultEvent;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhooksDtoConverterTest extends BaseTest {

  VerificationRequestEvent verificationRequestEvent =
      new VerificationRequestEvent(
          "1234567890",
          VerificationMethodType.SMS,
          NumberIdentity.valueOf("+11235551234"),
          Price.builder().setAmount(10.5F).setCurrencyId("USD").build(),
          VerificationReference.valueOf("reference string"),
          "custom string",
          Collections.singletonList("es-ES"));

  VerificationResultEvent verificationResultEvent =
      new VerificationResultEvent(
          "1234567890",
          VerificationMethodType.SMS,
          NumberIdentity.valueOf("+11235551234"),
          VerificationReference.valueOf("reference string"),
          "custom string",
          VerificationStatusType.DENIED,
          VerificationStatusReasonType.FRAUD,
          VerificationSourceType.MANUAL);

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
}
