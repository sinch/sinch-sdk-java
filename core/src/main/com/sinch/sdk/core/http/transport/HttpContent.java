package com.sinch.sdk.core.http.transport;

import java.io.File;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Content of an HTTP request.
 *
 * <p>Content is sent untouched: text has to be encoded by the caller, and the <code>content-type
 * </code> header describing the content has to be set by the caller, except for form data where the
 * transport sets it with the boundary of the parts.
 *
 * <p>Every kind of content can be sent more than once, so that a request can be retried.
 *
 * <p><b>Internal use:</b> used by the SDK HTTP clients, not part of the SDK public API yet. It may
 * change without notice.
 *
 * @since 2.5
 */
public abstract class HttpContent {

  private HttpContent() {}

  /**
   * Binary content
   *
   * @param content Bytes to send. The array is not copied
   * @return Content instance
   * @since 2.5
   */
  public static HttpContent ofBytes(byte[] content) {
    return new BytesContent(content);
  }

  /**
   * File content, read from disk while being sent rather than loaded in memory
   *
   * @param file File to send
   * @return Content instance
   * @since 2.5
   */
  public static HttpContent ofFile(File file) {
    return new FileContent(file);
  }

  /**
   * Form data, sent as <code>multipart/form-data</code>
   *
   * @param parameters Parts to send, by name. A value is either a {@link File}, a <code>byte[]
   *     </code>, a {@link java.util.Collection} of values sent as several parts with the same name,
   *     or any other object sent as its text representation
   * @return Content instance
   * @since 2.5
   */
  public static HttpContent ofFormData(Map<String, ?> parameters) {
    return new FormDataContent(parameters);
  }

  /**
   * Binary content
   *
   * @since 2.5
   */
  public static final class BytesContent extends HttpContent {
    private final byte[] value;

    private BytesContent(byte[] value) {
      this.value = Objects.requireNonNull(value, "content");
    }

    public byte[] getValue() {
      return value;
    }

    @Override
    public String toString() {
      return "BytesContent{" + "length=" + value.length + '}';
    }
  }

  /**
   * File content
   *
   * @since 2.5
   */
  public static final class FileContent extends HttpContent {
    private final File file;

    private FileContent(File file) {
      this.file = Objects.requireNonNull(file, "file");
    }

    public File getFile() {
      return file;
    }

    @Override
    public String toString() {
      return "FileContent{" + "file=" + file + '}';
    }
  }

  /**
   * Form data content
   *
   * @since 2.5
   */
  public static final class FormDataContent extends HttpContent {
    private final Map<String, Object> parameters;

    private FormDataContent(Map<String, ?> parameters) {
      this.parameters =
          Collections.unmodifiableMap(
              new LinkedHashMap<>(Objects.requireNonNull(parameters, "parameters")));
    }

    public Map<String, Object> getParameters() {
      return parameters;
    }

    @Override
    public String toString() {
      return "FormDataContent{" + "parameters=" + parameters + '}';
    }
  }
}
