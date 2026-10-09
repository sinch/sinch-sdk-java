package com.sinch.sdk.core.http;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class HttpRequest {

  private final String fullUrl;
  private final String path;
  private final HttpMethod method;
  private final Collection<URLParameter> queryParameters;
  private final String body;
  private final Map<String, String> headerParams;
  private final Collection<String> accept;
  private final Collection<String> contentType;
  private final Collection<String> authNames;
  private final Map<String, Object> formParams;
  private final boolean idempotent;

  public HttpRequest(
      String fullUrl,
      HttpMethod method,
      String body,
      Map<String, String> headerParams,
      Collection<String> accept,
      Collection<String> contentType,
      Collection<String> authNames) {
    this.fullUrl = fullUrl;
    this.path = null;
    this.method = method;
    this.queryParameters = null;
    this.body = body;
    this.headerParams = headerParams;
    this.accept = accept;
    this.contentType = contentType;
    this.authNames = authNames;
    this.formParams = null;
    this.idempotent = false;
  }

  public HttpRequest(
      String path,
      HttpMethod method,
      Collection<URLParameter> queryParameters,
      String body,
      Map<String, String> headerParams,
      Collection<String> accept,
      Collection<String> contentType,
      Collection<String> authNames) {
    this(path, method, queryParameters, body, headerParams, accept, contentType, authNames, false);
  }

  /**
   * Request to an operation that accepts an <code>Idempotency-Key</code> header
   *
   * @param path Path of the operation
   * @param method HTTP method
   * @param queryParameters Query parameters
   * @param body Serialized body
   * @param headerParams Headers, with the key set by the user if any
   * @param accept Accepted content types
   * @param contentType Content type of the body
   * @param authNames Authentication schemes
   * @param idempotent <code>true</code> when the operation accepts an <code>Idempotency-Key
   *     </code> header: the transport then generates one if the user did not set it
   * @since 2.3
   */
  public HttpRequest(
      String path,
      HttpMethod method,
      Collection<URLParameter> queryParameters,
      String body,
      Map<String, String> headerParams,
      Collection<String> accept,
      Collection<String> contentType,
      Collection<String> authNames,
      boolean idempotent) {
    this.fullUrl = null;
    this.path = path;
    this.method = method;
    this.queryParameters = queryParameters;
    this.body = body;
    this.headerParams = headerParams;
    this.accept = accept;
    this.contentType = contentType;
    this.authNames = authNames;
    this.formParams = null;
    this.idempotent = idempotent;
  }

  public HttpRequest(
      String path,
      HttpMethod method,
      Collection<URLParameter> queryParameters,
      Map<String, Object> formParams,
      Map<String, String> headerParams,
      Collection<String> accept,
      Collection<String> contentType,
      Collection<String> authNames) {
    this.fullUrl = null;
    this.path = path;
    this.method = method;
    this.queryParameters = queryParameters;
    this.formParams = formParams;
    this.headerParams = headerParams;
    this.accept = accept;
    this.contentType = contentType;
    this.authNames = authNames;
    this.body = null;
    this.idempotent = false;
  }

  public Optional<String> getFullUrl() {
    return Optional.ofNullable(fullUrl);
  }

  public Optional<String> getPath() {
    return Optional.ofNullable(path);
  }

  public HttpMethod getMethod() {
    return method;
  }

  public Collection<URLParameter> getQueryParameters() {
    return queryParameters;
  }

  public String getBody() {
    return body;
  }

  public Map<String, String> getHeaderParams() {
    return headerParams;
  }

  public Collection<String> getAccept() {
    return accept;
  }

  public Collection<String> getContentType() {
    return contentType;
  }

  public Collection<String> getAuthNames() {
    return authNames;
  }

  public Map<String, Object> getFormParams() {
    return formParams;
  }

  /**
   * Whether the operation accepts an <code>Idempotency-Key</code> header
   *
   * @return <code>true</code> when the transport has to generate a key if none is set
   * @since 2.3
   */
  public boolean isIdempotent() {
    return idempotent;
  }
}
