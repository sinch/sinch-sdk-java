package com.sinch.sample.numbers;

import com.sinch.sample.Utils;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.*;
import com.sinch.sdk.domains.numbers.models.requests.*;
import com.sinch.sdk.domains.numbers.models.responses.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.responses.AvailableNumberListResponse;
import com.sinch.sdk.domains.numbers.models.responses.AvailableRegionListResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collections;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NumbersSampleFlow {

  private static final String SINCH_PROJECT_ID = "SINCH_PROJECT_ID";
  private static final String SINCH_KEY_ID = "SINCH_KEY_ID";
  private static final String SINCH_KEY_SECRET = "SINCH_KEY_SECRET";

  private static final Logger LOGGER = Utils.initializeLogger(NumbersSampleFlow.class.getName());

  public static void main(String[] args) {

    try {
      Configuration configuration = Utils.loadConfiguration(LOGGER);
      new NumbersSampleFlow().run(configuration);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      System.exit(-1);
    }
  }

  public void run(Configuration configuration) {

    String testRegionCode = "US"; // region code we are interested in
    String testCodePattern = "+1781"; // Boston area code

    SinchClient sinch = new SinchClient(configuration);
    // ===================================================================== \\
    // Scenario: We want to rent a number of type 'LOCAL' in the 'US' region \\
    // ===================================================================== \\
    int step = 0;

    // 1. check and retrieve region code availability
    var regionCode = checkAndGetRegionCodeAvailability(++step, sinch, testRegionCode);

    // 2. retrieve a number for this region code
    boolean rentByNumber = true;
    String phoneNumber;

    if (rentByNumber) {
      //   2.1 can be rent by phone number
      phoneNumber = getAvailablePhoneNumber(++step, sinch, regionCode, testCodePattern);
      // Rent by phone number
      rentPhoneNumber(++step, sinch, phoneNumber);
    } else {
      //   2.2 or can be rent by filtering parameters
      phoneNumber = rentPhoneNumberByAny(++step, sinch, regionCode, testCodePattern);
    }

    // 3 Verify number is active
    // 3.1: verify by dedicated phone number request
    verifyActiveNumberByNumber(++step, sinch, phoneNumber);
    // 3.2: verify by listing page after page and check for requested number
    verifyActiveNumberByPagination(++step, sinch, phoneNumber, regionCode);
    // 3.3: verify by using auto pagination feature and check for requested number
    verifyActiveNumberByAutoPagination(++step, sinch, phoneNumber, regionCode);

    // 4: Update an active number
    updateActiveNumber(++step, sinch, phoneNumber);

    // 5. Release the number
    releasePhoneNumber(++step, sinch, phoneNumber);
  }

  String checkAndGetRegionCodeAvailability(int step, SinchClient sinchClient, String regionCode) {

    echoStep(
        step,
        "List the available regions that support the type 'LOCAL' and check if '"
            + regionCode
            + "' is"
            + " part of them");

    // 1. Build the request data for listing the regions that support 'LOCAL' numbers
    var availableRegionsRequestData =
        AvailableRegionListAllRequestParameters.builder()
            .setTypes(Collections.singletonList(NumberType.LOCAL))
            .build();

    // 2. Request for available regions using the built-in SDK method
    AvailableRegionListResponse availableRegionListResponse =
        sinchClient.numbers().regions().list(availableRegionsRequestData);

    // 3. This API is following the SDK pattern for list and the server response is wrapped inside a
    // ListResponse
    // The response list is found using the getContent() method
    var regions = availableRegionListResponse.getContent();
    // Check whether we have some results and stop the program otherwise
    if (regions.isEmpty()) {
      throw new ApiException(
          "No regions are available for the number type "
              + availableRegionsRequestData.getTypes().orElseThrow().stream()
                  .map(NumberType::valueOf)
                  .collect(Collectors.joining(", ")));
    }

    // 4. auto iteration other items is available for all List responses.
    // In case of underlying API is requiring new calls (paginated results): it will be handled
    // automatically
    echo("List of available regions:");
    availableRegionListResponse.iterator().forEachRemaining(f -> echo(" - " + f.getRegionCode()));

    // 4. Check if 'US' is part of the regions that support the 'LOCAL' type
    if (availableRegionListResponse.stream()
        .noneMatch(region -> regionCode.equals(region.getRegionCode()))) {
      throw new ApiException("The '" + regionCode + "' region is not supported.");
    }

    echo(
        "The region '"
            + regionCode
            + "' is available. Let's use it in the following of this program.\n");

    return regionCode;
  }

  String getAvailablePhoneNumber(
      int step, SinchClient sinchClient, String regionCode, String codePattern) {

    echoStep(
        step,
        "List available numbers in the '"
            + regionCode
            + "' region with pattern '"
            + codePattern
            + "'");

    // 1. Build the request data for listing the numbers of type 'LOCAL' in the regionCode with an
    // area code pattern
    var availableNumbersRequestData =
        AvailableNumberListAllRequestParameters.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setNumberPattern(
                NumberPattern.builder()
                    .setSearchPattern(SearchPattern.START)
                    .setPattern(codePattern)
                    .build())
            .build();

    // 2. Request for available numbers using the built-in SDK method
    // This API is following the SDK pattern for list and the server response is wrapped inside a
    AvailableNumberListResponse availableNumbersListResponse =
        sinchClient.numbers().available().list(availableNumbersRequestData);

    // 3. Looking for first available number
    // auto iteration other items is available for all List responses.
    // In case of underlying API is requiring new calls (paginated results): it will be handled
    // automatically
    AvailableNumber availableNumber =
        availableNumbersListResponse.stream()
            .findFirst()
            .orElseThrow(
                () ->
                    new ApiException(
                        "No numbers are available for the number type "
                            + availableNumbersRequestData.getType()
                            + " in the region "
                            + availableNumbersRequestData.getRegionCode()
                            + " with the pattern "
                            + availableNumbersRequestData.getNumberPattern().get().getPattern()));

    // 4. return the phone number
    String phoneNumber = availableNumber.getPhoneNumber();
    echo("The phone number '" + phoneNumber + "' is available. Let's rent it!\n");

    return phoneNumber;
  }

  void rentPhoneNumber(int step, SinchClient sinchClient, String phoneNumber) {

    echoStep(step, "Rent phone number: '" + phoneNumber + "'");

    // 1. Build the request data
    var rentRequestData = AvailableNumberRentRequestParameters.builder().build();

    // 2. Request to rent the number
    ActiveNumber rentedNumber =
        sinchClient.numbers().available().rent(phoneNumber, rentRequestData);

    echo(
        "The number "
            + rentedNumber.getPhoneNumber()
            + " has been rented with the 'rent' operation.The next charge date is "
            + rentedNumber.getNextChargeDate());
    echo("Let's use now the 'ActiveNumbers' API to see how to manage this number.\n");
  }

  String rentPhoneNumberByAny(
      int step, SinchClient sinchClient, String regionCode, String pattern) {

    echoStep(step, "Rent a phone number for region '" + regionCode + "'");

    // 1. Build the request data
    var rentAnyNumberRequestData =
        AvailableNumberRentAnyRequestParameters.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setNumberPattern(
                NumberPattern.builder()
                    .setSearchPattern(SearchPattern.START)
                    .setPattern(pattern)
                    .build())
            .build();

    // 2. rent a number
    ActiveNumber rentedNumber = sinchClient.numbers().available().rentAny(rentAnyNumberRequestData);

    echo(
        "The number "
            + rentedNumber.getPhoneNumber()
            + " has been rented with the 'rentAny' operation.The next charge date is "
            + rentedNumber.getNextChargeDate()
            + "\n");
    return rentedNumber.getPhoneNumber();
  }

  void verifyActiveNumberByNumber(int step, SinchClient sinchClient, String phoneNumber) {
    echoStep(
        step,
        "Verify the number is part of our active numbers - Method 1: Give the number in input");

    // 1. Simple request to get information related to active number
    ActiveNumber activeNumber = sinchClient.numbers().active().get(phoneNumber);

    echo(
        "SUCCESS: The number "
            + phoneNumber
            + " has been found as an active number. Cost is "
            + activeNumber.getMoney().getAmount()
            + " "
            + activeNumber.getMoney().getCurrencyCode()
            + "\n");
  }

  void verifyActiveNumberByPagination(
      int step, SinchClient sinchClient, String phoneNumber, String regionCode) {

    echoStep(
        step,
        "Check the number is part of our active numbers - Method 2: List all active numbers and"
            + " navigate across pages");

    // 1. Build the request data
    var listActiveNumbersRequestData =
        ActiveNumberListRequestParameters.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setPageSize(2) // Set a low number to demonstrate the pagination later on
            .build();

    // 2. Request for active number using the built-in SDK method
    ActiveNumberListResponse activeNumbersListResponse =
        sinchClient.numbers().active().list(listActiveNumbersRequestData);

    // 3. To check if the phone number is part of the active numbers: check the page
    // content and if not present, check the next page until we find the phone number, or we reach
    // the end of the list
    Optional<ActiveNumber> found;
    do {
      found =
          activeNumbersListResponse.getContent().stream()
              .filter(
                  f ->
                      phoneNumber.equals(f.getPhoneNumber())
                          && regionCode.equals(f.getRegionCode()))
              .findFirst();
      if (found.isEmpty() && activeNumbersListResponse.hasNextPage()) {
        activeNumbersListResponse = activeNumbersListResponse.nextPage();
      } else {
        activeNumbersListResponse = null;
      }
    } while (found.isEmpty() && null != activeNumbersListResponse);

    echo(
        (found.isPresent() ? "SUCCESS:" : "FAILED:")
            + " The number "
            + phoneNumber
            + " is "
            + (found.isPresent() ? "" : "NOT ")
            + "listed in the active numbers.\n");
  }

  void verifyActiveNumberByAutoPagination(
      int step, SinchClient sinchClient, String phoneNumber, String regionCode) {

    echoStep(
        step,
        "Check the number is part of our active numbers - Method 3: List all active numbers and"
            + " navigate across pages using auto pagination SDK feature");

    // 1. Build the request data
    var listActiveNumbersRequestData =
        ActiveNumberListRequestParameters.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setPageSize(2) // Set a low number to demonstrate the pagination later on
            .build();

    // 2. Request for active number using the built-in SDK method
    ActiveNumberListResponse activeNumbersListResponse =
        sinchClient.numbers().active().list(listActiveNumbersRequestData);

    // 3. To check if the phone number is part of the active numbers: use the
    // auto-iterator. Like for hasNextPage/nextPage, http calls will be performed automatically when
    // required
    activeNumbersListResponse = sinchClient.numbers().active().list(listActiveNumbersRequestData);
    var iterator = activeNumbersListResponse.iterator();
    boolean found = false;
    while (iterator.hasNext()) {
      var number =
          iterator
              .next(); // If we are at the end of the current page content, the next() method will
      // perform an HTTP call to load more elements in the iterator
      if (phoneNumber.equals(number.getPhoneNumber())
          && regionCode.equals(number.getRegionCode())) {
        found = true;
        break;
      }
    }

    echo(
        (found ? "SUCCESS:" : "FAILED:")
            + " The number "
            + phoneNumber
            + " is "
            + (found ? "" : "NOT ")
            + "listed in the active numbers.\n");
  }

  void updateActiveNumber(int step, SinchClient sinchClient, String phoneNumber) {

    echoStep(step, "Update active number: '" + phoneNumber + "'");

    // 1. Build the request data
    var updateActiveNumberRequestData =
        ActiveNumberUpdateRequestParameters.builder()
            .setDisplayName("Rented in the scope of testing the Java SDK")
            .build();

    // 2. Request to update the number
    ActiveNumber updatedNumber =
        sinchClient.numbers().active().update(phoneNumber, updateActiveNumberRequestData);

    echo(
        "SUCCESS: The number "
            + phoneNumber
            + " has been updated; the display name is '"
            + updatedNumber.getDisplayName()
            + "'\n");
  }

  void releasePhoneNumber(int step, SinchClient sinchClient, String phoneNumber) {
    echoStep(step, "Releasing  phone number: '" + phoneNumber + "'");

    // 1. Request to release the number
    ActiveNumber releasedNumber = sinchClient.numbers().active().release(phoneNumber);

    echo(
        "SUCCESS: The number "
            + phoneNumber
            + " has been released; it will expire at "
            + releasedNumber.getExpireAt());
  }

  void echoStep(int step, String text) {
    String formatted = "| Step " + step + ": " + text + " |";
    String separator = String.format("+%0" + (formatted.length() - 2) + "d+", 0).replace('0', '-');

    System.out.println(separator);
    System.out.println(formatted);
    System.out.println(separator);
  }

  void echo(String text) {
    System.out.println("  " + text);
  }
}
