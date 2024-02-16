package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * MMS Channel description
 *
 * @see <a href="https://developers.sinch.com/docs/conversation/channel-support/mms">MMS Channel</a>
 * @since 1.0
 */
public class ConversationChannelMMS extends ConversationChannel<MMSCredentials> {

  private ConversationChannelMMS(
      MMSCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.MMS, credentials, callbackSecret, state, channelKnownId);
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
  public static class Builder extends ConversationChannel.Builder<MMSCredentials, Builder> {

    private Builder() {}

    /** {@inheritDoc} */
    public ConversationChannelMMS build() {
      return new ConversationChannelMMS(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
