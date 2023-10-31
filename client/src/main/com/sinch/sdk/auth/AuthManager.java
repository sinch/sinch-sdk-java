package com.sinch.sdk.auth;

import com.sinch.sdk.core.http.HttpClient;

public interface AuthManager {

  String getSchema();

  void resetToken();

  void setHttpClient(HttpClient httpClient);

  String getAuthorizationHeaderValue();
}
