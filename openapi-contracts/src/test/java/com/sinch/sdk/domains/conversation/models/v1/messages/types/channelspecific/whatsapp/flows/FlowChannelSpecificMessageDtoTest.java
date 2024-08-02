package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.FlowChannelSpecificMessage.FlowActionEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.FlowChannelSpecificMessage.FlowModeEnum;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class FlowChannelSpecificMessageDtoTest extends ConversationBaseTest {

  public static FlowChannelSpecificMessage flowChannelSpecificMessageHeaderDocument =
      createMessage(WhatsAppInteractiveHeaderDtoTest.headerDocument);
  public static FlowChannelSpecificMessage flowChannelSpecificMessageHeaderImage =
      createMessage(WhatsAppInteractiveHeaderDtoTest.headerImage);
  public static FlowChannelSpecificMessage flowChannelSpecificMessageHeaderText =
      createMessage(WhatsAppInteractiveHeaderDtoTest.headerText);
  public static FlowChannelSpecificMessage flowChannelSpecificMessageHeaderVideo =
      createMessage(WhatsAppInteractiveHeaderDtoTest.headerVideo);

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/flows/FlowChannelSpecificMessageHeaderDocumentDto.json")
  static String jsonFlowChannelSpecificMessageHeaderDocumentDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/flows/FlowChannelSpecificMessageHeaderImageDto.json")
  static String jsonFlowChannelSpecificMessageHeaderImageDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/flows/FlowChannelSpecificMessageHeaderTextDto.json")
  static String jsonFlowChannelSpecificMessageHeaderTextDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/flows/FlowChannelSpecificMessageHeaderVideoDto.json")
  static String jsonFlowChannelSpecificMessageHeaderVideoDto;

  static FlowChannelSpecificMessage createMessage(WhatsAppInteractiveHeader header) {
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
  void deserializeFlowChannelSpecificMessageDocumentDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonFlowChannelSpecificMessageHeaderDocumentDto,
            flowChannelSpecificMessageHeaderDocument.getClass());

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(flowChannelSpecificMessageHeaderDocument);
  }

  @Test
  void serializeFlowChannelSpecificMessageImageDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(flowChannelSpecificMessageHeaderImage);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderImageDto, serializedString, true);
  }

  @Test
  void deserializeFlowChannelSpecificMessageImageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonFlowChannelSpecificMessageHeaderImageDto,
            flowChannelSpecificMessageHeaderImage.getClass());

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(flowChannelSpecificMessageHeaderImage);
  }

  @Test
  void serializeFlowChannelSpecificMessageTextDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(flowChannelSpecificMessageHeaderText);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderTextDto, serializedString, true);
  }

  @Test
  void deserializeFlowChannelSpecificMessageTextDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonFlowChannelSpecificMessageHeaderTextDto,
            flowChannelSpecificMessageHeaderText.getClass());

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(flowChannelSpecificMessageHeaderText);
  }

  @Test
  void serializeFlowChannelSpecificMessageVideoDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(flowChannelSpecificMessageHeaderVideo);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderVideoDto, serializedString, true);
  }

  @Test
  void deserializeFlowChannelSpecificMessageVideoDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonFlowChannelSpecificMessageHeaderVideoDto,
            flowChannelSpecificMessageHeaderVideo.getClass());

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(flowChannelSpecificMessageHeaderVideo);
  }
}
