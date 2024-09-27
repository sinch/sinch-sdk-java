package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse.ChoiceResponseMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse.ChoiceResponseMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback.FallbackMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback.FallbackMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard.MediaCardMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard.MediaCardMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.productresponse.ProductResponseMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.productresponse.ProductResponseMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageDtoTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ContactMessageDtoTest extends ConversationBaseTest {

  public static ContactMessage<ChannelSpecificContactMessage> channelSpecificContactMessageDto =
      ContactMessage.<ChannelSpecificContactMessage>builder()
          .setBody(ChannelSpecificContactMessageDtoTest.channelSpecificContactMessageNfmReply)
          .setReplyTo(ReplyToDtoTest.replyToDto)
          .build();

  public static ContactMessage<ChoiceResponseMessage> choiceResponseContactMessageDto =
      ContactMessage.<ChoiceResponseMessage>builder()
          .setBody(ChoiceResponseMessageDtoTest.choiceResponseMessageDto)
          .setReplyTo(ReplyToDtoTest.replyToDto)
          .build();

  public static ContactMessage<FallbackMessage> fallbackContactMessageDto =
      ContactMessage.<FallbackMessage>builder()
          .setBody(FallbackMessageDtoTest.choiceFallbackMessageDto)
          .setReplyTo(ReplyToDtoTest.replyToDto)
          .build();

  public static ContactMessage<LocationMessage> locationContactMessageDto =
      ContactMessage.<LocationMessage>builder()
          .setBody(LocationMessageDtoTest.locationMessageDto)
          .setReplyTo(ReplyToDtoTest.replyToDto)
          .build();

  public static ContactMessage<MediaCardMessage> mediaCardContactMessageDto =
      ContactMessage.<MediaCardMessage>builder()
          .setBody(MediaCardMessageDtoTest.mediaCardMessageDto)
          .setReplyTo(ReplyToDtoTest.replyToDto)
          .build();

  public static ContactMessage<MediaMessage> mediaContactMessageDto =
      ContactMessage.<MediaMessage>builder()
          .setBody(MediaMessageDtoTest.mediaMessageDto)
          .setReplyTo(ReplyToDtoTest.replyToDto)
          .build();

  public static ContactMessage<ProductResponseMessage> productResponseContactMessageDto =
      ContactMessage.<ProductResponseMessage>builder()
          .setBody(ProductResponseMessageDtoTest.productResponseMessageDto)
          .setReplyTo(ReplyToDtoTest.replyToDto)
          .build();

  public static ContactMessage<TextMessage> textContactMessageDto =
      ContactMessage.<TextMessage>builder()
          .setBody(TextMessageDtoTest.textMessageDto)
          .setReplyTo(ReplyToDtoTest.replyToDto)
          .build();

  public static ContactMessage<TextMessage> textContactMessageNoReplyToDto =
      ContactMessage.<TextMessage>builder().setBody(TextMessageDtoTest.textMessageDto).build();

  public static ContactMessage<TextMessage> textContactMessageNullReplyToDto =
      ContactMessage.<TextMessage>builder()
          .setBody(TextMessageDtoTest.textMessageDto)
          .setReplyTo(null)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/ContactMessageChannelSpecificContactNfmReply.json")
  static String jsonChannelSpecificContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/ContactMessageChoiceResponseDto.json")
  static String jsonChoiceResponseContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/ContactMessageFallbackDto.json")
  static String jsonFallbackContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/ContactMessageLocationDto.json")
  static String jsonLocationContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/ContactMessageMediaCardDto.json")
  static String jsonMediaCardContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/ContactMessageMediaDto.json")
  static String jsonMediaContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/ContactMessageProductResponseDto.json")
  static String jsonProductResponseContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/ContactMessageTextDto.json")
  static String jsonTextMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/ContactMessageTextNoReplyToDto.json")
  static String jsonTextMessageNoReplyToDto;

  @GivenTextResource("/domains/conversation/v1/messages/ContactMessageTextNullReplyToDto.json")
  static String jsonTextMessageNullReplyToDto;

  @Test
  void serializeChannelSpecificContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(channelSpecificContactMessageDto);

    JSONAssert.assertEquals(jsonChannelSpecificContactMessageDto, serializedString, true);
  }

  @Test
  void deserializeChannelSpecificContactMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonChannelSpecificContactMessageDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(channelSpecificContactMessageDto);
  }

  @Test
  void serializeChoiceResponseContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(choiceResponseContactMessageDto);

    JSONAssert.assertEquals(jsonChoiceResponseContactMessageDto, serializedString, true);
  }

  @Test
  void deserializeChoiceResponseContactMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonChoiceResponseContactMessageDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(choiceResponseContactMessageDto);
  }

  @Test
  void serializeFallbackContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(fallbackContactMessageDto);

    JSONAssert.assertEquals(jsonFallbackContactMessageDto, serializedString, true);
  }

  @Test
  void deserializeFallbackContactMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonFallbackContactMessageDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(fallbackContactMessageDto);
  }

  @Test
  void serializeLocationContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(locationContactMessageDto);

    JSONAssert.assertEquals(jsonLocationContactMessageDto, serializedString, true);
  }

  @Test
  void deserializeLocationContactMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonLocationContactMessageDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(locationContactMessageDto);
  }

  @Test
  void serializeCardMediaContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(mediaCardContactMessageDto);

    JSONAssert.assertEquals(jsonMediaCardContactMessageDto, serializedString, true);
  }

  @Test
  void deserializeMediaCardContactMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonMediaCardContactMessageDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(mediaCardContactMessageDto);
  }

  @Test
  void serializeMediaContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(mediaContactMessageDto);

    JSONAssert.assertEquals(jsonMediaContactMessageDto, serializedString, true);
  }

  @Test
  void deserializeMediaContactMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonMediaContactMessageDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(mediaContactMessageDto);
  }

  @Test
  void serializeProductResponseContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(productResponseContactMessageDto);

    JSONAssert.assertEquals(jsonProductResponseContactMessageDto, serializedString, true);
  }

  @Test
  void deserializeProductResponseContactMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonProductResponseContactMessageDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(productResponseContactMessageDto);
  }

  @Test
  void serializeTextContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(textContactMessageDto);

    JSONAssert.assertEquals(jsonTextMessageDto, serializedString, true);
  }

  @Test
  void deserializeTextContactMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonTextMessageDto, ContactMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(textContactMessageDto);
  }

  @Test
  void serializeTextNoReplyToContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(textContactMessageNoReplyToDto);

    JSONAssert.assertEquals(jsonTextMessageNoReplyToDto, serializedString, true);
  }

  @Test
  void deserializeNoReplyTextContactMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonTextMessageNoReplyToDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(textContactMessageNoReplyToDto);
  }

  @Test
  void serializeTextNullReplyToContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(textContactMessageNullReplyToDto);

    JSONAssert.assertEquals(jsonTextMessageNullReplyToDto, serializedString, true);
  }

  @Test
  void deserializeNullReplyTextContactMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonTextMessageNullReplyToDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(textContactMessageNullReplyToDto);
  }
}
