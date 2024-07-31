package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class WhatsAppInteractiveHeaderDtoTest extends ConversationBaseTest {

  public static WhatsAppInteractiveHeaderDocument headerDocument =
      WhatsAppInteractiveHeaderDocument.builder()
          .setDocument(
              WhatsAppInteractiveHeaderMedia.builder().setLink("a document URL link").build())
          .build();
  public static WhatsAppInteractiveHeaderImage headerImage =
      WhatsAppInteractiveHeaderImage.builder()
          .setImage(WhatsAppInteractiveHeaderMedia.builder().setLink("an image URL link").build())
          .build();
  public static WhatsAppInteractiveHeaderText headerText =
      WhatsAppInteractiveHeaderText.builder().setText("text header value").build();
  public static WhatsAppInteractiveHeaderVideo headerVideo =
      WhatsAppInteractiveHeaderVideo.builder()
          .setVideo(WhatsAppInteractiveHeaderMedia.builder().setLink("a video URL link").build())
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/flows/WhatsAppInteractiveHeaderTextDto.json")
  static String jsonFlowChannelSpecificMessageHeaderTextDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/flows/WhatsAppInteractiveHeaderImageDto.json")
  static String jsonFlowChannelSpecificMessageHeaderImageDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/flows/WhatsAppInteractiveHeaderDocumentDto.json")
  static String jsonFlowChannelSpecificMessageHeaderDocumentDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/flows/WhatsAppInteractiveHeaderVideoDto.json")
  static String jsonFlowChannelSpecificMessageHeaderVideoDto;

  @Test
  void serializeDocumentDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(headerDocument);

    JSONAssert.assertEquals(
        jsonFlowChannelSpecificMessageHeaderDocumentDto, serializedString, true);
  }

  @Test
  void deserializeDocumentDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonFlowChannelSpecificMessageHeaderDocumentDto, headerDocument.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(headerDocument);
  }

  @Test
  void serializeImageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(headerImage);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderImageDto, serializedString, true);
  }

  @Test
  void deserializeImageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonFlowChannelSpecificMessageHeaderImageDto, headerImage.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(headerImage);
  }

  @Test
  void serializeTextDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(headerText);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderTextDto, serializedString, true);
  }

  @Test
  void deserializeTextDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonFlowChannelSpecificMessageHeaderTextDto, headerText.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(headerText);
  }

  @Test
  void serializeVideoDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(headerVideo);

    JSONAssert.assertEquals(jsonFlowChannelSpecificMessageHeaderVideoDto, serializedString, true);
  }

  @Test
  void deserializeVideoDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonFlowChannelSpecificMessageHeaderVideoDto, headerVideo.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(headerVideo);
  }
}
