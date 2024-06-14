package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.models.v1.Price;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEventImpl;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventImpl;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationRequestEventDtoTest {

  @GivenJsonResource("/domains/verification/v1/webhooks/VerificationRequestEventDto.json")
  static VerificationEvent requestEventDto;

  public static VerificationEvent expectedRequestEventDto =
      new VerificationEventImpl(
          (VerificationRequestEventImpl)
              VerificationRequestEvent.builder()
                  .setId("1234567890")
                  .setEvent(VerificationRequestEvent.EventEnum.VERIFICATION_REQUEST_EVENT)
                  .setMethod(VerificationRequestEvent.MethodEnum.SMS)
                  .setIdentity(
                      IdentityInternal.builder()
                          .setType(IdentityInternal.TypeEnum.NUMBER)
                          .setEndpoint("+11235551234")
                          .build())
                  .setReference("reference string")
                  .setCustom("custom string")
                  .setPrice(Price.builder().setAmount(10.5F).setCurrencyId("USD").build())
                  .setAcceptLanguage(Collections.singletonList("es-ES"))
                  .build());

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(requestEventDto, expectedRequestEventDto);
  }
}
