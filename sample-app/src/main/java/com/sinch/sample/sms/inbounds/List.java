package com.sinch.sample.sms.inbounds;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
import java.util.logging.Logger;

public class List extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public List() throws IOException {}

  public static void main(String[] args) {
    try {
      new List().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("List inbounds");

    LOGGER.info("Response:");
    client.sms().inbounds().list(null).iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
