package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.ConversationContext.Builder;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Execution context related to Mailgun domains
 *
 * @since __TO_BE_DEFINED__
 */
public class MailgunContext {

  private final MailgunRegion region;
  private final String url;
  private final Collection<String> storageUrls;

  private MailgunContext(MailgunRegion region, String url, Collection<String> storageUrls) {
    this.region = region;
    this.url = url;
    this.storageUrls = storageUrls;
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
   * Mailgun Storage Servers Configuration
   *
   * @return Mailgun Storage Server configuration to be used
   * @since __TO_BE_DEFINED__
   */
  public Collection<ServerConfiguration> getStorageServers() {
    return storageUrls.stream().map(ServerConfiguration::new).collect(Collectors.toList());
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
   * Mailgun Storage URLs
   *
   * @return Mailgun Storage Server URLs
   * @since __TO_BE_DEFINED__
   */
  public Collection<String> getStorageUrls() {
    return storageUrls;
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
    Collection<String> storageUrls;

    protected Builder() {}

    protected Builder(MailgunContext context) {
      this.region = null != context ? context.getRegion() : null;
      this.url = null != context ? context.getUrl() : null;
      this.storageUrls = null != context ? context.getStorageUrls() : null;
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
     * Set Mailgun Storage URLs
     *
     * @param storageUrls List of storage URLs
     * @return Current builder
     * @since __TO_BE_DEFINED__
     */
    public Builder setStorageUrls(Collection<String> storageUrls) {
      this.storageUrls = storageUrls;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since __TO_BE_DEFINED__
     */
    public MailgunContext build() {

      return new MailgunContext(region, url, storageUrls);
    }
  }
}