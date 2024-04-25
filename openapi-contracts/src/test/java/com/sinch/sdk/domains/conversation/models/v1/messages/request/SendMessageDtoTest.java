package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.request.MessageQueue;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import com.sinch.sdk.domains.conversation.models.v1.templates.TemplateMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SendMessageDtoTest extends ConversationBaseTest {

  public static SendMessageRequest<CardMessage> sendCardMessageRequestDto =
      SendMessageDtoTest.<CardMessage>builder()
          .setMessage(AppMessageDtoTest.appCardMessageDto)
          .build();
  public static SendMessageRequest<CarouselMessage> sendCarouselMessageRequestDto =
      SendMessageDtoTest.<CarouselMessage>builder()
          .setMessage(AppMessageDtoTest.appCarouselMessageDto)
          .build();
  public static SendMessageRequest<ChoiceMessage> sendChoiceMessageRequestDto =
      SendMessageDtoTest.<ChoiceMessage>builder()
          .setMessage(AppMessageDtoTest.appChoiceMessageDto)
          .build();
  public static SendMessageRequest<ContactInfoMessage> sendContactInfoMessageRequestDto =
      SendMessageDtoTest.<ContactInfoMessage>builder()
          .setMessage(AppMessageDtoTest.appContactInfoMessageDto)
          .build();
  public static SendMessageRequest<ListMessage> sendListMessageRequestDto =
      SendMessageDtoTest.<ListMessage>builder()
          .setMessage(AppMessageDtoTest.appListMessageDto)
          .build();
  public static SendMessageRequest<LocationMessage> sendLocationMessageRequestDto =
      SendMessageDtoTest.<LocationMessage>builder()
          .setMessage(AppMessageDtoTest.appLocationMessageDto)
          .build();
  public static SendMessageRequest<MediaMessage> sendMediaMessageRequestDto =
      SendMessageDtoTest.<MediaMessage>builder()
          .setMessage(AppMessageDtoTest.appMediaMessageDto)
          .build();
  public static SendMessageRequest<TemplateMessage> sendTemplateMessageRequestDto =
      SendMessageDtoTest.<TemplateMessage>builder()
          .setMessage(AppMessageDtoTest.appTemplateMessageDto)
          .build();
  public static SendMessageRequest<TextMessage> sendTextMessageRequestDto =
      SendMessageDtoTest.<TextMessage>builder()
          .setMessage(AppMessageDtoTest.appTextMessageDto)
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/request/SendCardMessageRequestDto.json")
  static String jsonSendCardMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendCarouselMessageRequestDto.json")
  static String jsonSendCarouselMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendChoiceMessageRequestDto.json")
  static String jsonSendChoiceMessageRequestDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/SendContactInfoMessageRequestDto.json")
  static String jsonSendContactInfoMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendListMessageRequestDto.json")
  static String jsonSendListMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendLocationMessageRequestDto.json")
  static String jsonSendLocationMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendMediaMessageRequestDto.json")
  static String jsonSendMediaMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendTemplateMessageRequestDto.json")
  static String jsonSendTemplateMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/SendTextMessageRequestDto.json")
  static String jsonSendTextMessageRequestDto;

  private static <T extends AppMessageMessage> SendMessageRequest.Builder<T> builder() {
    Map<String, String> map = new HashMap<>();
    map.put("a property key", "a property value");
    return SendMessageRequest.<T>builder()
        .setAppId("my app ID")
        .setRecipient(ContactId.builder().setContactId("my contact ID").build())
        .setCallbackUrl("callback URL value")
        .setChannelPriorityOrder(Collections.singletonList(ConversationChannel.LINE))
        .setChannelProperties(map)
        .setMessageMetadata("message metadata value")
        .setConversationMetadata("conversation metadata")
        .setQueue(MessageQueue.HIGH_PRIORITY)
        .setTtl(2)
        .setProcessingStrategy(ProcessingStrategy.DISPATCH_ONLY)
        .setCorrelationId("correlation ID value")
        .setConversationMetadataUpdateStrategy(MetadataUpdateStrategy.REPLACE);
  }

  @Test
  void serializeSendCardMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendCardMessageRequestDto);

    JSONAssert.assertEquals(jsonSendCardMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeSendCarouselMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendCarouselMessageRequestDto);

    JSONAssert.assertEquals(jsonSendCarouselMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeSendChoiceMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendChoiceMessageRequestDto);

    JSONAssert.assertEquals(jsonSendChoiceMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeSendContactInfoMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendContactInfoMessageRequestDto);

    JSONAssert.assertEquals(jsonSendContactInfoMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeSendListMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendListMessageRequestDto);

    JSONAssert.assertEquals(jsonSendListMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeSendLocationMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendLocationMessageRequestDto);

    JSONAssert.assertEquals(jsonSendLocationMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeSendMediaMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendMediaMessageRequestDto);

    JSONAssert.assertEquals(jsonSendMediaMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeSendTemplateMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendTemplateMessageRequestDto);

    JSONAssert.assertEquals(jsonSendTemplateMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeSendTextMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendTextMessageRequestDto);

    JSONAssert.assertEquals(jsonSendTextMessageRequestDto, serializedString, true);
  }
}
