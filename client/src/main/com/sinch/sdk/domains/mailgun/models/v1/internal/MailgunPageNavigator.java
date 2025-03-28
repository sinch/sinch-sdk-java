package com.sinch.sdk.domains.mailgun.models.v1.internal;

import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.models.pagination.PageNavigator;

public class MailgunPageNavigator extends PageNavigator<HttpRequest> {

  private final HttpRequest nextPageRequest;

  public MailgunPageNavigator(HttpRequest nextPageRequest) {
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
    return "MailgunPageNavigator{" + "nextPageRequest=" + nextPageRequest + "} " + super.toString();
  }
}
