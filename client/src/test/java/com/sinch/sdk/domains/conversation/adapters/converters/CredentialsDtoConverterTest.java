package com.sinch.sdk.domains.conversation.adapters.converters;

import com.sinch.sdk.domains.conversation.models.credentials.BasicAuthCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelInstagram;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelKakaoTalk;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelKakaoTalkChat;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelLine;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelMMS;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelMessenger;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelRCS;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelSMS;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelTelegram;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelViber;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelViberBM;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelWeChat;
import com.sinch.sdk.domains.conversation.models.credentials.ConversationChannelWhatsApp;
import com.sinch.sdk.domains.conversation.models.credentials.CredentialState;
import com.sinch.sdk.domains.conversation.models.credentials.CredentialStateStatusType;
import com.sinch.sdk.domains.conversation.models.credentials.InstagramCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.KakaoTalkChatCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.KakaoTalkCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.LineCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.MMSCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.StaticBearerCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.StaticTokenCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.TelegramCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.WeChatCredentials;
import com.sinch.sdk.domains.conversation.models.dto.v1.ConversationChannelCredentialsDtoTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CredentialsDtoConverterTest {

  @Test
  void convertINSTAGRAMFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelInstagramResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelInstagram.builder()
                .setCredentials(
                    InstagramCredentials.builder()
                        .setBusinessAccountId("instagramChannel business account id")
                        .setToken("instagramChannel token")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertINSTAGRAMToDto() {
    Assertions.assertThat(
            ConversationChannelCredentialsDtoTest.conversationChannelInstagramRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelInstagram.builder()
                    .setCredentials(
                        InstagramCredentials.builder()
                            .setBusinessAccountId("instagramChannel business account id")
                            .setToken("instagramChannel token")
                            .build())
                    .setCallbackSecret("callback secret")
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertKAKAO_TALKFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelKakaoTalkResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelKakaoTalk.builder()
                .setCredentials(
                    KakaoTalkCredentials.builder()
                        .setKakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                        .setKakaotalkSenderKey("kakaoTalkChannel a sender key")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertKAKAO_TALKToDto() {
    Assertions.assertThat(
            ConversationChannelCredentialsDtoTest.conversationChannelKakaoTalkRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelKakaoTalk.builder()
                    .setCredentials(
                        KakaoTalkCredentials.builder()
                            .setKakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                            .setKakaotalkSenderKey("kakaoTalkChannel a sender key")
                            .build())
                    .setCallbackSecret("callback secret")
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertKAKAO_TALK_CHATFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelKakaoTalkChatResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelKakaoTalkChat.builder()
                .setCredentials(
                    KakaoTalkChatCredentials.builder()
                        .setKakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                        .setApiKey("")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertKAKAO_TALK_CHATToDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelKakaoTalkChatRequestDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelKakaoTalkChat.builder()
                .setCredentials(
                    KakaoTalkChatCredentials.builder()
                        .setKakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                        .setApiKey("")
                        .build())
                .setCallbackSecret("callback secret")
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertLINEFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelLineResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelLine.builder()
                .setCredentials(
                    LineCredentials.builder()
                        .setToken("lineChannel a token value")
                        .setSecret("lineChannel a secret value")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertLINEToDto() {
    Assertions.assertThat(ConversationChannelCredentialsDtoTest.conversationChannelLineRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelLine.builder()
                    .setCredentials(
                        LineCredentials.builder()
                            .setToken("lineChannel a token value")
                            .setSecret("lineChannel a secret value")
                            .build())
                    .setCallbackSecret("callback secret")
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertMESSENGERFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelMessengerResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelMessenger.builder()
                .setCredentials(
                    StaticTokenCredentials.builder()
                        .setToken("messengerChannel a token value")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertMESSENGERToDto() {
    Assertions.assertThat(
            ConversationChannelCredentialsDtoTest.conversationChannelMessengerRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelMessenger.builder()
                    .setCredentials(
                        StaticTokenCredentials.builder()
                            .setToken("messengerChannel a token value")
                            .build())
                    .setCallbackSecret("callback secret")
                    .setState(
                        CredentialState.builder()
                            .setDescription("description value")
                            .setStatus(CredentialStateStatusType.PENDING)
                            .build())
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertMMSFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelMMSResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelMMS.builder()
                .setCredentials(
                    MMSCredentials.builder()
                        .setAccountId("mmsChannel an account id")
                        .setApiKey("mmsChannel an api key")
                        .setDefaultSender("mmsChannel default sender")
                        .setBasicAuth(
                            BasicAuthCredentials.builder()
                                .setUsername("mmsChannel an user name")
                                .setPassword("mmsChannel a password")
                                .build())
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertMMSToDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelMMSRequestDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelMMS.builder()
                .setCredentials(
                    MMSCredentials.builder()
                        .setAccountId("mmsChannel an account id")
                        .setApiKey("mmsChannel an api key")
                        .setDefaultSender("mmsChannel default sender")
                        .setBasicAuth(
                            BasicAuthCredentials.builder()
                                .setUsername("mmsChannel an user name")
                                .setPassword("mmsChannel a password")
                                .build())
                        .build())
                .setCallbackSecret("callback secret")
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertRCSFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelRCSResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelRCS.builder()
                .setCredentials(
                    StaticBearerCredentials.builder()
                        .setClaimedIdentity("rcsChannel my claimed identity")
                        .setToken("rcsChannel my token")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertRCSToDto() {
    Assertions.assertThat(ConversationChannelCredentialsDtoTest.conversationChannelRCSRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelRCS.builder()
                    .setCredentials(
                        StaticBearerCredentials.builder()
                            .setClaimedIdentity("rcsChannel my claimed identity")
                            .setToken("rcsChannel my token")
                            .build())
                    .setCallbackSecret("callback secret")
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertSMSFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelSMSResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelSMS.builder()
                .setCredentials(
                    StaticBearerCredentials.builder()
                        .setClaimedIdentity("smsChannel my claimed identity")
                        .setToken("smsChannel my token")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertSMSToDto() {
    Assertions.assertThat(ConversationChannelCredentialsDtoTest.conversationChannelSMSRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelSMS.builder()
                    .setCredentials(
                        StaticBearerCredentials.builder()
                            .setClaimedIdentity("smsChannel my claimed identity")
                            .setToken("smsChannel my token")
                            .build())
                    .setCallbackSecret("callback secret")
                    .setState(
                        CredentialState.builder()
                            .setDescription("description value")
                            .setStatus(CredentialStateStatusType.PENDING)
                            .build())
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertTELEGRAMFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelTelegramResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelTelegram.builder()
                .setCredentials(
                    TelegramCredentials.builder().setToken("telegramChannel token").build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertTELEGRAMToDto() {
    Assertions.assertThat(
            ConversationChannelCredentialsDtoTest.conversationChannelTelegramRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelTelegram.builder()
                    .setCredentials(
                        TelegramCredentials.builder().setToken("telegramChannel token").build())
                    .setCallbackSecret("callback secret")
                    .setState(
                        CredentialState.builder()
                            .setDescription("description value")
                            .setStatus(CredentialStateStatusType.PENDING)
                            .build())
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertVIBERFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelViberResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelViber.builder()
                .setCredentials(
                    StaticTokenCredentials.builder().setToken("viberChannel token").build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertVIBERToDto() {
    Assertions.assertThat(ConversationChannelCredentialsDtoTest.conversationChannelViberRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelViber.builder()
                    .setCredentials(
                        StaticTokenCredentials.builder().setToken("viberChannel token").build())
                    .setCallbackSecret("callback secret")
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertVIBERBMFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelViberBmResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelViberBM.builder()
                .setCredentials(
                    StaticBearerCredentials.builder()
                        .setClaimedIdentity("viberBMChannel my claimed identity")
                        .setToken("viberBMChannel my token")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertVIBERBMToDto() {
    Assertions.assertThat(
            ConversationChannelCredentialsDtoTest.conversationChannelViberBmRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelViberBM.builder()
                    .setCredentials(
                        StaticBearerCredentials.builder()
                            .setClaimedIdentity("viberBMChannel my claimed identity")
                            .setToken("viberBMChannel my token")
                            .build())
                    .setCallbackSecret("callback secret")
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertWECHATFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelWeChatResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelWeChat.builder()
                .setCallbackSecret("my callback secret")
                .setCredentials(
                    WeChatCredentials.builder()
                        .setAppId("wechatChannel app id")
                        .setAesKey("wechatChannel AES key")
                        .setToken("wechatChannel token")
                        .setAppSecret("wechatChannel secret")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertWECHATToDto() {
    Assertions.assertThat(ConversationChannelCredentialsDtoTest.conversationChannelWeChatRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelWeChat.builder()
                    .setCallbackSecret("my callback secret")
                    .setCredentials(
                        WeChatCredentials.builder()
                            .setAppId("wechatChannel app id")
                            .setAesKey("wechatChannel AES key")
                            .setToken("wechatChannel token")
                            .setAppSecret("wechatChannel secret")
                            .build())
                    .setCallbackSecret("callback secret")
                    .setState(
                        CredentialState.builder()
                            .setDescription("description value")
                            .setStatus(CredentialStateStatusType.PENDING)
                            .build())
                    .setChannelKnownId("channel id")
                    .build()));
  }

  @Test
  void convertWHATSAPPFromDto() {
    Assertions.assertThat(
            CredentialsDtoConverter.convert(
                ConversationChannelCredentialsDtoTest.conversationChannelWhatsAppResponseDto))
        .usingRecursiveComparison()
        .isEqualTo(
            ConversationChannelWhatsApp.builder()
                .setCredentials(
                    StaticBearerCredentials.builder()
                        .setClaimedIdentity("whatsAppChannel my claimed identity")
                        .setToken("whatsAppChannel my token")
                        .build())
                .setCallbackSecret("callback secret")
                .setState(
                    CredentialState.builder()
                        .setDescription("description value")
                        .setStatus(CredentialStateStatusType.PENDING)
                        .build())
                .setChannelKnownId("channel id")
                .build());
  }

  @Test
  void convertWHATSAPPToDto() {
    Assertions.assertThat(
            ConversationChannelCredentialsDtoTest.conversationChannelWhatsAppRequestDto)
        .usingRecursiveComparison()
        .isEqualTo(
            CredentialsDtoConverter.convert(
                ConversationChannelWhatsApp.builder()
                    .setCredentials(
                        StaticBearerCredentials.builder()
                            .setClaimedIdentity("whatsAppChannel my claimed identity")
                            .setToken("whatsAppChannel my token")
                            .build())
                    .setCallbackSecret("callback secret")
                    .setState(
                        CredentialState.builder()
                            .setDescription("description value")
                            .setStatus(CredentialStateStatusType.PENDING)
                            .build())
                    .setChannelKnownId("channel id")
                    .build()));
  }
}
