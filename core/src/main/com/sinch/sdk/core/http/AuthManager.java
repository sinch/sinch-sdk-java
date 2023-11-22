package com.sinch.sdk.core.http;

public interface AuthManager {

  final String SCHEMA_KEYWORD_BEARER = "Bearer";
  final String SCHEMA_KEYWORD_BASIC = "Basic";

  String getSchema();

  void resetToken();

  String getAuthorizationHeaderValue();
}
