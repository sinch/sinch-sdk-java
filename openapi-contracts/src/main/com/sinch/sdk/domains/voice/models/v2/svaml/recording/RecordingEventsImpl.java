package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

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
  RecordingEventsImpl.JSON_PROPERTY_ON_FINISH,
  RecordingEventsImpl.JSON_PROPERTY_ON_FAILURE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RecordingEventsImpl implements RecordingEvents {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ON_FINISH = "onFinish";

  private OptionalValue<List<SvamlCommand>> onFinish;

  public static final String JSON_PROPERTY_ON_FAILURE = "onFailure";

  private OptionalValue<List<SvamlCommand>> onFailure;

  public RecordingEventsImpl() {}

  protected RecordingEventsImpl(
      OptionalValue<List<SvamlCommand>> onFinish, OptionalValue<List<SvamlCommand>> onFailure) {
    this.onFinish = onFinish;
    this.onFailure = onFailure;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnFinish() {
    return onFinish.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_FINISH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onFinish() {
    return onFinish;
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

  /** Return true if this RecordingEvents object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecordingEventsImpl recordingEvents = (RecordingEventsImpl) o;
    return Objects.equals(this.onFinish, recordingEvents.onFinish)
        && Objects.equals(this.onFailure, recordingEvents.onFailure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(onFinish, onFailure);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecordingEventsImpl {\n");
    sb.append("    onFinish: ").append(toIndentedString(onFinish)).append("\n");
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
  static class Builder implements RecordingEvents.Builder {
    OptionalValue<List<SvamlCommand>> onFinish = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onFailure = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ON_FINISH)
    public Builder setOnFinish(List<SvamlCommand> onFinish) {
      this.onFinish = OptionalValue.of(onFinish);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_FAILURE)
    public Builder setOnFailure(List<SvamlCommand> onFailure) {
      this.onFailure = OptionalValue.of(onFailure);
      return this;
    }

    public RecordingEvents build() {
      return new RecordingEventsImpl(onFinish, onFailure);
    }
  }
}
