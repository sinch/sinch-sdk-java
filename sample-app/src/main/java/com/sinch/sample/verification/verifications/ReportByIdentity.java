package com.sinch.sample.verification.verifications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
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

    var identity = NumberIdentity.builder().setEndpoint(phoneNumber).build();

    VerificationMethodType method = VerificationMethodType.SMS;

    VerificationReport response;

    if (method == VerificationMethodType.FLASH_CALL) {
      response =
          client
              .verification()
              .verifications()
              .reportFlashCallByIdentity(
                  identity,
                  VerificationReportFlashCallRequestParameters.builder()
                      .setCli("+12098910108")
                      .build());
    } else if (method == VerificationMethodType.SMS) {
      response =
          client
              .verification()
              .verifications()
              .reportSmsByIdentity(
                  identity,
                  VerificationReportSMSRequestParameters.builder().setCode("8448").build());
    } else if (method == VerificationMethodType.CALLOUT) {
      response =
          client
              .verification()
              .verifications()
              .reportCalloutByIdentity(
                  identity,
                  VerificationReportCalloutRequestParameters.builder().setCode("5762").build());
    } else {
      throw new UnsupportedOperationException("Unknown method " + method);
    }

    LOGGER.info("Response :" + response);
  }
}
