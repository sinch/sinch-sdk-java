package com.sinch.sdk.domains.voice.models.svaml;

public class InstructionSay extends Instruction {

  private final String text;
  private final String locale;

  private InstructionSay(String text, String locale) {
    this.text = text;
    this.locale = locale;
  }

  public String getText() {
    return text;
  }

  public String getLocale() {
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

    String text;
    String locale;

    public Builder<B> setText(String text) {
      this.text = text;
      return this;
    }

    public Builder<B> setLocale(String locale) {
      this.locale = locale;
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
