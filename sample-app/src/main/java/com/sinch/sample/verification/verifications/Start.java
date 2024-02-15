package com.sinch.sample.verification.verifications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
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

    var identity = NumberIdentity.valueOf(phoneNumber);

    var method = VerificationMethodType.SMS;

    StartVerificationResponse response;
    if (method == VerificationMethodType.CALLOUT) {
      response =
          client
              .verification()
              .verifications()
              .startCallout(
                  StartVerificationCalloutRequestParameters.builder()
                      .setIdentity(identity)
                      .build());
    } else if (method == VerificationMethodType.SMS) {
      response =
          client
              .verification()
              .verifications()
              .startSms(
                  StartVerificationSMSRequestParameters.builder().setIdentity(identity).build());
    } else if (method == VerificationMethodType.SEAMLESS) {
      response =
          client
              .verification()
              .verifications()
              .startSeamless(
                  StartVerificationSeamlessRequestParameters.builder()
                      .setIdentity(identity)
                      .build());
    } else if (method == VerificationMethodType.FLASH_CALL) {
      response =
          client
              .verification()
              .verifications()
              .startFlashCall(
                  StartVerificationFlashCallRequestParameters.builder()
                      .setDialTimeOut(17)
                      .setIdentity(identity)
                      .build());
    } else {
      throw new IllegalArgumentException("Unexpected method type '%s'".formatted(method));
    }

    LOGGER.info("Response :" + response);
  }
}
