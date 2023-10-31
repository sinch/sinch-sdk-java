package com.sinch.sdk.domains.numbers.models;

import java.time.Instant;

/**
 * Scheduled Voice provisioning information
 *
 * <p>This object is temporary and will appear while the scheduled voice provisioning is processing.
 * Once it has successfully processed, only the ID of the Voice configuration will display.
 */
public class ScheduledVoiceProvisioning {

  private final String appId;

  private final ProvisioningStatus status;

  private final Instant lastUpdatedTime;

  /**
   * @param appId RTC application ID of the scheduled provisioning task.
   * @param status The provisioning status
   * @param lastUpdatedTime when the status was last updated
   */
  public ScheduledVoiceProvisioning(
      String appId, ProvisioningStatus status, Instant lastUpdatedTime) {
    this.appId = appId;
    this.status = status;
    this.lastUpdatedTime = lastUpdatedTime;
  }

  public String getAppId() {
    return appId;
  }

  public ProvisioningStatus getStatus() {
    return status;
  }

  public Instant getLastUpdatedTime() {
    return lastUpdatedTime;
  }

  @Override
  public String toString() {
    return "ScheduledVoiceProvisioning{"
        + "appId='"
        + appId
        + '\''
        + ", status="
        + status
        + ", lastUpdatedTime="
        + lastUpdatedTime
        + '}';
  }
}
