package com.sinch.sdk.domains.numbers;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberListRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.ActiveNumberListResponse;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberListRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberUpdateRequest;

/**
 * Active Numbers Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number</a>
 * @since 1.0
 * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.NumbersService} instead.
 */
@Deprecated
public interface ActiveNumberService {

  /**
   * Lists active numbers for a project
   *
   * @param parameters Filtering criteria
   * @return List of active numbers
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.numbers.api.v1.NumbersService#list(ActiveNumberListRequest)} instead.
   */
  @Deprecated
  ActiveNumberListResponse list(ActiveNumberListRequestParameters parameters) throws ApiException;

  /**
   * Get active number information by phone number
   *
   * @param phoneNumber Phone number
   * @return Active number information
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.NumbersService#get(String)}
   *     instead.
   */
  @Deprecated
  ActiveNumber get(String phoneNumber) throws ApiException;

  /**
   * Release an active number from the project
   *
   * @param phoneNumber Phone number
   * @return Released active number
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.NumbersService#release(String)}
   *     instead.
   */
  @Deprecated
  ActiveNumber release(String phoneNumber) throws ApiException;

  /**
   * Update an active phone number
   *
   * @param phoneNumber Phone number
   * @param parameters Parameters to be updated
   * @return Updated active number
   * @since 1.0
   * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.NumbersService#update(String,
   *     ActiveNumberUpdateRequest)} instead.
   */
  @Deprecated
  ActiveNumber update(String phoneNumber, ActiveNumberUpdateRequestParameters parameters)
      throws ApiException;
}
