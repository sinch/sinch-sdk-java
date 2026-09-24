package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MenuItemDtoTest extends BaseTest {

  public static final MenuItem expectedMenuItem =
      MenuItem.builder()
          .setPrompt(MenuPromptDtoTest.expectedMenuPrompt)
          .setRepeatPrompt(MenuPromptDtoTest.expectedMenuPrompt)
          .setInputTimeoutDurationSeconds(10)
          .setRepeatCount(3)
          .setMinimumInputLength(1)
          .setMaximumInputLength(4)
          .setTerminatingSequence("#")
          .setInputMethods(Arrays.asList(MenuItem.InputMethodsEnum.DTMF))
          .setMatches(
              Collections.singletonMap(
                  "1", Arrays.asList(GotoMenuCommandDtoTest.expectedGotoMenuCommand)))
          .setOnFail(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/MenuItemDto.json")
  String jsonMenuItem;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedMenuItem);

    JSONAssert.assertEquals(jsonMenuItem, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    MenuItem deserialized = objectMapper.readValue(jsonMenuItem, MenuItem.class);

    TestHelpers.recursiveEquals(deserialized, expectedMenuItem);
  }
}
