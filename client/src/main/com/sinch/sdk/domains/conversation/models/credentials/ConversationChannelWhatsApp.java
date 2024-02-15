package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * WhatsApp Channel description
 *
 * @see <a href="https://developers.sinch.com/docs/conversation/channel-support/whatsapp">WhatsApp
 *     Channel</a>
 * @since 1.0
 */
public class ConversationChannelWhatsApp extends ConversationChannel<StaticBearerCredentials> {

  private ConversationChannelWhatsApp(
      StaticBearerCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.WHATSAPP, credentials, callbackSecret, state, channelKnownId);
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
    public ConversationChannelWhatsApp build() {
      return new ConversationChannelWhatsApp(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
