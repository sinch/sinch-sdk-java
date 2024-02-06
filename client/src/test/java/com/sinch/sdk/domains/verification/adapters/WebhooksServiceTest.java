package com.sinch.sdk.domains.verification.adapters;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.WebHooksService;
import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhooksServiceTest extends BaseTest {

  public String request =
      "{\"id\":\"018c25e1-7163-5677-b8fb-467d7b1cffa5\",\"event\":\"VerificationResultEvent\",\"method\":\"sms\",\"identity\":{\"verified\":false,\"type\":\"number\",\"endpoint\":\"+33628254417\"},\"status\":\"FAIL\",\"reason\":\"Expired\"}";

  WebHooksService webHooksService;

  @Test
  void checkApplicationAuthentication() throws ApiException {

    Map<String, String> headers =
        Stream.of(
                new AbstractMap.SimpleEntry<>(
                    "authorization",
                    "application 789:xfKhO0XvlRNJraahUBEJzzi1f3Fn3pYO41/ZzwOHPaQ="),
                new AbstractMap.SimpleEntry<>("content-type", "application/json; charset=utf-8"),
                new AbstractMap.SimpleEntry<>("x-timestamp", "2023-12-01T15:01:20.0406449Z"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    boolean authenticationResult =
        webHooksService.validateAuthenticationHeader(
            "POST", "/VerificationRequestEvent", headers, request);

    Assertions.assertThat(authenticationResult).isEqualTo(true);
  }

  @BeforeEach
  public void setUp() throws IOException {

    Configuration configuration =
        Configuration.builder()
            .setProjectId("unused")
            .setKeyId("unused")
            .setKeySecret("unused")
            .setApplicationKey("789")
            .setApplicationSecret("9876543210")
            .build();

    webHooksService = new SinchClient(configuration).verification().webhooks();
  }
}
