package com.sinch.sdk.domains.verification.models.dto.v1.sinchevents;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.Price;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.VerificationRequestEventImpl;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.internal.VerificationEventInternal;
import com.sinch.sdk.domains.verification.models.v1.sinchevents.internal.VerificationEventInternalImpl;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationRequestEventDtoTest extends VerificationBaseTest {

  @GivenJsonResource("/domains/verification/v1/sinchevents/VerificationRequestEventDto.json")
  VerificationEventInternal requestEventDto;

  public static VerificationEventInternalImpl expectedRequestEventDto =
      new VerificationEventInternalImpl(
          (VerificationRequestEventImpl)
              VerificationRequestEvent.builder()
                  .setId("1234567890")
                  .setMethod(VerificationMethod.SMS)
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
