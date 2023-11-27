package com.sinch.sample.verification.status;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import java.io.IOException;
import java.util.logging.Logger;

public class GetByReference extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(GetByReference.class.getName());

  public GetByReference() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetByReference().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    VerificationReference reference = VerificationReference.valueOf("a test reference");

    LOGGER.info("Get status by reference for: '" + reference + "'");

    VerificationReport response = client.verification().status().get(reference);
    LOGGER.info("Response :" + response);
  }
}
