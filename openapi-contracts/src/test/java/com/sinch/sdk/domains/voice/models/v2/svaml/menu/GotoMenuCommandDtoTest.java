package com.sinch.sdk.domains.voice.models.v2.svaml.menu;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class GotoMenuCommandDtoTest extends BaseTest {

  public static final GotoMenuCommand expectedGotoMenuCommand =
      GotoMenuCommand.builder().setMenuName("main").build();

  @GivenTextResource("/domains/voice/v2/svaml/menu/GotoMenuCommandDto.json")
  String jsonGotoMenuCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedGotoMenuCommand);

    JSONAssert.assertEquals(jsonGotoMenuCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    GotoMenuCommand deserialized =
        objectMapper.readValue(jsonGotoMenuCommand, GotoMenuCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedGotoMenuCommand);
  }
}
