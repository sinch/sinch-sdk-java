package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.models.DualToneMultiFrequency;

public class InstructionSendDtfm extends Instruction {

  private final OptionalValue<DualToneMultiFrequency> dtfm;

  private InstructionSendDtfm(OptionalValue<DualToneMultiFrequency> dtfm) {
    this.dtfm = dtfm;
  }

  public OptionalValue<DualToneMultiFrequency> getTDtfm() {
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

    OptionalValue<DualToneMultiFrequency> dtfm = OptionalValue.empty();

    public Builder<B> setDtfm(DualToneMultiFrequency dtfm) {
      this.dtfm = OptionalValue.of(dtfm);
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
