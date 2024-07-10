package com.sinch.sdk.domains.numbers.models.v1.request;

import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import java.util.Collection;

/**
 * Parameters request to list available numbers for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers">https://developers.sinch.com/docs/numbers/api-reference/numbers/tag/Available-Number/#tag/Available-Number/operation/NumberService_ListAvailableNumbers/</a>
 * @since 1.2
 */
public interface AvailableNumberListRequest {

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
  Integer getSize();

  static Builder builder() {
    return AvailableNumberListRequestImpl.builder();
  }

  interface Builder {

    /**
     * @param regionCode Region code to filter by. ISO 3166-1 alpha-2 country code of the phone
     *     number. Example: US, GB or SE.
     * @return current builder
     */
    Builder setRegionCode(String regionCode);

    /**
     * @param type Number type to filter by
     * @return current builder
     */
    Builder setType(NumberType type);

    /**
     * @param searchPattern Search criteria
     * @return current builder
     */
    Builder setSearchPattern(SearchPattern searchPattern);

    /**
     * @param capabilities capability criteria
     * @return current builder
     */
    Builder setCapabilities(Collection<Capability> capabilities);

    /**
     * @param size Optional. The maximum number of items to return.
     * @return current builder
     */
    Builder setSize(Integer size);

    AvailableNumberListRequest build();
  }
}
