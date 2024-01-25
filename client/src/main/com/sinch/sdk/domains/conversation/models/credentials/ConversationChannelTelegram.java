package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout.Builder;

public class ConversationChannelTelegram extends ConversationChannel {

  private ConversationChannelTelegram(
      TelegramCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.TELEGRAM, credentials, callbackSecret, state, channelKnownId);
  }

  @Override
  public TelegramCredentials getCredentials() {
    return (TelegramCredentials) super.getCredentials();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<Builder> {

    TelegramCredentials credentials;

    public Builder setCredentials(TelegramCredentials credentials) {
      this.credentials = credentials;
      return this;
    }

    public ConversationChannelTelegram build() {
      return new ConversationChannelTelegram(credentials, callbackSecret, state, channelKnownId);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
