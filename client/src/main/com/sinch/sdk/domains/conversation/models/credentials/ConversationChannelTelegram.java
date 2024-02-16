package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout.Builder;

/**
 * Telegram channel description
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/conversation/channel-support/instagram">Conversation
 *     API Telegram Bot Support</a>
 * @since 1.0
 */
public class ConversationChannelTelegram extends ConversationChannel<TelegramCredentials> {

  private ConversationChannelTelegram(
      TelegramCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.TELEGRAM, credentials, callbackSecret, state, channelKnownId);
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
  public static class Builder extends ConversationChannel.Builder<TelegramCredentials, Builder> {

    private Builder() {}

    /** {@inheritDoc} */
    public ConversationChannelTelegram build() {
      return new ConversationChannelTelegram(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
