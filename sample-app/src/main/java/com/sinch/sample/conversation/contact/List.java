package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactListRequest;
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

    LOGGER.info("List");

    var result =
        client.conversation().contact().list(ContactListRequest.builder().setPageSize(1).build());

    LOGGER.info("Response: ");
    result
        .iterator()
        .forEachRemaining(
            f -> LOGGER.info(String.format("- %s (%s) : %s", f.getDisplayName(), f.getId(), f)));
  }
}
