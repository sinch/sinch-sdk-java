package com.sinch.sdk.domains.conversation.models.v1.messages.types.calendar;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CalendarMessageDtoTest extends ConversationBaseTest {

  public static CalendarMessage calendarMessageDto =
      CalendarMessage.builder()
          .setTitle("Calendar Message Example")
          .setEventStart(Instant.parse("2023-10-01T10:00:00Z"))
          .setEventEnd(Instant.parse("2023-10-01T11:00:00Z"))
          .setEventTitle("Team Meeting")
          .setEventDescription("Monthly team sync-up")
          .setFallbackUrl("https://calendar.example.com/event/12345")
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/calendar/CalendarMessageDto.json")
  String jsonCalendarMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(calendarMessageDto);

    JSONAssert.assertEquals(jsonCalendarMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCalendarMessageDto, CalendarMessage.class);

    TestHelpers.recursiveEquals(deserialized, calendarMessageDto);
  }
}
