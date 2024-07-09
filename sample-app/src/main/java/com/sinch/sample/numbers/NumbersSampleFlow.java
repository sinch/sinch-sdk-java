package com.sinch.sample.numbers;

import static com.sinch.sample.Utils.echo;
import static com.sinch.sample.Utils.echoStep;

import com.sinch.sample.Utils;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SearchPattern;
import com.sinch.sdk.domains.numbers.models.v1.SearchPosition;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest;
import com.sinch.sdk.models.Configuration;
import java.util.Collections;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NumbersSampleFlow {

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

    NumbersService service = new SinchClient(configuration).numbers().v1();
    // ===================================================================== \\
    // Scenario: We want to rent a number of type 'LOCAL' in the 'US' region \\
    // ===================================================================== \\
    int step = 0;

    // 1. check and retrieve region code availability
    var regionCode = checkAndGetRegionCodeAvailability(++step, service.regions(), testRegionCode);

    // 2. retrieve a number for this region code
    boolean rentByNumber = true;
    String phoneNumber;

    if (rentByNumber) {
      //   2.1 can be rent by phone number
      phoneNumber = getAvailablePhoneNumber(++step, service, regionCode, testCodePattern);
      // Rent by phone number
      rentPhoneNumber(++step, service, phoneNumber);
    } else {
      //   2.2 or can be rent by filtering parameters
      phoneNumber = rentPhoneNumberByAny(++step, service, regionCode, testCodePattern);
    }

    echo("Let's use now the 'ActiveNumbers' API to see how to manage this number.\n");

    // 3 Verify number is active
    // 3.1: verify by dedicated phone number request
    verifyActiveNumberByNumber(++step, service, phoneNumber);
    // 3.2: verify by listing page after page and check for requested number
    verifyActiveNumberByPagination(++step, service, phoneNumber, regionCode);
    // 3.3: verify by using auto pagination feature and check for requested number
    verifyActiveNumberByAutoPagination(++step, service, phoneNumber, regionCode);

    // 4: Update an active number
    updateActiveNumber(++step, service, phoneNumber);

    // 5. Release the number
    releasePhoneNumber(++step, service, phoneNumber);
  }

  String checkAndGetRegionCodeAvailability(
      int step, AvailableRegionService service, String regionCode) {

    echoStep(
        step,
        "List the available regions that support the type 'LOCAL' and check if '"
            + regionCode
            + "' is"
            + " part of them");

    // 1. Build the request data for listing the regions that support 'LOCAL' numbers
    var availableRegionsRequestData =
        AvailableRegionListRequest.builder()
            .setTypes(Collections.singletonList(NumberType.LOCAL))
            .build();

    // 2. Request for available regions using the built-in SDK method
    var availableRegionListResponse = service.list(availableRegionsRequestData);

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
      int step, NumbersService service, String regionCode, String codePattern) {

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
        AvailableNumberListRequest.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setSearchPattern(
                SearchPattern.builder()
                    .setPosition(SearchPosition.START)
                    .setPattern(codePattern)
                    .build())
            .build();

    // 2. Request for available numbers using the built-in SDK method
    // This API is following the SDK pattern for list and the server response is wrapped inside a
    var availableNumbersListResponse =
        service.searchForAvailableNumbers(availableNumbersRequestData);

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
                            + availableNumbersRequestData.getSearchPattern()));

    // 4. return the phone number
    String phoneNumber = availableNumber.getPhoneNumber();
    echo("The phone number '" + phoneNumber + "' is available. Let's rent it!\n");

    return phoneNumber;
  }

  void rentPhoneNumber(int step, NumbersService service, String phoneNumber) {

    echoStep(step, "Rent phone number: '" + phoneNumber + "'");

    // 1. Build the request data
    var rentRequestData =
        AvailableNumberRentRequest.builder().setCallbackUrl("https://foo.url").build();

    // 2. Request to rent the number
    ActiveNumber rentedNumber = service.rent(phoneNumber, rentRequestData);

    echo(
        "The number "
            + rentedNumber.getPhoneNumber()
            + " has been rented with the 'rent' operation.The next charge date is "
            + rentedNumber.getNextChargeDate());
  }

  String rentPhoneNumberByAny(int step, NumbersService service, String regionCode, String pattern) {

    echoStep(step, "Rent a phone number for region '" + regionCode + "'");

    // 1. Build the request data
    var rentAnyNumberRequestData =
        AvailableNumberRentAnyRequest.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setNumberPattern(
                SearchPattern.builder()
                    .setPosition(SearchPosition.START)
                    .setPattern(pattern)
                    .build())
            .build();

    // 2. rent a number
    ActiveNumber rentedNumber = service.rentAny(rentAnyNumberRequestData);

    echo(
        "The number "
            + rentedNumber.getPhoneNumber()
            + " has been rented with the 'rentAny' operation.The next charge date is "
            + rentedNumber.getNextChargeDate()
            + "\n");
    return rentedNumber.getPhoneNumber();
  }

  void verifyActiveNumberByNumber(int step, NumbersService service, String phoneNumber) {
    echoStep(
        step,
        "Verify the number is part of our active numbers - Method 1: Give the number in input");

    // 1. Simple request to get information related to active number
    ActiveNumber activeNumber = service.get(phoneNumber);

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
      int step, NumbersService service, String phoneNumber, String regionCode) {

    echoStep(
        step,
        "Check the number is part of our active numbers - Method 2: List all active numbers and"
            + " navigate across pages");

    // 1. Build the request data
    var listActiveNumbersRequestData =
        ActiveNumberListRequest.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setPageSize(2) // Set a low number to demonstrate the pagination later on
            .build();

    // 2. Request for active number using the built-in SDK method
    var activeNumbersListResponse = service.list(listActiveNumbersRequestData);

    // 3. To check if the phone number is part of the active numbers: check the page
    // content and if not present, check the next page until we find the phone number, or we reach
    // the end of the list
    Optional<ActiveNumber> found;
    boolean reachedEndOfPages = false;
    do {
      // use stream onto page content to looking for phoneNumber
      found =
          activeNumbersListResponse.getContent().stream()
              .filter(
                  f ->
                      phoneNumber.equals(f.getPhoneNumber())
                          && regionCode.equals(f.getRegionCode()))
              .findFirst();

      // not present within current page
      if (found.isEmpty()) {
        // need to load the next one... if there is one available
        if (activeNumbersListResponse.hasNextPage()) {
          activeNumbersListResponse = activeNumbersListResponse.nextPage();
        } else {
          reachedEndOfPages = true;
        }
      }
    } while (found.isEmpty() && !reachedEndOfPages);

    echo(
        (found.isPresent() ? "SUCCESS:" : "FAILED:")
            + " The number "
            + phoneNumber
            + " is "
            + (found.isPresent() ? "" : "NOT ")
            + "listed in the active numbers.\n");
  }

  void verifyActiveNumberByAutoPagination(
      int step, NumbersService service, String phoneNumber, String regionCode) {

    echoStep(
        step,
        "Check the number is part of our active numbers - Method 3: List all active numbers and"
            + " navigate across pages using auto pagination SDK feature");

    // 1. Build the request data
    var listActiveNumbersRequestData =
        ActiveNumberListRequest.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setPageSize(2) // Set a low number to demonstrate the pagination later on
            .build();

    // 2. Request for active number using the built-in SDK method
    var activeNumbersListResponse = service.list(listActiveNumbersRequestData);

    // 3. To check if the phone number is part of the active numbers: use the
    // auto-iterator. Like for hasNextPage/nextPage, http calls will be performed automatically when
    // required
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

  void updateActiveNumber(int step, NumbersService service, String phoneNumber) {

    echoStep(step, "Update active number: '" + phoneNumber + "'");

    // 1. Build the request data
    var updateActiveNumberRequestData =
        ActiveNumberUpdateRequest.builder()
            .setDisplayName("Rented in the scope of testing the Java SDK")
            .build();

    // 2. Request to update the number
    ActiveNumber updatedNumber = service.update(phoneNumber, updateActiveNumberRequestData);

    echo(
        "SUCCESS: The number "
            + phoneNumber
            + " has been updated; the display name is '"
            + updatedNumber.getDisplayName()
            + "'\n");
  }

  void releasePhoneNumber(int step, NumbersService service, String phoneNumber) {
    echoStep(step, "Releasing  phone number: '" + phoneNumber + "'");

    // 1. Request to release the number
    ActiveNumber releasedNumber = service.release(phoneNumber);

    echo(
        "SUCCESS: The number "
            + phoneNumber
            + " has been released; it will expire at "
            + releasedNumber.getExpireAt());
  }
}
