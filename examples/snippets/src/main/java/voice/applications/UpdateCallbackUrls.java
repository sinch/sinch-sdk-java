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
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.CallbacksUrl;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class UpdateCallbackUrls {

  private static final Logger LOGGER = Logger.getLogger(UpdateCallbackUrls.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The new callback URL to set for the application
    String callbackURL = "https://my.callback.url/voice";

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    ApplicationsService applicationsService = client.voice().v1().applications();

    Callbacks request =
        Callbacks.builder().setUrl(CallbacksUrl.builder().setPrimary(callbackURL).build()).build();

    LOGGER.info(
        String.format(
            "Update callback URLs for application key '%s': '%s'", applicationKey, request));

    applicationsService.updateCallbackUrls(applicationKey, request);

    LOGGER.info("Done");
  }
}
