package com.sinch.sdk.core.http;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.ServerConfiguration;

public interface HttpClient extends AutoCloseable {

  boolean isClosed();

  void close() throws Exception;

  HttpResponse invokeAPI(ServerConfiguration serverConfiguration, HttpRequest request)
      throws ApiException;
}
