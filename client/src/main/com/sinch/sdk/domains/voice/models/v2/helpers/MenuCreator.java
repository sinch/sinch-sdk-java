package com.sinch.sdk.domains.voice.models.v2.helpers;

import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.amd.AmdCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.amd.AmdEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.CallEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.GotoMenuCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.menu.MenuItem;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommand;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.RecordingEvents;
import com.sinch.sdk.domains.voice.models.v2.svaml.recording.StartRecordingCommand;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Fluent creator of a <code>menu</code> command, returned by {@link Menu#create(String)}
 *
 * <p>{@link #build()} checks that the start menu and every {@link Menu#gotoMenu(String)} target are
 * items of this menu.
 *
 * @since 2.4
 */
public final class MenuCreator {

  private final String startMenu;
  private final Map<String, MenuItem> items = new LinkedHashMap<>();

  MenuCreator(String startMenu) {
    this.startMenu = Objects.requireNonNull(startMenu, "startMenu must not be null");
  }

  /**
   * Add a menu item
   *
   * @param name Name of the item, 1 to 16 characters. Start menu and gotoMenu targets refer to it
   * @param item Lambda filling the item
   * @return This creator
   * @throws IllegalArgumentException if an item with this name is already defined
   * @since 2.4
   */
  public MenuCreator item(String name, Consumer<MenuItemCreator> item) {
    checkNewItem(name);
    return item(name, Menu.item(item));
  }

  /**
   * Add a menu item
   *
   * @param name Name of the item, 1 to 16 characters. Start menu and gotoMenu targets refer to it
   * @param item Menu item, e.g. built with {@link Menu#item(Consumer)} to share it
   * @return This creator
   * @throws IllegalArgumentException if an item with this name is already defined
   * @since 2.4
   */
  public MenuCreator item(String name, MenuItem item) {
    checkNewItem(name);
    items.put(name, Objects.requireNonNull(item, "item must not be null"));
    return this;
  }

  /**
   * Build the <code>menu</code> command
   *
   * @return The command
   * @throws IllegalStateException if the start menu, or the target of a <code>gotoMenu</code>
   *     command of an item, is not an item of this menu
   * @since 2.4
   */
  public MenuCommand build() {
    checkMenu(startMenu, items);
    return MenuCommand.builder()
        .setStartMenu(startMenu)
        .setMenus(new LinkedHashMap<>(items))
        .build();
  }

  private void checkNewItem(String name) {
    Objects.requireNonNull(name, "name must not be null");
    if (items.containsKey(name)) {
      throw new IllegalArgumentException(
          String.format("menu item \"%s\" is already defined", name));
    }
  }

  /** The start menu, and every <code>gotoMenu</code> target of the items, must be an item */
  static void checkMenu(String startMenu, Map<String, MenuItem> menus) {
    Map<String, MenuItem> items = null == menus ? Collections.emptyMap() : menus;
    if (!items.containsKey(startMenu)) {
      throw new IllegalStateException(String.format("menu start \"%s\" is not defined", startMenu));
    }
    for (MenuItem item : items.values()) {
      if (null != item.getMatches()) {
        for (List<SvamlCommand> commands : item.getMatches().values()) {
          checkGotoTargets(commands, items.keySet());
        }
      }
      checkGotoTargets(item.getOnFailure(), items.keySet());
    }
  }

  /**
   * A <code>gotoMenu</code> target must be an item of the enclosing menu. Nested event handlers are
   * searched too. A nested <code>menu</code> is checked against its own items, so one built without
   * this creator (e.g. with {@link MenuCommand#builder()}) is checked as well.
   */
  static void checkGotoTargets(List<SvamlCommand> commands, Set<String> names) {
    if (null == commands) {
      return;
    }
    for (SvamlCommand command : commands) {
      if (command instanceof GotoMenuCommand) {
        String target = ((GotoMenuCommand) command).getMenuName();
        if (!names.contains(target)) {
          throw new IllegalStateException(String.format("gotoMenu \"%s\" is not defined", target));
        }
      } else if (command instanceof MenuCommand) {
        MenuCommand menu = (MenuCommand) command;
        checkMenu(menu.getStartMenu(), menu.getMenus());
      } else if (command instanceof DialCommand) {
        CallEvents events = ((DialCommand) command).getEvents();
        if (null != events) {
          checkGotoTargets(events.getOnAnswer(), names);
          checkGotoTargets(events.getOnBusy(), names);
          checkGotoTargets(events.getOnReject(), names);
          checkGotoTargets(events.getOnTimeout(), names);
          checkGotoTargets(events.getOnHangup(), names);
          checkGotoTargets(events.getOnFailure(), names);
        }
      } else if (command instanceof AmdCommand) {
        AmdEvents events = ((AmdCommand) command).getEvents();
        if (null != events) {
          checkGotoTargets(events.getOnHuman(), names);
          checkGotoTargets(events.getOnMachine(), names);
          checkGotoTargets(events.getOnBeep(), names);
          checkGotoTargets(events.getOnUnknown(), names);
        }
      } else if (command instanceof MessagesCommand) {
        MessagesCommand messages = (MessagesCommand) command;
        if (null != messages.getEvents()) {
          checkGotoTargets(messages.getEvents().getOnFinish(), names);
        }
      } else if (command instanceof StartRecordingCommand) {
        RecordingEvents events = ((StartRecordingCommand) command).getEvents();
        if (null != events) {
          checkGotoTargets(events.getOnFinish(), names);
          checkGotoTargets(events.getOnFailure(), names);
        }
      }
    }
  }
}
