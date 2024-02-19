package com.sinch.sdk.domains.voice;

import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.NumberInformation;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsAssignNumbersRequestParameters;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.models.E164PhoneNumber;

/** You can use the API to manage features of applications in your project. */
public interface ApplicationsService {

  /**
   * Get information about your numbers.
   *
   * <p>It returns a list of numbers that you own, as well as their capability (voice or SMS). For
   * the ones that are assigned to an app, it returns the application key of the app.
   *
   * @return Your numbers
   * @since 1.0
   */
  AssignedNumbers getNumbers();

  /**
   * Returns any callback URLs configured for the specified application
   *
   * @param applicationKey The unique identifying key of the application
   * @return Assigned callback to application
   * @since 1.0
   */
  CallbackUrls getCallbackUrls(String applicationKey);

  /**
   * @since 1.0
   */
  void updateCallbackUrls(String applicationKey, CallbackUrls parameters);

  NumberInformation queryNumber(E164PhoneNumber number);

  /**
   * Update or assign a list of numbers to an application.
   *
   * @param parameters Request parameters
   * @since 1.0
   */
  void assignNumbers(ApplicationsAssignNumbersRequestParameters parameters);

  /**
   * Un-assign a number from an application.
   *
   * @param phoneNumber The phone number
   * @param applicationKey Indicates the application where the number was assigned.
   *     <p>If empty, the application key that is used to authenticate
   * @since 1.0
   */
  public void unassignNumber(E164PhoneNumber phoneNumber, String applicationKey);
}
