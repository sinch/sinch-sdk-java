/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package verification.report;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.verification.api.v1.VerificationsReportService;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequestSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponse;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class ReportByIdentity {

  private static final Logger LOGGER = Logger.getLogger(ReportByIdentity.class.getName());

  public static void main(String[] args) {

    String applicationKey = Settings.getApplicationKey().orElse("MY_APPLICATION_KEY");
    String applicationSecret = Settings.getApplicationSecret().orElse("MY_APPLICATION_SECRET");

    // The phone number being verified via SMS.
    String phoneNumber = "PHONE_NUMBER";
    // The OTP is the code the user received via SMS as part of the verification process.
    String receivedVerificationCode = "OTP_CODE";

    Configuration configuration =
        Configuration.builder()
            .setApplicationKey(applicationKey)
            .setApplicationSecret(applicationSecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    VerificationsReportService verificationsReportService =
        client.verification().v1().verificationReport();

    LOGGER.info(String.format("Report SMS verification code for phone number '%s'", phoneNumber));

    VerificationReportRequestSms request =
        VerificationReportRequestSms.builder().setCode(receivedVerificationCode).build();

    VerificationReportResponse response =
        verificationsReportService.reportSmsByIdentity(
            NumberIdentity.valueOf(phoneNumber), request);

    LOGGER.info("Response: " + response);
  }
}
