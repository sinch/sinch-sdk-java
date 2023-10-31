package com.sinch.sdk.domains.numbers.adapters.api.v1;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.*;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
class ActiveNumberApiTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/active-numbers-list.json")
  String activeListResponse;

  @GivenTextResource("/domains/numbers/v1/active-numbers-get.json")
  String activeGetResponse;

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  HttpMapper mapper = new HttpMapper();

  @InjectMocks
  ActiveNumberApi service = new ActiveNumberApi(httpClient, serverConfiguration, mapper);

  ActiveNumberDto expectedActiveNumberDto =
      new ActiveNumberDto(
              "GB",
              1,
              OffsetDateTime.parse("2023-09-22T15:49:58.813424Z"),
              OffsetDateTime.parse("2023-10-06T15:49:58.813381Z"))
          .phoneNumber("+447520651116XYZ")
          .projectId("project id")
          .displayName("a display")
          .type("MOBILE")
          .capability(Arrays.asList("SMS", "VOICE"))
          .money(new MoneyDto().currencyCode("EUR").amount("0.80"))
          .smsConfiguration(
              new SMSConfigurationDto()
                  .servicePlanId("service plan id")
                  .scheduledProvisioning(
                      new ScheduledProvisioningDto(
                              "service plan id from scheduled",
                              "campaign id from scheduled",
                              OffsetDateTime.parse("2023-09-25T12:08:02.115Z"),
                              Collections.singletonList(SmsErrorCodeDto.ERROR_CODE_UNSPECIFIED))
                          .status(ProvisioningStatusDto.PROVISIONING_STATUS_UNSPECIFIED)))
          .voiceConfiguration(
              new VoiceConfigurationDto(OffsetDateTime.parse("2023-09-25T12:08:02.115Z"))
                  .appId("app id")
                  .scheduledVoiceProvisioning(
                      new ScheduledVoiceProvisioningDto(
                              "app id from scheduled",
                              OffsetDateTime.parse("2023-09-25T12:08:02.115Z"))
                          .status(ProvisioningStatusDto.PROVISIONING_STATUS_UNSPECIFIED)))
          .callbackUrl("foo callback");

  @Test
  void list() {

    when(httpClient.invokeAPI(eq(serverConfiguration), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, activeListResponse.getBytes(StandardCharsets.UTF_8)));

    ActiveNumbersResponseDto response =
        service.numberServiceListActiveNumbers(
            "project",
            "region",
            "type",
            "pattern",
            "searchPattern",
            Collections.singletonList("capability"),
            45,
            "token",
            "order by");

    ActiveNumbersResponseDto expected =
        new ActiveNumbersResponseDto()
            .totalSize(1)
            .nextPageToken("foo")
            .activeNumbers(Collections.singletonList(expectedActiveNumberDto));

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void get() {

    when(httpClient.invokeAPI(eq(serverConfiguration), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, activeGetResponse.getBytes(StandardCharsets.UTF_8)));

    ActiveNumberDto response = service.numberServiceGetActiveNumber("project", "foo phone");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedActiveNumberDto);
  }

  @Test
  void release() {

    when(httpClient.invokeAPI(eq(serverConfiguration), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, activeGetResponse.getBytes(StandardCharsets.UTF_8)));

    ActiveNumberDto response = service.numberServiceReleaseNumber("project", "foo phone");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedActiveNumberDto);
  }

  @Test
  void update() {

    when(httpClient.invokeAPI(eq(serverConfiguration), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, activeGetResponse.getBytes(StandardCharsets.UTF_8)));

    ActiveNumberRequestDto parameters = new ActiveNumberRequestDto();

    ActiveNumberDto response =
        service.numberServiceUpdateActiveNumber("project", "foo phone", parameters);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedActiveNumberDto);
  }
}
