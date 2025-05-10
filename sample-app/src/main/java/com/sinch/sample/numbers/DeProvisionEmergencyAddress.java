package com.sinch.sample.numbers;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import java.io.IOException;
import java.util.logging.Logger;

public class DeProvisionEmergencyAddress extends BaseApplication {
  private static final Logger LOGGER =
      Logger.getLogger(DeProvisionEmergencyAddress.class.getName());

  public DeProvisionEmergencyAddress() throws IOException {}

  public static void main(String[] args) {
    try {
      new DeProvisionEmergencyAddress().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    NumbersService service = client.numbers().v1();

    LOGGER.info("De-provisioning EmergencyAddress for: " + virtualPhoneNumber);

    service.deprovisionEmergencyAddress(virtualPhoneNumber);
  }
}
