package com.sinch.sdk.models;

/**
 * Credentials related to Mailgun authentication
 *
 * @since __TO_BE_DEFINED__
 */
public class MailgunCredentials {

  private final String apiUser;
  private final String apiKey;

  private MailgunCredentials(String apiKey) {
    apiUser = "api";
    this.apiKey = apiKey;
  }

  /**
   * @since __TO_BE_DEFINED__
   */
  public String getApiUser() {
    return apiUser;
  }

  /**
   * @since __TO_BE_DEFINED__
   */
  public String getApiKey() {
    return apiKey;
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since __TO_BE_DEFINED__
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder
   *
   * @param credentials Source credentials to fill initial builder state
   * @return New Builder instance
   * @since __TO_BE_DEFINED__
   */
  public static Builder builder(MailgunCredentials credentials) {
    return new Builder(credentials);
  }

  /**
   * Dedicated Builder
   *
   * @since __TO_BE_DEFINED__
   */
  public static class Builder {

    String apiKey;

    protected Builder() {}

    /**
     * Initialize a builder with existing credentials
     *
     * @param credentials Credentials to be used as initial builder state
     * @since __TO_BE_DEFINED__
     */
    protected Builder(MailgunCredentials credentials) {
      this.apiKey = null != credentials ? credentials.getApiKey() : null;
    }

    /**
     * Set Mailgun api key
     *
     * @param apiKey api key to be used
     * @return Current builder
     * @since __TO_BE_DEFINED__
     */
    public Builder setApiKey(String apiKey) {
      this.apiKey = apiKey;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since __TO_BE_DEFINED__
     */
    public MailgunCredentials build() {
      return new MailgunCredentials(apiKey);
    }
  }
}
