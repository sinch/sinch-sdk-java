package com.sinch.sdk.domains.numbers.models.v1.active.request;

import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SearchPattern;
import java.util.Collection;

/**
 * Parameters request to list active numbers for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Active-Number/</a>
 * @since TODO NEXT_RELEASE_VERSION
 */
public interface ActiveNumberListRequest {

  /**
   * @return Region code to filter by. ISO 3166-1 alpha-2 country code of the phone number. Example:
   *     &#x60;US&#x60;, &#x60;GB&#x60; or &#x60;SE&#x60;. (required)
   */
  String getRegionCode();

  /**
   * @return Number type to filter by. Options include, &#x60;MOBILE&#x60;, &#x60;LOCAL&#x60; or
   *     &#x60;TOLL_FREE&#x60;. (required)
   */
  NumberType getType();

  /**
   * @return Search criteria
   */
  SearchPattern getSearchPattern();

  /**
   * @return Number capabilities to filter by, &#x60;SMS&#x60; and/or &#x60;VOICE&#x60;.
   */
  Collection<Capability> getCapabilities();

  /**
   * @return The maximum number of items to return
   */
  Integer getPageSize();

  /**
   * @return The next page token value returned from a previous List request, if any.
   */
  String getPageToken();

  /**
   * @return Supported fields for ordering by &#x60;phoneNumber&#x60; or * &#x60;displayName&#x60;
   */
  OrderBy getOrderBy();

  static Builder builder() {
    return new ActiveNumberListRequestImpl.Builder();
  }

  static Builder builder(ActiveNumberListRequest parameters) {
    return new ActiveNumberListRequestImpl.Builder(parameters);
  }

  public interface Builder {

    /**
     * @param regionCode Region code to filter by. ISO 3166-1 alpha-2 country code of the phone
     *     number. Example: US, GB or SE.
     * @return Current builder
     */
    Builder setRegionCode(String regionCode);

    /**
     * @param type Number type to filter by
     * @return Current builder
     */
    Builder setType(NumberType type);

    /**
     * @param searchPattern Pattern to search for
     * @return Current builder
     */
    Builder setSearchPattern(SearchPattern searchPattern);

    /**
     * @param capabilities Number capabilities to filter by
     * @return Current builder
     */
    Builder setCapabilities(Collection<Capability> capabilities);

    /**
     * @param pageSize The maximum number of items to return.
     * @return Current builder
     */
    Builder setPageSize(Integer pageSize);

    /**
     * @param pageToken The next page token value returned from a previous List request, if any
     * @return Current builder
     */
    Builder setPageToken(String pageToken);

    /**
     * @param orderBy Ordering results
     * @return Current builder
     */
    Builder setOrderBy(OrderBy orderBy);

    ActiveNumberListRequest build();
  }
}
