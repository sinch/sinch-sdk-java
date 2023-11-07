package com.sinch.sample.sms.webhooks;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
import java.util.logging.Logger;

public class IncomingSMS extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(IncomingSMS.class.getName());

  public IncomingSMS() throws IOException {}

  public static void main(String[] args) {
    try {
      new IncomingSMS().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    String payload =
        "{\n"
            + "  \"body\": \"This is a test message.\",\n"
            + "  \"from\": \"16051234567\",\n"
            + "  \"id\": \"01XXXXX21XXXXX119Z8P1XXXXX\",\n"
            + "  \"operator_id\": \"string\",\n"
            + "  \"received_at\": \"2022-08-24T14:15:22Z\",\n"
            + "  \"to\": \"13185551234\",\n"
            + "  \"type\": \"mo_text\"\n"
            + "}";
    LOGGER.info("Convert payload" + payload);

    Object value = client.sms().webHooks().incomingSMS(payload);

    LOGGER.info("Convertion result: " + value);
  }
}
