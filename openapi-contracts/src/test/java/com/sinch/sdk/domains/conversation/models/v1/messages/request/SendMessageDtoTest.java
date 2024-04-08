package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.adapters.messages.SendMessageRequestMapper;
import com.sinch.sdk.domains.conversation.models.v1.AgentDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ContactId;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppCardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppCarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppLocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppTemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppTextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChannelSpecificMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChannelSpecificMessage.MessageTypeEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChannelSpecificMessageMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverrideMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TemplateMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.request.MessageQueue;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SendMessageDtoTest extends BaseTest {

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

  private static final SendMessageRequest.Builder commonBuilder =
      SendMessageRequest.builder()
          .setAppId("my app ID")
          .setRecipient(ContactId.builder().setContactId("my contact ID").build())
          .setCallbackUrl("callback URL value")
          .setChannelPriorityOrder(Collections.singletonList(ConversationChannel.LINE))
          .setChannelProperties(createChannelProperties())
          .setMessageMetadata("message metadata value")
          .setConversationMetadata("conversation metadata")
          .setQueue(MessageQueue.HIGH_PRIORITY)
          .setTtl(2)
          .setProcessingStrategy(ProcessingStrategy.DISPATCH_ONLY)
          .setCorrelationId("correlation ID value")
          .setConversationMetadataUpdateStrategy(MetadataUpdateStrategy.REPLACE);

  public static SendMessageRequest sendCardMessageRequestDto =
      commonBuilder
          .setMessage(
              AppCardMessage.builder()
                  .setMessage(CardMessageDtoTest.cardMessageDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .build();

  public static SendMessageRequest sendCarouselMessageRequestDto =
      commonBuilder
          .setMessage(
              AppCarouselMessage.builder()
                  .setMessage(CarouselMessageDtoTest.carouselMessageDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .build();

  public static SendMessageRequest sendChoiceMessageRequestDto =
      commonBuilder
          .setMessage(
              AppChoiceMessage.builder()
                  .setMessage(ChoiceMessageDtoTest.choiceMessageDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .build();

  public static SendMessageRequest sendContactInfoMessageRequestDto =
      commonBuilder
          .setMessage(
              AppContactInfoMessage.builder()
                  .setMessage(ContactInfoMessageDtoTest.contactInfoMessageDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .build();

  public static SendMessageRequest sendListMessageRequestDto =
      commonBuilder
          .setMessage(
              AppListMessage.builder()
                  .setMessage(ListMessageDtoTest.listMessageProductDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .build();

  public static SendMessageRequest sendLocationMessageRequestDto =
      commonBuilder
          .setMessage(
              AppLocationMessage.builder()
                  .setMessage(LocationMessageDtoTest.locationMessageDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .build();

  public static SendMessageRequest sendMediaMessageRequestDto =
      commonBuilder
          .setMessage(
              AppMediaMessage.builder()
                  .setMessage(MediaMessageDtoTest.mediaMessageDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .build();

  public static SendMessageRequest sendTemplateMessageRequestDto =
      commonBuilder
          .setMessage(
              AppTemplateMessage.builder()
                  .setMessage(TemplateMessageDtoTest.templateMessageDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .build();

  public static SendMessageRequest sendTextMessageRequestDto =
      commonBuilder
          .setMessage(
              AppTextMessage.builder()
                  .setMessage(TextMessageDtoTest.textMessageDto)
                  .setExplicitChannelMessage(createExplicitChannelMessage())
                  .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
                  // TODO .setChannelSpecificMessage(createChannelSpecificMessage())
                  .setAgent(AgentDtoTest.agentDto)
                  .build())
          .build();

  static {
    // init dedicated mapper for send request serialization
    SendMessageRequestMapper.initMapper();
  }

  private static Map<ConversationChannel, Object> createExplicitChannelMessage() {
    Map<ConversationChannel, Object> map = new HashMap<>();
    map.put(ConversationChannel.KAKAOTALK, "foo value");
    return Collections.unmodifiableMap(map);
  }

  private static Map<ConversationChannel, OmniMessageOverride> createExplicitChannelOmniMessage() {
    Map<ConversationChannel, OmniMessageOverride> map = new HashMap<>();
    map.put(
        ConversationChannel.MESSENGER,
        OmniMessageOverride.builder()
            .setMessage(
                OmniMessageOverrideMessage.builder()
                    .setCardMessage(CardMessageDtoTest.cardMessageDto)
                    .build())
            .build());
    return Collections.unmodifiableMap(map);
  }

  private static Map<ConversationChannel, ChannelSpecificMessage> createChannelSpecificMessage() {
    Map<ConversationChannel, ChannelSpecificMessage> map = new HashMap<>();
    map.put(
        ConversationChannel.MESSENGER,
        ChannelSpecificMessage.builder()
            .setMessageType(MessageTypeEnum.FLOWS)
            .setMessage(ChannelSpecificMessageMessage.builder().build())
            .build());
    return Collections.unmodifiableMap(map);
  }

  private static Map<String, String> createChannelProperties() {
    Map<String, String> map = new HashMap<>();
    map.put("a property key", "a property value");
    return Collections.unmodifiableMap(map);
  }

  /*
    TOTO: waiting for https://gitlab.com/sinch/sinch-projects/enterprise-and-messaging/documentation/developer-experience/oas-documentation/-/compare/master...TemplateReferenceField-indirection-for-OmniMessageOverride
  */
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
