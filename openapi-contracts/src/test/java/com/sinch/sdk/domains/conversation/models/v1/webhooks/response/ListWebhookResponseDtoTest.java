package com.sinch.sdk.domains.conversation.models.v1.webhooks.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ListWebhookResponseDtoTest extends ConversationBaseTest {

  public static ListWebhooksResponse expectedRequestDto =
      ListWebhooksResponse.builder()
          .setWebhooks(Arrays.asList(WebhookDtoTest.expectedRequestDto))
          .build();
  public static ListWebhooksResponse expectedResponseDto =
      ListWebhooksResponse.builder()
          .setWebhooks(Arrays.asList(WebhookDtoTest.expectedResponseDto))
          .build();

  @GivenJsonResource("domains/conversation/v1/webhooks/response/ListWebhooksResponseDto.json")
  ListWebhooksResponse dto;

  @GivenTextResource("/domains/conversation/v1/webhooks/response/ListWebhooksRequestDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedRequestDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedResponseDto);
  }
}
