package com.sinch.sdk.core.http.transport;

import com.sinch.sdk.core.exceptions.ApiException;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Map;

/**
 * Content of an HTTP response.
 *
 * @since 2.4
 */
public interface HttpContentParser extends Closeable {

  /**
   * Content as text, decoded with the charset of the <code>content-type</code> header, or UTF-8
   * when the header does not define one
   *
   * @return Text content, empty when the response has no content
   * @since 2.4
   */
  String asString();

  /**
   * Content as bytes
   *
   * @return Bytes received, empty when the response has no content
   * @since 2.4
   */
  byte[] asBytes();

  /**
   * Fields of a JSON object content. Nested objects are maps, arrays are lists, and a field set to
   * <code>null</code> in the payload is present with a <code>null</code> value
   *
   * @return Fields of the object, in payload order. Empty when the response has no content
   * @throws ApiException if the content is not a JSON object
   * @since 2.4
   */
  Map<String, Object> asMap() throws ApiException;

  /**
   * Content as a stream
   *
   * @return Stream over the content
   * @since 2.4
   */
  InputStream asStream();

  /**
   * Release the resources held for the content
   *
   * @since 2.4
   */
  @Override
  default void close() {}
}
