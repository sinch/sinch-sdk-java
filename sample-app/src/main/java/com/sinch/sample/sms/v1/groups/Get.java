package com.sinch.sample.sms.v1.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import com.sinch.sdk.domains.sms.models.v1.groups.Group;
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

    GroupsService service = client.sms().v1().groups();

    LOGGER.info("Get for: " + smsGroupId);

    Group response = service.get(smsGroupId);

    LOGGER.info("Response: " + response);
  }
}
