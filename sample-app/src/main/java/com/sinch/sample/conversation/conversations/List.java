package com.sinch.sample.conversation.conversations;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.ConversationsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationsListResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class List extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public List() throws IOException {}

  public static void main(String[] args) {
    try {
      new List().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ConversationsService service = client.conversation().v1().conversations();

    LOGGER.info("List conversations for appID:" + conversationAppId);

    ConversationsListRequest request =
        ConversationsListRequest.builder()
            .setPageSize(1)
            .setOnlyActive(false)
            .setAppId(conversationAppId)
            .build();
    ConversationsListResponse response = service.list(request);

    LOGGER.info("Response (by stream)");

    AtomicInteger index = new AtomicInteger();
    response.stream()
        .peek(
            a ->
                LOGGER.info(
                    String.format(
                        "Conversation %d (id '%s'): %s", index.incrementAndGet(), a.getId(), a)))
        .forEach(
            a -> {
              /* just here to consume the stream*/
            });
  }
}
