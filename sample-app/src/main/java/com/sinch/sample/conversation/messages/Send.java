package com.sinch.sample.conversation.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.models.v1.Recipient;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class Send extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Send.class.getName());

  public Send() throws IOException {}

  public static void main(String[] args) {
    try {
      new Send().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Send message with Conversation");

    var parameters =
        SendMessageRequest.builder()
            .setAppId(conversationAppId)
            .setMessage(
                AppMessage.builder()
                    .setTextMessage(TextMessage.builder().setText("My text from jpp").build())
                    .build())
            .setRecipient(Recipient.builder().setContactId(conversationContactId).build())
            .setTtl(25)
            .build();

    var result = client.conversation().messages().send(parameters);

    LOGGER.info("Response: " + result);
  }
}
