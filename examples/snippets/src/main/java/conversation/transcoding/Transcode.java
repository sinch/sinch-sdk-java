/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package conversation.transcoding;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.TranscodingService;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.Coordinates;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.request.TranscodeMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.transcoding.response.TranscodeMessageResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.Arrays;
import java.util.logging.Logger;
import utils.Settings;

public class Transcode {

  private static final Logger LOGGER = Logger.getLogger(Transcode.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // ID of the Conversation application to use for transcoding
    String conversationApplicationId = "APPLICATION_ID";
    // The channel to transcode the message for
    ConversationChannel conversationChannel = ConversationChannel.WHATSAPP;

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    TranscodingService transcodingService = client.conversation().v1().transcoding();

    AppMessage<?> appMessage =
        AppMessage.<LocationMessage>builder()
            .setBody(
                LocationMessage.builder()
                    .setCoordinates(
                        Coordinates.builder()
                            .setLatitude(47.627980)
                            .setLongitude(-2.822915)
                            .build())
                    .setTitle("Coordinates title")
                    .build())
            .build();

    TranscodeMessageRequest request =
        TranscodeMessageRequest.builder()
            .setAppId(conversationApplicationId)
            .setAppMessage(appMessage)
            .setChannels(Arrays.asList(conversationChannel))
            .build();

    LOGGER.info("Transcode message request: " + request);

    TranscodeMessageResponse response = transcodingService.transcodeMessage(request);

    LOGGER.info("Transcode message response: " + response);
  }
}
