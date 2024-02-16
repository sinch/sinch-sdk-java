package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * Viber Business Messages channel description
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/channel-support/viber-business">Viber
 *     Business Messages</a>
 * @since 1.0
 */
public class ConversationChannelViberBM extends ConversationChannel<StaticBearerCredentials> {

  private ConversationChannelViberBM(
      StaticBearerCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.VIBERBM, credentials, callbackSecret, state, channelKnownId);
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
    public ConversationChannelViberBM build() {
      return new ConversationChannelViberBM(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
