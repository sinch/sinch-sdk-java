package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelMessenger extends ConversationChannel<StaticTokenCredentials> {

  private ConversationChannelMessenger(
      StaticTokenCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.MESSENGER, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<StaticTokenCredentials, Builder> {

    private Builder() {}

    public ConversationChannelMessenger build() {
      return new ConversationChannelMessenger(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
