package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;

public class ConversationChannelCredentialsBuilderFactory {

  public static ConversationChannelCredentials.Builder appleBc(
      AppleBusinessChatCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.APPLEBC)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder instagram(InstagramCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.INSTAGRAM)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder kakaoTalk(KakaoTalkCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.KAKAOTALK)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder kakaoTalkChat(
      KakaoTalkChatCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.KAKAOTALKCHAT)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder line(LineCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.LINE)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder messenger(
      StaticTokenCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.MESSENGER)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder mms(MMSCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.MMS)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder rcs(StaticBearerCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.RCS)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder sms(StaticBearerCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.SMS)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder telegram(TelegramCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.TELEGRAM)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder viber(StaticTokenCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.VIBER)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder viberBm(
      StaticBearerCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.VIBERBM)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder weChat(WeChatCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.WECHAT)
        .setCredentials(credentials);
  }

  public static ConversationChannelCredentials.Builder whatsApp(
      StaticBearerCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.WHATSAPP)
        .setCredentials(credentials);
  }
}
