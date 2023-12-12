package com.sinch.sdk.domains.numbers.adapters.api.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.*;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
class AvailableNumberApiTest extends BaseTest {

  @GivenTextResource("/domains/numbers/v1/error-trial-account.json")
  String errorTrialAccount;

  @GivenTextResource("/domains/numbers/v1/rent-response.json")
  String rentResponse;

  @GivenTextResource("/domains/numbers/v1/available-numbers-list.json")
  String availableListResponse;

  @GivenTextResource("/domains/numbers/v1/available-numbers-get.json")
  String availableGetResponse;

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  HttpMapper mapper = new HttpMapper();

  @InjectMocks
  AvailableNumberApi service =
      new AvailableNumberApi(httpClient, serverConfiguration, null, mapper);

  AvailableNumberDto expectedAvailableNumberDto =
      new AvailableNumberDto("+46650553763", "SE", 1, true)
          .type("LOCAL")
          .capability(Collections.singletonList("VOICE"))
          .setupPrice(new MoneyDto().currencyCode("DOLLAR").amount("0.57"))
          .monthlyPrice(new MoneyDto().currencyCode("EUR").amount("0.80"));

  ActiveNumberDto expectedActiveNumberDto =
      new ActiveNumberDto(
              "US",
              0,
              OffsetDateTime.parse("2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME),
              OffsetDateTime.parse("2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME))
          .phoneNumber("+12025550134")
          .projectId("51bc3f40-f266-4ca8-8938-a1ed0ff32b9a")
          .displayName("string")
          .type("MOBILE")
          .capability(Collections.singletonList("SMS"))
          .money(new MoneyDto().currencyCode("USD").amount("2.00"))
          .smsConfiguration(
              new SMSConfigurationDto()
                  .servicePlanId("string")
                  .campaignId("string")
                  .scheduledProvisioning(
                      new ScheduledProvisioningDto(
                              "8200000f74924bd6800000b212f00000",
                              "string",
                              OffsetDateTime.parse(
                                  "2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                              Collections.emptyList())
                          .status(ProvisioningStatusDto.WAITING)))
          .voiceConfiguration(
              new VoiceConfigurationDto(
                      OffsetDateTime.parse(
                          "2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                  .appId("string")
                  .scheduledVoiceProvisioning(
                      new ScheduledVoiceProvisioningDto(
                              "string",
                              OffsetDateTime.parse(
                                  "2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                          .status(ProvisioningStatusDto.WAITING)))
          .callbackUrl("https://www.your-callback-server.com/callback");

  @Test
  void listAll() {

    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, availableListResponse.getBytes(StandardCharsets.UTF_8)));

    AvailableNumbersResponseDto response =
        service.numberServiceListAvailableNumbers(
            "project",
            "region",
            "type",
            "pattern",
            "searchPattern",
            Collections.singletonList("capability"),
            45);

    AvailableNumbersResponseDto expected =
        new AvailableNumbersResponseDto()
            .availableNumbers(Collections.singletonList(expectedAvailableNumberDto));

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void get() {

    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, availableGetResponse.getBytes(StandardCharsets.UTF_8)));

    AvailableNumberDto response = service.numberServiceGetAvailableNumber("project", "region");

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(expectedAvailableNumberDto);
  }

  @Test
  void rentAny() {

    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, rentResponse.getBytes(StandardCharsets.UTF_8)));

    RentAnyNumberRequestDto parameters =
        new RentAnyNumberRequestDto()
            .regionCode("region")
            .type("type")
            .numberPattern(
                new SearchPatternDto().pattern("pattern").searchPattern("search pattern"))
            .capabilities(Collections.singletonList("capability"))
            .smsConfiguration(
                new RentAnyNumberRequestSmsConfigurationDto()
                    .servicePlanId("service plan id")
                    .campaignId("campaign id"))
            .voiceConfiguration(new RentAnyNumberRequestVoiceConfigurationDto().appId("app id"))
            .callbackUrl("foo callback");

    ActiveNumberDto response = service.numberServiceRentAnyNumber("project", parameters);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedActiveNumberDto);
  }

  @Test
  void rent() {

    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                200, "foo message", null, rentResponse.getBytes(StandardCharsets.UTF_8)));

    ActiveNumberDto response =
        service.numberServiceRentNumber("project", "phone", new RentNumberRequestDto());

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedActiveNumberDto);
  }

  @Test
  void rentWithError() {

    when(httpClient.invokeAPI(any(), any(), any()))
        .thenReturn(
            new HttpResponse(
                500, "foo message", null, errorTrialAccount.getBytes(StandardCharsets.UTF_8)));

    ApiException exception =
        assertThrows(
            ApiException.class,
            () -> service.numberServiceRentNumber("project", "phone", new RentNumberRequestDto()));

    assertEquals(exception.getCode(), 403);
    assertEquals(
        exception.getMessage(), "PERMISSION_DENIED: Trial account is not enabled to rent number");
  }
}
