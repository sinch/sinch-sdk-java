package com.sinch.sample.verification.status;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.verification.api.v1.VerificationStatusService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;
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

    VerificationStatusService service = client.verification().v1().verificationStatus();

    NumberIdentity identity = NumberIdentity.valueOf(phoneNumber);

    LOGGER.info("Get status by identity for  : " + identity);

    VerificationMethod method = VerificationMethod.FLASH_CALL;

    VerificationStatusResponse response = service.getByIdentity(identity, method);

    LOGGER.info("Response: " + response);
  }
}
