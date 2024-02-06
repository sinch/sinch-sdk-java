package com.sinch.sample.verification.verifications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationCalloutRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationFlashCallRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSMSRequestParameters;
import com.sinch.sdk.domains.verification.models.requests.StartVerificationSeamlessRequestParameters;
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

    var identity = NumberIdentity.builder().setEndpoint(phoneNumber).build();

    var method = VerificationMethodType.SMS;

    StartVerificationRequestParameters.Builder<?> builder;

    if (method == VerificationMethodType.CALLOUT) {
      builder = StartVerificationCalloutRequestParameters.builder();
    } else if (method == VerificationMethodType.SMS) {
      builder = StartVerificationSMSRequestParameters.builder();
    } else if (method == VerificationMethodType.SEAMLESS) {
      builder = StartVerificationSeamlessRequestParameters.builder();
    } else if (method == VerificationMethodType.FLASH_CALL) {
      builder = StartVerificationFlashCallRequestParameters.builder().setDialTimeOut(17);
    } else {
      throw new IllegalArgumentException("Unexpected method type '%s'".formatted(method));
    }

    // process common properties
    builder.setIdentity(identity);

    var response = client.verification().verifications().start(builder.build());

    LOGGER.info("Response :" + response);
  }
}
