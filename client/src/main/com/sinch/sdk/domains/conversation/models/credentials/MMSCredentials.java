package com.sinch.sdk.domains.conversation.models.credentials;

public class MMSCredentials implements Credentials {

  private final String accountId;
  private final String apiKey;
  private final String defaultSender;

  private final BasicAuthCredentials basicAuth;

  private MMSCredentials(
      String accountId, String apiKey, BasicAuthCredentials basicAuth, String defaultSender) {
    this.accountId = accountId;
    this.apiKey = apiKey;
    this.basicAuth = basicAuth;
    this.defaultSender = defaultSender;
  }

  public String getAccountId() {
    return accountId;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getDefaultSender() {
    return defaultSender;
  }

  public BasicAuthCredentials getBasicAuth() {
    return basicAuth;
  }

  @Override
  public String toString() {
    return "MMSCredentials{"
        + "accountId='"
        + accountId
        + '\''
        + ", apiKey='***'"
        + ", basicAuth='***'"
        + ", defaultSender='"
        + defaultSender
        + "'"
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String accountId;
    String apiKey;
    String defaultSender;
    BasicAuthCredentials basicAuth;

    public Builder setAccountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    public Builder setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    public Builder setDefaultSender(String defaultSender) {
      this.defaultSender = defaultSender;
      return this;
    }

    public Builder setBasicAuth(BasicAuthCredentials basicAuth) {
      this.basicAuth = basicAuth;
      return this;
    }

    public MMSCredentials build() {
      return new MMSCredentials(accountId, apiKey, basicAuth, defaultSender);
    }
  }
}
