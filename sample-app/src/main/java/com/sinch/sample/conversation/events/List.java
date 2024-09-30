package com.sinch.sample.conversation.events;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.EventsService;
import com.sinch.sdk.domains.conversation.models.v1.events.request.EventsListRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.response.EventsListResponse;
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

    EventsService service = client.conversation().v1().events();
    LOGGER.info("List events");

    EventsListRequest request =
        EventsListRequest.builder().setConversationId(conversationId).build();
    EventsListResponse response = service.list(request);

    LOGGER.info("Response (by stream)");

    AtomicInteger index = new AtomicInteger();
    response.stream()
        .peek(
            a ->
                LOGGER.info(
                    String.format(
                        "Message %d (id '%s'): %s", index.incrementAndGet(), a.getId(), a)))
        .forEach(
            a -> {
              /* just here to consume the stream*/
            });
  }
}
