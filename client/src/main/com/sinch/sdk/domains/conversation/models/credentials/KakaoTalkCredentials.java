package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * KakaoTalk's credentials information
 *
 * @since 1.0
 */
public class KakaoTalkCredentials implements Credentials {

  private final String kakaotalkPlusFriendId;
  private final String kakaotalkSenderKey;

  private KakaoTalkCredentials(String kakaotalkPlusFriendId, String kakaotalkSenderKey) {
    this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
    this.kakaotalkSenderKey = kakaotalkSenderKey;
  }

  /**
   * Friend ID
   *
   * @return account id
   * @since 1.0
   */
  public String getKakaotalkPlusFriendId() {
    return kakaotalkPlusFriendId;
  }

  /**
   * Sender key
   *
   * @return sender key
   * @since 1.0
   */
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

  /**
   * Getting builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    String kakaotalkPlusFriendId;
    String kakaotalkSenderKey;

    private Builder() {}

    /**
     * see getter
     *
     * @param kakaotalkPlusFriendId see getter
     * @return Current builder
     * @see #getKakaotalkPlusFriendId()
     * @since 1.0
     */
    public Builder setKakaotalkPlusFriendId(String kakaotalkPlusFriendId) {
      this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
      return this;
    }

    /**
     * see getter
     *
     * @param kakaotalkSenderKey see getter
     * @return Current builder
     * @see #getKakaotalkSenderKey()
     * @since 1.0
     */
    public Builder setKakaotalkSenderKey(String kakaotalkSenderKey) {
      this.kakaotalkSenderKey = kakaotalkSenderKey;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public KakaoTalkCredentials build() {
      return new KakaoTalkCredentials(kakaotalkPlusFriendId, kakaotalkSenderKey);
    }
  }
}
