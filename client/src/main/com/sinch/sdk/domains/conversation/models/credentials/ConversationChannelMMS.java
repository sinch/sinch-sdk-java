package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelMMS extends ConversationChannel<MMSCredentials> {

  private ConversationChannelMMS(
      MMSCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.MMS, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<MMSCredentials, Builder> {

    private Builder() {}

    public ConversationChannelMMS build() {
      return new ConversationChannelMMS(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
