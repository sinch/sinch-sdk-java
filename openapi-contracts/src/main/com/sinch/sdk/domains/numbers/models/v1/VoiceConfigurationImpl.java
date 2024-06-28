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
  VoiceConfigurationImpl.JSON_PROPERTY_APP_ID,
  VoiceConfigurationImpl.JSON_PROPERTY_TRUNK_ID,
  VoiceConfigurationImpl.JSON_PROPERTY_SERVICE_ID,
  VoiceConfigurationImpl.JSON_PROPERTY_TYPE,
  VoiceConfigurationImpl.JSON_PROPERTY_LAST_UPDATED_TIME,
  VoiceConfigurationImpl.JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VoiceConfigurationImpl implements VoiceConfiguration {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "appId";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_TRUNK_ID = "trunkId";

  private OptionalValue<String> trunkId;

  public static final String JSON_PROPERTY_SERVICE_ID = "serviceId";

  private OptionalValue<String> serviceId;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<VoiceApplicationType> type;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public static final String JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING =
      "scheduledVoiceProvisioning";

  private OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning;

  public VoiceConfigurationImpl() {}

  protected VoiceConfigurationImpl(
      OptionalValue<String> appId,
      OptionalValue<String> trunkId,
      OptionalValue<String> serviceId,
      OptionalValue<VoiceApplicationType> type,
      OptionalValue<Instant> lastUpdatedTime,
      OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning) {
    this.appId = appId;
    this.trunkId = trunkId;
    this.serviceId = serviceId;
    this.type = type;
    this.lastUpdatedTime = lastUpdatedTime;
    this.scheduledProvisioning = scheduledProvisioning;
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

  @JsonIgnore
  public String getTrunkId() {
    return trunkId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRUNK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> trunkId() {
    return trunkId;
  }

  @JsonIgnore
  public String getServiceId() {
    return serviceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SERVICE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> serviceId() {
    return serviceId;
  }

  @JsonIgnore
  public VoiceApplicationType getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
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

  /** Return true if this VoiceConfiguration object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoiceConfigurationImpl voiceConfiguration = (VoiceConfigurationImpl) o;
    return Objects.equals(this.appId, voiceConfiguration.appId)
        && Objects.equals(this.trunkId, voiceConfiguration.trunkId)
        && Objects.equals(this.serviceId, voiceConfiguration.serviceId)
        && Objects.equals(this.type, voiceConfiguration.type)
        && Objects.equals(this.lastUpdatedTime, voiceConfiguration.lastUpdatedTime)
        && Objects.equals(this.scheduledProvisioning, voiceConfiguration.scheduledProvisioning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, trunkId, serviceId, type, lastUpdatedTime, scheduledProvisioning);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoiceConfigurationImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    trunkId: ").append(toIndentedString(trunkId)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
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
  static class Builder implements VoiceConfiguration.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<String> trunkId = OptionalValue.empty();
    OptionalValue<String> serviceId = OptionalValue.empty();
    OptionalValue<VoiceApplicationType> type = OptionalValue.empty();
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();
    OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TRUNK_ID)
    public Builder setTrunkId(String trunkId) {
      this.trunkId = OptionalValue.of(trunkId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SERVICE_ID)
    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
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
    public Builder setScheduledProvisioning(ScheduledVoiceProvisioning scheduledProvisioning) {
      this.scheduledProvisioning = OptionalValue.of(scheduledProvisioning);
      return this;
    }

    public VoiceConfiguration build() {
      return new VoiceConfigurationImpl(
          appId, trunkId, serviceId, type, lastUpdatedTime, scheduledProvisioning);
    }
  }
}
