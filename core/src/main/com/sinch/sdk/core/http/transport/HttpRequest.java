package com.sinch.sdk.core.http.transport;

import com.sinch.sdk.core.http.HttpMethod;
import java.util.Objects;
import java.util.Optional;

/**
 * HTTP request sent by an {@link HttpTransport}.
 *
 * <p>The request is sent as is: the URL and the query parameters are not encoded, and the headers
 * expected by the server (<code>accept</code>, <code>content-type</code>, ...) have to be set by
 * the caller.
 *
 * @since 2.4
 */
public final class HttpRequest {

  private final HttpMethod method;
  private final String url;
  private final String queryParameters;
  private final HttpHeaders headers;
  private final HttpContent content;

  private HttpRequest(
      HttpMethod method,
      String url,
      String queryParameters,
      HttpHeaders headers,
      HttpContent content) {
    this.method = method;
    this.url = url;
    this.queryParameters = queryParameters;
    this.headers = headers;
    this.content = content;
  }

  /**
   * HTTP method
   *
   * @return Method of the request
   * @since 2.4
   */
  public HttpMethod getMethod() {
    return method;
  }

  /**
   * URL of the request, without query parameters
   *
   * @return Absolute URL
   * @since 2.4
   */
  public String getUrl() {
    return url;
  }

  /**
   * Query parameters, already serialized and encoded, including the leading <code>?</code>
   *
   * @return Query parameters appended to the URL as is
   * @since 2.4
   */
  public Optional<String> getQueryParameters() {
    return Optional.ofNullable(queryParameters);
  }

  /**
   * Headers of the request
   *
   * @return Headers. Not to be modified: use {@link #builder(HttpRequest)} to change them
   * @since 2.4
   */
  public HttpHeaders getHeaders() {
    return headers;
  }

  /**
   * Content of the request
   *
   * @return Content, empty when the request has no body
   * @since 2.4
   */
  public Optional<HttpContent> getContent() {
    return Optional.ofNullable(content);
  }

  @Override
  public String toString() {
    return "HttpRequest{"
        + "method="
        + method
        + ", url='"
        + url
        + '\''
        + ", queryParameters='"
        + queryParameters
        + '\''
        + ", headers="
        + headers
        + ", content="
        + content
        + '}';
  }

  /**
   * Getting Builder
   *
   * @return New Builder instance
   * @since 2.4
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Getting Builder pre-populated from an existing instance
   *
   * @param request Source request to fill initial builder state
   * @return New Builder instance
   * @since 2.4
   */
  public static Builder builder(HttpRequest request) {
    return new Builder(request);
  }

  /**
   * Dedicated Builder
   *
   * @since 2.4
   */
  public static final class Builder {

    private HttpMethod method;
    private String url;
    private String queryParameters;
    private HttpHeaders headers = new HttpHeaders();
    private HttpContent content;

    private Builder() {}

    private Builder(HttpRequest request) {
      Objects.requireNonNull(request, "request");
      this.method = request.method;
      this.url = request.url;
      this.queryParameters = request.queryParameters;
      this.headers = request.headers;
      this.content = request.content;
    }

    /**
     * See {@link HttpRequest#getMethod()} getter
     *
     * @param method see getter
     * @return Current builder
     * @since 2.4
     */
    public Builder setMethod(HttpMethod method) {
      this.method = method;
      return this;
    }

    /**
     * See {@link HttpRequest#getUrl()} getter
     *
     * @param url see getter
     * @return Current builder
     * @since 2.4
     */
    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    /**
     * See {@link HttpRequest#getQueryParameters()} getter
     *
     * @param queryParameters see getter. When not empty, it must start with <code>?</code>
     * @return Current builder
     * @since 2.4
     */
    public Builder setQueryParameters(String queryParameters) {
      this.queryParameters = queryParameters;
      return this;
    }

    /**
     * See {@link HttpRequest#getHeaders()} getter
     *
     * @param headers see getter. The headers are copied
     * @return Current builder
     * @since 2.4
     */
    public Builder setHeaders(HttpHeaders headers) {
      this.headers = null == headers ? new HttpHeaders() : headers;
      return this;
    }

    /**
     * See {@link HttpRequest#getContent()} getter
     *
     * @param content see getter
     * @return Current builder
     * @since 2.4
     */
    public Builder setContent(HttpContent content) {
      this.content = content;
      return this;
    }

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     * @since 2.4
     */
    public HttpRequest build() {
      Objects.requireNonNull(method, "method");
      Objects.requireNonNull(url, "url");
      if (null != queryParameters
          && !queryParameters.isEmpty()
          && !queryParameters.startsWith("?")) {
        throw new IllegalArgumentException(
            "Query parameters must start with '?': '" + queryParameters + "'");
      }
      return new HttpRequest(method, url, queryParameters, new HttpHeaders(headers), content);
    }
  }
}
