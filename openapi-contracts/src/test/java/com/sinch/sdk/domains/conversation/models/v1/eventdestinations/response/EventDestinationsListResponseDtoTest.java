package com.sinch.sdk.domains.conversation.models.v1.eventdestinations.response;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.eventdestinations.EventDestinationDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.eventdestinations.internal.EventDestinationsListResponseInternal;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class EventDestinationsListResponseDtoTest extends ConversationBaseTest {

  @GivenJsonResource(
      "domains/conversation/v1/eventdestinations/response/EventDestinationsListResponseDto.json")
  EventDestinationsListResponseInternal dto;

  public static EventDestinationsListResponseInternal expectedResponseDto =
      EventDestinationsListResponseInternal.builder()
          .setEventDestinations(Arrays.asList(EventDestinationDtoTest.expectedResponseDto))
          .build();

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedResponseDto);
  }
}
