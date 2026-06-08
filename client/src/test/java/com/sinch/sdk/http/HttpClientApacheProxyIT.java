package com.sinch.sdk.http;

import static org.junit.jupiter.api.Assertions.*;

import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.HttpProxyConfiguration;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * E2E proxy tests using Docker directly with a real Squid proxy.
 *
 * <p>Requires Docker to be running. Included in the failsafe integration-test phase alongside other
 * {@code *IT} tests.
 */
class HttpClientApacheProxyIT {

  private static final int SQUID_PORT = 3128;

  @BeforeAll
  static void requireDocker() throws Exception {
    Process p = new ProcessBuilder("docker", "info").redirectErrorStream(true).start();
    boolean finished = p.waitFor(5, TimeUnit.SECONDS);
    Assumptions.assumeTrue(
        finished && p.exitValue() == 0, "Docker is not available, skipping proxy E2E tests");
  }

  private static HttpRequest simpleGetRequest() {
    return new HttpRequest("api/test", HttpMethod.GET, null, (String) null, null, null, null, null);
  }

  /** Start a plain (unauthenticated) Squid container, return the container ID. */
  private static String startSquidContainer(int hostPort) throws Exception {
    ProcessBuilder pb =
        new ProcessBuilder(
            "docker",
            "run",
            "-d",
            "--rm",
            "--add-host=host.docker.internal:host-gateway",
            "-p",
            hostPort + ":" + SQUID_PORT,
            "ubuntu/squid:latest");
    pb.redirectErrorStream(true);
    Process p = pb.start();
    String containerId;
    try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
      containerId = r.readLine();
    }
    assertTrue(p.waitFor(30, TimeUnit.SECONDS), "docker run must finish");
    assertEquals(0, p.exitValue(), "docker run must succeed");
    assertNotNull(containerId, "container ID must be returned");
    // Give Squid a moment to start listening
    Thread.sleep(3000);
    return containerId.trim();
  }

  /**
   * Start an authenticated Squid container using config and password files from test resources.
   * Returns the container ID.
   */
  private static String startAuthSquidContainer(int hostPort) throws Exception {
    // Resolve resource files from classpath
    Path squidConf =
        java.nio.file.Paths.get(
            HttpClientApacheProxyIT.class
                .getClassLoader()
                .getResource("squid-auth/squid.conf")
                .toURI());
    Path passwords =
        java.nio.file.Paths.get(
            HttpClientApacheProxyIT.class
                .getClassLoader()
                .getResource("squid-auth/passwords")
                .toURI());

    assertTrue(Files.exists(squidConf), "squid.conf must exist on classpath");
    assertTrue(Files.exists(passwords), "passwords must exist on classpath");

    ProcessBuilder pb =
        new ProcessBuilder(
            "docker",
            "run",
            "-d",
            "--rm",
            "--add-host=host.docker.internal:host-gateway",
            "-p",
            hostPort + ":" + SQUID_PORT,
            "-v",
            squidConf.toAbsolutePath() + ":/etc/squid/squid.conf:ro",
            "-v",
            passwords.toAbsolutePath() + ":/etc/squid/passwords:ro",
            "ubuntu/squid:latest");
    pb.redirectErrorStream(true);
    Process p = pb.start();
    String containerId;
    try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
      containerId = r.readLine();
    }
    assertTrue(p.waitFor(30, TimeUnit.SECONDS), "docker run must finish");
    assertEquals(0, p.exitValue(), "docker run must succeed");
    assertNotNull(containerId, "container ID must be returned");
    Thread.sleep(3000);
    return containerId.trim();
  }

  private static void stopContainer(String containerId) {
    try {
      new ProcessBuilder("docker", "stop", containerId)
          .redirectErrorStream(true)
          .start()
          .waitFor(15, TimeUnit.SECONDS);
    } catch (Exception ignored) {
    }
  }

  private static int findFreePort() throws Exception {
    try (ServerSocket s = new ServerSocket(0)) {
      return s.getLocalPort();
    }
  }

  @Test
  void unauthenticatedProxyRoutesTraffic() throws Exception {
    int proxyPort = findFreePort();
    String containerId = startSquidContainer(proxyPort);
    try {
      MockWebServer targetServer = new MockWebServer();
      targetServer.start();
      try {
        targetServer.enqueue(
            new MockResponse()
                .setBody("{\"status\":\"ok\"}")
                .addHeader("Content-Type", "application/json"));

        String targetUrl = String.format("http://host.docker.internal:%d/", targetServer.getPort());

        HttpProxyConfiguration proxyConfig =
            HttpProxyConfiguration.builder().setHostname("localhost").setPort(proxyPort).build();

        try (HttpClientApache client = new HttpClientApache(proxyConfig)) {
          HttpResponse response =
              client.invokeAPI(new ServerConfiguration(targetUrl), null, simpleGetRequest());

          assertEquals(
              200, response.getCode(), "Request through unauthenticated proxy must succeed");
        }

        RecordedRequest request = targetServer.takeRequest(5, TimeUnit.SECONDS);
        assertNotNull(request, "Target server must receive the proxied request");
      } finally {
        targetServer.shutdown();
      }
    } finally {
      stopContainer(containerId);
    }
  }

  @Test
  void authenticatedProxyRoutesTrafficAfterChallenge() throws Exception {
    int proxyPort = findFreePort();
    String containerId = startAuthSquidContainer(proxyPort);
    try {
      MockWebServer targetServer = new MockWebServer();
      targetServer.start();
      try {
        targetServer.enqueue(
            new MockResponse()
                .setBody("{\"status\":\"ok\"}")
                .addHeader("Content-Type", "application/json"));

        String targetUrl = String.format("http://host.docker.internal:%d/", targetServer.getPort());

        HttpProxyConfiguration proxyConfig =
            HttpProxyConfiguration.builder()
                .setHostname("localhost")
                .setPort(proxyPort)
                .setUsername("proxyuser")
                .setPassword("proxypass")
                .build();

        try (HttpClientApache client = new HttpClientApache(proxyConfig)) {
          HttpResponse response =
              client.invokeAPI(new ServerConfiguration(targetUrl), null, simpleGetRequest());

          assertEquals(
              200,
              response.getCode(),
              "Request through authenticated proxy must succeed after 407 challenge");
        }

        RecordedRequest request = targetServer.takeRequest(5, TimeUnit.SECONDS);
        assertNotNull(request, "Target server must receive the proxied request");
      } finally {
        targetServer.shutdown();
      }
    } finally {
      stopContainer(containerId);
    }
  }

  @Test
  void authenticatedProxyRejectsWrongCredentials() throws Exception {
    int proxyPort = findFreePort();
    String containerId = startAuthSquidContainer(proxyPort);
    try {
      MockWebServer targetServer = new MockWebServer();
      targetServer.start();
      try {
        String targetUrl = String.format("http://host.docker.internal:%d/", targetServer.getPort());

        HttpProxyConfiguration proxyConfig =
            HttpProxyConfiguration.builder()
                .setHostname("localhost")
                .setPort(proxyPort)
                .setUsername("wrong-user")
                .setPassword("wrong-pass")
                .build();

        try (HttpClientApache client = new HttpClientApache(proxyConfig)) {
          HttpResponse response =
              client.invokeAPI(new ServerConfiguration(targetUrl), null, simpleGetRequest());

          assertEquals(
              407,
              response.getCode(),
              "Wrong credentials must result in 407 Proxy Authentication Required");
        }
      } finally {
        targetServer.shutdown();
      }
    } finally {
      stopContainer(containerId);
    }
  }
}
