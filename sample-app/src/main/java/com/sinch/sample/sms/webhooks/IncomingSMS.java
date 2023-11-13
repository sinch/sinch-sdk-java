package com.sinch.sample.sms.webhooks;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.Inbound;
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
    LOGGER.info("Convert MOText payload" + payload);

    Inbound<?> value = client.sms().webHooks().incomingSMS(payload);

    LOGGER.info("Conversion result: " + value);

    payload =
        "{\n"
            + "  \"body\": \"a body\",\n"
            + "  \"client_reference\": \"a client reference\",\n"
            + "  \"from\": \"+11203494390\",\n"
            + "  \"id\": \"01FC66621XXXXX119Z8PMV1QPA\",\n"
            + "  \"operator_id\": \"35000\",\n"
            + "  \"received_at\": \"2019-08-24T14:17:22Z\",\n"
            + "  \"sent_at\": \"2019-08-24T14:15:22Z\",\n"
            + "  \"to\": \"11203453453\",\n"
            + "  \"type\": \"mo_binary\",\n"
            + "  \"udh\": \"foo udh\"\n"
            + "}";
    LOGGER.info("Convert MOBinary payload" + payload);

    value = client.sms().webHooks().incomingSMS(payload);

    LOGGER.info("Conversion result: " + value);
  }
}
