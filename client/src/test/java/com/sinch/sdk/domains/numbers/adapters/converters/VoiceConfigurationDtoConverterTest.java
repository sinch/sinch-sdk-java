package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationDtoTest;
import java.time.Instant;
import org.junit.jupiter.api.Test;

class VoiceConfigurationDtoConverterTest {

  static VoiceConfiguration configuration =
      new VoiceConfiguration(
          "AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE",
          Instant.parse("2024-06-30T07:08:09.10Z"),
          ScheduledVoiceProvisioningDtoConverterTest.provisioning);

  @Test
  void convert() {

    VoiceConfiguration converted =
        VoiceConfigurationDtoConverter.convert(VoiceConfigurationDtoTest.configurationResponseRTC);
    TestHelpers.recursiveEquals(configuration, converted);
  }
}
