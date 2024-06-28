package com.sinch.sdk.domains.numbers.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberRentRequest;
import com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumberListResponse;

/**
 * Available Number Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference/#numbersavailable-endpoint-category">online
 *     documentatio</a>
 * @since TODO NEXT_RELEASE_VERSION
 */
public interface AvailableNumberService {

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
   * @since TODO NEXT_RELEASE_VERSION
   */
  AvailableNumberListResponse list(AvailableNumberListRequest parameters) throws ApiException;

  /**
   * Get available number information by phone number
   *
   * <p>This endpoint allows you to enter a specific phone number to check if it's available for use
   *
   * @param phoneNumber Phone number
   * @return Available number information
   * @since TODO NEXT_RELEASE_VERSION
   */
  AvailableNumber checkAvailability(String phoneNumber) throws ApiException;

  /**
   * Activate a new phone number
   *
   * <p>Activate a phone number to use with SMS products, Voice products, or both.
   *
   * <p>You'll use smsConfiguration to setup your number for SMS and voiceConfiguration for Voice.
   * To setup for both, add both objects. See the dropdown menu (just under language selection) for
   * code samples.
   *
   * <p>Note: You cannot add both objects if you only need to configure one object. For example, if
   * you only need to configure smsConfiguration for SMS messaging, do not add the
   * voiceConfiguration object or it will result in an error.
   *
   * @param phoneNumber Number to be activated
   * @param parameters Activation parameters
   * @return Activated number
   * @since TODO NEXT_RELEASE_VERSION
   */
  ActiveNumber rent(String phoneNumber, AvailableNumberRentRequest parameters) throws ApiException;

  /**
   * Rent any number that matches the criteria
   *
   * <p>Activates a phone number that matches the search criteria provided in the request. Currently
   * the rentAny operation works only for US LOCAL numbers
   *
   * @param parameters Selection and activation parameters
   * @return Activated number according to criteria
   * @since TODO NEXT_RELEASE_VERSION
   */
  ActiveNumber rentAny(AvailableNumberRentAnyRequest parameters) throws ApiException;
}
