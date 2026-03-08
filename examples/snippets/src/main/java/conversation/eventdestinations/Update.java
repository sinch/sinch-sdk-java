/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.eventdestinations;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.EventDestinationsService;
import com.sinch.sdk.domains.conversation.models.v1.eventdestinations.EventDestination;
import com.sinch.sdk.domains.conversation.models.v1.eventdestinations.EventDestinationTargetType;
import com.sinch.sdk.domains.conversation.models.v1.eventdestinations.EventDestinationTrigger;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.Arrays;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the conversation event destination to update
    String eventDestinationId = "EVENT_DESTINATION_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    EventDestinationsService eventDestinationsService =
        client.conversation().v1().eventDestinations();

    EventDestination eventDestination =
        EventDestination.builder()
            .setTarget("https://foo.com")
            .setTriggers(
                Arrays.asList(
                    EventDestinationTrigger.CAPABILITY, EventDestinationTrigger.CHANNEL_EVENT))
            .setTargetType(EventDestinationTargetType.HTTP)
            .build();

    LOGGER.info(String.format("Update event destination with ID '%s'", eventDestinationId));

    EventDestination response =
        eventDestinationsService.update(eventDestinationId, eventDestination);

    LOGGER.info("Response: " + response);
  }
}
