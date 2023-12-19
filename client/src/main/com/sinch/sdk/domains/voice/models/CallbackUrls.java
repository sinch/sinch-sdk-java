package com.sinch.sdk.domains.voice.models;

/**
 * Returns any callback URLs configured for the specified application
 *
 * @since 1.0
 */
public class CallbackUrls {
  private final ApplicationURL url;

  private CallbackUrls(ApplicationURL url) {
    this.url = url;
  }

  /**
   * Associated application URL
   *
   * @return The URL
   * @since 1.0
   */
  public ApplicationURL getUrl() {
    return url;
  }

  @Override
  public String toString() {
    return "CallbackUrls{" + "url=" + url + '}';
  }

  /**
   * Create a builder instance
   *
   * @return Dedicated builder
   * @since 1.0
   */
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    ApplicationURL url;

    /**
     * @param url the numbers list
     * @return Current builder
     * @see CallbackUrls#getUrl() getter
     */
    public Builder setUrl(ApplicationURL url) {
      this.url = url;
      return this;
    }

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public CallbackUrls build() {
      return new CallbackUrls(url);
    }
  }
}
