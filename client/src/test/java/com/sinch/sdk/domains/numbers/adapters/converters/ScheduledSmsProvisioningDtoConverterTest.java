package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.ProvisioningStatus;
import com.sinch.sdk.domains.numbers.models.ScheduledSmsProvisioning;
import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfigurationDtoTest;
import java.time.Instant;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ScheduledSmsProvisioningDtoConverterTest {

  static ScheduledSmsProvisioning provisioning =
      new ScheduledSmsProvisioning(
          "service plan id from scheduled",
          "campaign id from scheduled",
          ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
          Instant.parse("2023-09-25T12:08:02.115Z"),
          Collections.singletonList(SmsErrorCode.ERROR_CODE_UNSPECIFIED));

  @Test
  void convert() {

    ScheduledSmsProvisioning converted =
        ScheduledSmsProvisioningDtoConverter.convert(
            SmsConfigurationDtoTest.configurationResponse.getScheduledProvisioning());
    TestHelpers.recursiveEquals(provisioning, converted);
  }
}
