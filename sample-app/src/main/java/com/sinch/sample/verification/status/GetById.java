package com.sinch.sample.verification.status;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationStatus;
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

    VerificationId id = VerificationId.valueOf(verificationId);

    LOGGER.info("Get status by id for  : " + id);

    VerificationStatus response = client.verification().verificationStatus().getById(id);
    LOGGER.info("Response :" + response);
  }
}
