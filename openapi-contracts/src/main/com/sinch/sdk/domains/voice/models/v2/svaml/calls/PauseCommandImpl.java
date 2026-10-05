package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

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

@JsonPropertyOrder({
  PauseCommandImpl.JSON_PROPERTY_COMMAND,
  PauseCommandImpl.JSON_PROPERTY_DURATION_MILLISECONDS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PauseCommandImpl implements PauseCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  /** The command property. Must have the value <code>pause</code>. */
  public static class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>pause</code> command. */
    public static final CommandEnum PAUSE = new CommandEnum("pause");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(PAUSE));

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

  public static final String JSON_PROPERTY_DURATION_MILLISECONDS = "durationMilliseconds";

  private OptionalValue<Integer> durationMilliseconds;

  public PauseCommandImpl() {}

  protected PauseCommandImpl(
      OptionalValue<CommandEnum> command, OptionalValue<Integer> durationMilliseconds) {
    this.command = command;
    this.durationMilliseconds = durationMilliseconds;
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
  public Integer getDurationMilliseconds() {
    return durationMilliseconds.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DURATION_MILLISECONDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> durationMilliseconds() {
    return durationMilliseconds;
  }

  /** Return true if this PauseCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PauseCommandImpl pauseCommand = (PauseCommandImpl) o;
    return Objects.equals(this.command, pauseCommand.command)
        && Objects.equals(this.durationMilliseconds, pauseCommand.durationMilliseconds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, durationMilliseconds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PauseCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    durationMilliseconds: ")
        .append(toIndentedString(durationMilliseconds))
        .append("\n");
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
  static class Builder implements PauseCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.PAUSE);
    OptionalValue<Integer> durationMilliseconds = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.PAUSE)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.PAUSE, command));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_DURATION_MILLISECONDS, required = true)
    public Builder setDurationMilliseconds(Integer durationMilliseconds) {
      this.durationMilliseconds = OptionalValue.of(durationMilliseconds);
      return this;
    }

    public PauseCommand build() {
      return new PauseCommandImpl(command, durationMilliseconds);
    }
  }
}
