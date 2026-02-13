/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package verification.status;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.verification.api.v1.VerificationsStatusService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class GetByIdentity {

  private static final Logger LOGGER = Logger.getLogger(GetByIdentity.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The phone number you are verifying, in E.164 format (e.g. +46701234567).
    // This should be the same number you used when starting the verification.
    String phoneNumber = "PHONE_NUMBER";
    // The verification method you used when starting the verification.
    VerificationMethod verificationMethod = VerificationMethod.SMS;

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    VerificationsStatusService verificationsStatusService =
        client.verification().v1().verificationStatus();

    LOGGER.info(String.format("Verification status for phone number '%s'", phoneNumber));

    NumberIdentity identity = NumberIdentity.valueOf(phoneNumber);

    VerificationStatusResponse response =
        verificationsStatusService.getByIdentity(identity, verificationMethod);

    LOGGER.info("Response: " + response);
  }
}
