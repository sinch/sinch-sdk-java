package com.sinch.sdk.domains.conversation.models.credentials;

public class TelegramCredentials implements Credentials {

  private final String token;

  private TelegramCredentials(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "TelegramCredentials{" + "token='***'" + '}';
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

    public TelegramCredentials build() {
      return new TelegramCredentials(token);
    }
  }
}
