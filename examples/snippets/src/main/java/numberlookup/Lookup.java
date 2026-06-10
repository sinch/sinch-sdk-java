/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package numberlookup;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.numberlookup.api.v2.NumberLookupV2Service;
import com.sinch.sdk.domains.numberlookup.models.v2.request.LookupFeatureType;
import com.sinch.sdk.domains.numberlookup.models.v2.request.NumberLookupRequest;
import com.sinch.sdk.domains.numberlookup.models.v2.response.NumberLookupResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collections;
import java.util.logging.Logger;
import utils.Settings;

public class Lookup {

  private static final Logger LOGGER = Logger.getLogger(Lookup.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // The phone number you want to lookup in E.164 format
    String phoneNumber = Settings.getPhoneNumber().orElse("PHONE_NUMBER");

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    NumberLookupV2Service numberLookupService = client.lookup().lookup();

    NumberLookupRequest request =
        NumberLookupRequest.builder()
            .setNumber(phoneNumber)
            .setFeatures(Collections.singletonList(LookupFeatureType.LINE_TYPE))
            .build();

    LOGGER.info("Lookup for: " + phoneNumber);

    NumberLookupResponse response = numberLookupService.lookup(request);

    LOGGER.info("Response: " + response);
  }
}
