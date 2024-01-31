package com.sinch.sdk.domains.voice.models.svaml;

/** Base class for SVAML Action */
public abstract class Action {

  @Override
  public String toString() {
    return "";
  }

  public abstract static class Builder<B extends Builder<B>> {

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public abstract Action build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
