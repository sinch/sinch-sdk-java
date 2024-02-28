package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;

/** Execution context related to Conversation domains */
public class ConversationContext {

  private final ConversationRegion region;
  private final String url;
  private final String templateManagementUrl;

  private ConversationContext(ConversationRegion region, String url, String templateManagementUrl) {
    this.region = region;
    this.url = url;
    this.templateManagementUrl = templateManagementUrl;
  }

  /**
   * Conversation region
   *
   * @return Selected Region
   * @since 1.0
   */
  public ConversationRegion getRegion() {
    return region;
  }

  /**
   * Conversation URL
   *
   * @return Conversation Server URL
   * @since 1.0
   */
  public String getUrl() {
    return url;
  }

  /**
   * Conversation template management URL
   *
   * @return Conversation template management URL
   * @since 1.0
   */
  public String getTemplateManagementUrl() {
    return templateManagementUrl;
  }

  /**
   * Conversation Server Configuration
   *
   * @return Conversation Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getServer() {
    return new ServerConfiguration(getUrl());
  }

  /**
   * Conversation Template Management Configuration
   *
   * @return Conversation Template Management to be used
   * @since 1.0
   */
  public ServerConfiguration getTemplateManagementServer() {
    return new ServerConfiguration(getTemplateManagementUrl());
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
  public static Builder builder(ConversationContext configuration) {
    return new Builder(configuration);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    ConversationRegion region;
    String url;
    String templateManagementUrl;

    protected Builder() {}

    /**
     * Initialize a builder with existing configuration
     *
     * @param context Configuration to be used as initial builder state
     * @since 1.0
     */
    protected Builder(ConversationContext context) {
      this.region = null != context ? context.getRegion() : null;
      this.url = null != context ? context.getUrl() : null;
      this.templateManagementUrl = null != context ? context.getTemplateManagementUrl() : null;
    }

    /**
     * Set region to be used for Conversation service
     *
     * @param region The region
     * @return Current builder
     * @since 1.0
     */
    public Builder setRegion(ConversationRegion region) {
      this.region = region;
      return this;
    }

    /**
     * Set Conversation URL to be used
     *
     * @param url Conversation URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set URL dedicated to template management to be used
     *
     * @param templateManagementUrl Template Management URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setTemplateManagementUrl(String templateManagementUrl) {
      this.templateManagementUrl = templateManagementUrl;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public ConversationContext build() {

      return new ConversationContext(region, url, templateManagementUrl);
    }
  }
}
