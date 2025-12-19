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
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class Rent {

  private static final Logger LOGGER = Logger.getLogger(Rent.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    String servicePlanIdToAssociateWithTheNumber =
        Settings.getServicePlanId().orElse("MY_SERVICE_PLAN_ID");

    // Available numbers list can be retrieved by using list() function from available service, see
    // the SearchAvailableSnippet or
    // https://developers.sinch.com/docs/numbers/getting-started/java-sdk/searchavailable
    String phoneNumberToBeRented = "AVAILABLE_PHONE_NUMBER_TO_BE_RENTED";

    Configuration configuration =
        Configuration.builder()
            .setProjectId(projectId)
            .setKeyId(keyId)
            .setKeySecret(keySecret)
            .build();

    SinchClient client = new SinchClient(configuration);

    NumbersService numbersService = client.numbers().v1();

    SmsConfiguration smsConfiguration =
        SmsConfiguration.builder().setServicePlanId(servicePlanIdToAssociateWithTheNumber).build();

    AvailableNumberRentRequest parameters =
        AvailableNumberRentRequest.builder().setSmsConfiguration(smsConfiguration).build();

    ActiveNumber response = numbersService.rent(phoneNumberToBeRented, parameters);

    LOGGER.info(String.format("Rented number: %s", response));
  }
}
