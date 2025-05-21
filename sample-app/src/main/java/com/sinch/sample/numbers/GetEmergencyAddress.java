package com.sinch.sample.numbers;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.EmergencyAddress;
import java.io.IOException;
import java.util.logging.Logger;

public class GetEmergencyAddress extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(GetEmergencyAddress.class.getName());

  public GetEmergencyAddress() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetEmergencyAddress().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    NumbersService service = client.numbers().v1();

    LOGGER.info("Get EmergencyAddress for: " + virtualPhoneNumber);

    EmergencyAddress response = service.getEmergencyAddress(virtualPhoneNumber);

    LOGGER.info("Response: " + response);
  }
}
