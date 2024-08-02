package com.sinch.sdk.domains.conversation.models.v1.messages.types.productresponse;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ProductItemDtoTest;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ProductResponseMessageDtoTest extends ConversationBaseTest {

  public static ProductResponseMessage productResponseMessageDto =
      ProductResponseMessage.builder()
          .setTitle("a product response message title value")
          .setCatalogId("catalog id value")
          .setProducts(Arrays.asList(ProductItemDtoTest.productItemDto))
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/productresponse/ProductResponseMessageDto.json")
  String jsonProductResponseMessageDto;

  @Test
  void serializeMessageChoiceDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(productResponseMessageDto);

    JSONAssert.assertEquals(jsonProductResponseMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageChoiceDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonProductResponseMessageDto, ProductResponseMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(productResponseMessageDto);
  }
}
