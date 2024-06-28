package com.sinch.sdk.domains.numbers.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.active.request.ActiveNumberUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.active.response.ActiveNumberListResponse;

/**
 * Active Numbers Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference/#numbersactive-endpoint-category">online
 *     documentation</a>
 * @since TODO NEXT_RELEASE_VERSION
 */
public interface ActiveNumberService {

  /**
   * Lists active numbers for a project
   *
   * @param parameters Filtering criteria
   * @return List of active numbers
   * @since TODO NEXT_RELEASE_VERSION
   */
  ActiveNumberListResponse list(ActiveNumberListRequest parameters) throws ApiException;

  /**
   * Get active number information by phone number
   *
   * @param phoneNumber Phone number
   * @return Active number information
   * @since TODO NEXT_RELEASE_VERSION
   */
  ActiveNumber get(String phoneNumber) throws ApiException;

  /**
   * Release an active number from the project
   *
   * @param phoneNumber Phone number
   * @return Released active number
   * @since TODO NEXT_RELEASE_VERSION
   */
  ActiveNumber release(String phoneNumber) throws ApiException;

  /**
   * Update an active phone number
   *
   * @param phoneNumber Phone number
   * @param parameters Parameters to be updated
   * @return Updated active number
   * @since TODO NEXT_RELEASE_VERSION
   */
  ActiveNumber update(String phoneNumber, ActiveNumberUpdateRequest parameters) throws ApiException;
}
