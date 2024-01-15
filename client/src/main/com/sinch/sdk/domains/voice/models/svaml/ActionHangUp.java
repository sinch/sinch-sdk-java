package com.sinch.sdk.domains.voice.models.svaml;

public class ActionHangUp extends Action {

  private ActionHangUp() {}

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    public ActionHangUp build() {
      return new ActionHangUp();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
