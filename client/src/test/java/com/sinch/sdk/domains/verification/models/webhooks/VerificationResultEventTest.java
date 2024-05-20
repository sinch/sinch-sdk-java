package com.sinch.sdk.domains.verification.models.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
class VerificationResultEventTest {

  @GivenJsonResource(
      "/client/sinch/sdk/domains/verification/models/webhooks/VerificationResultEvent.json")
  static VerificationResultEvent dto;

  @Test
  void getId() {
    Assertions.assertThat(dto.getId())
        .usingRecursiveComparison()
        .isEqualTo(VerificationId.valueOf("1234567890"));
  }

  @Test
  void getEvent() {
    Assertions.assertThat(dto.getEvent()).isEqualTo("VerificationResultEvent");
  }

  @Test
  void getMethod() {
    Assertions.assertThat(dto.getMethod()).isEqualTo(VerificationMethodType.from("sms"));
  }

  @Test
  void getIdentity() {
    Assertions.assertThat(dto.getIdentity())
        .usingRecursiveComparison()
        .isEqualTo(NumberIdentity.builder().setEndpoint("+11235551234").build());
  }

  @Test
  void getReference() {
    Assertions.assertThat(dto.getReference().get())
        .usingRecursiveComparison()
        .isEqualTo(VerificationReference.valueOf("reference string"));
  }

  @Test
  void getCustom() {
    Assertions.assertThat(dto.getCustom().get()).isEqualTo("custom string");
  }

  @Test
  void getStatus() {
    Assertions.assertThat(dto.getStatus()).isEqualTo(VerificationStatusType.DENIED);
  }

  @Test
  void getReason() {
    Assertions.assertThat(dto.getReason().get()).isEqualTo(VerificationStatusReasonType.FRAUD);
  }

  @Test
  void getSource() {
    Assertions.assertThat(dto.getSource().get()).isEqualTo(VerificationSourceType.MANUAL);
  }
}
