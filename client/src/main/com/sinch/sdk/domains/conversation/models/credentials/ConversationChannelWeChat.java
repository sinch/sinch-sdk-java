package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelWeChat extends ConversationChannel<WeChatCredentials> {

  private ConversationChannelWeChat(
      WeChatCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.WECHAT, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<WeChatCredentials, Builder> {

    private Builder() {}

    public ConversationChannelWeChat build() {
      return new ConversationChannelWeChat(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
