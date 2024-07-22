package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ListMessageDtoTest extends ConversationBaseTest {

  public static ListItem<ChoiceItem> itemChoice =
      ChoiceItem.builder()
          .setTitle("choice title")
          .setDescription("description value")
          .setMedia(MediaMessageDtoTest.mediaMessageDto)
          .setPostbackData("postback value")
          .build();

  public static ListItem<ProductItem> itemProduct =
      ProductItem.builder()
          .setId("product ID value")
          .setMarketplace("marketplace value")
          .setQuantity(4)
          .setItemPrice(3.14159F)
          .setCurrency("currency value")
          .build();
  public static ListMessage listMessageChoiceDto =
      ListMessage.builder()
          .setTitle("a list message title value")
          .setDescription("description value")
          .setMessageProperties(
              ListMessageMessageProperties.builder()
                  .setCatalogId("catalog ID value")
                  .setMenu("menu value")
                  .build())
          .setSections(
              Collections.singletonList(
                  ListSection.<ChoiceItem>builder()
                      .setTitle("a list section title value")
                      .setItems(Collections.singletonList(itemChoice))
                      .build()))
          .build();

  public static ListMessage listMessageProductDto =
      ListMessage.builder()
          .setTitle("a list message title value")
          .setDescription("description value")
          .setMessageProperties(
              ListMessageMessageProperties.builder()
                  .setCatalogId("catalog ID value")
                  .setMenu("menu value")
                  .build())
          .setSections(
              Collections.singletonList(
                  ListSection.<ProductItem>builder()
                      .setTitle("a list section title value")
                      .setItems(Collections.singletonList(itemProduct))
                      .build()))
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/ListMessageChoiceDto.json")
  String jsonListMessageChoiceDto;

  @GivenTextResource("/domains/conversation/v1/messages/ListMessageProductDto.json")
  String jsonListMessageProductDto;

  @Test
  void serializeMessageChoiceDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(listMessageChoiceDto);

    JSONAssert.assertEquals(jsonListMessageChoiceDto, serializedString, true);
  }

  @Test
  void deserializeMessageChoiceDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonListMessageChoiceDto, ListMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(listMessageChoiceDto);
  }

  @Test
  void serializeMessageProductDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(listMessageProductDto);

    JSONAssert.assertEquals(jsonListMessageProductDto, serializedString, true);
  }

  @Test
  void deserializeMessageProductDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonListMessageProductDto, ListMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(listMessageProductDto);
  }
}