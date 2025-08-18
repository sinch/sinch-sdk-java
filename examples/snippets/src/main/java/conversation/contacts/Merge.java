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
import com.sinch.sdk.domains.conversation.models.v1.contacts.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contacts.request.MergeContactRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class Merge {

  private static final Logger LOGGER = Logger.getLogger(Merge.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    //  The ID of the contact to merge from (the source contact)
    String sourceContactId = "SOURCE_CONTACT_ID";
    // The ID of the contact to merge into (the destination contact)
    String destinationContactId = "DESTINATION_CONTACT_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    ContactsService contactService = client.conversation().v1().contacts();

    LOGGER.info(
        String.format(
            "Merge contact with ID '%s' onto contact with ID '%s'",
            sourceContactId, destinationContactId));

    MergeContactRequest request =
        MergeContactRequest.builder().setSourceId(sourceContactId).build();
    Contact result = contactService.mergeContact(destinationContactId, request);

    LOGGER.info("Response: " + result);
  }
}
