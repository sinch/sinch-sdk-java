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
  BridgeCallCommandImpl.JSON_PROPERTY_COMMAND,
  BridgeCallCommandImpl.JSON_PROPERTY_BRIDGE_NAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BridgeCallCommandImpl implements BridgeCallCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  /** The command property. Must have the value <code>bridgeCall</code>. */
  public static class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>bridgeCall</code> command. */
    public static final CommandEnum BRIDGE_CALL = new CommandEnum("bridgeCall");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(BRIDGE_CALL));

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

  public static final String JSON_PROPERTY_BRIDGE_NAME = "bridgeName";

  private OptionalValue<String> bridgeName;

  public BridgeCallCommandImpl() {}

  protected BridgeCallCommandImpl(
      OptionalValue<CommandEnum> command, OptionalValue<String> bridgeName) {
    this.command = command;
    this.bridgeName = bridgeName;
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
  public String getBridgeName() {
    return bridgeName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_BRIDGE_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> bridgeName() {
    return bridgeName;
  }

  /** Return true if this BridgeCallCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BridgeCallCommandImpl bridgeCallCommand = (BridgeCallCommandImpl) o;
    return Objects.equals(this.command, bridgeCallCommand.command)
        && Objects.equals(this.bridgeName, bridgeCallCommand.bridgeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, bridgeName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BridgeCallCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    bridgeName: ").append(toIndentedString(bridgeName)).append("\n");
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
  static class Builder implements BridgeCallCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.BRIDGE_CALL);
    OptionalValue<String> bridgeName = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.BRIDGE_CALL)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.BRIDGE_CALL, command));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_BRIDGE_NAME, required = true)
    public Builder setBridgeName(String bridgeName) {
      this.bridgeName = OptionalValue.of(bridgeName);
      return this;
    }

    public BridgeCallCommand build() {
      return new BridgeCallCommandImpl(command, bridgeName);
    }
  }
}
