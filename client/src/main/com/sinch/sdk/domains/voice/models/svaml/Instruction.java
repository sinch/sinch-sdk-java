package com.sinch.sdk.domains.voice.models.svaml;

public abstract class Instruction {

  @Override
  public String toString() {
    return "";
  }

  public abstract static class Builder<B extends Builder<B>> {

    public abstract Instruction build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
