package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.MohClassType;

public class ActionConnectConference extends Action {

  private final String conferenceId;
  private final ConferenceDtfmOptions dtfmOptions;
  private final MohClassType moh;

  private ActionConnectConference(
      String conferenceId, ConferenceDtfmOptions dtfmOptions, MohClassType moh) {
    this.conferenceId = conferenceId;
    this.dtfmOptions = dtfmOptions;
    this.moh = moh;
  }

  public String getConferenceId() {
    return conferenceId;
  }

  public ConferenceDtfmOptions getDtfmOptions() {
    return dtfmOptions;
  }

  public MohClassType getMoh() {
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

    String conferenceId;
    ConferenceDtfmOptions dtfmOptions;
    MohClassType moh;

    public Builder<B> setConferenceId(String conferenceId) {
      this.conferenceId = conferenceId;
      return this;
    }

    public Builder<B> setDtfmOptions(ConferenceDtfmOptions dtfmOptions) {
      this.dtfmOptions = dtfmOptions;
      return this;
    }

    public Builder<B> setMoh(MohClassType moh) {
      this.moh = moh;
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
