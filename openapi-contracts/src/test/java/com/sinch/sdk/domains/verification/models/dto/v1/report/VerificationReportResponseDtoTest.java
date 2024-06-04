package com.sinch.sdk.domains.verification.models.dto.v1.report;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationReportResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportPhoneCallResponseDto.json")
  VerificationReportResponse expectedVerificationReportPhoneCall;

  public static VerificationReportResponse verificationReportPhoneCallDto =
      VerificationReportResponse.builder()
          .setMethod(VerificationMethod.CALLOUT)
          .setId("the id")
          .setStatus(VerificationStatus.FAIL)
          .build();

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportFlashCallResponseDto.json")
  VerificationReportResponse expectedVerificationReportFlashCall;

  public static VerificationReportResponse verificationReportFlashCallDto =
      VerificationReportResponse.builder()
          .setMethod(VerificationMethod.FLASHCALL)
          .setId("the id")
          .setStatus(VerificationStatus.FAIL)
          .build();

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportSmsResponseDto.json")
  VerificationReportResponse expectedVerificationReportSms;

  public static VerificationReportResponse verificationReportSmsDto =
      VerificationReportResponse.builder()
          .setMethod(VerificationMethod.SMS)
          .setId("the id")
          .setStatus(VerificationStatus.FAIL)
          .build();

  @Test
  void deserializePhoneCall() {
    Assertions.assertThat(verificationReportPhoneCallDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportPhoneCall);
  }

  @Test
  void deserializeFlashCall() {
    Assertions.assertThat(verificationReportFlashCallDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportFlashCall);
  }

  @Test
  void serializeSms() {
    Assertions.assertThat(verificationReportSmsDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportSms);
  }
}