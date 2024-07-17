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
  ScheduledVoiceProvisioningESTImpl.JSON_PROPERTY_TYPE,
  ScheduledVoiceProvisioningESTImpl.JSON_PROPERTY_LAST_UPDATED_TIME,
  ScheduledVoiceProvisioningESTImpl.JSON_PROPERTY_STATUS,
  ScheduledVoiceProvisioningESTImpl.JSON_PROPERTY_TRUNK_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ScheduledVoiceProvisioningESTImpl
    implements ScheduledVoiceProvisioningEST,
        com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<VoiceApplicationType> type;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<ProvisioningStatus> status;

  public static final String JSON_PROPERTY_TRUNK_ID = "trunkId";

  private OptionalValue<String> trunkId;

  public ScheduledVoiceProvisioningESTImpl() {}

  protected ScheduledVoiceProvisioningESTImpl(
      OptionalValue<VoiceApplicationType> type,
      OptionalValue<Instant> lastUpdatedTime,
      OptionalValue<ProvisioningStatus> status,
      OptionalValue<String> trunkId) {
    this.type = type;
    this.lastUpdatedTime = lastUpdatedTime;
    this.status = status;
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
  public String getTrunkId() {
    return trunkId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TRUNK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> trunkId() {
    return trunkId;
  }

  /** Return true if this ScheduledVoiceProvisioningEST object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduledVoiceProvisioningESTImpl scheduledVoiceProvisioningEST =
        (ScheduledVoiceProvisioningESTImpl) o;
    return Objects.equals(this.type, scheduledVoiceProvisioningEST.type)
        && Objects.equals(this.lastUpdatedTime, scheduledVoiceProvisioningEST.lastUpdatedTime)
        && Objects.equals(this.status, scheduledVoiceProvisioningEST.status)
        && Objects.equals(this.trunkId, scheduledVoiceProvisioningEST.trunkId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, lastUpdatedTime, status, trunkId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduledVoiceProvisioningESTImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
  static class Builder implements ScheduledVoiceProvisioningEST.Builder {
    OptionalValue<VoiceApplicationType> type = OptionalValue.of(VoiceApplicationType.EST);
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();
    OptionalValue<ProvisioningStatus> status = OptionalValue.empty();
    OptionalValue<String> trunkId = OptionalValue.empty();

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

    @JsonProperty(JSON_PROPERTY_TRUNK_ID)
    public Builder setTrunkId(String trunkId) {
      this.trunkId = OptionalValue.of(trunkId);
      return this;
    }

    public ScheduledVoiceProvisioningEST build() {
      return new ScheduledVoiceProvisioningESTImpl(type, lastUpdatedTime, status, trunkId);
    }
  }
}
