package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
import com.sinch.sdk.domains.voice.models.v1.applications.Capability;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequest;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class AssignNumbers extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(AssignNumbers.class.getName());

  public AssignNumbers() throws IOException {}

  public static void main(String[] args) {
    try {
      new AssignNumbers().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ApplicationsService service = client.voice().v1().applications();

    LOGGER.info("Update numbers '%s'".formatted(virtualPhoneNumber));

    service.assignNumbers(
        UpdateNumbersRequest.builder()
            .setNumbers(List.of(virtualPhoneNumber))
            .setApplicationKey(applicationKey)
            .setCapability(Capability.VOICE)
            .build());
  }
}
