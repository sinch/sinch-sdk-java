package com.sinch.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@TestWithResources
class SinchClientTestIT extends BaseTest {
  static MockWebServer mockBackEnd;
  String serverUrl = String.format("http://localhost:%s", mockBackEnd.getPort());

  Configuration configuration =
      Configuration.builder()
          .setKeyId("foo")
          .setKeySecret("foo")
          .setProjectId("foo")
          .setNumbersUrl(serverUrl)
          .build();

  SinchClient sinchClient = new SinchClient(configuration);

  @BeforeAll
  static void classSetUp() throws IOException {
    mockBackEnd = new MockWebServer();
    mockBackEnd.start();
  }

  @AfterAll
  static void tearDown() throws IOException {
    mockBackEnd.shutdown();
  }

  @Test
  void sdkUserAgent() throws InterruptedException {

    mockBackEnd.enqueue(
        new MockResponse().setBody("foo").addHeader("Content-Type", "application/json"));

    try {
      sinchClient.numbers().available().checkAvailability("foo");
    } catch (ApiException ae) {
      // noop
    }
    RecordedRequest recordedRequest = mockBackEnd.takeRequest();
    String header = recordedRequest.getHeader("User-Agent");
    assertThat(header).matches("^sinch-sdk/.* \\(Java/.*; Apache; .*\\)$");
  }
}
