package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.models.DualToneMultiFrequency;

public class MenuOption {

  private final OptionalValue<DualToneMultiFrequency> dtfm;
  private final OptionalValue<MenuOptionAction> action;

  private MenuOption(
      OptionalValue<DualToneMultiFrequency> dtfm, OptionalValue<MenuOptionAction> action) {
    this.dtfm = dtfm;
    this.action = action;
  }

  public OptionalValue<DualToneMultiFrequency> getDtfm() {
    return dtfm;
  }

  public OptionalValue<MenuOptionAction> getAction() {
    return action;
  }

  @Override
  public String toString() {
    return "MenuOption{" + "dtfm=" + dtfm + ", action=" + action + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    OptionalValue<DualToneMultiFrequency> dtfm = OptionalValue.empty();
    OptionalValue<MenuOptionAction> action = OptionalValue.empty();

    public Builder setDtfm(DualToneMultiFrequency dtfm) {
      this.dtfm = OptionalValue.of(dtfm);
      return this;
    }

    public Builder setAction(MenuOptionAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    public MenuOption build() {
      return new MenuOption(dtfm, action);
    }
  }
}
