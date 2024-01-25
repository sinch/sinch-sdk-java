package com.sinch.sdk.domains.conversation.models.credentials;

public class StaticTokenCredentials implements Credentials {

  private final String token;

  private StaticTokenCredentials(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "StaticTokenCredentials{" + "token='***'" + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String token;

    public Builder setToken(String token) {
      this.token = token;
      return this;
    }

    public StaticTokenCredentials build() {
      return new StaticTokenCredentials(token);
    }
  }
}
