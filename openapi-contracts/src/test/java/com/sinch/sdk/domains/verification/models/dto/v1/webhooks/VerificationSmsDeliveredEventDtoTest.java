package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationSmsDeliveredEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationSmsDeliveredEvent.SmsResultEnum;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationSmsDeliveredEventImpl;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationEventInternal;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationEventInternalImpl;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationSmsDeliveredEventDtoTest extends VerificationBaseTest {

  @GivenJsonResource("/domains/verification/v1/webhooks/VerificationSmsDeliveryEventEventDto.json")
  VerificationEventInternal resultEventDto;

  public static VerificationEventInternalImpl expectedResultEvent =
      new VerificationEventInternalImpl(
          (VerificationSmsDeliveredEventImpl)
              VerificationSmsDeliveredEvent.builder()
                  .setId("1234567890")
                  .setMethod(VerificationMethod.SMS)
                  .setIdentity(NumberIdentity.valueOf("+11235551234"))
                  .setReference("reference string")
                  .setCustom("custom string")
                  .setSmsResult(SmsResultEnum.FAILED)
                  .build());

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(resultEventDto, expectedResultEvent);
  }
}
