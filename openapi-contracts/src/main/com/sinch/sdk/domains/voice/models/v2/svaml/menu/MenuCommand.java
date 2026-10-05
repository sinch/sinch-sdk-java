package com.sinch.sdk.domains.voice.models.v2.svaml.menu;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import java.util.Map;

/**
 * Defines a set of named menus and executes them starting from startMenu. This is a blocking
 * command — execution waits for the menu to complete before proceeding to the next command.
 *
 * <p>Each menu item configures prompts, input collection, timeout handling, and repeat behavior.
 */
@JsonDeserialize(builder = MenuCommandImpl.Builder.class)
public interface MenuCommand extends SvamlCommand {

  /**
   * Name of the menu to execute first. Must match a key in menus.
   *
   * <p>Field is required
   *
   * @return startMenu
   */
  String getStartMenu();

  /**
   * Map of menu definitions keyed by menu name.
   *
   * <p>Field is required
   *
   * @return menus
   */
  Map<String, MenuItem> getMenus();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MenuCommandImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param startMenu see getter
     * @return Current builder
     * @see #getStartMenu
     */
    Builder setStartMenu(String startMenu);

    /**
     * see getter
     *
     * @param menus see getter
     * @return Current builder
     * @see #getMenus
     */
    Builder setMenus(Map<String, MenuItem> menus);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MenuCommand build();
  }
}
