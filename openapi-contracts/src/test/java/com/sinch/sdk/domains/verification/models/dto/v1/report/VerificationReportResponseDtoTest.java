package com.sinch.sdk.domains.verification.models.dto.v1.report;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.verification.models.v1.VerificationStatus;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCallImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.report.response.internal.VerificationReportResponseInternal;
import com.sinch.sdk.domains.verification.models.v1.report.response.internal.VerificationReportResponseInternalImpl;
import org.junit.jupiter.api.Test;

@TestWithResources
public class VerificationReportResponseDtoTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportResponsePhoneCallDto.json")
  VerificationReportResponseInternal expectedVerificationReportPhoneCall;

  public static VerificationReportResponseInternalImpl verificationReportPhoneCallDto =
      new VerificationReportResponseInternalImpl(
          (VerificationReportResponsePhoneCallImpl)
              VerificationReportResponsePhoneCall.builder()
                  .setId("the id")
                  .setStatus(VerificationStatus.FAIL)
                  .build());

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportResponseFlashCallDto.json")
  VerificationReportResponseInternal expectedVerificationReportFlashCall;

  public static VerificationReportResponseInternalImpl verificationReportFlashCallDto =
      new VerificationReportResponseInternalImpl(
          (VerificationReportResponseFlashCallImpl)
              VerificationReportResponseFlashCall.builder()
                  .setId("the id")
                  .setStatus(VerificationStatus.FAIL)
                  .build());

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportResponseSmsDto.json")
  VerificationReportResponseInternal expectedVerificationReportSms;

  public static VerificationReportResponseInternalImpl verificationReportSmsDto =
      new VerificationReportResponseInternalImpl(
          (VerificationReportResponseSmsImpl)
              VerificationReportResponseSms.builder()
                  .setId("the id")
                  .setStatus(VerificationStatus.FAIL)
                  .build());

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
  void serializeSms() {
    TestHelpers.recursiveEquals(verificationReportSmsDto, expectedVerificationReportSms);
  }
}
