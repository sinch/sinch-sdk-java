package com.sinch.sdk.domains.voice.models.v1.webhooks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  AnsweredCallEventAnsweringMachineDetectionImpl.JSON_PROPERTY_STATUS,
  AnsweredCallEventAnsweringMachineDetectionImpl.JSON_PROPERTY_REASON,
  AnsweredCallEventAnsweringMachineDetectionImpl.JSON_PROPERTY_DURATION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AnsweredCallEventAnsweringMachineDetectionImpl
    implements AnsweredCallEventAnsweringMachineDetection {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<StatusEnum> status;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<ReasonEnum> reason;

  public static final String JSON_PROPERTY_DURATION = "duration";

  private OptionalValue<Integer> duration;

  public AnsweredCallEventAnsweringMachineDetectionImpl() {}

  protected AnsweredCallEventAnsweringMachineDetectionImpl(
      OptionalValue<StatusEnum> status,
      OptionalValue<ReasonEnum> reason,
      OptionalValue<Integer> duration) {
    this.status = status;
    this.reason = reason;
    this.duration = duration;
  }

  @JsonIgnore
  public StatusEnum getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StatusEnum> status() {
    return status;
  }

  @JsonIgnore
  public ReasonEnum getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ReasonEnum> reason() {
    return reason;
  }

  @JsonIgnore
  public Integer getDuration() {
    return duration.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> duration() {
    return duration;
  }

  /** Return true if this aceRequest_allOf_amd object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnsweredCallEventAnsweringMachineDetectionImpl aceRequestAllOfAmd =
        (AnsweredCallEventAnsweringMachineDetectionImpl) o;
    return Objects.equals(this.status, aceRequestAllOfAmd.status)
        && Objects.equals(this.reason, aceRequestAllOfAmd.reason)
        && Objects.equals(this.duration, aceRequestAllOfAmd.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, reason, duration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnsweredCallEventAnsweringMachineDetectionImpl {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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
  static class Builder implements AnsweredCallEventAnsweringMachineDetection.Builder {
    OptionalValue<StatusEnum> status = OptionalValue.empty();
    OptionalValue<ReasonEnum> reason = OptionalValue.empty();
    OptionalValue<Integer> duration = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(StatusEnum status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(ReasonEnum reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DURATION)
    public Builder setDuration(Integer duration) {
      this.duration = OptionalValue.of(duration);
      return this;
    }

    public AnsweredCallEventAnsweringMachineDetection build() {
      return new AnsweredCallEventAnsweringMachineDetectionImpl(status, reason, duration);
    }
  }
}
