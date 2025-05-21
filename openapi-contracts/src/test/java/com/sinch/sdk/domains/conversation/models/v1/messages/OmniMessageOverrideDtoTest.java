package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.TemplateReferenceDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel.CarouselMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.contactinfo.ContactInfoMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.list.ListMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageDtoTest;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
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
      TemplateReferenceDtoTest.templateReferenceWithVersionDto;
  public static OmniMessageOverride omniMessageOverrideText = TextMessageDtoTest.textMessageDto;

  @GivenTextResource("/domains/conversation/v1/messages/OmniMessageOverrideCardDto.json")
  static String jsonOmniMessageOverrideCardDto;

  @GivenTextResource("/domains/conversation/v1/messages/OmniMessageOverrideCarouselDto.json")
  static String jsonOmniMessageOverrideCarouselDto;

  @GivenTextResource("/domains/conversation/v1/messages/OmniMessageOverrideChoiceDto.json")
  static String jsonOmniMessageOverrideChoiceDto;

  @GivenTextResource("/domains/conversation/v1/messages/OmniMessageOverrideContactInfoDto.json")
  static String jsonOmniMessageOverrideContactInfoDto;

  @GivenTextResource("/domains/conversation/v1/messages/OmniMessageOverrideListDto.json")
  static String jsonOmniMessageOverrideListDto;

  @GivenTextResource("/domains/conversation/v1/messages/OmniMessageOverrideLocationDto.json")
  static String jsonOmniMessageOverrideLocationDto;

  @GivenTextResource("/domains/conversation/v1/messages/OmniMessageOverrideMediaDto.json")
  static String jsonOmniMessageOverrideMediaDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/OmniMessageOverrideTemplateReferenceDto.json")
  static String jsonOmniMessageOverrideTemplateReferenceDto;

  @GivenTextResource("/domains/conversation/v1/messages/OmniMessageOverrideTextDto.json")
  static String jsonOmniMessageOverrideTextDto;

  @Test
  void serializeCardDto() throws IOException, JSONException {
    String serializedString = objectMapper.writeValueAsString(omniMessageOverrideCard);

    JSONAssert.assertEquals(jsonOmniMessageOverrideCardDto, serializedString, true);
  }

  @Test
  void deserializeCardDto() throws IOException, JSONException {
    Object deserialized =
        objectMapper.readValue(jsonOmniMessageOverrideCardDto, OmniMessageOverride.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(omniMessageOverrideCard);
  }

  @Test
  void serializeCarouselDto() throws IOException, JSONException {
    String serializedString = objectMapper.writeValueAsString(omniMessageOverrideCarousel);

    JSONAssert.assertEquals(jsonOmniMessageOverrideCarouselDto, serializedString, true);
  }

  @Test
  void deserializeCarouselDto() throws IOException, JSONException {
    Object deserialized =
        objectMapper.readValue(jsonOmniMessageOverrideCarouselDto, OmniMessageOverride.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(omniMessageOverrideCarousel);
  }

  @Test
  void serializeChoiceDto() throws IOException, JSONException {
    String serializedString = objectMapper.writeValueAsString(omniMessageOverrideChoice);

    JSONAssert.assertEquals(jsonOmniMessageOverrideChoiceDto, serializedString, true);
  }

  @Test
  void deserializeChoiceDto() throws IOException, JSONException {
    Object deserialized =
        objectMapper.readValue(jsonOmniMessageOverrideChoiceDto, OmniMessageOverride.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(omniMessageOverrideChoice);
  }

  @Test
  void serializeContactInfoDto() throws IOException, JSONException {
    String serializedString = objectMapper.writeValueAsString(omniMessageOverrideContactInfo);

    JSONAssert.assertEquals(jsonOmniMessageOverrideContactInfoDto, serializedString, true);
  }

  @Test
  void deserializeContactInfoDto() throws IOException, JSONException {
    Object deserialized =
        objectMapper.readValue(jsonOmniMessageOverrideContactInfoDto, OmniMessageOverride.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(omniMessageOverrideContactInfo);
  }

  @Test
  void serializeListDto() throws IOException, JSONException {
    String serializedString = objectMapper.writeValueAsString(omniMessageOverrideList);

    JSONAssert.assertEquals(jsonOmniMessageOverrideListDto, serializedString, true);
  }

  @Test
  void deserializeListDto() throws IOException, JSONException {
    Object deserialized =
        objectMapper.readValue(jsonOmniMessageOverrideListDto, OmniMessageOverride.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(omniMessageOverrideList);
  }

  @Test
  void serializeLocationDto() throws IOException, JSONException {
    String serializedString = objectMapper.writeValueAsString(omniMessageOverrideLocation);

    JSONAssert.assertEquals(jsonOmniMessageOverrideLocationDto, serializedString, true);
  }

  @Test
  void deserializeLocationDto() throws IOException, JSONException {
    Object deserialized =
        objectMapper.readValue(jsonOmniMessageOverrideLocationDto, OmniMessageOverride.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(omniMessageOverrideLocation);
  }

  @Test
  void serializeMediaDto() throws IOException, JSONException {
    String serializedString = objectMapper.writeValueAsString(omniMessageOverrideMedia);

    JSONAssert.assertEquals(jsonOmniMessageOverrideMediaDto, serializedString, true);
  }

  @Test
  void deserializeMediaDto() throws IOException, JSONException {
    Object deserialized =
        objectMapper.readValue(jsonOmniMessageOverrideMediaDto, OmniMessageOverride.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(omniMessageOverrideMedia);
  }

  @Test
  void serializeTemplateReferenceDto() throws IOException, JSONException {
    String serializedString = objectMapper.writeValueAsString(omniMessageOverrideTemplateReference);

    JSONAssert.assertEquals(jsonOmniMessageOverrideTemplateReferenceDto, serializedString, true);
  }

  @Test
  void deserializeTemplateReferenceDto() throws IOException, JSONException {
    Object deserialized =
        objectMapper.readValue(
            jsonOmniMessageOverrideTemplateReferenceDto, OmniMessageOverride.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(omniMessageOverrideTemplateReference);
  }

  @Test
  void serializeTextDto() throws IOException, JSONException {
    String serializedString = objectMapper.writeValueAsString(omniMessageOverrideText);

    JSONAssert.assertEquals(jsonOmniMessageOverrideTextDto, serializedString, true);
  }

  @Test
  void deserializeTextDto() throws IOException, JSONException {
    Object deserialized =
        objectMapper.readValue(jsonOmniMessageOverrideTextDto, OmniMessageOverride.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(omniMessageOverrideText);
  }
}
