package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * RCS Channel description
 *
 * @see <a href="https://developers.sinch.com/docs/conversation/channel-support/rcs">RCS Channel</a>
 * @since 1.0
 */
public class ConversationChannelRCS extends ConversationChannel<StaticBearerCredentials> {

  private ConversationChannelRCS(
      StaticBearerCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.RCS, credentials, callbackSecret, state, channelKnownId);
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
  public static class Builder
      extends ConversationChannel.Builder<StaticBearerCredentials, Builder> {

    private Builder() {}

    /** {@inheritDoc} */
    public ConversationChannelRCS build() {
      return new ConversationChannelRCS(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
