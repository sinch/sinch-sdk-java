/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.application;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.AppService;
import com.sinch.sdk.domains.conversation.models.v1.app.request.AppCreateRequest;
import com.sinch.sdk.domains.conversation.models.v1.app.response.AppResponse;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentials;
import com.sinch.sdk.domains.conversation.models.v1.credentials.ConversationChannelCredentialsBuilderFactory;
import com.sinch.sdk.domains.conversation.models.v1.credentials.StaticBearerCredentials;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import utils.Settings;

public class Create {

  private static final Logger LOGGER = Logger.getLogger(Create.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The service plan ID and API token for the SMS channel
    String smsServicePlanId = Settings.getServicePlanId().orElse("SMS_SERVICE_PLAN_ID");
    String smsApiToken = ("SMS_API_TOKEN");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    AppService appService = client.conversation().v1().app();

    LOGGER.info(
        String.format(
            "Create conversation application with SMS channel for service plan ID '%s'",
            smsServicePlanId));

    ConversationChannelCredentials smsChannel =
        ConversationChannelCredentialsBuilderFactory.sms(
                StaticBearerCredentials.builder()
                    .setClaimedIdentity(smsServicePlanId)
                    .setToken(smsApiToken)
                    .build())
            .build();

    List<ConversationChannelCredentials> channelCredentials = Arrays.asList(smsChannel);

    AppCreateRequest request =
        AppCreateRequest.builder()
            .setChannelCredentials(channelCredentials)
            .setDisplayName("Created from Java SDK snippet")
            .build();

    AppResponse response = appService.create(request);

    LOGGER.info("Response: " + response);
  }
}
