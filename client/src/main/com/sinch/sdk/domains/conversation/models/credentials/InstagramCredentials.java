package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * Instagram's credentials information
 *
 * @since 1.0
 */
public class InstagramCredentials implements Credentials {

  private final String businessAccountId;
  private final String token;

  private InstagramCredentials(String businessAccountId, String token) {
    this.businessAccountId = businessAccountId;
    this.token = token;
  }

  /**
   * Business account ID
   *
   * @return account id
   * @since 1.0
   */
  public String getBusinessAccountId() {
    return businessAccountId;
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
    return "InstagramCredentials{"
        + "businessAccountId='"
        + businessAccountId
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

    String businessAccountId;
    String token;

    private Builder() {}

    /**
     * see getter
     *
     * @param businessAccountId see getter
     * @return Current builder
     * @see #getBusinessAccountId()
     * @since 1.0
     */
    public Builder setBusinessAccountId(String businessAccountId) {
      this.businessAccountId = businessAccountId;
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
    public InstagramCredentials build() {
      return new InstagramCredentials(businessAccountId, token);
    }
  }
}
