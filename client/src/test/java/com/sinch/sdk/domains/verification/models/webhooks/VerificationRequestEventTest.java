package com.sinch.sdk.domains.verification.models.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
class VerificationRequestEventTest {

  @GivenJsonResource(
      "/client/sinch/sdk/domains/verification/models/webhooks/VerificationRequestEvent.json")
  static VerificationRequestEvent dto;

  @Test
  void getId() {
    Assertions.assertThat(dto.getId())
        .usingRecursiveComparison()
        .isEqualTo(VerificationId.valueOf("1234567890"));
  }

  @Test
  void getEvent() {
    Assertions.assertThat(dto.getEvent()).isEqualTo("VerificationRequestEvent");
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
  void getPrice() {
    Assertions.assertThat(dto.getPrice().get())
        .usingRecursiveComparison()
        .isEqualTo(Price.builder().setAmount(10.5F).setCurrencyId("USD").build());
  }

  @Test
  void getAcceptLanguage() {
    Assertions.assertThat(dto.getAcceptLanguage().get())
        .usingRecursiveComparison()
        .isEqualTo(Collections.singletonList("es-ES"));
  }
}
