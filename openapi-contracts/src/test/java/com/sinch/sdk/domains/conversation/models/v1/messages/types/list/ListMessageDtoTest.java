package com.sinch.sdk.domains.conversation.models.v1.messages.types.list;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItem;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItemDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ProductItem;
import com.sinch.sdk.domains.conversation.models.v1.messages.ProductItemDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageDtoTest;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ListMessageDtoTest extends ConversationBaseTest {

  public static ListMessage listMessageChoiceDto =
      ListMessage.builder()
          .setTitle("a list message title value")
          .setDescription("description value")
          .setMessageProperties(
              ListAdditionalProperties.builder()
                  .setCatalogId("catalog ID value")
                  .setMenu("menu value")
                  .build())
          .setSections(
              Collections.singletonList(
                  ListSection.<ChoiceItem>builder()
                      .setTitle("a list section title value")
                      .setItems(Collections.singletonList(ChoiceItemDtoTest.choiceItemDto))
                      .build()))
          .setMedia(MediaMessageDtoTest.mediaMessageDto)
          .build();

  public static ListMessage listMessageChoiceWithWhatsappHeaderDto =
      ListMessage.builder()
          .setTitle("a list message title value")
          .setDescription("description value")
          .setMessageProperties(
              ListAdditionalProperties.builder()
                  .setCatalogId("catalog ID value")
                  .setMenu("menu value")
                  .setWhatsappHeader("my whatsapp header")
                  .build())
          .setSections(
              Collections.singletonList(
                  ListSection.<ChoiceItem>builder()
                      .setTitle("a list section title value")
                      .setItems(Collections.singletonList(ChoiceItemDtoTest.choiceItemDto))
                      .build()))
          .setMedia(MediaMessageDtoTest.mediaMessageDto)
          .build();

  public static ListMessage listMessageProductDto =
      ListMessage.builder()
          .setTitle("a list message title value")
          .setDescription("description value")
          .setMessageProperties(
              ListAdditionalProperties.builder()
                  .setCatalogId("catalog ID value")
                  .setMenu("menu value")
                  .build())
          .setSections(
              Collections.singletonList(
                  ListSection.<ProductItem>builder()
                      .setTitle("a list section title value")
                      .setItems(Collections.singletonList(ProductItemDtoTest.productItemDto))
                      .build()))
          .setMedia(MediaMessageDtoTest.mediaMessageDto)
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/list/ListMessageChoiceDto.json")
  String jsonListMessageChoiceDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/list/ListMessageChoiceWithWhatsappHeaderDto.json")
  String jsonListMessageChoiceWithWhatsappHeaderDto;

  @GivenTextResource("/domains/conversation/v1/messages/types/list/ListMessageProductDto.json")
  String jsonListMessageProductDto;

  @Test
  void serializeListMessageChoiceDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(listMessageChoiceDto);

    JSONAssert.assertEquals(jsonListMessageChoiceDto, serializedString, true);
  }

  @Test
  void deserializeListMessageChoiceDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonListMessageChoiceDto, ListMessage.class);

    TestHelpers.recursiveEquals(deserialized, listMessageChoiceDto);
  }

  @Test
  void serializeListMessageChoiceWithWhatsappHeaderDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(listMessageChoiceWithWhatsappHeaderDto);

    JSONAssert.assertEquals(jsonListMessageChoiceWithWhatsappHeaderDto, serializedString, true);
  }

  @Test
  void deserializeListMessageChoiceWithWhatsappHeaderDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonListMessageChoiceWithWhatsappHeaderDto, ListMessage.class);

    TestHelpers.recursiveEquals(deserialized, listMessageChoiceWithWhatsappHeaderDto);
  }

  @Test
  void serializeListMessageProductDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(listMessageProductDto);

    JSONAssert.assertEquals(jsonListMessageProductDto, serializedString, true);
  }

  @Test
  void deserializeListMessageProductDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonListMessageProductDto, ListMessage.class);

    TestHelpers.recursiveEquals(deserialized, listMessageProductDto);
  }
}
