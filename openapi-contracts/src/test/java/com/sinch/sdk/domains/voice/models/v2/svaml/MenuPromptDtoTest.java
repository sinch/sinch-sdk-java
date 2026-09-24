package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MenuPromptDtoTest extends BaseTest {

  public static final MenuPrompt expectedMenuPrompt =
      MenuPrompt.builder()
          .setAllowBargeIn(false)
          .setMessages(Arrays.asList(SayMessageDtoTest.expectedSayMessage))
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/MenuPromptDto.json")
  String jsonMenuPrompt;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedMenuPrompt);

    JSONAssert.assertEquals(jsonMenuPrompt, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    MenuPrompt deserialized = objectMapper.readValue(jsonMenuPrompt, MenuPrompt.class);

    TestHelpers.recursiveEquals(deserialized, expectedMenuPrompt);
  }
}
