package com.sinch.sdk.domains.voice.models.v2.sinchevents;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class MenuInputDtoTest extends BaseTest {

  public static final MenuInput expectedMenuInput =
      MenuInput.builder().setMenuName("main").setInput("1234").build();

  @GivenTextResource("/domains/voice/v2/sinchevents/MenuInputDto.json")
  String jsonMenuInput;

  @Test
  void deserialize() throws JsonProcessingException {
    MenuInput deserialized = objectMapper.readValue(jsonMenuInput, MenuInput.class);

    TestHelpers.recursiveEquals(deserialized, expectedMenuInput);
  }
}
