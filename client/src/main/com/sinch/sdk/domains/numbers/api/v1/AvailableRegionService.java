package com.sinch.sdk.domains.numbers.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse;

/**
 * Available Region Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference/#numbersregions-endpoint-category">online
 *     documentation</a>
 * @since TODO NEXT_RELEASE_VERSION
 */
public interface AvailableRegionService {

  /**
   * List available regions
   *
   * @param parameters Filtering criteria
   * @return List of available regions according to search criteria
   * @since TODO NEXT_RELEASE_VERSION
   */
  AvailableRegionListResponse list(AvailableRegionListRequest parameters) throws ApiException;
}
