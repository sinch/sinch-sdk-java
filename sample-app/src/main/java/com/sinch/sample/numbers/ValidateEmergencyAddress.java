package com.sinch.sample.numbers;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import com.sinch.sdk.domains.numbers.models.v1.request.EmergencyAddressRequest;
import com.sinch.sdk.domains.numbers.models.v1.response.ValidateAddressResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class ValidateEmergencyAddress extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(ValidateEmergencyAddress.class.getName());

  public ValidateEmergencyAddress() throws IOException {}

  public static void main(String[] args) {
    try {
      new ValidateEmergencyAddress().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    NumbersService service = client.numbers().v1();

    LOGGER.info("Validate EmergencyAddress for: " + virtualPhoneNumber);

    EmergencyAddress emergencyAddress =
        EmergencyAddress.builder()
            .setStreetNumber("3500")
            .setStreetInfo("Lenox Road NE")
            .setCity("Atlanta")
            .setState("GA")
            .setPostalCode("30326")
            .build();

    EmergencyAddressRequest request =
        EmergencyAddressRequest.builder()
            .setDisplayName("a display")
            .setAddress(emergencyAddress)
            .build();
    ValidateAddressResponse value = service.validateEmergencyAddress(virtualPhoneNumber, request);

    LOGGER.info("Response: " + value);
  }
}
