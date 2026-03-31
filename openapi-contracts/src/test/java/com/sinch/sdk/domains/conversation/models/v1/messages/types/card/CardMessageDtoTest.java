package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.calendar.CalendarMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.calendar.CalendarMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.call.CallMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.Choice;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceCallMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceLocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceTextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceURLMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.sharelocation.ShareLocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.sharelocation.ShareLocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.url.UrlMessageDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CardMessageDtoTest extends ConversationBaseTest {

  public static CardMessage cardMessageDto =
      CardMessage.builder()
          .setTitle("title value")
          .setDescription("description value")
          .setMedia(MediaMessageDtoTest.mediaMessageDto)
          .setHeight(CardHeight.MEDIUM)
          .setChoices(
              Arrays.asList(
                  ChoiceTextMessage.builder()
                      .setMessage(TextMessageDtoTest.textMessageDto)
                      .setPostbackData("postback_data text")
                      .build(),
                  ChoiceCallMessage.builder()
                      .setMessage(CallMessageDtoTest.callMessageDto)
                      .setPostbackData("postback_data call")
                      .build(),
                  ChoiceLocationMessage.builder()
                      .setMessage(LocationMessageDtoTest.locationMessageDto)
                      .setPostbackData("postback_data location")
                      .build(),
                  ChoiceURLMessage.builder()
                      .setMessage(UrlMessageDtoTest.urlMessageDto)
                      .setPostbackData("postback_data url")
                      .build(),
                  Choice.<CalendarMessage>builder()
                      .setMessage(CalendarMessageDtoTest.calendarMessageDto)
                      .setPostbackData("postback calendar_message data value")
                      .build(),
                  Choice.<ShareLocationMessage>builder()
                      .setMessage(ShareLocationMessageDtoTest.shareLocationMessageDto)
                      .setPostbackData("postback share_location_message data value")
                      .build()))
          .build();

  public static CardMessage cardMessageWithMessagePropertiesWhatsAppHeaderDto =
      CardMessage.builder()
          .setTitle("title value")
          .setDescription("description value")
          .setMedia(MediaMessageDtoTest.mediaMessageDto)
          .setHeight(CardHeight.MEDIUM)
          .setChoices(
              Arrays.asList(
                  ChoiceTextMessage.builder()
                      .setMessage(TextMessageDtoTest.textMessageDto)
                      .setPostbackData("postback_data text")
                      .build(),
                  ChoiceCallMessage.builder()
                      .setMessage(CallMessageDtoTest.callMessageDto)
                      .setPostbackData("postback_data call")
                      .build(),
                  ChoiceLocationMessage.builder()
                      .setMessage(LocationMessageDtoTest.locationMessageDto)
                      .setPostbackData("postback_data location")
                      .build(),
                  ChoiceURLMessage.builder()
                      .setMessage(UrlMessageDtoTest.urlMessageDto)
                      .setPostbackData("postback_data url")
                      .build(),
                  Choice.<CalendarMessage>builder()
                      .setMessage(CalendarMessageDtoTest.calendarMessageDto)
                      .setPostbackData("postback calendar_message data value")
                      .build(),
                  Choice.<ShareLocationMessage>builder()
                      .setMessage(ShareLocationMessageDtoTest.shareLocationMessageDto)
                      .setPostbackData("postback share_location_message data value")
                      .build()))
          .setMessageProperties(MessagePropertiesDtoTest.messagePropertiesDto)
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/card/CardMessageDto.json")
  String jsonCardMessageDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/card/CardMessageWithMessagePropertiesWhatsAppHeaderDto.json")
  String jsonCardMessageWithMessagePropertiesWhatsAppHeaderDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(cardMessageDto);

    JSONAssert.assertEquals(jsonCardMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCardMessageDto, CardMessage.class);

    TestHelpers.recursiveEquals(deserialized, cardMessageDto);
  }

  @Test
  void serializeCardMessageWithMessagePropertiesWhatsAppHeaderDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(cardMessageWithMessagePropertiesWhatsAppHeaderDto);

    JSONAssert.assertEquals(
        jsonCardMessageWithMessagePropertiesWhatsAppHeaderDto, serializedString, true);
  }

  @Test
  void deserializeCardMessageWithMessagePropertiesWhatsAppHeaderDto()
      throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonCardMessageWithMessagePropertiesWhatsAppHeaderDto, CardMessage.class);

    TestHelpers.recursiveEquals(deserialized, cardMessageWithMessagePropertiesWhatsAppHeaderDto);
  }
}
