package com.sinch.sdk.domains.numbers.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.domains.numbers.adapters.api.v1.ActiveNumberApi;
import com.sinch.sdk.domains.numbers.adapters.converters.ActiveNumberUpdateRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.models.*;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumbersResponseDto;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberListRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateVoiceConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.ActiveNumberListResponse;
import com.sinch.sdk.models.Configuration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
class ActiveNumberServiceTest extends BaseTest {

  @GivenJsonResource("/domains/numbers/v1/active-numbers-list-light.json")
  ActiveNumbersResponseDto activeNumbersListLightDto;

  @GivenJsonResource("/domains/numbers/v1/active-numbers-list.json")
  ActiveNumbersResponseDto activeNumbersListDto;

  @GivenJsonResource("/domains/numbers/v1/active-numbers-get.json")
  ActiveNumberDto activeGetResponseDto;

  @Mock Configuration configuration;
  @Mock ActiveNumberApi api;
  @InjectMocks ActiveNumberService service;

  @Test
  void list() throws ApiException {

    when(api.numberServiceListActiveNumbers(
            eq(configuration.getProjectId()),
            eq("region"),
            eq(NumberType.MOBILE.value()),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null),
            eq(null)))
        .thenReturn(activeNumbersListLightDto);

    ActiveNumberListResponse response =
        service.list(
            ActiveNumberListRequestParameters.builder()
                .setRegionCode("region")
                .setType(NumberType.MOBILE)
                .build());

