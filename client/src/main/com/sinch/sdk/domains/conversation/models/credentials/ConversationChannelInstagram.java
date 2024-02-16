package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * Instagram channel description
 *
 * @see <a href="https://developers.sinch.com/docs/conversation/channel-support/instagram">Instagram
 *     Channel</a>
 * @since 1.0
 */
public class ConversationChannelInstagram extends ConversationChannel<InstagramCredentials> {

  private ConversationChannelInstagram(
      InstagramCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.INSTAGRAM, credentials, callbackSecret, state, channelKnownId);
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
  public static class Builder extends ConversationChannel.Builder<InstagramCredentials, Builder> {

    private Builder() {}

    /** {@inheritDoc} */
    public ConversationChannelInstagram build() {
      return new ConversationChannelInstagram(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
