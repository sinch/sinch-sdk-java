package com.sinch.sample.verification.report;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.api.v1.VerificationReportService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestPhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class ReportByIdentity extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(ReportByIdentity.class.getName());

  public ReportByIdentity() throws IOException {}

  public static void main(String[] args) {
    try {
      new ReportByIdentity().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Get report by identity for  : " + phoneNumber);

    VerificationReportService service = client.verification().v1().verificationReport();

    var identity = NumberIdentity.builder().setEndpoint(phoneNumber).build();

    VerificationMethod method = VerificationMethod.FLASH_CALL;

    VerificationReportResponse response;

    if (method == VerificationMethod.FLASH_CALL) {
      response =
          service.reportFlashCallByIdentity(
              identity,
              VerificationReportRequestFlashCall.builder().setCli("+17074661874").build());
    } else if (method == VerificationMethod.SMS) {
      response =
          service.reportSmsByIdentity(
              identity, VerificationReportRequestSms.builder().setCode("1234").build());
    } else if (method == VerificationMethod.PHONE_CALL) {
      response =
          service.reportPhoneCallByIdentity(
              identity, VerificationReportRequestPhoneCall.builder().setCode("4567").build());
    } else {
      throw new UnsupportedOperationException("Unknown method " + method);
    }

    LOGGER.info("Response: " + response);
  }
}
