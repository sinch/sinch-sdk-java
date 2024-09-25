package com.sinch.sdk.domains.conversation.models.v1.credentials;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import org.junit.jupiter.api.Test;

class ConversationChannelCredentialsBuilderFactoryTest {

  @Test
  void appleBc() {
    AppleBusinessChatCredentials credentials = AppleBusinessChatCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.appleBc(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.APPLEBC);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void instagram() {
    InstagramCredentials credentials = InstagramCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.instagram(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.INSTAGRAM);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void kakaoTalk() {
    KakaoTalkCredentials credentials = KakaoTalkCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.kakaoTalk(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.KAKAOTALK);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void kakaoTalkChat() {
    KakaoTalkChatCredentials credentials = KakaoTalkChatCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.kakaoTalkChat(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.KAKAOTALKCHAT);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void line() {
    LineCredentials credentials = LineCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.line(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.LINE);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void messenger() {
    StaticTokenCredentials credentials = StaticTokenCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.messenger(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.MESSENGER);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void mms() {
    MMSCredentials credentials = MMSCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.mms(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.MMS);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void rcs() {
    StaticBearerCredentials credentials = StaticBearerCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.rcs(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.RCS);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void sms() {
    StaticBearerCredentials credentials = StaticBearerCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.sms(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.SMS);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void telegram() {
    TelegramCredentials credentials = TelegramCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.telegram(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.TELEGRAM);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void viber() {
    StaticTokenCredentials credentials = StaticTokenCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.viber(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.VIBER);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void viberBm() {
    StaticBearerCredentials credentials = StaticBearerCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.viberBm(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.VIBERBM);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void weChat() {
    WeChatCredentials credentials = WeChatCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.weChat(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.WECHAT);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }

  @Test
  void whatsApp() {
    StaticBearerCredentials credentials = StaticBearerCredentials.builder().build();
    ConversationChannelCredentials conversationChannelCredentials =
        ConversationChannelCredentialsBuilderFactory.whatsApp(credentials).build();

    assertEquals(conversationChannelCredentials.getChannel(), ConversationChannel.WHATSAPP);
    TestHelpers.recursiveEquals(conversationChannelCredentials.getCredentials(), credentials);
  }
}
