package com.sinch.sample.mailgun.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import java.io.IOException;
import java.util.logging.Logger;

public class PurgeSendingQueue extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(PurgeSendingQueue.class.getName());

  public PurgeSendingQueue() throws IOException {}

  public static void main(String[] args) {
    try {
      new PurgeSendingQueue().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    EmailsService service = client.mailgun().v1().emails();

    LOGGER.info("Purge domain: " + mailgunDomain);

    service.purgeSendingQueue(mailgunDomain, "https://storage-us-east4.api.mailgun.net");
  }
}
