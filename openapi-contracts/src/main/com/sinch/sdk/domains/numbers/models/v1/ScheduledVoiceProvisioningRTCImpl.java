package com.sinch.sdk.domains.numbers.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.internal.VoiceApplicationType;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  ScheduledVoiceProvisioningRTCImpl.JSON_PROPERTY_TYPE,
  ScheduledVoiceProvisioningRTCImpl.JSON_PROPERTY_LAST_UPDATED_TIME,
  ScheduledVoiceProvisioningRTCImpl.JSON_PROPERTY_STATUS,
  ScheduledVoiceProvisioningRTCImpl.JSON_PROPERTY_APP_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ScheduledVoiceProvisioningRTCImpl
    implements ScheduledVoiceProvisioningRTC,
        com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<VoiceApplicationType> type;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<ProvisioningStatus> status;

  public static final String JSON_PROPERTY_APP_ID = "appId";

  private OptionalValue<String> appId;

  public ScheduledVoiceProvisioningRTCImpl() {}

  protected ScheduledVoiceProvisioningRTCImpl(
      OptionalValue<VoiceApplicationType> type,
      OptionalValue<Instant> lastUpdatedTime,
      OptionalValue<ProvisioningStatus> status,
      OptionalValue<String> appId) {
    this.type = type;
    this.lastUpdatedTime = lastUpdatedTime;
    this.status = status;
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

  @JsonProperty(JSON_PROPERTY_LAST_UPDATED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> lastUpdatedTime() {
    return lastUpdatedTime;
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
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> appId() {
    return appId;
  }

  /** Return true if this ScheduledVoiceProvisioningRTC object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduledVoiceProvisioningRTCImpl scheduledVoiceProvisioningRTC =
        (ScheduledVoiceProvisioningRTCImpl) o;
    return Objects.equals(this.type, scheduledVoiceProvisioningRTC.type)
        && Objects.equals(this.lastUpdatedTime, scheduledVoiceProvisioningRTC.lastUpdatedTime)
        && Objects.equals(this.status, scheduledVoiceProvisioningRTC.status)
        && Objects.equals(this.appId, scheduledVoiceProvisioningRTC.appId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, lastUpdatedTime, status, appId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduledVoiceProvisioningRTCImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
  static class Builder implements ScheduledVoiceProvisioningRTC.Builder {
    OptionalValue<VoiceApplicationType> type = OptionalValue.of(VoiceApplicationType.RTC);
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();
    OptionalValue<ProvisioningStatus> status = OptionalValue.empty();
    OptionalValue<String> appId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_TIME)
    public Builder setLastUpdatedTime(Instant lastUpdatedTime) {
      this.lastUpdatedTime = OptionalValue.of(lastUpdatedTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(ProvisioningStatus status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    public ScheduledVoiceProvisioningRTC build() {
      return new ScheduledVoiceProvisioningRTCImpl(type, lastUpdatedTime, status, appId);
    }
  }
}
