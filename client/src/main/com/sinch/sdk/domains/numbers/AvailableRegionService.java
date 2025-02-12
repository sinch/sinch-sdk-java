package com.sinch.sdk.domains.numbers;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.models.requests.AvailableRegionListAllRequestParameters;
import com.sinch.sdk.domains.numbers.models.responses.AvailableRegionListResponse;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.request.AvailableRegionListRequest;

/**
 * Available Region Service
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Regions">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Regions</a>
 * @deprecated use {@link com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService} instead.
 */
@Deprecated
public interface AvailableRegionService {

  /**
   * List available regions
   *
   * @param parameters Filtering criteria
   * @return List of available regions according to search criteria
   * @since 1.0
   * @deprecated use {@link
   *     com.sinch.sdk.domains.numbers.api.v1.AvailableRegionService#list(AvailableRegionListRequest)}
   *     instead.
   */
  @Deprecated
  AvailableRegionListResponse list(AvailableRegionListAllRequestParameters parameters)
      throws ApiException;
}
