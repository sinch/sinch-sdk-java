package com.sinch.sample.verification.status;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.api.v1.VerificationStatusService;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;
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

    LOGGER.info("Get status by id for  : " + verificationId);

    VerificationStatusService service = client.verification().v1().verificationStatus();

    VerificationStatusResponse response = service.getById(verificationId);

    LOGGER.info("Response: " + response);
  }
}
