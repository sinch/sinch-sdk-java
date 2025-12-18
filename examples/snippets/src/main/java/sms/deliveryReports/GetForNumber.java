/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package sms.deliveryReports;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.util.logging.Logger;
import utils.Settings;

public class GetForNumber {

  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String smsRegion = Settings.getSMSRegion().orElse("MY_SMS_REGION");

    // The ID of the SMS batch to retrieve the delivery report for
    String batchId = "BATCH_ID";
    // The phone number to retrieve the delivery report for
    String phoneNumber = "RECIPIENT_PHONE_NUMBER";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setSmsRegion(SMSRegion.from(smsRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    DeliveryReportsService deliveryReportsService = client.sms().v1().deliveryReports();

    LOGGER.info(String.format("Get delivery report for number '%s'", phoneNumber));

    RecipientDeliveryReport response = deliveryReportsService.getForNumber(batchId, phoneNumber);

    LOGGER.info("Response :" + response);
  }
}
