package com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ReasonDtoTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class FallbackMessageDtoTest extends ConversationBaseTest {

  public static FallbackMessage choiceFallbackMessageDto =
      FallbackMessage.builder()
          .setRawMessage("raw message value")
          .setReason(ReasonDtoTest.expectedWithChannelCodeDto)
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/fallback/FallbackMessageDto.json")
  String jsonFallbackMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(choiceFallbackMessageDto);

    JSONAssert.assertEquals(jsonFallbackMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonFallbackMessageDto, FallbackMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(choiceFallbackMessageDto);
  }
}
