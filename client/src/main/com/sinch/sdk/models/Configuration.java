package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;
import java.util.Optional;

/** Configuration used by Sinch Client */
public class Configuration {

  private final UnifiedCredentials unifiedCredentials;
  private final ApplicationCredentials applicationCredentials;
  private final SmsServicePlanCredentials smsServicePlanCredentials;
  private final String oauthUrl;
  private final NumbersContext numbersContext;
  private final SmsContext smsContext;
  private final VerificationContext verificationContext;
  private final VoiceContext voiceContext;

  private final ConversationRegion conversationRegion;
  private final String conversationUrl;
  private final String conversationTemplateManagementUrl;

  private Configuration(
      UnifiedCredentials unifiedCredentials,
      ApplicationCredentials applicationCredentials,
      SmsServicePlanCredentials smsServicePlanCredentials,
      String oauthUrl,
      NumbersContext numbersContext,
      SmsContext smsContext,
      VerificationContext verificationContext,
      VoiceContext voiceContext,
      ConversationRegion conversationRegion,
      String conversationUrl,
      String conversationTemplateManagementUrl) {
    this.unifiedCredentials = unifiedCredentials;
    this.applicationCredentials = applicationCredentials;
    this.smsServicePlanCredentials = smsServicePlanCredentials;
    this.oauthUrl = oauthUrl;
    this.numbersContext = numbersContext;
    this.smsContext = smsContext;
    this.voiceContext = voiceContext;
    this.verificationContext = verificationContext;
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
        + ", numbersContext="
        + numbersContext
        + ", smsContext="
        + smsContext
        + ", verificationContext="
        + verificationContext
        + ", voiceContext="
        + voiceContext
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
   * Get SMS service plan ID credentials
   *
   * @return Credentials
   * @since 1.0
   */
  public Optional<SmsServicePlanCredentials> getSmsServicePlanCredentials() {
    return Optional.ofNullable(smsServicePlanCredentials);
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
   * Get Numbers domain related execution context
   *
   * @return Current Numbers context
   * @since 1.0
   */
  public Optional<NumbersContext> getNumbersContext() {
    return Optional.ofNullable(numbersContext);
  }

  /**
   * Get SMS domain related execution context
   *
   * @return Current SMS context
   * @since 1.0
   */
  public Optional<SmsContext> getSmsContext() {
    return Optional.ofNullable(smsContext);
  }

  /**
   * Get Verification domain related execution context
   *
   * @return Current Verification context
   * @since 1.0
   */
  public Optional<VerificationContext> getVerificationContext() {
    return Optional.ofNullable(verificationContext);
  }

  /**
   * Get Voice domain related execution context
   *
   * @return Current Voice context
   * @since 1.0
   */
  public Optional<VoiceContext> getVoiceContext() {
    return Optional.ofNullable(voiceContext);
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
    SmsServicePlanCredentials.Builder smsServicePlanCredentials;
    String oauthUrl;
    NumbersContext.Builder numbersContext;
    SmsContext.Builder smsContext;
    VerificationContext.Builder verificationContext;
    VoiceContext.Builder voiceContext;

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
      this.unifiedCredentials =
          configuration.getUnifiedCredentials().map(UnifiedCredentials::builder).orElse(null);
      this.applicationCredentials =
          configuration
              .getApplicationCredentials()
              .map(ApplicationCredentials::builder)
              .orElse(null);
      this.smsServicePlanCredentials =
          configuration
              .getSmsServicePlanCredentials()
              .map(SmsServicePlanCredentials::builder)
              .orElse(null);
      this.oauthUrl = configuration.getOAuthUrl();
      this.numbersContext =
          configuration.getNumbersContext().map(NumbersContext::builder).orElse(null);
      this.smsContext = configuration.getSmsContext().map(SmsContext::builder).orElse(null);
      this.verificationContext =
          configuration.getVerificationContext().map(VerificationContext::builder).orElse(null);
      this.voiceContext = configuration.getVoiceContext().map(VoiceContext::builder).orElse(null);

      this.conversationRegion = configuration.getConversationRegion();
      this.conversationUrl = configuration.getConversationUrl();
      this.conversationTemplateManagementUrl = configuration.getConversationTemplateManagementUrl();
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
     * @see ApplicationCredentials#getApplicationSecret() getter
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
     * Set Numbers related context
     *
     * @param context {@link #getNumbersContext() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setNumbersContext(NumbersContext context) {
      this.numbersContext = null != context ? NumbersContext.builder(context) : null;
      return this;
    }

    /**
     * Set SMS related service plan ID
     *
     * @param servicePlanId {@link SmsServicePlanCredentials#getServicePlanId() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setSmsServicePlanId(String servicePlanId) {
      if (null == this.smsServicePlanCredentials) {
        this.smsServicePlanCredentials = SmsServicePlanCredentials.builder();
      }
      this.smsServicePlanCredentials.setServicePlanId(servicePlanId);
      return this;
    }

    /**
     * Set SMS related service plan token
     *
     * @param token {@link SmsServicePlanCredentials#getApiToken() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setSmsApiToken(String token) {
      if (null == this.smsServicePlanCredentials) {
        this.smsServicePlanCredentials = SmsServicePlanCredentials.builder();
      }
      this.smsServicePlanCredentials.setApiToken(token);
      return this;
    }

    /**
     * Set SMS related region
     *
     * @param region {@link SmsContext#getSmsRegion() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setSmsRegion(SMSRegion region) {
      if (null == this.smsContext) {
        this.smsContext = SmsContext.builder();
      }
      this.smsContext.setSmsRegion(region);
      return this;
    }

    /**
     * Set Sms related context
     *
     * @param context {@link #getSmsContext() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setSmsContext(SmsContext context) {
      this.smsContext = null != context ? SmsContext.builder(context) : null;
      return this;
    }

    /**
     * Set Verification related context
     *
     * @param context {@link #getVerificationContext() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setVerificationContext(VerificationContext context) {
      this.verificationContext = null != context ? VerificationContext.builder(context) : null;
      return this;
    }

    /**
     * Set Voice related region
     *
     * @param region {@link VoiceContext#getVoiceRegion() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setVoiceRegion(VoiceRegion region) {
      if (null == this.voiceContext) {
        this.voiceContext = VoiceContext.builder();
      }
      this.voiceContext.setVoiceRegion(region);
      return this;
    }

    /**
     * Set Voice related context
     *
     * @param context {@link #getVoiceContext() getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setVoiceContext(VoiceContext context) {
      this.voiceContext = null != context ? VoiceContext.builder(context) : null;
      return this;
    }

    /**
     * Set Conversation Region to be used
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

    /**
     * Build a Configuration instance from builder current state
     *
     * @return Configuration instance build from current builder state
     * @since 1.0
     */
    public Configuration build() {

      return new Configuration(
          null != unifiedCredentials ? unifiedCredentials.build() : null,
          null != applicationCredentials ? applicationCredentials.build() : null,
          null != smsServicePlanCredentials ? smsServicePlanCredentials.build() : null,
          oauthUrl,
          null != numbersContext ? numbersContext.build() : null,
          null != smsContext ? smsContext.build() : null,
          null != verificationContext ? verificationContext.build() : null,
          null != voiceContext ? voiceContext.build() : null,
          conversationRegion,
          conversationUrl,
          conversationTemplateManagementUrl);
    }
  }
}
