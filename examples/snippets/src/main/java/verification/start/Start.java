/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package verification.start;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.verification.api.v1.VerificationsStartService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponse;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Start {

  private static final Logger LOGGER = Logger.getLogger(Start.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The phone number you want to verify, in E.164 format (e.g. +46701234567).
    String phoneNumber = "PHONE_NUMBER";

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    VerificationsStartService verificationsStartService =
        client.verification().v1().verificationStart();

    LOGGER.info(String.format("Start a verification by SMS onto phone number '%s'", phoneNumber));

    VerificationStartRequestSms request =
        VerificationStartRequestSms.builder()
            .setIdentity(NumberIdentity.valueOf(phoneNumber))
            .build();

    VerificationStartResponse response = verificationsStartService.startSms(request);

    LOGGER.info("Response: " + response);
  }
}
