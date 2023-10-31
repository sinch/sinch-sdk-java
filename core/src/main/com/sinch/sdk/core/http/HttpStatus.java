package com.sinch.sdk.core.http;

import java.net.HttpURLConnection;

public class HttpStatus {

  public static Integer UNAUTHORIZED = HttpURLConnection.HTTP_UNAUTHORIZED;

  public static boolean isSuccessfulStatus(int statusCode) {
    return statusCode >= 200 && statusCode < 300;
  }
}
