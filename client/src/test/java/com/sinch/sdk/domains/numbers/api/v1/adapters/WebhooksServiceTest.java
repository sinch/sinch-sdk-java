package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.api.v1.WebHooksService;
import com.sinch.sdk.domains.numbers.models.v1.WebhooksDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent;
import com.sinch.sdk.models.Configuration;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhooksServiceTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/webhooks/number-event.json")
  String incomingWebhookJSON;

  WebHooksService webHooksService;

  @Test
  void checkValidateAuthenticatedRequest() {

    Map<String, String> headers =
        Stream.of(
                new AbstractMap.SimpleEntry<>(
                    NumbersWebhooksAuthenticationValidation.SIGNATURE_HEADER,
                    "e289b8fac44491417aeceee28d2715840b5f1aca"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    String secret = "secret value";
    String body =
        "{\"eventId\":\"01j3fycq0fyqq3gkgxb0g5ekbz\",\"timestamp\":\"2024-07-23T14:02:14.415637289\",\"projectId\":\"b8bae3c6-e7df-422b-9401-8ae3ee3e0aff\",\"resourceId\":\"+12053017799\",\"resourceType\":\"ACTIVE_NUMBER\",\"eventType\":\"PROVISIONING_TO_VOICE_PLATFORM\",\"status\":\"SUCCEEDED\",\"failureCode\":null}";

    boolean authenticationResult =
        webHooksService.validateAuthenticationHeader(secret, headers, body);

    assertTrue(authenticationResult);
  }

  @Test
  void parse() throws ApiException {

    NumberEvent response = webHooksService.parseEvent(incomingWebhookJSON);

    TestHelpers.recursiveEquals(response, WebhooksDtoTest.numberEvent);
  }

  @BeforeEach
  public void setUp() throws IOException {

    Configuration configuration =
        Configuration.builder()
            .setProjectId("unused")
            .setKeyId("unused")
            .setKeySecret("unused")
            .build();

    webHooksService = new SinchClient(configuration).numbers().v1().webhooks();
  }
}
