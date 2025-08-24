package com.sinch.sample.conversation.application;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.AppService;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.credentials.AppleBusinessChatCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.BasicAuthCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentialsBuilderFactory;
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

    AppService service = client.conversation().v1().app();

    LOGGER.info("Create conversation Application");

    var appleBcChannel =
        ConversationChannelCredentialsBuilderFactory.appleBc(
                AppleBusinessChatCredentials.builder()
                    .setApplePayCertificatePassword("appleBc password")
                    .setApplePayCertificateReference("appleBc certificate reference")
                    .setMerchantId("appleBc merchant ID")
                    .setBusinessChatAccountId("appleBc business chat account id")
                    .build())
            .build();

    var instagramChannel =
        ConversationChannelCredentialsBuilderFactory.instagram(
                InstagramCredentials.builder()
                    .setBusinessAccountId("instagramChannel business account id")
                    .setToken("instagramChannel token")
                    .build())
            .build();

    var kakaoTalkChannel =
        ConversationChannelCredentialsBuilderFactory.kakaoTalk(
                KakaoTalkCredentials.builder()
                    .setKakaotalkPlusFriendId("kakaoTalkChannel a friend id")
                    .setKakaotalkSenderKey("kakaoTalkChannel a sender key")
                    .build())
            .build();

    var kakaoTalkChatChannel =
        ConversationChannelCredentialsBuilderFactory.kakaoTalkChat(
                KakaoTalkChatCredentials.builder()
                    .setKakaotalkPlusFriendId("kakaoTalkChatChannel a friend id")
                    .setApiKey("kakaoTalkChatChannel api key")
                    .build())
            .build();

    var lineChannel =
        ConversationChannelCredentialsBuilderFactory.line(
                LineCredentials.builder()
                    .setToken("lineChannel a token value")
                    .setSecret("lineChannel a secret value")
                    .build())
            .build();

    var messengerChannel =
        ConversationChannelCredentialsBuilderFactory.messenger(
                StaticTokenCredentials.builder().setToken("messengerChannel a token value").build())
            .build();

    var mmsChannel =
        ConversationChannelCredentialsBuilderFactory.mms(
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
        ConversationChannelCredentialsBuilderFactory.rcs(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity("rcsChannel my claimed identity")
                    .setToken("rcsChannel my token")
                    .build())
            .build();

    var smsChannel =
        ConversationChannelCredentialsBuilderFactory.sms(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity(smsServicePlanId)
                    .setToken(smsApiToken)
                    .build())
            .build();

    var telegramChannel =
        ConversationChannelCredentialsBuilderFactory.telegram(
                TelegramCredentials.builder().setToken("telegramChannel token").build())
            .build();

    var viberBMChannel =
        ConversationChannelCredentialsBuilderFactory.viberBm(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity("viberBMChannel my claimed identity")
                    .setToken("viberBMChannel my token")
                    .build())
            .build();

    var wechatChannel =
        ConversationChannelCredentialsBuilderFactory.weChat(
                WeChatCredentials.builder()
                    .setAesKey("wechatChannel AES key")
                    .setAppId("wechatChannel app id")
                    .setAppSecret("wechatChannel secret")
                    .setToken("wechatChannel token")
                    .build())
            .build();
    var whatsAppChannel =
        ConversationChannelCredentialsBuilderFactory.whatsApp(
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
            viberBMChannel,
            wechatChannel,
            whatsAppChannel);
    var parameters =
        AppCreateRequest.builder()
            .setChannelCredentials(channelCredentials)
            .setDisplayName("Created from Java SDK")
            .build();
    var result = service.create(parameters);

    LOGGER.info("Response: " + result);
  }
}
