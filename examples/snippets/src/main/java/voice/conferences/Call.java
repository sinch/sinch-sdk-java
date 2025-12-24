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
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Call {

  private static final Logger LOGGER = Logger.getLogger(Call.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");
    String phoneNumber = Settings.getPhoneNumber().orElse("MY_SINCH_PHONE_NUMBER");

    // An existing or to be created conference ID
    String conferenceId = "CONFERENCE_ID";
    // The phone number to be called and added to the conference, in E.164 format (e.g.,
    // +12025550123)
    String recipientPhoneNumber = "RECIPIENT_PHONE_NUMBER";

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    ConferencesService conferencesService = client.voice().v1().conferences();

    LOGGER.info(
        String.format(
            "Joining conference '%s' for phone number '%s'", conferenceId, recipientPhoneNumber));

    CalloutRequestConference request =
        CalloutRequestConference.builder()
            .setDestination(DestinationPstn.from(recipientPhoneNumber))
            .setCli(phoneNumber)
            .setConferenceId(conferenceId)
            .build();

    String response = conferencesService.call(request);

    LOGGER.info("Response: " + response);
  }
}
