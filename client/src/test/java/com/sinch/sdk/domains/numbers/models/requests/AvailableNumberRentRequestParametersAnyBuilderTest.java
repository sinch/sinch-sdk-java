package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableNumberRentRequestParametersAnyBuilderTest {

  final String regionCode = "foo region";
  final NumberType type = NumberType.MOBILE;
  final NumberPattern numberPattern =
      NumberPattern.builder().setPattern("a pattern").setSearchPattern(SearchPattern.END).build();
  final Collection<Capability> capabilities = Arrays.asList(Capability.VOICE, Capability.SMS);

  final RentSMSConfigurationRequestParameters smsConfiguration =
      RentSMSConfigurationRequestParameters.builder()
          .setServicePlanId("plan id")
          .setCampaignId("campaign id")
          .build();

  final RentVoiceConfigurationRequestParameters voiceConfiguration =
      RentVoiceConfigurationRequestParameters.builder().setAppId("app id").build();
  final String callbackUrl = " the callback";

  final AvailableNumberRentAnyRequestParameters value =
      AvailableNumberRentAnyRequestParameters.builder()
          .setRegionCode(regionCode)
          .setType(type)
          .setNumberPattern(numberPattern)
          .setCapabilities(capabilities)
          .setSmsConfiguration(smsConfiguration)
          .setVoiceConfiguration(voiceConfiguration)
          .setCallbackUrl(callbackUrl)
          .build();

  @Test
  void getRegionCode() {
    Assertions.assertThat(value.getRegionCode().get()).isEqualTo(regionCode);
  }

  @Test
  void getType() {
    Assertions.assertThat(value.getType().get()).isEqualTo(type);
  }

  @Test
  void getNumberPattern() {
    Assertions.assertThat(value.getNumberPattern()).isEqualTo(OptionalValue.of(numberPattern));
  }

  @Test
  void getCapabilities() {
    Assertions.assertThat(value.getCapabilities()).isEqualTo(OptionalValue.of(capabilities));
  }

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
