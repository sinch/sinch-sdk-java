/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package sms.inbounds;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.sms.api.v1.InboundsService;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.SMSRegion;
import java.util.logging.Logger;
import utils.Settings;

public class List {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");
    String smsRegion = Settings.getSMSRegion().orElse("MY_SMS_REGION");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .setSmsRegion(SMSRegion.from(smsRegion))
            .build();

    SinchClient client = new SinchClient(configuration);

    InboundsService inboundsService = client.sms().v1().inbounds();

    LOGGER.info("List inbounds messages");

    LOGGER.info("Response:");
    inboundsService.list().iterator().forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
