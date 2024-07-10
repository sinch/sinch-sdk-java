package com.sinch.sdk.domains.numbers.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.Money;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.OrderBy;
import com.sinch.sdk.domains.numbers.models.ProvisioningStatus;
import com.sinch.sdk.domains.numbers.models.SMSConfiguration;
import com.sinch.sdk.domains.numbers.models.ScheduledSmsProvisioning;
import com.sinch.sdk.domains.numbers.models.ScheduledVoiceProvisioning;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import com.sinch.sdk.domains.numbers.models.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberListRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateVoiceConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumberDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberListRequest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

@TestWithResources
class ActiveNumberServiceTest extends BaseTest {

  @Mock com.sinch.sdk.domains.numbers.api.v1.NumbersService v1;

  ActiveNumberService service;

  ActiveNumber expectedNumberResponse =
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
                  "campaign id",
                  new ScheduledSmsProvisioning(
                      "service plan id from scheduled",
                      "campaign id from scheduled",
                      ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                      Instant.parse("2023-09-25T12:08:02.115Z"),
                      Arrays.asList(SmsErrorCode.ERROR_CODE_UNSPECIFIED))))
          .setVoiceConfiguration(
              new VoiceConfiguration(
                  "AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE",
                  Instant.parse("2024-06-30T07:08:09.100Z"),
                  new ScheduledVoiceProvisioning(
                      "EEEEEEEEEE-DDDD-CCCC-BBBB-AAAAAAAA",
                      ProvisioningStatus.WAITING,
                      Instant.parse("2024-07-01T11:58:35.610198Z"))))
          .setCallbackUrl("foo callback")
          .build();

  @BeforeEach
  public void initMocks() {
    service = spy(new ActiveNumberService(v1));
  }

  @Test
  void list() throws ApiException {

    com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse responseV1 =
        new com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse(
            v1,
            new Page<>(
                ActiveNumberListRequest.builder()
                    .setRegionCode("another region")
                    .setType(com.sinch.sdk.domains.numbers.models.v1.NumberType.MOBILE)
                    .build(),
                ActiveNumberDtoTest.activeNumberListLight.getActiveNumbers(),
                new TokenPageNavigator("")));

    when(v1.list(
            ActiveNumberListRequest.builder()
                .setRegionCode("region")
                .setType(com.sinch.sdk.domains.numbers.models.v1.NumberType.MOBILE)
                .build()))
        .thenReturn(responseV1);

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
            new ArrayList<>(
                Arrays.asList(
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
                        .build())),
            new TokenPageNavigator(""));

    TestHelpers.recursiveEquals(response.getContent(), expected.getEntities());
  }

  @Test
  void listWithParameters() throws ApiException {

    com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse responseV1 =
        new com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse(
            v1,
            new Page<>(
                ActiveNumberListRequest.builder()
                    .setRegionCode("another region")
                    .setType(com.sinch.sdk.domains.numbers.models.v1.NumberType.TOLL_FREE)
                    .setSearchPattern(
                        com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern.builder()
                            .setPattern("pattern value")
                            .setPosition(
                                com.sinch.sdk.domains.numbers.models.v1.request.SearchPosition.END)
                            .build())
                    .setCapabilities(
                        Arrays.asList(com.sinch.sdk.domains.numbers.models.v1.Capability.VOICE))
                    .setPageSize(5)
                    .setPageToken("foo")
                    .setOrderBy(
                        com.sinch.sdk.domains.numbers.models.v1.request.OrderBy.PHONE_NUMBER)
                    .build(),
                ActiveNumberDtoTest.activeNumberList.getActiveNumbers(),
                new TokenPageNavigator("foo")));

    when(v1.list(
            ActiveNumberListRequest.builder()
                .setRegionCode("another region")
                .setType(com.sinch.sdk.domains.numbers.models.v1.NumberType.TOLL_FREE)
                .setSearchPattern(
                    com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern.builder()
                        .setPattern("pattern value")
                        .setPosition(
                            com.sinch.sdk.domains.numbers.models.v1.request.SearchPosition.END)
                        .build())
                .setCapabilities(
                    Arrays.asList(com.sinch.sdk.domains.numbers.models.v1.Capability.VOICE))
                .setPageSize(5)
                .setPageToken("foo")
                .setOrderBy(com.sinch.sdk.domains.numbers.models.v1.request.OrderBy.PHONE_NUMBER)
                .build()))
        .thenReturn(responseV1);

    ActiveNumberListRequestParameters parameters =
        ActiveNumberListRequestParameters.builder()
            .setRegionCode("another region")
            .setType(NumberType.TOLL_FREE)
            .setNumberPattern(
                NumberPattern.builder()
                    .setPattern("pattern value")
                    .setSearchPattern(SearchPattern.END)
                    .build())
            .setCapabilities(Arrays.asList(Capability.VOICE))
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
                .setCapabilities(Arrays.asList(Capability.VOICE))
                .setPageSize(5)
                .setPageToken("foo")
                .setOrderBy(OrderBy.PHONE_NUMBER)
                .build(),
            new ArrayList<>(
                Arrays.asList(
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
                                "campaign id",
                                new ScheduledSmsProvisioning(
                                    "service plan id from scheduled",
                                    "campaign id from scheduled",
                                    ProvisioningStatus.PROVISIONING_STATUS_UNSPECIFIED,
                                    Instant.parse("2023-09-25T12:08:02.115Z"),
                                    Arrays.asList(SmsErrorCode.ERROR_CODE_UNSPECIFIED))))
                        .setVoiceConfiguration(
                            new VoiceConfiguration(
                                "AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE",
                                Instant.parse("2024-06-30T07:08:09.10Z"),
                                new ScheduledVoiceProvisioning(
                                    "EEEEEEEEEE-DDDD-CCCC-BBBB-AAAAAAAA",
                                    ProvisioningStatus.WAITING,
                                    Instant.parse("2024-07-01T11:58:35.610198Z"))))
                        .setCallbackUrl("foo callback")
                        .build())),
            new TokenPageNavigator("foo"));

    ActiveNumberListResponse response = service.list(parameters);

    TestHelpers.recursiveEquals(response.getContent(), expected.getEntities());
  }

  @Test
  void get() throws ApiException {

    when(v1.get(eq("foo phone number"))).thenReturn(ActiveNumberDtoTest.activeNumber);

    ActiveNumber response = service.get("foo phone number");

    TestHelpers.recursiveEquals(response, expectedNumberResponse);
  }

  @Test
  void release() throws ApiException {

    when(v1.release(eq("foo phone number"))).thenReturn(ActiveNumberDtoTest.activeNumber);

    ActiveNumber response = service.release("foo phone number");

    TestHelpers.recursiveEquals(response, expectedNumberResponse);
  }

  @Test
  void update() {

    ActiveNumberUpdateSMSConfigurationRequestParameters smsConfiguration =
        ActiveNumberUpdateSMSConfigurationRequestParameters.builder()
            .setServicePlanId("service plan id")
            .setCampaignId("campaign id")
            .build();

    ActiveNumberUpdateVoiceConfigurationRequestParameters voiceConfiguration =
        ActiveNumberUpdateVoiceConfigurationRequestParameters.builder()
            .setAppId("AAAAAAAA-BBBB-CCCC-DDDD-EEEEEEEEEE")
            .build();
    ActiveNumberUpdateRequestParameters parameters =
        ActiveNumberUpdateRequestParameters.builder()
            .setDisplayName("a display")
            .setSmsConfiguration(smsConfiguration)
            .setVoiceConfiguration(voiceConfiguration)
            .setCallback("foo callback")
            .build();

    when(v1.update(
            eq("foo phone number"),
            ArgumentMatchers.eq(ActiveNumberDtoTest.activeNumberUpdateRequest)))
        .thenReturn(ActiveNumberDtoTest.activeNumber);

    ActiveNumber response = service.update("foo phone number", parameters);

    TestHelpers.recursiveEquals(response, expectedNumberResponse);
  }
}
