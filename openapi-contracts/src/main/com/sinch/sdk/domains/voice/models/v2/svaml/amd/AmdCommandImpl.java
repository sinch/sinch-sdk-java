package com.sinch.sdk.domains.voice.models.v2.svaml.amd;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.Arrays;
import java.util.Objects;

@JsonPropertyOrder({AmdCommandImpl.JSON_PROPERTY_COMMAND, AmdCommandImpl.JSON_PROPERTY_EVENTS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AmdCommandImpl implements AmdCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  /** The command property. Must have the value <code>amd</code>. */
  public static class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>amd</code> command. */
    public static final CommandEnum AMD = new CommandEnum("amd");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(AMD));

    private CommandEnum(String value) {
      super(value);
    }

    public static java.util.stream.Stream<CommandEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static CommandEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(CommandEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static final String JSON_PROPERTY_COMMAND = "command";

  private OptionalValue<CommandEnum> command;

  public static final String JSON_PROPERTY_EVENTS = "events";

  private OptionalValue<AmdEvents> events;

  public AmdCommandImpl() {}

  protected AmdCommandImpl(OptionalValue<CommandEnum> command, OptionalValue<AmdEvents> events) {
    this.command = command;
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
  public AmdEvents getEvents() {
    return events.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<AmdEvents> events() {
    return events;
  }

  /** Return true if this AmdCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmdCommandImpl amdCommand = (AmdCommandImpl) o;
    return Objects.equals(this.command, amdCommand.command)
        && Objects.equals(this.events, amdCommand.events);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, events);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmdCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
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
  static class Builder implements AmdCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.AMD);
    OptionalValue<AmdEvents> events = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.AMD)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.AMD, command));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENTS)
    public Builder setEvents(AmdEvents events) {
      this.events = OptionalValue.of(events);
      return this;
    }

    public AmdCommand build() {
      return new AmdCommandImpl(command, events);
    }
  }
}
