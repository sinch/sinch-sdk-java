package com.sinch.sample.voice.conferences;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
import java.util.logging.Logger;

public class KickAll extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(KickAll.class.getName());

  public KickAll() throws IOException {}

  public static void main(String[] args) {
    try {
      new KickAll().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Kill all participant from conference '%s'".formatted(conferenceId));

    client.voice().conferences().kickAll(conferenceId);
  }
}
