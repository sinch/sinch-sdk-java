package com.sinch.sdk.core.http.transport;

import java.io.Closeable;
import java.util.Objects;
import java.util.Optional;

/**
 * HTTP response received by an {@link HttpTransport}.
 *
 * <p>A response can hold resources until its content is read: it has to be closed once it is no
 * longer used.
 *
 * <p><b>Internal use:</b> used by the SDK HTTP clients, not part of the SDK public API yet. It may
 * change without notice.
 *
 * @since 2.4
 */
public final class HttpResponse implements Closeable {

  private final int status;
  private final String reasonPhrase;
  private final HttpHeaders headers;
  private final HttpContentParser content;

  /**
   * @param status Status code
   * @param reasonPhrase Reason phrase of the status line, <code>null</code> when none was received
   * @param headers Headers received
   * @param content Content received
   * @since 2.4
   */
  public HttpResponse(
      int status, String reasonPhrase, HttpHeaders headers, HttpContentParser content) {
    this.status = status;
    this.reasonPhrase = reasonPhrase;
    this.headers = new HttpHeaders(Objects.requireNonNull(headers, "headers")).readOnlyView();
    this.content = Objects.requireNonNull(content, "content");
  }

  /**
   * Status code
   *
   * @return Status code of the response
   * @since 2.4
   */
  public int getStatus() {
    return status;
  }

  /**
   * Reason phrase of the status line
   *
   * @return Reason phrase, empty when none was received (e.g. HTTP/2)
   * @since 2.4
   */
  public Optional<String> getReasonPhrase() {
    return Optional.ofNullable(reasonPhrase);
  }

  /**
   * Headers of the response
   *
   * @return Read-only headers received
   * @since 2.4
   */
  public HttpHeaders getHeaders() {
    return headers;
  }

  /**
   * Content of the response
   *
   * @return Content received
   * @since 2.4
   */
  public HttpContentParser getContent() {
    return content;
  }

  @Override
  public void close() {
    content.close();
  }

  @Override
  public String toString() {
    return "HttpResponse{"
        + "status="
        + status
        + ", reasonPhrase='"
        + reasonPhrase
        + '\''
        + ", headers="
        + headers
        + ", content="
        + content
        + '}';
  }
}
