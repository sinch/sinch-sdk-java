package com.sinch.sdk.domains.voice.models.v2.sinchevents;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.svaml.IncomingCallResponseEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  VoiceSinchEventResponseImpl.JSON_PROPERTY_COMMANDS,
  VoiceSinchEventResponseImpl.JSON_PROPERTY_CALL_NAME,
  VoiceSinchEventResponseImpl.JSON_PROPERTY_EVENTS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VoiceSinchEventResponseImpl implements VoiceSinchEventResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMANDS = "commands";

  private OptionalValue<List<SvamlCommand>> commands;

  public static final String JSON_PROPERTY_CALL_NAME = "callName";

  private OptionalValue<String> callName;

  public static final String JSON_PROPERTY_EVENTS = "events";

  private OptionalValue<IncomingCallResponseEvents> events;

  public VoiceSinchEventResponseImpl() {}

  protected VoiceSinchEventResponseImpl(
      OptionalValue<List<SvamlCommand>> commands,
      OptionalValue<String> callName,
      OptionalValue<IncomingCallResponseEvents> events) {
    this.commands = commands;
    this.callName = callName;
    this.events = events;
  }

  @JsonIgnore
  public List<SvamlCommand> getCommands() {
    return commands.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMANDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<SvamlCommand>> commands() {
    return commands;
  }

  @JsonIgnore
  public String getCallName() {
    return callName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CALL_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> callName() {
    return callName;
  }

  @JsonIgnore
  public IncomingCallResponseEvents getEvents() {
    return events.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<IncomingCallResponseEvents> events() {
    return events;
  }

  /** Return true if this VoiceSinchEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoiceSinchEventResponseImpl voiceSinchEventResponse = (VoiceSinchEventResponseImpl) o;
    return Objects.equals(this.commands, voiceSinchEventResponse.commands)
        && Objects.equals(this.callName, voiceSinchEventResponse.callName)
        && Objects.equals(this.events, voiceSinchEventResponse.events);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commands, callName, events);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoiceSinchEventResponseImpl {\n");
    sb.append("    commands: ").append(toIndentedString(commands)).append("\n");
    sb.append("    callName: ").append(toIndentedString(callName)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
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
  static class Builder implements VoiceSinchEventResponse.Builder {
    OptionalValue<List<SvamlCommand>> commands = OptionalValue.empty();
    OptionalValue<String> callName = OptionalValue.empty();
    OptionalValue<IncomingCallResponseEvents> events = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMANDS, required = true)
    public Builder setCommands(List<SvamlCommand> commands) {
      this.commands = OptionalValue.of(commands);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_NAME)
    public Builder setCallName(String callName) {
      this.callName = OptionalValue.of(callName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENTS)
    public Builder setEvents(IncomingCallResponseEvents events) {
      this.events = OptionalValue.of(events);
      return this;
    }

    public VoiceSinchEventResponse build() {
      return new VoiceSinchEventResponseImpl(commands, callName, events);
    }
  }
}
