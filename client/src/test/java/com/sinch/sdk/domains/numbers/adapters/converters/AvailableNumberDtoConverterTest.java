package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.Money;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.AvailableNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class AvailableNumberDtoConverterTest {

  AvailableNumber expectedItem =
      AvailableNumber.builder()
          .setPhoneNumber("+46650553763")
          .setRegionCode("SE")
          .setPaymentIntervalMonths(1)
          .setSupportingDocumentationRequired(true)
          .setType(NumberType.LOCAL)
          .setCapability(Collections.singletonList(Capability.VOICE))
          .setSetupPrice(Money.builder().setCurrencyCode("DOLLAR").setAmount(0.57).build())
          .setMonthlyPrice(Money.builder().setCurrencyCode("EUR").setAmount(0.80).build())
          .build();

  @Test
  void convertAvailableNumberListResponse() {

    Collection<AvailableNumber> expected = new ArrayList<>(Arrays.asList(expectedItem));

    AvailableNumberListResponse dto =
        new AvailableNumberListResponse(
            AvailableNumberDtoTest.availableNumberList.getAvailableNumbers());

    Collection<AvailableNumber> converted = AvailableNumberDtoConverter.convert(dto);

    TestHelpers.recursiveEquals(converted, expected);
  }

  @Test
  void convertEmptyAvailableNumberListResponse() {
    AvailableNumberListResponse dto = new AvailableNumberListResponse(null);
    Collection<AvailableNumber> converted = AvailableNumberDtoConverter.convert(dto);

    assertEquals(converted.size(), 0);
  }

  @Test
  void convertAvailableNumberDto() {

    AvailableNumber converted =
        AvailableNumberDtoConverter.convert(AvailableNumberDtoTest.availableNumber);
    TestHelpers.recursiveEquals(converted, expectedItem);
  }
}
