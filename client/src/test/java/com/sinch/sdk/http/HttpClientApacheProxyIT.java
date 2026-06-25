package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.e2e.Config;
import com.sinch.sdk.models.HttpProxyConfiguration;
import org.junit.jupiter.api.Test;

class HttpClientApacheProxyIT {

  private static final String PROXY_HOST = "localhost";
  private static final String TARGET_URL = "http://proxy-target-server:1080/";

  private static HttpRequest simpleGetRequest() {
    return new HttpRequest("health", HttpMethod.GET, null, (String) null, null, null, null, null);
  }

  @Test
  void unauthenticatedProxyRoutesTraffic() throws Exception {
    HttpProxyConfiguration proxyConfig =
        HttpProxyConfiguration.builder()
            .setHostname(PROXY_HOST)
            .setPort(Config.PROXY_UNAUTHENTICATED_PORT)
            .build();

    try (HttpClientApache client = new HttpClientApache(proxyConfig)) {
      HttpResponse response =
          client.invokeAPI(new ServerConfiguration(TARGET_URL), null, simpleGetRequest());

      assertEquals(200, response.getCode(), "Request through unauthenticated proxy must succeed");
    }
  }

  @Test
  void authenticatedProxyRoutesTraffic() throws Exception {
    HttpProxyConfiguration proxyConfig =
        HttpProxyConfiguration.builder()
            .setHostname(PROXY_HOST)
            .setPort(Config.PROXY_AUTHENTICATED_PORT)
            .setUsername("user")
            .setPassword("password")
            .build();

    try (HttpClientApache client = new HttpClientApache(proxyConfig)) {
      HttpResponse response =
          client.invokeAPI(new ServerConfiguration(TARGET_URL), null, simpleGetRequest());

      assertEquals(200, response.getCode(), "Request through authenticated proxy must succeed");
    }
  }

  @Test
  void authenticatedProxyRejectsWrongCredentials() throws Exception {
    HttpProxyConfiguration proxyConfig =
        HttpProxyConfiguration.builder()
            .setHostname(PROXY_HOST)
            .setPort(Config.PROXY_AUTHENTICATED_PORT)
            .setUsername("wrong-user")
            .setPassword("wrong-pass")
            .build();

    try (HttpClientApache client = new HttpClientApache(proxyConfig)) {
      HttpResponse response =
          client.invokeAPI(new ServerConfiguration(TARGET_URL), null, simpleGetRequest());

      assertEquals(
          407,
          response.getCode(),
          "Wrong credentials must result in 407 Proxy Authentication Required");
    }
  }
}
