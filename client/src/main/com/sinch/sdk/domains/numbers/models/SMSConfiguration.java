package com.sinch.sdk.domains.numbers.models;

import java.util.Optional;

/** The SMS configuration for a number */
public class SMSConfiguration {
  private final String servicePlanId;

  private final String campaignId;

  private final ScheduledSmsProvisioning scheduledSmsProvisioning;

  /**
   * @param servicePlanId The servicePlanId can be found in the Sinch Customer Dashboard. The
   *     service plan ID is what ties this to the configured SMS service.
   * @param campaignId Only for US phone numbers. This campaignId is required to send SMS traffic to
   *     US; click here to read more about 10DLC A2P messaging. So, it is the current campaign ID
   *     for this number. The campaignId is found on your TCR platform.
   * @param scheduledSmsProvisioning This object is temporary and will appear while the scheduled
   *     provisioning for SMS is processing. Once it has successfully processed, only the ID of the
   *     SMS configuration will display.
   */
  public SMSConfiguration(
      String servicePlanId, String campaignId, ScheduledSmsProvisioning scheduledSmsProvisioning) {
    this.servicePlanId = servicePlanId;
    this.campaignId = campaignId;
    this.scheduledSmsProvisioning = scheduledSmsProvisioning;
  }

  public String getServicePlanId() {
    return servicePlanId;
  }

  public Optional<String> getCampaignId() {
    return Optional.ofNullable(campaignId);
  }

  public Optional<ScheduledSmsProvisioning> getScheduledSmsProvisioning() {
    return Optional.ofNullable(scheduledSmsProvisioning);
  }

  @Override
  public String toString() {
    return "SMSConfiguration{"
        + "servicePlanId='"
        + servicePlanId
        + '\''
        + ", campaignId='"
        + campaignId
        + '\''
        + ", scheduledSmsProvisioning="
        + scheduledSmsProvisioning
        + '}';
  }
}
