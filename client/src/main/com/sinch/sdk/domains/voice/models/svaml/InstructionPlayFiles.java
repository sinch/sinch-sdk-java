package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import java.util.Collection;

public class InstructionPlayFiles extends Instruction {

  private final OptionalValue<Collection<String>> ids;
  private final OptionalValue<String> locale;

  private InstructionPlayFiles(
      OptionalValue<Collection<String>> ids, OptionalValue<String> locale) {
    this.ids = ids;
    this.locale = locale;
  }

  public OptionalValue<Collection<String>> getIds() {
    return ids;
  }

  public OptionalValue<String> getLocale() {
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

    OptionalValue<Collection<String>> ids = OptionalValue.empty();
    OptionalValue<String> locale = OptionalValue.empty();

    public Builder<B> setIds(Collection<String> ids) {
      this.ids = OptionalValue.of(ids);
      return this;
    }

    public Builder<B> setLocale(String locale) {
      this.locale = OptionalValue.of(locale);
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
