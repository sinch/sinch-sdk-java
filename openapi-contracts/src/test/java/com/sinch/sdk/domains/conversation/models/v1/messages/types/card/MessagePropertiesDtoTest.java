package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MessagePropertiesDtoTest extends ConversationBaseTest {

  public static MessageProperties messagePropertiesDto =
      MessageProperties.builder().setWhatsappHeader("WhatsApp Header value").build();

  @GivenTextResource("/domains/conversation/v1/messages/types/card/MessagePropertiesDto.json")
  String jsonMessagePropertiesDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(messagePropertiesDto);

    JSONAssert.assertEquals(jsonMessagePropertiesDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonMessagePropertiesDto, MessageProperties.class);

    TestHelpers.recursiveEquals(deserialized, messagePropertiesDto);
  }
}
