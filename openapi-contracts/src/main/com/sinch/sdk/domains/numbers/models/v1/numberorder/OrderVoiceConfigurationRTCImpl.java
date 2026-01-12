package com.sinch.sdk.domains.numbers.models.v1.numberorder;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.internal.ScheduledVoiceProvisioningInternal;
import com.sinch.sdk.domains.numbers.models.v1.internal.VoiceApplicationType;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  OrderVoiceConfigurationRTCImpl.JSON_PROPERTY_TYPE,
  OrderVoiceConfigurationRTCImpl.JSON_PROPERTY_LAST_UPDATED_TIME,
  OrderVoiceConfigurationRTCImpl.JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING,
  OrderVoiceConfigurationRTCImpl.JSON_PROPERTY_APP_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderVoiceConfigurationRTCImpl implements OrderVoiceConfigurationRTC {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<VoiceApplicationType> type;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public static final String JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING =
      "scheduledVoiceProvisioning";

  private OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning;

  public static final String JSON_PROPERTY_APP_ID = "appId";

  private OptionalValue<String> appId;

  public OrderVoiceConfigurationRTCImpl() {}

  protected OrderVoiceConfigurationRTCImpl(
      OptionalValue<VoiceApplicationType> type,
      OptionalValue<Instant> lastUpdatedTime,
      OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning,
      OptionalValue<String> appId) {
    this.type = type;
    this.lastUpdatedTime = lastUpdatedTime;
    this.scheduledVoiceProvisioning = scheduledVoiceProvisioning;
    this.appId = appId;
  }

  @JsonIgnore
  public VoiceApplicationType getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VoiceApplicationType> type() {
    return type;
  }

  @JsonIgnore
  public Instant getLastUpdatedTime() {
    return lastUpdatedTime.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<Instant> lastUpdatedTime() {
    return lastUpdatedTime;
  }

  @JsonIgnore
  public ScheduledVoiceProvisioningInternal getScheduledVoiceProvisioning() {
    return scheduledVoiceProvisioning.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning() {
    return scheduledVoiceProvisioning;
  }

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> appId() {
    return appId;
  }

  /** Return true if this OrderVoiceConfigurationRTC object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderVoiceConfigurationRTCImpl orderVoiceConfigurationRTC = (OrderVoiceConfigurationRTCImpl) o;
    return Objects.equals(this.type, orderVoiceConfigurationRTC.type)
        && Objects.equals(this.lastUpdatedTime, orderVoiceConfigurationRTC.lastUpdatedTime)
        && Objects.equals(
            this.scheduledVoiceProvisioning, orderVoiceConfigurationRTC.scheduledVoiceProvisioning)
        && Objects.equals(this.appId, orderVoiceConfigurationRTC.appId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, lastUpdatedTime, scheduledVoiceProvisioning, appId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderVoiceConfigurationRTCImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
    sb.append("    scheduledVoiceProvisioning: ")
        .append(toIndentedString(scheduledVoiceProvisioning))
        .append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
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
  static class Builder implements OrderVoiceConfigurationRTC.Builder {
    OptionalValue<VoiceApplicationType> type = OptionalValue.empty();
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();
    OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning =
        OptionalValue.empty();
    OptionalValue<String> appId = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    public Builder setType(VoiceApplicationType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_TIME)
    public Builder setLastUpdatedTime(Instant lastUpdatedTime) {
      this.lastUpdatedTime = OptionalValue.of(lastUpdatedTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING)
    public Builder setScheduledVoiceProvisioning(
        ScheduledVoiceProvisioningInternal scheduledVoiceProvisioning) {
      this.scheduledVoiceProvisioning = OptionalValue.of(scheduledVoiceProvisioning);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    public OrderVoiceConfigurationRTC build() {
      return new OrderVoiceConfigurationRTCImpl(
          type, lastUpdatedTime, scheduledVoiceProvisioning, appId);
    }
  }
}
