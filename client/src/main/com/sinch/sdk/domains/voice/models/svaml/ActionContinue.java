package com.sinch.sdk.domains.voice.models.svaml;

public class ActionContinue extends Action {

  private ActionContinue() {}

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    public ActionContinue build() {
      return new ActionContinue();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
