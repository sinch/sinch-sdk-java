package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.capability;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ReasonDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.capability.CapabilityEventNotification.CapabilityStatusEnum;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.internal.ConversationEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.internal.ConversationEventInternalImpl;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class CapabilityEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/webhooks/events/capability/CapabilityEventDto.json")
  ConversationEventInternal eventDto;

  public static ConversationEventInternal expectedEventDto =
      new ConversationEventInternalImpl(
          (CapabilityEventImpl)
              CapabilityEvent.builder()
                  .setAppId("app id value")
                  .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
                  .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
                  .setMessageMetadata("metadata value")
                  .setProjectId("project id value")
                  .setCorrelationId("correlation id value")
                  .setNotification(
                      CapabilityEventNotification.builder()
                          .setContactId("contact id value")
                          .setIdentity("12345678910")
                          .setChannel(ConversationChannel.WHATSAPP)
                          .setCapabilityStatus(CapabilityStatusEnum.CAPABILITY_PARTIAL)
                          .setRequestId("request id value")
                          .setChannelCapabilities(Arrays.asList("capability value"))
                          .setReason(ReasonDtoTest.expectedWithChannelCodeDto)
                          .build())
                  .build());

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(eventDto, expectedEventDto);
  }
}
