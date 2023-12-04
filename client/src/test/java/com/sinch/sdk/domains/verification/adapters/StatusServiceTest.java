package com.sinch.sdk.domains.verification.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.adapters.api.v1.QueryVerificationsApi;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.dto.v1.VerificationReportDtoTest;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import java.util.function.Supplier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class StatusServiceTest extends BaseTest {

  @Mock QueryVerificationsApi api;
  @Mock Configuration configuration;
  @Mock HttpClient httpClient;
  @Mock Supplier<Map<String, AuthManager>> authManagerSupplier;

  StatusService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new StatusService(configuration, httpClient, authManagerSupplier));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getByIdentity() throws ApiException {

    when(api.verificationStatusByIdentity(eq("number"), eq("endpoint string"), eq("sms")))
        .thenReturn(VerificationReportDtoTest.expectedVerificationCalloutDto);

    VerificationReport response =
        service.get(
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

    VerificationReport response = service.get(VerificationId.valueOf("the id"));

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportCalloutResponse);
  }

  @Test
  void getByReference() throws ApiException {

    when(api.verificationStatusByReference(eq("the reference")))
        .thenReturn(VerificationReportDtoTest.expectedVerificationCalloutDto);

    VerificationReport response = service.get(VerificationReference.valueOf("the reference"));

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportCalloutResponse);
  }
}
