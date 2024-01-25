package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelMMS extends ConversationChannel {

  private ConversationChannelMMS(
      MMSCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.MMS, credentials, callbackSecret, state, channelKnownId);
  }

  @Override
  public MMSCredentials getCredentials() {
    return (MMSCredentials) super.getCredentials();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<Builder> {

    MMSCredentials credentials;

    public Builder setCredentials(MMSCredentials credentials) {
      this.credentials = credentials;
      return this;
    }

    public ConversationChannelMMS build() {
      return new ConversationChannelMMS(credentials, callbackSecret, state, channelKnownId);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
