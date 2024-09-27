package com.sinch.sample.conversation.conversations;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.CreateConversationRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class Create extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Create.class.getName());

  public Create() throws IOException {}

  public static void main(String[] args) {
    try {
      new Create().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ConversationsService service = client.conversation().v1().conversations();

    CreateConversationRequest request =
        CreateConversationRequest.builder()
            .setAppId(conversationAppId)
            .setContactId(conversationContactId)
            .build();
    LOGGER.info("Create conversation: " + request);

    Conversation result = service.create(request);

    LOGGER.info("Response: " + result);
  }
}
