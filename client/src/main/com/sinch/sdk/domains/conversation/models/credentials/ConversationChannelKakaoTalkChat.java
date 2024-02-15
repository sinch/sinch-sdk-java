package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelKakaoTalkChat
    extends ConversationChannel<KakaoTalkChatCredentials> {

  private ConversationChannelKakaoTalkChat(
      KakaoTalkChatCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.KAKAO_TALK_CHAT, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder
      extends ConversationChannel.Builder<KakaoTalkChatCredentials, Builder> {

    private Builder() {}

    public ConversationChannelKakaoTalkChat build() {
      return new ConversationChannelKakaoTalkChat(
          credentials, callbackSecret, state, channelKnownId);
    }
  }
}
