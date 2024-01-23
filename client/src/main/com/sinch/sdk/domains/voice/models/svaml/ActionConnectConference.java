package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.MohClassType;

public class ActionConnectConference extends Action {

  private final OptionalValue<String> conferenceId;
  private final OptionalValue<ConferenceDtfmOptions> dtfmOptions;
  private final OptionalValue<MohClassType> moh;

  private ActionConnectConference(
      OptionalValue<String> conferenceId,
      OptionalValue<ConferenceDtfmOptions> dtfmOptions,
      OptionalValue<MohClassType> moh) {
    this.conferenceId = conferenceId;
    this.dtfmOptions = dtfmOptions;
    this.moh = moh;
  }

  public OptionalValue<String> getConferenceId() {
    return conferenceId;
  }

  public OptionalValue<ConferenceDtfmOptions> getDtfmOptions() {
    return dtfmOptions;
  }

  public OptionalValue<MohClassType> getMoh() {
    return moh;
  }

  @Override
  public String toString() {
    return "ActionConnectConference{"
        + "conferenceId='"
        + conferenceId
        + '\''
        + ", dtfmOptions="
        + dtfmOptions
        + ", moh="
        + moh
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<String> conferenceId = OptionalValue.empty();
    OptionalValue<ConferenceDtfmOptions> dtfmOptions = OptionalValue.empty();
    OptionalValue<MohClassType> moh = OptionalValue.empty();

    public Builder<B> setConferenceId(String conferenceId) {
      this.conferenceId = OptionalValue.of(conferenceId);
      return this;
    }

    public Builder<B> setDtfmOptions(ConferenceDtfmOptions dtfmOptions) {
      this.dtfmOptions = OptionalValue.of(dtfmOptions);
      return this;
    }

    public Builder<B> setMoh(MohClassType moh) {
      this.moh = OptionalValue.of(moh);
      return this;
    }

    public ActionConnectConference build() {
      return new ActionConnectConference(conferenceId, dtfmOptions, moh);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