    Page<ActiveNumberListRequestParameters, ActiveNumber, String> expected =
        new Page<>(
            ActiveNumberListRequestParameters.builder()
                .setRegionCode("region")
                .setType(NumberType.MOBILE)
                .build(),
            Collections.singletonList(
                ActiveNumber.builder()
                    .setPhoneNumber("+447520651116XYZ")
                    .setProjectId("project id")
                    .setRegionCode("GB")
                    .setType(NumberType.MOBILE)
                    .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
                    .setDisplayName("")
                    .setMoney(new Money("EUR", 0.80))
                    .setPaymentIntervalMonths(1)
                    .setNextChargeDate(Instant.parse("2023-09-22T15:49:58.813424Z"))
                    .setExpireAt(Instant.parse("2023-10-06T15:49:58.813381Z"))
                    .setSmsConfiguration(new SMSConfiguration("service plan id", "", null))
                    .setVoiceConfiguration(new VoiceConfiguration("app id", null, null))
                    .setCallbackUrl("")
                    .build()),
            new TokenPageNavigator(""));
    Assertions.assertThat(response.getContent())
        .usingRecursiveComparison()
        .isEqualTo(expected.getEntities());
  }

  @Test
  void listWithParameters() throws ApiException {

    when(api.numberServiceListActiveNumbers(
            eq(configuration.getProjectId()),
            eq("another region"),
            eq(NumberType.TOLL_FREE.value()),
            eq("pattern value"),
            eq(SearchPattern.END.value()),
            eq(Collections.singletonList(Capability.VOICE.value())),
            eq(5),
            eq("foo"),
            eq(OrderBy.PHONE_NUMBER.value())))
        .thenReturn(activeNumbersListDto);

    ActiveNumberListRequestParameters parameters =
        ActiveNumberListRequestParameters.builder()
            .setRegionCode("another region")
            .setType(NumberType.TOLL_FREE)
            .setNumberPattern(
                NumberPattern.builder()
                    .setPattern("pattern value")
                    .setSearchPattern(SearchPattern.END)
                    .build())
            .setCapabilities(Collections.singletonList(Capability.VOICE))
            .setPageSize(5)
            .setPageToken("foo")
            .setOrderBy(OrderBy.PHONE_NUMBER)
            .build();

    Page<ActiveNumberListRequestParameters, ActiveNumber, String> expected =
        new Page<>(
            ActiveNumberListRequestParameters.builder()
                .setRegionCode("another region")
                .setType(NumberType.TOLL_FREE)
                .setNumberPattern(
                    NumberPattern.builder()
                        .setPattern("pattern value")
                        .setSearchPattern(SearchPattern.END)
                        .build())
                .setCapabilities(Collections.singletonList(Capability.VOICE))
                .setPageSize(5)
                .setPageToken("foo")
                .setOrderBy(OrderBy.PHONE_NUMBER)
                .build(),
            Collections.singletonList(
                ActiveNumber.builder()
                    .setPhoneNumber("+447520651116XYZ")
                    .setProjectId("project id")
                    .setRegionCode("GB")
                    .setType(NumberType.MOBILE)
                    .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
                    .setDisplayName("a display")
                    .setMoney(new Money("EUR", 0.80))
                    .setPaymentIntervalMonths(1)
                    .setNextChargeDate(Instant.parse("2023-09-22T15:49:58.813424Z"))
                    .setExpireAt(Instant.parse("2023-10-06T15:49:58.813381Z"))
                    .setSmsConfiguration(
                        new SMSConfiguration(
                            "service plan id",
                            null,
                            new ScheduledSmsProvisioning(
                                "service plan id from scheduled",
                                "campaign id from scheduled",
                                ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                                Instant.parse("2023-09-25T12:08:02.115Z"),
                                Collections.singletonList(SmsErrorCode.ERROR_CODE_UNSPECIFIED))))
                    .setVoiceConfiguration(
                        new VoiceConfiguration(
                            "app id",
                            Instant.parse("2023-09-25T12:08:02.115Z"),
                            new ScheduledVoiceProvisioning(
                                "app id from scheduled",
                                ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                                Instant.parse("2023-09-25T12:08:02.115Z"))))
                    .setCallbackUrl("foo callback")
                    .build()),
            new TokenPageNavigator("foo"));

    ActiveNumberListResponse response = service.list(parameters);

    Assertions.assertThat(response.getContent())
        .usingRecursiveComparison()
        .isEqualTo(expected.getEntities());
  }

  @Test
  void get() throws ApiException {

    when(api.numberServiceGetActiveNumber(eq(configuration.getProjectId()), eq("foo phone number")))
        .thenReturn(activeGetResponseDto);

    ActiveNumber expected =
        ActiveNumber.builder()
            .setPhoneNumber("+447520651116XYZ")
            .setProjectId("project id")
            .setRegionCode("GB")
            .setType(NumberType.MOBILE)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setDisplayName("a display")
            .setMoney(new Money("EUR", 0.80))
            .setPaymentIntervalMonths(1)
            .setNextChargeDate(Instant.parse("2023-09-22T15:49:58.813424Z"))
            .setExpireAt(Instant.parse("2023-10-06T15:49:58.813381Z"))
            .setSmsConfiguration(
                new SMSConfiguration(
                    "service plan id",
                    null,
                    new ScheduledSmsProvisioning(
                        "service plan id from scheduled",
                        "campaign id from scheduled",
                        ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                        Instant.parse("2023-09-25T12:08:02.115Z"),
                        Collections.singletonList(SmsErrorCode.ERROR_CODE_UNSPECIFIED))))
            .setVoiceConfiguration(
                new VoiceConfiguration(
                    "app id",
                    Instant.parse("2023-09-25T12:08:02.115Z"),
                    new ScheduledVoiceProvisioning(
                        "app id from scheduled",
                        ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                        Instant.parse("2023-09-25T12:08:02.115Z"))))
            .setCallbackUrl("foo callback")
            .build();

    ActiveNumber response = service.get("foo phone number");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void release() throws ApiException {

    when(api.numberServiceReleaseNumber(eq(configuration.getProjectId()), eq("foo phone number")))
        .thenReturn(activeGetResponseDto);

    ActiveNumber expected =
        ActiveNumber.builder()
            .setPhoneNumber("+447520651116XYZ")
            .setProjectId("project id")
            .setRegionCode("GB")
            .setType(NumberType.MOBILE)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setDisplayName("a display")
            .setMoney(new Money("EUR", 0.80))
            .setPaymentIntervalMonths(1)
            .setNextChargeDate(Instant.parse("2023-09-22T15:49:58.813424Z"))
            .setExpireAt(Instant.parse("2023-10-06T15:49:58.813381Z"))
            .setSmsConfiguration(
                new SMSConfiguration(
                    "service plan id",
                    null,
                    new ScheduledSmsProvisioning(
                        "service plan id from scheduled",
                        "campaign id from scheduled",
                        ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                        Instant.parse("2023-09-25T12:08:02.115Z"),
                        Collections.singletonList(SmsErrorCode.ERROR_CODE_UNSPECIFIED))))
            .setVoiceConfiguration(
                new VoiceConfiguration(
                    "app id",
                    Instant.parse("2023-09-25T12:08:02.115Z"),
                    new ScheduledVoiceProvisioning(
                        "app id from scheduled",
                        ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                        Instant.parse("2023-09-25T12:08:02.115Z"))))
            .setCallbackUrl("foo callback")
            .build();

    ActiveNumber response = service.release("foo phone number");

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  void update() {

    ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration =
        ActiveNumberUpdateSMSConfigurationRequestParameters.builder()
            .setServicePlanId("service plan id")
            .setCampaignId("campaign id")
            .build();

    ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration =
        ActiveNumberUpdateVoiceConfigurationRequestParameters.builder().setAppId("app id").build();
    ActiveNumberUpdateRequestParameters parameters =
        ActiveNumberUpdateRequestParameters.builder()
            .setDisplayName("my display name")
            .setSmsConfiguration(smsConfiguration)
            .setVoiceConfiguration(voiceConfiguration)
            .setCallback("foo callback")
            .build();

    when(api.numberServiceUpdateActiveNumber(
            eq(configuration.getProjectId()),
            eq("foo phone number"),
            ArgumentMatchers.eq(
                ActiveNumberUpdateRequestParametersDtoConverter.convert(parameters))))
        .thenReturn(activeGetResponseDto);

    ActiveNumber expected =
        ActiveNumber.builder()
            .setPhoneNumber("+447520651116XYZ")
            .setProjectId("project id")
            .setRegionCode("GB")
            .setType(NumberType.MOBILE)
            .setCapability(Arrays.asList(Capability.SMS, Capability.VOICE))
            .setDisplayName("a display")
            .setMoney(new Money("EUR", 0.80))
            .setPaymentIntervalMonths(1)
            .setNextChargeDate(Instant.parse("2023-09-22T15:49:58.813424Z"))
            .setExpireAt(Instant.parse("2023-10-06T15:49:58.813381Z"))
            .setSmsConfiguration(
                new SMSConfiguration(
                    "service plan id",
                    null,
                    new ScheduledSmsProvisioning(
                        "service plan id from scheduled",
                        "campaign id from scheduled",
                        ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                        Instant.parse("2023-09-25T12:08:02.115Z"),
                        Collections.singletonList(SmsErrorCode.ERROR_CODE_UNSPECIFIED))))
            .setVoiceConfiguration(
                new VoiceConfiguration(
                    "app id",
                    Instant.parse("2023-09-25T12:08:02.115Z"),
                    new ScheduledVoiceProvisioning(
                        "app id from scheduled",
                        ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                        Instant.parse("2023-09-25T12:08:02.115Z"))))
            .setCallbackUrl("foo callback")
            .build();

    ActiveNumber response = service.update("foo phone number", parameters);

    Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expected);
  }
}
