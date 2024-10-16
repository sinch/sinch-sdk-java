package com.sinch.sample.voice.conferences;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
import java.io.IOException;
import java.util.logging.Logger;

public class KickParticipant extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(KickParticipant.class.getName());

  public KickParticipant() throws IOException {}

  public static void main(String[] args) {
    try {
      new KickParticipant().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ConferencesService service = client.voice().v1().conferences();

    LOGGER.info("Kick participant '%s' for conference '%s".formatted(callId, conferenceId));

    service.kickParticipant(conferenceId, callId);
  }
}
