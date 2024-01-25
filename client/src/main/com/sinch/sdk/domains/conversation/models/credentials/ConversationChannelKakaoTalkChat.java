package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelKakaoTalkChat extends ConversationChannel {

  private ConversationChannelKakaoTalkChat(
      KakaoTalkChatCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.KAKAO_TALK_CHAT, credentials, callbackSecret, state, channelKnownId);
  }

  @Override
  public KakaoTalkChatCredentials getCredentials() {
    return (KakaoTalkChatCredentials) super.getCredentials();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<Builder> {

    KakaoTalkChatCredentials credentials;

    public Builder setCredentials(KakaoTalkChatCredentials credentials) {
      this.credentials = credentials;
      return this;
    }

    public ConversationChannelKakaoTalkChat build() {
      return new ConversationChannelKakaoTalkChat(
          credentials, callbackSecret, state, channelKnownId);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
