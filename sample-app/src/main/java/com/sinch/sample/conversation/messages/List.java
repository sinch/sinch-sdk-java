package com.sinch.sample.conversation.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessagesListRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.MessagesListResponse;
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

    MessagesService service = client.conversation().v1().messages();

    LOGGER.info("List message");

    MessagesListRequest request = MessagesListRequest.builder().setPageSize(1).build();
    MessagesListResponse response = service.list(request);

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
