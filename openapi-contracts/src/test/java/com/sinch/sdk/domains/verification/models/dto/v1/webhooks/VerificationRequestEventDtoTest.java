package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.Price;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventImpl;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationEventInternal;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationEventInternalImpl;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationRequestEventDtoTest extends VerificationBaseTest {

  @GivenJsonResource("/domains/verification/v1/webhooks/VerificationRequestEventDto.json")
  VerificationEventInternal requestEventDto;

  public static VerificationEventInternalImpl expectedRequestEventDto =
      new VerificationEventInternalImpl(
          (VerificationRequestEventImpl)
              VerificationRequestEvent.builder()
                  .setId("1234567890")
                  .setEvent(VerificationRequestEvent.EventEnum.VERIFICATION_REQUEST_EVENT)
                  .setMethod(VerificationRequestEvent.MethodEnum.SMS)
                  .setIdentity(NumberIdentity.valueOf("+11235551234"))
                  .setReference("reference string")
                  .setCustom("custom string")
                  .setPrice(Price.builder().setAmount(10.5F).setCurrencyId("USD").build())
                  .build());

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(requestEventDto, expectedRequestEventDto);
  }
}
