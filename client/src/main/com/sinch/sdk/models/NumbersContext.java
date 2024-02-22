package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.UnifiedCredentials.Builder;

/** Execution context related to Numbers domains */
public class NumbersContext {

  private final String numbersUrl;

  private NumbersContext(String numbersUrl) {
    this.numbersUrl = numbersUrl;
  }

  /**
   * Numbers Server Configuration
   *
   * @return Numbers Server configuration to be used
   * @since 1.0
   */
  public ServerConfiguration getNumbersServer() {
    return new ServerConfiguration(getNumbersUrl());
  }

  /**
   * Numbers URL
   *
   * @return Numbers Server URL
   * @since 1.0
   */
  public String getNumbersUrl() {
    return numbersUrl;
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
   * @param context Source context to fill initial builder state
   * @return New Builder instance
   * @since 1.0
   */
  public static Builder builder(NumbersContext context) {
    return new Builder(context);
  }

  /**
   * Dedicated Builder
   *
   * @since 1.0
   */
  public static class Builder {

    String numbersUrl;

    protected Builder() {}

    protected Builder(NumbersContext context) {
      this.numbersUrl = null != context ? context.getNumbersUrl() : null;
    }

    /**
     * Set Numbers API URL
     *
     * @param numbersUrl Numbers API URL
     * @return Current builder
     * @since 1.0
     */
    public Builder setNumbersUrl(String numbersUrl) {
      this.numbersUrl = numbersUrl;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 1.0
     */
    public NumbersContext build() {

      return new NumbersContext(numbersUrl);
    }
  }
}
