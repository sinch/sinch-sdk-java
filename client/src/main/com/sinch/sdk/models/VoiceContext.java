package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;

/** Execution context related to Voice domains */
public class VoiceContext {

  private final VoiceRegion voiceRegion;
  private final String voiceUrl;
  private final String voiceApplicationManagementUrl;

  public VoiceContext(
      VoiceRegion voiceRegion, String voiceUrl, String voiceApplicationManagementUrl) {
    this.voiceRegion = voiceRegion;
    this.voiceUrl = voiceUrl;
    this.voiceApplicationManagementUrl = voiceApplicationManagementUrl;
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
  public static Builder builder(VoiceContext configuration) {
    return new Builder(configuration);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    VoiceRegion voiceRegion;
    String voiceUrl;
    String voiceApplicationMngmtUrl;

    protected Builder() {}

    /**
     * Initialize a builder with existing configuration
     *
     * @param context Configuration to be used as initial builder state
     * @since 1.0
     */
    protected Builder(VoiceContext context) {
      this.voiceRegion = null != context ? context.getVoiceRegion() : null;
      this.voiceUrl = null != context ? context.getVoiceUrl() : null;
      this.voiceApplicationMngmtUrl =
          null != context ? context.getVoiceApplicationManagementUrl() : null;
    }

    /**
     * Set region to be used for Voice service
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
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VoiceContext build() {

      return new VoiceContext(voiceRegion, voiceUrl, voiceApplicationMngmtUrl);
    }
  }
}
