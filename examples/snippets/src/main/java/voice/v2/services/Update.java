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
import com.sinch.sdk.domains.voice.models.v2.services.request.UpdateServiceRequest;
import com.sinch.sdk.domains.voice.models.v2.services.response.ServiceResponse;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // The ID of the service to update
    String serviceId = "SERVICE_ID";
    String name = "Updated service name";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    ServicesService servicesService = client.voice().v2().services();

    UpdateServiceRequest request = UpdateServiceRequest.builder().setName(name).build();

    LOGGER.info(String.format("Update voice service with ID '%s'", serviceId));

    ServiceResponse response = servicesService.update(serviceId, request);

    LOGGER.info("Response: " + response);
  }
}
