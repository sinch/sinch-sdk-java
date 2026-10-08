package com.sinch.sdk.domains.voice.models.v2.services.request;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Query parameters for listing services
 *
 * @since 2.3
 */
public interface ListServicesQueryParameters {

  /**
   * Filter services by name or description. Returns all services where either the name or
   * description contains the specified value (case-insensitive partial match).
   *
   * @return filter
   */
  OptionalValue<String> getFilter();

  /**
   * Return the default service only.
   *
   * @return isDefault
   */
  OptionalValue<Boolean> getIsDefault();

  /**
   * Number of items to be returned on each page. minimum: 1 maximum: 100
   *
   * @return pageSize
   */
  OptionalValue<Integer> getPageSize();

  /**
   * Page number (1-based) minimum: 1
   *
   * @return page
   */
  OptionalValue<Integer> getPage();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ListServicesQueryParametersImpl.Builder();
  }

  /**
   * Getting builder from existing instance
   *
   * @param parameters Instance to copy the values from
   * @return New Builder instance
   */
  static Builder builder(ListServicesQueryParameters parameters) {
    return new ListServicesQueryParametersImpl.Builder(parameters);
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param filter see getter
     * @return Current builder
     * @see #getFilter
     */
    Builder setFilter(String filter);

    /**
     * see getter
     *
     * @param isDefault see getter
     * @return Current builder
     * @see #getIsDefault
     */
    Builder setIsDefault(Boolean isDefault);

    /**
     * see getter
     *
     * @param pageSize see getter
     * @return Current builder
     * @see #getPageSize
     */
    Builder setPageSize(Integer pageSize);

    /**
     * see getter
     *
     * @param page see getter
     * @return Current builder
     * @see #getPage
     */
    Builder setPage(Integer page);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ListServicesQueryParameters build();
  }
}
