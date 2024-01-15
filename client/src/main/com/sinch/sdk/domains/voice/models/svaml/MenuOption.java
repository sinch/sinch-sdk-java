package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.models.DualToneMultiFrequency;

public class MenuOption {

  private final DualToneMultiFrequency dtfm;
  private final MenuOptionActionType action;

  private MenuOption(DualToneMultiFrequency dtfm, MenuOptionActionType action) {
    this.dtfm = dtfm;
    this.action = action;
  }

  public DualToneMultiFrequency getDtfm() {
    return dtfm;
  }

  public MenuOptionActionType getAction() {
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

    DualToneMultiFrequency dtfm;
    MenuOptionActionType action;

    public Builder setDtfm(DualToneMultiFrequency dtfm) {
      this.dtfm = dtfm;
      return this;
    }

    public Builder setAction(MenuOptionActionType action) {
      this.action = action;
      return this;
    }

    public MenuOption build() {
      return new MenuOption(dtfm, action);
    }
  }
}
