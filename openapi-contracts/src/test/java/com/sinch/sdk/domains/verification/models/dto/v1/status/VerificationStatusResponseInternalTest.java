package com.sinch.sdk.domains.verification.models.dto.v1.status;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.Price;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal;
import com.sinch.sdk.domains.verification.models.v1.internal.IdentityInternal.TypeEnum;
import com.sinch.sdk.domains.verification.models.v1.status.StatusPrice;
import com.sinch.sdk.domains.verification.models.v1.status.response.FlashCallVerificationStatusResponse;
import com.sinch.sdk.domains.verification.models.v1.status.response.FlashCallVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.PhoneCallVerificationStatusResponse;
import com.sinch.sdk.domains.verification.models.v1.status.response.PhoneCallVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.SmsVerificationStatusResponse;
import com.sinch.sdk.domains.verification.models.v1.status.response.SmsVerificationStatusResponseImpl;
import com.sinch.sdk.domains.verification.models.v1.status.response.SmsVerificationStatusResponsePrice;
import com.sinch.sdk.domains.verification.models.v1.status.response.internal.VerificationStatusResponseInternal;
import com.sinch.sdk.domains.verification.models.v1.status.response.internal.VerificationStatusResponseInternalImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationStatusResponseInternalTest extends BaseTest {

  public static VerificationStatusResponseInternal expectedVerificationCalloutDto =
      new VerificationStatusResponseInternalImpl(
          (PhoneCallVerificationStatusResponseImpl)
              PhoneCallVerificationStatusResponse.builder()
                  .setId("the id")
                  .setMethod(PhoneCallVerificationStatusResponse.MethodEnum.CALLOUT)
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
                  .setIdentity(
                      IdentityInternal.builder()
                          .setType(TypeEnum.NUMBER)
                          .setEndpoint("endpoint value")
                          .build())
                  .setCountryId("es-ES")
                  .setVerificationTimestamp("2024-05-22T09:38:59.5590437")
                  .build());
  public static VerificationStatusResponseInternal expectedVerificationFlashCallDto =
      new VerificationStatusResponseInternalImpl(
          (FlashCallVerificationStatusResponseImpl)
              FlashCallVerificationStatusResponse.builder()
                  .setId("the id")
                  .setMethod(FlashCallVerificationStatusResponse.MethodEnum.FLASHCALL)
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
                  .setSource(FlashCallVerificationStatusResponse.SourceEnum.MANUAL)
                  .setIdentity(
                      IdentityInternal.builder()
                          .setType(TypeEnum.NUMBER)
                          .setEndpoint("endpoint value")
                          .build())
                  .setCountryId("es-ES")
                  .setVerificationTimestamp("2024-05-22T09:38:59.5590437")
                  .build());
  public static VerificationStatusResponseInternal expectedVerificationSMSDto =
      new VerificationStatusResponseInternalImpl(
          (SmsVerificationStatusResponseImpl)
              SmsVerificationStatusResponse.builder()
                  .setId("the id")
                  .setMethod(SmsVerificationStatusResponse.MethodEnum.SMS)
                  .setReference("my reference")
                  .setStatus(VerificationStatus.FAIL)
                  .setReason(VerificationStatusReason.FRAUD)
                  .setSource(SmsVerificationStatusResponse.SourceEnum.INTERCEPTED)
                  .setPrice(
                      SmsVerificationStatusResponsePrice.builder()
                          .setVerificationPrice(
                              Price.builder()
                                  .setCurrencyId("verificationPrice currency id")
                                  .setAmount(3.141516F)
                                  .build())
                          .build())
                  .setIdentity(
                      IdentityInternal.builder()
                          .setType(TypeEnum.NUMBER)
                          .setEndpoint("endpoint value")
                          .build())
                  .setCountryId("es-ES")
                  .setVerificationTimestamp("2024-05-22T09:38:59.5590437")
                  .build());

  @GivenJsonResource("/domains/verification/v1/status/VerificationStatusCalloutResponseDto.json")
  VerificationStatusResponseInternal loadedVerificationCalloutDto;

  @GivenJsonResource("/domains/verification/v1/status/VerificationStatusFlashCallResponseDto.json")
  VerificationStatusResponseInternal loadedVerificationFlashCallDto;

  @GivenJsonResource("/domains/verification/v1/status/VerificationStatusSMSResponseDto.json")
  VerificationStatusResponseInternal loadedVerificationSMSDto;

  @Test
  void deserializeCallout() {
    Assertions.assertThat(loadedVerificationCalloutDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationCalloutDto);
  }

  @Test
  void deserializeFlashCall() {
    Assertions.assertThat(loadedVerificationFlashCallDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationFlashCallDto);
  }

  @Test
  void deserializeSMS() {
    Assertions.assertThat(loadedVerificationSMSDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationSMSDto);
  }
}
