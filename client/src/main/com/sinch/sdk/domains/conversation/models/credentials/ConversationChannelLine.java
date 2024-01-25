package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelLine extends ConversationChannel {

  private ConversationChannelLine(
      LineCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.LINE, credentials, callbackSecret, state, channelKnownId);
  }

  @Override
  public LineCredentials getCredentials() {
    return (LineCredentials) super.getCredentials();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<Builder> {

    LineCredentials credentials;

    public Builder setCredentials(LineCredentials credentials) {
      this.credentials = credentials;
      return this;
    }

    public ConversationChannelLine build() {
      return new ConversationChannelLine(credentials, callbackSecret, state, channelKnownId);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
