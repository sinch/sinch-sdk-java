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
  ScheduledVoiceProvisioningImpl.JSON_PROPERTY_APP_ID,
  ScheduledVoiceProvisioningImpl.JSON_PROPERTY_STATUS,
  ScheduledVoiceProvisioningImpl.JSON_PROPERTY_LAST_UPDATED_TIME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ScheduledVoiceProvisioningImpl implements ScheduledVoiceProvisioning {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "appId";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<ProvisioningStatus> status;

  public static final String JSON_PROPERTY_LAST_UPDATED_TIME = "lastUpdatedTime";

  private OptionalValue<Instant> lastUpdatedTime;

  public ScheduledVoiceProvisioningImpl() {}

  protected ScheduledVoiceProvisioningImpl(
      OptionalValue<String> appId,
      OptionalValue<ProvisioningStatus> status,
      OptionalValue<Instant> lastUpdatedTime) {
    this.appId = appId;
    this.status = status;
    this.lastUpdatedTime = lastUpdatedTime;
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

  /** Return true if this ScheduledVoiceProvisioning object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScheduledVoiceProvisioningImpl scheduledVoiceProvisioning = (ScheduledVoiceProvisioningImpl) o;
    return Objects.equals(this.appId, scheduledVoiceProvisioning.appId)
        && Objects.equals(this.status, scheduledVoiceProvisioning.status)
        && Objects.equals(this.lastUpdatedTime, scheduledVoiceProvisioning.lastUpdatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appId, status, lastUpdatedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScheduledVoiceProvisioningImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    lastUpdatedTime: ").append(toIndentedString(lastUpdatedTime)).append("\n");
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
  static class Builder implements ScheduledVoiceProvisioning.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<ProvisioningStatus> status = OptionalValue.empty();
    OptionalValue<Instant> lastUpdatedTime = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
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

    public ScheduledVoiceProvisioning build() {
      return new ScheduledVoiceProvisioningImpl(appId, status, lastUpdatedTime);
    }
  }
}
