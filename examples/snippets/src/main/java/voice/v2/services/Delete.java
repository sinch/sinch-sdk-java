/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package voice.v2.services;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v2.ServicesService;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Delete {

  private static final Logger LOGGER = Logger.getLogger(Delete.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // The ID of the service to delete
    String serviceId = "SERVICE_ID";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    ServicesService servicesService = client.voice().v2().services();

    LOGGER.info(String.format("Deleting voice service with ID '%s'", serviceId));

    servicesService.delete(serviceId);

    LOGGER.info("Done");
  }
}
