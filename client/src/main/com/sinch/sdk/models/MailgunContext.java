package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Execution context related to Mailgun domains
 *
 * @since 1.6
 */
public class MailgunContext {

  private final MailgunRegion region;
  private final String url;
  private final Collection<String> storageUrls;
  private final Boolean regionAsDefault;

  private MailgunContext(
      MailgunRegion region, String url, Collection<String> storageUrls, Boolean regionAsDefault) {
    this.region = region;
    this.url = url;
    this.storageUrls = null == storageUrls ? Collections.emptyList() : storageUrls;
    this.regionAsDefault = regionAsDefault;
  }

  /**
   * Mailgun region
   *
   * @return Selected Region
   * @since 1.6
   */
  public MailgunRegion getRegion() {
    return region;
  }

  /**
   * Mailgun Server Configuration
   *
   * @return Mailgun Server configuration to be used
   * @since 1.6
   */
  public ServerConfiguration getServer() {
    return new ServerConfiguration(getUrl());
  }

  /**
   * Mailgun Storage Servers Configuration
   *
   * @return Mailgun Storage Server configuration to be used
   * @since 1.6
   */
  public Collection<ServerConfiguration> getStorageServers() {
    return storageUrls.stream().map(ServerConfiguration::new).collect(Collectors.toList());
  }

  /**
   * Mailgun URL
   *
   * @return Mailgun Server URL
   * @since 1.6
   */
  public String getUrl() {
    return url;
  }

  /**
   * Mailgun Storage URLs
   *
   * @return Mailgun Storage Server URLs
   * @since 1.6
   */
  public Collection<String> getStorageUrls() {
    return storageUrls;
  }

  /**
   * @deprecated Helper for transition period until 2.0 release
   */
  @Deprecated
  public Boolean getRegionAsDefault() {
    return regionAsDefault;
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 1.6
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder
   *
   * @param context Source context to fill initial builder state
   * @return New Builder instance
   * @since 1.6
   */
  public static Builder builder(MailgunContext context) {
    return new Builder(context);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.6
   */
  public static class Builder {

    MailgunRegion region;
    String url;
    Collection<String> storageUrls;
    Boolean regionAsDefault;

    protected Builder() {}

    protected Builder(MailgunContext context) {
      this.region = null != context ? context.getRegion() : null;
      this.url = null != context ? context.getUrl() : null;
      this.storageUrls = null != context ? context.getStorageUrls() : null;
      this.regionAsDefault = null != context ? context.getRegionAsDefault() : null;
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
     * @since 1.6
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
     * @since 1.6
     */
    public Builder setStorageUrls(Collection<String> storageUrls) {
      this.storageUrls = storageUrls;
      return this;
    }

    public MailgunRegion getRegion() {
      return region;
    }

    public String getUrl() {
      return url;
    }

    public Collection<String> getStorageUrls() {
      return storageUrls;
    }

    public Boolean getRegionAsDefault() {
      return regionAsDefault;
    }

    /**
     * @deprecated Helper for transition period until 2.0 release
     */
    public Builder setRegionAsDefault(Boolean regionAsDefault) {
      this.regionAsDefault = regionAsDefault;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.6
     */
    public MailgunContext build() {

      return new MailgunContext(region, url, storageUrls, regionAsDefault);
    }
  }
}
