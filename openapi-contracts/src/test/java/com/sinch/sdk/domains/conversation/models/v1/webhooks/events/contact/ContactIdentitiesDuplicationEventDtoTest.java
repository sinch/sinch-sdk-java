package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.contact;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.internal.ConversationEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.internal.ConversationEventInternalImpl;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ContactIdentitiesDuplicationEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource(
      "domains/conversation/v1/webhooks/events/contact/ContactIdentitiesDuplicationEventDto.json")
  ConversationEventInternal eventDto;

  public static ConversationEventInternal expectedEventDto =
      new ConversationEventInternalImpl(
          (ContactIdentitiesDuplicationEventImpl)
              ContactIdentitiesDuplicationEvent.builder()
                  .setAppId("app id value")
                  .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
                  .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
                  .setMessageMetadata("metadata value")
                  .setProjectId("project id value")
                  .setCorrelationId("correlation id value")
                  .setDuplicatedIdentities(
                      Arrays.asList(
                          DuplicatedIdentities.builder()
                              .setChannel(ConversationChannel.from("channel"))
                              .setContactIds(
                                  Arrays.asList(
                                      "01EKA07N79THJ20ZSN6AS30TMW", "01EKA07N79THJ20ZSN6AS30TTT"))
                              .build()))
                  .build());

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(eventDto, expectedEventDto);
  }
}
