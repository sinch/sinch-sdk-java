package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.adapters.ConversationBaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CoordinatesDtoTest extends ConversationBaseTest {

  public static Coordinates coordinatesDto =
      Coordinates.builder().setLatitude(47.627980F).setLongitude(-2.822915F).build();

  @GivenTextResource("/domains/conversation/v1/messages/CoordinatesDto.json")
  String jsonCoordinatesDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(coordinatesDto);

    JSONAssert.assertEquals(jsonCoordinatesDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCoordinatesDto, Coordinates.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(coordinatesDto);
  }
}
