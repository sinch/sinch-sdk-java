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
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  MenuCommandImpl.JSON_PROPERTY_COMMAND,
  MenuCommandImpl.JSON_PROPERTY_START_MENU,
  MenuCommandImpl.JSON_PROPERTY_MENUS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class MenuCommandImpl implements MenuCommand, SvamlCommand {
  private static final long serialVersionUID = 1L;

  /** The command property. Must have the value <code>menu</code>. */
  public static class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>menu</code> command. */
    public static final CommandEnum MENU = new CommandEnum("menu");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(MENU));

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

  public static final String JSON_PROPERTY_START_MENU = "startMenu";

  private OptionalValue<String> startMenu;

  public static final String JSON_PROPERTY_MENUS = "menus";

  private OptionalValue<Map<String, MenuItem>> menus;

  public MenuCommandImpl() {}

  protected MenuCommandImpl(
      OptionalValue<CommandEnum> command,
      OptionalValue<String> startMenu,
      OptionalValue<Map<String, MenuItem>> menus) {
    this.command = command;
    this.startMenu = startMenu;
    this.menus = menus;
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
  public String getStartMenu() {
    return startMenu.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_START_MENU)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> startMenu() {
    return startMenu;
  }

  @JsonIgnore
  public Map<String, MenuItem> getMenus() {
    return menus.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MENUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Map<String, MenuItem>> menus() {
    return menus;
  }

  /** Return true if this MenuCommand object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MenuCommandImpl menuCommand = (MenuCommandImpl) o;
    return Objects.equals(this.command, menuCommand.command)
        && Objects.equals(this.startMenu, menuCommand.startMenu)
        && Objects.equals(this.menus, menuCommand.menus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command, startMenu, menus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MenuCommandImpl {\n");
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
    sb.append("    startMenu: ").append(toIndentedString(startMenu)).append("\n");
    sb.append("    menus: ").append(toIndentedString(menus)).append("\n");
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
  static class Builder implements MenuCommand.Builder {
    OptionalValue<CommandEnum> command = OptionalValue.of(CommandEnum.MENU);
    OptionalValue<String> startMenu = OptionalValue.empty();
    OptionalValue<Map<String, MenuItem>> menus = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_COMMAND, required = true)
    Builder setCommand(CommandEnum command) {
      if (!Objects.equals(command, CommandEnum.MENU)) {
        throw new IllegalArgumentException(
            String.format("'command' must be '%s' (is '%s')", CommandEnum.MENU, command));
      }
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_START_MENU, required = true)
    public Builder setStartMenu(String startMenu) {
      this.startMenu = OptionalValue.of(startMenu);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_MENUS, required = true)
    public Builder setMenus(Map<String, MenuItem> menus) {
      this.menus = OptionalValue.of(menus);
      return this;
    }

    public MenuCommand build() {
      return new MenuCommandImpl(command, startMenu, menus);
    }
  }
}
