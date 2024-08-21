package com.sinch.sample.conversation.conversations;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRecentRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationsListRecentResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class ListRecent extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(ListRecent.class.getName());

  public ListRecent() throws IOException {}

  public static void main(String[] args) {
    try {
      new ListRecent().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ConversationsService service = client.conversation().v1().conversations();

    LOGGER.info("List recent conversations for appID:" + conversationAppId);

    ConversationsListRecentRequest request =
        ConversationsListRecentRequest.builder()
            .setOnlyActive(false)
            .setAppId(conversationAppId)
            .setPageSize(1)
            .build();
    ConversationsListRecentResponse response = service.listRecent(request);

    LOGGER.info("Response (by stream)");

    AtomicInteger index = new AtomicInteger();
    response.stream()
        .peek(a -> LOGGER.info(String.format("Conversation %d : %s", index.incrementAndGet(), a)))
        .forEach(
            a -> {
              /* just here to consume the stream*/
            });
  }
}
