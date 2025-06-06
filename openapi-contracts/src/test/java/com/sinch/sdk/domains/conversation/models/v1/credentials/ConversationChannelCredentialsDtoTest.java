package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConversationChannelCredentialsDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelAppleBusinessChatRequestDto.json")
  String jsonConversationChannelAppleBcRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelAppleBusinessChatResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelAppleBcDto;

  public static ConversationChannelCredentials conversationChannelAppleBcResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.APPLEBC)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              AppleBusinessChatCredentials.builder()
                  .setBusinessChatAccountId("appleBc business_chat_account_id value")
                  .setMerchantId("appleBc merchant_id value")
                  .setApplePayCertificateReference("appleBc apple_pay_certificate_reference value")
                  .setApplePayCertificatePassword("appleBc apple_pay_certificate_password value")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  public static ConversationChannelCredentials conversationChannelAppleBcRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.APPLEBC)
          .setCallbackSecret("callback secret")
          .setCredentials(
              AppleBusinessChatCredentials.builder()
                  .setBusinessChatAccountId("appleBc business_chat_account_id value")
                  .setMerchantId("appleBc merchant_id value")
                  .setApplePayCertificateReference("appleBc apple_pay_certificate_reference value")
                  .setApplePayCertificatePassword("appleBc apple_pay_certificate_password value")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelInstagramRequestDto.json")
  String jsonConversationChannelInstagramRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelInstagramResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelInstagramDto;

  public static ConversationChannelCredentials conversationChannelInstagramResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.INSTAGRAM)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              InstagramCredentials.builder()
                  .setToken("instagramChannel token")
                  .setBusinessAccountId("instagramChannel business account id")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelInstagramRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.INSTAGRAM)
          .setCallbackSecret("callback secret")
          .setCredentials(
              InstagramCredentials.builder()
                  .setToken("instagramChannel token")
                  .setBusinessAccountId("instagramChannel business account id")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelKakaoTalkRequestDto.json")
  String jsonConversationChannelKakaoTalkRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelKakaoTalkResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelKakaoTalkDto;

  public static ConversationChannelCredentials conversationChannelKakaoTalkResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.KAKAOTALK)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              KakaoTalkCredentials.builder()
                  .setKakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                  .setKakaotalkSenderKey("kakaoTalkChannel a sender key")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelKakaoTalkRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.KAKAOTALK)
          .setCallbackSecret("callback secret")
          .setCredentials(
              KakaoTalkCredentials.builder()
                  .setKakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                  .setKakaotalkSenderKey("kakaoTalkChannel a sender key")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelKakaoTalkChatRequestDto.json")
  String jsonConversationChannelKakaoTalkChatRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelKakaoTalkChatResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelKakaoTalkChatDto;

  public static ConversationChannelCredentials conversationChannelKakaoTalkChatResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.KAKAOTALKCHAT)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              KakaoTalkChatCredentials.builder()
                  .setKakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                  .setApiKey("")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelKakaoTalkChatRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.KAKAOTALKCHAT)
          .setCallbackSecret("callback secret")
          .setCredentials(
              KakaoTalkChatCredentials.builder()
                  .setKakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                  .setApiKey("")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelLineRequestDto.json")
  String jsonConversationChannelLineRequestDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelLineResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelLineDto;

  public static ConversationChannelCredentials conversationChannelLineResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.LINE)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              LineCredentials.builder()
                  .setToken("lineChannel a token value")
                  .setSecret("lineChannel a secret value")
                  .setIsDefault(true)
                  .build())
          .setCredentialOrdinalNumber(1)
          .build();
  public static ConversationChannelCredentials conversationChannelLineRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.LINE)
          .setCallbackSecret("callback secret")
          .setCredentials(
              LineCredentials.builder()
                  .setToken("lineChannel a token value")
                  .setSecret("lineChannel a secret value")
                  .setIsDefault(true)
                  .build())
          .setCredentialOrdinalNumber(1)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelLineEnterpriseThailandRequestDto.json")
  String jsonConversationChannelLineEnterpriseThailandRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelLineEnterpriseThailandResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelLineEnterpriseThailandDto;

  public static ConversationChannelCredentials
      conversationChannelLineEnterpriseThailandResponseDto =
          ConversationChannelCredentials.builder()
              .setChannel(ConversationChannel.LINE)
              .setCallbackSecret("callback secret")
              .setChannelKnownId("channel id")
              .setState(
                  ChannelIntegrationState.builder()
                      .setStatus(ChannelIntegrationStatus.PENDING)
                      .setDescription("description value")
                      .build())
              .setCredentials(
                  LineEnterpriseCredentialsThailand.builder()
                      .setToken("line enterprise credentials thailand token value")
                      .setSecret("line enterprise credentials thailand secret value")
                      .setIsDefault(true)
                      .build())
              .setCredentialOrdinalNumber(1)
              .build();
  public static ConversationChannelCredentials conversationChannelLineEnterpriseThailandRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.LINE)
          .setCallbackSecret("callback secret")
          .setCredentials(
              LineEnterpriseCredentialsThailand.builder()
                  .setToken("line enterprise credentials thailand token value")
                  .setSecret("line enterprise credentials thailand secret value")
                  .setIsDefault(true)
                  .build())
          .setCredentialOrdinalNumber(1)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelLineEnterpriseJapanRequestDto.json")
  String jsonConversationChannelLineEnterpriseJapanRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelLineEnterpriseJapanResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelLineEnterpriseJapanDto;

  public static ConversationChannelCredentials conversationChannelLineEnterpriseJapanResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.LINE)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              LineEnterpriseCredentialsJapan.builder()
                  .setToken("line enterprise credentials japan token value")
                  .setSecret("line enterprise credentials japan secret value")
                  .setIsDefault(true)
                  .build())
          .setCredentialOrdinalNumber(1)
          .build();
  public static ConversationChannelCredentials conversationChannelLineEnterpriseJapanRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.LINE)
          .setCallbackSecret("callback secret")
          .setCredentials(
              LineEnterpriseCredentialsJapan.builder()
                  .setToken("line enterprise credentials japan token value")
                  .setSecret("line enterprise credentials japan secret value")
                  .setIsDefault(true)
                  .build())
          .setCredentialOrdinalNumber(1)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelMessengerRequestDto.json")
  String jsonConversationChannelMessengerRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelMessengerResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelMessengerDto;

  public static ConversationChannelCredentials conversationChannelMessengerResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.MESSENGER)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              StaticTokenCredentials.builder().setToken("messengerChannel a token value").build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelMessengerRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.MESSENGER)
          .setCallbackSecret("callback secret")
          .setCredentials(
              StaticTokenCredentials.builder().setToken("messengerChannel a token value").build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelMMSRequestDto.json")
  String jsonConversationChannelMMSRequestDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelMMSResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelMMSDto;

  public static ConversationChannelCredentials conversationChannelMMSResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.MMS)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
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
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelMMSRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.MMS)
          .setCallbackSecret("callback secret")
          .setCredentials(
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
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelRCSRequestDto.json")
  String jsonConversationChannelRCSRequestDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelRCSResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelRCSDto;

  public static ConversationChannelCredentials conversationChannelRCSResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.RCS)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("rcsChannel my claimed identity")
                  .setToken("rcsChannel my token")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelRCSRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.RCS)
          .setCallbackSecret("callback secret")
          .setCredentials(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("rcsChannel my claimed identity")
                  .setToken("rcsChannel my token")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelSMSRequestDto.json")
  String jsonConversationChannelSMSRequestDto;

  @GivenJsonResource("/domains/conversation/v1/credentials/ConversationChannelSMSResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelSMSDto;

  public static ConversationChannelCredentials conversationChannelSMSResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.SMS)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("smsChannel my claimed identity")
                  .setToken("smsChannel my token")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelSMSRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.SMS)
          .setCallbackSecret("callback secret")
          .setCredentials(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("smsChannel my claimed identity")
                  .setToken("smsChannel my token")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelTelegramRequestDto.json")
  String jsonConversationChannelTelegramRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelTelegramResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelTelegramDto;

  public static ConversationChannelCredentials conversationChannelTelegramResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.TELEGRAM)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(TelegramCredentials.builder().setToken("telegramChannel token").build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelTelegramRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.TELEGRAM)
          .setCallbackSecret("callback secret")
          .setCredentials(TelegramCredentials.builder().setToken("telegramChannel token").build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource("/domains/conversation/v1/credentials/ConversationChannelViberRequestDto.json")
  String jsonConversationChannelViberRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelViberResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelViberDto;

  public static ConversationChannelCredentials conversationChannelViberResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.VIBER)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(StaticTokenCredentials.builder().setToken("viberChannel token").build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelViberRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.VIBER)
          .setCallbackSecret("callback secret")
          .setCredentials(StaticTokenCredentials.builder().setToken("viberChannel token").build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelViberBmRequestDto.json")
  String jsonConversationChannelViberBmRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelViberBmResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelViberBmDto;

  public static ConversationChannelCredentials conversationChannelViberBmResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.VIBERBM)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("viberBMChannel my claimed identity")
                  .setToken("viberBMChannel my token")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelViberBmRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.VIBERBM)
          .setCallbackSecret("callback secret")
          .setCredentials(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("viberBMChannel my claimed identity")
                  .setToken("viberBMChannel my token")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelWeChatRequestDto.json")
  String jsonConversationChannelWeChatRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelWeChatResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelWeChatDto;

  public static ConversationChannelCredentials conversationChannelWeChatResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.WECHAT)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              WeChatCredentials.builder()
                  .setAppId("wechatChannel app id")
                  .setAppSecret("wechatChannel secret")
                  .setToken("wechatChannel token")
                  .setAesKey("wechatChannel AES key")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelWeChatRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.WECHAT)
          .setCallbackSecret("callback secret")
          .setCredentials(
              WeChatCredentials.builder()
                  .setAppId("wechatChannel app id")
                  .setAppSecret("wechatChannel secret")
                  .setToken("wechatChannel token")
                  .setAesKey("wechatChannel AES key")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/credentials/ConversationChannelWhatsAppRequestDto.json")
  String jsonConversationChannelWhatsAppRequestDto;

  @GivenJsonResource(
      "/domains/conversation/v1/credentials/ConversationChannelWhatsAppResponseDto.json")
  ConversationChannelCredentials loadedConversationChannelWhatsAppDto;

  public static ConversationChannelCredentials conversationChannelWhatsAppResponseDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.WHATSAPP)
          .setCallbackSecret("callback secret")
          .setChannelKnownId("channel id")
          .setState(
              ChannelIntegrationState.builder()
                  .setStatus(ChannelIntegrationStatus.PENDING)
                  .setDescription("description value")
                  .build())
          .setCredentials(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("whatsAppChannel my claimed identity")
                  .setToken("whatsAppChannel my token")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();
  public static ConversationChannelCredentials conversationChannelWhatsAppRequestDto =
      ConversationChannelCredentials.builder()
          .setChannel(ConversationChannel.WHATSAPP)
          .setCallbackSecret("callback secret")
          .setCredentials(
              StaticBearerCredentials.builder()
                  .setClaimedIdentity("whatsAppChannel my claimed identity")
                  .setToken("whatsAppChannel my token")
                  .build())
          .setCredentialOrdinalNumber(0)
          .build();

  @Test
  void serializeConversationChannelAppleBcDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelAppleBcRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelAppleBcRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelAppleBcDto() {
    Assertions.assertThat(loadedConversationChannelAppleBcDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelAppleBcResponseDto);
  }

  @Test
  void serializeConversationChannelInstagramDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelInstagramRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelInstagramRequestDto, serializedString, true);
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
        objectMapper.writeValueAsString(conversationChannelKakaoTalkRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelKakaoTalkRequestDto, serializedString, true);
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
        objectMapper.writeValueAsString(conversationChannelKakaoTalkChatRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelKakaoTalkChatRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelKakaoTalkChatDto() {
    Assertions.assertThat(loadedConversationChannelKakaoTalkChatDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelKakaoTalkChatResponseDto);
  }

  @Test
  void serializeConversationChannelLineDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelLineRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelLineRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelLineDto() {
    Assertions.assertThat(loadedConversationChannelLineDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelLineResponseDto);
  }

  @Test
  void serializeConversationChannelLineEnterpriseThailandDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelLineEnterpriseThailandRequestDto);

    JSONAssert.assertEquals(
        jsonConversationChannelLineEnterpriseThailandRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelLineEnterpriseThailandDto() {
    Assertions.assertThat(loadedConversationChannelLineEnterpriseThailandDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelLineEnterpriseThailandResponseDto);
  }

  @Test
  void serializeConversationChannelLineEnterpriseJapanDto()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelLineEnterpriseJapanRequestDto);

    JSONAssert.assertEquals(
        jsonConversationChannelLineEnterpriseJapanRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelLineEnterpriseJapanDto() {
    Assertions.assertThat(loadedConversationChannelLineEnterpriseJapanDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelLineEnterpriseJapanResponseDto);
  }

  @Test
  void serializeConversationChannelMessengerDto() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(conversationChannelMessengerRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelMessengerRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelMessengerDto() {
    Assertions.assertThat(loadedConversationChannelMessengerDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelMessengerResponseDto);
  }

  @Test
  void serializeConversationChannelMMSDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelMMSRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelMMSRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelMMSDto() {
    Assertions.assertThat(loadedConversationChannelMMSDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelMMSResponseDto);
  }

  @Test
  void serializeConversationChannelRCSDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelRCSRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelRCSRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelRCSDto() {
    Assertions.assertThat(loadedConversationChannelRCSDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelRCSResponseDto);
  }

  @Test
  void serializeConversationChannelSMSDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelSMSRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelSMSRequestDto, serializedString, true);
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
        objectMapper.writeValueAsString(conversationChannelTelegramRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelTelegramRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelTelegramDto() {
    Assertions.assertThat(loadedConversationChannelTelegramDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelTelegramResponseDto);
  }

  @Test
  void serializeConversationChannelViberDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelViberRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelViberRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelViberDto() {
    Assertions.assertThat(loadedConversationChannelViberDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelViberResponseDto);
  }

  @Test
  void serializeConversationChannelViberBmDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelViberBmRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelViberBmRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelViberBmDto() {
    Assertions.assertThat(loadedConversationChannelViberBmDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelViberBmResponseDto);
  }

  @Test
  void serializeConversationChannelWeChatDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationChannelWeChatRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelWeChatRequestDto, serializedString, true);
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
        objectMapper.writeValueAsString(conversationChannelWhatsAppRequestDto);

    JSONAssert.assertEquals(jsonConversationChannelWhatsAppRequestDto, serializedString, true);
  }

  @Test
  void deserializeConversationChannelWhatsAppDto() {
    Assertions.assertThat(loadedConversationChannelWhatsAppDto)
        .usingRecursiveComparison()
        .isEqualTo(conversationChannelWhatsAppResponseDto);
  }
}
