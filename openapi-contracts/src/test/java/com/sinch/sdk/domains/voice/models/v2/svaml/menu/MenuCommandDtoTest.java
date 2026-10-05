package com.sinch.sdk.domains.voice.models.v2.svaml.menu;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MenuCommandDtoTest extends BaseTest {

  public static final MenuCommand expectedMenuCommand =
      MenuCommand.builder()
          .setStartMenu("main")
          .setMenus(Collections.singletonMap("main", MenuItemDtoTest.expectedMenuItem))
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/menu/MenuCommandDto.json")
  String jsonMenuCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedMenuCommand);

    JSONAssert.assertEquals(jsonMenuCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    MenuCommand deserialized = objectMapper.readValue(jsonMenuCommand, MenuCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedMenuCommand);
  }
}
