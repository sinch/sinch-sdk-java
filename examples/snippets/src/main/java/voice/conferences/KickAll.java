/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package voice.conferences;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class KickAll {

  private static final Logger LOGGER = Logger.getLogger(KickAll.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The ID of the conference to remove all participants from
    String conferenceId = "CONFERENCE_ID";

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    ConferencesService conferencesService = client.voice().v1().conferences();

    LOGGER.info(String.format("Kick all participants from conference with ID '%s'", conferenceId));

    conferencesService.kickAll(conferenceId);

    LOGGER.info("Done");
  }
}
