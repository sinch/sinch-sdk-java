package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;

public class TranscriptionOptions {

  private final OptionalValue<Boolean> enabled;
  private final OptionalValue<String> locale;

  private TranscriptionOptions(OptionalValue<Boolean> enabled, OptionalValue<String> locale) {
    this.enabled = enabled;
    this.locale = locale;
  }

  public OptionalValue<Boolean> getEnabled() {
    return enabled;
  }

  public OptionalValue<String> getLocale() {
    return locale;
  }

  @Override
  public String toString() {
    return "TranscriptionOptions{" + "enabled=" + enabled + ", locale='" + locale + '\'' + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    OptionalValue<Boolean> enabled = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();

    public Builder setEnabled(Boolean enabled) {
      this.enabled = OptionalValue.of(enabled);
      return this;
    }

    public Builder setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
      return this;
    }

    public TranscriptionOptions build() {
      return new TranscriptionOptions(enabled, locale);
    }
  }
}
