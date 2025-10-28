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
  VoiceConfigurationFAXImpl.JSON_PROPERTY_TYPE,
  VoiceConfigurationFAXImpl.JSON_PROPERTY_LAST_UPDATED_TIME,
  VoiceConfigurationFAXImpl.JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING,
  VoiceConfigurationFAXImpl.JSON_PROPERTY_SERVICE_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VoiceConfigurationFAXImpl
    implements VoiceConfigurationFAX, com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<VoiceApplicationType> type;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public static final String JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING =
      "scheduledVoiceProvisioning";

  private OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning;

  public static final String JSON_PROPERTY_SERVICE_ID = "serviceId";

  private OptionalValue<String> serviceId;

  public VoiceConfigurationFAXImpl() {}

  protected VoiceConfigurationFAXImpl(
      OptionalValue<VoiceApplicationType> type,
      OptionalValue<Instant> lastUpdatedTime,
      OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning,
      OptionalValue<String> serviceId) {
    this.type = type;
    this.lastUpdatedTime = lastUpdatedTime;
    this.scheduledProvisioning = scheduledProvisioning;
    this.serviceId = serviceId;
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
  public ScheduledVoiceProvisioning getScheduledProvisioning() {
    return scheduledProvisioning.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning() {
    return scheduledProvisioning;
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

  /** Return true if this VoiceConfigurationFAX object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoiceConfigurationFAXImpl voiceConfigurationFAX = (VoiceConfigurationFAXImpl) o;
    return Objects.equals(this.type, voiceConfigurationFAX.type)
        && Objects.equals(this.lastUpdatedTime, voiceConfigurationFAX.lastUpdatedTime)
        && Objects.equals(this.scheduledProvisioning, voiceConfigurationFAX.scheduledProvisioning)
        && Objects.equals(this.serviceId, voiceConfigurationFAX.serviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, lastUpdatedTime, scheduledProvisioning, serviceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoiceConfigurationFAXImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
    sb.append("    scheduledProvisioning: ")
        .append(toIndentedString(scheduledProvisioning))
        .append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
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
  static class Builder implements VoiceConfigurationFAX.Builder {
    OptionalValue<VoiceApplicationType> type = OptionalValue.of(VoiceApplicationType.FAX);
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();
    OptionalValue<ScheduledVoiceProvisioning> scheduledProvisioning = OptionalValue.empty();
    OptionalValue<String> serviceId = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    Builder setType(VoiceApplicationType type) {
      if (!Objects.equals(type, VoiceApplicationType.FAX)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", VoiceApplicationType.FAX, type));
      }
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

    @JsonProperty(JSON_PROPERTY_SERVICE_ID)
    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    public VoiceConfigurationFAX build() {
      return new VoiceConfigurationFAXImpl(type, lastUpdatedTime, scheduledProvisioning, serviceId);
    }
  }
}
