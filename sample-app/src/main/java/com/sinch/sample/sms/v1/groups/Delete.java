package com.sinch.sample.sms.v1.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import java.io.IOException;
import java.util.logging.Logger;

public class Delete extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Delete.class.getName());

  public Delete() throws IOException {}

  public static void main(String[] args) {
    try {
      new Delete().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    GroupsService service = client.sms().v1().groups();

    LOGGER.info("Deleting group: " + smsGroupId);

    service.delete(smsGroupId);

    LOGGER.info("Done");
  }
}
