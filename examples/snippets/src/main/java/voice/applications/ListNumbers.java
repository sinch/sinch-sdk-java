/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package voice.applications;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersListResponse;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class ListNumbers {

  private static final Logger LOGGER = Logger.getLogger(ListNumbers.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    ApplicationsService applicationsService = client.voice().v1().applications();

    LOGGER.info("Get assigned numbers");

    OwnedNumbersListResponse response = applicationsService.listNumbers();

    LOGGER.info("Response: ");

    response.iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
