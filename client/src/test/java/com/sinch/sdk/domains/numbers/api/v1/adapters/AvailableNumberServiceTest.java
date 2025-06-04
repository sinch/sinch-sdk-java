package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.numbers.api.v1.internal.AvailableNumberApi;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.AvailableNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse;
import com.sinch.sdk.models.NumbersContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class AvailableNumberServiceTest extends BaseTest {

  @Mock NumbersContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock AvailableNumberApi api;
  AvailableNumberService service;

  String uriUUID = "foo";

  @BeforeEach
  public void initMocks() {
    AvailableNumberService v1 =
        new AvailableNumberService(uriUUID, context, () -> httpClient, authManagers);
    service = spy(v1);
    doReturn(api).when(service).getApi();
  }

  @Test
  void list() throws ApiException {

    when(api.numberServiceListAvailableNumbers(
            eq(uriUUID),
            eq("region"),
            eq(NumberType.MOBILE.value()),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(AvailableNumberDtoTest.availableNumberList);

    AvailableNumberListResponse expected =
        new AvailableNumberListResponse(
            AvailableNumberDtoTest.availableNumberList.getAvailableNumbers());

    AvailableNumberListResponse response =
        service.list(
            AvailableNumberListRequest.builder()
                .setRegionCode("region")
                .setType(NumberType.MOBILE)
                .build());

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void listWithParameters() throws ApiException {

    when(api.numberServiceListAvailableNumbers(
            eq(uriUUID),
            eq("another region"),
            eq(NumberType.TOLL_FREE.value()),
            eq("pattern value"),
            eq(SearchPosition.END.value()),
            eq(Collections.singletonList(Capability.VOICE.value())),
            eq(5)))
        .thenReturn(AvailableNumberDtoTest.availableNumberList);

    AvailableNumberListRequest parameters =
        AvailableNumberListRequest.builder()
            .setRegionCode("another region")
            .setType(NumberType.TOLL_FREE)
            .setSearchPattern(
                SearchPattern.builder()
                    .setPattern("pattern value")
                    .setPosition(SearchPosition.END)
                    .build())
            .setCapabilities(Arrays.asList(Capability.VOICE))
            .setSize(5)
            .build();

    AvailableNumberListResponse expected =
        new AvailableNumberListResponse(
            AvailableNumberDtoTest.availableNumberList.getAvailableNumbers());

    AvailableNumberListResponse response = service.list(parameters);

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void rentDefault() {

    AvailableNumberRentRequest request = AvailableNumberRentRequest.builder().build();

    when(api.numberServiceRentNumber(eq(uriUUID), eq("foo"), eq(request)))
        .thenReturn(ActiveNumberDtoTest.activeNumber);

    ActiveNumber response = service.rent("foo");

    TestHelpers.recursiveEquals(response, ActiveNumberDtoTest.activeNumber);
  }

  @Test
  void rent() {

    AvailableNumberRentRequest request =
        AvailableNumberRentRequest.builder()
            .setSmsConfiguration(
                SmsConfiguration.builder().setServicePlanId("").setCampaignId("").build())
            .setVoiceConfiguration(VoiceConfigurationRTC.builder().setAppId("").build())
            .setCallbackUrl("foo")
            .build();

    when(api.numberServiceRentNumber(eq(uriUUID), eq("foo"), eq(request)))
        .thenReturn(ActiveNumberDtoTest.activeNumber);

    ActiveNumber response = service.rent("foo", request);

    TestHelpers.recursiveEquals(response, ActiveNumberDtoTest.activeNumber);
  }

  @Test
  void rentAny() {

    AvailableNumberRentAnyRequest request =
        AvailableNumberRentAnyRequest.builder()
            .setRegionCode("foo region")
            .setType(NumberType.MOBILE)
            .build();

    when(api.numberServiceRentAnyNumber(eq(uriUUID), eq(request)))
        .thenReturn(ActiveNumberDtoTest.activeNumber);
    ActiveNumber response = service.rentAny(request);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ActiveNumberDtoTest.activeNumber);
  }
}
