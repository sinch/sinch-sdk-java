package conversation;

import com.sinch.sdk.domains.conversation.api.v1.ConversationService;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.util.Collections;
import java.util.logging.Logger;

public class Snippet {

  private static final Logger LOGGER = Logger.getLogger(Snippet.class.getName());

  static void execute(ConversationService conversationService) {

    MessagesService messagesService = conversationService.messages();

    String appId = "CONVERSATION_APPLICATION_ID";
    String from = "SINCH_VIRTUAL_PHONE_NUMBER";
    String to = "RECIPIENT_PHONE_NUMBER";

    String body = "This is a test Conversation message using the Sinch Java SDK.";

    ChannelRecipientIdentities recipients =
        ChannelRecipientIdentities.of(
            ChannelRecipientIdentity.builder()
                .setChannel(ConversationChannel.SMS)
                .setIdentity(to)
                .build());

    AppMessage<TextMessage> message =
        AppMessage.<TextMessage>builder()
            .setBody(TextMessage.builder().setText(body).build())
            .build();

    SendMessageRequest<TextMessage> request =
        SendMessageRequest.<TextMessage>builder()
            .setAppId(appId)
            .setRecipient(recipients)
            .setMessage(message)
            .setChannelProperties(Collections.singletonMap("SMS_SENDER", from))
            .build();

    LOGGER.info("Sending SMS Text using Conversation API");

    SendMessageResponse value = messagesService.sendMessage(request);

    LOGGER.info("Response: " + value);
  }
}
