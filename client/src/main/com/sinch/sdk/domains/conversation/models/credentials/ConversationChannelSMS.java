package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * SMS Channel description
 *
 * @see <a href="https://developers.sinch.com/docs/conversation/channel-support/sms">Instagram
 *     Channel</a>
 * @since 1.0
 */
public class ConversationChannelSMS extends ConversationChannel<StaticBearerCredentials> {

  private ConversationChannelSMS(
      StaticBearerCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.SMS, credentials, callbackSecret, state, channelKnownId);
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
    public ConversationChannelSMS build() {
      return new ConversationChannelSMS(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
