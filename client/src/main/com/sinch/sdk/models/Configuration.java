package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;
import java.util.Optional;

/** Configuration used by Sinch Client */
public class Configuration {

  private final UnifiedCredentials unifiedCredentials;
  private final ApplicationCredentials applicationCredentials;
  private final String oauthUrl;
  private final String numbersUrl;
  private final SMSRegion smsRegion;
  private final String smsUrl;
  private final String verificationUrl;
  private final VoiceRegion voiceRegion;
  private final String voiceUrl;
  private final String voiceApplicationManagementUrl;

  private Configuration(
      UnifiedCredentials unifiedCredentials,
      ApplicationCredentials applicationCredentials,
      String oauthUrl,
      String numbersUrl,
      SMSRegion smsRegion,
      String smsUrl,
      String verificationUrl,
      VoiceRegion voiceRegion,
      String voiceUrl,
      String voiceApplicationManagementUrl) {
    this.unifiedCredentials = unifiedCredentials;
    this.applicationCredentials = applicationCredentials;
    this.oauthUrl = oauthUrl;
    this.numbersUrl = numbersUrl;
    this.smsRegion = null == smsRegion ? SMSRegion.US : smsRegion;
    this.smsUrl = smsUrl;
    this.verificationUrl = verificationUrl;
    this.voiceRegion = voiceRegion;
    this.voiceUrl = voiceUrl;
    this.voiceApplicationManagementUrl = voiceApplicationManagementUrl;
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
   * @see UnifiedCredentials#getKeyId()
   * @since 1.0
   */
  public String getKeyId() {
    return null != unifiedCredentials ? unifiedCredentials.getKeyId() : null;
  }

  /**
   * Get key ID
   *
   * @return key secret.
   * @see UnifiedCredentials#getKeySecret()
   * @since 1.0
   */
  public String getKeySecret() {
    return null != unifiedCredentials ? unifiedCredentials.getKeySecret() : null;
  }

  /**
   * Get Project ID
   *
   * @return Project id.
   * @see UnifiedCredentials#getProjectId()
   * @since 1.0
   */
  public String getProjectId() {
    return null != unifiedCredentials ? unifiedCredentials.getProjectId() : null;
  }

  /**
   * Get Sinch unified credentials
   *
   * @return Credentials
   * @see <a href="https://developers.sinch.com/">https://developers.sinch.com/</a>
   * @since 1.0
   */
  public Optional<UnifiedCredentials> getUnifiedCredentials() {
    return Optional.ofNullable(unifiedCredentials);
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
   * Credentials to be used for Verification and Voice services
   *
   * @return Application credentials
   * @see <a
   *     href="https://developers.sinch.com/docs/verification/api-reference/authentication/">Sinch
   *     Documentation</a>
   * @since 1.0
   */
  public Optional<ApplicationCredentials> getApplicationCredentials() {
    return Optional.ofNullable(applicationCredentials);
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

    UnifiedCredentials.Builder unifiedCredentials;
    ApplicationCredentials.Builder applicationCredentials;
    String oauthUrl;
    String numbersUrl;
    SMSRegion smsRegion;
    String smsUrl;
    String verificationUrl;
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
      this.unifiedCredentials =
          configuration.getUnifiedCredentials().map(UnifiedCredentials::builder).orElse(null);
      this.applicationCredentials =
          configuration
              .getApplicationCredentials()
              .map(ApplicationCredentials::builder)
              .orElse(null);
      this.oauthUrl = configuration.getOAuthUrl();
      this.numbersUrl = configuration.getNumbersUrl();
      this.smsRegion = configuration.getSmsRegion();
      this.smsUrl = configuration.getSmsUrl();
      this.verificationUrl = configuration.getVerificationUrl();
      this.voiceRegion = configuration.getVoiceRegion();
      this.voiceUrl = configuration.getVoiceUrl();
      this.voiceApplicationMngmtUrl = configuration.getVoiceApplicationManagementUrl();
    }

    /**
     * Set key ID
     *
     * @param keyId key ID
     * @return Current builder
     * @see UnifiedCredentials#getKeyId() getter
     * @since 1.0
     */
    public Builder setKeyId(String keyId) {
      if (null == this.unifiedCredentials) {
        this.unifiedCredentials = UnifiedCredentials.builder();
      }
      this.unifiedCredentials.setKeyId(keyId);
      return this;
    }

    /**
     * Set key secret
     *
     * @param keySecret key secret
     * @return Current builder
     * @see UnifiedCredentials#getKeySecret() getter
     * @since 1.0
     */
    public Builder setKeySecret(String keySecret) {
      if (null == this.unifiedCredentials) {
        this.unifiedCredentials = UnifiedCredentials.builder();
      }
      this.unifiedCredentials.setKeySecret(keySecret);
      return this;
    }

    /**
     * Set Project ID
     *
     * @param projectId Project ID
     * @return Current builder
     * @see UnifiedCredentials#getProjectId() getter
     * @since 1.0
     */
    public Builder setProjectId(String projectId) {
      if (null == this.unifiedCredentials) {
        this.unifiedCredentials = UnifiedCredentials.builder();
      }
      this.unifiedCredentials.setProjectId(projectId);
      return this;
    }

    /**
     * Set Application key
     *
     * @param applicationKey key
     * @return Current builder
     * @see ApplicationCredentials#getApplicationKey() getter
     * @since 1.0
     */
    public Builder setApplicationKey(String applicationKey) {
      if (null == this.applicationCredentials) {
        this.applicationCredentials = ApplicationCredentials.builder();
      }
      this.applicationCredentials.setApplicationKey(applicationKey);
      return this;
    }

    /**
     * Set Application secret
     *
     * @param applicationSecret key
     * @return Current builder
     * @see ApplicationCredentials#getApplicationSecret() () getter
     * @since 1.0
     */
    public Builder setApplicationSecret(String applicationSecret) {
      if (null == this.applicationCredentials) {
        this.applicationCredentials = ApplicationCredentials.builder();
      }
      this.applicationCredentials.setApplicationSecret(applicationSecret);
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
          null != unifiedCredentials ? unifiedCredentials.build() : null,
          null != applicationCredentials ? applicationCredentials.build() : null,
          oauthUrl,
          numbersUrl,
          smsRegion,
          smsUrl,
          verificationUrl,
          voiceRegion,
          voiceUrl,
          voiceApplicationMngmtUrl);
    }
  }
}
