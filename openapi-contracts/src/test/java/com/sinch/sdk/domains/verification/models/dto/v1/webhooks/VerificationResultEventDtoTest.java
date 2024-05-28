package com.sinch.sdk.domains.verification.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.domains.verification.models.dto.v1.IdentityDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationResultEventDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationStatusDto;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationStatusReasonDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationResultEventDtoTest {

  @GivenJsonResource("/domains/verification/v1/webhooks/VerificationResultEventDto.json")
  static VerificationResultEventDto resultEventDto;

  public static VerificationResultEventDto expectedResultEvent =
      new VerificationResultEventDto()
          .id("1234567890")
          .event("VerificationResultEvent")
          .method("sms")
          .identity(new IdentityDto().type("number").endpoint("+11235551234"))
          .reference("reference string")
          .custom("custom string")
          .status(VerificationStatusDto.DENIED)
          .reason(VerificationStatusReasonDto.FRAUD)
          .source("manual");

  @Test
  void deserialize() {
    Assertions.assertThat(resultEventDto).usingRecursiveComparison().isEqualTo(expectedResultEvent);
  }
}
