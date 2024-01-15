package com.sinch.sdk.domains.voice.models.svaml;

public class TranscriptionOptions {

  private final Boolean enabled;
  private final String locale;

  private TranscriptionOptions(Boolean enabled, String locale) {
    this.enabled = enabled;
    this.locale = locale;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public String getLocale() {
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

    Boolean enabled;
    String locale;

    public Builder setEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    public Builder setLocale(String locale) {
      this.locale = locale;
      return this;
    }

    public TranscriptionOptions build() {
      return new TranscriptionOptions(enabled, locale);
    }
  }
}
