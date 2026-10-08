package com.sinch.sdk.domains.voice.api.v2.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.voice.models.v2.PaginationLinks;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;

/** Follows the <code>links.next</code> URL of Voice v2 list responses */
final class PaginationLinksHelper {

  private PaginationLinksHelper() {}

  /**
   * Build the request for the page after the current one
   *
   * @param serverConfiguration Server the request is sent to
   * @param links Links of the current page
   * @return The request for the next page, or <code>null</code> on the last page
   * @throws ApiException if the next link is not a valid URI
   */
  static HttpRequest nextPageRequest(ServerConfiguration serverConfiguration, PaginationLinks links)
      throws ApiException {

    String nextLink = null != links ? links.getNext() : null;
    if (StringUtil.isEmpty(nextLink)) {
      return null;
    }

    // The API serves "next" as an absolute URL: its path and query are followed as they are, but
    // against the configured server, so that credentials are never sent to a host taken from a
    // response
    URI next;
    URI server;
    try {
      next = new URI(nextLink);
      server = new URI(serverConfiguration.getUrl());
    } catch (URISyntaxException e) {
      throw new ApiException("Invalid next page link: " + nextLink, e);
    }

    String fullUrl =
        server.getScheme()
            + "://"
            + server.getRawAuthority()
            + next.getRawPath()
            + (null != next.getRawQuery() ? "?" + next.getRawQuery() : "");

    return new HttpRequest(
        fullUrl,
        HttpMethod.GET,
        null,
        new HashMap<>(),
        Arrays.asList("application/json", "application/problem+json"),
        Arrays.asList(),
        Arrays.asList("BasicAuth", "SinchOAuth2"));
  }
}
