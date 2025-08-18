/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.contacts;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.ContactsService;
import com.sinch.sdk.domains.conversation.models.v1.contacts.request.ContactGetChannelProfileByContactIdRequest;
import com.sinch.sdk.domains.conversation.models.v1.contacts.request.GetChannelProfileConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contacts.response.GetChannelProfileResponse;
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

    ContactsService contactService = client.conversation().v1().contacts();

    ContactGetChannelProfileByContactIdRequest parametersByContactId =
        ContactGetChannelProfileByContactIdRequest.builder()
            .setAppId(conversationApplicationId)
            .setChannel(conversationChannel)
            .setContactId(conversationContactId)
            .build();

    LOGGER.info(
        String.format(
            "Get MESSENGER channel profile for contact with ID '%s'", conversationContactId));

    GetChannelProfileResponse result =
        contactService.getChannelProfileByContactId(parametersByContactId);

    LOGGER.info("Response: " + result);
  }
}
