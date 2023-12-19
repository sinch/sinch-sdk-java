package com.sinch.sample.voice.callouts;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.DestinationNumber;
import java.io.IOException;
import java.util.logging.Logger;

public class Call extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Call.class.getName());

  public Call() throws IOException {}

  public static void main(String[] args) {
    try {
      new Call().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Start call for: " + phoneNumber);

    var parameters =
        CalloutRequestParametersConference.builder()
            .setDestination(DestinationNumber.valueOf(phoneNumber))
            .setConferenceId("My conference Id")
            .build();
    var response = client.voice().callouts().call(parameters);

    LOGGER.info("Response: " + response);
  }
}
