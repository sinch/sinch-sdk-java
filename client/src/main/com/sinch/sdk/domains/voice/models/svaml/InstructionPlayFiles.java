package com.sinch.sdk.domains.voice.models.svaml;

import java.util.Collection;

public class InstructionPlayFiles extends Instruction {

  private final Collection<String> ids;
  private final String locale;

  private InstructionPlayFiles(Collection<String> ids, String locale) {
    this.ids = ids;
    this.locale = locale;
  }

  public Collection<String> getIds() {
    return ids;
  }

  public String getLocale() {
    return locale;
  }

  @Override
  public String toString() {
    return "InstructionPlayFiles{"
        + "ids="
        + ids
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

    Collection<String> ids;
    String locale;

    public Builder<B> setIds(Collection<String> ids) {
      this.ids = ids;
      return this;
    }

    public Builder<B> setLocale(String locale) {
      this.locale = locale;
      return this;
    }

    public InstructionPlayFiles build() {
      return new InstructionPlayFiles(ids, locale);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
