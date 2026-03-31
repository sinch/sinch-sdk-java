package com.sinch.sdk.domains.conversation.models.v1.eventdestinations;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.eventdestinations.request.EventDestinationCreateRequest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class EventDestinationDtoTest extends ConversationBaseTest {

  public static EventDestinationCreateRequest expectedRequestDto =
      EventDestinationCreateRequest.builder()
          .setAppId("an app id")
          .setTarget("https://fake.url/ConversationEvent")
          .setTargetType(EventDestinationTargetType.HTTP)
          .setSecret("my secret value")
          .setTriggers(
              Arrays.asList(
                  EventDestinationTrigger.CAPABILITY,
                  EventDestinationTrigger.CHANNEL_EVENT,
                  EventDestinationTrigger.CONTACT_CREATE,
                  EventDestinationTrigger.UNSUPPORTED))
          .setClientCredentials(ClientCredentialsDtoTest.expectedDto)
          .build();

  public static EventDestination expectedResponseDto =
      EventDestination.builder()
          .setId("a webhook id")
          .setAppId("an app id")
          .setTarget("https://fake.url/ConversationEvent")
          .setTargetType(EventDestinationTargetType.HTTP)
          .setSecret("my secret value")
          .setTriggers(
              Arrays.asList(
                  EventDestinationTrigger.CAPABILITY,
                  EventDestinationTrigger.CHANNEL_EVENT,
                  EventDestinationTrigger.CONTACT_CREATE,
                  EventDestinationTrigger.UNSUPPORTED))
          .setClientCredentials(ClientCredentialsDtoTest.expectedDto)
          .build();

  @GivenTextResource(
      "domains/conversation/v1/eventdestinations/request/EventDestinationRequestDto.json")
  String requestJSON;

  @GivenTextResource(
      "/domains/conversation/v1/eventdestinations/response/EventDestinationResponseDto.json")
  String responseJSON;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedRequestDto);

    JSONAssert.assertEquals(requestJSON, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {

    Object deserialized = objectMapper.readValue(responseJSON, EventDestination.class);
    TestHelpers.recursiveEquals(deserialized, expectedResponseDto);
  }
}
