/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package numbers.callback;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.response.CallbackConfigurationResponse;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Update {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    String hmac = "NEW_HMAC_SECRET";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    CallbackConfigurationService callbackConfigurationService = client.numbers().v1().callback();

    LOGGER.info("Update callback HMAC secret");

    CallbackConfigurationUpdateRequest parameters =
        CallbackConfigurationUpdateRequest.builder().setHmacSecret(hmac).build();

    CallbackConfigurationResponse value = callbackConfigurationService.update(parameters);

    LOGGER.info("Response :" + value);
  }
}
