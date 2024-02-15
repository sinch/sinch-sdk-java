package com.sinch.sample.verification.verifications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
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

    VerificationReport response;

    if (method == VerificationMethodType.FLASH_CALL) {
      response =
          client
              .verification()
              .verifications()
              .reportFlashCallById(
                  id,
                  VerificationReportFlashCallRequestParameters.builder()
                      .setCli("+19799770634")
                      .build());
    } else if (method == VerificationMethodType.SMS) {
      response =
          client
              .verification()
              .verifications()
              .reportSmsById(
                  id, VerificationReportSMSRequestParameters.builder().setCode("4511").build());
    } else if (method == VerificationMethodType.CALLOUT) {
      response =
          client
              .verification()
              .verifications()
              .reportCalloutById(
                  id, VerificationReportCalloutRequestParameters.builder().setCode("5762").build());
    } else {
      throw new UnsupportedOperationException("Unknown method " + method);
    }

    LOGGER.info("Response :" + response);
  }
}
