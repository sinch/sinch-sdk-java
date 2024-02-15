package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * WeChat Channel description
 *
 * @see <a href="https://developers.sinch.com/docs/conversation/channel-support/wechat">WeChat
 *     Channel</a>
 * @since 1.0
 */
public class ConversationChannelWeChat extends ConversationChannel<WeChatCredentials> {

  private ConversationChannelWeChat(
      WeChatCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.WECHAT, credentials, callbackSecret, state, channelKnownId);
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
  public static class Builder extends ConversationChannel.Builder<WeChatCredentials, Builder> {

    private Builder() {}

    /** {@inheritDoc} */
    public ConversationChannelWeChat build() {
      return new ConversationChannelWeChat(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
