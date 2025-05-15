package com.sinch.sample.numbers;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import com.sinch.sdk.domains.numbers.models.v1.request.EmergencyAddressRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class ProvisionEmergencyAddress extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(ProvisionEmergencyAddress.class.getName());

  public ProvisionEmergencyAddress() throws IOException {}

  public static void main(String[] args) {
    try {
      new ProvisionEmergencyAddress().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    NumbersService service = client.numbers().v1();

    LOGGER.info("Provisioning EmergencyAddress for: " + virtualPhoneNumber);

    EmergencyAddress emergencyAddress =
        EmergencyAddress.builder()
            .setStreetNumber("3500")
            .setStreetInfo("Lenox Rd NE")
            .setCity("Atlanta")
            .setState("GA")
            .setPostalCode("30326")
            .build();

    EmergencyAddressRequest request =
        EmergencyAddressRequest.builder()
            .setDisplayName("a display")
            .setAddress(emergencyAddress)
            .build();
    EmergencyAddress value = service.provisionEmergencyAddress(virtualPhoneNumber, request);

    LOGGER.info("Response: " + value);
  }
}
