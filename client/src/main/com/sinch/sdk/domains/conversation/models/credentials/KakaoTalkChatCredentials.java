package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * KakaoTalkChat's credentials information
 *
 * @since 1.0
 */
public class KakaoTalkChatCredentials implements Credentials {

  private final String kakaotalkPlusFriendId;
  private final String apiKey;

  private KakaoTalkChatCredentials(String kakaotalkPlusFriendId, String apiKey) {
    this.kakaotalkPlusFriendId = kakaotalkPlusFriendId;
    this.apiKey = apiKey;
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
   * API key
   *
   * @return API key
   * @since 1.0
   */
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
    String apiKey;

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
     * @param apiKey see getter
     * @return Current builder
     * @see #getApiKey()
     * @since 1.0
     */
    public Builder setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public KakaoTalkChatCredentials build() {
      return new KakaoTalkChatCredentials(kakaotalkPlusFriendId, apiKey);
    }
  }
}
