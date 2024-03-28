package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ProductItem;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ListMessageDtoTest extends BaseTest {

  static ListItem itemChoice =
      ListItem.builder()
          .setItem(
              ListItemItem.builder()
                  .setChoice(
                      ListItemChoice.builder()
                          .setTitle("choice title")
                          .setDescription("description value")
                          .setMedia(
                              ListItemMediaMessage.builder()
                                  .setMediaMessage(MediaMessageDtoTest.mediaMessageDto)
                                  .build())
                          .setPostbackData("postback value")
                          .build())
                  .build())
          .build();

  static ListItem itemProduct =
      ListItem.builder()
          .setItem(
              ListItemItem.builder()
                  .setProduct(
                      ProductItem.builder()
                          .setId("product ID value")
                          .setMarketplace("marketplace value")
                          .setQuantity(4)
                          .setItemPrice(3.14159F)
                          .setCurrency("currency value")
                          .build())
                  .build())
          .build();
  public static ListMessage listMessageDto =
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
                  ListSection.builder()
                      .setTitle("a list section title value")
                      .setItems(Arrays.asList(itemChoice, itemProduct))
                      .build()))
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/ListMessageDto.json")
  String jsonListMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(listMessageDto);

    JSONAssert.assertEquals(jsonListMessageDto, serializedString, true);
  }
}
