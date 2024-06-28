package com.sinch.sample.verification.status;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.api.v1.VerificationStatusService;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;
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

    VerificationStatusService service = client.verification().v1().verificationStatus();
    String reference = "my reference";

    LOGGER.info("Get status by reference for: '" + reference + "'");

    VerificationStatusResponse response = service.getByReference(reference);
    LOGGER.info("Response: " + response);
  }
}
