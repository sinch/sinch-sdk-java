package com.mycompany.app.conversation;

import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessageBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.message.MessageInboundEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.message.MessageInboundEventMessage;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component("ConversationServerBusinessLogic")
public class ServerBusinessLogic {

  private static final Logger LOGGER = Logger.getLogger(ServerBusinessLogic.class.getName());

  private final MessagesService messagesService;

  public ServerBusinessLogic(MessagesService messagesService) {
    this.messagesService = messagesService;
  }

  public void handleMessageInboundEvent(MessageInboundEvent event) {

    LOGGER.info("Handle event: " + event);

    MessageInboundEventMessage message = event.getMessage();

    ChannelIdentity channelIdentity = message.getChannelIdentity();
    if (null == channelIdentity) {
      LOGGER.warning("Message Inbound Event with no channel identity");
      return;
    }

    String identity = channelIdentity.getIdentity();
    String receivedText = getMoText(message);
    LOGGER.info("MO SMS from '%s': '%s'".formatted(identity, receivedText));

    AppMessage<TextMessage> replyTextMessage =
        AppMessage.<TextMessage>builder()
            .setBody(
                TextMessage.builder()
                    .setText("Your message said: '%s'".formatted(receivedText))
                    .build())
            .build();

    SendMessageRequest<TextMessage> request =
        SendMessageRequest.<TextMessage>builder()
            .setAppId(event.getAppId())
            .setMessage(replyTextMessage)
            .setRecipient(
                ChannelRecipientIdentities.of(
                    ChannelRecipientIdentity.builder()
                        .setChannel(ConversationChannel.SMS)
                        .setIdentity(identity)
                        .build()))
            .build();

    SendMessageResponse response = messagesService.sendTextMessage(request);

    LOGGER.info("Response: " + response);
  }

  private String getMoText(MessageInboundEventMessage message) {

    if (null != message.getContactMessage()) {
      ContactMessageBody messageBody = message.getContactMessage().getBody();

      if (messageBody instanceof TextMessage textMessage) {
        return textMessage.getText();
      }
    }
    return "(no text content)";
  }
}
