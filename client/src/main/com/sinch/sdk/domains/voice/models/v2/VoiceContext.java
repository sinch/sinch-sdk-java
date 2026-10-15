package com.sinch.sdk.domains.voice.models.v2;

import com.sinch.sdk.core.models.ServerConfiguration;

/**
 * Execution context related to Voice V2. It holds Voice V2 settings only: Voice V1 settings live in
 * {@link com.sinch.sdk.models.VoiceContext}.
 *
 * @since 2.3
 */
public class VoiceContext {

  private final VoiceRegion voiceRegion;
  private final String voiceUrl;

  public VoiceContext(VoiceRegion voiceRegion, String voiceUrl) {
    this.voiceRegion = voiceRegion;
    this.voiceUrl = voiceUrl;
  }

  /**
   * Voice V2 region
   *
   * @return Selected Voice V2 region
   * @since 2.3
   */
  public VoiceRegion getVoiceRegion() {
    return voiceRegion;
  }

  /**
   * Voice V2 URL
   *
   * @return Voice V2 server URL
   * @since 2.3
   */
  public String getVoiceUrl() {
    return voiceUrl;
  }

  /**
   * Voice V2 server configuration
   *
   * @return Voice V2 server configuration to be used
   * @since 2.3
   */
  public ServerConfiguration getVoiceServer() {
    return new ServerConfiguration(getVoiceUrl());
  }

  @Override
  public String toString() {
    return "VoiceContext{" + "voiceRegion=" + voiceRegion + ", voiceUrl='" + voiceUrl + '\'' + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 2.3
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder
   *
   * @param context Source context to fill initial builder state
   * @return New Builder instance
   * @since 2.3
   */
  public static Builder builder(VoiceContext context) {
    return new Builder(context);
  }

  /**
   * Dedicated Builder
   *
   * @since 2.3
   */
  public static class Builder {

    VoiceRegion voiceRegion;
    String voiceUrl;

    protected Builder() {}

    /**
     * Initialize a builder with existing context
     *
     * @param context Context to be used as initial builder state
     * @since 2.3
     */
    protected Builder(VoiceContext context) {
      this.voiceRegion = null != context ? context.getVoiceRegion() : null;
      this.voiceUrl = null != context ? context.getVoiceUrl() : null;
    }

    /**
     * Set region to be used for Voice V2 service. Ignored when a URL is set with {@link
     * #setVoiceUrl(String)}.
     *
     * @param voiceRegion The region
     * @return Current builder
     * @since 2.3
     */
    public Builder setVoiceRegion(VoiceRegion voiceRegion) {
      this.voiceRegion = voiceRegion;
      return this;
    }

    /**
     * Set Voice V2 URL to be used. Takes precedence over the region.
     *
     * @param voiceUrl Voice V2 URL
     * @return Current builder
     * @since 2.3
     */
    public Builder setVoiceUrl(String voiceUrl) {
      this.voiceUrl = voiceUrl;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 2.3
     */
    public VoiceContext build() {
      return new VoiceContext(voiceRegion, voiceUrl);
    }
  }
}
