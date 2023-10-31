package com.sinch.sdk.core.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HttpResponse {

  private final int code;

  private final String message;

  private final Map<String, List<String>> headers;

  private final byte[] buffer;

  public HttpResponse(
      final int code,
      final String message,
      final Map<String, List<String>> headers,
      final byte[] buffer) {
    this.code = code;
    this.message = null != message ? message : "";
    this.headers = (null != headers) ? headers : Collections.emptyMap();
    this.buffer = null != buffer ? buffer : "".getBytes(StandardCharsets.UTF_8);
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public Map<String, List<String>> getHeaders() {
    return headers;
  }

  public InputStream getContent() {
    return new ByteArrayInputStream(buffer);
  }

  @Override
  public String toString() {
    return "HttpResponse{"
        + "code="
        + code
        + ", message='"
        + message
        + '\''
        + ", headers="
        + headers
        + ", buffer="
        + new String(buffer)
        + '}';
  }
}
