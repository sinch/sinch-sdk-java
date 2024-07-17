package com.sinch.sdk.domains.conversation.models.v1.events;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.events.contact.internal.ContactEventInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.conversation.EventConversationDeletedDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.conversation.EventConversationDeletedImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ContactEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/EventComposingDto.json")
  ContactEventInternalImpl dtoEventComposing;

  @GivenTextResource("domains/conversation/v1/events/EventComposingDto.json")
  String jsonEventComposing;

  @GivenJsonResource("domains/conversation/v1/events/EventComposingEndDto.json")
  ContactEventInternalImpl dtoEventComposingEnd;

  @GivenTextResource("domains/conversation/v1/events/EventComposingEndDto.json")
  String jsonEventComposingEnd;

  @GivenJsonResource("domains/conversation/v1/events/conversation/EventConversationDeletedDto.json")
  ContactEventInternalImpl dtoConversationDeleteEvent;

  @GivenTextResource("domains/conversation/v1/events/conversation/EventConversationDeletedDto.json")
  String jsonConversationDeleteEvent;

  @GivenJsonResource("domains/conversation/v1/events/EventCommentDto.json")
  ContactEventInternalImpl dtoEventCommentDto;

  @GivenTextResource("domains/conversation/v1/events/EventCommentDto.json")
  String jsonEventCommentDto;

  @GivenJsonResource("domains/conversation/v1/events/EventGenericDto.json")
  ContactEventInternalImpl dtoEventGenericDto;

  @GivenTextResource("domains/conversation/v1/events/EventGenericDto.json")
  String jsonEventGenericDto;

  public static ContactEventInternalImpl expectedComposingDto =
      new ContactEventInternalImpl((EventComposingImpl) EventComposingDtoTest.expectedDto);

  public static ContactEventInternalImpl expectedComposingEndDto =
      new ContactEventInternalImpl((EventComposingEndImpl) EventComposingEndDtoTest.expectedDto);

  public static ContactEventInternalImpl expectedEventConversationDeletedDto =
      new ContactEventInternalImpl(
          (EventConversationDeletedImpl) EventConversationDeletedDtoTest.expectedDto);

  public static ContactEventInternalImpl expectedEventCommentDto =
      new ContactEventInternalImpl((EventCommentImpl) EventCommentDtoTest.expectedDto);

  public static ContactEventInternalImpl expectedEventGenericDto =
      new ContactEventInternalImpl((EventGenericImpl) EventGenericDtoTest.expectedDto);

  @Test
  void serializeEventComposingDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedComposingDto);
    JSONAssert.assertEquals(jsonEventComposing, serializedString, true);
  }

  @Test
  void deserializeEventComposingDto() {
    TestHelpers.recursiveEquals(dtoEventComposing, expectedComposingDto);
  }

  @Test
  void serializeEventComposingEndDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedComposingEndDto);
    JSONAssert.assertEquals(jsonEventComposingEnd, serializedString, true);
  }

  @Test
  void deserializeEventComposingEndDto() {
    TestHelpers.recursiveEquals(dtoEventComposingEnd, expectedComposingEndDto);
  }

  @Test
  void serializeConversationDeletedEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedEventConversationDeletedDto);
    JSONAssert.assertEquals(jsonConversationDeleteEvent, serializedString, true);
  }

  @Test
  void deserializeConversationDeletedEventDto() {
    TestHelpers.recursiveEquals(dtoConversationDeleteEvent, expectedEventConversationDeletedDto);
  }

  @Test
  void serializeEventCommentDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedEventCommentDto);
    JSONAssert.assertEquals(jsonEventCommentDto, serializedString, true);
  }

  @Test
  void deserializeEventCommentDto() {
    TestHelpers.recursiveEquals(dtoEventCommentDto, expectedEventCommentDto);
  }

  @Test
  void serializeEventGenericDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedEventGenericDto);
    JSONAssert.assertEquals(jsonEventGenericDto, serializedString, true);
  }

  @Test
  void deserializeEventGenericDto() {
    TestHelpers.recursiveEquals(dtoEventGenericDto, expectedEventGenericDto);
  }
}
