package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

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
public class MessagesCommandDtoTest extends BaseTest {

  public static final MessagesCommand expectedMessagesCommand =
      MessagesCommand.builder()
          .setMessagesName("my-messages")
          .setMessages(
              Arrays.asList(
                  SayMessageDtoTest.expectedSayMessage, PlayMessageDtoTest.expectedPlayMessage))
          .setEvents(MessageEventsDtoTest.expectedMessageEvents)
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/playback/MessagesCommandDto.json")
  String jsonMessagesCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedMessagesCommand);

    JSONAssert.assertEquals(jsonMessagesCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    MessagesCommand deserialized =
        objectMapper.readValue(jsonMessagesCommand, MessagesCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedMessagesCommand);
  }
}
