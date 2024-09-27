package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.SMSConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfigurationDtoTest;
import org.junit.jupiter.api.Test;

class SmsConfigurationDtoConverterTest {

  static SMSConfiguration configuration =
      new SMSConfiguration(
          "service plan id", "campaign id", ScheduledSmsProvisioningDtoConverterTest.provisioning);

  @Test
  void convertDto() {

    SMSConfiguration converted =
        SmsConfigurationDtoConverter.convert(SmsConfigurationDtoTest.configurationResponse);
    TestHelpers.recursiveEquals(configuration, converted);
  }
}
