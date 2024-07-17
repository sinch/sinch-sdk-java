package com.sinch.sdk.domains.numbers.adapters;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.adapters.converters.ActiveNumberDtoConverterTest;
import com.sinch.sdk.domains.numbers.models.*;
import com.sinch.sdk.domains.numbers.models.requests.*;
import com.sinch.sdk.domains.numbers.models.responses.AvailableNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.AvailableNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class AvailableNumberServiceTest extends BaseTest {

  AvailableNumberService service;
  @Mock com.sinch.sdk.domains.numbers.api.v1.NumbersService v1;

  @BeforeEach
  public void initMocks() {
    service = spy(new AvailableNumberService(v1));
  }

  @Test
  void list() throws ApiException {

    when(v1.searchForAvailableNumbers(
            eq(
                AvailableNumberListRequest.builder()
                    .setRegionCode("region")
                    .setType(com.sinch.sdk.domains.numbers.models.v1.NumberType.MOBILE)
                    .build())))
        .thenReturn(
            new com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse(
                AvailableNumberDtoTest.availableNumberList.getAvailableNumbers()));

    AvailableNumberListAllRequestParameters parameters =
        AvailableNumberListAllRequestParameters.builder()
            .setRegionCode("region")
            .setType(NumberType.MOBILE)
            .build();

    Collection<AvailableNumber> expected =
        new ArrayList<>(
            Collections.singletonList(
                AvailableNumber.builder()
                    .setPhoneNumber("+46650553763")
                    .setRegionCode("SE")
                    .setType(NumberType.LOCAL)
                    .setCapability(new ArrayList<>(Collections.singletonList(Capability.VOICE)))
                    .setSetupPrice(new Money("DOLLAR", 0.57))
                    .setMonthlyPrice(new Money("EUR", 0.80))
                    .setPaymentIntervalMonths(1)
                    .setSupportingDocumentationRequired(true)
                    .build()));

    AvailableNumberListResponse response = service.list(parameters);

    assertFalse(response.hasNextPage(), "Has no next page");
    assertThrows(NoSuchElementException.class, response::nextPage);
    TestHelpers.recursiveEquals(response.getContent(), expected);
  }

  @Test
  void listWithParameters() throws ApiException {

    when(v1.searchForAvailableNumbers(
            eq(
                AvailableNumberListRequest.builder()
                    .setRegionCode("another region")
                    .setType(com.sinch.sdk.domains.numbers.models.v1.NumberType.TOLL_FREE)
                    .setSearchPattern(
                        com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern.builder()
                            .setPattern("pattern value")
                            .setPosition(SearchPosition.END)
                            .build())
                    .setCapabilities(
                        Collections.singletonList(
                            com.sinch.sdk.domains.numbers.models.v1.Capability.VOICE))
                    .setSize(45)
                    .build())))
        .thenReturn(
            new com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse(
                AvailableNumberDtoTest.availableNumberList.getAvailableNumbers()));

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
        new ArrayList<>(
            Collections.singletonList(
                AvailableNumber.builder()
                    .setPhoneNumber("+46650553763")
                    .setRegionCode("SE")
                    .setType(NumberType.LOCAL)
                    .setCapability(new ArrayList<>(Collections.singletonList(Capability.VOICE)))
                    .setSetupPrice(new Money("DOLLAR", 0.57))
                    .setMonthlyPrice(new Money("EUR", 0.80))
                    .setPaymentIntervalMonths(1)
                    .setSupportingDocumentationRequired(true)
                    .build()));

    AvailableNumberListResponse response = service.list(parameters);

    assertFalse(response.hasNextPage(), "Has no next page");
    assertThrows(NoSuchElementException.class, response::nextPage);
    TestHelpers.recursiveEquals(response.getContent(), expected);
  }

  @Test
  void get() {

    when(v1.checkAvailability(eq("foo"))).thenReturn(AvailableNumberDtoTest.availableNumber);

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

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void rent() {

    when(v1.rent(eq("foo"), any())).thenReturn(ActiveNumberDtoTest.activeNumber);

    ActiveNumber response =
        service.rent(
            "foo",
            AvailableNumberRentRequestParameters.builder()
                .setSmsConfiguration(
                    RentSMSConfigurationRequestParameters.builder()
                        .setServicePlanId("")
                        .setCampaignId("")
                        .build())
                .setVoiceConfiguration(
                    RentVoiceConfigurationRequestParameters.builder().setAppId("").build())
                .setCallbackUrl("foo")
                .build());

    TestHelpers.recursiveEquals(response, ActiveNumberDtoConverterTest.activeNumber);
  }

  @Test
  void rentAny() {

    when(v1.rentAny(any())).thenReturn(ActiveNumberDtoTest.activeNumber);

    AvailableNumberRentAnyRequestParameters parameters =
        AvailableNumberRentAnyRequestParameters.builder()
            .setRegionCode("foo region")
            .setType(NumberType.MOBILE)
            .build();
    ActiveNumber response = service.rentAny(parameters);

    TestHelpers.recursiveEquals(response, ActiveNumberDtoConverterTest.activeNumber);
  }
}
