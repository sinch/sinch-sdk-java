package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout.Builder;

public class ConversationChannelTelegram extends ConversationChannel<TelegramCredentials> {

  private ConversationChannelTelegram(
      TelegramCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.TELEGRAM, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<TelegramCredentials, Builder> {

    private Builder() {}

    public ConversationChannelTelegram build() {
      return new ConversationChannelTelegram(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
