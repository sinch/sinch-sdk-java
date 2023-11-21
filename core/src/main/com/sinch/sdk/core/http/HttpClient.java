package com.sinch.sdk.core.http;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.ServerConfiguration;
import java.util.Map;

public interface HttpClient extends AutoCloseable {

  boolean isClosed();

  void close() throws Exception;

  HttpResponse invokeAPI(
      ServerConfiguration serverConfiguration,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      HttpRequest request)
      throws ApiException;
}
