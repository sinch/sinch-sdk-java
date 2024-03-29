package com.sinch.sample.verification.status;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReport;
import java.io.IOException;
import java.util.logging.Logger;

public class GetById extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(GetById.class.getName());

  public GetById() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetById().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    VerificationId id = VerificationId.valueOf(callId);

    LOGGER.info("Get status by id for  : " + id);

    VerificationReport response = client.verification().verificationStatus().getById(id);
    LOGGER.info("Response :" + response);
  }
}
