package com.sinch.sdk.domains.conversation.models.credentials;

public class BasicAuthCredentials {

  private final String username;
  private final String password;

  private BasicAuthCredentials(String username, String password) {
    this.password = password;
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public String toString() {
    return "BasicAuthCredentials{" + "username='" + username + '\'' + ", password='***'" + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String username;
    String password;

    public Builder setPassword(String password) {
      this.password = password;
      return this;
    }

    public Builder setUsername(String username) {
      this.username = username;
      return this;
    }

    public BasicAuthCredentials build() {
      return new BasicAuthCredentials(username, password);
    }
  }
}
