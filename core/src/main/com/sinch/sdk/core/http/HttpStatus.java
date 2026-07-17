package com.sinch.sdk.core.http;

import java.net.HttpURLConnection;

public class HttpStatus {

  @Deprecated public static final int UNAUTHORIZED = HttpURLConnection.HTTP_UNAUTHORIZED;

  public static final int TOO_MANY_REQUESTS = 429;

  public static boolean isSuccessfulStatus(int statusCode) {
    return statusCode >= 200 && statusCode < 300;
  }
}
