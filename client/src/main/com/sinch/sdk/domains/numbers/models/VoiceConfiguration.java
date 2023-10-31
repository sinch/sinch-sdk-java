package com.sinch.sdk.domains.numbers.models;

import java.time.Instant;
import java.util.Optional;

/**
 * The voice configuration for a number
 *
 * @since 1.0
 */
public class VoiceConfiguration {
  private final String appId;

  private final Instant lastUpdatedTime;

  private final ScheduledVoiceProvisioning scheduledVoiceProvisioning;

  /**
   * @param appId Your app ID for the Voice API. The appId can be found in your Sinch Customer
   *     Dashboard under Voice, then apps.
   * @param lastUpdatedTime when the status was last updated
   * @param scheduledVoiceProvisioning This object is temporary and will appear while the scheduled
   *     voice provisioning is processing. Once it has successfully processed, only the ID of the
   *     Voice configuration will display.
   */
  public VoiceConfiguration(
      String appId,
      Instant lastUpdatedTime,
      ScheduledVoiceProvisioning scheduledVoiceProvisioning) {
    this.appId = appId;
    this.lastUpdatedTime = lastUpdatedTime;
    this.scheduledVoiceProvisioning = scheduledVoiceProvisioning;
  }

  public String getAppId() {
    return appId;
  }

  public Optional<Instant> getLastUpdatedTime() {
    return Optional.ofNullable(lastUpdatedTime);
  }

  public Optional<ScheduledVoiceProvisioning> getScheduledVoiceProvisioning() {
    return Optional.ofNullable(scheduledVoiceProvisioning);
  }

  @Override
  public String toString() {
    return "VoiceConfiguration{"
        + "appId='"
        + appId
        + '\''
        + ", lastUpdatedTime="
        + lastUpdatedTime
        + ", scheduledVoiceProvisioning="
        + scheduledVoiceProvisioning
        + '}';
  }
}
