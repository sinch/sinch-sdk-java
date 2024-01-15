package com.sinch.sdk.domains.voice.models.svaml;

import java.util.Collection;

public class Menu {

  private final String id;
  private final String mainPrompt;
  private final String repeatPrompt;
  private final Integer repeats;
  private final Integer maxDigits;
  private final Integer timeoutMills;
  private final Integer maxTimeoutMills;
  private final Collection<MenuOption> options;

  private Menu(
      String id,
      String mainPrompt,
      String repeatPrompt,
      Integer repeats,
      Integer maxDigits,
      Integer timeoutMills,
      Integer maxTimeoutMills,
      Collection<MenuOption> options) {
    this.id = id;
    this.mainPrompt = mainPrompt;
    this.repeatPrompt = repeatPrompt;
    this.repeats = repeats;
    this.maxDigits = maxDigits;
    this.timeoutMills = timeoutMills;
    this.maxTimeoutMills = maxTimeoutMills;
    this.options = options;
  }

  public String getId() {
    return id;
  }

  public String getMainPrompt() {
    return mainPrompt;
  }

  public String getRepeatPrompt() {
    return repeatPrompt;
  }

  public Integer getRepeats() {
    return repeats;
  }

  public Integer getMaxDigits() {
    return maxDigits;
  }

  public Integer getTimeoutMills() {
    return timeoutMills;
  }

  public Integer getMaxTimeoutMills() {
    return maxTimeoutMills;
  }

  public Collection<MenuOption> getOptions() {
    return options;
  }

  @Override
  public String toString() {
    return "Menu{"
        + "id='"
        + id
        + '\''
        + ", mainPrompt='"
        + mainPrompt
        + '\''
        + ", repeatPrompt='"
        + repeatPrompt
        + '\''
        + ", repeats="
        + repeats
        + ", maxDigits="
        + maxDigits
        + ", timeoutMills="
        + timeoutMills
        + ", maxTimeoutMills="
        + maxTimeoutMills
        + ", options="
        + options
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    String id;
    String mainPrompt;
    String repeatPrompt;
    Integer repeats;
    Integer maxDigits;
    Integer timeoutMills;
    Integer maxTimeoutMills;
    Collection<MenuOption> options;

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setMainPrompt(String mainPrompt) {
      this.mainPrompt = mainPrompt;
      return this;
    }

    public Builder setRepeatPrompt(String repeatPrompt) {
      this.repeatPrompt = repeatPrompt;
      return this;
    }

    public Builder setRepeats(Integer repeats) {
      this.repeats = repeats;
      return this;
    }

    public Builder setMaxDigits(Integer maxDigits) {
      this.maxDigits = maxDigits;
      return this;
    }

    public Builder setTimeoutMills(Integer timeoutMills) {
      this.timeoutMills = timeoutMills;
      return this;
    }

    public Builder setMaxTimeoutMills(Integer maxTimeoutMills) {
      this.maxTimeoutMills = maxTimeoutMills;
      return this;
    }

    public Builder setOptions(Collection<MenuOption> options) {
      this.options = options;
      return this;
    }

    public Menu build() {
      return new Menu(
          id, mainPrompt, repeatPrompt, repeats, maxDigits, timeoutMills, maxTimeoutMills, options);
    }
  }
}
