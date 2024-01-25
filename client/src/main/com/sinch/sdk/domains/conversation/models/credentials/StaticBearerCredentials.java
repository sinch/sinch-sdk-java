package com.sinch.sdk.domains.conversation.models.credentials;

public class StaticBearerCredentials implements Credentials {

  private final String claimedIdentity;
  private final String token;

  protected StaticBearerCredentials(String claimedIdentity, String token) {
    this.claimedIdentity = claimedIdentity;
    this.token = token;
  }

  public String getClaimedIdentity() {
    return claimedIdentity;
  }

  public String getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "StaticBearerCredentials{"
        + "claimedIdentity='"
        + claimedIdentity
        + '\''
        + ", token='***'"
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String claimedIdentity;
    String token;

    public Builder setClaimedIdentity(String claimedIdentity) {
      this.claimedIdentity = claimedIdentity;
      return this;
    }

    public Builder setToken(String token) {
      this.token = token;
      return this;
    }

    public StaticBearerCredentials build() {
      return new StaticBearerCredentials(claimedIdentity, token);
    }
  }
}
