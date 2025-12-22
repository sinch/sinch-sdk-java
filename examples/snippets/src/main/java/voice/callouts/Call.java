/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package voice.callouts;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.voice.api.v1.CalloutsService;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTS;
import com.sinch.sdk.domains.voice.models.v1.destination.DestinationPstn;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Call {

  private static final Logger LOGGER = Logger.getLogger(Call.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The phone number you want to call, in E.164 format (e.g., +12025550123)
    String recipientPhoneNumber = "RECIPIENT_PHONE_NUMBER";
    String textToSpeech = "Hello, this is a call initiated from Sinch Java SDK. Goodbye.";

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    CalloutsService calloutsService = client.voice().v1().callouts();

    LOGGER.info(String.format("Calling phone number '%s'", recipientPhoneNumber));

    CalloutRequestTTS request =
        CalloutRequestTTS.builder()
            .setDestination(DestinationPstn.from(recipientPhoneNumber))
            .setText(textToSpeech)
            .build();

    String response = calloutsService.call(request);

    LOGGER.info("Response: " + response);
  }
}
