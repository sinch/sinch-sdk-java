package com.sinch.sample.conversation.application;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.request.ConversationChannelCredentialsRequestBuilderFactory;
import com.sinch.sdk.domains.conversation.models.v1.credentials.AppleBcCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.BasicAuthCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.InstagramCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.KakaoTalkChatCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.KakaoTalkCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.LineCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.MMSCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticBearerCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticTokenCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.TelegramCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.WeChatCredentials;
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

    var appleBcChannel =
        ConversationChannelCredentialsRequestBuilderFactory.appleBc(
                AppleBcCredentials.builder()
                    .setApplePayCertificatePassword("appleBc password")
                    .setApplePayCertificateReference("appleBc certificate reference")
                    .setMerchantId("appleBc merchant ID")
                    .setBusinessChatAccountId("appleBc business chat account id")
                    .build())
            .build();

    var instagramChannel =
        ConversationChannelCredentialsRequestBuilderFactory.instagram(
                InstagramCredentials.builder()
                    .setBusinessAccountId("instagramChannel business account id")
                    .setToken("instagramChannel token")
                    .build())
            .build();

    var kakaoTalkChannel =
        ConversationChannelCredentialsRequestBuilderFactory.kakaoTalk(
                KakaoTalkCredentials.builder()
                    .setKakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                    .setKakaotalkSenderKey("kakaoTalkChannel a sender key")
                    .build())
            .build();

    var kakaoTalkChatChannel =
        ConversationChannelCredentialsRequestBuilderFactory.kakaoTalkChat(
                KakaoTalkChatCredentials.builder()
                    .setKakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                    .setApiKey("kakaoTalkChatChannel api key")
                    .build())
            .build();

    var lineChannel =
        ConversationChannelCredentialsRequestBuilderFactory.line(
                LineCredentials.builder()
                    .setToken("lineChannel a token value")
                    .setSecret("lineChannel a secret value")
                    .build())
            .build();

    var messengerChannel =
        ConversationChannelCredentialsRequestBuilderFactory.messenger(
                StaticTokenCredentials.builder().setToken("messengerChannel a token value").build())
            .build();

    var mmsChannel =
        ConversationChannelCredentialsRequestBuilderFactory.mms(
                MMSCredentials.builder()
                    .setApiKey("mmsChannel an api key")
                    .setAccountId("mmsChannel an account id")
                    //   .setDefaultSender("mmsChannel a default sender")
                    .setBasicAuth(
                        BasicAuthCredentials.builder()
                            .setUsername("mmsChannel an user name")
                            .setPassword("mmsChannel a password")
                            .build())
                    .build())
            .build();

    var rcsChannel =
        ConversationChannelCredentialsRequestBuilderFactory.rcs(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity("rcsChannel my claimed identity")
                    .setToken("rcsChannel my token")
                    .build())
            .build();

    var smsChannel =
        ConversationChannelCredentialsRequestBuilderFactory.sms(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity(smsServicePlanId)
                    .setToken(smsApiToken)
                    .build())
            .build();

    var telegramChannel =
        ConversationChannelCredentialsRequestBuilderFactory.telegram(
                TelegramCredentials.builder().setToken("telegramChannel token").build())
            .build();

    var viberChannel =
        ConversationChannelCredentialsRequestBuilderFactory.viber(
                StaticTokenCredentials.builder().setToken("viberChannel token").build())
            .build();

    var viberBMChannel =
        ConversationChannelCredentialsRequestBuilderFactory.viberBm(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity("viberBMChannel my claimed identity")
                    .setToken("viberBMChannel my token")
                    .build())
            .build();

    var wechatChannel =
        ConversationChannelCredentialsRequestBuilderFactory.weChat(
                WeChatCredentials.builder()
                    .setAesKey("wechatChannel AES key")
                    .setAppId("wechatChannel app id")
                    .setAppSecret("wechatChannel secret")
                    .setToken("wechatChannel token")
                    .build())
            .build();
    var whatsAppChannel =
        ConversationChannelCredentialsRequestBuilderFactory.whatsApp(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity("whatsAppChannel my claimed identity")
                    .setToken("whatsAppChannel my token")
                    .build())
            .build();

    var channelCredentials =
        Arrays.asList(
            appleBcChannel,
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
        AppCreateRequest.builder()
            .setChannelCredentials(channelCredentials)
            .setDisplayName("Created from Java SDK")
            .build();
    var result = client.conversation().app().create(parameters);

    LOGGER.info("Response: " + result);
  }
}
