package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class UnassignNumber extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(UnassignNumber.class.getName());

  public UnassignNumber() throws IOException {}

  public static void main(String[] args) {
    try {
      new UnassignNumber().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ApplicationsService service = client.voice().v1().applications();

    LOGGER.info(
        "Un-assign number '%s' from application '%s'"
            .formatted(virtualPhoneNumber, applicationKey));

    UnAssignNumberRequest request =
        UnAssignNumberRequest.builder()
            .setNumber(virtualPhoneNumber)
            .setApplicationKey(applicationKey)
            .build();
    service.unAssignNumber(request);
  }
}
