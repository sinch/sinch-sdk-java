/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package conversation.contact;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.ContactService;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactGetChannelProfileByContactIdRequest;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.GetChannelProfileConversationChannel;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class GetChannelProfile {

  private static final Logger LOGGER = Logger.getLogger(GetChannelProfile.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the Conversation application the contact belongs to
    String conversationApplicationId = "APPLICATION_ID";
    // The ID of the contact to retrieve the channel profile for
    String conversationContactId = "CONTACT_ID";
    // The channel associated with the contact
    GetChannelProfileConversationChannel conversationChannel =
        GetChannelProfileConversationChannel.MESSENGER;

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    ContactService contactService = client.conversation().v1().contact();

    ContactGetChannelProfileByContactIdRequest parametersByContactId =
        ContactGetChannelProfileByContactIdRequest.builder()
            .setAppId(conversationApplicationId)
            .setChannel(conversationChannel)
            .setContactId(conversationContactId)
            .build();

    LOGGER.info(
        String.format(
            "Get MESSENGER channel profile for contact with ID '%s'", conversationContactId));

    String result = contactService.getChannelProfileByContactId(parametersByContactId);

    LOGGER.info("Response: " + result);
  }
}
