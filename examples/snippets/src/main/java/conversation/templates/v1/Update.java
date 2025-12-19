/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package conversation.templates.v1;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.templates.v1.TemplatesServiceV1;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateTranslation;
import com.sinch.sdk.domains.conversation.templates.models.v1.TemplateV1;
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

    TemplatesServiceV1 templatesServiceV1 = client.conversation().templates().v1();

    TemplateV1 request =
        TemplateV1.builder()
            .setDescription("Updated description from V1 API")
            .setDefaultTranslation("en-US")
            .setTranslations(
                Arrays.asList(
                    TemplateTranslation.builder()
                        .setLanguageCode("en-US")
                        .setContent(
                            "{ \"text_message\": { \"text\" : \"text updated from V1 template\"}}")
                        .build()))
            .build();

    LOGGER.info(String.format("Update template with ID '%s'", conversationTemplateId));

    TemplateV1 result = templatesServiceV1.update(conversationTemplateId, request);

    LOGGER.info("Response: " + result);
  }
}
