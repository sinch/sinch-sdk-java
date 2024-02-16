package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * Viber Bot channel description
 *
 * @see <a href="https://developers.sinch.com/docs/conversation/channel-support/viber-bot">Viber
 *     Bot</a>
 * @since 1.0
 */
public class ConversationChannelViber extends ConversationChannel<StaticTokenCredentials> {

  private ConversationChannelViber(
      StaticTokenCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.VIBER, credentials, callbackSecret, state, channelKnownId);
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
    public ConversationChannelViber build() {
      return new ConversationChannelViber(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
