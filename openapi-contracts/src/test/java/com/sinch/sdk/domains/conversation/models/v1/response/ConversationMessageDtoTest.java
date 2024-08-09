package com.sinch.sdk.domains.conversation.models.v1.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import java.time.Instant;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConversationMessageDtoTest extends ConversationBaseTest {

  public static ConversationMessage appConversationMessage =
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
  public static ConversationMessage contactConversationMessage =
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

  @GivenTextResource("/domains/conversation/v1/messages/ConversationMessageAppTextDto.json")
  static String jsonConversationMessageAppTextDto;

  @GivenTextResource("/domains/conversation/v1/messages/ConversationMessageContactLocationDto.json")
  static String jsonConversationMessageContactLocationDto;

  @Test
  void serializeAppConversationMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appConversationMessage);

    JSONAssert.assertEquals(jsonConversationMessageAppTextDto, serializedString, true);
  }

  @Test
  void deserializeAppConversationMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonConversationMessageAppTextDto, ConversationMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(appConversationMessage);
  }

  @Test
  void serializeContactConversationMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(contactConversationMessage);

    JSONAssert.assertEquals(jsonConversationMessageContactLocationDto, serializedString, true);
  }

  @Test
  void deserializeContactConversationMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonConversationMessageContactLocationDto, ConversationMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(contactConversationMessage);
  }
}
