package com.sinch.sdk.domains.numbers.models;

import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableNumberBuilderTest {

  final String phoneNumber = "01234";
  final String regionCode = "region";
  final NumberType type = NumberType.MOBILE;
  final Collection<Capability> capability = Arrays.asList(Capability.VOICE, Capability.SMS);
  final Money setupPrice = new Money("setup currency", .5);
  final Money monthlyPrice = new Money("monthly currency", 1.5);
  final Integer paymentIntervalMonths = 23;
  final Boolean supportingDocumentationRequired = true;

  final AvailableNumber value =
      AvailableNumber.builder()
          .setPhoneNumber(phoneNumber)
          .setRegionCode(regionCode)
          .setType(type)
          .setCapability(capability)
          .setSetupPrice(setupPrice)
          .setMonthlyPrice(monthlyPrice)
          .setPaymentIntervalMonths(paymentIntervalMonths)
          .setSupportingDocumentationRequired(supportingDocumentationRequired)
          .build();

  @Test
  void getPhoneNumber() {
    Assertions.assertThat(value.getPhoneNumber()).isEqualTo(phoneNumber);
  }

  @Test
  void getRegionCode() {
    Assertions.assertThat(value.getRegionCode()).isEqualTo(regionCode);
  }

  @Test
  void getType() {
    Assertions.assertThat(value.getType()).usingRecursiveComparison().isEqualTo(type);
  }

  @Test
  void getCapability() {
    Assertions.assertThat(value.getCapability()).usingRecursiveComparison().isEqualTo(capability);
  }

  @Test
  void getSetupPrice() {
    Assertions.assertThat(value.getSetupPrice()).usingRecursiveComparison().isEqualTo(setupPrice);
  }

  @Test
  void getMonthlyPrice() {
    Assertions.assertThat(value.getMonthlyPrice())
        .usingRecursiveComparison()
        .isEqualTo(monthlyPrice);
  }

  @Test
  void getPaymentIntervalMonths() {
    Assertions.assertThat(value.getPaymentIntervalMonths()).isEqualTo(paymentIntervalMonths);
  }

  @Test
  void getSupportingDocumentationRequired() {
    Assertions.assertThat(value.getSupportingDocumentationRequired())
        .isEqualTo(supportingDocumentationRequired);
  }
}
