package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.ReasonDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.internal.ConversationEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.internal.ConversationEventInternalImpl;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class MessageDeliveryReceiptEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource(
      "domains/conversation/v1/webhooks/events/delivery/MessageDeliveryReceiptEventDto.json")
  ConversationEventInternal eventDto;

  public static ConversationEventInternal expectedEventDto =
      new ConversationEventInternalImpl(
          (MessageDeliveryReceiptEventImpl)
              MessageDeliveryReceiptEvent.builder()
                  .setAppId("app id value")
                  .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
                  .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
                  .setMessageMetadata("metadata value")
                  .setProjectId("project id value")
                  .setCorrelationId("correlation id value")
                  .setReport(
                      MessageDeliveryReport.builder()
                          .setMessageId("message id")
                          .setConversationId("conversation id")
                          .setStatus(DeliveryStatus.DELIVERED)
                          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
                          .setContactId("contact ID")
                          .setReason(ReasonDtoTest.expectedDto)
                          .setMetadata("metadata value")
                          .setProcessingMode(ProcessingMode.DISPATCH)
                          .build())
                  .build());

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(eventDto, expectedEventDto);
  }
}
