package com.sinch.sample.voice.conferences;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
import com.sinch.sdk.domains.voice.models.v1.Destination;
import com.sinch.sdk.domains.voice.models.v1.DestinationType;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
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

    ConferencesService service = client.voice().v1().conferences();

    LOGGER.info(
        "Joining conference '%s' for phone number '%s'".formatted(conferenceId, phoneNumber));

    CalloutRequestConference parameters =
        CalloutRequestConference.builder()
            .setDestination(
                Destination.builder()
                    .setType(DestinationType.NUMBER)
                    .setEndpoint(phoneNumber)
                    .build())
            .setCli(virtualPhoneNumber)
            .setConferenceId(conferenceId)
            .setCustom("my custom value")
            .build();

    var response = service.call(parameters);

    LOGGER.info("Response: '%s'".formatted(response));
  }
}
