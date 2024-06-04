package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEventImpl;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationResultEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationResultEventImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationResultEventDtoTest {

  @GivenJsonResource("/domains/verification/v1/webhooks/VerificationResultEventDto.json")
  static VerificationEvent resultEventDto;

  public static VerificationEvent expectedResultEvent =
      new VerificationEventImpl(
          (VerificationResultEventImpl)
              VerificationResultEvent.builder()
                  .setId("1234567890")
                  .setEvent(VerificationResultEvent.EventEnum.VERIFICATIONRESULTEVENT)
                  .setMethod(VerificationResultEvent.MethodEnum.SMS)
                  .setIdentity(
                      IdentityInternal.builder()
                          .setType(IdentityInternal.TypeEnum.NUMBER)
                          .setEndpoint("+11235551234")
                          .build())
                  .setReference("reference string")
                  .setCustom("custom string")
                  .setStatus(VerificationStatus.DENIED)
                  .setReason(VerificationStatusReason.FRAUD)
                  .setSource(VerificationResultEvent.SourceEnum.MANUAL)
                  .build());

  @Test
  void deserialize() {
    Assertions.assertThat(resultEventDto).usingRecursiveComparison().isEqualTo(expectedResultEvent);
  }
}