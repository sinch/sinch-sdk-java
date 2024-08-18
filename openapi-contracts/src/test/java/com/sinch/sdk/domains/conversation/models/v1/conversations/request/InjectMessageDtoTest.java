package com.sinch.sdk.domains.conversation.models.v1.conversations.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InjectMessageDtoTest extends ConversationBaseTest {

  public static InjectMessageRequest injectAppMessage =
      InjectMessageRequest.<CardMessage>builder()
          .setBody(AppMessageDtoTest.appTextMessageDto)
          .setAcceptTime(Instant.parse("2024-08-14T14:03:20.786662Z"))
          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
          .setContactId("contact id value")
          .setDirection(ConversationDirection.TO_CONTACT)
          .setConversationId("conversation id")
          .setInjected(true)
          .setSenderId("send id value")
          .setProcessingMode(ProcessingMode.CONVERSATION)
          .setMetadata("metdata value")
          .build();
  public static InjectMessageRequest injectContactMessage =
      InjectMessageRequest.<CardMessage>builder()
          .setBody(ContactMessageDtoTest.textContactMessageDto)
          .setAcceptTime(Instant.parse("2024-08-14T14:03:20.786662Z"))
          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
          .setContactId("contact id value")
          .setDirection(ConversationDirection.TO_APP)
          .setConversationId("conversation id")
          .setInjected(true)
          .setSenderId("send id value")
          .setProcessingMode(ProcessingMode.CONVERSATION)
          .setMetadata("metdata value")
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/conversations/request/InjectAppMessageRequestDto.json")
  static String jsonInjectAppMessageRequestDto;

  @GivenTextResource(
      "/domains/conversation/v1/conversations/request/InjectContactMessageRequestDto.json")
  static String jsonInjectContactMessageRequestDto;

  @Test
  void serializeInjectAppMessageRequestDtoDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(injectAppMessage);

    JSONAssert.assertEquals(jsonInjectAppMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeInjectContactMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(injectContactMessage);

    JSONAssert.assertEquals(jsonInjectContactMessageRequestDto, serializedString, true);
  }
}
