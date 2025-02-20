/*
 * API Overview | Sinch
 *
 * OpenAPI document version: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.v1.groups.request;

import com.sinch.sdk.core.models.OptionalValue;

/** ListGroupsQueryParameters */
public interface ListGroupsQueryParameters {

  /**
   * Get page minimum: 0
   *
   * @return page
   */
  OptionalValue<Integer> getPage();

  /**
   * Get pageSize minimum: 0 maximum: 100
   *
   * @return pageSize
   */
  OptionalValue<Integer> getPageSize();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ListGroupsQueryParametersImpl.Builder();
  }

  /**
   * Getting builder from existing instance
   *
   * @return New Builder instance
   */
  static Builder builder(ListGroupsQueryParameters parameters) {
    return new ListGroupsQueryParametersImpl.Builder(parameters);
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param page see getter
     * @return Current builder
     * @see #getPage
     */
    Builder setPage(Integer page);

    /**
     * see getter
     *
     * @param pageSize see getter
     * @return Current builder
     * @see #getPageSize
     */
    Builder setPageSize(Integer pageSize);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ListGroupsQueryParameters build();
  }
}
