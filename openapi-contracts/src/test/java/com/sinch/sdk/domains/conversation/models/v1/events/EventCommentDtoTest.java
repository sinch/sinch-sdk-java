package com.sinch.sdk.domains.conversation.models.v1.events;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.events.EventComment.CommentTypeEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class EventCommentDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/EventCommentDto.json")
  EventComment dto;

  @GivenTextResource("domains/conversation/v1/events/EventCommentDto.json")
  String json;

  public static EventComment expectedDto =
      EventComment.builder()
          .setId("comment id")
          .setText("text value")
          .setCommentType(CommentTypeEnum.LIVE)
          .setCommentedOn("https/my.link.com")
          .setUser("user name")
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);
    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedDto);
  }
}
