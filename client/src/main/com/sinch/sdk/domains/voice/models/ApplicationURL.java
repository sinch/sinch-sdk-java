package com.sinch.sdk.domains.voice.models;

/** primary and if configured fallback callback URLs for an application */
public class ApplicationURL {

  private final String primary;
  private final String fallback;

  private ApplicationURL(String primary, String fallback) {
    this.primary = primary;
    this.fallback = fallback;
  }

  /**
   * Primary callback URL for application
   *
   * @return callback URL value
   * @since 1.0
   */
  public String getPrimary() {
    return primary;
  }

  /**
   * Fallback callback URL (returned if configured).
   *
   * <p>It is used only if Sinch platform gets a timeout or error from your primary callback URL.
   *
   * @return callback URL value
   * @since 1.0
   */
  public String getFallback() {
    return fallback;
  }

  @Override
  public String toString() {
    return "ApplicationURL{"
        + "primary='"
        + primary
        + '\''
        + ", fallback='"
        + fallback
        + '\''
        + '}';
  }

  /**
   * Create a builder instance
   *
   * @return Dedicated builder
   */
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String primary;
    String fallback;

    /**
     * @param primary The primary URL to be used
     * @return Current builder
     * @see ApplicationURL#getPrimary() getter
     */
    public Builder setPrimary(String primary) {
      this.primary = primary;
      return this;
    }

    /**
     * @param fallback The fallback URL to be used
     * @return Current builder
     * @see ApplicationURL#getFallback() () getter
     */
    public Builder setFallback(String fallback) {
      this.fallback = fallback;
      return this;
    }

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public ApplicationURL build() {
      return new ApplicationURL(primary, fallback);
    }
  }
}
