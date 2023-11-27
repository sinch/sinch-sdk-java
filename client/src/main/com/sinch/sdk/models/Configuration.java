package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;

/** Configuration used by Sinch Client */
public class Configuration {

  private final String keyId;
  private final String keySecret;
  private final String projectId;
  private final String oauthUrl;
  private final String numbersUrl;
  private final SMSRegion smsRegion;
  private final String smsUrl;
  private final String verificationUrl;

  private Configuration(
      String keyId,
      String keySecret,
      String projectId,
      String oauthUrl,
      String numbersUrl,
      SMSRegion smsRegion,
      String smsUrl,
      String verificationUrl) {
    this.keyId = keyId;
    this.keySecret = keySecret;
    this.projectId = projectId;
    this.oauthUrl = oauthUrl;
    this.numbersUrl = numbersUrl;
    this.smsRegion = null == smsRegion ? SMSRegion.US : smsRegion;
    this.smsUrl = smsUrl;
    this.verificationUrl = verificationUrl;
  }

  @Override
  public String toString() {
    // ! do not dump secret values
    return "Configuration{"
        + "keyId=..."
        + ", keySecret=..."
        + ", projectId=..."
        + ", oAuthUrl='"
        + oauthUrl
        + '\''
        + ", numbersUrl='"
        + numbersUrl
        + '\''
        + ", smsRegion='"
        + smsRegion
        + '\''
        + ", smsUrl='"
        + smsUrl
        + '\''
        + ", verificationUrl='"
        + verificationUrl
        + '\''
        + "}";
  }

  /**
   * Get Key ID
   *
   * @return key id.
   * @see <a href="https://developers.sinch.com/">https://developers.sinch.com/</a>
   * @since 1.0
   */
  public String getKeyId() {
    return keyId;
  }

  /**
   * Get key ID
   *
   * @return key secret.
   * @see <a href="https://developers.sinch.com/">https://developers.sinch.com/</a>
   * @since 1.0
   */
  public String getKeySecret() {
    return keySecret;
  }

  /**
   * Get Project ID
   *
   * @return Project id.
   * @see <a href="https://developers.sinch.com/">https://developers.sinch.com/</a>
   * @since 1.0
   */
  public String getProjectId() {
    return projectId;
  }

  /**
   * OAuth server
   *
   * @return OAuth Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getOAuthServer() {
    return new ServerConfiguration(getOAuthUrl());
  }

  /**
   * OAuth URL
   *
   * @return OAuth Server URL
   * @since 1.0
   */
  public String getOAuthUrl() {
    return oauthUrl;
  }

  /**
   * Numbers Server Configuration
   *
   * @return Numbers Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getNumbersServer() {
    return new ServerConfiguration(getNumbersUrl());
  }

  /**
   * Numbers URL
   *
   * @return Numbers Server URL
   * @since 1.0
   */
  public String getNumbersUrl() {
    return numbersUrl;
  }

  /**
   * SMS Server Configuration
   *
   * @return SMS Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getSmsServer() {
    return new ServerConfiguration(String.format(getSmsUrl(), getSmsRegion()));
  }

  /**
   * SMS Region
   *
   * @return SMS region
   * @see <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/#base-url/">https://developers.sinch.com/docs/sms/api-reference/#base-url/</a>
   * @since 1.0
   */
  public SMSRegion getSmsRegion() {
    return smsRegion;
  }

  /**
   * SMS URL
   *
   * @return SMS Server URL
   * @since 1.0
   */
  public String getSmsUrl() {
    return smsUrl;
  }

  /**
   * Verification Server Configuration
   *
   * @return Verification Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getVerificationServer() {
    return new ServerConfiguration(getVerificationUrl());
  }
  /**
   * Verification URL
   *
   * @return Verification Server URL
   * @since 1.0
   */
  public String getVerificationUrl() {
    return verificationUrl;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(Configuration configuration) {
    return new Builder(configuration);
  }

  /** Configuration builder */
  public static class Builder {

    private String keyId;
    private String keySecret;
    private String projectId;
    private String oauthUrl;
    private String numbersUrl;
    private SMSRegion smsRegion;
    private String smsUrl;
    private String verificationUrl;

    protected Builder() {}

    /**
     * Initialize a builder with existing configuration
     *
     * @param configuration Configuration to be used as initial builder state
     * @since 1.0
     */
    protected Builder(Configuration configuration) {
      this.keyId = configuration.getKeyId();
      this.keySecret = configuration.getKeySecret();
      this.projectId = configuration.getProjectId();
      this.oauthUrl = configuration.getOAuthUrl();
      this.numbersUrl = configuration.getNumbersUrl();
      this.smsRegion = configuration.getSmsRegion();
      this.smsUrl = configuration.getSmsUrl();
      this.verificationUrl = configuration.getVerificationUrl();
    }

    /**
     * Build a Configuration instance from builder current state
     *
     * @return Configuration instance build from current builder state
     * @since 1.0
     */
    public Configuration build() {
      return new Configuration(
          keyId, keySecret, projectId, oauthUrl, numbersUrl, smsRegion, smsUrl, verificationUrl);
    }

    /**
     * Set key ID
     *
     * @param keyId key ID
     * @return Current builder
     * @since 1.0
     */
    public Builder setKeyId(String keyId) {
      this.keyId = keyId;
      return this;
    }

    /**
     * Set key secret
     *
     * @param keySecret key secret
     * @return Current builder
     * @since 1.0
     */
    public Builder setKeySecret(String keySecret) {
      this.keySecret = keySecret;
      return this;
    }

    /**
     * Set Project ID
     *
     * @param projectId Project ID
     * @return Current builder
     * @since 1.0
     */
    public Builder setProjectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    /**
     * Set OAuth URL
     *
     * @param oauthUrl OAuth URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setOAuthUrl(String oauthUrl) {
      this.oauthUrl = oauthUrl;
      return this;
    }

    /**
     * Set Numbers API URL
     *
     * @param numbersUrl Numbers API URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setNumbersUrl(String numbersUrl) {
      this.numbersUrl = numbersUrl;
      return this;
    }

    /**
     * Set SMS region
     *
     * @param smsRegion SMS region
     * @return Current builder
     * @since 1.0
     */
    public Builder setSmsRegion(SMSRegion smsRegion) {
      this.smsRegion = smsRegion;
      return this;
    }

    /**
     * Set SMS API URL
     *
     * @param smsUrl SMS API URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setSmsUrl(String smsUrl) {
      this.smsUrl = smsUrl;
      return this;
    }

    /**
     * Set Verification API URL
     *
     * @param verificationUrl Verification API URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setVerificationUrl(String verificationUrl) {
      this.verificationUrl = verificationUrl;
      return this;
    }
  }
}
