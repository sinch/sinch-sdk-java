package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;

public class ActionPark extends Action {

  private final OptionalValue<String> locale;
  private final OptionalValue<String> introPrompt;
  private final OptionalValue<String> holdPrompt;
  private final OptionalValue<Integer> maxDuration;

  private ActionPark(
      OptionalValue<String> locale,
      OptionalValue<String> introPrompt,
      OptionalValue<String> holdPrompt,
      OptionalValue<Integer> maxDuration) {
    this.locale = locale;
    this.introPrompt = introPrompt;
    this.holdPrompt = holdPrompt;
    this.maxDuration = maxDuration;
  }

  public OptionalValue<String> getLocale() {
    return locale;
  }

  public OptionalValue<String> getIntroPrompt() {
    return introPrompt;
  }

  public OptionalValue<String> getHoldPrompt() {
    return holdPrompt;
  }

  public OptionalValue<Integer> getMaxDuration() {
    return maxDuration;
  }

  @Override
  public String toString() {
    return "ActionPark{"
        + "locale='"
        + locale
        + '\''
        + ", introPrompt='"
        + introPrompt
        + '\''
        + ", holdPrompt='"
        + holdPrompt
        + '\''
        + ", maxDuration="
        + maxDuration
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<String> locale = OptionalValue.empty();
    OptionalValue<String> introPrompt = OptionalValue.empty();
    OptionalValue<String> holdPrompt = OptionalValue.empty();
    OptionalValue<Integer> maxDuration = OptionalValue.empty();

    public Builder<B> setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    public Builder<B> setIntroPrompt(String introPrompt) {
      this.introPrompt = OptionalValue.of(introPrompt);
      return this;
    }

    public Builder<B> setHoldPrompt(String holdPrompt) {
      this.holdPrompt = OptionalValue.of(holdPrompt);
      return this;
    }

    public Builder<B> setMaxDuration(Integer maxDuration) {
      this.maxDuration = OptionalValue.of(maxDuration);
      return this;
    }

    public ActionPark build() {
      return new ActionPark(locale, introPrompt, holdPrompt, maxDuration);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
