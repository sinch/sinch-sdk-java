package com.sinch.sdk.http;

import com.sinch.sdk.core.http.transport.HttpHeaders;
import java.util.Map;
import java.util.Optional;

/**
 * Optional parameters of a call of the {@link SinchHttpClient}: query parameters, headers and
 * request level options.
 *
 * @since 2.5
 */
public class HttpCallParameters {

  private final String queryParameters;
  private final HttpHeaders headers;
  private final HttpRequestOptions options;

  private HttpCallParameters(
      String queryParameters, HttpHeaders headers, HttpRequestOptions options) {
    this.queryParameters = queryParameters;
    this.headers = headers;
    this.options = options;
  }

  /**
   * Query parameters, already serialized and URL encoded, e.g. <code>?pageSize=5&amp;regionCode=US
   * </code>. They are appended to the URL as is: the SDK does not encode them
   *
   * @return Query parameters, with or without the leading <code>?</code>
   * @since 2.5
   */
  public Optional<String> getQueryParameters() {
    return Optional.ofNullable(queryParameters);
  }

  /**
   * Headers of the request. The headers expected by the server (<code>accept</code>, <code>
   * content-type</code>, ...) have to be set by the caller. <code>User-Agent</code> is set by the
   * SDK, and so is <code>Authorization</code> when the call is authenticated
   *
   * @return Copy of the headers
   * @since 2.5
   */
  public Optional<HttpHeaders> getHeaders() {
    return Optional.ofNullable(headers).map(HttpHeaders::new);
  }

  /**
   * Request level options
   *
   * @return Options overriding the client settings for this call
   * @since 2.5
   */
  public Optional<HttpRequestOptions> getOptions() {
    return Optional.ofNullable(options);
  }

  @Override
  public String toString() {
    return "HttpCallParameters{"
        + "queryParameters='"
        + queryParameters
        + '\''
        + ", headers="
        + headers
        + ", options="
        + options
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
   * @param parameters Source parameters to fill initial builder state
   * @return New Builder instance
   * @since 2.5
   */
  public static Builder builder(HttpCallParameters parameters) {
    return new Builder(parameters);
  }

  /**
   * Dedicated Builder
   *
   * @since 2.5
   */
  public static class Builder {

    private String queryParameters;
    private HttpHeaders headers;
    private HttpRequestOptions options;

    protected Builder() {}

    protected Builder(HttpCallParameters parameters) {
      if (null == parameters) {
        return;
      }
      this.queryParameters = parameters.queryParameters;
      this.headers = parameters.headers;
      this.options = parameters.options;
    }

    /**
     * See {@link HttpCallParameters#getQueryParameters()} getter
     *
     * @param queryParameters see getter
     * @return Current builder
     * @since 2.5
     */
    public Builder setQueryParameters(String queryParameters) {
      this.queryParameters = queryParameters;
      return this;
    }

    /**
     * See {@link HttpCallParameters#getHeaders()} getter
     *
     * @param headers see getter. The headers are copied
     * @return Current builder
     * @since 2.5
     */
    public Builder setHeaders(HttpHeaders headers) {
      this.headers = null == headers ? null : new HttpHeaders(headers);
      return this;
    }

    /**
     * See {@link HttpCallParameters#getHeaders()} getter
     *
     * <p>Convenience to set one value per header. Use {@link #setHeaders(HttpHeaders)} to send a
     * header with several values.
     *
     * @param headers see getter, as header names to their value. A <code>null</code> value is
     *     ignored. The headers are copied
     * @return Current builder
     * @since 2.5
     */
    public Builder setHeaders(Map<String, String> headers) {
      if (null == headers) {
        this.headers = null;
        return this;
      }
      HttpHeaders copy = new HttpHeaders();
      headers.forEach(
          (name, value) -> {
            if (null != value) {
              copy.add(name, value);
            }
          });
      this.headers = copy;
      return this;
    }

    /**
     * See {@link HttpCallParameters#getOptions()} getter
     *
     * @param options see getter
     * @return Current builder
     * @since 2.5
     */
    public Builder setOptions(HttpRequestOptions options) {
      this.options = options;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 2.5
     */
    public HttpCallParameters build() {
      return new HttpCallParameters(queryParameters, headers, options);
    }
  }
}
