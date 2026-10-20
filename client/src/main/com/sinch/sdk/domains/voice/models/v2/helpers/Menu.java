package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.menu.GotoMenuCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuItem;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuPrompt;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Helpers to build the interactive menu SVAML commands
 *
 * @since 2.4
 */
public final class Menu {

  private Menu() {}

  /**
   * Run an interactive menu that collects user input (e.g. DTMF digits)
   *
   * <p>The sequence waits for the menu to end before running the next command.
   *
   * @param startMenu Name of the item played first, 1 to 16 characters. It must be one of the items
   *     of the menu
   * @return The creator of the <code>menu</code> command
   * @since 2.4
   */
  public static MenuCreator create(String startMenu) {
    return new MenuCreator(startMenu);
  }

  /**
   * Jump to another item of the enclosing menu
   *
   * <p>Only valid within a menu: in the <code>match</code> or <code>onFailure</code> commands of an
   * item, including their nested event handlers. The target must be an item of that menu.
   *
   * <p>The target is checked when one of these is built: a menu ({@link MenuCreator}), a sequence
   * ({@link CommandsSequenceCreator}), a static call behavior or a response to an incoming call.
   * Building another creator alone, e.g. {@link DialCreator}, does not check it.
   *
   * <p>Named after the API command: <code>goto</code> is a reserved word in Java.
   *
   * @param name Name of the menu item, 1 to 16 characters, sent as <code>menuName</code>
   * @return The <code>gotoMenu</code> command
   * @since 2.4
   */
  public static GotoMenuCommand gotoMenu(String name) {
    Objects.requireNonNull(name, "name must not be null");
    return GotoMenuCommand.builder().setMenuName(name).build();
  }

  /**
   * Create a menu prompt, e.g. to share it between several items or as repeat prompt
   *
   * @param prompt Lambda filling the prompt
   * @return The menu prompt
   * @throws IllegalStateException if the lambda adds no message
   * @since 2.4
   */
  public static MenuPrompt prompt(Consumer<PromptCreator> prompt) {
    Objects.requireNonNull(prompt, "prompt must not be null");
    PromptCreator creator = new PromptCreator();
    prompt.accept(creator);
    return creator.build();
  }

  /**
   * Create a menu item, e.g. to share it between several menus
   *
   * <p>Add it to a menu with {@link MenuCreator#item(String, MenuItem)}. Its <code>gotoMenu</code>
   * targets are checked when that menu is built.
   *
   * @param item Lambda filling the item
   * @return The menu item
   * @since 2.4
   */
  public static MenuItem item(Consumer<MenuItemCreator> item) {
    Objects.requireNonNull(item, "item must not be null");
    MenuItemCreator creator = new MenuItemCreator();
    item.accept(creator);
    return creator.build();
  }
}
