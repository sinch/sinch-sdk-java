package com.sinch.sample.conversation.conversations;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.InjectEventResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.AppEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.types.GenericEvent;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class InjectEvent extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(InjectEvent.class.getName());

  public InjectEvent() throws IOException {}

  public static void main(String[] args) {
    try {
      new InjectEvent().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ConversationsService service = client.conversation().v1().conversations();

    Map<String, String> map = new HashMap<>();
    map.put("a property key", "a property value");

    AppEvent event = GenericEvent.builder().setPayload(map).build();

    InjectEventRequest request =
        InjectEventRequest.builder()
            .setAcceptTime(Instant.now())
            .setAppEvent(event)
            .setChannelIdentity(
                ChannelIdentity.builder()
                    .setChannel(ConversationChannel.RCS)
                    .setIdentity(phoneNumber)
                    .build())
            .setConversationId(conversationId)
            .setProcessingMode(ProcessingMode.CONVERSATION)
            .build();

    LOGGER.info("Inject event request: " + request);

    InjectEventResponse response = service.injectEvent(conversationId, request);

    LOGGER.info("Inject event response: " + response);
  }
}
