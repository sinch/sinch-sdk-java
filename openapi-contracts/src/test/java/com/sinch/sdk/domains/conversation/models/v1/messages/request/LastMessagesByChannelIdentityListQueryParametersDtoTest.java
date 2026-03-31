package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import java.time.Instant;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class LastMessagesByChannelIdentityListQueryParametersDtoTest extends ConversationBaseTest {

  public static LastMessagesByChannelIdentityListQueryParameters
      listLastMessagesByChannelIdentityRequest =
          LastMessagesByChannelIdentityListQueryParameters.builder()
              .setAppId("an application ID")
              .setMessagesSource(MessageSource.CONVERSATION_SOURCE)
              .setChannelIdentities(Arrays.asList("447700900000", "447700900001", "447700900002"))
              .setDirection(ConversationDirection.TO_CONTACT)
              .setView(ConversationMessagesView.WITHOUT_METADATA)
              .setChannel(ConversationChannel.WHATSAPP)
              .setStartTime(Instant.parse("2026-01-01T08:30:00Z"))
              .setEndTime(Instant.parse("2026-01-31T22:30:00Z"))
              .setPageSize(100)
              .setPageToken("a page token")
              .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/ListLastMessagesByChannelIdentityRequestDto.json")
  static String listLastMessagesByChannelIdentityRequestDto;

  @Test
  void serializeListLastMessagesByChannelIdentityRequestDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(listLastMessagesByChannelIdentityRequest);

    JSONAssert.assertEquals(listLastMessagesByChannelIdentityRequestDto, serializedString, true);
  }
}
