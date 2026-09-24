package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;

/** Execution context related to Voice domains */
public class VoiceContext {

  private final VoiceRegion voiceRegion;
  private final String voiceUrl;
  private final String voiceApplicationManagementUrl;
  private final String voiceV2Url;

  public VoiceContext(
      VoiceRegion voiceRegion, String voiceUrl, String voiceApplicationManagementUrl) {
    this(voiceRegion, voiceUrl, voiceApplicationManagementUrl, null);
  }

  public VoiceContext(
      VoiceRegion voiceRegion,
      String voiceUrl,
      String voiceApplicationManagementUrl,
      String voiceV2Url) {
    this.voiceRegion = voiceRegion;
    this.voiceUrl = voiceUrl;
    this.voiceApplicationManagementUrl = voiceApplicationManagementUrl;
    this.voiceV2Url = voiceV2Url;
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
   * Voice V2 URL
   *
   * @return Voice V2 Server URL
   * @since 2.3
   */
  public String getVoiceV2Url() {
    return voiceV2Url;
  }

  /**
   * Voice V2 Server Configuration
   *
   * @return Voice V2 Server configuration to be used
   * @since 2.3
   */
  public ServerConfiguration getVoiceV2Server() {
    return new ServerConfiguration(getVoiceV2Url());
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
    String voiceV2Url;

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
      this.voiceV2Url = null != context ? context.getVoiceV2Url() : null;
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
     * Set Voice V2 URL to be used
     *
     * @param voiceV2Url Voice V2 URL
     * @return Current builder
     * @since 2.3
     */
    public Builder setVoiceV2Url(String voiceV2Url) {
      this.voiceV2Url = voiceV2Url;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public VoiceContext build() {

      return new VoiceContext(voiceRegion, voiceUrl, voiceApplicationMngmtUrl, voiceV2Url);
    }
  }
}
