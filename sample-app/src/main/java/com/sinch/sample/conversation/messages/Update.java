package com.sinch.sample.conversation.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessageUpdateRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class Update extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    MessagesService service = client.conversation().v1().messages();

    LOGGER.info("Updating message: " + conversationMessageId);

    MessageUpdateRequest request =
        MessageUpdateRequest.builder().setMetadata("metadata value set from Java SDK").build();
    ConversationMessage response = service.update(conversationMessageId, request);

    LOGGER.info("Response: " + response);
  }
}
