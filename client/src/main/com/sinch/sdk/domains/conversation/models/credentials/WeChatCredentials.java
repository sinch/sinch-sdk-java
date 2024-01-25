package com.sinch.sdk.domains.conversation.models.credentials;

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

  public String getAppId() {
    return appId;
  }

  public String getAppSecret() {
    return appSecret;
  }

  public String getToken() {
    return token;
  }

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

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String appId;
    String appSecret;
    String token;
    String aesKey;

    public Builder setAppId(String appId) {
      this.appId = appId;
      return this;
    }

    public Builder setAppSecret(String appSecret) {
      this.appSecret = appSecret;
      return this;
    }

    public Builder setToken(String token) {
      this.token = token;
      return this;
    }

    public Builder setAesKey(String aesKey) {
      this.aesKey = aesKey;
      return this;
    }

    public WeChatCredentials build() {
      return new WeChatCredentials(appId, appSecret, token, aesKey);
    }
  }
}
