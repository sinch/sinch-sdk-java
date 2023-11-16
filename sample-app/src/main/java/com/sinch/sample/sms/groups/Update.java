package com.sinch.sample.sms.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.requests.GroupUpdateRequestParameters;
import java.io.IOException;
import java.util.logging.Logger;

public class Update extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    String groupId = "01HF70ZG5VDZA9EP56HCHVB1R0";
    GroupUpdateRequestParameters parameters =
        GroupUpdateRequestParameters.builder().setName("new name").build();

    LOGGER.info("Update group: " + groupId + " with: " + parameters);

    Group response = client.sms().groups().update(groupId, parameters);

    LOGGER.info("Response: " + response);
  }
}
