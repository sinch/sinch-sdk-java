package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelRCS extends ConversationChannel {

  private ConversationChannelRCS(
      StaticBearerCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.RCS, credentials, callbackSecret, state, channelKnownId);
  }

  @Override
  public StaticBearerCredentials getCredentials() {
    return (StaticBearerCredentials) super.getCredentials();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<Builder> {

    StaticBearerCredentials credentials;

    public Builder setCredentials(StaticBearerCredentials credentials) {
      this.credentials = credentials;
      return this;
    }

    public ConversationChannelRCS build() {
      return new ConversationChannelRCS(credentials, callbackSecret, state, channelKnownId);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
