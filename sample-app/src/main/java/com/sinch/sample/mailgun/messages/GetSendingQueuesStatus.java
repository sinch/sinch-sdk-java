package com.sinch.sample.mailgun.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendingQueuesStatusResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class GetSendingQueuesStatus extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(GetSendingQueuesStatus.class.getName());

  public GetSendingQueuesStatus() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetSendingQueuesStatus().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    EmailsService service = client.mailgun().v1().emails();

    LOGGER.info("Get queue status");

    SendingQueuesStatusResponse response = service.getSendingQueuesStatus(mailgunDomain);

    LOGGER.info("Response: " + response);
  }
}
