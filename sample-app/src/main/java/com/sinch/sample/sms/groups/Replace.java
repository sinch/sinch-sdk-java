package com.sinch.sample.sms.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.Group;
import com.sinch.sdk.domains.sms.models.requests.GroupReplaceRequestParameters;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Replace extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Replace.class.getName());

  public Replace() throws IOException {}

  public static void main(String[] args) {
    try {
      new Replace().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    String groupId = "01HF70ZG5VDZA9EP56HCHVB1R0";
    GroupReplaceRequestParameters parameters =
        GroupReplaceRequestParameters.builder()
            .setName("foo")
            .setMembers(Arrays.asList("+3312345678", "+3312345678"))
            .build();

    LOGGER.info("Replace group: " + groupId + " with: " + parameters);

    Group response = client.sms().groups().replace(groupId, parameters);

    LOGGER.info("Response :" + response);
  }
}
