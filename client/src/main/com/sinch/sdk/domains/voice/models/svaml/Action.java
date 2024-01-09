package com.sinch.sdk.domains.voice.models.svaml;

public abstract class Action {

  @Override
  public String toString() {
    return "";
  }

  public abstract static class Builder<B extends Builder<B>> {

    public abstract Action build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
