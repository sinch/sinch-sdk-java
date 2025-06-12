package com.sinch.sdk.domains.numbers.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse;
import com.sinch.sdk.domains.numbers.models.v1.regions.request.AvailableRegionsListQueryParameters;

/**
 * Available Region Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/sdk/java/syntax-reference/#numbersregions-endpoint-category">online
 *     documentation</a>
 * @since 1.2
 * @deprecated As of release 2.0, replaced by {@link AvailableRegionsService}
 */
@Deprecated
public interface AvailableRegionService {

  /**
   * List available regions
   *
   * @param parameters Filtering criteria
   * @return List of available regions according to search criteria
   * @since 1.2
   * @deprecated As of release 2.0, replaced by {@link
   *     AvailableRegionsService#list(AvailableRegionsListQueryParameters)}
   */
  @Deprecated
  AvailableRegionListResponse list(AvailableRegionListRequest parameters) throws ApiException;
}
