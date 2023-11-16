package com.sinch.sample.sms.groups;

import com.sinch.sample.BaseApplication;
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

    String groupId = "01HF714PHPH9SQ2BNWSCY2068R";

    LOGGER.info("List members for groupId: " + groupId);

    Collection<String> response = client.sms().groups().listMembers(groupId);

    response.iterator().forEachRemaining(LOGGER::info);
  }
}
