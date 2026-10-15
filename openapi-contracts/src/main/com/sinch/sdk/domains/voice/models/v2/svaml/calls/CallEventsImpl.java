package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  CallEventsImpl.JSON_PROPERTY_ON_ANSWER,
  CallEventsImpl.JSON_PROPERTY_ON_BUSY,
  CallEventsImpl.JSON_PROPERTY_ON_REJECT,
  CallEventsImpl.JSON_PROPERTY_ON_TIMEOUT,
  CallEventsImpl.JSON_PROPERTY_ON_HANGUP,
  CallEventsImpl.JSON_PROPERTY_ON_FAILURE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallEventsImpl implements CallEvents {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ON_ANSWER = "onAnswer";

  private OptionalValue<List<SvamlCommand>> onAnswer;

  public static final String JSON_PROPERTY_ON_BUSY = "onBusy";

  private OptionalValue<List<SvamlCommand>> onBusy;

  public static final String JSON_PROPERTY_ON_REJECT = "onReject";

  private OptionalValue<List<SvamlCommand>> onReject;

  public static final String JSON_PROPERTY_ON_TIMEOUT = "onTimeout";

  private OptionalValue<List<SvamlCommand>> onTimeout;

  public static final String JSON_PROPERTY_ON_HANGUP = "onHangup";

  private OptionalValue<List<SvamlCommand>> onHangup;

  public static final String JSON_PROPERTY_ON_FAILURE = "onFailure";

  private OptionalValue<List<SvamlCommand>> onFailure;

  public CallEventsImpl() {}

  protected CallEventsImpl(
      OptionalValue<List<SvamlCommand>> onAnswer,
      OptionalValue<List<SvamlCommand>> onBusy,
      OptionalValue<List<SvamlCommand>> onReject,
      OptionalValue<List<SvamlCommand>> onTimeout,
      OptionalValue<List<SvamlCommand>> onHangup,
      OptionalValue<List<SvamlCommand>> onFailure) {
    this.onAnswer = onAnswer;
    this.onBusy = onBusy;
    this.onReject = onReject;
    this.onTimeout = onTimeout;
    this.onHangup = onHangup;
    this.onFailure = onFailure;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnAnswer() {
    return onAnswer.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_ANSWER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onAnswer() {
    return onAnswer;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnBusy() {
    return onBusy.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_BUSY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onBusy() {
    return onBusy;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnReject() {
    return onReject.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_REJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onReject() {
    return onReject;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnTimeout() {
    return onTimeout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onTimeout() {
    return onTimeout;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnHangup() {
    return onHangup.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_HANGUP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onHangup() {
    return onHangup;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnFailure() {
    return onFailure.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_FAILURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onFailure() {
    return onFailure;
  }

  /** Return true if this CallEvents object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallEventsImpl callEvents = (CallEventsImpl) o;
    return Objects.equals(this.onAnswer, callEvents.onAnswer)
        && Objects.equals(this.onBusy, callEvents.onBusy)
        && Objects.equals(this.onReject, callEvents.onReject)
        && Objects.equals(this.onTimeout, callEvents.onTimeout)
        && Objects.equals(this.onHangup, callEvents.onHangup)
        && Objects.equals(this.onFailure, callEvents.onFailure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(onAnswer, onBusy, onReject, onTimeout, onHangup, onFailure);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallEventsImpl {\n");
    sb.append("    onAnswer: ").append(toIndentedString(onAnswer)).append("\n");
    sb.append("    onBusy: ").append(toIndentedString(onBusy)).append("\n");
    sb.append("    onReject: ").append(toIndentedString(onReject)).append("\n");
    sb.append("    onTimeout: ").append(toIndentedString(onTimeout)).append("\n");
    sb.append("    onHangup: ").append(toIndentedString(onHangup)).append("\n");
    sb.append("    onFailure: ").append(toIndentedString(onFailure)).append("\n");
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
  static class Builder implements CallEvents.Builder {
    OptionalValue<List<SvamlCommand>> onAnswer = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onBusy = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onReject = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onTimeout = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onHangup = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onFailure = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ON_ANSWER)
    public Builder setOnAnswer(List<SvamlCommand> onAnswer) {
      this.onAnswer = OptionalValue.of(onAnswer);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_BUSY)
    public Builder setOnBusy(List<SvamlCommand> onBusy) {
      this.onBusy = OptionalValue.of(onBusy);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_REJECT)
    public Builder setOnReject(List<SvamlCommand> onReject) {
      this.onReject = OptionalValue.of(onReject);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_TIMEOUT)
    public Builder setOnTimeout(List<SvamlCommand> onTimeout) {
      this.onTimeout = OptionalValue.of(onTimeout);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_HANGUP)
    public Builder setOnHangup(List<SvamlCommand> onHangup) {
      this.onHangup = OptionalValue.of(onHangup);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_FAILURE)
    public Builder setOnFailure(List<SvamlCommand> onFailure) {
      this.onFailure = OptionalValue.of(onFailure);
      return this;
    }

    public CallEvents build() {
      return new CallEventsImpl(onAnswer, onBusy, onReject, onTimeout, onHangup, onFailure);
    }
  }
}
