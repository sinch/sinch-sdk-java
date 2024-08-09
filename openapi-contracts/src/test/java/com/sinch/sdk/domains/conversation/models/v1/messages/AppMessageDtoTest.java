package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.AgentDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride.ChannelSpecificTemplate;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.FlowChannelSpecificMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.template.TemplateMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageDtoTest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
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

  @GivenTextResource("/domains/conversation/v1/messages/AppMessageCardDto.json")
  static String jsonAppMessageCardRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/AppMessageCarouselDto.json")
  static String jsonAppMessageCarouselRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/AppMessageChoiceDto.json")
  static String jsonAppMessageChoiceRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/AppMessageContactInfoDto.json")
  static String jsonAppMessageContactInfoRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/AppMessageListDto.json")
  static String jsonAppMessageListMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/AppMessageLocationDto.json")
  static String jsonAppMessageLocationMessageRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/AppMessageMediaDto.json")
  static String jsonAppMessageMediaRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/AppMessageTemplateDto.json")
  static String jsonAppMessageTemplateRequestDto;

  @GivenTextResource("/domains/conversation/v1/messages/AppMessageTextDto.json")
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
  void deserializeCardMessageRequestDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonAppMessageCardRequestDto, AppMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(appCardMessageDto);
  }

  @Test
  void serializeCarouselMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appCarouselMessageDto);

    JSONAssert.assertEquals(jsonAppMessageCarouselRequestDto, serializedString, true);
  }

  @Test
  void deserializeCarouselMessageRequestDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonAppMessageCarouselRequestDto, AppMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(appCarouselMessageDto);
  }

  @Test
  void serializeChoiceMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appChoiceMessageDto);

    JSONAssert.assertEquals(jsonAppMessageChoiceRequestDto, serializedString, true);
  }

  @Test
  void deserializeChoiceMessageRequestDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonAppMessageChoiceRequestDto, AppMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(appChoiceMessageDto);
  }

  @Test
  void serializeContactInfoMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appContactInfoMessageDto);

    JSONAssert.assertEquals(jsonAppMessageContactInfoRequestDto, serializedString, true);
  }

  @Test
  void deserializeContactInfoMessageRequestDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonAppMessageContactInfoRequestDto, AppMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(appContactInfoMessageDto);
  }

  @Test
  void serializeListMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appListMessageDto);

    JSONAssert.assertEquals(jsonAppMessageListMessageRequestDto, serializedString, true);
  }

  @Test
  void deserializeListMessageRequestDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonAppMessageListMessageRequestDto, AppMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(appListMessageDto);
  }

  @Test
  void serializeLocationMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appLocationMessageDto);

    JSONAssert.assertEquals(jsonAppMessageLocationMessageRequestDto, serializedString, true);
  }

  @Test
  void deserializeLocationMessageRequestDto() throws JsonProcessingException, JSONException {
    Object deserialized =
        objectMapper.readValue(jsonAppMessageLocationMessageRequestDto, AppMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(appLocationMessageDto);
  }

  @Test
  void serializeMediaMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appMediaMessageDto);

    JSONAssert.assertEquals(jsonAppMessageMediaRequestDto, serializedString, true);
  }

  @Test
  void deserializeMediaMessageRequestDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonAppMessageMediaRequestDto, AppMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(appMediaMessageDto);
  }

  @Test
  void serializeTemplateMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appTemplateMessageDto);

    JSONAssert.assertEquals(jsonAppMessageTemplateRequestDto, serializedString, true);
  }

  @Test
  void deserializeTemplateMessageRequestDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonAppMessageTemplateRequestDto, AppMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(appTemplateMessageDto);
  }

  @Test
  void serializeTextMessageRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appTextMessageDto);

    JSONAssert.assertEquals(jsonAppMessageTextRequestDto, serializedString, true);
  }

  @Test
  void deserializeTextMessageRequestDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonAppMessageTextRequestDto, AppMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(appTextMessageDto);
  }
}
