package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.FlowChannelSpecificMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.FlowChannelSpecificMessage.FlowActionEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.FlowChannelSpecificMessage.FlowModeEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.FlowChannelSpecificMessageFlowActionPayload;
import com.sinch.sdk.domains.conversation.models.v1.messages.FlowChannelSpecificMessageHeader;
import com.sinch.sdk.domains.conversation.models.v1.messages.WhatsAppInteractiveBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.WhatsAppInteractiveFooter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class FlowChannelSpecificMessageDtoTest extends ConversationBaseTest {

  public static FlowChannelSpecificMessage flowChannelSpecificMessageHeaderDocument =
      createMessage(FlowChannelSpecificMessageHeaderDtoTest.headerDocument);
  public static FlowChannelSpecificMessage flowChannelSpecificMessageHeaderImage =
      createMessage(FlowChannelSpecificMessageHeaderDtoTest.headerImage);
  public static FlowChannelSpecificMessage flowChannelSpecificMessageHeaderText =
      createMessage(FlowChannelSpecificMessageHeaderDtoTest.headerText);
  public static FlowChannelSpecificMessage flowChannelSpecificMessageHeaderVideo =
      createMessage(FlowChannelSpecificMessageHeaderDtoTest.headerVideo);

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/FlowChannelSpecificMessageHeaderDocumentDto.json")
  static String jsonFlowChannelSpecificMessageHeaderDocumentDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/FlowChannelSpecificMessageHeaderImageDto.json")
  static String jsonFlowChannelSpecificMessageHeaderImageDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/FlowChannelSpecificMessageHeaderTextDto.json")
  static String jsonFlowChannelSpecificMessageHeaderTextDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/FlowChannelSpecificMessageHeaderVideoDto.json")
  static String jsonFlowChannelSpecificMessageHeaderVideoDto;

  static FlowChannelSpecificMessage createMessage(FlowChannelSpecificMessageHeader header) {
    Object data =
        Stream.of(
                new Object[][] {
                  {"product_name", "name"},
                  {"product_description", "description"},
                  {"product_price", 100},
                })
            .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
    return FlowChannelSpecificMessage.builder()
        .setFlowId("1")
        .setFlowCta("Book!")
        .setHeader(header)
        .setBody(WhatsAppInteractiveBody.builder().setText("Flow message body").build())
        .setFooter(WhatsAppInteractiveFooter.builder().setText("Flow message footer").build())
        .setFlowToken("AQAAAAACS5FpgQ_cAAAAAD0QI3s.")
        .setFlowMode(FlowModeEnum.DRAFT)
        .setFlowAction(FlowActionEnum.NAVIGATE)
        .setFlowActionPayload(
            FlowChannelSpecificMessageFlowActionPayload.builder()
                .setScreen("<SCREEN_NAME>")
                .setData(data)
                .build())
        .build();
  }

  @Test
  void serializeFlowChannelSpecificMessageDocumentDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(flowChannelSpecificMessageHeaderDocument);

    JSONAssert.assertEquals(
        jsonFlowChannelSpecificMessageHeaderDocumentDto, serializedString, true);
  }

  @Test
  void serializeFlowChannelSpecificMessageImageDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(flowChannelSpecificMessageHeaderImage);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderImageDto, serializedString, true);
  }

  @Test
  void serializeFlowChannelSpecificMessageTextDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(flowChannelSpecificMessageHeaderText);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderTextDto, serializedString, true);
  }

  @Test
  void serializeFlowChannelSpecificMessageVideoDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(flowChannelSpecificMessageHeaderVideo);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderVideoDto, serializedString, true);
  }
}
