package com.sinch.sample.sms.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.responses.GroupsListResponse;
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

    LOGGER.info("List groups");

    GroupsListResponse response = client.sms().groups().list();

    response.iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
