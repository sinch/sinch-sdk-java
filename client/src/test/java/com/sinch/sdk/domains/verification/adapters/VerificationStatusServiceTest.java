package com.sinch.sdk.domains.verification.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationStatus;
import com.sinch.sdk.domains.verification.models.dto.v1.status.VerificationStatusResponseTest;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationStatusServiceTest extends BaseTest {

  @Mock com.sinch.sdk.domains.verification.api.v1.VerificationStatusService v1;

  VerificationStatusService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new VerificationStatusService(v1));
  }

  @Test
  void getByIdentity() throws ApiException {

    when(v1.getByIdentity(
            eq(
                com.sinch.sdk.domains.verification.models.v1.NumberIdentity.valueOf(
                    "endpoint string")),
            eq(VerificationMethod.SMS)))
        .thenReturn(
            VerificationStatusResponseTest.expectedVerificationSmsDto
                .getVerificationStatusResponseSmsImpl());

    VerificationStatus response =
        service.getByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationMethodType.SMS);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationStatusSmsResponse);
  }

  @Test
  void getById() throws ApiException {

    when(v1.getById(eq("the id")))
        .thenReturn(
            VerificationStatusResponseTest.expectedVerificationPhoneCallDto
                .getVerificationStatusResponsePhoneCallImpl());

    VerificationStatus response = service.getById(VerificationId.valueOf("the id"));

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationStatusPhoneCallResponse);
  }

  @Test
  void getByReference() throws ApiException {

    when(v1.getByReference(eq("the reference")))
        .thenReturn(
            VerificationStatusResponseTest.expectedVerificationFlashCallDto
                .getVerificationStatusResponseFlashCallImpl());

    VerificationStatus response =
        service.getByReference(VerificationReference.valueOf("the reference"));

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationStatusFlashCallResponse);
  }
}
