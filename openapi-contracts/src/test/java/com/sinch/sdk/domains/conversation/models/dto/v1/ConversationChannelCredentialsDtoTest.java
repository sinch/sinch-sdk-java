package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConversationChannelCredentialsDtoTest extends BaseTest {

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelInstagramDto.json")
  String jsonConversationChannelInstagramDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelInstagramDto.json")
  ConversationChannelCredentialDto loadedConversationChannelInstagramDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelKakaoTalkDto.json")
  String jsonConversationChannelKakaoTalkDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelKakaoTalkDto.json")
  ConversationChannelCredentialDto loadedConversationChannelKakaoTalkDto;

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelKakaoTalkChatDto.json")
  String jsonConversationChannelKakaoTalkChatDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelKakaoTalkChatDto.json")
  ConversationChannelCredentialDto loadedConversationChannelKakaoTalkChatDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelLineDto.json")
  String jsonConversationChannelLineDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelLineDto.json")
  ConversationChannelCredentialDto loadedConversationChannelLineDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelMessengerDto.json")
  ConversationChannelCredentialDto loadedConversationChannelMessengerDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelMessengerDto.json")
  String jsonConversationChannelMessengerDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelMMSDto.json")
  ConversationChannelCredentialDto loadedConversationChannelMMSDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelMMSDto.json")
  String jsonConversationChannelMMSDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelRCSDto.json")
  ConversationChannelCredentialDto loadedConversationChannelRCSDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelRCSDto.json")
  String jsonConversationChannelRCSDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelSMSDto.json")
  ConversationChannelCredentialDto loadedConversationChannelSMSDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelSMSDto.json")
  String jsonConversationChannelSMSDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelTelegramDto.json")
  ConversationChannelCredentialDto loadedConversationChannelTelegramDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelTelegramDto.json")
  String jsonConversationChannelTelegramDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelViberDto.json")
  ConversationChannelCredentialDto loadedConversationChannelViberDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelViberDto.json")
  String jsonConversationChannelViberDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelViberBmDto.json")
  ConversationChannelCredentialDto loadedConversationChannelViberBmDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelViberBmDto.json")
  String jsonConversationChannelViberBmDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelWeChatDto.json")
  ConversationChannelCredentialDto loadedConversationChannelWeChatDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelWeChatDto.json")
  String jsonConversationChannelWeChatDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelWhatsAppDto.json")
  ConversationChannelCredentialDto loadedConversationChannelWhatsAppDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelWhatsAppDto.json")
  String jsonConversationChannelWhatsAppDto;

  public static ConversationChannelCredentialDto conversationChannelInstagramResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.INSTAGRAM)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .instagramCredentials(
              new InstagramCredentialsDto()
                  .token("instagramChannel token")
                  .businessAccountId("instagramChannel business account id"));

  public static ConversationChannelCredentialDto conversationChannelInstagramRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.INSTAGRAM)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .instagramCredentials(
              new InstagramCredentialsDto()
                  .token("instagramChannel token")
                  .businessAccountId("instagramChannel business account id"));

  public static ConversationChannelCredentialDto conversationChannelKakaoTalkResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.KAKAOTALK)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .kakaotalkCredentials(
              new KakaoTalkCredentialsDto()
                  .kakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                  .kakaotalkSenderKey("kakaoTalkChannel a sender key"));
  public static ConversationChannelCredentialDto conversationChannelKakaoTalkRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.KAKAOTALK)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .kakaotalkCredentials(
              new KakaoTalkCredentialsDto()
                  .kakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                  .kakaotalkSenderKey("kakaoTalkChannel a sender key"));
  public static ConversationChannelCredentialDto conversationChannelKakaoTalkChatResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.KAKAOTALKCHAT)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .kakaotalkchatCredentials(
              new KakaoTalkChatCredentialsDto()
                  .kakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                  .apiKey(""));
  public static ConversationChannelCredentialDto conversationChannelKakaoTalkChatRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.KAKAOTALKCHAT)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .kakaotalkchatCredentials(
              new KakaoTalkChatCredentialsDto()
                  .kakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                  .apiKey(""));
  public static ConversationChannelCredentialDto conversationChannelLineResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.LINE)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .lineCredentials(
              new LineCredentialsDto()
                  .token("lineChannel a token value")
                  .secret("lineChannel a secret value"));
  public static ConversationChannelCredentialDto conversationChannelLineRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.LINE)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .lineCredentials(
              new LineCredentialsDto()
                  .token("lineChannel a token value")
                  .secret("lineChannel a secret value"));
  public static ConversationChannelCredentialDto conversationChannelMessengerResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.MESSENGER)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .staticToken(new StaticTokenCredentialDto().token("messengerChannel a token value"));
  public static ConversationChannelCredentialDto conversationChannelMessengerRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.MESSENGER)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .staticToken(new StaticTokenCredentialDto().token("messengerChannel a token value"));

  public static ConversationChannelCredentialDto conversationChannelMMSResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.MMS)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .mmsCredentials(
              new MMSCredentialsDto()
                  .basicAuth(
                      new BasicAuthCredentialDto()
                          .username("mmsChannel an user name")
                          .password("mmsChannel a password"))
                  .accountId("mmsChannel an account id")
                  .apiKey("mmsChannel an api key")
                  .defaultSender("mmsChannel default sender"));
  public static ConversationChannelCredentialDto conversationChannelMMSRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.MMS)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .mmsCredentials(
              new MMSCredentialsDto()
                  .basicAuth(
                      new BasicAuthCredentialDto()
                          .username("mmsChannel an user name")
                          .password("mmsChannel a password"))
                  .accountId("mmsChannel an account id")
                  .apiKey("mmsChannel an api key")
                  .defaultSender("mmsChannel default sender"));
  public static ConversationChannelCredentialDto conversationChannelRCSResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.RCS)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .staticBearer(
              new StaticBearerCredentialDto()
                  .claimedIdentity("rcsChannel my claimed identity")
                  .token("rcsChannel my token"));
  public static ConversationChannelCredentialDto conversationChannelRCSRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.RCS)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .staticBearer(
              new StaticBearerCredentialDto()
                  .claimedIdentity("rcsChannel my claimed identity")
                  .token("rcsChannel my token"));
  public static ConversationChannelCredentialDto conversationChannelSMSResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.SMS)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .staticBearer(
              new StaticBearerCredentialDto()
                  .claimedIdentity("smsChannel my claimed identity")
                  .token("smsChannel my token"));
  public static ConversationChannelCredentialDto conversationChannelSMSRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.SMS)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .staticBearer(
              new StaticBearerCredentialDto()
                  .claimedIdentity("smsChannel my claimed identity")
                  .token("smsChannel my token"));

  public static ConversationChannelCredentialDto conversationChannelTelegramResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.TELEGRAM)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .telegramCredentials(new TelegramCredentialsDto().token("telegramChannel token"));
  public static ConversationChannelCredentialDto conversationChannelTelegramRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.TELEGRAM)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .telegramCredentials(new TelegramCredentialsDto().token("telegramChannel token"));

  public static ConversationChannelCredentialDto conversationChannelViberResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.VIBER)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .staticToken(new StaticTokenCredentialDto().token("viberChannel token"));
  public static ConversationChannelCredentialDto conversationChannelViberRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.VIBER)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .staticToken(new StaticTokenCredentialDto().token("viberChannel token"));

  public static ConversationChannelCredentialDto conversationChannelViberBmResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.VIBERBM)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .staticBearer(
              new StaticBearerCredentialDto()
                  .claimedIdentity("viberBMChannel my claimed identity")
                  .token("viberBMChannel my token"));
  public static ConversationChannelCredentialDto conversationChannelViberBmRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.VIBERBM)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .staticBearer(
              new StaticBearerCredentialDto()
                  .claimedIdentity("viberBMChannel my claimed identity")
                  .token("viberBMChannel my token"));
  public static ConversationChannelCredentialDto conversationChannelWeChatResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.WECHAT)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .wechatCredentials(
              new WeChatCredentialsDto()
                  .appId("wechatChannel app id")
                  .appSecret("wechatChannel secret")
                  .token("wechatChannel token")
                  .aesKey("wechatChannel AES key"));
  public static ConversationChannelCredentialDto conversationChannelWeChatRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.WECHAT)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .wechatCredentials(
              new WeChatCredentialsDto()
                  .appId("wechatChannel app id")
                  .appSecret("wechatChannel secret")
                  .token("wechatChannel token")
                  .aesKey("wechatChannel AES key"));
  public static ConversationChannelCredentialDto conversationChannelWhatsAppResponseDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.WHATSAPP)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .state(
              new ConversationChannelCredentialStateDto()
                  .status("PENDING")
                  .description("description value"))
          .staticBearer(
              new StaticBearerCredentialDto()
                  .claimedIdentity("whatsAppChannel my claimed identity")
                  .token("whatsAppChannel my token"));
  public static ConversationChannelCredentialDto conversationChannelWhatsAppRequestDto =
      new ConversationChannelCredentialDto()
          .channel(ConversationChannelDto.WHATSAPP)
          .callbackSecret("callback secret")
          .channelKnownId("channel id")
          .staticBearer(
              new StaticBearerCredentialDto()
                  .claimedIdentity("whatsAppChannel my claimed identity")
                  .token("whatsAppChannel my token"));

  @Test
  void serializeConversationChannelInstagramDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelInstagramResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelInstagramDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelInstagramDto() {
    Assertions.assertThat(loadedConversationChannelInstagramDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelInstagramResponseDto);
  }

  @Test
  void serializeConversationChannelKakaoTalkDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelKakaoTalkResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelKakaoTalkDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelKakaoTalkDto() {
    Assertions.assertThat(loadedConversationChannelKakaoTalkDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelKakaoTalkResponseDto);
  }

  @Test
  void serializeConversationChannelKakaoTalkChatDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelKakaoTalkChatResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelKakaoTalkChatDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelKakaoTalkChatDto() {
    Assertions.assertThat(loadedConversationChannelKakaoTalkChatDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelKakaoTalkChatResponseDto);
  }

  @Test
  void serializeConversationChannelLineDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelLineResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelLineDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelLineDto() {
    Assertions.assertThat(loadedConversationChannelLineDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelLineResponseDto);
  }

  @Test
  void serializeConversationChannelMessengerDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelMessengerResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelMessengerDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelMessengerDto() {
    Assertions.assertThat(loadedConversationChannelMessengerDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelMessengerResponseDto);
  }

  @Test
  void serializeConversationChannelMMSDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelMMSResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelMMSDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelMMSDto() {
    Assertions.assertThat(loadedConversationChannelMMSDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelMMSResponseDto);
  }

  @Test
  void serializeConversationChannelRCSDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelRCSResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelRCSDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelRCSDto() {
    Assertions.assertThat(loadedConversationChannelRCSDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelRCSResponseDto);
  }

  @Test
  void serializeConversationChannelSMSDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelSMSResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelSMSDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelSMSDto() {
    Assertions.assertThat(loadedConversationChannelSMSDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelSMSResponseDto);
  }

  @Test
  void serializeConversationChannelTelegramDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelTelegramResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelTelegramDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelTelegramDto() {
    Assertions.assertThat(loadedConversationChannelTelegramDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelTelegramResponseDto);
  }

  @Test
  void serializeConversationChannelViberDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelViberResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelViberDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelViberDto() {
    Assertions.assertThat(loadedConversationChannelViberDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelViberResponseDto);
  }

  @Test
  void serializeConversationChannelViberBmDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelViberBmResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelViberBmDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelViberBmDto() {
    Assertions.assertThat(loadedConversationChannelViberBmDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelViberBmResponseDto);
  }

  @Test
  void serializeConversationChannelWeChatDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelWeChatResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelWeChatDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelWeChatDto() {
    Assertions.assertThat(loadedConversationChannelWeChatDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelWeChatResponseDto);
  }

  @Test
  void serializeConversationChannelWhatsAppDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelWhatsAppResponseDto);

    JSONAssert.assertEquals(jsonConversationChannelWhatsAppDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelWhatsAppDto() {
    Assertions.assertThat(loadedConversationChannelWhatsAppDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelWhatsAppResponseDto);
  }
}
