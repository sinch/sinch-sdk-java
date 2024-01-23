package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;

public class InstructionSay extends Instruction {

  private final OptionalValue<String> text;
  private final OptionalValue<String> locale;

  private InstructionSay(OptionalValue<String> text, OptionalValue<String> locale) {
    this.text = text;
    this.locale = locale;
  }

  public OptionalValue<String> getText() {
    return text;
  }

  public OptionalValue<String> getLocale() {
    return locale;
  }

  @Override
  public String toString() {
    return "InstructionSay{"
        + "text="
        + text
        + ", locale='"
        + locale
        + '\''
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<String> text = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();

    public Builder<B> setText(String text) {
      this.text = OptionalValue.of(text);
      return this;
    }

    public Builder<B> setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    public InstructionSay build() {
      return new InstructionSay(text, locale);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
