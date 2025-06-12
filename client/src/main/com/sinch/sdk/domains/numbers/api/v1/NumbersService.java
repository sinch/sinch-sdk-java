package com.sinch.sdk.domains.numbers.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumbersListQueryParameters;
import com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumberListResponse;

/**
 * Numbers Service
 *
 * @see <a href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference">online
 *     documentation</a>
 * @since 1.2
 */
public interface NumbersService extends ActiveNumberService, AvailableNumberService {

  /**
   * Search for available phone numbers
   *
   * <p>Search for available phone numbers that are available for you to activate. You can filter by
   * any property on the available number resource.
   *
   * <p>When searching, indicate the capability of the number in the array as SMS and/or VOICE. To
   * search for a number capable of both, list both SMS and VOICE.
   *
   * @param parameters Filtering criteria
   * @return List of available numbers according to search criteria
   * @since 1.2
   * @deprecated As of release 2.0, replaced by {@link
   *     AvailableNumberService#searchForAvailableNumbers(AvailableNumbersListQueryParameters)}
   */
  @Deprecated
  AvailableNumberListResponse searchForAvailableNumbers(AvailableNumberListRequest parameters)
      throws ApiException;

  /**
   * Activate a new phone number
   *
   * @param phoneNumber Number to be activated
   * @return Activated number See {@link #rent(String, AvailableNumberRentRequest)}.
   * @since 1.7
   */
  ActiveNumber rent(String phoneNumber) throws ApiException;

  /**
   * Lists active numbers for a project
   *
   * @param parameters Filtering criteria
   * @return List of active numbers
   * @since 1.2
   * @deprecated As of release 2.0, replaced by {@link
   *     ActiveNumberService#list(ActiveNumbersListQueryParameters)}
   */
  @Deprecated
  ActiveNumberListResponse list(ActiveNumberListRequest parameters) throws ApiException;

  /**
   * Available Region Service instance
   *
   * @return service instance for project
   * @since 1.2
   */
  AvailableRegionsService regions();

  /**
   * Callbacks Configuration Service instance
   *
   * @return service instance for project
   * @since 1.2
   */
  CallbackConfigurationService callback();

  /**
   * Webhooks helpers instance
   *
   * @return instance service related to webhooks helpers
   * @since 1.2
   */
  WebHooksService webhooks();
}
