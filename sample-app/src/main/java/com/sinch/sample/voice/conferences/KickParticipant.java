package com.sinch.sample.voice.conferences;

import com.sinch.sample.BaseApplication;
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

    String callId = "e429ecbb-6057-4756-8148-2b498f968136";
    LOGGER.info("Kick participant '%s' for conference '%s".formatted(callId, conferenceId));

    client.voice().conferences().kickParticipant(conferenceId, callId);
  }
}
