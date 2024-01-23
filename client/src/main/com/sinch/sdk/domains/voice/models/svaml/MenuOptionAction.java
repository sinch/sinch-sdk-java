package com.sinch.sdk.domains.voice.models.svaml;

/** Navigates to the named menu */
public class MenuOptionAction {

  private final MenuOptionActionType type;
  private final String id;

  private MenuOptionAction(MenuOptionActionType type, String id) {
    this.type = type;
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public MenuOptionActionType getType() {
    return type;
  }

  public static MenuOptionAction from(MenuOptionActionType type, String id) {
    return new MenuOptionAction(type, id);
  }

  @Override
  public String toString() {
    return "MenuOptionAction{" + "type=" + type + ", id='" + id + '\'' + '}';
  }
}
