package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ChoiceMessageDtoTest extends BaseTest {

  public static ChoiceMessage choiceMessageDto =
      ChoiceMessage.builder()
          .setTextMessage(TextMessageDtoTest.textMessageDto)
          .setChoices(
              Collections.singletonList(
                  Choice.builder().setCallMessage(CallMessageDtoTest.callMessageDto).build()))
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/ChoiceMessageDto.json")
  String jsonChoiceMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(choiceMessageDto);

    JSONAssert.assertEquals(jsonChoiceMessageDto, serializedString, true);
  }
}
