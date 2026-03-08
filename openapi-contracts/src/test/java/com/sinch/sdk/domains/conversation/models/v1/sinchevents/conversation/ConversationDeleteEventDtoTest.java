package com.sinch.sdk.domains.conversation.models.v1.sinchevents.conversation;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.ConversationDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.internal.ConversationSinchEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.internal.ConversationSinchEventInternalImpl;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ConversationDeleteEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource(
      "domains/conversation/v1/sinchevents/conversation/ConversationDeleteEventDto.json")
  ConversationSinchEventInternal eventDto;

  public static ConversationSinchEventInternal expectedEventDto =
      new ConversationSinchEventInternalImpl(
          (ConversationDeleteEventImpl)
              ConversationDeleteEvent.builder()
                  .setAppId("app id value")
                  .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
                  .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
                  .setMessageMetadata("metadata value")
                  .setProjectId("project id value")
                  .setCorrelationId("correlation id value")
                  .setNotification(
                      ConversationNotification.builder()
                          .setConversation(ConversationDtoTest.conversationResponse)
                          .build())
                  .build());

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(eventDto, expectedEventDto);
  }
}
