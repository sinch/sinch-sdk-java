package com.sinch.sdk.core.http;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.ServerConfiguration;
import java.util.Map;

public interface HttpClient extends AutoCloseable {

  boolean isClosed();

  void close() throws Exception;

  /**
   * Register a set of headers to be added onto requests
   *
   * @param headers Map of key/value headers to be added
   */
  void setRequestHeaders(Map<String, String> headers);

  HttpResponse invokeAPI(ServerConfiguration serverConfiguration, HttpRequest request)
      throws ApiException;
}
