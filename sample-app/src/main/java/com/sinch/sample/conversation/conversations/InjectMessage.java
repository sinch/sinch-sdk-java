package com.sinch.sample.conversation.conversations;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessageBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.io.IOException;
import java.time.Instant;
import java.util.logging.Logger;

public class InjectMessage extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(InjectMessage.class.getName());

  public InjectMessage() throws IOException {}

  public static void main(String[] args) {
    try {
      new InjectMessage().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ConversationsService service = client.conversation().v1().conversations();

    AppMessage appMessage =
        AppMessage.<TextMessage>builder()
            .setBody(TextMessage.builder().setText("Text from Inject AppMessage").build())
            .build();

    ContactMessage contactMessage =
        ContactMessage.<TextMessage>builder()
            .setBody(TextMessage.builder().setText("Text from Inject ContactMessage").build())
            .build();

    ConversationMessageBody message = appMessage;

    InjectMessageRequest request =
        InjectMessageRequest.builder()
            .setContactId(conversationContactId)
            .setBody(message)
            .setChannelIdentity(
                ChannelIdentity.builder()
                    .setChannel(ConversationChannel.RCS)
                    .setIdentity(phoneNumber)
                    .build())
            .setDirection(
                message == contactMessage
                    ? ConversationDirection.TO_APP
                    : ConversationDirection.TO_CONTACT)
            .setAcceptTime(Instant.now())
            .build();

    LOGGER.info("Update request: " + request);

    service.injectMessage(conversationId, request);
  }
}
