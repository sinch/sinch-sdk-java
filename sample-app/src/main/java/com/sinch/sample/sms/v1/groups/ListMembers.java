package com.sinch.sample.sms.v1.groups;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.GroupsService;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;

public class ListMembers extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(ListMembers.class.getName());

  public ListMembers() throws IOException {}

  public static void main(String[] args) {
    try {
      new ListMembers().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    GroupsService service = client.sms().v1().groups();

    LOGGER.info("List members for groupId: " + smsGroupId);

    Collection<String> response = service.listMembers(smsGroupId);

    response.iterator().forEachRemaining(LOGGER::info);
  }
}
