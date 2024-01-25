package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelWeChat extends ConversationChannel {

  private ConversationChannelWeChat(
      WeChatCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.WECHAT, credentials, callbackSecret, state, channelKnownId);
  }

  @Override
  public WeChatCredentials getCredentials() {
    return (WeChatCredentials) super.getCredentials();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<Builder> {

    WeChatCredentials credentials;

    public Builder setCredentials(WeChatCredentials credentials) {
      this.credentials = credentials;
      return this;
    }

    public ConversationChannelWeChat build() {
      return new ConversationChannelWeChat(credentials, callbackSecret, state, channelKnownId);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
