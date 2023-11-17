package com.sinch.sdk.domains.numbers.adapters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.adapters.api.v1.AvailableNumberApi;
import com.sinch.sdk.domains.numbers.models.*;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumbersResponseDto;
import com.sinch.sdk.domains.numbers.models.requests.*;
import com.sinch.sdk.domains.numbers.models.responses.AvailableNumberListResponse;
import com.sinch.sdk.models.Configuration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
class AvailableNumberServiceTest extends BaseTest {

  @GivenJsonResource("/domains/numbers/v1/available-numbers-list.json")
  AvailableNumbersResponseDto availableNumbersListDto;

  @GivenJsonResource("/domains/numbers/v1/available-numbers-get.json")
  AvailableNumberDto getNumberDto;

  @GivenJsonResource("/domains/numbers/v1/rent-response.json")
  ActiveNumberDto rentNumberDto;

  @Mock Configuration configuration;
  @Mock AvailableNumberApi api;
  @InjectMocks AvailableNumberService service;

  @Test
  void list() throws ApiException {

    when(api.numberServiceListAvailableNumbers(
            eq(configuration.getProjectId()),
            eq("region"),
            ArgumentMatchers.eq(NumberType.MOBILE.value()),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(availableNumbersListDto);

    AvailableNumberListAllRequestParameters parameters =
        AvailableNumberListAllRequestParameters.builder()
            .setRegionCode("region")
            .setType(NumberType.MOBILE)
            .build();

    Collection<AvailableNumber> expected =
        Collections.singletonList(
            AvailableNumber.builder()
                .setPhoneNumber("+46650553763")
                .setRegionCode("SE")
                .setType(NumberType.LOCAL)
                .setCapability(Collections.singletonList(Capability.VOICE))
                .setSetupPrice(new Money("DOLLAR", 0.57))
                .setMonthlyPrice(new Money("EUR", 0.80))
                .setPaymentIntervalMonths(1)
                .setSupportingDocumentationRequired(true)
                .build());

    AvailableNumberListResponse response = service.list(parameters);

    assertFalse(response.hasNextPage(), "Has no next page");
    assertThrows(NoSuchElementException.class, response::nextPage);
    Assertions.assertThat(response.getContent()).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void listWithParameters() throws ApiException {

    when(api.numberServiceListAvailableNumbers(
            eq(configuration.getProjectId()),
            eq("another region"),
            ArgumentMatchers.eq(NumberType.TOLL_FREE.value()),
            eq("pattern value"),
            ArgumentMatchers.eq(SearchPattern.END.value()),
            ArgumentMatchers.eq(Collections.singletonList(Capability.VOICE.value())),
            eq(45)))
        .thenReturn(availableNumbersListDto);

    AvailableNumberListAllRequestParameters parameters =
        AvailableNumberListAllRequestParameters.builder()
            .setRegionCode("another region")
            .setType(NumberType.TOLL_FREE)
            .setNumberPattern(
                NumberPattern.builder()
                    .setPattern("pattern value")
                    .setSearchPattern(SearchPattern.END)
                    .build())
            .setCapabilities(Collections.singletonList(Capability.VOICE))
            .setSize(45)
            .build();

    Collection<AvailableNumber> expected =
        Collections.singletonList(
            AvailableNumber.builder()
                .setPhoneNumber("+46650553763")
                .setRegionCode("SE")
                .setType(NumberType.LOCAL)
                .setCapability(Collections.singletonList(Capability.VOICE))
                .setSetupPrice(new Money("DOLLAR", 0.57))
                .setMonthlyPrice(new Money("EUR", 0.80))
                .setPaymentIntervalMonths(1)
                .setSupportingDocumentationRequired(true)
                .build());

    AvailableNumberListResponse response = service.list(parameters);

    assertFalse(response.hasNextPage(), "Has no next page");
    assertThrows(NoSuchElementException.class, response::nextPage);
    Assertions.assertThat(response.getContent()).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void get() {

    when(api.numberServiceGetAvailableNumber(eq(configuration.getProjectId()), eq("foo")))
        .thenReturn(getNumberDto);

    AvailableNumber response = service.checkAvailability("foo");

    AvailableNumber expected =
        AvailableNumber.builder()
            .setPhoneNumber("+46650553763")
            .setRegionCode("SE")
            .setType(NumberType.LOCAL)
            .setCapability(Collections.singletonList(Capability.VOICE))
            .setSetupPrice(new Money("DOLLAR", 0.57))
            .setMonthlyPrice(new Money("EUR", 0.80))
            .setPaymentIntervalMonths(1)
            .setSupportingDocumentationRequired(true)
            .build();

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void rent() {

    when(api.numberServiceRentNumber(eq(configuration.getProjectId()), eq("foo"), any()))
        .thenReturn(rentNumberDto);

    ActiveNumber response =
        service.rent(
            "foo",
            new AvailableNumberRentRequestParameters(
                new RentSMSConfigurationRequestParameters("", ""),
                new RentVoiceConfigurationRequestParameters(""),
                "foo"));
    ActiveNumber expected =
        ActiveNumber.builder()
            .setRegionCode("US")
            .setPaymentIntervalMonths(0)
            .setNextChargeDate(
                OffsetDateTime.parse("2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    .toInstant())
            .setExpireAt(
                OffsetDateTime.parse("2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    .toInstant())
            .setPhoneNumber("+12025550134")
            .setProjectId("51bc3f40-f266-4ca8-8938-a1ed0ff32b9a")
            .setDisplayName("string")
            .setType(NumberType.MOBILE)
            .setCapability(Collections.singletonList(Capability.SMS))
            .setMoney(new Money("USD", 2.00))
            .setSmsConfiguration(
                new SMSConfiguration(
                    "string",
                    "string",
                    new ScheduledSmsProvisioning(
                        "8200000f74924bd6800000b212f00000",
                        "string",
                        ProvisioningStatus.WAITING,
                        OffsetDateTime.parse(
                                "2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                            .toInstant(),
                        Collections.emptyList())))
            .setVoiceConfiguration(
                new VoiceConfiguration(
                    "string",
                    OffsetDateTime.parse(
                            "2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                        .toInstant(),
                    new ScheduledVoiceProvisioning(
                        "string",
                        ProvisioningStatus.WAITING,
                        OffsetDateTime.parse(
                                "2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                            .toInstant())))
            .setCallbackUrl("https://www.your-callback-server.com/callback")
            .build();

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void rentAny() {

    when(api.numberServiceRentAnyNumber(eq(configuration.getProjectId()), any()))
        .thenReturn(rentNumberDto);

    AvailableNumberRentAnyRequestParameters parameters =
        AvailableNumberRentAnyRequestParameters.builder()
            .setRegionCode("foo region")
            .setType(NumberType.MOBILE)
            .build();
    ActiveNumber response = service.rentAny(parameters);
    ActiveNumber expected =
        ActiveNumber.builder()
            .setRegionCode("US")
            .setPaymentIntervalMonths(0)
            .setNextChargeDate(
                OffsetDateTime.parse("2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    .toInstant())
            .setExpireAt(
                OffsetDateTime.parse("2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                    .toInstant())
            .setPhoneNumber("+12025550134")
            .setProjectId("51bc3f40-f266-4ca8-8938-a1ed0ff32b9a")
            .setDisplayName("string")
            .setType(NumberType.MOBILE)
            .setCapability(Collections.singletonList(Capability.SMS))
            .setMoney(new Money("USD", 2.00))
            .setSmsConfiguration(
                new SMSConfiguration(
                    "string",
                    "string",
                    new ScheduledSmsProvisioning(
                        "8200000f74924bd6800000b212f00000",
                        "string",
                        ProvisioningStatus.WAITING,
                        OffsetDateTime.parse(
                                "2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                            .toInstant(),
                        Collections.emptyList())))
            .setVoiceConfiguration(
                new VoiceConfiguration(
                    "string",
                    OffsetDateTime.parse(
                            "2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                        .toInstant(),
                    new ScheduledVoiceProvisioning(
                        "string",
                        ProvisioningStatus.WAITING,
                        OffsetDateTime.parse(
                                "2019-08-24T14:15:22Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                            .toInstant())))
            .setCallbackUrl("https://www.your-callback-server.com/callback")
            .build();

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }
}
