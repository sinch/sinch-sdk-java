package com.sinch.sample.verification.verifications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethod;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import java.io.IOException;
import java.util.logging.Logger;

public class Start extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Start.class.getName());

  public Start() throws IOException {}

  public static void main(String[] args) {
    try {
      new Start().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Start verification for : " + phoneNumber);

    client
        .verification()
        .verifications()
        .start(
            StartVerificationFlashCallRequestParameters.builder()
                .setIdentity(NumberIdentity.builder().setEndpoint("+33444555666").build())
                .setMethod(VerificationMethod.SMS)
                .build());

    // LOGGER.info("Response :" + response);
  }
}
