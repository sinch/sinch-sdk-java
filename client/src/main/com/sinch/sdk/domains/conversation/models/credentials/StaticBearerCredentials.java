package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * Static Bearer's credentials information
 *
 * @since 1.0
 */
public class StaticBearerCredentials implements Credentials {

  private final String claimedIdentity;
  private final String token;

  protected StaticBearerCredentials(String claimedIdentity, String token) {
    this.claimedIdentity = claimedIdentity;
    this.token = token;
  }

  /**
   * Claimed identity
   *
   * @return identity value
   * @since 1.0
   */
  public String getClaimedIdentity() {
    return claimedIdentity;
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
    return "StaticBearerCredentials{"
        + "claimedIdentity='"
        + claimedIdentity
        + '\''
        + ", token='***'"
        + '}';
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

    String claimedIdentity;
    String token;

    private Builder() {}

    /**
     * see getter
     *
     * @param claimedIdentity see getter
     * @return Current builder
     * @see #getClaimedIdentity()
     * @since 1.0
     */
    public Builder setClaimedIdentity(String claimedIdentity) {
      this.claimedIdentity = claimedIdentity;
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
    public StaticBearerCredentials build() {
      return new StaticBearerCredentials(claimedIdentity, token);
    }
  }
}
