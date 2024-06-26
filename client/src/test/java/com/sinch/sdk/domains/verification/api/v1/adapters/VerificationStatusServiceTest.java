package com.sinch.sdk.domains.verification.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationStatusApi;
import com.sinch.sdk.domains.verification.models.dto.v1.status.VerificationStatusResponseTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationStatusServiceTest extends VerificationBaseTest {

  @Mock VerificationStatusApi api;
  @Mock VerificationContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  VerificationStatusService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new VerificationStatusService(context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getByIdentity() throws ApiException {

    when(api.verificationStatusByIdentity(eq("endpoint string"), eq("sms")))
        .thenReturn(VerificationStatusResponseTest.expectedVerificationSmsDto);

    VerificationStatusResponse response =
        service.getByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationMethod.SMS);

    TestHelpers.recursiveEquals(
        response,
        VerificationStatusResponseTest.expectedVerificationSmsDto
            .getVerificationStatusResponseSmsImpl());
  }

  @Test
  void getById() throws ApiException {

    when(api.verificationStatusById(eq("the id")))
        .thenReturn(VerificationStatusResponseTest.expectedVerificationPhoneCallDto);

    VerificationStatusResponse response = service.getById("the id");

    TestHelpers.recursiveEquals(
        response,
        VerificationStatusResponseTest.expectedVerificationPhoneCallDto
            .getVerificationStatusResponsePhoneCallImpl());
  }

  @Test
  void getByReference() throws ApiException {

    when(api.verificationStatusByReference(eq("the reference")))
        .thenReturn(VerificationStatusResponseTest.expectedVerificationFlashCallDto);

    VerificationStatusResponse response = service.getByReference("the reference");

    TestHelpers.recursiveEquals(
        response,
        VerificationStatusResponseTest.expectedVerificationFlashCallDto
            .getVerificationStatusResponseFlashCallImpl());
  }
}
