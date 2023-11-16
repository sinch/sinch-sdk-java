package com.sinch.sample.sms.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.Group;
import java.io.IOException;
import java.util.logging.Logger;

public class Get extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public Get() throws IOException {}

  public static void main(String[] args) {
    try {
      new Get().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    String groupId = "01HF714PHPH9SQ2BNWSCY2068R";
    LOGGER.info("Get for: " + groupId);

    Group response = client.sms().groups().get(groupId);

    LOGGER.info("Response: " + response);
  }
}
