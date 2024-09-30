package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ProductItemDtoTest extends ConversationBaseTest {

  public static ProductItem productItemDto =
      ProductItem.builder()
          .setId("product ID value")
          .setMarketplace("marketplace value")
          .setQuantity(4)
          .setItemPrice(3.14159F)
          .setCurrency("currency value")
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/ProductItemDto.json")
  String jsonProductItemDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(productItemDto);

    JSONAssert.assertEquals(jsonProductItemDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonProductItemDto, ProductItem.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(productItemDto);
  }
}
