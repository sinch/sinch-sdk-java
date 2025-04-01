package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.FlowChannelSpecificMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderStatusDtoTest;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ChannelSpecificMessageDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/ChannelSpecificMessageFlowsDto.json")
  static String jsonChannelSpecificMessageFlowsDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/ChannelSpecificMessageOrderStatusDto.json")
  static String jsonChannelSpecificMessageOrderStatusDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/ChannelSpecificMessageOrderDetailsDto.json")
  static String jsonChannelSpecificMessageOrderDetailsDto;

  @Test
  void deserializeChannelSpecificMessageFlowsDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonChannelSpecificMessageFlowsDto, ChannelSpecificMessage.class);

    TestHelpers.recursiveEquals(
        deserialized, FlowChannelSpecificMessageDtoTest.flowChannelSpecificMessageHeaderDocument);
  }

  @Test
  void deserializeChannelSpecificMessageOrderStatusDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonChannelSpecificMessageOrderStatusDto, ChannelSpecificMessage.class);

    TestHelpers.recursiveEquals(deserialized, OrderStatusDtoTest.ORDER_STATUS_DTO);
  }

  @Test
  void deserializeChannelSpecificMessageOrderDetailsDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonChannelSpecificMessageOrderDetailsDto, ChannelSpecificMessage.class);

    TestHelpers.recursiveEquals(deserialized, OrderDetailsDtoTest.ORDER_DETAILS_DTO);
  }
}
