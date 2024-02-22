package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;

/** Execution context related to Verification domains */
public class VerificationContext {

  private final String verificationUrl;

  private VerificationContext(String verificationUrl) {
    this.verificationUrl = verificationUrl;
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
  public static Builder builder(VerificationContext configuration) {
    return new Builder(configuration);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    String verificationUrl;

    protected Builder() {}

    /**
     * Initialize a builder with existing configuration
     *
     * @param context Configuration to be used as initial builder state
     * @since 1.0
     */
    protected Builder(VerificationContext context) {
      this.verificationUrl = null != context ? context.getVerificationUrl() : null;
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
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VerificationContext build() {

      return new VerificationContext(verificationUrl);
    }
  }
}
