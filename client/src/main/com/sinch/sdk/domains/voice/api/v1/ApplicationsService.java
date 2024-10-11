package com.sinch.sdk.domains.voice.api.v1;

import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersResponse;
import com.sinch.sdk.domains.voice.models.v1.applications.response.QueryNumberResponse;

/**
 * You can use the API to manage features of applications in your project.
 *
 * @since 1.4
 */
public interface ApplicationsService {

  /**
   * Get information about your numbers.
   *
   * <p>It returns a list of numbers that you own, as well as their capability (Voice or SMS). For
   * the ones that are assigned to an app, it returns the application key of the app.
   *
   * @return Your numbers
   * @since 1.4
   */
  OwnedNumbersResponse listNumbers();

  /**
   * Returns any callback URLs configured for the specified application
   *
   * @param applicationKey The unique identifying key of the application
   * @return Assigned callback to application
   * @since 1.4
   */
  Callbacks getCallbackUrls(String applicationKey);

  /**
   * Update the configured callback URLs for the specified application.
   *
   * @param applicationKey The unique identifying key of the application
   * @param parameters Callbacks settings
   * @since 1.4
   */
  void updateCallbackUrls(String applicationKey, Callbacks parameters);

  /**
   * Returns information about the requested number
   *
   * @param number The phone number you want to query
   * @return Number information
   */
  QueryNumberResponse queryNumber(String number);

  /**
   * Update or assign a list of numbers to an application.
   *
   * @param parameters Request parameters
   * @since 1.4
   */
  void assignNumbers(UpdateNumbersRequest parameters);

  /**
   * Un-assign a number from an application.
   *
   * @param parameters Request parameters
   * @since 1.4
   */
  public void unAssignNumber(UnAssignNumberRequest parameters);
}
