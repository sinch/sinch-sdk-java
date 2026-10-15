package com.sinch.sdk.domains.voice.models.v2.calls.request;

import com.sinch.sdk.core.models.OptionalValue;

/**
 * Query parameters for starting a call
 *
 * @since 2.3
 */
public interface StartCallQueryParameters {

  /**
   * The ID of the service to use. If omitted, the project's default service is used.
   *
   * @return serviceId
   */
  OptionalValue<String> getServiceId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StartCallQueryParametersImpl.Builder();
  }

  /**
   * Getting builder from existing instance
   *
   * @param parameters Instance to copy the values from
   * @return New Builder instance
   */
  static Builder builder(StartCallQueryParameters parameters) {
    return new StartCallQueryParametersImpl.Builder(parameters);
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param serviceId see getter
     * @return Current builder
     * @see #getServiceId
     */
    Builder setServiceId(String serviceId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StartCallQueryParameters build();
  }
}
