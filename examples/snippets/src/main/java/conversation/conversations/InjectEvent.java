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
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.conversations.request.InjectEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.conversations.response.InjectEventResponse;
import com.sinch.sdk.domains.conversation.models.v1.events.AppEvent;
import com.sinch.sdk.domains.conversation.models.v1.events.types.GenericEvent;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import utils.Settings;

public class InjectEvent {

  private static final Logger LOGGER = Logger.getLogger(InjectEvent.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the conversation to inject the event into
    String conversationId = "CONVERSATION_ID";
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

    ConversationsService conversationsService = client.conversation().v1().conversations();

    Map<String, String> map = new HashMap<>();
    map.put("a property key", "a property value");

    AppEvent event = GenericEvent.builder().setPayload(map).build();

    InjectEventRequest request =
        InjectEventRequest.builder()
            .setAcceptTime(Instant.now())
            .setAppEvent(event)
            .setChannelIdentity(
                ChannelIdentity.builder()
                    .setChannel(recipientChannel)
                    .setIdentity(recipientPhoneNumber)
                    .build())
            .setConversationId(conversationId)
            .setProcessingMode(ProcessingMode.CONVERSATION)
            .build();

    LOGGER.info("Inject event request: " + request);

    InjectEventResponse response = conversationsService.injectEvent(conversationId, request);

    LOGGER.info("Inject event response: " + response);
  }
}
