/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package numbers;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.numberorder.request.LookupNumberRequirementsRequest;
import com.sinch.sdk.domains.numbers.models.v1.numberorder.response.NumberRequirements;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Orders {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

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

    NumbersService numbersService = client.numbers().v1();

    LOGGER.info("POC Orders");

    NumberRequirements response =
        numbersService
            .orders()
            .lookupNumberRequirements(
                LookupNumberRequirementsRequest.builder().setRegionCode("US").build());

    LOGGER.info("Response: " + response);
  }
}
