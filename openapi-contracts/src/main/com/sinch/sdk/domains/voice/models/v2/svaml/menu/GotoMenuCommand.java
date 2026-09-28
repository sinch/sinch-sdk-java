package com.sinch.sdk.domains.voice.models.v2.svaml.menu;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Switches execution to another menu within the current menu context. The menu name must be a menu
 * defined in the <code>menu</code> command. This is a blocking command — execution waits for the
 * menu to complete before proceeding to the next command.
 *
 * <p>Important: this command can only be called within a menu execution context.
 */
@JsonDeserialize(builder = GotoMenuCommandImpl.Builder.class)
public interface GotoMenuCommand extends SvamlCommand {

  /** The command property. Must have the value <code>gotoMenu</code>. */
  public class CommandEnum extends EnumDynamic<String, CommandEnum> {
    /** The <code>gotoMenu</code> command. */
    public static final CommandEnum GOTO_MENU = new CommandEnum("gotoMenu");

    private static final EnumSupportDynamic<String, CommandEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(CommandEnum.class, CommandEnum::new, Arrays.asList(GOTO_MENU));

    private CommandEnum(String value) {
      super(value);
    }

    public static Stream<CommandEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static CommandEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(CommandEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  /**
   * Name of the target menu to execute next. Must match a key in menus.
   *
   * <p>Field is required
   *
   * @return menuName
   */
  String getMenuName();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new GotoMenuCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param menuName see getter
     * @return Current builder
     * @see #getMenuName
     */
    Builder setMenuName(String menuName);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    GotoMenuCommand build();
  }
}
