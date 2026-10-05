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
  HangupCommandImpl.JSON_PROPERTY_COMMAND,
  HangupCommandImpl.JSON_PROPERTY_CALL_NAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class HangupCommandImpl implements HangupCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  /** The command property. Must have the value <code>hangup</code>. */
  public static class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>hangup</code> command. */
    public static final CommandEnum HANGUP = new CommandEnum("hangup");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(HANGUP));

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

  public static final String JSON_PROPERTY_CALL_NAME = "callName";

  private OptionalValue<String> callName;

  public HangupCommandImpl() {}

  protected HangupCommandImpl(OptionalValue<CommandEnum> command, OptionalValue<String> callName) {
    this.command = command;
    this.callName = callName;
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

  /** Return true if this HangupCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HangupCommandImpl hangupCommand = (HangupCommandImpl) o;
    return Objects.equals(this.command, hangupCommand.command)
        && Objects.equals(this.callName, hangupCommand.callName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, callName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HangupCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    callName: ").append(toIndentedString(callName)).append("\n");
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
  static class Builder implements HangupCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.HANGUP);
    OptionalValue<String> callName = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.HANGUP)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.HANGUP, command));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CALL_NAME)
    public Builder setCallName(String callName) {
      this.callName = OptionalValue.of(callName);
      return this;
    }

    public HangupCommand build() {
      return new HangupCommandImpl(command, callName);
    }
  }
}
