package com.sinch.sdk.domains.numbers.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ScheduledSmsProvisioningImpl.JSON_PROPERTY_SERVICE_PLAN_ID,
  ScheduledSmsProvisioningImpl.JSON_PROPERTY_CAMPAIGN_ID,
  ScheduledSmsProvisioningImpl.JSON_PROPERTY_STATUS,
  ScheduledSmsProvisioningImpl.JSON_PROPERTY_LAST_UPDATED_TIME,
  ScheduledSmsProvisioningImpl.JSON_PROPERTY_ERROR_CODES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ScheduledSmsProvisioningImpl implements ScheduledSmsProvisioning {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SERVICE_PLAN_ID = "servicePlanId";

  private OptionalValue<String> servicePlanId;

  public static final String JSON_PROPERTY_CAMPAIGN_ID = "campaignId";

  private OptionalValue<String> campaignId;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<ProvisioningStatus> status;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public static final String JSON_PROPERTY_ERROR_CODES = "errorCodes";

  private OptionalValue<List<SmsErrorCode>> errorCodes;

  public ScheduledSmsProvisioningImpl() {}

  protected ScheduledSmsProvisioningImpl(
      OptionalValue<String> servicePlanId,
      OptionalValue<String> campaignId,
      OptionalValue<ProvisioningStatus> status,
      OptionalValue<Instant> lastUpdatedTime,
      OptionalValue<List<SmsErrorCode>> errorCodes) {
    this.servicePlanId = servicePlanId;
    this.campaignId = campaignId;
    this.status = status;
    this.lastUpdatedTime = lastUpdatedTime;
    this.errorCodes = errorCodes;
  }

  @JsonIgnore
  public String getServicePlanId() {
    return servicePlanId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICE_PLAN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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
  public ProvisioningStatus getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProvisioningStatus> status() {
    return status;
  }

  @JsonIgnore
  public Instant getLastUpdatedTime() {
    return lastUpdatedTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_LAST_UPDATED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> lastUpdatedTime() {
    return lastUpdatedTime;
  }

  @JsonIgnore
  public List<SmsErrorCode> getErrorCodes() {
    return errorCodes.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ERROR_CODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SmsErrorCode>> errorCodes() {
    return errorCodes;
  }

  /** Return true if this ScheduledProvisioning object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduledSmsProvisioningImpl scheduledProvisioning = (ScheduledSmsProvisioningImpl) o;
    return Objects.equals(this.servicePlanId, scheduledProvisioning.servicePlanId)
        && Objects.equals(this.campaignId, scheduledProvisioning.campaignId)
        && Objects.equals(this.status, scheduledProvisioning.status)
        && Objects.equals(this.lastUpdatedTime, scheduledProvisioning.lastUpdatedTime)
        && Objects.equals(this.errorCodes, scheduledProvisioning.errorCodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(servicePlanId, campaignId, status, lastUpdatedTime, errorCodes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduledSmsProvisioningImpl {\n");
    sb.append("    servicePlanId: ").append(toIndentedString(servicePlanId)).append("\n");
    sb.append("    campaignId: ").append(toIndentedString(campaignId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
    sb.append("    errorCodes: ").append(toIndentedString(errorCodes)).append("\n");
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
  static class Builder implements ScheduledSmsProvisioning.Builder {
    OptionalValue<String> servicePlanId = OptionalValue.empty();
    OptionalValue<String> campaignId = OptionalValue.empty();
    OptionalValue<ProvisioningStatus> status = OptionalValue.empty();
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();
    OptionalValue<List<SmsErrorCode>> errorCodes = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(ProvisioningStatus status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_TIME)
    public Builder setLastUpdatedTime(Instant lastUpdatedTime) {
      this.lastUpdatedTime = OptionalValue.of(lastUpdatedTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_CODES)
    public Builder setErrorCodes(List<SmsErrorCode> errorCodes) {
      this.errorCodes = OptionalValue.of(errorCodes);
      return this;
    }

    public ScheduledSmsProvisioning build() {
      return new ScheduledSmsProvisioningImpl(
          servicePlanId, campaignId, status, lastUpdatedTime, errorCodes);
    }
  }
}
