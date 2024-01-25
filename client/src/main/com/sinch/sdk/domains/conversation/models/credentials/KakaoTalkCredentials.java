package com.sinch.sdk.domains.conversation.models.credentials;

public class KakaoTalkCredentials implements Credentials {

  private final String kakaotalkPlusFriendId;
  private final String kakaotalkSenderKey;

  private KakaoTalkCredentials(String kakaotalkPlusFriendId, String kakaotalkSenderKey) {
    this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
    this.kakaotalkSenderKey = kakaotalkSenderKey;
  }

  public String getKakaotalkPlusFriendId() {
    return kakaotalkPlusFriendId;
  }

  public String getKakaotalkSenderKey() {
    return kakaotalkSenderKey;
  }

  @Override
  public String toString() {
    return "KakaoTalkCredentials{"
        + "kakaotalkPlusFriendId='"
        + kakaotalkPlusFriendId
        + '\''
        + ", kakaotalkSenderKey='***'"
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String kakaotalkPlusFriendId;
    String kakaotalkSenderKey;

    public Builder setKakaotalkPlusFriendId(String kakaotalkPlusFriendId) {
      this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
      return this;
    }

    public Builder setKakaotalkSenderKey(String kakaotalkSenderKey) {
      this.kakaotalkSenderKey = kakaotalkSenderKey;
      return this;
    }

    public KakaoTalkCredentials build() {
      return new KakaoTalkCredentials(kakaotalkPlusFriendId, kakaotalkSenderKey);
    }
  }
}
