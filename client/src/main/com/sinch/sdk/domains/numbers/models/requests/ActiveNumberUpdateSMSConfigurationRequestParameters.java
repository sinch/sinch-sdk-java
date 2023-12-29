package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/***
 * SMS configuration parameters request to update an active number for a project
 * @since 1.0
 */
public class ActiveNumberUpdateSMSConfigurationRequestParameters {

  private final OptionalValue<String> servicePlanId;
  private final OptionalValue<String> campaignId;

  private ActiveNumberUpdateSMSConfigurationRequestParameters(
      OptionalValue<String> servicePlanId, OptionalValue<String> campaignId) {
    this.servicePlanId = servicePlanId;
    this.campaignId = campaignId;
  }

  public OptionalValue<String> getServicePlanId() {
    return servicePlanId;
  }

  public OptionalValue<String> getCampaignId() {
    return campaignId;
  }

  @Override
  public String toString() {
    return "ActiveNumberUpdateSMSConfigurationRequestParameters{"
        + "servicePlanId='"
        + servicePlanId
        + '\''
        + ", campaignId="
        + campaignId
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    OptionalValue<String> servicePlanId = OptionalValue.empty();

    OptionalValue<String> campaignId = OptionalValue.empty();

    private Builder() {}

    /**
     * @param servicePlanId The servicePlanId can be found in the Sinch Customer Dashboard. The
     *     service plan ID is what ties this number to the configured SMS service.
     * @return current builder
     */
    public Builder setServicePlanId(String servicePlanId) {
      this.servicePlanId = OptionalValue.of(servicePlanId);
      return this;
    }

    /**
     * @param campaignId Only for US phone numbers. This campaignId is required to send SMS traffic
     *     to US; click here to read more about 10DLC A2P messaging. So, it is the current campaign
     *     ID for this number. The campaignId is found on your TCR platform.
     * @return current builder
     */
    public Builder setCampaignId(String campaignId) {
      this.campaignId = OptionalValue.of(campaignId);
      return this;
    }

    public ActiveNumberUpdateSMSConfigurationRequestParameters build() {
      return new ActiveNumberUpdateSMSConfigurationRequestParameters(servicePlanId, campaignId);
    }
  }
}
