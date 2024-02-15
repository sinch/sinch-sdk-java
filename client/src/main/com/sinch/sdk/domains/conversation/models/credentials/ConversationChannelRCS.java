package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelRCS extends ConversationChannel<StaticBearerCredentials> {

  private ConversationChannelRCS(
      StaticBearerCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.RCS, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder
      extends ConversationChannel.Builder<StaticBearerCredentials, Builder> {

    private Builder() {}

    public ConversationChannelRCS build() {
      return new ConversationChannelRCS(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
