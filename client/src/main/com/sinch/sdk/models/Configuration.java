package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;

/** Configuration used by Sinch Client */
public class Configuration {

  private final String keyId;
  private final String keySecret;
  private final String projectId;
  private final String applicationKey;
  private final String applicationSecret;
  private final String oauthUrl;
  private final String numbersUrl;
  private final SMSRegion smsRegion;
  private final String smsUrl;
  private final String verificationUrl;
  private final VoiceRegion voiceRegion;
  private final String voiceUrl;
  private final String voiceApplicationManagementUrl;
  private final ConversationRegion conversationRegion;
  private final String conversationUrl;
  private final String conversationTemplateManagementUrl;

  public Configuration(
      String keyId,
      String keySecret,
      String projectId,
      String applicationKey,
      String applicationSecret,
      String oauthUrl,
      String numbersUrl,
      SMSRegion smsRegion,
      String smsUrl,
      String verificationUrl,
      VoiceRegion voiceRegion,
      String voiceUrl,
      String voiceApplicationManagementUrl,
      ConversationRegion conversationRegion,
      String conversationUrl,
      String conversationTemplateManagementUrl) {
    this.keyId = keyId;
    this.keySecret = keySecret;
    this.projectId = projectId;
    this.applicationKey = applicationKey;
    this.applicationSecret = applicationSecret;
    this.oauthUrl = oauthUrl;
    this.numbersUrl = numbersUrl;
    this.smsRegion = null == smsRegion ? SMSRegion.US : smsRegion;
    this.smsUrl = smsUrl;
    this.verificationUrl = verificationUrl;
    this.voiceRegion = voiceRegion;
    this.voiceUrl = voiceUrl;
    this.voiceApplicationManagementUrl = voiceApplicationManagementUrl;
    this.conversationRegion =
        null == conversationRegion ? ConversationRegion.US : conversationRegion;
    this.conversationUrl = conversationUrl;
    this.conversationTemplateManagementUrl = conversationTemplateManagementUrl;
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
        + ", conversationRegion="
        + conversationRegion
        + ", conversationUrl='"
        + conversationUrl
        + '\''
        + ", conversationTemplateManagementUrl='"
        + conversationTemplateManagementUrl
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
   * Get selected Voice region
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
   * Conversation Region to be used for Conversation service
   *
   * @return Conversation region
   * @since 1.0
   */
  public ConversationRegion getConversationRegion() {
    return conversationRegion;
  }

  /**
   * Conversation Server Configuration
   *
   * @return Conversation Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getConversationServer() {
    return new ServerConfiguration(getConversationUrl());
  }

  /**
   * Conversation URL
   *
   * @return Conversation Server URL
   * @since 1.0
   */
  public String getConversationUrl() {
    return conversationUrl;
  }

  /**
   * Conversation Template Server Configuration
   *
   * @return Conversation Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getConversationTemplateManagementUrlServer() {
    return new ServerConfiguration(getConversationTemplateManagementUrl());
  }

  /**
   * Conversation Template Management URL
   *
   * @return Conversation Server URL
   * @since 1.0
   */
  public String getConversationTemplateManagementUrl() {
    return conversationTemplateManagementUrl;
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
    private String applicationKey;
    private String applicationSecret;
    private String oauthUrl;
    private String numbersUrl;
    private SMSRegion smsRegion;
    private String smsUrl;
    private String verificationUrl;
    public VoiceRegion voiceRegion;
    public String voiceUrl;
    private String voiceApplicationMngmtUrl;
    public ConversationRegion conversationRegion;
    public String conversationUrl;
    public String conversationTemplateManagementUrl;

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
      this.applicationKey = configuration.getApplicationKey();
      this.applicationSecret = configuration.getApplicationSecret();
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
      this.conversationRegion = configuration.getConversationRegion();
      this.conversationUrl = configuration.getConversationUrl();
      this.conversationTemplateManagementUrl = configuration.getConversationTemplateManagementUrl();
    }

    /**
     * Build a Configuration instance from builder current state
     *
     * @return Configuration instance build from current builder state
     * @since 1.0
     */
    public Configuration build() {
      return new Configuration(
          keyId,
          keySecret,
          projectId,
          applicationKey,
          applicationSecret,
          oauthUrl,
          numbersUrl,
          smsRegion,
          smsUrl,
          verificationUrl,
          voiceRegion,
          voiceUrl,
          voiceApplicationMngmtUrl,
          conversationRegion,
          conversationUrl,
          conversationTemplateManagementUrl);
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
     * Set Voice region to be used
     *
     * @param voiceRegion The region
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
     * Set Application secret Set Conversation Region to be used
     *
     * @param conversationRegion Conversation Region
     * @return Current builder
     * @since 1.0
     */
    public Builder setConversationRegion(ConversationRegion conversationRegion) {
      this.conversationRegion = conversationRegion;
      return this;
    }

    /**
     * Set Conversation API URL
     *
     * @param conversationUrl Conversation API URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setConversationUrl(String conversationUrl) {
      this.conversationUrl = conversationUrl;
      return this;
    }

    /**
     * Set Conversation Template Management API URL
     *
     * @param conversationTemplateManagementUrl Conversation Template Management URL
     * @return Current builder * @since 1.0
     */
    public Builder setConversationTemplateManagementUrl(String conversationTemplateManagementUrl) {
      this.conversationTemplateManagementUrl = conversationTemplateManagementUrl;
      return this;
    }
  }
}
