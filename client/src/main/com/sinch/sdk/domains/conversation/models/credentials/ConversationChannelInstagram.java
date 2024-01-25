package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelInstagram extends ConversationChannel {

  private ConversationChannelInstagram(
      InstagramCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.INSTAGRAM, credentials, callbackSecret, state, channelKnownId);
  }

  @Override
  public InstagramCredentials getCredentials() {
    return (InstagramCredentials) super.getCredentials();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<Builder> {

    InstagramCredentials credentials;

    public Builder setCredentials(InstagramCredentials credentials) {
      this.credentials = credentials;
      return this;
    }

    public ConversationChannelInstagram build() {
      return new ConversationChannelInstagram(credentials, callbackSecret, state, channelKnownId);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
