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
}
