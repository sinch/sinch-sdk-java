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
public class MessageEventsDtoTest extends BaseTest {

  public static final MessageEvents expectedMessageEvents =
      MessageEvents.builder()
          .setOnFinish(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/MessageEventsDto.json")
  String jsonMessageEvents;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedMessageEvents);

    JSONAssert.assertEquals(jsonMessageEvents, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    MessageEvents deserialized = objectMapper.readValue(jsonMessageEvents, MessageEvents.class);

    TestHelpers.recursiveEquals(deserialized, expectedMessageEvents);
  }
}
