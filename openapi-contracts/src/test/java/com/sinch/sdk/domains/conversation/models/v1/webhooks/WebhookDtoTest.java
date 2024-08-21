package com.sinch.sdk.domains.conversation.models.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class WebhookDtoTest extends ConversationBaseTest {

  public static Webhook expectedDto =
      Webhook.builder()
          .setId("a webhook id")
          .setAppId("an app id")
          .setTarget("https://fake.url/ConversationEvent")
          .setTargetType(WebhookTargetType.HTTP)
          .setSecret("my secret value")
          .setTriggers(
              Arrays.asList(
                  WebhookTrigger.CAPABILITY,
                  WebhookTrigger.CHANNEL_EVENT,
                  WebhookTrigger.CONTACT_CREATE,
                  WebhookTrigger.UNSUPPORTED))
          .setClientCredentials(ClientCredentialsDtoTest.expectedDto)
          .build();

  @GivenJsonResource("domains/conversation/v1/webhooks/WebhookDto.json")
  Webhook dto;

  @GivenTextResource("/domains/conversation/v1/webhooks/WebhookDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);

    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedDto);
  }
}
