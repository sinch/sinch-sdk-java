package com.sinch.sdk.domains.voice.models.v2.svaml.menu;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;

/**
 * Switches execution to another menu within the current menu context. The menu name must be a menu
 * defined in the <code>menu</code> command. This is a blocking command — execution waits for the
 * menu to complete before proceeding to the next command.
 *
 * <p>Important: this command can only be called within a menu execution context.
 */
@JsonDeserialize(builder = GotoMenuCommandImpl.Builder.class)
public interface GotoMenuCommand extends SvamlCommand {

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
