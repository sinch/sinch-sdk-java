package com.sinch.sdk.e2e.domains;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class WebhooksHelper {

  public static <T> Response<T> callURL(URL url, Function<String, T> parseEvent)
      throws IOException {

    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    byte[] buffer = new byte[1024];
    int bytesRead;
    try (InputStream inputStream = con.getInputStream()) {
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        byteArrayOutputStream.write(buffer, 0, bytesRead);
      }
    }

    Response<T> response = new Response<>();
    response.headers = transformHeaders(con.getHeaderFields());
    response.rawPayload = byteArrayOutputStream.toString("UTF-8");
    response.event = parseEvent.apply(response.rawPayload);
    return response;
  }

  static Map<String, String> transformHeaders(Map<String, List<String>> headers) {
    if (null == headers) {
      return null;
    }
    HashMap<String, String> newMap = new HashMap<>();
    headers.forEach((key, value) -> newMap.put(key, String.join(";", value)));
    return newMap;
  }

  public static class Response<T> {
    public Map<String, String> headers;
    public String rawPayload;
    public T event;
  }
}
