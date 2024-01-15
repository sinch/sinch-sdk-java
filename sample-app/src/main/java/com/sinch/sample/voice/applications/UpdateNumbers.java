package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.CapabilityType;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsUpdateNumbersRequestParameters;
import com.sinch.sdk.models.E164PhoneNumber;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class UpdateNumbers extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(UpdateNumbers.class.getName());

  public UpdateNumbers() throws IOException {}

  public static void main(String[] args) {
    try {
      new UpdateNumbers().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Update numbers '%s'".formatted(phoneNumber));

    client
        .voice()
        .applications()
        .updateNumbers(
            ApplicationsUpdateNumbersRequestParameters.builder()
                .setNumbers(List.of(E164PhoneNumber.valueOf(phoneNumber)))
                .setApplicationKey(applicationKey)
                .setCapability(CapabilityType.VOICE)
                .build());
  }
}
