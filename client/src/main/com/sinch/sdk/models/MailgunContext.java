package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.ConversationContext.Builder;

/**
 * Execution context related to Mailgun domains
 *
 * @since __TO_BE_DEFINED__
 */
public class MailgunContext {

  MailgunRegion region;
  private final String url;

  private MailgunContext(MailgunRegion region, String url) {
    this.region = region;
    this.url = url;
  }

  /**
   * Mailgun region
   *
   * @return Selected Region
   * @since __TO_BE_DEFINED__
   */
  public MailgunRegion getRegion() {
    return region;
  }

  /**
   * Mailgun Server Configuration
   *
   * @return Mailgun Server configuration to be used
   * @since __TO_BE_DEFINED__
   */
  public ServerConfiguration getServer() {
    return new ServerConfiguration(getUrl());
  }

  /**
   * Mailgun URL
   *
   * @return Mailgun Server URL
   * @since __TO_BE_DEFINED__
   */
  public String getUrl() {
    return url;
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since __TO_BE_DEFINED__
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder
   *
   * @param context Source context to fill initial builder state
   * @return New Builder instance
   * @since __TO_BE_DEFINED__
   */
  public static Builder builder(MailgunContext context) {
    return new Builder(context);
  }

  /**
   * Dedicated Builder
   *
   * @since __TO_BE_DEFINED__
   */
  public static class Builder {

    MailgunRegion region;
    String url;

    protected Builder() {}

    protected Builder(MailgunContext context) {
      this.region = null != context ? context.getRegion() : null;
      this.url = null != context ? context.getUrl() : null;
    }

    /**
     * Set region to be used for Mailgun service
     *
     * @param region The region
     * @return Current builder
     * @since 1.0
     */
    public Builder setRegion(MailgunRegion region) {
      this.region = region;
      return this;
    }

    /**
     * Set Mailgun API URL
     *
     * @param url Mailgun API URL
     * @return Current builder
     * @since __TO_BE_DEFINED__
     */
    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since __TO_BE_DEFINED__
     */
    public MailgunContext build() {

      return new MailgunContext(region, url);
    }
  }
}
