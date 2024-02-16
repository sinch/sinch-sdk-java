package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * KakaoTalkChat channel description
 *
 * @since 1.0
 */
public class ConversationChannelKakaoTalkChat
    extends ConversationChannel<KakaoTalkChatCredentials> {

  private ConversationChannelKakaoTalkChat(
      KakaoTalkChatCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.KAKAO_TALK_CHAT, credentials, callbackSecret, state, channelKnownId);
  }

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Dedicated Builder
   *
   * @see <a
   *     href="https://developers.sinch.com/docs/conversation/channel-support/kakaotalk">Conversation
   *     API KakaoTalk</a>
   * @since 1.0
   */
  public static class Builder
      extends ConversationChannel.Builder<KakaoTalkChatCredentials, Builder> {

    private Builder() {}

    /** {@inheritDoc} */
    public ConversationChannelKakaoTalkChat build() {
      return new ConversationChannelKakaoTalkChat(
          credentials, callbackSecret, state, channelKnownId);
    }
  }
}
