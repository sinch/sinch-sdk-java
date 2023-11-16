package com.sinch.sample.sms.groups;

import com.sinch.sample.BaseApplication;
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

    String groupId = "01HF70ZG5VDZA9EP56HCHVB1R0";

    LOGGER.info("Deleting group: " + groupId);

    client.sms().groups().delete(groupId);

    LOGGER.info("Done");
  }
}
