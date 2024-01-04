package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableNumberRentRequestParametersBuilderTest {

  RentSMSConfigurationRequestParameters smsConfiguration =
      RentSMSConfigurationRequestParameters.builder()
          .setServicePlanId("plan id")
          .setCampaignId("campaign id")
          .build();

  RentVoiceConfigurationRequestParameters voiceConfiguration =
      RentVoiceConfigurationRequestParameters.builder().setAppId("app id").build();
  String callbackUrl = "the callback";

  final AvailableNumberRentRequestParameters value =
      AvailableNumberRentRequestParameters.builder()
          .setSmsConfiguration(smsConfiguration)
          .setVoiceConfiguration(voiceConfiguration)
          .setCallbackUrl(callbackUrl)
          .build();

  @Test
  void getSmsConfiguration() {
    Assertions.assertThat(value.getSmsConfiguration())
        .isEqualTo(OptionalValue.of(smsConfiguration));
  }

  @Test
  void getVoiceConfiguration() {
    Assertions.assertThat(value.getVoiceConfiguration())
        .isEqualTo(OptionalValue.of(voiceConfiguration));
  }

  @Test
  void getCallBackUrl() {
    Assertions.assertThat(value.getCallBackUrl()).isEqualTo(OptionalValue.of(callbackUrl));
  }
}
