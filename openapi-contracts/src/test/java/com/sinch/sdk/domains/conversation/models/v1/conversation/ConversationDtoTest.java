package com.sinch.sdk.domains.conversation.models.v1.conversation;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.time.Instant;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ConversationDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/conversation/ConversationDto.json")
  Conversation dto;

  public static Conversation conversation =
      Conversation.builder()
          .setActive(true)
          .setActiveChannel(ConversationChannel.WHATSAPP)
          .setAppId("conversation app Id")
          .setContactId("contact ID")
          .setId("a conversation id")
          .setLastReceived(Instant.parse("2020-11-17T15:00:00Z"))
          .setMetadata("metadata value")
          .setMetadataJson(Collections.singletonMap("metadata_json_key", "metadata json value"))
          .setCorrelationId("correlation id value")
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, conversation);
  }
}
