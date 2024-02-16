package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * WeChat's credentials information
 *
 * @since 1.0
 */
public class WeChatCredentials implements Credentials {

  private final String appId;
  private final String appSecret;
  private final String token;
  private final String aesKey;

  private WeChatCredentials(String appId, String appSecret, String token, String aesKey) {
    this.appId = appId;
    this.appSecret = appSecret;
    this.token = token;
    this.aesKey = aesKey;
  }

  /**
   * We chat app ID
   *
   * @return app id
   * @since 1.0
   */
  public String getAppId() {
    return appId;
  }

  /**
   * app secret ID
   *
   * @return app secret
   * @since 1.0
   */
  public String getAppSecret() {
    return appSecret;
  }

  /**
   * token
   *
   * @return token
   * @since 1.0
   */
  public String getToken() {
    return token;
  }

  /**
   * AES key
   *
   * @return AES key
   * @since 1.0
   */
  public String getAesKey() {
    return aesKey;
  }

  @Override
  public String toString() {
    return "WeChatCredentials{"
        + "appId='"
        + appId
        + '\''
        + ", appSecret='***'"
        + ", token='***'"
        + ", aesKey='***'"
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

    String appId;
    String appSecret;
    String token;
    String aesKey;

    private Builder() {}

    /**
     * see getter
     *
     * @param appId see getter
     * @return Current builder
     * @see #getAppId()
     * @since 1.0
     */
    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    /**
     * see getter
     *
     * @param appSecret see getter
     * @return Current builder
     * @see #getAppSecret()
     * @since 1.0
     */
    public Builder setAppSecret(String appSecret) {
      this.appSecret = appSecret;
      return this;
    }

    /**
     * see getter
     *
     * @param token see getter
     * @return Current builder
     * @see #getToken()
     * @since 1.0
     */
    public Builder setToken(String token) {
      this.token = token;
      return this;
    }

    /**
     * see getter
     *
     * @param aesKey see getter
     * @return Current builder
     * @see #getAesKey()
     * @since 1.0
     */
    public Builder setAesKey(String aesKey) {
      this.aesKey = aesKey;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public WeChatCredentials build() {
      return new WeChatCredentials(appId, appSecret, token, aesKey);
    }
  }
}
