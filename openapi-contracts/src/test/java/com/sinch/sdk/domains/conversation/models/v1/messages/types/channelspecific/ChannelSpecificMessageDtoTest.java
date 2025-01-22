package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.FlowChannelSpecificMessageDtoTest;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ChannelSpecificMessageDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/ChannelSpecificMessageFlowsDto.json")
  static String jsonChannelSpecificMessageFlowsDto;

  @Test
  void deserializeChannelSpecificMessageFlowsDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonChannelSpecificMessageFlowsDto, ChannelSpecificMessage.class);

    TestHelpers.recursiveEquals(
        deserialized, FlowChannelSpecificMessageDtoTest.flowChannelSpecificMessageHeaderDocument);
  }
}
