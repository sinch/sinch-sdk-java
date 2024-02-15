package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelLine extends ConversationChannel<LineCredentials> {

  private ConversationChannelLine(
      LineCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.LINE, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<LineCredentials, Builder> {

    private Builder() {}

    public ConversationChannelLine build() {
      return new ConversationChannelLine(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
