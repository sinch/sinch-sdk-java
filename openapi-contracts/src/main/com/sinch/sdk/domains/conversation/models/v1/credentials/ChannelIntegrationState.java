/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.credentials;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** State of the channel credentials integration. */
@JsonDeserialize(builder = ChannelIntegrationStateImpl.Builder.class)
public interface ChannelIntegrationState {

  /**
   * Get status
   *
   * @return status
   */
  ChannelIntegrationStatus getStatus();

  /**
   * Description in case the integration fails
   *
   * @return description
   */
  String getDescription();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ChannelIntegrationStateImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param status see getter
     * @return Current builder
     * @see #getStatus
     */
    Builder setStatus(ChannelIntegrationStatus status);

    /**
     * see getter
     *
     * @param description see getter
     * @return Current builder
     * @see #getDescription
     */
    Builder setDescription(String description);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ChannelIntegrationState build();
  }
}
