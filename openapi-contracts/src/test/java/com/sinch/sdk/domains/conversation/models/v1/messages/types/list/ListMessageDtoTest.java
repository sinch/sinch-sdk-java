package com.sinch.sdk.domains.conversation.models.v1.messages.types.list;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItem;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceItemDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ProductItem;
import com.sinch.sdk.domains.conversation.models.v1.messages.ProductItemDtoTest;
import java.util.Collections;
import org.assertj.core.api.Assertions;
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
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/list/ListMessageChoiceDto.json")
  String jsonListMessageChoiceDto;

  @GivenTextResource("/domains/conversation/v1/messages/types/list/ListMessageProductDto.json")
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
