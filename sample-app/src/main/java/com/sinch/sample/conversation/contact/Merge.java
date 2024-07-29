package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ContactService;
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

    ContactService service = client.conversation().v1().contact();

    LOGGER.info("Merge contact '%s' onto '%s'".formatted(sourceContactId, destinationContactId));

    var result = service.mergeContact(destinationContactId, sourceContactId);

    LOGGER.info("Response: " + result);
  }
}
