package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Collection;

public class Menu {

  private final OptionalValue<String> id;
  private final OptionalValue<String> mainPrompt;
  private final OptionalValue<String> repeatPrompt;
  private final OptionalValue<Integer> repeats;
  private final OptionalValue<Integer> maxDigits;
  private final OptionalValue<Integer> timeoutMills;
  private final OptionalValue<Integer> maxTimeoutMills;
  private final OptionalValue<Collection<MenuOption>> options;

  private Menu(
      OptionalValue<String> id,
      OptionalValue<String> mainPrompt,
      OptionalValue<String> repeatPrompt,
      OptionalValue<Integer> repeats,
      OptionalValue<Integer> maxDigits,
      OptionalValue<Integer> timeoutMills,
      OptionalValue<Integer> maxTimeoutMills,
      OptionalValue<Collection<MenuOption>> options) {
    this.id = id;
    this.mainPrompt = mainPrompt;
    this.repeatPrompt = repeatPrompt;
    this.repeats = repeats;
    this.maxDigits = maxDigits;
    this.timeoutMills = timeoutMills;
    this.maxTimeoutMills = maxTimeoutMills;
    this.options = options;
  }

  public OptionalValue<String> getId() {
    return id;
  }

  public OptionalValue<String> getMainPrompt() {
    return mainPrompt;
  }

  public OptionalValue<String> getRepeatPrompt() {
    return repeatPrompt;
  }

  public OptionalValue<Integer> getRepeats() {
    return repeats;
  }

  public OptionalValue<Integer> getMaxDigits() {
    return maxDigits;
  }

  public OptionalValue<Integer> getTimeoutMills() {
    return timeoutMills;
  }

  public OptionalValue<Integer> getMaxTimeoutMills() {
    return maxTimeoutMills;
  }

  public OptionalValue<Collection<MenuOption>> getOptions() {
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

    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> mainPrompt = OptionalValue.empty();
    OptionalValue<String> repeatPrompt = OptionalValue.empty();
    OptionalValue<Integer> repeats = OptionalValue.empty();
    OptionalValue<Integer> maxDigits = OptionalValue.empty();
    OptionalValue<Integer> timeoutMills = OptionalValue.empty();
    OptionalValue<Integer> maxTimeoutMills = OptionalValue.empty();
    OptionalValue<Collection<MenuOption>> options = OptionalValue.empty();

    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    public Builder setMainPrompt(String mainPrompt) {
      this.mainPrompt = OptionalValue.of(mainPrompt);
      return this;
    }

    public Builder setRepeatPrompt(String repeatPrompt) {
      this.repeatPrompt = OptionalValue.of(repeatPrompt);
      return this;
    }

    public Builder setRepeats(Integer repeats) {
      this.repeats = OptionalValue.of(repeats);
      return this;
    }

    public Builder setMaxDigits(Integer maxDigits) {
      this.maxDigits = OptionalValue.of(maxDigits);
      return this;
    }

    public Builder setTimeoutMills(Integer timeoutMills) {
      this.timeoutMills = OptionalValue.of(timeoutMills);
      return this;
    }

    public Builder setMaxTimeoutMills(Integer maxTimeoutMills) {
      this.maxTimeoutMills = OptionalValue.of(maxTimeoutMills);
      return this;
    }

    public Builder setOptions(Collection<MenuOption> options) {
      this.options = OptionalValue.of(options);
      return this;
    }

    public Menu build() {
      return new Menu(
          id, mainPrompt, repeatPrompt, repeats, maxDigits, timeoutMills, maxTimeoutMills, options);
    }
  }
}
