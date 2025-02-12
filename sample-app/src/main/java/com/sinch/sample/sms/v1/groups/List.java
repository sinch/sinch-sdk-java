package com.sinch.sample.sms.v1.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import com.sinch.sdk.domains.sms.models.v1.groups.response.ListGroupsResponse;
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

    GroupsService service = client.sms().v1().groups();

    LOGGER.info("List groups");

    ListGroupsResponse response = service.list();

    response.iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
