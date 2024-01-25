package com.sinch.sdk.domains.conversation.models.credentials;

import com.sinch.sdk.domains.conversation.models.ChannelType;

public class ConversationChannelKakaoTalk extends ConversationChannel {

  private ConversationChannelKakaoTalk(
      KakaoTalkCredentials credentials,
      String callbackSecret,
      CredentialState state,
      String channelKnownId) {
    super(ChannelType.KAKAO_TALK, credentials, callbackSecret, state, channelKnownId);
  }

  @Override
  public KakaoTalkCredentials getCredentials() {
    return (KakaoTalkCredentials) super.getCredentials();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ConversationChannel.Builder<Builder> {

    KakaoTalkCredentials credentials;

    public Builder setCredentials(KakaoTalkCredentials credentials) {
      this.credentials = credentials;
      return this;
    }

    public ConversationChannelKakaoTalk build() {
      return new ConversationChannelKakaoTalk(credentials, callbackSecret, state, channelKnownId);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
