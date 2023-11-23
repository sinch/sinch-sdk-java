package com.sinch.sample.verification.verifications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethod;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponse;
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

    Identity identity = NumberIdentity.builder().setEndpoint(phoneNumber).build();

    VerificationMethod method = VerificationMethod.SMS;

    StartVerificationRequestParameters parameters;
    if (method != VerificationMethod.FLASH_CALL) {
      parameters = StartVerificationRequestParameters.builder(method).setIdentity(identity).build();
    } else {
      //  Dedicated flashcall builder usage do not require setting explicit verification method
      // parameter
      parameters =
          StartVerificationFlashCallRequestParameters.builder()
              .setIdentity(identity)
              .setDialTimeOut(17)
              .build();
    }
    StartVerificationResponse response = client.verification().verifications().start(parameters);
    LOGGER.info("Response :" + response);
  }
}
