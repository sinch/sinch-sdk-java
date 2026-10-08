package com.sinch.sdk.domains.voice.models.v2.sinchevents;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Information about the menu interaction that triggered the Sinch Event, including the menu name
 * and the input sequence received from the user.
 *
 * <p>This property is also included for Sinch Events triggered by the <code>webhook</code> command
 * within a menu context.
 */
@JsonDeserialize(builder = MenuInputImpl.Builder.class)
public interface MenuInput {

  /**
   * The name of the menu that triggered this Sinch Event.
   *
   * <p>Field is required
   *
   * @return menuName
   */
  String getMenuName();

  /**
   * The input sequence gathered from the user by the menu.
   *
   * <p>Field is required
   *
   * @return input
   */
  String getInput();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new MenuInputImpl.Builder();
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
     * see getter
     *
     * @param input see getter
     * @return Current builder
     * @see #getInput
     */
    Builder setInput(String input);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    MenuInput build();
  }
}
