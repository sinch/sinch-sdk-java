package com.sinch.sdk.domains.numbers.models.requests;

import java.util.Optional;

/**
 * SMS configuration parameters request to rent a number
 *
 * @since 1.0
 */
public class RentSMSConfigurationRequestParameters {
  private final String servicePlanId;
  private final String campaignId;

  /**
   * @param servicePlanId The servicePlanId can be found in the Sinch Customer Dashboard. The
   *     service plan ID is what ties this number to the configured SMS service.
   * @param campaignId Only for US phone numbers. This campaignId is required to send SMS traffic to
   *     US; click here to read more about 10DLC A2P messaging. So, it is the current campaign ID
   *     for this number. The campaignId is found on your TCR platform.
   */
  public RentSMSConfigurationRequestParameters(String servicePlanId, String campaignId) {
    this.servicePlanId = servicePlanId;
    this.campaignId = campaignId;
  }

  public RentSMSConfigurationRequestParameters(String servicePlanId) {
    this(servicePlanId, null);
  }

  public String getServicePlanId() {
    return servicePlanId;
  }

  public Optional<String> getCampaignId() {
    return Optional.ofNullable(this.campaignId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String servicePlanId;
    String campaignId;

    private Builder() {}

    public Builder setServicePlanId(String servicePlanId) {
      this.servicePlanId = servicePlanId;
      return this;
    }

    public Builder setCampaignId(String campaignId) {
      this.campaignId = campaignId;
      return this;
    }

    public RentSMSConfigurationRequestParameters build() {
      return new RentSMSConfigurationRequestParameters(servicePlanId, campaignId);
    }
  }
}
