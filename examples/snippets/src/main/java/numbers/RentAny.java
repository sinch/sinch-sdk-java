/**
 * Sinch Java Snippet
 *
 * <p>This snippet is available at https://github.com/sinch/sinch-sdk-java
 *
 * <p>See https://github.com/sinch/sinch-sdk-java/blob/main/examples/snippets/README.md for details
 */
package numbers;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.models.Configuration;
import java.util.logging.Logger;
import utils.Settings;

public class RentAny {

  private static final Logger LOGGER = Logger.getLogger(RentAny.class.getName());

  public static void main(String[] args) {

    String projectId = Settings.getProjectId().orElse("MY_PROJECT_ID");
    String keyId = Settings.getKeyId().orElse("MY_KEY_ID");
    String keySecret = Settings.getKeySecret().orElse("MY_KEY_SECRET");

    String servicePlanIdToAssociateWithTheNumber =
        Settings.getServicePlanId().orElse("MY_SERVICE_PLAN_ID");

    // ISO 3166-1 alpha-2 country code of the phone number. e.g. "US", "GB", "SE"...
    // See https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2 for details
    String regionCode = "MY_REGION_CODE";

    NumberType numberType = NumberType.LOCAL;

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

    AvailableNumberRentAnyRequest parameters =
        AvailableNumberRentAnyRequest.builder()
            .setType(numberType)
            .setRegionCode(regionCode)
            .setSmsConfiguration(smsConfiguration)
            .build();

    ActiveNumber response = numbersService.rentAny(parameters);

    LOGGER.info(String.format("Rented number: %s", response));
  }
}
