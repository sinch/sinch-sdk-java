package com.sinch.sdk.domains.verification.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.adapters.api.v1.SendingAndReportingVerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.StartVerificationResponseDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportRequestResourceDto;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import java.util.function.Supplier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationsServiceTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/StartVerificationSMSRequestDto.json")
  public InitiateVerificationResourceDto startVerificationSMSRequestDto;

  @GivenJsonResource("/domains/verification/v1/VerificationReportCalloutRequestDto.json")
  public VerificationReportRequestResourceDto verificationReportRequestResourceDto;

  @Mock SendingAndReportingVerificationsApi api;
  @Mock Configuration configuration;
  @Mock HttpClient httpClient;
  @Mock Supplier<Map<String, AuthManager>> authManagerSupplier;

  VerificationsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new VerificationsService(configuration, httpClient, authManagerSupplier));
    doReturn(api).when(service).getApi();
  }

  @Test
  void start() throws ApiException {

    when(api.startVerification(eq(startVerificationSMSRequestDto)))
        .thenReturn(StartVerificationResponseDtoTest.expectedStartVerificationSMSDto);

    StartVerificationResponse response =
        service.start(VerificationsDtoConverterTest.startVerificationSMSRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedStartVerificationSMSResponse);
  }

  @Test
  void getByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("number"), eq("endpoint string"), eq(verificationReportRequestResourceDto)))
        .thenReturn(VerificationReportDtoTest.expectedVerificationCalloutDto);

    VerificationReport response =
        service.report(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationsDtoConverterTest.verificationReportCalloutRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportCalloutResponse);
  }

  @Test
  void getById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportRequestResourceDto)))
        .thenReturn(VerificationReportDtoTest.expectedVerificationCalloutDto);

    VerificationReport response =
        service.report(
            VerificationId.valueOf("the id"),
            VerificationsDtoConverterTest.verificationReportCalloutRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportCalloutResponse);
  }
}
