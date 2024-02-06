package com.sinch.sample.verification.verifications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import java.io.IOException;
import java.util.logging.Logger;

public class ReportById extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(ReportById.class.getName());

  public ReportById() throws IOException {}

  public static void main(String[] args) {
    try {
      new ReportById().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    VerificationId id = VerificationId.valueOf(verificationId);

    LOGGER.info("Get report by id for  : " + id);

    VerificationMethodType method = VerificationMethodType.CALLOUT;

    VerificationReportRequestParameters.Builder<?> builder;

    if (method == VerificationMethodType.FLASH_CALL) {
      builder = VerificationReportFlashCallRequestParameters.builder().setCli("+19799770634");
    } else if (method == VerificationMethodType.SMS) {
      builder = VerificationReportSMSRequestParameters.builder().setCode("4511");
    } else if (method == VerificationMethodType.CALLOUT) {
      builder = VerificationReportCalloutRequestParameters.builder().setCode("5762");
    } else {
      throw new UnsupportedOperationException("Unknown method " + method);
    }

    VerificationReport response = client.verification().verifications().report(id, builder.build());
    LOGGER.info("Response :" + response);
  }
}
