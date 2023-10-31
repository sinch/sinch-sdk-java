package com.sinch.sdk.domains.numbers.models;

import java.time.Instant;
import java.util.Collection;

/**
 * Scheduled SMS provisioning information
 *
 * <p>This object is temporary and will appear while the scheduled provisioning for SMS is
 * processing. Once it has successfully processed, only the ID of the SMS configuration will
 * display.
 */
public class ScheduledSmsProvisioning {
  private final String servicePlanId;

  private final String campaignId;

  private final ProvisioningStatus status;

  private final Instant lastUpdatedTime;

  private final Collection<SmsErrorCode> errorCodes;

  /**
   * @param servicePlanId Service plan of the scheduled provisioning task.
   * @param campaignId Campaign ID of the scheduled provisioning task. Note that the campaign ID is
   *     only for US numbers as it relates to 10DLC.
   * @param status The provisioning status
   * @param lastUpdatedTime when the status was last updated
   * @param errorCodes The provisioning error codes
   */
  public ScheduledSmsProvisioning(
      String servicePlanId,
      String campaignId,
      ProvisioningStatus status,
      Instant lastUpdatedTime,
      Collection<SmsErrorCode> errorCodes) {
    this.servicePlanId = servicePlanId;
    this.campaignId = campaignId;
    this.status = status;
    this.lastUpdatedTime = lastUpdatedTime;
    this.errorCodes = errorCodes;
  }

  public String getServicePlanId() {
    return servicePlanId;
  }

  public String getCampaignId() {
    return campaignId;
  }

  public ProvisioningStatus getStatus() {
    return status;
  }

  public Instant getLastUpdatedTime() {
    return lastUpdatedTime;
  }

  public Collection<SmsErrorCode> getErrorCodes() {
    return errorCodes;
  }

  @Override
  public String toString() {
    return "ScheduledSmsProvisioning{"
        + "servicePlanId='"
        + servicePlanId
        + '\''
        + ", campaignId='"
        + campaignId
        + '\''
        + ", status="
        + status
        + ", lastUpdatedTime="
        + lastUpdatedTime
        + ", errorCodes="
        + errorCodes
        + '}';
  }
}
