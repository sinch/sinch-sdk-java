package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * Facebook Messenger channel description
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/channel-support/facebook-messenger">Facebook
 *     Messenger Channel</a>
 * @since 1.0
 */
public class ConversationChannelMessenger extends ConversationChannel<StaticTokenCredentials> {

  private ConversationChannelMessenger(
      StaticTokenCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.MESSENGER, credentials, callbackSecret, state, channelKnownId);
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
  public static class Builder extends ConversationChannel.Builder<StaticTokenCredentials, Builder> {

    private Builder() {}

    /** {@inheritDoc} */
    public ConversationChannelMessenger build() {
      return new ConversationChannelMessenger(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
