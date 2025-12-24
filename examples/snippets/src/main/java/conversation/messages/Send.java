/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package conversation.messages;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.SendMessageRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.response.SendMessageResponse;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.ConversationRegion;
import java.util.logging.Logger;
import utils.Settings;

public class Send {

  private static final Logger LOGGER = Logger.getLogger(Send.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String conversationRegion = Settings.getConversationRegion().orElse("MY_CONVERSATION_REGION");

    // The ID of the Conversation Application to send the message from
    String conversationApplicationId = "CONVERSATION_APPLICATION_ID";
    // Phone number to send the SMS message to (in E.164 format, e.g. +46701234567)
    String smsRecipientPhoneNumber = "RECIPIENT_PHONE_NUMBER";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setConversationRegion(ConversationRegion.from(conversationRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    MessagesService messagesService = client.conversation().v1().messages();

    LOGGER.info(
        String.format(
            "Send SMS message with Conversation to phone number '%s'", smsRecipientPhoneNumber));

    SendMessageRequest<TextMessage> request =
        createSMSSendMessage(conversationApplicationId, smsRecipientPhoneNumber);

    SendMessageResponse response = messagesService.sendTextMessage(request);

    LOGGER.info("Response: " + response);
  }

  static SendMessageRequest<TextMessage> createSMSSendMessage(
      String applicationId, String smsRecipientPhoneNumber) {

    SendMessageRequest.Builder<TextMessage> builder = SendMessageRequest.<TextMessage>builder();

    builder
        .setAppId(applicationId)
        .setMessage(
            AppMessage.<TextMessage>builder()
                .setBody(
                    TextMessage.builder()
                        .setText("[Java SDK: Conversation Message] Sample text message")
                        .build())
                .build())
        .setRecipient(
            ChannelRecipientIdentities.of(
                ChannelRecipientIdentity.builder()
                    .setChannel(ConversationChannel.SMS)
                    .setIdentity(smsRecipientPhoneNumber)
                    .build()))
        .build();

    return builder.build();
  }
}
