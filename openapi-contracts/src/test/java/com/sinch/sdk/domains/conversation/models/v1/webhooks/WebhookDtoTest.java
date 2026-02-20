package com.sinch.sdk.domains.conversation.models.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.request.CreateWebhookRequest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class WebhookDtoTest extends ConversationBaseTest {

  public static CreateWebhookRequest expectedRequestDto =
      CreateWebhookRequest.builder()
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

  public static Webhook expectedResponseDto =
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

  @GivenTextResource("domains/conversation/v1/webhooks/WebhookRequestDto.json")
  String requestJSON;

  @GivenTextResource("/domains/conversation/v1/webhooks/WebhookResponseDto.json")
  String responseJSON;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedRequestDto);

    JSONAssert.assertEquals(requestJSON, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {

    Object deserialized = objectMapper.readValue(responseJSON, Webhook.class);
    TestHelpers.recursiveEquals(deserialized, expectedResponseDto);
  }
}
