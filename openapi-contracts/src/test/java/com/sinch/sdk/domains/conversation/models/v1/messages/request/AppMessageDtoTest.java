package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.AgentDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChannelSpecificMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride.ChannelSpecificTemplate;
import com.sinch.sdk.domains.conversation.models.v1.messages.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TemplateMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessageDtoTest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class AppMessageDtoTest extends ConversationBaseTest {

  public static AppMessage<CardMessage> appCardMessageDto =
      AppMessage.<CardMessage>builder()
          .setMessage(CardMessageDtoTest.cardMessageDto)
          .setExplicitChannelMessage(createExplicitChannelMessage())
          .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
          .setChannelSpecificMessage(createChannelSpecificMessage())
          .setAgent(AgentDtoTest.expectedDto)
          .build();

  public static AppMessage<CarouselMessage> appCarouselMessageDto =
      AppMessage.<CarouselMessage>builder()
          .setMessage(CarouselMessageDtoTest.carouselMessageDto)
          .setExplicitChannelMessage(createExplicitChannelMessage())
          .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
          .setChannelSpecificMessage(createChannelSpecificMessage())
          .setAgent(AgentDtoTest.expectedDto)
          .build();

  public static AppMessage<ChoiceMessage> appChoiceMessageDto =
      AppMessage.<ChoiceMessage>builder()
          .setMessage(ChoiceMessageDtoTest.choiceMessageDto)
          .setExplicitChannelMessage(createExplicitChannelMessage())
          .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
          .setChannelSpecificMessage(createChannelSpecificMessage())
          .setAgent(AgentDtoTest.expectedDto)
          .build();
  public static AppMessage<ContactInfoMessage> appContactInfoMessageDto =
      AppMessage.<ContactInfoMessage>builder()
          .setMessage(ContactInfoMessageDtoTest.contactInfoMessageDto)
          .setExplicitChannelMessage(createExplicitChannelMessage())
          .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
          .setChannelSpecificMessage(createChannelSpecificMessage())
          .setAgent(AgentDtoTest.expectedDto)
          .build();

  public static AppMessage<ListMessage> appListMessageDto =
      AppMessage.<ListMessage>builder()
          .setMessage(ListMessageDtoTest.listMessageChoiceDto)
          .setExplicitChannelMessage(createExplicitChannelMessage())
          .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
          .setChannelSpecificMessage(createChannelSpecificMessage())
          .setAgent(AgentDtoTest.expectedDto)
          .build();

  public static AppMessage<LocationMessage> appLocationMessageDto =
      AppMessage.<LocationMessage>builder()
          .setMessage(LocationMessageDtoTest.locationMessageDto)
          .setExplicitChannelMessage(createExplicitChannelMessage())
          .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
          .setChannelSpecificMessage(createChannelSpecificMessage())
          .setAgent(AgentDtoTest.expectedDto)
          .build();
  public static AppMessage<MediaMessage> appMediaMessageDto =
      AppMessage.<MediaMessage>builder()
          .setMessage(MediaMessageDtoTest.mediaMessageDto)
          .setExplicitChannelMessage(createExplicitChannelMessage())
          .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
          .setChannelSpecificMessage(createChannelSpecificMessage())
          .setAgent(AgentDtoTest.expectedDto)
          .build();

  public static AppMessage<TemplateMessage> appTemplateMessageDto =
      AppMessage.<TemplateMessage>builder()
          .setMessage(TemplateMessageDtoTest.templateMessageDto)
          .setExplicitChannelMessage(createExplicitChannelMessage())
          .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
          .setChannelSpecificMessage(createChannelSpecificMessage())
          .setAgent(AgentDtoTest.expectedDto)
          .build();
  public static AppMessage<TextMessage> appTextMessageDto =
      AppMessage.<TextMessage>builder()
          .setMessage(TextMessageDtoTest.textMessageDto)
          .setExplicitChannelMessage(createExplicitChannelMessage())
          .setExplicitChannelOmniMessage(createExplicitChannelOmniMessage())
          .setChannelSpecificMessage(createChannelSpecificMessage())
          .setAgent(AgentDtoTest.expectedDto)
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/request/AppMessageCardRequestDto.json")
  static String jsonAppMessageCardRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/AppMessageCarouselRequestDto.json")
  static String jsonAppMessageCarouselRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/AppMessageChoiceRequestDto.json")
  static String jsonAppMessageChoiceRequestDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/AppMessageContactInfoRequestDto.json")
  static String jsonAppMessageContactInfoRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/AppMessageListRequestDto.json")
  static String jsonAppMessageListMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/AppMessageLocationRequestDto.json")
  static String jsonAppMessageLocationMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/AppMessageMediaRequestDto.json")
  static String jsonAppMessageMediaRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/AppMessageTemplateRequestDto.json")
  static String jsonAppMessageTemplateRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/request/AppMessageTextRequestDto.json")
  static String jsonAppMessageTextRequestDto;

  private static Map<ConversationChannel, Object> createExplicitChannelMessage() {
    Map<ConversationChannel, Object> map = new HashMap<>();
    map.put(ConversationChannel.KAKAOTALK, "foo value");
    return Collections.unmodifiableMap(map);
  }

  private static Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride>
      createExplicitChannelOmniMessage() {
    Map<OmniMessageOverride.ChannelSpecificTemplate, OmniMessageOverride> map = new HashMap<>();
    map.put(ChannelSpecificTemplate.KAKAOTALK, ChoiceMessageDtoTest.choiceMessageDto);
    return Collections.unmodifiableMap(map);
  }

  private static Map<ConversationChannel, ChannelSpecificMessage> createChannelSpecificMessage() {
    Map<ConversationChannel, ChannelSpecificMessage> map = new HashMap<>();
    map.put(
        ConversationChannel.MESSENGER,
        FlowChannelSpecificMessageDtoTest.flowChannelSpecificMessageHeaderText);
    return Collections.unmodifiableMap(map);
  }

  @Test
  void serializeCardMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appCardMessageDto);

    JSONAssert.assertEquals(jsonAppMessageCardRequestDto, serializedString, true);
  }

  @Test
  void serializeCarouselMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appCarouselMessageDto);

    JSONAssert.assertEquals(jsonAppMessageCarouselRequestDto, serializedString, true);
  }

  @Test
  void serializeChoiceMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appChoiceMessageDto);

    JSONAssert.assertEquals(jsonAppMessageChoiceRequestDto, serializedString, true);
  }

  @Test
  void serializeContactInfoMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appContactInfoMessageDto);

    JSONAssert.assertEquals(jsonAppMessageContactInfoRequestDto, serializedString, true);
  }

  @Test
  void serializeListMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appListMessageDto);

    JSONAssert.assertEquals(jsonAppMessageListMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeLocationMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appLocationMessageDto);

    JSONAssert.assertEquals(jsonAppMessageLocationMessageRequestDto, serializedString, true);
  }

  @Test
  void serializeMediaMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appMediaMessageDto);

    JSONAssert.assertEquals(jsonAppMessageMediaRequestDto, serializedString, true);
  }

  @Test
  void serializeTemplateMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appTemplateMessageDto);

    JSONAssert.assertEquals(jsonAppMessageTemplateRequestDto, serializedString, true);
  }

  @Test
  void serializeTextMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appTextMessageDto);

    JSONAssert.assertEquals(jsonAppMessageTextRequestDto, serializedString, true);
  }
}
