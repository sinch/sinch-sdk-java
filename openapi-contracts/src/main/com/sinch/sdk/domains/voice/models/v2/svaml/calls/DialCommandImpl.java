package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.destination.CallDestination;
import com.sinch.sdk.domains.voice.models.v2.destination.CallOrigin;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.Objects;

@JsonPropertyOrder({
  DialCommandImpl.JSON_PROPERTY_COMMAND,
  DialCommandImpl.JSON_PROPERTY_CALL_NAME,
  DialCommandImpl.JSON_PROPERTY_FROM,
  DialCommandImpl.JSON_PROPERTY_TO,
  DialCommandImpl.JSON_PROPERTY_DIAL_TIMEOUT_DURATION_SECONDS,
  DialCommandImpl.JSON_PROPERTY_MAX_CALL_DURATION_SECONDS,
  DialCommandImpl.JSON_PROPERTY_EVENTS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class DialCommandImpl implements DialCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COMMAND = "command";

  private OptionalValue<CommandEnum> command;

  public static final String JSON_PROPERTY_CALL_NAME = "callName";

  private OptionalValue<String> callName;

  public static final String JSON_PROPERTY_FROM = "from";

  private OptionalValue<CallOrigin> from;

  public static final String JSON_PROPERTY_TO = "to";

  private OptionalValue<CallDestination> to;

  public static final String JSON_PROPERTY_DIAL_TIMEOUT_DURATION_SECONDS =
      "dialTimeoutDurationSeconds";

  private OptionalValue<Integer> dialTimeoutDurationSeconds;

  public static final String JSON_PROPERTY_MAX_CALL_DURATION_SECONDS = "maxCallDurationSeconds";

  private OptionalValue<Integer> maxCallDurationSeconds;

  public static final String JSON_PROPERTY_EVENTS = "events";

  private OptionalValue<CallEvents> events;

  public DialCommandImpl() {}

  protected DialCommandImpl(
      OptionalValue<CommandEnum> command,
      OptionalValue<String> callName,
      OptionalValue<CallOrigin> from,
      OptionalValue<CallDestination> to,
      OptionalValue<Integer> dialTimeoutDurationSeconds,
      OptionalValue<Integer> maxCallDurationSeconds,
      OptionalValue<CallEvents> events) {
    this.command = command;
    this.callName = callName;
    this.from = from;
    this.to = to;
    this.dialTimeoutDurationSeconds = dialTimeoutDurationSeconds;
    this.maxCallDurationSeconds = maxCallDurationSeconds;
    this.events = events;
  }

  @JsonIgnore
  public CommandEnum getCommand() {
    return command.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COMMAND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CommandEnum> command() {
    return command;
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
  public CallOrigin getFrom() {
    return from.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FROM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallOrigin> from() {
    return from;
  }

  @JsonIgnore
  public CallDestination getTo() {
    return to.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<CallDestination> to() {
    return to;
  }

  @JsonIgnore
  public Integer getDialTimeoutDurationSeconds() {
    return dialTimeoutDurationSeconds.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT_DURATION_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> dialTimeoutDurationSeconds() {
    return dialTimeoutDurationSeconds;
  }

  @JsonIgnore
  public Integer getMaxCallDurationSeconds() {
    return maxCallDurationSeconds.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MAX_CALL_DURATION_SECONDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> maxCallDurationSeconds() {
    return maxCallDurationSeconds;
  }

  @JsonIgnore
  public CallEvents getEvents() {
    return events.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CallEvents> events() {
    return events;
  }

  /** Return true if this DialCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DialCommandImpl dialCommand = (DialCommandImpl) o;
    return Objects.equals(this.command, dialCommand.command)
        && Objects.equals(this.callName, dialCommand.callName)
        && Objects.equals(this.from, dialCommand.from)
        && Objects.equals(this.to, dialCommand.to)
        && Objects.equals(this.dialTimeoutDurationSeconds, dialCommand.dialTimeoutDurationSeconds)
        && Objects.equals(this.maxCallDurationSeconds, dialCommand.maxCallDurationSeconds)
        && Objects.equals(this.events, dialCommand.events);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        command, callName, from, to, dialTimeoutDurationSeconds, maxCallDurationSeconds, events);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DialCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    callName: ").append(toIndentedString(callName)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    dialTimeoutDurationSeconds: ")
        .append(toIndentedString(dialTimeoutDurationSeconds))
        .append("\n");
    sb.append("    maxCallDurationSeconds: ")
        .append(toIndentedString(maxCallDurationSeconds))
        .append("\n");
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
  static class Builder implements DialCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.DIAL);
    OptionalValue<String> callName = OptionalValue.empty();
    OptionalValue<CallOrigin> from = OptionalValue.empty();
    OptionalValue<CallDestination> to = OptionalValue.empty();
    OptionalValue<Integer> dialTimeoutDurationSeconds = OptionalValue.empty();
    OptionalValue<Integer> maxCallDurationSeconds = OptionalValue.empty();
    OptionalValue<CallEvents> events = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.DIAL)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.DIAL, command));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_NAME)
    public Builder setCallName(String callName) {
      this.callName = OptionalValue.of(callName);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FROM)
    public Builder setFrom(CallOrigin from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TO, required = true)
    public Builder setTo(CallDestination to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DIAL_TIMEOUT_DURATION_SECONDS)
    public Builder setDialTimeoutDurationSeconds(Integer dialTimeoutDurationSeconds) {
      this.dialTimeoutDurationSeconds = OptionalValue.of(dialTimeoutDurationSeconds);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MAX_CALL_DURATION_SECONDS)
    public Builder setMaxCallDurationSeconds(Integer maxCallDurationSeconds) {
      this.maxCallDurationSeconds = OptionalValue.of(maxCallDurationSeconds);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENTS)
    public Builder setEvents(CallEvents events) {
      this.events = OptionalValue.of(events);
      return this;
    }

    public DialCommand build() {
      return new DialCommandImpl(
          command, callName, from, to, dialTimeoutDurationSeconds, maxCallDurationSeconds, events);
    }
  }
}
