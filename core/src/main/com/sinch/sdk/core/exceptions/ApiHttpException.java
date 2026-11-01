package com.sinch.sdk.core.exceptions;

import com.sinch.sdk.core.http.transport.HttpResponse;
import java.util.Map;
import java.util.Objects;

/**
 * Exception thrown by the low-level HTTP client when the response status is 400 or greater.
 *
 * <p>{@link #getCode()} is the HTTP status. The message is extracted from the content when it is a
 * Sinch API error, or is <code>HTTP &lt;status&gt; &lt;reason phrase&gt;</code> otherwise.
 *
 * <p>The response content is fully loaded in memory: it remains readable from {@link
 * #getResponse()}.
 *
 * @since 2.5
 */
public class ApiHttpException extends ApiException {

  private static final long serialVersionUID = -1L;

  private final transient HttpResponse response;

  /**
   * @param response Response received, with a status of 400 or greater
   * @since 2.5
   */
  public ApiHttpException(HttpResponse response) {
    super(Objects.requireNonNull(response, "response").getStatus(), messageOf(response));
    this.response = response;
  }

  /**
   * Response that caused the exception
   *
   * @return Response received, with its status, headers and content
   * @since 2.5
   */
  public HttpResponse getResponse() {
    return response;
  }

  private static String messageOf(HttpResponse response) {
    String fallback =
        "HTTP "
            + response.getStatus()
            + response.getReasonPhrase().filter(s -> !s.isEmpty()).map(s -> " " + s).orElse("");
    try {
      Map<String, Object> fields = response.getContent().asMap();
      return ApiExceptionBuilder.build(fallback, response.getStatus(), fields).getMessage();
    } catch (RuntimeException notASinchError) {
      // content is not JSON, or not an error shape known by the builder
      return fallback;
    }
  }
}
