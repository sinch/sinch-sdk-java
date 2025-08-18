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
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the contact to update
    String conversationContactId = "CONTACT_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    ContactsService contactService = client.conversation().v1().contacts();

    LOGGER.info(String.format("Update contact with ID '%s'", conversationContactId));

    Contact contact = Contact.builder().setDisplayName("updated from Java SDK snippet").build();

    Contact result = contactService.update(conversationContactId, contact);

    LOGGER.info("Response: " + result);
  }
}
