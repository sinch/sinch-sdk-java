/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java-snippets
 *
 * <p>See https://github.com/sinch/sinch-sdk-java-snippets/blob/main/README.md for details
 */
package numbers;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class SearchForAvailableNumbers {

  private static final Logger LOGGER = Logger.getLogger(SearchForAvailableNumbers.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    // ISO 3166-1 alpha-2 country code of the phone number. e.g. "US", "GB", "SE"...
    // See https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2 for details
    String regionCode = "MY_REGION_CODE";
    NumberType type = NumberType.LOCAL;

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    NumbersService numbersService = client.numbers().v1();

    AvailableNumbersListQueryParameters parameters =
        AvailableNumbersListQueryParameters.builder()
            .setRegionCode(regionCode)
            .setType(type)
            .build();

    LOGGER.info("Looking for available numbers");

    AvailableNumberListResponse response = numbersService.searchForAvailableNumbers(parameters);

    response
        .iterator()
        .forEachRemaining(
            number -> LOGGER.info(String.format("Available number details: %s", number)));
  }
}
