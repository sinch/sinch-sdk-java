/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package numbers.eventdestinations;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.numbers.api.v1.EventDestinationsService;
import com.sinch.sdk.domains.numbers.models.v1.eventdestinations.response.EventDestinationResponse;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Get {

  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    EventDestinationsService eventDestinationsService = client.numbers().v1().eventDestinations();

    LOGGER.info("Get");

    EventDestinationResponse value = eventDestinationsService.get();

    LOGGER.info("Response :" + value);
  }
}
