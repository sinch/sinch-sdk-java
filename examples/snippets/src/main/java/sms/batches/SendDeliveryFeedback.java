/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package sms.batches;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import utils.Settings;

public class SendDeliveryFeedback {

  private static final Logger LOGGER = Logger.getLogger(SendDeliveryFeedback.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String smsRegion = Settings.getSMSRegion().orElse("MY_SMS_REGION");

    // The batch ID from which the message was sent
    String batchId = "BATCH_ID";
    // The recipient phone number, in E.164 format (e.g., +46701234567)
    List<String> recipients = Arrays.asList("RECIPIENT_PHONE_NUMBER");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setSmsRegion(SMSRegion.from(smsRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    BatchesService batchesService = client.sms().v1().batches();

    LOGGER.info(String.format("Sending delivery feedback for batch with ID '%s'", batchId));

    SendDeliveryFeedbackRequest request =
        SendDeliveryFeedbackRequest.builder().setRecipients(recipients).build();

    batchesService.sendDeliveryFeedback(batchId, request);

    LOGGER.info("Done");
  }
}
