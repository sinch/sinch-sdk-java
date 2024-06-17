package com.sinch.sdk.domains.verification.models.dto.v1.status;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.Price;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.status.StatusCallResult;
import com.sinch.sdk.domains.verification.models.v1.status.StatusPrice;
import com.sinch.sdk.domains.verification.models.v1.status.StatusSource;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseSms;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponseSmsPrice;
import com.sinch.sdk.domains.verification.models.v1.status.response.internal.VerificationStatusResponseInternal;
import com.sinch.sdk.domains.verification.models.v1.status.response.internal.VerificationStatusResponseInternalImpl;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationStatusResponseTest extends VerificationBaseTest {

  public static VerificationStatusResponseInternalImpl expectedVerificationPhoneCallDto =
      new VerificationStatusResponseInternalImpl(
          (VerificationStatusResponsePhoneCallImpl)
              VerificationStatusResponsePhoneCall.builder()
                  .setId("the id")
                  .setStatus(VerificationStatus.FAIL)
                  .setReason(VerificationStatusReason.FRAUD)
                  .setCallComplete(true)
                  .setReference("my reference")
                  .setPrice(
                      StatusPrice.builder()
                          .setVerificationPrice(
                              Price.builder()
                                  .setCurrencyId("verificationPrice currency id")
                                  .setAmount(3.141516F)
                                  .build())
                          .setTerminationPrice(
                              Price.builder()
                                  .setCurrencyId("terminationPrice currency id")
                                  .setAmount(6.626070F)
                                  .build())
                          .setBillableDuration(34)
                          .build())
                  .setIdentity(NumberIdentity.valueOf("endpoint value"))
                  .setCountryId("es-ES")
                  .setVerificationTimestamp(
                      DateUtil.failSafeTimeStampToInstant("2024-05-22T09:38:59.5590437"))
                  .setCallResult(StatusCallResult.ANSWERED)
                  .build());
  public static VerificationStatusResponseInternalImpl expectedVerificationFlashCallDto =
      new VerificationStatusResponseInternalImpl(
          (VerificationStatusResponseFlashCallImpl)
              VerificationStatusResponseFlashCall.builder()
                  .setId("the id")
                  .setStatus(VerificationStatus.FAIL)
                  .setReason(VerificationStatusReason.FRAUD)
                  .setReference("my reference")
                  .setPrice(
                      StatusPrice.builder()
                          .setVerificationPrice(
                              Price.builder()
                                  .setCurrencyId("verificationPrice currency id")
                                  .setAmount(3.141516F)
                                  .build())
                          .setTerminationPrice(
                              Price.builder()
                                  .setCurrencyId("terminationPrice currency id")
                                  .setAmount(6.626070F)
                                  .build())
                          .setBillableDuration(34)
                          .build())
                  .setSource(StatusSource.MANUAL)
                  .setIdentity(NumberIdentity.valueOf("endpoint value"))
                  .setCountryId("es-ES")
                  .setVerificationTimestamp(
                      DateUtil.failSafeTimeStampToInstant("2024-05-22T09:38:59.5590437"))
                  .setCallComplete(false)
                  .setCallResult(StatusCallResult.ANSWERED)
                  .build());
  public static VerificationStatusResponseInternalImpl expectedVerificationSmsDto =
      new VerificationStatusResponseInternalImpl(
          (VerificationStatusResponseSmsImpl)
              VerificationStatusResponseSms.builder()
                  .setId("the id")
                  .setReference("my reference")
                  .setStatus(VerificationStatus.FAIL)
                  .setReason(VerificationStatusReason.FRAUD)
                  .setSource(StatusSource.INTERCEPTED)
                  .setPrice(
                      VerificationStatusResponseSmsPrice.builder()
                          .setVerificationPrice(
                              Price.builder()
                                  .setCurrencyId("verificationPrice currency id")
                                  .setAmount(3.141516F)
                                  .build())
                          .build())
                  .setIdentity(NumberIdentity.valueOf("endpoint value"))
                  .setCountryId("es-ES")
                  .setVerificationTimestamp(
                      DateUtil.failSafeTimeStampToInstant("2024-05-22T09:38:59.5590437"))
                  .build());

  @GivenJsonResource("/domains/verification/v1/status/VerificationStatusResponsePhoneCallDto.json")
  VerificationStatusResponseInternal loadedVerificationPhoneCallDto;

  @GivenJsonResource("/domains/verification/v1/status/VerificationStatusResponseFlashCallDto.json")
  VerificationStatusResponseInternal loadedVerificationFlashCallDto;

  @GivenJsonResource("/domains/verification/v1/status/VerificationStatusResponseSmsDto.json")
  VerificationStatusResponseInternal loadedVerificationSmsDto;

  @Test
  void deserializePhoneCall() {
    TestHelpers.recursiveEquals(loadedVerificationPhoneCallDto, expectedVerificationPhoneCallDto);
  }

  @Test
  void deserializeFlashCall() {
    TestHelpers.recursiveEquals(loadedVerificationFlashCallDto, expectedVerificationFlashCallDto);
  }

  @Test
  void deserializeSms() {
    TestHelpers.recursiveEquals(loadedVerificationSmsDto, expectedVerificationSmsDto);
  }
}
