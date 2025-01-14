package com.sinch.sample.sms.v1.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import com.sinch.sdk.domains.sms.models.v1.groups.Group;
import com.sinch.sdk.domains.sms.models.v1.groups.request.GroupRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
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

    GroupsService service = client.sms().v1().groups();

    GroupRequest parameters =
        GroupRequest.builder()
            .setName("foo")
            .setMembers(new HashSet<>(Arrays.asList("+3312345678", "+3312345679")))
            .build();

    LOGGER.info("Replace group: " + smsGroupId + " with: " + parameters);

    Group response = service.replace(smsGroupId, parameters);

    LOGGER.info("Response :" + response);
  }
}
