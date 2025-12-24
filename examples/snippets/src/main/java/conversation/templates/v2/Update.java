/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.templates.v2;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.templates.v2.TemplatesServiceV2;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v2.TemplateV2;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.Collections;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the template to update
    String conversationTemplateId = "TEMPLATE_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    TemplatesServiceV2 templatesServiceV2 = client.conversation().templates().v2();

    TemplateV2 request =
        TemplateV2.builder()
            .setDescription("Updated description from V2 API")
            .setVersion(2)
            .setDefaultTranslation("en-US")
            .setTranslations(
                Collections.singletonList(
                    TemplateTranslation.builder()
                        .setVersion("1")
                        .setLanguageCode("en-US")
                        .setMessage(
                            TextMessage.builder()
                                .setText("my updated text from V2 template")
                                .build())
                        .build()))
            .build();

    LOGGER.info(String.format("Update template with ID '%s'", conversationTemplateId));

    TemplateV2 response = templatesServiceV2.update(conversationTemplateId, request);

    LOGGER.info("Response: " + response);
  }
}
