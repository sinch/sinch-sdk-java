package com.sinch.sdk.domains.numbers.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  VoiceConfigurationRTCImpl.JSON_PROPERTY_TYPE,
  VoiceConfigurationRTCImpl.JSON_PROPERTY_LAST_UPDATED_TIME,
  VoiceConfigurationRTCImpl.JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING,
  VoiceConfigurationRTCImpl.JSON_PROPERTY_APP_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VoiceConfigurationRTCImpl
    implements VoiceConfigurationRTC, com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<VoiceApplicationType> type;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public static final String JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING =
      "scheduledVoiceProvisioning";

  private OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning;

  public static final String JSON_PROPERTY_APP_ID = "appId";

  private OptionalValue<String> appId;

  public VoiceConfigurationRTCImpl() {}

  protected VoiceConfigurationRTCImpl(
      OptionalValue<VoiceApplicationType> type,
      OptionalValue<Instant> lastUpdatedTime,
      OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning,
      OptionalValue<String> appId) {
    this.type = type;
    this.lastUpdatedTime = lastUpdatedTime;
    this.scheduledProvisioning = scheduledProvisioning;
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
  public ScheduledVoiceProvisioning getScheduledProvisioning() {
    return scheduledProvisioning.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning() {
    return scheduledProvisioning;
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

  /** Return true if this VoiceConfigurationRTC object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoiceConfigurationRTCImpl voiceConfigurationRTC = (VoiceConfigurationRTCImpl) o;
    return Objects.equals(this.type, voiceConfigurationRTC.type)
        && Objects.equals(this.lastUpdatedTime, voiceConfigurationRTC.lastUpdatedTime)
        && Objects.equals(this.scheduledProvisioning, voiceConfigurationRTC.scheduledProvisioning)
        && Objects.equals(this.appId, voiceConfigurationRTC.appId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, lastUpdatedTime, scheduledProvisioning, appId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoiceConfigurationRTCImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
    sb.append("    scheduledProvisioning: ")
        .append(toIndentedString(scheduledProvisioning))
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
  static class Builder implements VoiceConfigurationRTC.Builder {
    OptionalValue<VoiceApplicationType> type = OptionalValue.of(VoiceApplicationType.RTC);
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();
    OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning = OptionalValue.empty();
    OptionalValue<String> appId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_TIME)
    public Builder setLastUpdatedTime(Instant lastUpdatedTime) {
      this.lastUpdatedTime = OptionalValue.of(lastUpdatedTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING)
    public Builder setScheduledProvisioning(ScheduledVoiceProvisioning scheduledProvisioning) {
      this.scheduledProvisioning = OptionalValue.of(scheduledProvisioning);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    public VoiceConfigurationRTC build() {
      return new VoiceConfigurationRTCImpl(type, lastUpdatedTime, scheduledProvisioning, appId);
    }
  }
}
