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
  OrderVoiceConfigurationFAXImpl.JSON_PROPERTY_TYPE,
  OrderVoiceConfigurationFAXImpl.JSON_PROPERTY_LAST_UPDATED_TIME,
  OrderVoiceConfigurationFAXImpl.JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING,
  OrderVoiceConfigurationFAXImpl.JSON_PROPERTY_SERVICE_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderVoiceConfigurationFAXImpl implements OrderVoiceConfigurationFAX {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<VoiceApplicationType> type;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public static final String JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING =
      "scheduledVoiceProvisioning";

  private OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning;

  public static final String JSON_PROPERTY_SERVICE_ID = "serviceId";

  private OptionalValue<String> serviceId;

  public OrderVoiceConfigurationFAXImpl() {}

  protected OrderVoiceConfigurationFAXImpl(
      OptionalValue<VoiceApplicationType> type,
      OptionalValue<Instant> lastUpdatedTime,
      OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning,
      OptionalValue<String> serviceId) {
    this.type = type;
    this.lastUpdatedTime = lastUpdatedTime;
    this.scheduledVoiceProvisioning = scheduledVoiceProvisioning;
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
  public ScheduledVoiceProvisioningInternal getScheduledVoiceProvisioning() {
    return scheduledVoiceProvisioning.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning() {
    return scheduledVoiceProvisioning;
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

  /** Return true if this OrderVoiceConfigurationFAX object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderVoiceConfigurationFAXImpl orderVoiceConfigurationFAX = (OrderVoiceConfigurationFAXImpl) o;
    return Objects.equals(this.type, orderVoiceConfigurationFAX.type)
        && Objects.equals(this.lastUpdatedTime, orderVoiceConfigurationFAX.lastUpdatedTime)
        && Objects.equals(
            this.scheduledVoiceProvisioning, orderVoiceConfigurationFAX.scheduledVoiceProvisioning)
        && Objects.equals(this.serviceId, orderVoiceConfigurationFAX.serviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, lastUpdatedTime, scheduledVoiceProvisioning, serviceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderVoiceConfigurationFAXImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
    sb.append("    scheduledVoiceProvisioning: ")
        .append(toIndentedString(scheduledVoiceProvisioning))
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
  static class Builder implements OrderVoiceConfigurationFAX.Builder {
    OptionalValue<VoiceApplicationType> type = OptionalValue.empty();
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();
    OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning =
        OptionalValue.empty();
    OptionalValue<String> serviceId = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_SERVICE_ID)
    public Builder setServiceId(String serviceId) {
      this.serviceId = OptionalValue.of(serviceId);
      return this;
    }

    public OrderVoiceConfigurationFAX build() {
      return new OrderVoiceConfigurationFAXImpl(
          type, lastUpdatedTime, scheduledVoiceProvisioning, serviceId);
    }
  }
}
