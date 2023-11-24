package com.sinch.sdk.domains.verification.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.adapters.api.v1.QueryVerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportDtoTest;
import com.sinch.sdk.models.Configuration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
public class StatusServiceTest extends BaseTest {

  @Mock Configuration configuration;
  @Mock QueryVerificationsApi api;
  @InjectMocks StatusService service;

  @Test
  void getByIdentity() throws ApiException {

    when(api.verificationStatusByIdentity(eq("number"), eq("endpoint string"), eq("sms")))
        .thenReturn(VerificationReportDtoTest.expectedVerificationCalloutDto);

    VerificationReport response =
        service.getByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationMethodType.SMS);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportCalloutResponse);
  }

  @Test
  void getById() throws ApiException {

    when(api.verificationStatusById(eq("the id")))
        .thenReturn(VerificationReportDtoTest.expectedVerificationCalloutDto);

    VerificationReport response = service.getById("the id");

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportCalloutResponse);
  }

  @Test
  void getByReference() throws ApiException {

    when(api.verificationStatusByReference(eq("the reference")))
        .thenReturn(VerificationReportDtoTest.expectedVerificationCalloutDto);

    VerificationReport response = service.getByReference("the reference");

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportCalloutResponse);
  }
}
