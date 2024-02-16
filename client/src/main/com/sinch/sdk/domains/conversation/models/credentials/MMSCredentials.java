package com.sinch.sdk.domains.conversation.models.credentials;

/**
 * MMS's credentials information
 *
 * @since 1.0
 */
public class MMSCredentials implements Credentials {

  private final String accountId;
  private final String apiKey;
  private final String defaultSender;

  private final BasicAuthCredentials basicAuth;

  private MMSCredentials(
      String accountId, String apiKey, BasicAuthCredentials basicAuth, String defaultSender) {
    this.accountId = accountId;
    this.apiKey = apiKey;
    this.basicAuth = basicAuth;
    this.defaultSender = defaultSender;
  }

  /**
   * account ID
   *
   * @return account id
   * @since 1.0
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * API key
   *
   * @return API key
   * @since 1.0
   */
  public String getApiKey() {
    return apiKey;
  }

  /**
   * Default sender
   *
   * @return Default sender
   * @since 1.0
   */
  public String getDefaultSender() {
    return defaultSender;
  }

  /**
   * Basic auth
   *
   * @return Basic auth
   * @since 1.0
   */
  public BasicAuthCredentials getBasicAuth() {
    return basicAuth;
  }

  @Override
  public String toString() {
    return "MMSCredentials{"
        + "accountId='"
        + accountId
        + '\''
        + ", apiKey='***'"
        + ", basicAuth='***'"
        + ", defaultSender='"
        + defaultSender
        + "'"
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

    String accountId;
    String apiKey;
    String defaultSender;
    BasicAuthCredentials basicAuth;

    private Builder() {}

    /**
     * see getter
     *
     * @param accountId see getter
     * @return Current builder
     * @see #getAccountId()
     * @since 1.0
     */
    public Builder setAccountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * see getter
     *
     * @param apiKey see getter
     * @return Current builder
     * @see #getApiKey()
     * @since 1.0
     */
    public Builder setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    /**
     * see getter
     *
     * @param defaultSender see getter
     * @return Current builder
     * @see #getDefaultSender()
     * @since 1.0
     */
    public Builder setDefaultSender(String defaultSender) {
      this.defaultSender = defaultSender;
      return this;
    }

    /**
     * see getter
     *
     * @param basicAuth see getter
     * @return Current builder
     * @see #getBasicAuth()
     * @since 1.0
     */
    public Builder setBasicAuth(BasicAuthCredentials basicAuth) {
      this.basicAuth = basicAuth;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public MMSCredentials build() {
      return new MMSCredentials(accountId, apiKey, basicAuth, defaultSender);
    }
  }
}
