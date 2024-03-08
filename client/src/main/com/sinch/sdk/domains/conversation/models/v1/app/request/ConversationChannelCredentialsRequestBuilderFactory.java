package com.sinch.sdk.domains.conversation.models.v1.app.request;

import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.credentials.AppleBcCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.InstagramCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.KakaoTalkChatCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.KakaoTalkCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.LineCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.MMSCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticBearerCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticTokenCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.TelegramCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.WeChatCredentials;

public class ConversationChannelCredentialsRequestBuilderFactory {

  public static ConversationChannelCredentialRequest.Builder appleBc(
      AppleBcCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.APPLEBC)
        .setApplebcCredentials(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder instagram(
      InstagramCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.INSTAGRAM)
        .setInstagramCredentials(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder kakaoTalk(
      KakaoTalkCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.KAKAOTALK)
        .setKakaotalkCredentials(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder kakaoTalkChat(
      KakaoTalkChatCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.KAKAOTALKCHAT)
        .setKakaotalkchatCredentials(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder line(LineCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.LINE)
        .setLineCredentials(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder messenger(
      StaticTokenCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.MESSENGER)
        .setStaticToken(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder mms(MMSCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.MMS)
        .setMmsCredentials(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder rcs(
      StaticBearerCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.RCS)
        .setStaticBearer(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder sms(
      StaticBearerCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.SMS)
        .setStaticBearer(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder telegram(
      TelegramCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.TELEGRAM)
        .setTelegramCredentials(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder viber(
      StaticTokenCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.VIBER)
        .setStaticToken(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder viberBm(
      StaticBearerCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.VIBERBM)
        .setStaticBearer(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder weChat(WeChatCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.WECHAT)
        .setWechatCredentials(credentials);
  }

  public static ConversationChannelCredentialRequest.Builder whatsApp(
      StaticBearerCredentials credentials) {
    return ConversationChannelCredentialRequest.builder()
        .setChannel(ConversationChannel.WHATSAPP)
        .setStaticBearer(credentials);
  }
}
