/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.contact;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.ContactService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.contact.Contact;
import com.sinch.sdk.domains.conversation.models.v1.contact.ContactLanguage;
import com.sinch.sdk.domains.conversation.models.v1.contact.request.ContactCreateRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.Arrays;
import java.util.logging.Logger;
import utils.Settings;

public class Create {

  private static final Logger LOGGER = Logger.getLogger(Create.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The channel to use for the contact
    ConversationChannel recipientChannel = ConversationChannel.SMS;
    // The phone number of the contact to create
    String recipientPhoneNumber = "RECIPIENT_PHONE_NUMBER";
    // The display name of the contact to create
    String contactDisplayName = "Created from Java SDK snippet";
    // The language of the contact to create
    ContactLanguage contactLanguage = ContactLanguage.FR;

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    ContactService contactService = client.conversation().v1().contact();

    LOGGER.info("Create contact");

    ContactCreateRequest contact =
        ContactCreateRequest.builder()
            .setChannelIdentities(
                Arrays.asList(
                    ChannelIdentity.builder()
                        .setChannel(recipientChannel)
                        .setIdentity(recipientPhoneNumber)
                        .build()))
            .setDisplayName(contactDisplayName)
            .setLanguage(contactLanguage)
            .build();

    Contact result = contactService.create(contact);

    LOGGER.info("Response: " + result);
  }
}
