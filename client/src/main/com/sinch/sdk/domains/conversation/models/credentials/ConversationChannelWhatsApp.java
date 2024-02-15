package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelWhatsApp extends ConversationChannel<StaticBearerCredentials> {

  private ConversationChannelWhatsApp(
      StaticBearerCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.WHATSAPP, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder
      extends ConversationChannel.Builder<StaticBearerCredentials, Builder> {

    private Builder() {}

    public ConversationChannelWhatsApp build() {
      return new ConversationChannelWhatsApp(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
