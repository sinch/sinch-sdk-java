/*
 * Mailgun API
 *
 * OpenAPI document version: 0.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.mailgun.models.v1.templates.request;

import com.sinch.sdk.core.models.OptionalValue;

/** GetTemplateQueryParameters */
public interface GetTemplateQueryParameters {

  /**
   * Get active
   *
   * @return active
   */
  OptionalValue<Boolean> getActive();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new GetTemplateQueryParametersImpl.Builder();
  }

  /**
   * Getting builder from existing instance
   *
   * @return New Builder instance
   */
  static Builder builder(GetTemplateQueryParameters parameters) {
    return new GetTemplateQueryParametersImpl.Builder(parameters);
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param active see getter
     * @return Current builder
     * @see #getActive
     */
    Builder setActive(Boolean active);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    GetTemplateQueryParameters build();
  }
}
