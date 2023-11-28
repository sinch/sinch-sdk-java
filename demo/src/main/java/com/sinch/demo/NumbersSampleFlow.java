package com.sinch.demo;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.*;
import com.sinch.sdk.domains.numbers.models.requests.*;
import com.sinch.sdk.domains.numbers.models.responses.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.responses.AvailableNumberListResponse;
import com.sinch.sdk.domains.numbers.models.responses.AvailableRegionListResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NumbersSampleFlow {
  private static final String SINCH_PROJECT_ID = "SINCH_PROJECT_ID";
  private static final String SINCH_KEY_ID = "SINCH_KEY_ID";
  private static final String SINCH_KEY_SECRET = "SINCH_KEY_SECRET";

  private static final Logger LOGGER = Utils.initializeLogger(NumbersSampleFlow.class.getName());

  public static void main(String[] args) {
    Properties properties = Utils.loadProperties(LOGGER);

    if (!properties.isEmpty()) {
      String projectId = properties.getProperty(SINCH_PROJECT_ID);
      String keyId = properties.getProperty(SINCH_KEY_ID);
      String keySecret = properties.getProperty(SINCH_KEY_SECRET);

      Configuration configuration =
          Configuration.builder()
              .setProjectId(projectId)
              .setKeyId(keyId)
              .setKeySecret(keySecret)
              .build();

      new NumbersSampleFlow().run(configuration);
    } else {
      LOGGER.severe("Failed to load the properties from config.properties");
    }
  }

  public void run(Configuration configuration) {

    SinchClient sinch = new SinchClient(configuration);

    // ===================================================================== \\
    // Scenario: We want to rent a number of type 'LOCAL' in the 'US' region \\
    // ===================================================================== \\

    System.out.println(
        "+----------------------------------------------------------------------------------------------------+");
    System.out.println(
        "| Step 1: List the available regions that support the type 'LOCAL' and check is 'US' is"
            + " part of them |");
    System.out.println(
        "+----------------------------------------------------------------------------------------------------+");

    // Build the request data for listing the regions that support 'LOCAL' numbers
    var availableRegionsRequestData =
        AvailableRegionListAllRequestParameters.builder()
            .setTypes(Collections.singletonList(NumberType.LOCAL))
            .build();

    // Declare the variable holding the response
    AvailableRegionListResponse availableRegionListResponse;
    try {
      // Send the HTTP request using the built-in SDK method
      availableRegionListResponse = sinch.numbers().regions().list(availableRegionsRequestData);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      return;
    }

    // Even if not paginated, this API is following the SDK pattern for list and the server response
    // is wrapped inside a ListResponse
    // The actual response is found using the getContent() method
    var regions = availableRegionListResponse.getContent();

    // Check whether we have some results and stop the program otherwise
    if (regions.isEmpty()) {
      LOGGER.severe(
          "No regions are available for the number type "
              + availableRegionsRequestData.getTypes().orElseThrow().stream()
                  .map(NumberType::valueOf)
                  .collect(Collectors.joining(", ")));
      return;
    }

    // Check if 'US' is part of the regions that support the 'LOCAL' type
    System.out.println(
        "List of available regions: "
            + regions.stream().map(Region::getRegionCode).collect(Collectors.joining(", ")));
    String regionCode = "";
    if (regions.stream().anyMatch(region -> "US".equals(region.getRegionCode()))) {
      regionCode = "US";
      System.out.println(
          "The region '"
              + regionCode
              + "' is available. Let's use it in the following of this program.\n");
    } else {
      LOGGER.severe("The 'US' region is not supported.");
    }

    System.out.println("+---------------------------------------------------+");
    System.out.println("| Step 2: List available numbers in the '" + regionCode + "' region |");
    System.out.println("+---------------------------------------------------+");

    // Build the request data for listing the numbers of type 'LOCAL' in the 'US' region
    var availableNumbersRequestData =
        AvailableNumberListAllRequestParameters.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setNumberPattern(
                NumberPattern.builder()
                    .setSearchPattern(SearchPattern.START)
                    .setPattern("+1781")
                    .build()) // Boston area code
            .build();

    // Declare the variable holding the response
    AvailableNumberListResponse availableNumbersListResponse;
    try {
      // Send the HTTP request using the built-in SDK method
      availableNumbersListResponse = sinch.numbers().available().list(availableNumbersRequestData);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      return;
    }

    // Even if not paginated, this API is following the SDK pattern for list and the server response
    // is wrapped inside a ListResponse
    // The actual response is found using the getContent() method
    var availableNumbers = availableNumbersListResponse.getContent();

    // Check whether we have some results and stop the program otherwise
    if (availableNumbers.isEmpty()) {
      LOGGER.severe(
          "No numbers are available for the number type "
              + availableNumbersRequestData.getType()
              + " in the region "
              + availableNumbersRequestData.getRegionCode()
              + " with the pattern "
              + availableNumbersRequestData.getNumberPattern().get().getPattern());
      return;
    }

    // Store the first phone number of the response
    AvailableNumber availableNumber = availableNumbers.stream().findFirst().orElseThrow();
    String phoneNumber = availableNumber.getPhoneNumber();
    System.out.println("The phone number " + phoneNumber + " is available. Let's rent it!\n");

    System.out.println("+-------------------------------+");
    System.out.println("| Step 3: Rent the phone number |");
    System.out.println("+-------------------------------+");

    var rentRequestData = AvailableNumberRentRequestParameters.builder().build();

    // Declare the variable holding the response
    ActiveNumber rentedNumber;
    try {
      // Send the HTTP request using the built-in SDK method
      rentedNumber = sinch.numbers().available().rent(phoneNumber, rentRequestData);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      return;
    }

    System.out.println(
        "The number "
            + rentedNumber.getPhoneNumber()
            + " has been rented. The next charge date is "
            + rentedNumber.getNextChargeDate());
    System.out.println("Let's use now the 'ActiveNumbers' API to see how to manage this number.\n");

    // NOTE: the 2 calls above can be merged in one with 'rentAny` operation. Feel free to uncomment
    // the following code and try it out
    //    var rentAnyNumberRequestData = AvailableNumberRentAnyRequestParameters.builder()
    //        .setRegionCode(regionCode)
    //        .setType(NumberType.LOCAL)
    //        .setNumberPattern(NumberPattern.builder()
    //            .setSearchPattern(SearchPattern.START)
    //            .setPattern("+1781").build())
    //        .build();
    //
    //    ActiveNumber rentedAnyNumber;
    //    try {
    //      rentedAnyNumber = sinch.numbers().available().rentAny(rentAnyNumberRequestData);
    //    } catch (ApiException apiException) {
    //      LOGGER.severe(apiException.toString());
    //      return;
    //    }
    //
    //    System.out.println("The number " + rentedAnyNumber.getPhoneNumber() + " has been rented
    // with the 'rentAny' operation. The next charge date is " + rentedAnyNumber.getNextChargeDate()
    // + "\n");

    System.out.println(
        "+----------------------------------------------------------------------------------------------+");
    System.out.println(
        "| Step 4: Verify the number is part of our active numbers - Method 1: Give the number in"
            + " input |");
    System.out.println(
        "+----------------------------------------------------------------------------------------------+");

    // Declare the variable holding the response
    ActiveNumber activeNumber;
    try {
      // Send the HTTP request using the built-in SDK method
      activeNumber = sinch.numbers().active().get(phoneNumber);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      return;
    }

    System.out.println(
        "SUCCESS: The number "
            + phoneNumber
            + " has been found as an active number. Cost is "
            + activeNumber.getMoney().getAmount()
            + " "
            + activeNumber.getMoney().getCurrencyCode()
            + "\n");

    System.out.println(
        "+--------------------------------------------------------------------------------------------+");
    System.out.println(
        "| Step 4: Check the number is part of our active numbers - Method 2: List all active"
            + " numbers |");
    System.out.println(
        "+--------------------------------------------------------------------------------------------+");

    var listActiveNumbersRequestData =
        ActiveNumberListRequestParameters.builder()
            .setRegionCode(regionCode)
            .setType(NumberType.LOCAL)
            .setPageSize(2) // Set a low number to demonstrate the pagination later on
            .build();

    // Declare the variable holding the response
    ActiveNumberListResponse activeNumbersListResponse;
    try {
      // Send the HTTP request using the built-in SDK method
      activeNumbersListResponse = sinch.numbers().active().list(listActiveNumbersRequestData);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      return;
    }

    // First possibility to check is the phone number is part of the active numbers: check the page
    // content and if not present, check the next page until we find the phone number, or we reach
    // the end of the list
    boolean found = false;
    // The 'list' operation supports pagination: the response content is wrapped inside the
    // 'ListResponse' interface
    List<ActiveNumber> activeNumbersList =
        (List<ActiveNumber>) activeNumbersListResponse.getContent();
    int numbersListSize = activeNumbersList.size();

    for (int i = 0; i < numbersListSize; i++) {
      if (phoneNumber.equals(activeNumbersList.get(i).getPhoneNumber())) {
        found = true;
        break;
      } else {
        // Check if we are at the end of the current page and if there are more pages to load from
        // the server
        if (i == numbersListSize - 1 && activeNumbersListResponse.hasNextPage()) {
          // If yes, load more active numbers: 'nextPage()' will perform an HTTP call to fetch more
          // active numbers
          activeNumbersListResponse = activeNumbersListResponse.nextPage();
          // Reset the elements of the loop to continue searching for the phone number
          activeNumbersList = (List<ActiveNumber>) activeNumbersListResponse.getContent();
          numbersListSize = activeNumbersList.size();
          i = -1;
        }
      }
    }

    System.out.println("Active numbers search - first method using standard pagination");
    System.out.println(
        "The number "
            + phoneNumber
            + " is "
            + (found ? "" : "NOT ")
            + "listed in the active numbers.");

    // Second possibility to check if the phone  number is part of the active numbers: use the
    // auto-iterator. Be careful, HTTP calls will be done under the hood without explicit mention in
    // the source code
    activeNumbersListResponse = sinch.numbers().active().list(listActiveNumbersRequestData);
    var activeNumbersIterator = activeNumbersListResponse.autoPageIter();
    found = false;
    while (activeNumbersIterator.hasNext()) {
      var number =
          activeNumbersIterator
              .next(); // If we are at the end of the iterator content, the next() method will
      // perform an HTTP call to load more elements in the iterator
      if (phoneNumber.equals(number.getPhoneNumber())) {
        found = true;
        break;
      }
    }

    System.out.println("Active numbers search - second method using the iterator");
    System.out.println(
        "The number "
            + phoneNumber
            + " is "
            + (found ? "" : "NOT ")
            + "listed in the active numbers.\n");

    System.out.println("+---------------------------------+");
    System.out.println("| Step 5: Update an active number |");
    System.out.println("+---------------------------------+");

    var updateActiveNumberRequestData =
        ActiveNumberUpdateRequestParameters.builder()
            .setDisplayName("Rented in the scope of testing the Java SDK")
            .build();

    // Declare the variable holding the response
    ActiveNumber updatedNumber;
    try {
      // Send the HTTP request using the built-in SDK method
      updatedNumber = sinch.numbers().active().update(phoneNumber, updateActiveNumberRequestData);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      return;
    }

    System.out.println(
        "SUCCESS: The number "
            + phoneNumber
            + " has been updated; the display name is '"
            + updatedNumber.getDisplayName()
            + "'\n");

    System.out.println("+----------------------------------+");
    System.out.println("| Step 6: Release the phone number |");
    System.out.println("+----------------------------------+");

    ActiveNumber releasedNumber;
    try {
      // Send the HTTP request using the built-in SDK method
      releasedNumber = sinch.numbers().active().release(phoneNumber);
    } catch (ApiException apiException) {
      LOGGER.severe(apiException.toString());
      return;
    }

    System.out.println(
        "SUCCESS: The number "
            + phoneNumber
            + " has been released; it will expire at "
            + releasedNumber.getExpireAt());
  }
}
