package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ShortLinkActivatedEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/types/ShortLinkActivatedEventDto.json")
  ShortLinkActivatedEvent dtoShortLinkActivatedEventDto;

  @GivenTextResource("domains/conversation/v1/events/types/ShortLinkActivatedEventDto.json")
  String jsonShortLinkActivatedEventDto;

  public static ShortLinkActivatedEvent expectedShortLinkActivatedEventDto =
      ShortLinkActivatedEvent.builder()
          .setPayload("payload value")
          .setTitle("title value")
          .setRef("ref value")
          .setSource("SHORTLINK")
          .setType("OPEN_THREAD")
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedShortLinkActivatedEventDto);
    JSONAssert.assertEquals(jsonShortLinkActivatedEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dtoShortLinkActivatedEventDto, expectedShortLinkActivatedEventDto);
  }
}
