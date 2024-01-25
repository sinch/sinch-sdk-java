package com.sinch.sdk.domains.conversation.models.credentials;

public class InstagramCredentials implements Credentials {

  private final String businessAccountId;
  private final String token;

  private InstagramCredentials(String businessAccountId, String token) {
    this.businessAccountId = businessAccountId;
    this.token = token;
  }

  public String getBusinessAccountId() {
    return businessAccountId;
  }

  public String getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "InstagramCredentials{"
        + "businessAccountId='"
        + businessAccountId
        + '\''
        + ", token='***'"
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String businessAccountId;
    String token;

    public Builder setBusinessAccountId(String businessAccountId) {
      this.businessAccountId = businessAccountId;
      return this;
    }

    public Builder setToken(String token) {
      this.token = token;
      return this;
    }

    public InstagramCredentials build() {
      return new InstagramCredentials(businessAccountId, token);
    }
  }
}
