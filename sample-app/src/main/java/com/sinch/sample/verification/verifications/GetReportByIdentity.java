package com.sinch.sample.verification.verifications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.VerificationReportSMSRequestParameters;
import java.io.IOException;
import java.util.logging.Logger;

public class GetReportByIdentity extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(GetReportByIdentity.class.getName());

  public GetReportByIdentity() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetReportByIdentity().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Get report by identity for  : " + phoneNumber);

    Identity identity = NumberIdentity.builder().setEndpoint(phoneNumber).build();

    VerificationMethodType method = VerificationMethodType.SMS;

    VerificationReportRequestParameters.Builder<?> builder;

    if (method == VerificationMethodType.FLASH_CALL) {
      builder = VerificationReportFlashCallRequestParameters.builder().setCli("+12098910108");
    } else if (method == VerificationMethodType.SMS) {
      builder = VerificationReportSMSRequestParameters.builder().setCode("0271");
    } else if (method == VerificationMethodType.CALLOUT) {
      builder = VerificationReportCalloutRequestParameters.builder().setCode("5762");
    } else {
      builder = VerificationReportRequestParameters.builder();
    }

    VerificationReport response =
        client.verification().verifications().report(identity, builder.build());
    LOGGER.info("Response :" + response);
  }
}
