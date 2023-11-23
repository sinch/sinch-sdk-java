package com.sinch.sdk.domains.verification.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiDeliveryFeedbackDto;
import com.sinch.sdk.domains.verification.adapters.api.v1.SendingAndReportingVerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.models.dto.v1.InitiateVerificationResourceDto;
import com.sinch.sdk.domains.verification.models.dto.v1.StartStartVerificationResponseDtoTest;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
import com.sinch.sdk.models.Configuration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
public class VerificationsServiceTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/StartVerificationSMSRequestDto.json")
  public InitiateVerificationResourceDto startVerificationSMSRequestDto;

  @Mock Configuration configuration;
  @Mock SendingAndReportingVerificationsApi api;
  @InjectMocks VerificationsService service;

  @Captor ArgumentCaptor<ApiDeliveryFeedbackDto> recipientsCaptor;

  @Test
  void start() throws ApiException {

    when(api.startVerification(eq(startVerificationSMSRequestDto)))
        .thenReturn(StartStartVerificationResponseDtoTest.expectedStartVerificationSMSDto);

    StartVerificationResponse response =
        service.start(VerificationsDtoConverterTest.startVerificationSMSRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedStartVerificationSMSResponse);
  }
}
