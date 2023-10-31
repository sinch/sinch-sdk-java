package com.sinch.sdk.domains.numbers.models;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ActiveNumberTest {

  final String phoneNumber = "01234";
  final String projectId = "project id";
  final String displayName = "display name";
  final String regionCode = "region";
  final NumberType type = NumberType.MOBILE;
  final Collection<Capability> capability = Arrays.asList(Capability.VOICE, Capability.SMS);

  final Money money = new Money("foo money", 0.50);

  final Integer paymentIntervalMonths = 5;

  final Instant nextChargeDate = Instant.now();

  final Instant expireAt = Instant.now();

  final SMSConfiguration smsConfiguration =
      new SMSConfiguration(
          "service plan id",
          "campaign id",
          new ScheduledSmsProvisioning(
              "service plan id from scheduled",
              "campaign id from scheduled",
              ProvisioningStatus.FAILED,
              Instant.now(),
              Collections.singletonList(SmsErrorCode.ERROR_CODE_UNSPECIFIED)));
  final VoiceConfiguration voiceConfiguration =
      new VoiceConfiguration(
          "app id",
          Instant.now(),
          new ScheduledVoiceProvisioning(
              "app id from scheduled", ProvisioningStatus.IN_PROGRESS, Instant.now()));

  final String callbackUrl = "foo callback";
  final ActiveNumber value =
      new ActiveNumber(
          phoneNumber,
          projectId,
          displayName,
          regionCode,
          type,
          capability,
          money,
          paymentIntervalMonths,
          nextChargeDate,
          expireAt,
          smsConfiguration,
          voiceConfiguration,
          callbackUrl);

  @Test
  void getPhoneNumber() {
    Assertions.assertThat(value.getPhoneNumber()).isEqualTo(phoneNumber);
  }

  @Test
  void getProjectId() {
    Assertions.assertThat(value.getProjectId()).isEqualTo(projectId);
  }

  @Test
  void getDisplayName() {
    Assertions.assertThat(value.getDisplayName()).isEqualTo(displayName);
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
  void getMoney() {
    Assertions.assertThat(value.getMoney()).isEqualTo(money);
  }

  @Test
  void getPaymentIntervalMonths() {
    Assertions.assertThat(value.getPaymentIntervalMonths()).isEqualTo(paymentIntervalMonths);
  }

  @Test
  void getNextChargeDate() {
    Assertions.assertThat(value.getNextChargeDate()).isEqualTo(nextChargeDate);
  }

  @Test
  void getExpireAt() {
    Assertions.assertThat(value.getExpireAt()).isEqualTo(expireAt);
  }

  @Test
  void getSmsConfiguration() {
    Assertions.assertThat(value.getSmsConfiguration()).isEqualTo(smsConfiguration);
  }

  @Test
  void getVoiceConfiguration() {
    Assertions.assertThat(value.getVoiceConfiguration()).isEqualTo(voiceConfiguration);
  }

  @Test
  void getCallbackUrl() {
    Assertions.assertThat(value.getCallbackUrl()).isEqualTo(callbackUrl);
  }
}
