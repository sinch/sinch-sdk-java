package com.sinch.sdk.domains.conversation.models.v1.events;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.events.internal.ContactEventInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.CommentEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.CommentEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEndEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEndEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ConversationDeletedEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ConversationDeletedEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.GenericEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.GenericEventImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ContactEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/types/ComposingEventDto.json")
  ContactEventInternalImpl dtoComposingEvent;

  @GivenTextResource("domains/conversation/v1/events/types/ComposingEventDto.json")
  String jsonComposingEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/ComposingEndEventDto.json")
  ContactEventInternalImpl dtoComposingEndEvent;

  @GivenTextResource("domains/conversation/v1/events/types/ComposingEndEventDto.json")
  String jsonComposingEndEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/ConversationDeletedEventDto.json")
  ContactEventInternalImpl dtoConversationDeletedEvent;

  @GivenTextResource("domains/conversation/v1/events/types/ConversationDeletedEventDto.json")
  String jsonConversationDeleteEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/CommentEventDto.json")
  ContactEventInternalImpl dtoCommentEvent;

  @GivenTextResource("domains/conversation/v1/events/types/CommentEventDto.json")
  String jsonCommentEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/GenericEventDto.json")
  ContactEventInternalImpl dtoGenericEvent;

  @GivenTextResource("domains/conversation/v1/events/types/GenericEventDto.json")
  String jsonGenericEvent;

  public static ContactEventInternalImpl expectedComposingEventDto =
      new ContactEventInternalImpl((ComposingEventImpl) ComposingEventDtoTest.expectedDto);

  public static ContactEventInternalImpl expectedComposingEndEventDto =
      new ContactEventInternalImpl((ComposingEndEventImpl) ComposingEndEventDtoTest.expectedDto);

  public static ContactEventInternalImpl expectedConversationDeletedEventDto =
      new ContactEventInternalImpl(
          (ConversationDeletedEventImpl) ConversationDeletedEventDtoTest.expectedDto);

  public static ContactEventInternalImpl expectedCommentEventDto =
      new ContactEventInternalImpl((CommentEventImpl) CommentEventDtoTest.expectedDto);

  public static ContactEventInternalImpl expectedGenericEventDto =
      new ContactEventInternalImpl((GenericEventImpl) GenericEventDtoTest.expectedDto);

  @Test
  void serializeComposingEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedComposingEventDto);
    JSONAssert.assertEquals(jsonComposingEvent, serializedString, true);
  }

  @Test
  void deserializeComposingEventDto() {
    TestHelpers.recursiveEquals(dtoComposingEvent, expectedComposingEventDto);
  }

  @Test
  void serializeComposingEndEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedComposingEndEventDto);
    JSONAssert.assertEquals(jsonComposingEndEvent, serializedString, true);
  }

  @Test
  void deserializeComposingEndEventDto() {
    TestHelpers.recursiveEquals(dtoComposingEndEvent, expectedComposingEndEventDto);
  }

  @Test
  void serializeConversationDeletedEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedConversationDeletedEventDto);
    JSONAssert.assertEquals(jsonConversationDeleteEvent, serializedString, true);
  }

  @Test
  void deserializeConversationDeletedEventDto() {
    TestHelpers.recursiveEquals(dtoConversationDeletedEvent, expectedConversationDeletedEventDto);
  }

  @Test
  void serializeCommentEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedCommentEventDto);
    JSONAssert.assertEquals(jsonCommentEvent, serializedString, true);
  }

  @Test
  void deserializeCommentEventDto() {
    TestHelpers.recursiveEquals(dtoCommentEvent, expectedCommentEventDto);
  }

  @Test
  void serializeGenericEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedGenericEventDto);
    JSONAssert.assertEquals(jsonGenericEvent, serializedString, true);
  }

  @Test
  void deserializeGenericEventDto() {
    TestHelpers.recursiveEquals(dtoGenericEvent, expectedGenericEventDto);
  }
}
