package com.sinch.sdk.http;

import static com.sinch.sdk.core.http.HttpContentType.CONTENT_TYPE_HEADER;
import static com.sinch.sdk.core.http.URLParameterUtils.encodeParametersAsString;

import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.transport.HttpContent;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpRequest;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import java.net.URI;
import java.util.Collection;
import java.util.Map;

/**
 * Maps the requests built by the SDK services onto the {@link HttpRequest} sent by an {@link
 * com.sinch.sdk.core.http.transport.HttpTransport}, and the {@link HttpResponse} it receives back
 * onto the responses consumed by the SDK services.
 */
final class TransportRequestMapper {

  static final String ACCEPT_HEADER = "Accept";

  private TransportRequestMapper() {}

  /**
   * @param serverConfiguration Server the request path is relative to
   * @param request Request built by an SDK service
   * @param headerParams Headers of the request
   * @param additionalHeaders Headers added onto every request (e.g. <code>User-Agent</code>)
   * @return Request to be sent, without authorization headers
   */
  static HttpRequest toTransportRequest(
      ServerConfiguration serverConfiguration,
      com.sinch.sdk.core.http.HttpRequest request,
      Map<String, String> headerParams,
      Map<String, String> additionalHeaders) {

    String target =
        request.getFullUrl().orElse(serverConfiguration.getUrl() + request.getPath().orElse(""));
    Collection<URLParameter> queryParameters = request.getQueryParameters();
    if (null != queryParameters && !queryParameters.isEmpty()) {
      target = target + "?" + encodeParametersAsString(queryParameters);
    }

    int queryIndex = target.indexOf('?');
    HttpRequest.Builder builder =
        HttpRequest.builder()
            .setMethod(request.getMethod())
            .setUrl(queryIndex < 0 ? target : target.substring(0, queryIndex))
            .setQueryParameters(queryIndex < 0 ? null : target.substring(queryIndex));

    // headers are set in this order, a header set later replacing a former one with the same name
    HttpHeaders headers = new HttpHeaders();
    setCollectionHeader(headers, ACCEPT_HEADER, request.getAccept());
    setHeaders(headers, headerParams);
    setHeaders(headers, additionalHeaders);

    if (null != request.getBody()) {
      setCollectionHeader(headers, CONTENT_TYPE_HEADER, request.getContentType());
      builder.setContent(HttpContent.ofString(request.getBody()));
    } else if (null != request.getFormParams()) {
      builder.setContent(HttpContent.ofFormData(request.getFormParams()));
    }

    return builder.setHeaders(headers).build();
  }

  /**
   * @param response Response received by the transport
   * @return Response to be consumed by the SDK services
   */
  static com.sinch.sdk.core.http.HttpResponse toServiceResponse(HttpResponse response) {
    return new com.sinch.sdk.core.http.HttpResponse(
        response.getStatus(),
        response.getReasonPhrase().orElse(null),
        response.getHeaders().toMap(),
        response.getContent().asBytes());
  }

  /**
   * Path of the request as signed by the authentication schemes: the encoded path of the URL
   * followed by the query parameters
   *
   * @param request Request to be sent
   * @return Path and query parameters
   */
  static String authorizationPath(HttpRequest request) {
    String path = URI.create(request.getUrl()).getRawPath();
    return (null == path || path.isEmpty() ? "/" : path) + request.getQueryParameters().orElse("");
  }

  private static void setCollectionHeader(
      HttpHeaders headers, String header, Collection<String> values) {
    if (null != values && !values.isEmpty()) {
      headers.set(header, String.join(",", values));
    }
  }

  private static void setHeaders(HttpHeaders headers, Map<String, String> values) {
    if (null == values) {
      return;
    }
    values.forEach(
        (name, value) -> {
          if (null != value) {
            headers.set(name, value);
          }
        });
  }
}
