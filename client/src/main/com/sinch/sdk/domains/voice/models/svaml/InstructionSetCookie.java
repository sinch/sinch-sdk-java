package com.sinch.sdk.domains.voice.models.svaml;

import java.util.Objects;

public class InstructionSetCookie extends Instruction {

  private final String key;
  private final String value;

  private InstructionSetCookie(String key, String value) {
    Objects.requireNonNull(key, "Key cannot be null");
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
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

    String key ;
    String value ;

    public Builder<B> setKey(String key) {
      this.key = key;
      return this;
    }

    public Builder<B> setValue(String value) {
      this.value = value;
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
