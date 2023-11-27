package com.sinch.sdk.core.http;

import com.sinch.sdk.core.utils.Pair;
import java.util.Collection;

public interface AuthManager {

  // expected schemes identifier defined at OAS files level
  String SCHEMA_KEYWORD_BEARER = "Bearer";
  String SCHEMA_KEYWORD_BASIC = "Basic";

  String getSchema();

  void resetToken();

  Collection<Pair<String, String>> getAuthorizationHeaders(
      String method, String httpContentType, String path, String body);
}
