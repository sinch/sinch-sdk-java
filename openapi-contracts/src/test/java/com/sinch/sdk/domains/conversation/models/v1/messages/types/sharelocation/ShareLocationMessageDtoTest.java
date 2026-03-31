package com.sinch.sdk.domains.conversation.models.v1.messages.types.sharelocation;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ShareLocationMessageDtoTest extends ConversationBaseTest {

  public static ShareLocationMessage shareLocationMessageDto =
      ShareLocationMessage.builder()
          .setTitle("Share Location Example")
          .setFallbackUrl("https://maps.example.com/?q=37.7749,-122.4194")
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/sharelocation/ShareLocationMessageDto.json")
  String jsonShareLocationMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(shareLocationMessageDto);

    JSONAssert.assertEquals(jsonShareLocationMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonShareLocationMessageDto, ShareLocationMessage.class);

    TestHelpers.recursiveEquals(deserialized, shareLocationMessageDto);
  }
}
