package com.sinch.sample.conversation.application;

import com.sinch.sample.BaseApplication;
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
import com.sinch.sdk.domains.conversation.models.credentials.InstagramCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.KakaoTalkChatCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.KakaoTalkCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.LineCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.MMSCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.StaticBearerCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.StaticTokenCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.TelegramCredentials;
import com.sinch.sdk.domains.conversation.models.credentials.WeChatCredentials;
import com.sinch.sdk.domains.conversation.models.requests.AppRequestParameters;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Create extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Create.class.getName());

  public Create() throws IOException {}

  public static void main(String[] args) {
    try {
      new Create().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Create conversation Application");

    var instagramChannel =
        ConversationChannelInstagram.builder()
            .setCredentials(
                InstagramCredentials.builder()
                    .setBusinessAccountId("instagramChannel business account id")
                    .setToken("instagramChannel token")
                    .build())
            .build();

    var kakaoTalkChannel =
        ConversationChannelKakaoTalk.builder()
            .setCredentials(
                KakaoTalkCredentials.builder()
                    .setKakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                    .setKakaotalkSenderKey("kakaoTalkChannel a sender key")
                    .build())
            .build();

    var kakaoTalkChatChannel =
        ConversationChannelKakaoTalkChat.builder()
            .setCredentials(
                KakaoTalkChatCredentials.builder()
                    .setKakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                    .setApiKey("kakaoTalkChatChannel api key")
                    .build())
            .build();

    var lineChannel =
        ConversationChannelLine.builder()
            .setCredentials(
                LineCredentials.builder()
                    .setToken("lineChannel a token value")
                    .setSecret("lineChannel a secret value")
                    .build())
            .build();

    var messengerChannel =
        ConversationChannelMessenger.builder()
            .setCredentials(
                StaticTokenCredentials.builder().setToken("messengerChannel a token value").build())
            .build();

    var mmsChannel =
        ConversationChannelMMS.builder()
            .setCredentials(
                MMSCredentials.builder()
                    .setApiKey("mmsChannel an api key")
                    .setAccountId("mmsChannel an account id")
                    .setDefaultSender("mmsChannel a default sender")
                    .setBasicAuth(
                        BasicAuthCredentials.builder()
                            .setUsername("mmsChannel an user name")
                            .setPassword("mmsChannel a password")
                            .build())
                    .build())
            .build();

    var rcsChannel =
        ConversationChannelRCS.builder()
            .setCredentials(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity("rcsChannel my claimed identity")
                    .setToken("rcsChannel my token")
                    .build())
            .build();

    var smsChannel =
        ConversationChannelSMS.builder()
            .setCredentials(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity("smsChannel my claimed identity")
                    .setToken("smsChannel my token")
                    .build())
            .build();

    var telegramChannel =
        ConversationChannelTelegram.builder()
            .setCredentials(TelegramCredentials.builder().setToken("telegramChannel token").build())
            .build();

    var viberChannel =
        ConversationChannelViber.builder()
            .setCredentials(StaticTokenCredentials.builder().setToken("viberChannel token").build())
            .build();

    var viberBMChannel =
        ConversationChannelViberBM.builder()
            .setCredentials(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity("viberBMChannel my claimed identity")
                    .setToken("viberBMChannel my token")
                    .build())
            .build();

    var wechatChannel =
        ConversationChannelWeChat.builder()
            .setCredentials(
                WeChatCredentials.builder()
                    .setAesKey("wechatChannel AES key")
                    .setAppId("wechatChannel app id")
                    .setAppSecret("wechatChannel secret")
                    .setToken("wechatChannel token")
                    .build())
            .build();
    var whatsAppChannel =
        ConversationChannelWhatsApp.builder()
            .setCredentials(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity("whatsAppChannel my claimed identity")
                    .setToken("whatsAppChannel my token")
                    .build())
            .build();

    var channelCredentials =
        Arrays.asList(
            instagramChannel,
            kakaoTalkChannel,
            kakaoTalkChatChannel,
            lineChannel,
            messengerChannel,
            mmsChannel,
            rcsChannel,
            smsChannel,
            telegramChannel,
            viberChannel,
            viberBMChannel,
            wechatChannel,
            whatsAppChannel);
    var parameters =
        AppRequestParameters.builder()
            .setChannelCredentials(channelCredentials)
            .setDisplayName("Created from Java SDK")
            .build();
    var result = client.conversation().app().create(parameters);

    LOGGER.info("Response: " + result);
  }
}
