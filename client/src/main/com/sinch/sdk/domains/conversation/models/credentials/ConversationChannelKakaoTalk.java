package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelKakaoTalk extends ConversationChannel<KakaoTalkCredentials> {

  private ConversationChannelKakaoTalk(
      KakaoTalkCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.KAKAO_TALK, credentials, callbackSecret, state, channelKnownId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<KakaoTalkCredentials, Builder> {

    private Builder() {}

    public ConversationChannelKakaoTalk build() {
      return new ConversationChannelKakaoTalk(credentials, callbackSecret, state, channelKnownId);
    }
  }
}
