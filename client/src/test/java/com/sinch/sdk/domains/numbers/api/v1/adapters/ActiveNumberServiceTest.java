package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.domains.numbers.api.v1.internal.ActiveNumberApi;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SearchPattern;
import com.sinch.sdk.domains.numbers.models.v1.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.active.request.OrderBy;
import com.sinch.sdk.domains.numbers.models.v1.active.response.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.active.response.internal.ActiveNumberListResponseInternal;
import com.sinch.sdk.models.NumbersContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

@TestWithResources
class ActiveNumberServiceTest extends NumbersBaseTest {

  @GivenJsonResource("/domains/numbers/v1/active/active-numbers-list-light.json")
  ActiveNumberListResponseInternal activeNumbersListLightDto;

  @GivenJsonResource("/domains/numbers/v1/active/active-numbers-list.json")
  ActiveNumberListResponseInternal activeNumbersListDto;

  @GivenJsonResource("/domains/numbers/v1/active/active-numbers-get.json")
  ActiveNumber activeGetResponseDto;

  @Mock NumbersContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock ActiveNumberApi api;
  ActiveNumberService service;

  String uriUUID = "foo";

  @BeforeEach
  public void initMocks() {
    ActiveNumberService v1 = new ActiveNumberService(uriUUID, context, httpClient, authManagers);
    service = spy(v1);
    doReturn(api).when(service).getApi();
  }

  @Test
  void list() throws ApiException {

    when(api.numberServiceListActiveNumbers(
            eq(uriUUID),
            eq("region"),
            eq(NumberType.MOBILE.value()),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(activeNumbersListLightDto);

    ActiveNumberListResponse expected =
        new ActiveNumberListResponse(
            service,
            new Page<>(
                ActiveNumberListRequest.builder()
                    .setRegionCode("region")
                    .setType(NumberType.MOBILE)
                    .build(),
                activeNumbersListLightDto.getActiveNumbers(),
                new TokenPageNavigator("")));

    ActiveNumberListResponse response =
        service.list(
            ActiveNumberListRequest.builder()
                .setRegionCode("region")
                .setType(NumberType.MOBILE)
                .build());

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void listWithParameters() throws ApiException {

    when(api.numberServiceListActiveNumbers(
            eq(uriUUID),
            eq("another region"),
            eq(NumberType.TOLL_FREE.value()),
            eq("pattern value"),
            eq(SearchPosition.END.value()),
            eq(Collections.singletonList(Capability.VOICE.value())),
            eq(5),
            eq("foo"),
            eq(OrderBy.PHONE_NUMBER.value())))
        .thenReturn(activeNumbersListDto);

    ActiveNumberListRequest parameters =
        ActiveNumberListRequest.builder()
            .setRegionCode("another region")
            .setType(NumberType.TOLL_FREE)
            .setSearchPattern(
                SearchPattern.builder()
                    .setPattern("pattern value")
                    .setPosition(SearchPosition.END)
                    .build())
            .setCapabilities(Arrays.asList(Capability.VOICE))
            .setPageSize(5)
            .setPageToken("foo")
            .setOrderBy(OrderBy.PHONE_NUMBER)
            .build();

    ActiveNumberListResponse expected =
        new ActiveNumberListResponse(
            service,
            new Page<>(
                ActiveNumberListRequest.builder()
                    .setRegionCode("another region")
                    .setType(NumberType.TOLL_FREE)
                    .setSearchPattern(
                        SearchPattern.builder()
                            .setPattern("pattern value")
                            .setPosition(SearchPosition.END)
                            .build())
                    .setCapabilities(Arrays.asList(Capability.VOICE))
                    .setPageSize(5)
                    .setPageToken("foo")
                    .setOrderBy(OrderBy.PHONE_NUMBER)
                    .build(),
                activeNumbersListDto.getActiveNumbers(),
                new TokenPageNavigator("foo")));

    ActiveNumberListResponse response = service.list(parameters);

    TestHelpers.recursiveEquals(response, expected);
  }

  @Test
  void get() throws ApiException {

    when(api.numberServiceGetActiveNumber(eq(uriUUID), eq("foo phone number")))
        .thenReturn(activeGetResponseDto);

    ActiveNumber response = service.get("foo phone number");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(activeGetResponseDto);
  }

  @Test
  void release() throws ApiException {

    when(api.numberServiceReleaseNumber(eq(uriUUID), eq("foo phone number")))
        .thenReturn(activeGetResponseDto);

    ActiveNumber response = service.release("foo phone number");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(activeGetResponseDto);
  }

  @Test
  void update() {

    SmsConfiguration smsConfiguration =
        SmsConfiguration.builder()
            .setServicePlanId("service plan id")
            .setCampaignId("campaign id")
            .build();

    VoiceConfiguration voiceConfiguration =
        VoiceConfigurationRTC.builder().setAppId("app id").build();

    ActiveNumberUpdateRequest parameters =
        ActiveNumberUpdateRequest.builder()
            .setDisplayName("my display name")
            .setSmsConfiguration(smsConfiguration)
            .setVoiceConfiguration(voiceConfiguration)
            .setCallbackUrl("foo callback")
            .build();

    when(api.numberServiceUpdateActiveNumber(
            eq(uriUUID), eq("foo phone number"), ArgumentMatchers.eq(parameters)))
        .thenReturn(activeGetResponseDto);

    ActiveNumber response = service.update("foo phone number", parameters);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(activeGetResponseDto);
  }
}
