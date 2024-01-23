package com.sinch.sample.voice.callouts;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.models.CalloutMethodType;
import com.sinch.sdk.domains.voice.models.DestinationNumber;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParameters;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustom;
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

    LOGGER.info("Start call for: " + phoneNumber);

    CalloutRequestParameters parameters = null;

    CalloutMethodType type = CalloutMethodType.CUSTOM_CALLOUT;

    // custom
    if (type == CalloutMethodType.CUSTOM_CALLOUT) {
      parameters =
          CalloutRequestParametersCustom.builder()
              // .setIce("https://8dbd-78-117-86-140.ngrok-free.app/VoiceEvent")
              // .setAce(true)
              .setDestination(DestinationNumber.valueOf(phoneNumber))
              .setCli(E164PhoneNumber.valueOf(virtualPhoneNumber))
              .build();
      ;
    }

    if (type == CalloutMethodType.CONFERENCE_CALLOUT) {
      parameters =
          CalloutRequestParametersConference.builder()
              .setDestination(DestinationNumber.valueOf(phoneNumber))
              .setConferenceId(conferenceId)
              .setCustom("my custom value")
              .setEnableAce(true)
              .setEnableDice(true)
              .setEnablePie(true)
              .build();
    }
    var response = client.voice().callouts().call(parameters);

    LOGGER.info("Response: " + response);
  }
}
