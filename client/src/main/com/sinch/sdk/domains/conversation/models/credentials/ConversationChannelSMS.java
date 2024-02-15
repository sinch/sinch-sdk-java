package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelSMS extends ConversationChannel<StaticBearerCredentials> {

  private ConversationChannelSMS(
      StaticBearerCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.SMS, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder
      extends ConversationChannel.Builder<StaticBearerCredentials, Builder> {

    private Builder() {}

    public ConversationChannelSMS build() {
      return new ConversationChannelSMS(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
