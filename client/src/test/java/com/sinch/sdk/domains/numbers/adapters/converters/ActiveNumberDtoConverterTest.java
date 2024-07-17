package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.Money;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumberDtoTest;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ActiveNumberDtoConverterTest {

  public static com.sinch.sdk.domains.numbers.models.ActiveNumber activeNumber =
      com.sinch.sdk.domains.numbers.models.ActiveNumber.builder()
          .setPhoneNumber("+447520651116XYZ")
          .setProjectId("project id")
          .setDisplayName("a display")
          .setRegionCode("GB")
          .setType(NumberType.MOBILE)
          .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
          .setMoney(Money.builder().setCurrencyCode("EUR").setAmount(0.8).build())
          .setPaymentIntervalMonths(1)
          .setNextChargeDate(Instant.parse("2023-09-22T15:49:58.813424Z"))
          .setExpireAt(Instant.parse("2023-10-06T15:49:58.813381Z"))
          .setSmsConfiguration(SmsConfigurationDtoConverterTest.configuration)
          .setVoiceConfiguration(VoiceConfigurationDtoConverterTest.configuration)
          .setCallbackUrl("foo callback")
          .build();

  @Test
  void convertActiveNumberDto() {
    ActiveNumber converted = ActiveNumberDtoConverter.convert(ActiveNumberDtoTest.activeNumber);
    TestHelpers.recursiveEquals(converted, activeNumber);
  }
}
