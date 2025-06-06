/*
 * Mailgun API
 *
 * OpenAPI document version: 0.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.mailgun.models.v1.emails.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** ExceededQueueQuota */
@JsonDeserialize(builder = ExceededQueueQuotaImpl.Builder.class)
public interface ExceededQueueQuota {

  /**
   * Get isDisabled
   *
   * @return isDisabled
   */
  Boolean getIsDisabled();

  /**
   * Get details
   *
   * @return details
   */
  QueueStatusDisabledDetails getDetails();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ExceededQueueQuotaImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param isDisabled see getter
     * @return Current builder
     * @see #getIsDisabled
     */
    Builder setIsDisabled(Boolean isDisabled);

    /**
     * see getter
     *
     * @param details see getter
     * @return Current builder
     * @see #getDetails
     */
    Builder setDetails(QueueStatusDisabledDetails details);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ExceededQueueQuota build();
  }
}
