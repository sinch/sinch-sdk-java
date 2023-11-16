package com.sinch.sample.sms.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.Group;
import java.io.IOException;
import java.util.logging.Logger;

public class Create extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Create.class.getName());

  public Create() throws IOException {}

  public static void main(String[] args) {
    try {
      new Create().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Creating group");

    Group response = client.sms().groups().create();

    LOGGER.info("Response: " + response);
  }
}
