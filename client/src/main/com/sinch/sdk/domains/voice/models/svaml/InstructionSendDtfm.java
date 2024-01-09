package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.models.DualToneMultiFrequency;

public class InstructionSendDtfm extends Instruction {

  private final DualToneMultiFrequency dtfm;

  private InstructionSendDtfm(DualToneMultiFrequency dtfm) {
    this.dtfm = dtfm;
  }

  public DualToneMultiFrequency getTDtfm() {
    return dtfm;
  }

  @Override
  public String toString() {
    return "InstructionSendDtfm{" + "dtfm=" + dtfm + "} " + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    DualToneMultiFrequency dtfm;

    public Builder<B> setDtfm(DualToneMultiFrequency dtfm) {
      this.dtfm = dtfm;
      return this;
    }

    public InstructionSendDtfm build() {
      return new InstructionSendDtfm(dtfm);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
