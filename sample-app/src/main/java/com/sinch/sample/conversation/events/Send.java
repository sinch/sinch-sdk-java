package com.sinch.sample.conversation.events;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.EventsService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.events.AppEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.request.SendEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.response.SendEventResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEndEvent;
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

    EventsService service = client.conversation().v1().events();

    AppEvent event = ComposingEndEvent.EMPTY;

    SendEventRequest request =
        SendEventRequest.builder()
            .setAppId(conversationAppId)
            .setEvent(event)
            .setRecipient(
                ChannelRecipientIdentities.of(
                    ChannelRecipientIdentity.builder()
                        .setChannel(ConversationChannel.RCS)
                        .setIdentity(phoneNumber)
                        .build()))
            .build();

    LOGGER.info("Send event request: " + request);

    SendEventResponse response = service.send(request);

    LOGGER.info("Send event response: " + response);
  }
}
