package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
import java.util.logging.Logger;

public class Merge extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Merge.class.getName());

  public Merge() throws IOException {}

  public static void main(String[] args) {
    try {
      new Merge().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    String sourceContactId = "source contact ID";
    String destinationContactId = "destination contact ID";

    LOGGER.info("Merge contact '%s' onto '%s'".formatted(sourceContactId, destinationContactId));

    var result =
        client.conversation().contact().mergeContact(destinationContactId, sourceContactId);

    LOGGER.info("Response: " + result);
  }
}
