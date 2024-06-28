package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.status.StatusSource;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationResultEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationResultEvent.EventEnum;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationResultEventImpl;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationEventInternal;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationEventInternalImpl;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationResultEventDtoTest extends VerificationBaseTest {

  @GivenJsonResource("/domains/verification/v1/webhooks/VerificationResultEventDto.json")
  VerificationEventInternal resultEventDto;

  public static VerificationEventInternalImpl expectedResultEvent =
      new VerificationEventInternalImpl(
          (VerificationResultEventImpl)
              VerificationResultEvent.builder()
                  .setId("1234567890")
                  .setEvent(EventEnum.VERIFICATION_RESULT_EVENT)
                  .setMethod(VerificationMethod.SMS)
                  .setIdentity(NumberIdentity.valueOf("+11235551234"))
                  .setReference("reference string")
                  .setCustom("custom string")
                  .setStatus(VerificationStatus.DENIED)
                  .setReason(VerificationStatusReason.FRAUD)
                  .setSource(StatusSource.MANUAL)
                  .build());

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(resultEventDto, expectedResultEvent);
  }
}
