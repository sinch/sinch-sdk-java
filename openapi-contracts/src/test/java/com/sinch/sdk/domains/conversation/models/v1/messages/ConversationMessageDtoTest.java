package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConversationMessageDtoTest extends ConversationBaseTest {

  public static ConversationMessage appConversationMessageRequest =
      ConversationMessage.builder()
          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
          .setContactId("contact id value")
          .setConversationId("conversation id value")
          .setDirection(ConversationDirection.TO_APP)
          .setId("id value")
          .setMetadata("metadata value")
          .setSenderId("sender id")
          .setProcessingMode(ProcessingMode.CONVERSATION)
          .setContent(AppMessageDtoTest.appTextMessageDto)
          .build();
  public static ConversationMessage appConversationMessageResponse =
      ConversationMessage.builder()
          .setAcceptTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
          .setContactId("contact id value")
          .setConversationId("conversation id value")
          .setDirection(ConversationDirection.TO_APP)
          .setId("id value")
          .setMetadata("metadata value")
          .setInjected(true)
          .setSenderId("sender id")
          .setProcessingMode(ProcessingMode.CONVERSATION)
          .setContent(AppMessageDtoTest.appTextMessageDto)
          .build();
  public static ConversationMessage contactConversationMessageRequest =
      ConversationMessage.builder()
          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
          .setContactId("contact id value")
          .setConversationId("conversation id value")
          .setDirection(ConversationDirection.TO_APP)
          .setId("id value")
          .setMetadata("metadata value")
          .setSenderId("sender id")
          .setProcessingMode(ProcessingMode.CONVERSATION)
          .setContent(ContactMessageDtoTest.locationContactMessageDto)
          .build();

  public static ConversationMessage contactConversationMessageResponse =
      ConversationMessage.builder()
          .setAcceptTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
          .setContactId("contact id value")
          .setConversationId("conversation id value")
          .setDirection(ConversationDirection.TO_APP)
          .setId("id value")
          .setMetadata("metadata value")
          .setInjected(true)
          .setSenderId("sender id")
          .setProcessingMode(ProcessingMode.CONVERSATION)
          .setContent(ContactMessageDtoTest.locationContactMessageDto)
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/ConversationMessageAppTextRequestDto.json")
  static String jsonConversationMessageAppTextRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/ConversationMessageAppTextResponseDto.json")
  static String jsonConversationMessageAppTextResponseDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/ConversationMessageContactLocationRequestDto.json")
  static String jsonConversationMessageContactLocationRequestDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/ConversationMessageContactLocationResponseDto.json")
  static String jsonConversationMessageContactLocationResponseDto;

  @Test
  void serializeAppConversationMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appConversationMessageRequest);

    JSONAssert.assertEquals(jsonConversationMessageAppTextRequestDto, serializedString, true);
  }

  @Test
  void deserializeAppConversationMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonConversationMessageAppTextResponseDto, ConversationMessage.class);

    TestHelpers.recursiveEquals(deserialized, appConversationMessageResponse);
  }

  @Test
  void serializeContactConversationMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(contactConversationMessageRequest);

    JSONAssert.assertEquals(
        jsonConversationMessageContactLocationRequestDto, serializedString, true);
  }

  @Test
  void deserializeContactConversationMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonConversationMessageContactLocationResponseDto, ConversationMessage.class);

    TestHelpers.recursiveEquals(deserialized, contactConversationMessageResponse);
  }
}
