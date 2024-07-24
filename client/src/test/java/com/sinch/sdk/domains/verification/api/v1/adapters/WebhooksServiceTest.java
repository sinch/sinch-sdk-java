package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.api.v1.WebHooksService;
import com.sinch.sdk.domains.verification.models.dto.v1.webhooks.VerificationRequestEventDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.webhooks.VerificationResponseEventDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.webhooks.VerificationResultEventDtoTest;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class WebhooksServiceTest extends VerificationBaseTest {

  String request =
      "{\"id\":\"018c25e1-7163-5677-b8fb-467d7b1cffa5\",\"event\":\"VerificationResultEvent\",\"method\":\"sms\",\"identity\":{\"verified\":false,\"type\":\"number\",\"endpoint\":\"+33628254417\"},\"status\":\"FAIL\",\"reason\":\"Expired\"}";

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationRequestEventDto.json")
  static String jsonVerificationRequestEventDto;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResultEventDto.json")
  static String jsonVerificationResultEventDto;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponsePhoneCall.json")
  String jsonResponsePhoneCall;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponseFlashCall.json")
  String jsonResponseFlashCall;

  @GivenTextResource("/domains/verification/v1/webhooks/VerificationResponseSms.json")
  String jsonResponseSms;

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

  @Test
  void checkApplicationEmptyAuthorizationHeader() throws ApiException {

    Map<String, String> headers =
        Stream.of(
                new AbstractMap.SimpleEntry<>("authorization", ""),
                new AbstractMap.SimpleEntry<>("content-type", "application/json; charset=utf-8"),
                new AbstractMap.SimpleEntry<>("x-timestamp", "2023-12-01T15:01:20.0406449Z"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    boolean authenticationResult =
        webHooksService.validateAuthenticationHeader(
            "POST", "/VerificationRequestEvent", headers, request);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkApplicationNoAuthorizationHeader() throws ApiException {

    Map<String, String> headers =
        Stream.of(
                new AbstractMap.SimpleEntry<>("content-type", "application/json; charset=utf-8"),
                new AbstractMap.SimpleEntry<>("x-timestamp", "2023-12-01T15:01:20.0406449Z"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    boolean authenticationResult =
        webHooksService.validateAuthenticationHeader(
            "POST", "/VerificationRequestEvent", headers, request);

    Assertions.assertThat(authenticationResult).isEqualTo(false);
  }

  @Test
  void checkParseEventVerificationRequestEventDto() throws ApiException {

    TestHelpers.recursiveEquals(
        webHooksService.parseEvent(jsonVerificationRequestEventDto),
        VerificationRequestEventDtoTest.expectedRequestEventDto.getVerificationRequestEventImpl());
  }

  @Test
  void checkParseEventVerificationResultEventDto() throws ApiException {

    TestHelpers.recursiveEquals(
        webHooksService.parseEvent(jsonVerificationResultEventDto),
        VerificationResultEventDtoTest.expectedResultEvent.getVerificationResultEventImpl());
  }

  @Test
  void checkSerializeResponsePhoneCall() throws JSONException {

    JSONAssert.assertEquals(
        webHooksService.serializeResponse(
            VerificationResponseEventDtoTest.expectedPhoneCallRequestEventResponseDto),
        jsonResponsePhoneCall,
        true);
  }

  @Test
  void checkSerializeResponseFlashCall() throws JSONException {

    JSONAssert.assertEquals(
        webHooksService.serializeResponse(
            VerificationResponseEventDtoTest.expectedFlashCallRequestEventResponseDto),
        jsonResponseFlashCall,
        true);
  }

  @Test
  void checkSerializeResponseSms() throws JSONException {

    JSONAssert.assertEquals(
        webHooksService.serializeResponse(
            VerificationResponseEventDtoTest.expectedSmsRequestEventResponseDto),
        jsonResponseSms,
        true);
  }

  @BeforeEach
  public void setUp() throws IOException {

    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("789")
            .setApplicationSecret("9876543210")
            .build();
    VerificationContext context = VerificationContext.builder().setVerificationUrl("foo").build();
    webHooksService = new VerificationService(credentials, context, null).webhooks();
  }
}
