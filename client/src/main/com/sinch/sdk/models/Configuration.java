package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;
import java.util.Optional;

/** Configuration used by Sinch Client */
public class Configuration {

  private final UnifiedCredentials unifiedCredentials;
  private final ApplicationCredentials applicationCredentials;
  private final String oauthUrl;
  private final NumbersContext numbersContext;
  private final SmsContext smsContext;
  private final VerificationContext verificationContext;
  private final VoiceContext voiceContext;

  private Configuration(
      UnifiedCredentials unifiedCredentials,
      ApplicationCredentials applicationCredentials,
      String oauthUrl,
      NumbersContext numbersContext,
      SmsContext smsContext,
      VerificationContext verificationContext,
      VoiceContext voiceContext) {
    this.unifiedCredentials = unifiedCredentials;
    this.applicationCredentials = applicationCredentials;
    this.oauthUrl = oauthUrl;
    this.numbersContext = numbersContext;
    this.smsContext = smsContext;
    this.voiceContext = voiceContext;
    this.verificationContext = verificationContext;
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
    NumbersContext.Builder numbersContext;
    SmsContext.Builder smsContext;
    VerificationContext.Builder verificationContext;
    VoiceContext.Builder voiceContext;

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
      this.numbersContext =
          configuration.getNumbersContext().map(NumbersContext::builder).orElse(null);
      this.smsContext = configuration.getSmsContext().map(SmsContext::builder).orElse(null);
      this.verificationContext =
          configuration.getVerificationContext().map(VerificationContext::builder).orElse(null);
      this.voiceContext = configuration.getVoiceContext().map(VoiceContext::builder).orElse(null);
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
     * Set Numbers related context
     *
     * @param context {@link #getNumbersContext()} () getter}
     * @return Current builder
     * @since 1.0
     */
    public Builder setNumbersContext(NumbersContext context) {
      this.numbersContext = null != context ? NumbersContext.builder(context) : null;
      return this;
    }

    /**
     * Set SMS related region
     *
     * @param region {@link SmsContext#getSmsRegion()} () getter}
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
     * @param context {@link #getSmsContext()} ()} () getter}
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
          null != numbersContext ? numbersContext.build() : null,
          null != smsContext ? smsContext.build() : null,
          null != verificationContext ? verificationContext.build() : null,
          null != voiceContext ? voiceContext.build() : null);
    }
  }
}
