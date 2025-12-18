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
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import utils.Settings;

public class Send {

  private static final Logger LOGGER = Logger.getLogger(Send.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String smsRegion = Settings.getSMSRegion().orElse("MY_SMS_REGION");

    // Sender could be a:
    // - phone number:  e.g. Sinch virtual number in E164 format
    // - alphanumeric sender ID: e.g. a brand name "BRAND"
    // - US short code: e.g. "12345"
    String sender = Settings.getPhoneNumber().orElse("SENDER_NUMBER");
    // The recipient phone number, in E.164 format (e.g., +46701234567)
    List<String> recipients = Arrays.asList("RECIPIENT_PHONE_NUMBER");
    // The body of the SMS message
    String body = "This is a test SMS message using the Sinch Java SDK.";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setSmsRegion(SMSRegion.from(smsRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    BatchesService batchesService = client.sms().v1().batches();

    LOGGER.info(String.format("Sending SMS Text to recipients '%s'", recipients));

    TextRequest request =
        TextRequest.builder().setTo(recipients).setBody(body).setFrom(sender).build();

    BatchResponse response = batchesService.send(request);

    LOGGER.info("Response: " + response);
  }
}
