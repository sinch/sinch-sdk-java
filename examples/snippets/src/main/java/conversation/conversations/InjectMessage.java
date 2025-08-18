/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.conversations;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.InjectMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.time.Instant;
import java.util.logging.Logger;
import utils.Settings;

public class InjectMessage {

  private static final Logger LOGGER = Logger.getLogger(InjectMessage.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the conversation to inject the message into
    String conversationId = "CONVERSATION_ID";
    // The ID of the contact to inject the message into
    String conversationContactId = "CONTACT_ID";
    // The channel to use for the recipient
    ConversationChannel recipientChannel = ConversationChannel.SMS;
    // The phone number of the recipient in E.164 format
    String recipientPhoneNumber = "RECIPIENT_PHONE_NUMBER";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    ConversationsService conversationsService = client.conversation().v1().conversations();

    AppMessage appMessage =
        AppMessage.<TextMessage>builder()
            .setBody(TextMessage.builder().setText("Text from Inject AppMessage").build())
            .build();

    InjectMessageRequest request =
        InjectMessageRequest.builder()
            .setContactId(conversationContactId)
            .setBody(appMessage)
            .setChannelIdentity(
                ChannelIdentity.builder()
                    .setChannel(recipientChannel)
                    .setIdentity(recipientPhoneNumber)
                    .build())
            .setDirection(ConversationDirection.TO_CONTACT)
            .setAcceptTime(Instant.now())
            .build();

    LOGGER.info(String.format("Inject message to conversation with ID '%s'", conversationId));

    conversationsService.injectMessage(conversationId, request);

    LOGGER.info("Done");
  }
}
