package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelViberBM extends ConversationChannel<StaticBearerCredentials> {

  private ConversationChannelViberBM(
      StaticBearerCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.VIBERBM, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder
      extends ConversationChannel.Builder<StaticBearerCredentials, Builder> {

    private Builder() {}

    public ConversationChannelViberBM build() {
      return new ConversationChannelViberBM(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
