package com.sinch.sdk.domains.conversation.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class AgentDtoTest extends BaseTest {

  public static Agent expectedDto =
      Agent.builder()
          .setDisplayName("display_name value")
          .setType(AgentType.BOT)
          .setPictureUrl("picture_url value")
          .build();

  @GivenJsonResource("domains/conversation/v1/AgentDto.json")
  Agent dto;

  @GivenTextResource("/domains/conversation/v1/AgentDto.json")
  String json;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedDto);
  }
}
