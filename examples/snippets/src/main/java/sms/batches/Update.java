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
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateTextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String smsRegion = Settings.getSMSRegion().orElse("MY_SMS_REGION");

    // ID of the SMS batch to update
    String batchId = "BATCH_ID";
    // Phone numbers to remove from the batch (in E.164 format, e.g., +46701234567)
    List<String> toRemove = Arrays.asList("+11111111111", "+29999999999");
    // Phone numbers to add to the batch (in E.164 format, e.g., +46701234567)
    List<String> toAdd = Arrays.asList("+123456789", "+987654321");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setSmsRegion(SMSRegion.from(smsRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    BatchesService batchesService = client.sms().v1().batches();

    LOGGER.info(String.format("Updating batch with ID '%s'", batchId));

    UpdateTextRequest request =
        UpdateTextRequest.builder().setToRemove(toRemove).setToAdd(toAdd).build();

    BatchResponse response = batchesService.update(batchId, request);

    LOGGER.info("Response: " + response);
  }
}
