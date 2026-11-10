package com.sinch.sdk.http;

import com.sinch.sdk.models.RetryConfiguration;
import com.sinch.sdk.models.TransportSettings;
import java.util.Optional;

/**
 * Settings of a single call of the {@link SinchHttpClient}, overriding the ones of the client.
 *
 * <p>A setting left unset uses the value of the client: {@link TransportSettings} and {@link
 * RetryConfiguration} of the {@link com.sinch.sdk.models.Configuration}.
 *
 * @since 2.5
 */
public class HttpRequestOptions {

  private final Boolean useSinchAuth;
  private final Integer timeoutSeconds;
  private final RetryConfiguration retryConfiguration;

  private HttpRequestOptions(
      Boolean useSinchAuth, Integer timeoutSeconds, RetryConfiguration retryConfiguration) {
    this.useSinchAuth = useSinchAuth;
    this.timeoutSeconds = timeoutSeconds;
    this.retryConfiguration = retryConfiguration;
  }

  /**
   * Whether the call is authenticated by the SDK. See {@link SinchHttpClient} for the scheme used
   *
   * @return <code>true</code> to inject the <code>Authorization</code> header, <code>false</code>
   *     to send the request without it. Empty to use {@link TransportSettings#getUseSinchAuth()}
   * @since 2.5
   */
  public Optional<Boolean> getUseSinchAuth() {
    return Optional.ofNullable(useSinchAuth);
  }

  /**
   * Timeout of the call
   *
   * @return Timeout in seconds, zero when disabled. Empty to use {@link
   *     TransportSettings#getTimeoutSeconds()}
   * @since 2.5
   */
  public Optional<Integer> getTimeoutSeconds() {
    return Optional.ofNullable(timeoutSeconds);
  }

  /**
   * Retry policy applied to the rate-limited (HTTP 429) responses of the call
   *
   * @return Policy replacing the whole client one. Empty to use the client one
   * @since 2.5
   */
  public Optional<RetryConfiguration> getRetryConfiguration() {
    return Optional.ofNullable(retryConfiguration);
  }

  @Override
  public String toString() {
    return "HttpRequestOptions{"
        + "useSinchAuth="
        + useSinchAuth
        + ", timeoutSeconds="
        + timeoutSeconds
        + ", retryConfiguration="
        + retryConfiguration
        + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 2.5
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder pre-populated from an existing instance
   *
   * @param options Source options to fill initial builder state
   * @return New Builder instance
   * @since 2.5
   */
  public static Builder builder(HttpRequestOptions options) {
    return new Builder(options);
  }

  /**
   * Dedicated Builder
   *
   * @since 2.5
   */
  public static class Builder {

    private Boolean useSinchAuth;
    private Integer timeoutSeconds;
    private RetryConfiguration retryConfiguration;

    protected Builder() {}

    protected Builder(HttpRequestOptions options) {
      if (null == options) {
        return;
      }
      this.useSinchAuth = options.useSinchAuth;
      this.timeoutSeconds = options.timeoutSeconds;
      this.retryConfiguration = options.retryConfiguration;
    }

    /**
     * See {@link HttpRequestOptions#getUseSinchAuth()} getter
     *
     * @param useSinchAuth see getter, <code>null</code> to use the client setting
     * @return Current builder
     * @since 2.5
     */
    public Builder setUseSinchAuth(Boolean useSinchAuth) {
      this.useSinchAuth = useSinchAuth;
      return this;
    }

    /**
     * See {@link HttpRequestOptions#getTimeoutSeconds()} getter
     *
     * @param timeoutSeconds see getter, zero to disable it, <code>null</code> to use the client
     *     setting
     * @return Current builder
     * @since 2.5
     */
    public Builder setTimeoutSeconds(Integer timeoutSeconds) {
      this.timeoutSeconds = timeoutSeconds;
      return this;
    }

    /**
     * See {@link HttpRequestOptions#getRetryConfiguration()} getter
     *
     * @param retryConfiguration see getter, <code>null</code> to use the client setting
     * @return Current builder
     * @since 2.5
     */
    public Builder setRetryConfiguration(RetryConfiguration retryConfiguration) {
      this.retryConfiguration = retryConfiguration;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 2.5
     */
    public HttpRequestOptions build() {
      if (null != timeoutSeconds && timeoutSeconds < 0) {
        throw new IllegalArgumentException(
            "HttpRequestOptions: timeoutSeconds must be zero or greater, got: " + timeoutSeconds);
      }
      return new HttpRequestOptions(useSinchAuth, timeoutSeconds, retryConfiguration);
    }
  }
}
