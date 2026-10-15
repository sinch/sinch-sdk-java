package com.sinch.sdk.domains.voice.models.v2.svaml.menu;

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
  GotoMenuCommandImpl.JSON_PROPERTY_COMMAND,
  GotoMenuCommandImpl.JSON_PROPERTY_MENU_NAME
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GotoMenuCommandImpl implements GotoMenuCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  /** The command property. Must have the value <code>gotoMenu</code>. */
  public static class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>gotoMenu</code> command. */
    public static final CommandEnum GOTO_MENU = new CommandEnum("gotoMenu");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(GOTO_MENU));

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

  public static final String JSON_PROPERTY_MENU_NAME = "menuName";

  private OptionalValue<String> menuName;

  public GotoMenuCommandImpl() {}

  protected GotoMenuCommandImpl(
      OptionalValue<CommandEnum> command, OptionalValue<String> menuName) {
    this.command = command;
    this.menuName = menuName;
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
  public String getMenuName() {
    return menuName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MENU_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> menuName() {
    return menuName;
  }

  /** Return true if this GotoMenuCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GotoMenuCommandImpl gotoMenuCommand = (GotoMenuCommandImpl) o;
    return Objects.equals(this.command, gotoMenuCommand.command)
        && Objects.equals(this.menuName, gotoMenuCommand.menuName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, menuName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GotoMenuCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    menuName: ").append(toIndentedString(menuName)).append("\n");
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
  static class Builder implements GotoMenuCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.GOTO_MENU);
    OptionalValue<String> menuName = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.GOTO_MENU)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.GOTO_MENU, command));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_MENU_NAME, required = true)
    public Builder setMenuName(String menuName) {
      this.menuName = OptionalValue.of(menuName);
      return this;
    }

    public GotoMenuCommand build() {
      return new GotoMenuCommandImpl(command, menuName);
    }
  }
}
