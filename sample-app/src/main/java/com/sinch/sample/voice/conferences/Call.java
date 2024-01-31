package com.sinch.sample.voice.conferences;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.models.E164PhoneNumber;
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

    LOGGER.info(
        "Joining conference '%s' for phone number '%s'".formatted(conferenceId, phoneNumber));

    var parameters =
        CalloutRequestParametersConference.builder()
            .setDestination(DestinationNumber.valueOf(phoneNumber))
            .setCli(E164PhoneNumber.valueOf("+123456789"))
            .setConferenceId(conferenceId)
            .setCustom("my custom value")
            .build();
    var response = client.voice().callouts().call(parameters);

    LOGGER.info("Response: '%s'".formatted(response));
  }
}
