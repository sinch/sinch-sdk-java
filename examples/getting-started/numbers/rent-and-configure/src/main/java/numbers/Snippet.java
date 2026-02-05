package numbers;

import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import java.util.logging.Logger;

public class Snippet {

  private static final Logger LOGGER = Logger.getLogger(Snippet.class.getName());

  static void execute(NumbersService numbersService) {

    // Available numbers list can be retrieved by using list() function from available service, see:
    // https://developers.sinch.com/docs/numbers/getting-started
    String phoneNumberToBeRented = "AVAILABLE_PHONE_NUMBER_TO_BE_RENTED";
    String servicePlanIdToAssociateWithTheNumber = "MY_SERVICE_PLAN_ID";

    SmsConfiguration smsConfiguration =
        SmsConfiguration.builder().setServicePlanId(servicePlanIdToAssociateWithTheNumber).build();

    LOGGER.info(
        String.format(
            "Sending request to rent the virtual number: '%s' and configure it with the"
                + " pre-configured service plan id '%s' to use the SMS capability",
            phoneNumberToBeRented, servicePlanIdToAssociateWithTheNumber));

    AvailableNumberRentRequest rentRequest =
        AvailableNumberRentRequest.builder().setSmsConfiguration(smsConfiguration).build();

    ActiveNumber response = numbersService.rent(phoneNumberToBeRented, rentRequest);

    LOGGER.info(String.format("Rented number: %s", response));
  }
}
