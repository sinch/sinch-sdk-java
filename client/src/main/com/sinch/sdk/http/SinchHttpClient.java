package com.sinch.sdk.http;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.exceptions.ApiHttpException;
import com.sinch.sdk.core.http.transport.HttpResponse;
import java.io.File;
import java.util.Map;

/**
 * Low-level HTTP client to call any Sinch API, including the endpoints not covered by the SDK
 * services (e.g. sources generated from an OpenAPI specification).
 *
 * <p>The SDK still takes care of:
 *
 * <ul>
 *   <li>the authentication, with a single scheme chosen from the configured credentials:
 *       <ul>
 *         <li>OAuth2 when <code>keyId</code> and <code>keySecret</code> are set, whatever the other
 *             credentials: it is accepted by every Sinch API. <code>projectId</code> is never
 *             required (it is part of the URL)
 *         <li>otherwise the SMS API token (SMS service plan credentials), or the signed request
 *             (application credentials, Voice and Verification APIs). The SDK cannot tell which API
 *             is called: when both are set, an {@link IllegalStateException} is thrown
 *       </ul>
 *       With {@link HttpRequestOptions#getUseSinchAuth()} set to <code>false</code>, no <code>
 *       Authorization</code> header is added and no credentials are required
 *   <li>the retries of the rate-limited (HTTP 429) responses
 *   <li>the timeout and the <code>User-Agent</code> header
 * </ul>
 *
 * <p>Everything else is up to the caller: the URL and the query parameters have to be already
 * encoded, the body is sent untouched, and the headers expected by the server (<code>accept</code>,
 * <code>content-type</code>, ...) have to be set. There is no pagination, and the field names are
 * the raw ones of the API specification.
 *
 * <p>Every method:
 *
 * <ul>
 *   <li>takes an absolute URL, sent as is. The query parameters of {@link
 *       HttpCallParameters#getQueryParameters()} are appended to it, with a leading <code>?</code>
 *       added when missing
 *   <li>takes optional {@link HttpCallParameters}, <code>null</code> when none
 *   <li>returns a response with a status lower than 400, whose content is fully loaded in memory
 *   <li>throws an {@link ApiHttpException} when the status is 400 or greater, and an {@link
 *       ApiException} when the request could not be sent
 * </ul>
 *
 * <p>A <code>String</code>, <code>byte[]</code> or {@link File} body requires the <code>
 * content-type</code> header: without it, an {@link IllegalArgumentException} is thrown before
 * sending the request. A signed request only supports a <code>String</code> body, signed as UTF-8
 * text: any other body throws an {@link IllegalArgumentException}.
 *
 * @since 2.5
 */
public interface SinchHttpClient {

  /**
   * Send a GET request
   *
   * @param url Absolute URL
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse get(String url) throws ApiException;

  /**
   * Send a GET request
   *
   * @param url Absolute URL
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse get(String url, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a DELETE request
   *
   * @param url Absolute URL
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse delete(String url) throws ApiException;

  /**
   * Send a DELETE request
   *
   * @param url Absolute URL
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse delete(String url, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a POST request with a text body, e.g. a JSON payload
   *
   * @param url Absolute URL
   * @param body Body, encoded with the charset of the <code>content-type</code> header, or UTF-8
   *     when the header does not define one. The <code>content-type</code> header is required
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse post(String url, String body, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a POST request with a binary body
   *
   * @param url Absolute URL
   * @param body Body, sent untouched. The <code>content-type</code> header is required
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse post(String url, byte[] body, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a POST request with the content of a file as body
   *
   * @param url Absolute URL
   * @param body File, read from disk while being sent rather than loaded in memory. The <code>
   *     content-type</code> header is required
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse post(String url, File body, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a POST request with a <code>multipart/form-data</code> body
   *
   * <p>The <code>content-type</code> header is set by the SDK, with the boundary of the parts: a
   * <code>content-type</code> header set by the caller is ignored.
   *
   * @param url Absolute URL
   * @param formParameters Parts to send, by name. A value is either a {@link File}, a <code>byte[]
   *     </code>, a {@link java.util.Collection} of values sent as several parts with the same name,
   *     any other object sent as its text representation, or <code>null</code> to omit the part
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse postFormData(
      String url, Map<String, ?> formParameters, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a PUT request with a text body, e.g. a JSON payload
   *
   * @param url Absolute URL
   * @param body Body, encoded with the charset of the <code>content-type</code> header, or UTF-8
   *     when the header does not define one. The <code>content-type</code> header is required
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse put(String url, String body, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a PUT request with a binary body
   *
   * @param url Absolute URL
   * @param body Body, sent untouched. The <code>content-type</code> header is required
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse put(String url, byte[] body, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a PUT request with the content of a file as body
   *
   * @param url Absolute URL
   * @param body File, read from disk while being sent rather than loaded in memory. The <code>
   *     content-type</code> header is required
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse put(String url, File body, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a PATCH request with a text body, e.g. a JSON payload
   *
   * @param url Absolute URL
   * @param body Body, encoded with the charset of the <code>content-type</code> header, or UTF-8
   *     when the header does not define one. The <code>content-type</code> header is required
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse patch(String url, String body, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a PATCH request with a binary body
   *
   * @param url Absolute URL
   * @param body Body, sent untouched. The <code>content-type</code> header is required
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse patch(String url, byte[] body, HttpCallParameters parameters) throws ApiException;

  /**
   * Send a PATCH request with the content of a file as body
   *
   * @param url Absolute URL
   * @param body File, read from disk while being sent rather than loaded in memory. The <code>
   *     content-type</code> header is required
   * @param parameters Query parameters, headers and options, <code>null</code> when none
   * @return Response received
   * @throws ApiException if the request failed
   * @since 2.5
   */
  HttpResponse patch(String url, File body, HttpCallParameters parameters) throws ApiException;
}
