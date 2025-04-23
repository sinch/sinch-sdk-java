package com.sinch.sdk.models;

/**
 * Credentials related to Voice/Verification authentication
 *
 * @since 1.0
 */
public class ApplicationCredentials implements Credentials {

  private final String applicationKey;
  private final String applicationSecret;

  private ApplicationCredentials(String applicationKey, String applicationSecret) {
    this.applicationKey = applicationKey;
    this.applicationSecret = applicationSecret;
  }

  /**
   * Application key to be used for Verification and Voice services
   *
   * <p>Use application secret in place of unified configuration for authentication (see Sinch
   * dashboard for details) These credentials are related to Verification &amp; Voice Apps
   *
   * @return Application key
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/authentication/">Sinch
   *     Documentation</a>
   * @since 1.0
   */
  public String getApplicationKey() {
    return applicationKey;
  }

  /**
   * Application secret to be used for Verification and Voice services
   *
   * <p>Use application secret in place of unified configuration for authentication (see Sinch
   * dashboard for details) These credentials are related to Verification &amp; Voice Apps
   *
   * @return Application key
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/authentication/">Sinch
   *     Documentation</a>
   * @since 1.0
   */
  public String getApplicationSecret() {
    return applicationSecret;
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder
   *
   * @param credentials Source credentials to fill initial builder state
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder(ApplicationCredentials credentials) {
    return new Builder(credentials);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    String applicationKey;
    String applicationSecret;

    protected Builder() {}

    /**
     * Initialize a builder with existing credentials
     *
     * @param credentials Credentials to be used as initial builder state
     * @since 1.0
     */
    protected Builder(ApplicationCredentials credentials) {
      this.applicationKey = null != credentials ? credentials.getApplicationKey() : null;
      this.applicationSecret = null != credentials ? credentials.getApplicationSecret() : null;
    }

    /**
     * Set Application secret
     *
     * @param applicationKey Application key to be used
     * @return Current builder
     * @since 1.0
     */
    public Builder setApplicationKey(String applicationKey) {
      this.applicationKey = applicationKey;
      return this;
    }

    /**
     * Set Application secret
     *
     * @param applicationSecret Application secret to be used
     * @return Current builder
     * @since 1.0
     */
    public Builder setApplicationSecret(String applicationSecret) {
      this.applicationSecret = applicationSecret;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public ApplicationCredentials build() {
      return new ApplicationCredentials(applicationKey, applicationSecret);
    }
  }
}
