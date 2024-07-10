package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.api.v1.adapters.messages.OmniMessageOverrideMapper;
import com.sinch.sdk.domains.conversation.models.v1.messages.CardMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.CarouselMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ChoiceMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactInfoMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ListMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.MediaMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.OmniMessageOverride;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.templates.TemplateReferenceDtoTest;
import java.io.IOException;
import java.io.StringWriter;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class OmniMessageOverrideDtoTest extends ConversationBaseTest {

  public static OmniMessageOverride omniMessageOverrideCard = CardMessageDtoTest.cardMessageDto;
  public static OmniMessageOverride omniMessageOverrideCarousel =
      CarouselMessageDtoTest.carouselMessageDto;
  public static OmniMessageOverride omniMessageOverrideChoice =
      ChoiceMessageDtoTest.choiceMessageDto;
  public static OmniMessageOverride omniMessageOverrideContactInfo =
      ContactInfoMessageDtoTest.contactInfoMessageDto;
  public static OmniMessageOverride omniMessageOverrideList =
      ListMessageDtoTest.listMessageProductDto;
  public static OmniMessageOverride omniMessageOverrideLocation =
      LocationMessageDtoTest.locationMessageDto;
  public static OmniMessageOverride omniMessageOverrideMedia = MediaMessageDtoTest.mediaMessageDto;
  public static OmniMessageOverride omniMessageOverrideTemplateReference =
      TemplateReferenceDtoTest.templateReferenceDto;
  public static OmniMessageOverride omniMessageOverrideText = TextMessageDtoTest.textMessageDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/OmniMessageOverrideMessageCardDto.json")
  static String jsonOmniMessageOverrideCardDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/OmniMessageOverrideMessageCarouselDto.json")
  static String jsonOmniMessageOverrideCarouselDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/OmniMessageOverrideMessageChoiceDto.json")
  static String jsonOmniMessageOverrideChoiceDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/OmniMessageOverrideMessageContactInfoDto.json")
  static String jsonOmniMessageOverrideContactInfoDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/OmniMessageOverrideMessageListDto.json")
  static String jsonOmniMessageOverrideListDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/OmniMessageOverrideMessageLocationDto.json")
  static String jsonOmniMessageOverrideLocationDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/OmniMessageOverrideMessageMediaDto.json")
  static String jsonOmniMessageOverrideMediaDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/OmniMessageOverrideMessageTemplateReferenceDto.json")
  static String jsonOmniMessageOverrideTemplateReferenceDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/request/OmniMessageOverrideMessageTextDto.json")
  static String jsonOmniMessageOverrideTextDto;

  JsonGenerator jsonGen;
  StringWriter writer;

  @BeforeEach
  void init() throws IOException {
    JsonFactory jsonFactory = new JsonFactory();
    writer = new StringWriter();
    jsonGen = jsonFactory.createGenerator(writer);
    jsonGen.setCodec(objectMapper);
  }

  @AfterEach
  void tearDown() throws IOException {
    writer.close();
  }

  @Test
  void serializeCardDto() throws IOException, JSONException {
    OmniMessageOverrideMapper.serialize(omniMessageOverrideCard, jsonGen);

    JSONAssert.assertEquals(jsonOmniMessageOverrideCardDto, writer.toString(), true);
  }

  @Test
  void serializeCarouselDto() throws IOException, JSONException {
    OmniMessageOverrideMapper.serialize(omniMessageOverrideCarousel, jsonGen);

    JSONAssert.assertEquals(jsonOmniMessageOverrideCarouselDto, writer.toString(), true);
  }

  @Test
  void serializeChoiceDto() throws IOException, JSONException {
    OmniMessageOverrideMapper.serialize(omniMessageOverrideChoice, jsonGen);

    JSONAssert.assertEquals(jsonOmniMessageOverrideChoiceDto, writer.toString(), true);
  }

  @Test
  void serializeContactInfoDto() throws IOException, JSONException {
    OmniMessageOverrideMapper.serialize(omniMessageOverrideContactInfo, jsonGen);

    JSONAssert.assertEquals(jsonOmniMessageOverrideContactInfoDto, writer.toString(), true);
  }

  @Test
  void serializeListDto() throws IOException, JSONException {
    OmniMessageOverrideMapper.serialize(omniMessageOverrideList, jsonGen);

    JSONAssert.assertEquals(jsonOmniMessageOverrideListDto, writer.toString(), true);
  }

  @Test
  void serializeLocationDto() throws IOException, JSONException {
    OmniMessageOverrideMapper.serialize(omniMessageOverrideLocation, jsonGen);

    JSONAssert.assertEquals(jsonOmniMessageOverrideLocationDto, writer.toString(), true);
  }

  @Test
  void serializeMediaDto() throws IOException, JSONException {
    OmniMessageOverrideMapper.serialize(omniMessageOverrideMedia, jsonGen);

    JSONAssert.assertEquals(jsonOmniMessageOverrideMediaDto, writer.toString(), true);
  }

  @Test
  void serializeTemplateReferenceDto() throws IOException, JSONException {
    OmniMessageOverrideMapper.serialize(omniMessageOverrideTemplateReference, jsonGen);

    JSONAssert.assertEquals(jsonOmniMessageOverrideTemplateReferenceDto, writer.toString(), true);
  }

  @Test
  void serializeTextDto() throws IOException, JSONException {

    OmniMessageOverrideMapper.serialize(omniMessageOverrideText, jsonGen);
    JSONAssert.assertEquals(jsonOmniMessageOverrideTextDto, writer.toString(), true);
  }
}
