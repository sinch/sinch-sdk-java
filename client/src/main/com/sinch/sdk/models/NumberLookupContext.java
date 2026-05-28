package com.sinch.sdk.models;

import com.sinch.sdk.core.models.ServerConfiguration;

/** Execution context related to Number Lookup domain */
public class NumberLookupContext {

  private final String numberLookupUrl;

  private NumberLookupContext(String numberLookupUrl) {
    this.numberLookupUrl = numberLookupUrl;
  }

  /**
   * Number Lookup Server Configuration
   *
   * @return Number Lookup Server configuration to be used
   * @since 2.1
   */
  public ServerConfiguration getNumberLookupServer() {
    return new ServerConfiguration(getNumberLookupUrl());
  }

  /**
   * Number Lookup URL
   *
   * @return Number Lookup Server URL
   * @since 2.1
   */
  public String getNumberLookupUrl() {
    return numberLookupUrl;
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 2.1
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder
   *
   * @param context Source context to fill initial builder state
   * @return New Builder instance
   * @since 2.1
   */
  public static Builder builder(NumberLookupContext context) {
    return new Builder(context);
  }

  /**
   * Dedicated Builder
   *
   * @since 2.1
   */
  public static class Builder {

    String numberLookupUrl;

    protected Builder() {}

    protected Builder(NumberLookupContext context) {
      this.numberLookupUrl = null != context ? context.getNumberLookupUrl() : null;
    }

    /**
     * Set Number Lookup API URL
     *
     * @param numberLookupUrl Number Lookup API URL
     * @return Current builder
     * @since 2.1
     */
    public Builder setNumberLookupUrl(String numberLookupUrl) {
      this.numberLookupUrl = numberLookupUrl;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 2.1
     */
    public NumberLookupContext build() {

      return new NumberLookupContext(numberLookupUrl);
    }
  }
}
