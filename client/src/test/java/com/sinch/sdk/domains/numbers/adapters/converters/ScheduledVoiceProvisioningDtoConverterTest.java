package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.ProvisioningStatus;
import com.sinch.sdk.domains.numbers.models.ScheduledVoiceProvisioning;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationDtoTest;
import java.time.Instant;
import org.junit.jupiter.api.Test;

class ScheduledVoiceProvisioningDtoConverterTest {

  static ScheduledVoiceProvisioning provisioning =
      new ScheduledVoiceProvisioning(
          "EEEEEEEEEE-DDDD-CCCC-BBBB-AAAAAAAA",
          ProvisioningStatus.WAITING,
          Instant.parse("2024-07-01T11:58:35.610198Z"));

  @Test
  void convert() {

    ScheduledVoiceProvisioning converted =
        ScheduledVoiceProvisioningDtoConverter.convert(
            VoiceConfigurationDtoTest.configurationRTC.getScheduledProvisioning());
    TestHelpers.recursiveEquals(provisioning, converted);
  }
}
