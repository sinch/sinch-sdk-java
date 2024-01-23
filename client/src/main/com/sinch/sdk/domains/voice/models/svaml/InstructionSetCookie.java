package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;

public class InstructionSetCookie extends Instruction {

  private final OptionalValue<String> key;
  private final OptionalValue<String> value;

  private InstructionSetCookie(OptionalValue<String> key, OptionalValue<String> value) {
    this.key = key;
    this.value = value;
  }

  public OptionalValue<String> getKey() {
    return key;
  }

  public OptionalValue<String> getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "InstructionSetCookie{"
        + "key='"
        + key
        + '\''
        + ", value='"
        + value
        + '\''
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<String> key = OptionalValue.empty();
    OptionalValue<String> value = OptionalValue.empty();

    public Builder<B> setKey(String key) {
      this.key = OptionalValue.of(key);
      return this;
    }

    public Builder<B> setValue(String value) {
      this.value = OptionalValue.of(value);
      return this;
    }

    public InstructionSetCookie build() {
      return new InstructionSetCookie(key, value);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
