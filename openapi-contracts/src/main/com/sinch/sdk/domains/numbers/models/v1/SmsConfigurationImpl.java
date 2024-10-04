package com.sinch.sdk.domains.numbers.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  SmsConfigurationImpl.JSON_PROPERTY_SERVICE_PLAN_ID,
  SmsConfigurationImpl.JSON_PROPERTY_CAMPAIGN_ID,
  SmsConfigurationImpl.JSON_PROPERTY_SCHEDULED_PROVISIONING
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SmsConfigurationImpl implements SmsConfiguration {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SERVICE_PLAN_ID = "servicePlanId";

  private OptionalValue<String> servicePlanId;

  public static final String JSON_PROPERTY_CAMPAIGN_ID = "campaignId";

  private OptionalValue<String> campaignId;

  public static final String JSON_PROPERTY_SCHEDULED_PROVISIONING = "scheduledProvisioning";

  private OptionalValue<ScheduledSmsProvisioning> scheduledProvisioning;

  public SmsConfigurationImpl() {}

  protected SmsConfigurationImpl(
      OptionalValue<String> servicePlanId,
      OptionalValue<String> campaignId,
      OptionalValue<ScheduledSmsProvisioning> scheduledProvisioning) {
    this.servicePlanId = servicePlanId;
    this.campaignId = campaignId;
    this.scheduledProvisioning = scheduledProvisioning;
  }

  @JsonIgnore
  public String getServicePlanId() {
    return servicePlanId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICE_PLAN_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> servicePlanId() {
    return servicePlanId;
  }

  @JsonIgnore
  public String getCampaignId() {
    return campaignId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CAMPAIGN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> campaignId() {
    return campaignId;
  }

  @JsonIgnore
  public ScheduledSmsProvisioning getScheduledProvisioning() {
    return scheduledProvisioning.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<ScheduledSmsProvisioning> scheduledProvisioning() {
    return scheduledProvisioning;
  }

  /** Return true if this SMSConfiguration object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmsConfigurationImpl smSConfiguration = (SmsConfigurationImpl) o;
    return Objects.equals(this.servicePlanId, smSConfiguration.servicePlanId)
        && Objects.equals(this.campaignId, smSConfiguration.campaignId)
        && Objects.equals(this.scheduledProvisioning, smSConfiguration.scheduledProvisioning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(servicePlanId, campaignId, scheduledProvisioning);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmsConfigurationImpl {\n");
    sb.append("    servicePlanId: ").append(toIndentedString(servicePlanId)).append("\n");
    sb.append("    campaignId: ").append(toIndentedString(campaignId)).append("\n");
    sb.append("    scheduledProvisioning: ")
        .append(toIndentedString(scheduledProvisioning))
        .append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements SmsConfiguration.Builder {
    OptionalValue<String> servicePlanId = OptionalValue.empty();
    OptionalValue<String> campaignId = OptionalValue.empty();
    OptionalValue<ScheduledSmsProvisioning> scheduledProvisioning = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SERVICE_PLAN_ID)
    public Builder setServicePlanId(String servicePlanId) {
      this.servicePlanId = OptionalValue.of(servicePlanId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CAMPAIGN_ID)
    public Builder setCampaignId(String campaignId) {
      this.campaignId = OptionalValue.of(campaignId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCHEDULED_PROVISIONING)
    public Builder setScheduledProvisioning(ScheduledSmsProvisioning scheduledProvisioning) {
      this.scheduledProvisioning = OptionalValue.of(scheduledProvisioning);
      return this;
    }

    public SmsConfiguration build() {
      return new SmsConfigurationImpl(servicePlanId, campaignId, scheduledProvisioning);
    }
  }
}
