package com.sinch.sdk.domains.conversation.models.v1.events;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.events.internal.AppEventInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.AgentJoinedEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.AgentJoinedEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.AgentLeftEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.AgentLeftEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.CommentReplyEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.CommentReplyEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEndEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEndEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.GenericEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.GenericEventImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class AppEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/types/ComposingEventDto.json")
  AppEventInternalImpl dtoComposingEvent;

  @GivenTextResource("domains/conversation/v1/events/types/ComposingEventDto.json")
  String jsonComposingEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/ComposingEndEventDto.json")
  AppEventInternalImpl dtoComposingEndEvent;

  @GivenTextResource("domains/conversation/v1/events/types/ComposingEndEventDto.json")
  String jsonComposingEndEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/CommentReplyEventDto.json")
  AppEventInternalImpl dtoCommentReplyEvent;

  @GivenTextResource("domains/conversation/v1/events/types/CommentReplyEventDto.json")
  String jsonCommentReplyEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/AgentJoinedEventDto.json")
  AppEventInternalImpl dtoAgentJoinedEvent;

  @GivenTextResource("domains/conversation/v1/events/types/AgentJoinedEventDto.json")
  String jsonAgentJoinedEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/AgentLeftEventDto.json")
  AppEventInternalImpl dtoAgentLeftEvent;

  @GivenTextResource("domains/conversation/v1/events/types/AgentLeftEventDto.json")
  String jsonAgentLeftEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/GenericEventDto.json")
  AppEventInternalImpl dtoGenericEvent;

  @GivenTextResource("domains/conversation/v1/events/types/GenericEventDto.json")
  String jsonGenericEvent;

  public static AppEventInternalImpl expectedComposingEventDto =
      new AppEventInternalImpl((ComposingEventImpl) ComposingEventDtoTest.expectedDto);

  public static AppEventInternalImpl expectedComposingEndEventDto =
      new AppEventInternalImpl((ComposingEndEventImpl) ComposingEndEventDtoTest.expectedDto);

  public static AppEventInternalImpl expectedCommentReplyEventDto =
      new AppEventInternalImpl((CommentReplyEventImpl) CommentReplyEventDtoTest.expectedDto);

  public static AppEventInternalImpl expectedAgentJoinedEventDto =
      new AppEventInternalImpl((AgentJoinedEventImpl) AgentJoinedEventDtoTest.expectedDto);

  public static AppEventInternalImpl expectedAgentLeftEventDto =
      new AppEventInternalImpl((AgentLeftEventImpl) AgentLeftEventDtoTest.expectedDto);

  public static AppEventInternalImpl expectedGenericEventDto =
      new AppEventInternalImpl((GenericEventImpl) GenericEventDtoTest.expectedDto);

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
  void deserializeComposingEndDEventto() {
    TestHelpers.recursiveEquals(dtoComposingEndEvent, expectedComposingEndEventDto);
  }

  @Test
  void serializeCommentReplyEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedCommentReplyEventDto);
    JSONAssert.assertEquals(jsonCommentReplyEvent, serializedString, true);
  }

  @Test
  void deserializeCommentReplyEventDto() {
    TestHelpers.recursiveEquals(dtoCommentReplyEvent, expectedCommentReplyEventDto);
  }

  @Test
  void serializeAgentJoinedEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedAgentJoinedEventDto);
    JSONAssert.assertEquals(jsonAgentJoinedEvent, serializedString, true);
  }

  @Test
  void deserializeAgentJoinedEventDto() {
    TestHelpers.recursiveEquals(dtoAgentJoinedEvent, expectedAgentJoinedEventDto);
  }

  @Test
  void serializeAgentLeftEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedAgentLeftEventDto);
    JSONAssert.assertEquals(jsonAgentLeftEvent, serializedString, true);
  }

  @Test
  void deserializeAgentLeftEventDto() {
    TestHelpers.recursiveEquals(dtoAgentLeftEvent, expectedAgentLeftEventDto);
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
