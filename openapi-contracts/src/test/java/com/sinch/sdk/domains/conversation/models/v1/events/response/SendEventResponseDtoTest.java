package com.sinch.sdk.domains.conversation.models.v1.events.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SendEventResponseDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/response/SendEventResponseDto.json")
  SendEventResponse sendEventResponseDto;

  public static SendEventResponse expectedResponse =
      SendEventResponse.builder()
          .setEventId("event id")
          .setAcceptedTime(Instant.parse("2024-06-18T12:34:56Z"))
          .build();

  @Test
  void deserializeSendEventResponseDto() {
    TestHelpers.recursiveEquals(sendEventResponseDto, expectedResponse);
  }
}
