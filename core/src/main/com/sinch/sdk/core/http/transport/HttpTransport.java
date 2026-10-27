package com.sinch.sdk.core.http.transport;

import java.io.Closeable;
import java.io.IOException;

/**
 * Sends HTTP requests.
 *
 * <p>A transport performs one exchange per request: authentication, retries and error handling are
 * performed by its caller.
 *
 * <p><b>Internal use:</b> used by the SDK HTTP clients, not part of the SDK public API yet. It may
 * change without notice.
 *
 * @since 2.4
 */
public interface HttpTransport extends Closeable {

  /**
   * Send a request
   *
   * @param request Request to send
   * @return Response received, whatever its status code
   * @throws IOException if the exchange failed or the transport is closed
   * @since 2.4
   */
  HttpResponse send(HttpRequest request) throws IOException;
}
