package com.sinch.sdk.domains.conversation.models.v1.webhooks.events;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ChannelIdentityDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/ChannelIdentityDto.json")
  ChannelIdentity dto;

  @GivenTextResource("domains/conversation/v1/ChannelIdentityDto.json")
  String json;

  public static ChannelIdentity expectedDto =
      ChannelIdentity.builder()
          .setAppId("an app id")
          .setChannel(ConversationChannel.MESSENGER)
          .setIdentity("an identity")
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);
    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedDto);
  }
}
