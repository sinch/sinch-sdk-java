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
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class UnAssignNumber {

  private static final Logger LOGGER = Logger.getLogger(UnAssignNumber.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The phone number to unassign from the application, in E.164 format (e.g., +12025550123)
    String phoneNumber = Settings.getPhoneNumber().orElse("MY_SINCH_PHONE_NUMBER");

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    ApplicationsService applicationsService = client.voice().v1().applications();

    LOGGER.info(
        String.format("Un-assign number '%s' from application '%s'", phoneNumber, applicationKey));

    UnAssignNumberRequest request =
        UnAssignNumberRequest.builder()
            .setNumber(phoneNumber)
            .setApplicationKey(applicationKey)
            .build();

    applicationsService.unassignNumber(request);

    LOGGER.info("Done");
  }
}
