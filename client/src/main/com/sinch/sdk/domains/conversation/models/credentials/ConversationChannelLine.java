package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

/**
 * Line channel description
 *
 * @see <a href="https://developers.sinch.com/docs/conversation/channel-support/line">Conversation
 *     API LINE</a>
 * @since 1.0
 */
public class ConversationChannelLine extends ConversationChannel<LineCredentials> {

  private ConversationChannelLine(
      LineCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.LINE, credentials, callbackSecret, state, channelKnownId);
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
  public static class Builder extends ConversationChannel.Builder<LineCredentials, Builder> {

    private Builder() {}

    /** {@inheritDoc} */
    public ConversationChannelLine build() {
      return new ConversationChannelLine(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
