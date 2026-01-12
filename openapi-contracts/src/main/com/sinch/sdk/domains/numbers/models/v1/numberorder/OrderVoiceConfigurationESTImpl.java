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
  OrderVoiceConfigurationESTImpl.JSON_PROPERTY_TYPE,
  OrderVoiceConfigurationESTImpl.JSON_PROPERTY_LAST_UPDATED_TIME,
  OrderVoiceConfigurationESTImpl.JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING,
  OrderVoiceConfigurationESTImpl.JSON_PROPERTY_TRUNK_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderVoiceConfigurationESTImpl implements OrderVoiceConfigurationEST {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<VoiceApplicationType> type;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public static final String JSON_PROPERTY_SCHEDULED_VOICE_PROVISIONING =
      "scheduledVoiceProvisioning";

  private OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning;

  public static final String JSON_PROPERTY_TRUNK_ID = "trunkId";

  private OptionalValue<String> trunkId;

  public OrderVoiceConfigurationESTImpl() {}

  protected OrderVoiceConfigurationESTImpl(
      OptionalValue<VoiceApplicationType> type,
      OptionalValue<Instant> lastUpdatedTime,
      OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning,
      OptionalValue<String> trunkId) {
    this.type = type;
    this.lastUpdatedTime = lastUpdatedTime;
    this.scheduledVoiceProvisioning = scheduledVoiceProvisioning;
    this.trunkId = trunkId;
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
  public String getTrunkId() {
    return trunkId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRUNK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> trunkId() {
    return trunkId;
  }

  /** Return true if this OrderVoiceConfigurationEST object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderVoiceConfigurationESTImpl orderVoiceConfigurationEST = (OrderVoiceConfigurationESTImpl) o;
    return Objects.equals(this.type, orderVoiceConfigurationEST.type)
        && Objects.equals(this.lastUpdatedTime, orderVoiceConfigurationEST.lastUpdatedTime)
        && Objects.equals(
            this.scheduledVoiceProvisioning, orderVoiceConfigurationEST.scheduledVoiceProvisioning)
        && Objects.equals(this.trunkId, orderVoiceConfigurationEST.trunkId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, lastUpdatedTime, scheduledVoiceProvisioning, trunkId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderVoiceConfigurationESTImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
    sb.append("    scheduledVoiceProvisioning: ")
        .append(toIndentedString(scheduledVoiceProvisioning))
        .append("\n");
    sb.append("    trunkId: ").append(toIndentedString(trunkId)).append("\n");
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
  static class Builder implements OrderVoiceConfigurationEST.Builder {
    OptionalValue<VoiceApplicationType> type = OptionalValue.empty();
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();
    OptionalValue<ScheduledVoiceProvisioningInternal> scheduledVoiceProvisioning =
        OptionalValue.empty();
    OptionalValue<String> trunkId = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_TRUNK_ID)
    public Builder setTrunkId(String trunkId) {
      this.trunkId = OptionalValue.of(trunkId);
      return this;
    }

    public OrderVoiceConfigurationEST build() {
      return new OrderVoiceConfigurationESTImpl(
          type, lastUpdatedTime, scheduledVoiceProvisioning, trunkId);
    }
  }
}
