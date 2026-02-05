package numbers;

import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import java.util.Collections;
import java.util.logging.Logger;

public class Snippet {

  private static final Logger LOGGER = Logger.getLogger(Snippet.class.getName());

  static void execute(NumbersService numbersService) {

    String servicePlanIdToAssociateWithTheNumber = "MY_SERVICE_PLAN_ID";
    String regionCode = "MY_REGION_CODE";

    Capability capability = Capability.SMS;
    NumberType numberType = NumberType.LOCAL;

    LOGGER.info(
        String.format(
            "Sending request to rent the first available number and configure it with the"
                + " pre-configured service plan id '%s' to use the SMS capability",
            servicePlanIdToAssociateWithTheNumber));

    ActiveNumber response =
        numbersService.rentAny(
            AvailableNumberRentAnyRequest.builder()
                .setCapabilities(Collections.singletonList(capability))
                .setType(numberType)
                .setRegionCode(regionCode)
                .setSmsConfiguration(
                    SmsConfiguration.builder()
                        .setServicePlanId(servicePlanIdToAssociateWithTheNumber)
                        .build())
                .build());

    LOGGER.info(String.format("Rented number: %s", response));
  }
}
