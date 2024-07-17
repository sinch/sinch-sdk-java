/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.v1.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration;

/** The phone number that has been rented by a customer and assigned to a project. */
@JsonDeserialize(builder = ActiveNumberUpdateRequestImpl.Builder.class)
public interface ActiveNumberUpdateRequest {

  /**
   * User supplied name for the phone number.
   *
   * @return displayName
   */
  String getDisplayName();

  /**
   * Get smsConfiguration
   *
   * @return smsConfiguration
   */
  SmsConfiguration getSmsConfiguration();

  /**
   * Get voiceConfiguration
   *
   * @return voiceConfiguration
   */
  VoiceConfiguration getVoiceConfiguration();

  /**
   * The active number's callback URL to be called for provisioning / deprovisioning updates
   *
   * @return callbackUrl
   */
  String getCallbackUrl();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ActiveNumberUpdateRequestImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param displayName see getter
     * @return Current builder
     * @see #getDisplayName
     */
    Builder setDisplayName(String displayName);

    /**
     * see getter
     *
     * @param smsConfiguration see getter
     * @return Current builder
     * @see #getSmsConfiguration
     */
    Builder setSmsConfiguration(SmsConfiguration smsConfiguration);

    /**
     * see getter
     *
     * @param voiceConfiguration see getter
     * @return Current builder
     * @see #getVoiceConfiguration
     */
    Builder setVoiceConfiguration(VoiceConfiguration voiceConfiguration);

    /**
     * see getter
     *
     * @param callbackUrl see getter
     * @return Current builder
     * @see #getCallbackUrl
     */
    Builder setCallbackUrl(String callbackUrl);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ActiveNumberUpdateRequest build();
  }
}
