/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package conversation.events;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.EventsService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.events.AppEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.request.SendEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.response.SendEventResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEndEvent;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class Send {

  private static final Logger LOGGER = Logger.getLogger(Send.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the Conversation Application to send the event from
    String conversationApplicationId = "APPLICATION_ID";
    // The channel to use for the recipient
    ConversationChannel recipientChannel = ConversationChannel.SMS;
    // The identity of the recipient (e.g. phone number for SMS)
    String recipientPhoneNumber = "RECIPIENT_PHONE_NUMBER";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    EventsService eventsService = client.conversation().v1().events();

    AppEvent event = ComposingEndEvent.EMPTY;

    SendEventRequest request =
        SendEventRequest.builder()
            .setAppId(conversationApplicationId)
            .setEvent(event)
            .setRecipient(
                ChannelRecipientIdentities.of(
                    ChannelRecipientIdentity.builder()
                        .setChannel(recipientChannel)
                        .setIdentity(recipientPhoneNumber)
                        .build()))
            .build();

    LOGGER.info(String.format("Send event to application with ID '%s'", conversationApplicationId));

    SendEventResponse response = eventsService.send(request);

    LOGGER.info("Response: " + response);
  }
}
