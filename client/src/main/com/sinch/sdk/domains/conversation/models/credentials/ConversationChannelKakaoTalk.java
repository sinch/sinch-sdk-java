package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * KakaoTalk channel description
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/channel-support/kakaotalk">Conversation
 *     API KakaoTalk</a>
 * @since 1.0
 */
public class ConversationChannelKakaoTalk extends ConversationChannel<KakaoTalkCredentials> {

  private ConversationChannelKakaoTalk(
      KakaoTalkCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.KAKAO_TALK, credentials, callbackSecret, state, channelKnownId);
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
   * @since 1.0
   */
  public static class Builder extends ConversationChannel.Builder<KakaoTalkCredentials, Builder> {

    private Builder() {}

    /** {@inheritDoc} */
    public ConversationChannelKakaoTalk build() {
      return new ConversationChannelKakaoTalk(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
