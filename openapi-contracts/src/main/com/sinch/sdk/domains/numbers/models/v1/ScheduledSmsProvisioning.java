/*
 * Numbers | Sinch
 *
 * OpenAPI document version: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;
import java.util.List;

/**
 * Represents the ongoing or failed scheduled provisioning job. This field will be empty if both the
 * was successfully provisioned into the SMS platform and linked to the 10DLC campaign.
 */
@JsonDeserialize(builder = ScheduledSmsProvisioningImpl.Builder.class)
public interface ScheduledSmsProvisioning {

  /**
   * The SMS service plan that the scheduled provisioning job will configured with the number.
   *
   * @return servicePlanId
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  String getServicePlanId();

  /**
   * TCR campaign ID that the scheduled provisioning job will configure with the number.
   *
   * @return campaignId
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  String getCampaignId();

  /**
   * Get status
   *
   * @return status
   */
  ProvisioningStatus getStatus();

  /**
   * Timestamp when the status was last updated.
   *
   * @return lastUpdatedTime
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Instant getLastUpdatedTime();

  /**
   * Get errorCodes
   *
   * @return errorCodes
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  List<SmsErrorCode> getErrorCodes();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ScheduledSmsProvisioningImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param servicePlanId see getter
     * @return Current builder
     * @see #getServicePlanId
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setServicePlanId(String servicePlanId);

    /**
     * see getter
     *
     * @param campaignId see getter
     * @return Current builder
     * @see #getCampaignId
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setCampaignId(String campaignId);

    /**
     * see getter
     *
     * @param status see getter
     * @return Current builder
     * @see #getStatus
     */
    Builder setStatus(ProvisioningStatus status);

    /**
     * see getter
     *
     * @param lastUpdatedTime see getter
     * @return Current builder
     * @see #getLastUpdatedTime
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setLastUpdatedTime(Instant lastUpdatedTime);

    /**
     * see getter
     *
     * @param errorCodes see getter
     * @return Current builder
     * @see #getErrorCodes
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
     */
    Builder setErrorCodes(List<SmsErrorCode> errorCodes);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ScheduledSmsProvisioning build();
  }
}
