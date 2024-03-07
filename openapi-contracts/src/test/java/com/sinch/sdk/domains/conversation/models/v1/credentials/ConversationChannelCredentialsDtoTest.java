package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConversationChannelCredentialsDtoTest extends BaseTest {

  public static ConversationChannelCredentials conversationChannelInstagramResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.INSTAGRAM)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setInstagramCredentials(
              InstagramCredentials.builder()
                  .setToken("instagramChannel token")
                  .setBusinessAccountId("instagramChannel business account id")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelInstagramRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.INSTAGRAM)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setInstagramCredentials(
              InstagramCredentials.builder()
                  .setToken("instagramChannel token")
                  .setBusinessAccountId("instagramChannel business account id")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelKakaoTalkResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.KAKAOTALK)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setKakaotalkCredentials(
              KakaoTalkCredentials.builder()
                  .setKakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                  .setKakaotalkSenderKey("kakaoTalkChannel a sender key")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelKakaoTalkRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.KAKAOTALK)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setKakaotalkCredentials(
              KakaoTalkCredentials.builder()
                  .setKakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                  .setKakaotalkSenderKey("kakaoTalkChannel a sender key")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelKakaoTalkChatResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.KAKAOTALKCHAT)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setKakaotalkchatCredentials(
              KakaoTalkChatCredentials.builder()
                  .setKakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                  .setApiKey("")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelKakaoTalkChatRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.KAKAOTALKCHAT)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setKakaotalkchatCredentials(
              KakaoTalkChatCredentials.builder()
                  .setKakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                  .setApiKey("")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelLineResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.LINE)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setLineCredentials(
              LineCredentials.builder()
                  .setToken("lineChannel a token value")
                  .setSecret("lineChannel a secret value")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelLineRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.LINE)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setLineCredentials(
              LineCredentials.builder()
                  .setToken("lineChannel a token value")
                  .setSecret("lineChannel a secret value")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelMessengerResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.MESSENGER)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setStaticToken(
              StaticTokenCredentials.builder().setToken("messengerChannel a token value").build())
          .build();
  public static ConversationChannelCredentials conversationChannelMessengerRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.MESSENGER)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setStaticToken(
              StaticTokenCredentials.builder().setToken("messengerChannel a token value").build())
          .build();

  public static ConversationChannelCredentials conversationChannelMMSResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.MMS)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setMmsCredentials(
              MMSCredentials.builder()
                  .setBasicAuth(
                      BasicAuthCredentials.builder()
                          .setUsername("mmsChannel an user name")
                          .setPassword("mmsChannel a password")
                          .build())
                  .setAccountId("mmsChannel an account id")
                  .setApiKey("mmsChannel an api key")
                  // TODO ? .setDefaultSender("mmsChannel default sender")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelMMSRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.MMS)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setMmsCredentials(
              MMSCredentials.builder()
                  .setBasicAuth(
                      BasicAuthCredentials.builder()
                          .setUsername("mmsChannel an user name")
                          .setPassword("mmsChannel a password")
                          .build())
                  .setAccountId("mmsChannel an account id")
                  .setApiKey("mmsChannel an api key")
                  // TODO ? .setDefaultSender("mmsChannel default sender")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelRCSResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.RCS)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setStaticBearer(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("rcsChannel my claimed identity")
                  .setToken("rcsChannel my token")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelRCSRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.RCS)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setStaticBearer(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("rcsChannel my claimed identity")
                  .setToken("rcsChannel my token")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelSMSResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.SMS)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setStaticBearer(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("smsChannel my claimed identity")
                  .setToken("smsChannel my token")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelSMSRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.SMS)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setStaticBearer(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("smsChannel my claimed identity")
                  .setToken("smsChannel my token")
                  .build())
          .build();

  public static ConversationChannelCredentials conversationChannelTelegramResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.TELEGRAM)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setTelegramCredentials(
              TelegramCredentials.builder().setToken("telegramChannel token").build())
          .build();
  public static ConversationChannelCredentials conversationChannelTelegramRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.TELEGRAM)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setTelegramCredentials(
              TelegramCredentials.builder().setToken("telegramChannel token").build())
          .build();
  public static ConversationChannelCredentials conversationChannelViberResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.VIBER)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setStaticToken(StaticTokenCredentials.builder().setToken("viberChannel token").build())
          .build();
  public static ConversationChannelCredentials conversationChannelViberRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.VIBER)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setStaticToken(StaticTokenCredentials.builder().setToken("viberChannel token").build())
          .build();
  public static ConversationChannelCredentials conversationChannelViberBmResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.VIBERBM)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setStaticBearer(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("viberBMChannel my claimed identity")
                  .setToken("viberBMChannel my token")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelViberBmRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.VIBERBM)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setStaticBearer(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("viberBMChannel my claimed identity")
                  .setToken("viberBMChannel my token")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelWeChatResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.WECHAT)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setWechatCredentials(
              WeChatCredentials.builder()
                  .setAppId("wechatChannel app id")
                  .setAppSecret("wechatChannel secret")
                  .setToken("wechatChannel token")
                  .setAesKey("wechatChannel AES key")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelWeChatRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.WECHAT)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setWechatCredentials(
              WeChatCredentials.builder()
                  .setAppId("wechatChannel app id")
                  .setAppSecret("wechatChannel secret")
                  .setToken("wechatChannel token")
                  .setAesKey("wechatChannel AES key")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelWhatsAppResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.WHATSAPP)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus("PENDING")
                  .setDescription("description value")
                  .build())
          .setStaticBearer(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("whatsAppChannel my claimed identity")
                  .setToken("whatsAppChannel my token")
                  .build())
          .build();
  public static ConversationChannelCredentials conversationChannelWhatsAppRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.WHATSAPP)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setStaticBearer(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("whatsAppChannel my claimed identity")
                  .setToken("whatsAppChannel my token")
                  .build())
          .build();

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelInstagramDto.json")
  String jsonConversationChannelInstagramDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelInstagramDto.json")
  ConversationChannelCredentials loadedConversationChannelInstagramDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelKakaoTalkDto.json")
  String jsonConversationChannelKakaoTalkDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelKakaoTalkDto.json")
  ConversationChannelCredentials loadedConversationChannelKakaoTalkDto;

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelKakaoTalkChatDto.json")
  String jsonConversationChannelKakaoTalkChatDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelKakaoTalkChatDto.json")
  ConversationChannelCredentials loadedConversationChannelKakaoTalkChatDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelLineDto.json")
  String jsonConversationChannelLineDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelLineDto.json")
  ConversationChannelCredentials loadedConversationChannelLineDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelMessengerDto.json")
  ConversationChannelCredentials loadedConversationChannelMessengerDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelMessengerDto.json")
  String jsonConversationChannelMessengerDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelMMSDto.json")
  ConversationChannelCredentials loadedConversationChannelMMSDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelMMSDto.json")
  String jsonConversationChannelMMSDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelRCSDto.json")
  ConversationChannelCredentials loadedConversationChannelRCSDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelRCSDto.json")
  String jsonConversationChannelRCSDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelSMSDto.json")
  ConversationChannelCredentials loadedConversationChannelSMSDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelSMSDto.json")
  String jsonConversationChannelSMSDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelTelegramDto.json")
  ConversationChannelCredentials loadedConversationChannelTelegramDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelTelegramDto.json")
  String jsonConversationChannelTelegramDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelViberDto.json")
  ConversationChannelCredentials loadedConversationChannelViberDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelViberDto.json")
  String jsonConversationChannelViberDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelViberBmDto.json")
  ConversationChannelCredentials loadedConversationChannelViberBmDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelViberBmDto.json")
  String jsonConversationChannelViberBmDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelWeChatDto.json")
  ConversationChannelCredentials loadedConversationChannelWeChatDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelWeChatDto.json")
  String jsonConversationChannelWeChatDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelWhatsAppDto.json")
  ConversationChannelCredentials loadedConversationChannelWhatsAppDto;

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelWhatsAppDto.json")
  String jsonConversationChannelWhatsAppDto;

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
  void deserializeConversationChannelKakaoTalkDto() throws JsonProcessingException {
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
