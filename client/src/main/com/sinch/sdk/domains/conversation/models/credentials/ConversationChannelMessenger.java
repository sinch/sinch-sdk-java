package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelMessenger extends ConversationChannel {

  private ConversationChannelMessenger(
      StaticTokenCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.MESSENGER, credentials, callbackSecret, state, channelKnownId);
  }

  @Override
  public StaticTokenCredentials getCredentials() {
    return (StaticTokenCredentials) super.getCredentials();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<Builder> {

    StaticTokenCredentials credentials;

    public Builder setCredentials(StaticTokenCredentials credentials) {
      this.credentials = credentials;
      return this;
    }

    public ConversationChannelMessenger build() {
      return new ConversationChannelMessenger(credentials, callbackSecret, state, channelKnownId);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
