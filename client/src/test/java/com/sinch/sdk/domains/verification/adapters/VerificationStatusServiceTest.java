package com.sinch.sdk.domains.verification.adapters;

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
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationStatusApi;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationStatus;
import com.sinch.sdk.domains.verification.models.dto.v1.status.VerificationStatusResponseInternalTest;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationStatusServiceTest extends BaseTest {

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
        .thenReturn(VerificationStatusResponseInternalTest.expectedVerificationSmsDto);

    VerificationStatus response =
        service.getByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationMethodType.SMS);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationStatusSmsResponse);
  }

  @Test
  void getById() throws ApiException {

    when(api.verificationStatusById(eq("the id")))
        .thenReturn(VerificationStatusResponseInternalTest.expectedVerificationPhoneCallDto);

    VerificationStatus response = service.getById(VerificationId.valueOf("the id"));

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationStatusPhoneCallResponse);
  }

  @Test
  void getByReference() throws ApiException {

    when(api.verificationStatusByReference(eq("the reference")))
        .thenReturn(VerificationStatusResponseInternalTest.expectedVerificationPhoneCallDto);

    VerificationStatus response =
        service.getByReference(VerificationReference.valueOf("the reference"));

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationStatusPhoneCallResponse);
  }
}
