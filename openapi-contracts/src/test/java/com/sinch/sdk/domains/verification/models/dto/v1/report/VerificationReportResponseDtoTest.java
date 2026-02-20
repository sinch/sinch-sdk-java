package com.sinch.sdk.domains.verification.models.dto.v1.report;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.api.v1.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatusReason;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponse;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseWhatsApp;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationReportResponseDtoTest extends VerificationBaseTest {

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportResponsePhoneCallDto.json")
  VerificationReportResponse expectedVerificationReportPhoneCall;

  public static VerificationReportResponsePhoneCall verificationReportPhoneCallDto =
      VerificationReportResponsePhoneCall.builder()
          .setId("the id")
          .setStatus(VerificationStatus.FAIL)
          .setReason(VerificationStatusReason.INVALID_CLI)
          .setCallComplete(true)
          .build();

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportResponseFlashCallDto.json")
  VerificationReportResponse expectedVerificationReportFlashCall;

  public static VerificationReportResponseFlashCall verificationReportFlashCallDto =
      VerificationReportResponseFlashCall.builder()
          .setId("the id")
          .setStatus(VerificationStatus.FAIL)
          .setReason(VerificationStatusReason.FRAUD)
          .setCallComplete(true)
          .build();

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportResponseSmsDto.json")
  VerificationReportResponse expectedVerificationReportSms;

  public static VerificationReportResponseSms verificationReportSmsDto =
      VerificationReportResponseSms.builder()
          .setId("the id")
          .setStatus(VerificationStatus.FAIL)
          .setReason(VerificationStatusReason.EXPIRED)
          .build();

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportResponseWhatsAppDto.json")
  VerificationReportResponse expectedVerificationReportWhatsApp;

  public static VerificationReportResponseWhatsApp verificationReportWhatsAppDto =
      VerificationReportResponseWhatsApp.builder()
          .setId("the id")
          .setStatus(VerificationStatus.FAIL)
          .setReason(VerificationStatusReason.EXPIRED)
          .build();

  @Test
  void deserializePhoneCall() {
    TestHelpers.recursiveEquals(
        verificationReportPhoneCallDto, expectedVerificationReportPhoneCall);
  }

  @Test
  void deserializeFlashCall() {
    TestHelpers.recursiveEquals(
        verificationReportFlashCallDto, expectedVerificationReportFlashCall);
  }

  @Test
  void deserializeSms() {
    TestHelpers.recursiveEquals(verificationReportSmsDto, expectedVerificationReportSms);
  }

  @Test
  void deserializeWhatsApp() {
    TestHelpers.recursiveEquals(verificationReportWhatsAppDto, expectedVerificationReportWhatsApp);
  }
}
