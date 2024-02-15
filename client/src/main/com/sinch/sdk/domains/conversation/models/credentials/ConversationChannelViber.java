package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelViber extends ConversationChannel<StaticTokenCredentials> {

  private ConversationChannelViber(
      StaticTokenCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.VIBER, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<StaticTokenCredentials, Builder> {

    private Builder() {}

    public ConversationChannelViber build() {
      return new ConversationChannelViber(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
