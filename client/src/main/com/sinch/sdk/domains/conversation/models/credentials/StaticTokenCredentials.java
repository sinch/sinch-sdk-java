package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * Static Token's credentials information
 *
 * @since 1.0
 */
public class StaticTokenCredentials implements Credentials {

  private final String token;

  private StaticTokenCredentials(String token) {
    this.token = token;
  }

  /**
   * Token
   *
   * @return token value
   * @since 1.0
   */
  public String getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "StaticTokenCredentials{" + "token='***'" + '}';
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

    String token;

    private Builder() {}

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
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public StaticTokenCredentials build() {
      return new StaticTokenCredentials(token);
    }
  }
}
