package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * Basic credentials based onto username/password
 *
 * @since 1.0
 */
public class BasicAuthCredentials {

  private final String username;
  private final String password;

  private BasicAuthCredentials(String username, String password) {
    this.password = password;
    this.username = username;
  }

  /**
   * Basic auth password
   *
   * @return password
   * @since 1.0
   */
  public String getPassword() {
    return password;
  }

  /**
   * Basic auth username
   *
   * @return username
   * @since 1.0
   */
  public String getUsername() {
    return username;
  }

  @Override
  public String toString() {
    return "BasicAuthCredentials{" + "username='" + username + '\'' + ", password='***'" + '}';
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

    String username;
    String password;

    /**
     * see getter
     *
     * @param password see getter
     * @return Current builder
     * @see #getPassword()
     * @since 1.0
     */
    public Builder setPassword(String password) {
      this.password = password;
      return this;
    }

    /**
     * see getter
     *
     * @param username see getter
     * @return Current builder
     * @see #getUsername()
     * @since 1.0
     */
    public Builder setUsername(String username) {
      this.username = username;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public BasicAuthCredentials build() {
      return new BasicAuthCredentials(username, password);
    }
  }
}
