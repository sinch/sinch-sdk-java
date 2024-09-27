package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.unsupported;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class UnsupportedCallbackEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource(
      "domains/conversation/v1/webhooks/events/unsupported/UnsupportedCallbackEventDto.json")
  UnsupportedCallbackEvent unsupportedCallbackEventDto;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/unsupported/UnsupportedCallbackEventDto.json")
  String jsonUnsupportedCallbackEventDto;

  public static UnsupportedCallbackEvent expectedUnsupportedCallbackEvent =
      UnsupportedCallbackEvent.builder()
          .setAppId("app id value")
          .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
          .setMessageMetadata("metadata value")
          .setProjectId("project id value")
          .setCorrelationId("correlation id value")
          .setCallback(
              UnsupportedCallbackEventCallback.builder()
                  .setChannel(ConversationChannel.MESSENGER)
                  .setPayload("payload value")
                  .setProcessingMode(ProcessingMode.DISPATCH)
                  .setId("id value")
                  .setContactId("contact id")
                  .setConversationId("conversation id")
                  .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
                  .build())
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedUnsupportedCallbackEvent);
    JSONAssert.assertEquals(jsonUnsupportedCallbackEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(unsupportedCallbackEventDto, expectedUnsupportedCallbackEvent);
  }
}
