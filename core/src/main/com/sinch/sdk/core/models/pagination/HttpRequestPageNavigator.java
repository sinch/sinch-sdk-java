package com.sinch.sdk.core.models.pagination;

import com.sinch.sdk.core.http.HttpRequest;

public class HttpRequestPageNavigator extends PageNavigator<HttpRequest> {

  private final HttpRequest nextPageRequest;

  public HttpRequestPageNavigator(HttpRequest nextPageRequest) {
    super(null);
    this.nextPageRequest = nextPageRequest;
  }

  private HttpRequest computeNextPageCursor() {
    return nextPageRequest;
  }

  @Override
  public HttpRequest getToken() {
    return computeNextPageCursor();
  }

  @Override
  public String toString() {
    return "HttpRequestPageNavigator{"
        + "nextPageRequest="
        + nextPageRequest
        + "} "
        + super.toString();
  }
}
