package com.sinch.sdk.domains.numbers.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.v1.available.response.internal.AvailableNumberListResponseInternal;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class AvailableNumberDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/available/available-numbers-list.json")
  String availableListResponse;

  @GivenTextResource("/domains/numbers/v1/available/available-numbers-get.json")
  String availableGetResponse;

  public static AvailableNumber availableNumber =
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

  public static AvailableNumberListResponseInternal availableNumberList =
      AvailableNumberListResponseInternal.builder()
          .setAvailableNumbers(Collections.singletonList(availableNumber))
          .build();

  @Test
  void deserialize() throws JsonProcessingException {

    AvailableNumber deserializedString =
        objectMapper.readValue(availableGetResponse, AvailableNumber.class);

    TestHelpers.recursiveEquals(availableNumber, deserializedString);
  }

  @Test
  void deserializeList() throws JsonProcessingException {

    AvailableNumberListResponseInternal deserializedString =
        objectMapper.readValue(availableListResponse, AvailableNumberListResponseInternal.class);

    TestHelpers.recursiveEquals(availableNumberList, deserializedString);
  }
}
