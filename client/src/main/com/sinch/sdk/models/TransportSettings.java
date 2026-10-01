package com.sinch.sdk.models;

/**
 * Transport level settings applied to every request the SDK sends.
 *
 * @since 2.3
 */
public class TransportSettings {

  /** Timeout applied to HTTP I/O operations when none is configured. */
  public static final int DEFAULT_TIMEOUT_SECONDS = 60;

  /** Sinch authentication is performed for the endpoints supporting it when none is configured. */
  public static final boolean DEFAULT_USE_SINCH_AUTH = true;

  /**
   * Settings holding the default of every field: {@link #DEFAULT_TIMEOUT_SECONDS} and {@link
   * #DEFAULT_USE_SINCH_AUTH}.
   *
   * @since 2.3
   */
  public static final TransportSettings DEFAULTS =
      builder()
          .setTimeoutSeconds(DEFAULT_TIMEOUT_SECONDS)
          .setUseSinchAuth(DEFAULT_USE_SINCH_AUTH)
          .build();

  private final int timeoutSeconds;
  private final boolean useSinchAuth;

  private TransportSettings(int timeoutSeconds, boolean useSinchAuth) {
    this.timeoutSeconds = timeoutSeconds;
    this.useSinchAuth = useSinchAuth;
  }

  /**
   * Timeout applied to HTTP I/O operations. Zero disables it.
   *
   * @return Timeout in seconds
   * @since 2.3
   */
  public int getTimeoutSeconds() {
    return timeoutSeconds;
  }

  /**
   * Whether the endpoints supporting it authenticate against the Sinch auth server.
   *
   * @return {@code true} when Sinch authentication is enabled, {@code false} when it is disabled
   * @since 2.3
   */
  public boolean getUseSinchAuth() {
    return useSinchAuth;
  }

  @Override
  public String toString() {
    return "TransportSettings{"
        + "timeoutSeconds="
        + timeoutSeconds
        + ", useSinchAuth="
        + useSinchAuth
        + '}';
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
   * Getting Builder pre-populated from an existing instance
   *
   * @param settings Source settings to fill initial builder state
   * @return New Builder instance
   * @since 2.3
   */
  public static Builder builder(TransportSettings settings) {
    return new Builder(settings);
  }

  /**
   * Dedicated Builder
   *
   * @since 2.3
   */
  public static class Builder {

    private Integer timeoutSeconds;
    private Boolean useSinchAuth;

    protected Builder() {}

    protected Builder(TransportSettings settings) {
      if (null == settings) {
        return;
      }
      this.timeoutSeconds = settings.timeoutSeconds;
      this.useSinchAuth = settings.useSinchAuth;
    }

    /**
     * Set the timeout applied to HTTP I/O operations. Zero disables it.
     *
     * @param timeoutSeconds Timeout in seconds, zero to disable it
     * @return Current builder
     * @see TransportSettings#getTimeoutSeconds() getter
     * @since 2.3
     */
    public Builder setTimeoutSeconds(Integer timeoutSeconds) {
      this.timeoutSeconds = timeoutSeconds;
      return this;
    }

    /**
     * Set whether the endpoints supporting it authenticate against the Sinch auth server
     *
     * @param useSinchAuth {@code true} (default) to authenticate with a Sinch access token, {@code
     *     false} to disable Sinch authentication
     * @return Current builder
     * @see TransportSettings#getUseSinchAuth() getter
     * @since 2.3
     */
    public Builder setUseSinchAuth(Boolean useSinchAuth) {
      this.useSinchAuth = useSinchAuth;
      return this;
    }

    /**
     * Build a {@link TransportSettings} instance from builder current state
     *
     * @return TransportSettings instance built from current builder state
     * @since 2.3
     */
    public TransportSettings build() {
      if (null != timeoutSeconds && timeoutSeconds < 0) {
        throw new IllegalArgumentException(
            "TransportSettings: timeoutSeconds must be zero or greater, got: " + timeoutSeconds);
      }
      return new TransportSettings(
          null != timeoutSeconds ? timeoutSeconds : DEFAULT_TIMEOUT_SECONDS,
          null != useSinchAuth ? useSinchAuth : DEFAULT_USE_SINCH_AUTH);
    }
  }
}
