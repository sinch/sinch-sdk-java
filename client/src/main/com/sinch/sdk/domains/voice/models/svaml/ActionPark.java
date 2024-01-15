package com.sinch.sdk.domains.voice.models.svaml;

public class ActionPark extends Action {

  private final String locale;
  private final String introPrompt;
  private final String holdPrompt;
  private final Integer maxDuration;

  private ActionPark(String locale, String introPrompt, String holdPrompt, Integer maxDuration) {
    this.locale = locale;
    this.introPrompt = introPrompt;
    this.holdPrompt = holdPrompt;
    this.maxDuration = maxDuration;
  }

  public String getLocale() {
    return locale;
  }

  public String getIntroPrompt() {
    return introPrompt;
  }

  public String getHoldPrompt() {
    return holdPrompt;
  }

  public Integer getMaxDuration() {
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

    String locale;
    String introPrompt;
    String holdPrompt;
    Integer maxDuration;

    public Builder<B> setLocale(String locale) {
      this.locale = locale;
      return this;
    }

    public Builder<B> setIntroPrompt(String introPrompt) {
      this.introPrompt = introPrompt;
      return this;
    }

    public Builder<B> setHoldPrompt(String holdPrompt) {
      this.holdPrompt = holdPrompt;
      return this;
    }

    public Builder<B> setMaxDuration(Integer maxDuration) {
      this.maxDuration = maxDuration;
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
