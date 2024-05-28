package com.sinch.sdk.domains.verification.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationReportResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/VerificationReportCalloutResponseDto.json")
  VerificationReportResponseDto expectedVerificationReportCallout;

  public static VerificationReportResponseDto verificationReportCalloutDto =
      new VerificationReportResponseDto()
          .method(VerificationMethodDto.CALLOUT)
          .id("the id")
          .status(VerificationStatusDto.FAIL);

  @GivenJsonResource("/domains/verification/v1/VerificationReportFlashCallResponseDto.json")
  VerificationReportResponseDto expectedVerificationReportFlashCall;

  public static VerificationReportResponseDto verificationReportFlashCallDto =
      new VerificationReportResponseDto()
          .method(VerificationMethodDto.FLASHCALL)
          .id("the id")
          .status(VerificationStatusDto.FAIL);

  @GivenJsonResource("/domains/verification/v1/VerificationReportSMSResponseDto.json")
  VerificationReportResponseDto expectedVerificationReportSMS;

  public static VerificationReportResponseDto verificationReportSMSDto =
      new VerificationReportResponseDto()
          .method(VerificationMethodDto.SMS)
          .id("the id")
          .status(VerificationStatusDto.FAIL);

  @Test
  void deserializeCallout() {
    Assertions.assertThat(verificationReportCalloutDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportCallout);
  }

  @Test
  void deserializeFlashCall() {
    Assertions.assertThat(verificationReportFlashCallDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportFlashCall);
  }

  @Test
  void serializeSMS() {
    Assertions.assertThat(verificationReportSMSDto)
        .usingRecursiveComparison()
        .isEqualTo(expectedVerificationReportSMS);
  }
}
