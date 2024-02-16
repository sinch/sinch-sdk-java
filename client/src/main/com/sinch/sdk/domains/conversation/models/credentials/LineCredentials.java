package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * Line's credentials information
 *
 * @since 1.0
 */
public class LineCredentials implements Credentials {

  private final String secret;
  private final String token;

  private LineCredentials(String secret, String token) {
    this.secret = secret;
    this.token = token;
  }

  /**
   * Secret
   *
   * @return secret value
   * @since 1.0
   */
  public String getSecret() {
    return secret;
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
    return "LineCredentials{" + "secret='***'" + ", token='***'" + '}';
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

    String secret;
    String token;

    private Builder() {}

    /**
     * see getter
     *
     * @param secret see getter
     * @return Current builder
     * @see #getSecret()
     * @since 1.0
     */
    public Builder setSecret(String secret) {
      this.secret = secret;
      return this;
    }

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
    public LineCredentials build() {
      return new LineCredentials(secret, token);
    }
  }
}
