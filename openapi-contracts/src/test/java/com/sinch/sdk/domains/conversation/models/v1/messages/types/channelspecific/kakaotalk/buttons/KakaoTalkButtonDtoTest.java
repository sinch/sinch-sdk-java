package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class KakaoTalkButtonDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/buttons/AppLinkButtonDto.json")
  static String jsonAppLinkButtonDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/buttons/BotKeywordButtonDto.json")
  static String jsonBotKeywordButtonDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/buttons/WebLinkButtonDto.json")
  static String jsonWebLinkButtonDto;

  public static KakaoTalkButton webLinkButtonDto =
      WebLinkButton.builder()
          .setName("Web link button")
          .setLinkMo("https://link.sample/mo")
          .setLinkPc("https://link.sample/pc")
          .build();

  public static KakaoTalkButton appLinkButtonDto =
      AppLinkButton.builder()
          .setName("Open app link button")
          .setSchemeIos("tel://+1234567890")
          .setSchemeAndroid("tel://+198765432")
          .build();

  public static KakaoTalkButton botKeywordButtonDto =
      BotKeywordButton.builder().setName("Help").build();

  @Test
  void deserializeAppLinkButtonButtonDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonAppLinkButtonDto, KakaoTalkButton.class);

    TestHelpers.recursiveEquals(deserialized, appLinkButtonDto);
  }

  @Test
  void serializeAppLinkButtonButtonDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(appLinkButtonDto);

    JSONAssert.assertEquals(jsonAppLinkButtonDto, serializedString, true);
  }

  @Test
  void deserializeBotKeywordButtonDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonBotKeywordButtonDto, KakaoTalkButton.class);

    TestHelpers.recursiveEquals(deserialized, botKeywordButtonDto);
  }

  @Test
  void serializeBotKeywordButtonDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(botKeywordButtonDto);

    JSONAssert.assertEquals(jsonBotKeywordButtonDto, serializedString, true);
  }

  @Test
  void deserializeAppLinkButtonDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonWebLinkButtonDto, KakaoTalkButton.class);

    TestHelpers.recursiveEquals(deserialized, webLinkButtonDto);
  }

  @Test
  void serializeAppLinkButtonDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(webLinkButtonDto);

    JSONAssert.assertEquals(jsonWebLinkButtonDto, serializedString, true);
  }
}
