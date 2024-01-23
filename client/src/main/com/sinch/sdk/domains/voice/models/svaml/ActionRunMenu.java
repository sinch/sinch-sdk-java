package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Collection;

public class ActionRunMenu extends Action {

  private final OptionalValue<Boolean> barge;
  private final OptionalValue<String> locale;
  private final OptionalValue<String> mainMenu;
  private final OptionalValue<Boolean> enableVoice;
  private final OptionalValue<Collection<Menu>> menus;

  private ActionRunMenu(
      OptionalValue<Boolean> barge,
      OptionalValue<String> locale,
      OptionalValue<String> mainMenu,
      OptionalValue<Boolean> enableVoice,
      OptionalValue<Collection<Menu>> menus) {
    this.barge = barge;
    this.locale = locale;
    this.mainMenu = mainMenu;
    this.enableVoice = enableVoice;
    this.menus = menus;
  }

  public OptionalValue<Boolean> getBarge() {
    return barge;
  }

  public OptionalValue<String> getLocale() {
    return locale;
  }

  public OptionalValue<String> getMainMenu() {
    return mainMenu;
  }

  public OptionalValue<Boolean> getEnableVoice() {
    return enableVoice;
  }

  public OptionalValue<Collection<Menu>> getMenus() {
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

    OptionalValue<Boolean> barge = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<String> mainMenu = OptionalValue.empty();
    OptionalValue<Boolean> enableVoice = OptionalValue.empty();
    OptionalValue<Collection<Menu>> menus = OptionalValue.empty();

    public Builder<B> setBarge(Boolean barge) {
      this.barge = OptionalValue.of(barge);
      return this;
    }

    public Builder<B> setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    public Builder<B> setMainMenu(String mainMenu) {
      this.mainMenu = OptionalValue.of(mainMenu);
      return this;
    }

    public Builder<B> setEnableVoice(Boolean enableVoice) {
      this.enableVoice = OptionalValue.of(enableVoice);
      return this;
    }

    public Builder<B> setMenus(Collection<Menu> menus) {
      this.menus = OptionalValue.of(menus);
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
