package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  AmdEventsImpl.JSON_PROPERTY_ON_HUMAN,
  AmdEventsImpl.JSON_PROPERTY_ON_MACHINE,
  AmdEventsImpl.JSON_PROPERTY_ON_BEEP,
  AmdEventsImpl.JSON_PROPERTY_ON_UNKNOWN
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AmdEventsImpl implements AmdEvents {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ON_HUMAN = "onHuman";

  private OptionalValue<List<SvamlCommand>> onHuman;

  public static final String JSON_PROPERTY_ON_MACHINE = "onMachine";

  private OptionalValue<List<SvamlCommand>> onMachine;

  public static final String JSON_PROPERTY_ON_BEEP = "onBeep";

  private OptionalValue<List<SvamlCommand>> onBeep;

  public static final String JSON_PROPERTY_ON_UNKNOWN = "onUnknown";

  private OptionalValue<List<SvamlCommand>> onUnknown;

  public AmdEventsImpl() {}

  protected AmdEventsImpl(
      OptionalValue<List<SvamlCommand>> onHuman,
      OptionalValue<List<SvamlCommand>> onMachine,
      OptionalValue<List<SvamlCommand>> onBeep,
      OptionalValue<List<SvamlCommand>> onUnknown) {
    this.onHuman = onHuman;
    this.onMachine = onMachine;
    this.onBeep = onBeep;
    this.onUnknown = onUnknown;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnHuman() {
    return onHuman.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_HUMAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onHuman() {
    return onHuman;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnMachine() {
    return onMachine.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_MACHINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onMachine() {
    return onMachine;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnBeep() {
    return onBeep.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_BEEP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onBeep() {
    return onBeep;
  }

  @JsonIgnore
  public List<SvamlCommand> getOnUnknown() {
    return onUnknown.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ON_UNKNOWN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<SvamlCommand>> onUnknown() {
    return onUnknown;
  }

  /** Return true if this AmdEvents object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmdEventsImpl amdEvents = (AmdEventsImpl) o;
    return Objects.equals(this.onHuman, amdEvents.onHuman)
        && Objects.equals(this.onMachine, amdEvents.onMachine)
        && Objects.equals(this.onBeep, amdEvents.onBeep)
        && Objects.equals(this.onUnknown, amdEvents.onUnknown);
  }

  @Override
  public int hashCode() {
    return Objects.hash(onHuman, onMachine, onBeep, onUnknown);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmdEventsImpl {\n");
    sb.append("    onHuman: ").append(toIndentedString(onHuman)).append("\n");
    sb.append("    onMachine: ").append(toIndentedString(onMachine)).append("\n");
    sb.append("    onBeep: ").append(toIndentedString(onBeep)).append("\n");
    sb.append("    onUnknown: ").append(toIndentedString(onUnknown)).append("\n");
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
  static class Builder implements AmdEvents.Builder {
    OptionalValue<List<SvamlCommand>> onHuman = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onMachine = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onBeep = OptionalValue.empty();
    OptionalValue<List<SvamlCommand>> onUnknown = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ON_HUMAN)
    public Builder setOnHuman(List<SvamlCommand> onHuman) {
      this.onHuman = OptionalValue.of(onHuman);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_MACHINE)
    public Builder setOnMachine(List<SvamlCommand> onMachine) {
      this.onMachine = OptionalValue.of(onMachine);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_BEEP)
    public Builder setOnBeep(List<SvamlCommand> onBeep) {
      this.onBeep = OptionalValue.of(onBeep);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ON_UNKNOWN)
    public Builder setOnUnknown(List<SvamlCommand> onUnknown) {
      this.onUnknown = OptionalValue.of(onUnknown);
      return this;
    }

    public AmdEvents build() {
      return new AmdEventsImpl(onHuman, onMachine, onBeep, onUnknown);
    }
  }
}
