package com.sinch.sdk.domains.voice.models.svaml;

import java.util.Collection;

public class ActionRunMenu extends Action {

  private final Boolean barge;
  private final String locale;
  private final String mainMenu;
  private final Boolean enableVoice;
  private final Collection<Menu> menus;

  private ActionRunMenu(
      Boolean barge, String locale, String mainMenu, Boolean enableVoice, Collection<Menu> menus) {
    this.barge = barge;
    this.locale = locale;
    this.mainMenu = mainMenu;
    this.enableVoice = enableVoice;
    this.menus = menus;
  }

  public Boolean getBarge() {
    return barge;
  }

  public String getLocale() {
    return locale;
  }

  public String getMainMenu() {
    return mainMenu;
  }

  public Boolean getEnableVoice() {
    return enableVoice;
  }

  public Collection<Menu> getMenus() {
    return menus;
  }

  @Override
  public String toString() {
    return "ActionRunMenu{"
        + "barge="
        + barge
        + ", locale='"
        + locale
        + '\''
        + ", mainMenu='"
        + mainMenu
        + '\''
        + ", enableVoice="
        + enableVoice
        + ", menus="
        + menus
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    Boolean barge;
    String locale;
    String mainMenu;
    Boolean enableVoice;
    Collection<Menu> menus;

    public Builder<B> setBarge(Boolean barge) {
      this.barge = barge;
      return this;
    }

    public Builder<B> setLocale(String locale) {
      this.locale = locale;
      return this;
    }

    public Builder<B> setMainMenu(String mainMenu) {
      this.mainMenu = mainMenu;
      return this;
    }

    public Builder<B> setEnableVoice(Boolean enableVoice) {
      this.enableVoice = enableVoice;
      return this;
    }

    public Builder<B> setMenus(Collection<Menu> menus) {
      this.menus = menus;
      return this;
    }

    public ActionRunMenu build() {
      return new ActionRunMenu(barge, locale, mainMenu, enableVoice, menus);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
