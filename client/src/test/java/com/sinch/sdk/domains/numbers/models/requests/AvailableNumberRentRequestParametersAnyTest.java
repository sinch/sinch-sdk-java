package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableNumberRentRequestParametersAnyTest {

  final String regionCode = "foo region";
  final NumberType type = NumberType.MOBILE;
  final NumberPattern numberPattern = new NumberPattern("a pattern", SearchPattern.END);
  final Collection<Capability> capabilities = Arrays.asList(Capability.VOICE, Capability.SMS);

  final RentSMSConfigurationRequestParameters smsConfiguration =
      new RentSMSConfigurationRequestParameters("plan id", "campaign id");

  final RentVoiceConfigurationRequestParameters voiceConfiguration =
      new RentVoiceConfigurationRequestParameters("app id");
  final String callbackUrl = " the callback";

  final AvailableNumberRentAnyRequestParameters value =
      new AvailableNumberRentAnyRequestParameters(
          regionCode,
          type,
          numberPattern,
          capabilities,
          smsConfiguration,
          voiceConfiguration,
          callbackUrl);

  @Test
  void getRegionCode() {
    Assertions.assertThat(value.getRegionCode()).isEqualTo(regionCode);
  }

  @Test
  void getType() {
    Assertions.assertThat(value.getType()).isEqualTo(type);
  }

  @Test
  void getNumberPattern() {
    Assertions.assertThat(value.getNumberPattern()).isEqualTo(Optional.of(numberPattern));
  }

  @Test
  void getCapabilities() {
    Assertions.assertThat(value.getCapabilities()).isEqualTo(Optional.of(capabilities));
  }

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
