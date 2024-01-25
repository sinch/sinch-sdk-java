package com.sinch.sdk.domains.conversation.models.credentials;

public class KakaoTalkChatCredentials implements Credentials {

  private final String kakaotalkPlusFriendId;
  private final String apiKey;

  private KakaoTalkChatCredentials(String kakaotalkPlusFriendId, String apiKey) {
    this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
    this.apiKey = apiKey;
  }

  public String getKakaotalkPlusFriendId() {
    return kakaotalkPlusFriendId;
  }

  public String getApiKey() {
    return apiKey;
  }

  @Override
  public String toString() {
    return "KakaoTalkChatCredentials{"
        + "kakaotalkPlusFriendId='"
        + kakaotalkPlusFriendId
        + '\''
        + ", apiKey='"
        + apiKey
        + '\''
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String kakaotalkPlusFriendId;
    String apiKey;

    public Builder setKakaotalkPlusFriendId(String kakaotalkPlusFriendId) {
      this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
      return this;
    }

    public Builder setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    public KakaoTalkChatCredentials build() {
      return new KakaoTalkChatCredentials(kakaotalkPlusFriendId, apiKey);
    }
  }
}
