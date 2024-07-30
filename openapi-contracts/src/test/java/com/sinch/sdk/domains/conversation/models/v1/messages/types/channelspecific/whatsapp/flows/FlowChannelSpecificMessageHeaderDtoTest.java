package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class FlowChannelSpecificMessageHeaderDtoTest extends ConversationBaseTest {

  public static WhatsAppInteractiveHeaderDocument headerDocument =
      WhatsAppInteractiveHeaderDocument.builder()
          .setMedia(WhatsAppInteractiveHeaderMedia.builder().setLink("a document URL link").build())
          .build();
  public static WhatsAppInteractiveHeaderImage headerImage =
      WhatsAppInteractiveHeaderImage.builder()
          .setMedia(WhatsAppInteractiveHeaderMedia.builder().setLink("an image URL link").build())
          .build();
  public static WhatsAppInteractiveHeaderText headerText =
      WhatsAppInteractiveHeaderText.builder().setText("text header value").build();
  public static WhatsAppInteractiveHeaderVideo headerVideo =
      WhatsAppInteractiveHeaderVideo.builder()
          .setMedia(WhatsAppInteractiveHeaderMedia.builder().setLink("a video URL link").build())
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/WhatsAppInteractiveHeaderTextDto.json")
  static String jsonFlowChannelSpecificMessageHeaderTextDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/WhatsAppInteractiveHeaderImageDto.json")
  static String jsonFlowChannelSpecificMessageHeaderImageDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/WhatsAppInteractiveHeaderDocumentDto.json")
  static String jsonFlowChannelSpecificMessageHeaderDocumentDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/WhatsAppInteractiveHeaderVideoDto.json")
  static String jsonFlowChannelSpecificMessageHeaderVideoDto;

  @Test
  void serializeDocumentDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(headerDocument);

    JSONAssert.assertEquals(
        jsonFlowChannelSpecificMessageHeaderDocumentDto, serializedString, true);
  }

  @Test
  void serializeImageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(headerImage);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderImageDto, serializedString, true);
  }

  @Test
  void serializeTextDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(headerText);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderTextDto, serializedString, true);
  }

  @Test
  void serializeVideoDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(headerVideo);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderVideoDto, serializedString, true);
  }
}
