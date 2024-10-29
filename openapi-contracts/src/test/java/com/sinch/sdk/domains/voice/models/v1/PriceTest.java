package com.sinch.sdk.domains.voice.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class PriceTest extends BaseTest {

  public static Price dto = Price.builder().setAmount(0.123456F).setCurrencyId("EUR").build();

  @GivenTextResource("/domains/voice/v1/PriceDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException, JSONException {
    Price expected = objectMapper.readValue(json, Price.class);

    TestHelpers.recursiveEquals(dto, expected);
  }
}
