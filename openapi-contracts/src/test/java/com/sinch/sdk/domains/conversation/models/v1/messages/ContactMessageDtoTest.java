package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.ChannelSpecificContactMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse.ChoiceResponseMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.fallback.FallbackMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard.MediaCardMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.productresponse.ProductResponseMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.replyto.ReplyToMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageDtoTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ContactMessageDtoTest extends ConversationBaseTest {

  public static ContactMessage channelSpecificContactMessageDto =
      ChannelSpecificContactMessageDtoTest.channelSpecificContactMessageNfmReply;
  public static ContactMessage choiceResponseContactMessageDto =
      ChoiceResponseMessageDtoTest.choiceResponseMessageDto;

  public static ContactMessage fallbackContactMessageDto =
      FallbackMessageDtoTest.choiceFallbackMessageDto;

  public static ContactMessage locationContactMessageDto =
      LocationMessageDtoTest.locationMessageDto;

  public static ContactMessage mediaCardContactMessageDto =
      MediaCardMessageDtoTest.mediaCardMessageDto;
  public static ContactMessage replyToContactMessageDto = ReplyToMessageDtoTest.replyToMessageDto;
  public static ContactMessage textContactMessageDto = TextMessageDtoTest.textMessageDto;
  public static ContactMessage productResponseContactMessageDto =
      ProductResponseMessageDtoTest.productResponseMessageDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/nfmreply/ChannelSpecificContactMessageNfmReply.json")
  static String jsonChannelSpecificContactMessageDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/choiceresponse/ChoiceResponseMessageDto.json")
  static String jsonChoiceResponseContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/types/fallback/FallbackMessageDto.json")
  static String jsonFallbackContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/types/location/LocationMessageDto.json")
  static String jsonLocationContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/types/mediacard/MediaCardMessageDto.json")
  static String jsonMediaCardContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/types/replyto/ReplyToMessageDto.json")
  static String jsonReplyToContactMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/types/text/TextMessageDto.json")
  static String jsonTextMessageDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/productresponse/ProductResponseMessageDto.json")
  static String jsonProductResponseContactMessageDto;

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
  void serializeReplyToContactMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(replyToContactMessageDto);

    JSONAssert.assertEquals(jsonReplyToContactMessageDto, serializedString, true);
  }

  @Test
  void deserializeReplyToContactMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonReplyToContactMessageDto, ContactMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(replyToContactMessageDto);
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
}
