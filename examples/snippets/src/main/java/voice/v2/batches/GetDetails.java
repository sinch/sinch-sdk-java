/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package voice.v2.batches;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v2.BatchesService;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchDetails;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class GetDetails {

  private static final Logger LOGGER = Logger.getLogger(GetDetails.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // The ID of the batch to get details for
    String batchId = "BATCH_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    BatchesService batchesService = client.voice().v2().batches();

    LOGGER.info(String.format("Get details for batch with ID '%s'", batchId));

    BatchDetails response = batchesService.getDetails(batchId);

    LOGGER.info("Response: " + response);
  }
}
