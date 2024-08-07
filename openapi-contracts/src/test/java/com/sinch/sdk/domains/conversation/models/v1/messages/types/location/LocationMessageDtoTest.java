package com.sinch.sdk.domains.conversation.models.v1.messages.types.location;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class LocationMessageDtoTest extends ConversationBaseTest {

  public static LocationMessage locationMessageDto =
      LocationMessage.builder()
          .setCoordinates(
              Coordinates.builder().setLatitude(47.627980F).setLongitude(-2.822915F).build())
          .setTitle("title value")
          .setLabel("label value")
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/location/LocationMessageDto.json")
  String jsonLocationMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(locationMessageDto);

    JSONAssert.assertEquals(jsonLocationMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonLocationMessageDto, LocationMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(locationMessageDto);
  }
}
