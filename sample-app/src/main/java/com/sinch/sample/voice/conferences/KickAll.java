package com.sinch.sample.voice.conferences;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
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

    ConferencesService service = client.voice().v1().conferences();

    LOGGER.info("Kill all participant from conference '%s'".formatted(conferenceId));

    service.kickAll(conferenceId);
  }
}
