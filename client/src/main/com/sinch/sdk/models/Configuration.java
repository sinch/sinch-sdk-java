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
  private final VoiceRegion voiceRegion;
  private final String voiceUrl;
  private final String voiceApplicationManagementUrl;

  private final String applicationKey;
  private final String applicationSecret;

  private Configuration(
      String keyId,
      String keySecret,
      String projectId,
      String oauthUrl,
      String numbersUrl,
      SMSRegion smsRegion,
      String smsUrl,
      String verificationUrl,
      VoiceRegion voiceRegion,
      String voiceUrl,
      String voiceApplicationManagementUrl,
      String applicationKey,
      String applicationSecret) {
    this.keyId = keyId;
    this.keySecret = keySecret;
    this.projectId = projectId;
    this.oauthUrl = oauthUrl;
    this.numbersUrl = numbersUrl;
    this.smsRegion = null == smsRegion ? SMSRegion.US : smsRegion;
    this.smsUrl = smsUrl;
    this.verificationUrl = verificationUrl;
    this.voiceRegion = voiceRegion;
    this.voiceUrl = voiceUrl;
    this.voiceApplicationManagementUrl = voiceApplicationManagementUrl;
    this.applicationKey = applicationKey;
    this.applicationSecret = applicationSecret;
  }

  @Override
  public String toString() {
    return "Configuration{"
        + "oauthUrl='"
        + oauthUrl
        + '\''
        + ", numbersUrl='"
        + numbersUrl
        + '\''
        + ", smsRegion="
        + smsRegion
        + ", smsUrl='"
        + smsUrl
        + '\''
        + ", verificationUrl='"
        + verificationUrl
        + '\''
        + ", voiceRegion="
        + voiceRegion
        + ", voiceUrl='"
        + voiceUrl
        + '\''
        + ", voiceApplicationMngmtUrl='"
        + voiceApplicationManagementUrl
        + '\''
        + '}';
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

  /**
   * Voice region
   *
   * @return Selected Voice Region
   * @since 1.0
   */
  public VoiceRegion getVoiceRegion() {
    return voiceRegion;
  }

  /**
   * Voice URL
   *
   * @return Voice Server URL
   * @since 1.0
   */
  public String getVoiceUrl() {
    return voiceUrl;
  }

  /**
   * Voice Server Configuration
   *
   * @return Voice Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getVoiceServer() {
    return new ServerConfiguration(getVoiceUrl());
  }

  /**
   * Voice Application Management URL
   *
   * @return Voice Application Management URL
   * @since 1.0
   */
  public String getVoiceApplicationManagementUrl() {
    return voiceApplicationManagementUrl;
  }

  /**
   * Voice Application Management Configuration
   *
   * @return Voice Application Management to be used
   * @since 1.0
   */
  public ServerConfiguration getVoiceApplicationManagementServer() {
    return new ServerConfiguration(getVoiceApplicationManagementUrl());
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
   * @param configuration Source configuration to fill initial builder state
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder(Configuration configuration) {
    return new Builder(configuration);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    String keyId;
    String keySecret;
    String projectId;
    String oauthUrl;
    String numbersUrl;
    SMSRegion smsRegion;
    String smsUrl;
    String verificationUrl;
    String applicationKey;
    String applicationSecret;
    VoiceRegion voiceRegion;
    String voiceUrl;
    String voiceApplicationMngmtUrl;

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
      this.applicationKey = configuration.getApplicationKey();
      this.applicationSecret = configuration.getApplicationSecret();
      this.voiceRegion = configuration.getVoiceRegion();
      this.voiceUrl = configuration.getVoiceUrl();
      this.voiceApplicationMngmtUrl = configuration.getVoiceApplicationManagementUrl();
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

    /**
     * Set region to be used for Vioce service
     *
     * @param voiceRegion The regino
     * @return Current builder
     * @since 1.0
     */
    public Builder setVoiceRegion(VoiceRegion voiceRegion) {
      this.voiceRegion = voiceRegion;
      return this;
    }

    /**
     * Set Voice URL to be used
     *
     * @param voiceUrl Voice URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setVoiceUrl(String voiceUrl) {
      this.voiceUrl = voiceUrl;
      return this;
    }

    /**
     * Set URL dedicated to Voice Application management to be used
     *
     * @param voiceApplicationMngmtUrl Voice Application Management URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setVoiceApplicationMngmtUrl(String voiceApplicationMngmtUrl) {
      this.voiceApplicationMngmtUrl = voiceApplicationMngmtUrl;
      return this;
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
     * Setter
     *
     * <p>See {@link Configuration#getVoiceRegion()} getter
     *
     * @return Current builder
     * @since 1.0
     */
    public VoiceRegion getVoiceRegion() {
      return voiceRegion;
    }

    /**
     * Setter
     *
     * <p>See {@link Configuration#getVoiceUrl()} getter
     *
     * @return Current builder
     * @since 1.0
     */
    public String getVoiceUrl() {
      return voiceUrl;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public Configuration build() {
      return new Configuration(
          keyId,
          keySecret,
          projectId,
          oauthUrl,
          numbersUrl,
          smsRegion,
          smsUrl,
          verificationUrl,
          voiceRegion,
          voiceUrl,
          voiceApplicationMngmtUrl,
          applicationKey,
          applicationSecret);
    }
  }
}
