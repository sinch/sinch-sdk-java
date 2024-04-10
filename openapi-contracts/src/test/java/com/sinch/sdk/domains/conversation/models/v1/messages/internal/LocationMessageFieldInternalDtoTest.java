package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessageDtoTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class LocationMessageFieldInternalDtoTest extends ConversationBaseTest {

  public static LocationMessageFieldInternal locationMessageDto =
      LocationMessageFieldInternal.builder()
          .setLocationMessage(LocationMessageDtoTest.locationMessageDto)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/internal/LocationMessageFieldInternalDto.json")
  String jsonLocationMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(locationMessageDto);

    JSONAssert.assertEquals(jsonLocationMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonLocationMessageDto, locationMessageDto.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(locationMessageDto);
  }
}
