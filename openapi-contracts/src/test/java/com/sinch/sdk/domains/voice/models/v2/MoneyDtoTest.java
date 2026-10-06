package com.sinch.sdk.domains.voice.models.v2;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class MoneyDtoTest extends BaseTest {

  public static final Money expectedMoney =
      Money.builder().setCurrencyCode("USD").setAmount("0.0123").build();

  @GivenTextResource("/domains/voice/v2/MoneyDto.json")
  String jsonMoney;

  @Test
  void deserialize() throws JsonProcessingException {
    Money deserialized = objectMapper.readValue(jsonMoney, Money.class);

    TestHelpers.recursiveEquals(deserialized, expectedMoney);
  }
}
