package com.sinch.sdk.domains.numbers.models.requests;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableNumberRentRequestParametersTest {

  RentSMSConfigurationRequestParameters smsConfiguration =
      new RentSMSConfigurationRequestParameters("plan id", "campaign id");

  RentVoiceConfigurationRequestParameters voiceConfiguration =
      new RentVoiceConfigurationRequestParameters("app id");
  String callbackUrl = "the callback";

  final AvailableNumberRentRequestParameters value =
      new AvailableNumberRentRequestParameters(smsConfiguration, voiceConfiguration, callbackUrl);

  @Test
  void getSmsConfiguration() {
    Assertions.assertThat(value.getSmsConfiguration()).isEqualTo(Optional.of(smsConfiguration));
  }

  @Test
  void getVoiceConfiguration() {
    Assertions.assertThat(value.getVoiceConfiguration()).isEqualTo(Optional.of(voiceConfiguration));
  }

  @Test
  void getCallBackUrl() {
    Assertions.assertThat(value.getCallBackUrl()).isEqualTo(Optional.of(callbackUrl));
  }
}
