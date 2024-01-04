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

package com.sinch.sdk.domains.numbers.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Represents the ongoing or failed scheduled provisioning job. This field will be empty if both the
 * was successfully provisioned into the SMS platform and linked to the 10DLC campaign.
 */
@JsonPropertyOrder({
  ScheduledProvisioningDto.JSON_PROPERTY_SERVICE_PLAN_ID,
  ScheduledProvisioningDto.JSON_PROPERTY_CAMPAIGN_ID,
  ScheduledProvisioningDto.JSON_PROPERTY_STATUS,
  ScheduledProvisioningDto.JSON_PROPERTY_LAST_UPDATED_TIME,
  ScheduledProvisioningDto.JSON_PROPERTY_ERROR_CODES
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ScheduledProvisioningDto {
  public static final String JSON_PROPERTY_SERVICE_PLAN_ID = "servicePlanId";
  private String servicePlanId;
  private boolean servicePlanIdDefined = false;

  public static final String JSON_PROPERTY_CAMPAIGN_ID = "campaignId";
  private String campaignId;
  private boolean campaignIdDefined = false;

  public static final String JSON_PROPERTY_STATUS = "status";
  private ProvisioningStatusDto status;
  private boolean statusDefined = false;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";
  private OffsetDateTime lastUpdatedTime;
  private boolean lastUpdatedTimeDefined = false;

  public static final String JSON_PROPERTY_ERROR_CODES = "errorCodes";
  private List<SmsErrorCodeDto> errorCodes;
  private boolean errorCodesDefined = false;

  public ScheduledProvisioningDto() {}

  @JsonCreator
  public ScheduledProvisioningDto(
      @JsonProperty(JSON_PROPERTY_SERVICE_PLAN_ID) String servicePlanId,
      @JsonProperty(JSON_PROPERTY_CAMPAIGN_ID) String campaignId,
      @JsonProperty(JSON_PROPERTY_LAST_UPDATED_TIME) OffsetDateTime lastUpdatedTime,
      @JsonProperty(JSON_PROPERTY_ERROR_CODES) List<SmsErrorCodeDto> errorCodes) {
    this();
    this.servicePlanId = servicePlanId;
    this.servicePlanIdDefined = true;
    this.campaignId = campaignId;
    this.campaignIdDefined = true;
    this.lastUpdatedTime = lastUpdatedTime;
    this.lastUpdatedTimeDefined = true;
    this.errorCodes = errorCodes;
    this.errorCodesDefined = true;
  }

  /**
   * The SMS service plan that the scheduled provisioning job will configured with the number.
   *
   * @return servicePlanId
   */
  @JsonProperty(JSON_PROPERTY_SERVICE_PLAN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getServicePlanId() {
    return servicePlanId;
  }

  @JsonIgnore
  public boolean getServicePlanIdDefined() {
    return servicePlanIdDefined;
  }

  /**
   * TCR campaign ID that the scheduled provisioning job will configure with the number.
   *
   * @return campaignId
   */
  @JsonProperty(JSON_PROPERTY_CAMPAIGN_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCampaignId() {
    return campaignId;
  }

  @JsonIgnore
  public boolean getCampaignIdDefined() {
    return campaignIdDefined;
  }

  public ScheduledProvisioningDto status(ProvisioningStatusDto status) {
    this.status = status;
    this.statusDefined = true;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ProvisioningStatusDto getStatus() {
    return status;
  }

  @JsonIgnore
  public boolean getStatusDefined() {
    return statusDefined;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(ProvisioningStatusDto status) {
    this.status = status;
    this.statusDefined = true;
  }

  /**
   * Timestamp when the status was last updated.
   *
   * @return lastUpdatedTime
   */
  @JsonProperty(JSON_PROPERTY_LAST_UPDATED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getLastUpdatedTime() {
    return lastUpdatedTime;
  }

  @JsonIgnore
  public boolean getLastUpdatedTimeDefined() {
    return lastUpdatedTimeDefined;
  }

  /**
   * Get errorCodes
   *
   * @return errorCodes
   */
  @JsonProperty(JSON_PROPERTY_ERROR_CODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<SmsErrorCodeDto> getErrorCodes() {
    return errorCodes;
  }

  @JsonIgnore
  public boolean getErrorCodesDefined() {
    return errorCodesDefined;
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
    ScheduledProvisioningDto scheduledProvisioning = (ScheduledProvisioningDto) o;
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
    sb.append("class ScheduledProvisioningDto {\n");
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
}
