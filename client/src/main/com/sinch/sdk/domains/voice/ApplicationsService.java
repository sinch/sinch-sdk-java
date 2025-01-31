package com.sinch.sdk.domains.voice;

import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.NumberInformation;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsAssignNumbersRequestParameters;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequest;
import com.sinch.sdk.models.E164PhoneNumber;

/**
 * You can use the API to manage features of applications in your project.
 *
 * @since 1.0
 * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.ApplicationsService} instead.
 */
@Deprecated
public interface ApplicationsService {

  /**
   * Get information about your numbers.
   *
   * <p>It returns a list of numbers that you own, as well as their capability (voice or SMS). For
   * the ones that are assigned to an app, it returns the application key of the app.
   *
   * @return Your numbers
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.voice.api.v1.ApplicationsService#listNumbers()}
   *     instead.
   */
  @Deprecated
  AssignedNumbers listNumbers();

  /**
   * Returns any callback URLs configured for the specified application
   *
   * @param applicationKey The unique identifying key of the application
   * @return Assigned callback to application
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.voice.api.v1.ApplicationsService#getCallbackUrls(String)} instead.
   */
  @Deprecated
  CallbackUrls getCallbackUrls(String applicationKey);

  /**
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.voice.api.v1.ApplicationsService#updateCallbackUrls(String,
   *     Callbacks)} instead.
   */
  @Deprecated
  void updateCallbackUrls(String applicationKey, CallbackUrls parameters);

  /**
   * @deprecated use {@link
   *     com.sinch.sdk.domains.voice.api.v1.ApplicationsService#queryNumber(String)} instead.
   */
  @Deprecated
  NumberInformation queryNumber(E164PhoneNumber number);

  /**
   * Update or assign a list of numbers to an application.
   *
   * @param parameters Request parameters
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.voice.api.v1.ApplicationsService#assignNumbers(UpdateNumbersRequest)}
   *     instead.
   */
  @Deprecated
  void assignNumbers(ApplicationsAssignNumbersRequestParameters parameters);

  /**
   * Un-assign a number from an application.
   *
   * @param phoneNumber The phone number
   * @param applicationKey Indicates the application where the number was assigned.
   *     <p>If empty, the application key that is used to authenticate
   * @deprecated use {@link
   *     com.sinch.sdk.domains.voice.api.v1.ApplicationsService#unassignNumber(UnAssignNumberRequest)}
   *     instead.
   * @since 1.0
   */
  @Deprecated
  public void unassignNumber(E164PhoneNumber phoneNumber, String applicationKey);
}
