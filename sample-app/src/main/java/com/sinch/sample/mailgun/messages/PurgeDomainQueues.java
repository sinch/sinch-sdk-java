package com.sinch.sample.mailgun.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import java.io.IOException;
import java.util.logging.Logger;

public class PurgeDomainQueues extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(PurgeDomainQueues.class.getName());

  public PurgeDomainQueues() throws IOException {}

  public static void main(String[] args) {
    try {
      new PurgeDomainQueues().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    EmailsService service = client.mailgun().v1().emails();

    LOGGER.info("Purge domain: " + mailgunDomain);

    service.purgeDomainQueues(mailgunDomain);
  }
}
