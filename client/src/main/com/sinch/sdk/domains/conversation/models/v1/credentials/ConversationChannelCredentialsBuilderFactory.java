package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;

/** Factory helper for App credentials builder */
public class ConversationChannelCredentialsBuilderFactory {

  private ConversationChannelCredentialsBuilderFactory() {}

  /**
   * Create dedicated conversation credential builder for <code>{@link ConversationChannel#APPLEBC}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder appleBc(
      AppleBusinessChatCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.APPLEBC)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#INSTAGRAM}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder instagram(InstagramCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.INSTAGRAM)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#KAKAOTALK}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder kakaoTalk(KakaoTalkCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.KAKAOTALK)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>
   * {@link ConversationChannel#KAKAOTALKCHAT}</code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder kakaoTalkChat(
      KakaoTalkChatCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.KAKAOTALKCHAT)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#LINE}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder line(LineCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.LINE)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#MESSENGER}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder messenger(
      StaticTokenCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.MESSENGER)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#MMS}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder mms(MMSCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.MMS)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#RCS}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder rcs(StaticBearerCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.RCS)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#SMS}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder sms(StaticBearerCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.SMS)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#TELEGRAM}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder telegram(TelegramCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.TELEGRAM)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#VIBER}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder viber(StaticTokenCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.VIBER)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#VIBERBM}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder viberBm(
      StaticBearerCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.VIBERBM)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#WECHAT}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder weChat(WeChatCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.WECHAT)
        .setCredentials(credentials);
  }

  /**
   * Create dedicated conversation credential builder for<code>{@link ConversationChannel#WHATSAPP}
   * </code> channel
   *
   * @param credentials Credentials parameters to be used to init builder
   * @return Conversation channel credentials builder filled with input parameters
   * @since 1.3
   */
  public static ConversationChannelCredentials.Builder whatsApp(
      StaticBearerCredentials credentials) {
    return ConversationChannelCredentials.builder()
        .setChannel(ConversationChannel.WHATSAPP)
        .setCredentials(credentials);
  }
}
