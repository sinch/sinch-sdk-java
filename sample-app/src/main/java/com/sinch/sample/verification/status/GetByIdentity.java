package com.sinch.sample.verification.status;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import java.io.IOException;
import java.util.logging.Logger;

public class GetByIdentity extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(GetByIdentity.class.getName());

  public GetByIdentity() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetByIdentity().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    var identity = NumberIdentity.builder().setEndpoint(phoneNumber).build();

    LOGGER.info("Get status by identity for  : " + identity);

    VerificationMethodType method = VerificationMethodType.SMS;

    VerificationReport response = client.verification().verificationStatus().get(identity, method);
    LOGGER.info("Response :" + response);
  }
}
