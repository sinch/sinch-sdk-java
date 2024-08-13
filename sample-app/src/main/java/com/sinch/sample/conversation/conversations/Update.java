package com.sinch.sample.conversation.conversations;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import com.sinch.sdk.domains.conversation.models.v1.request.MetadataUpdateStrategy;
import java.io.IOException;
import java.util.Collections;
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

    ConversationsService service = client.conversation().v1().conversations();

    LOGGER.info("Before: " + service.get(conversationId));

    Conversation request =
        Conversation.builder()
            .setCorrelationId("correlation ID value")
            .setMetadataJson(Collections.emptyMap())
            .setActive(true)
            .build();
    LOGGER.info("Update request: " + request);

    Conversation result = service.update(conversationId, MetadataUpdateStrategy.REPLACE, request);

    LOGGER.info("Response: " + result);
  }
}
