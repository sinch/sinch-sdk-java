package com.sinch.sdk.domains.conversation.models.credentials;

public class LineCredentials implements Credentials {

  private final String secret;
  private final String token;

  private LineCredentials(String secret, String token) {
    this.secret = secret;
    this.token = token;
  }

  public String getSecret() {
    return secret;
  }

  public String getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "LineCredentials{" + "secret='***'" + ", token='***'" + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String secret;
    String token;

    public Builder setSecret(String secret) {
      this.secret = secret;
      return this;
    }

    public Builder setToken(String token) {
      this.token = token;
      return this;
    }

    public LineCredentials build() {
      return new LineCredentials(secret, token);
    }
  }
}
