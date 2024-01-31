package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.ConferenceDtfmOptions;
import com.sinch.sdk.domains.voice.models.MusicOnHoldType;

public class ActionConnectConference extends Action {

  private final OptionalValue<String> conferenceId;
  private final OptionalValue<ConferenceDtfmOptions> dtfmOptions;
  private final OptionalValue<MusicOnHoldType> musicOnHold;

  private ActionConnectConference(
      OptionalValue<String> conferenceId,
      OptionalValue<ConferenceDtfmOptions> dtfmOptions,
      OptionalValue<MusicOnHoldType> musicOnHold) {
    this.conferenceId = conferenceId;
    this.dtfmOptions = dtfmOptions;
    this.musicOnHold = musicOnHold;
  }

  public OptionalValue<String> getConferenceId() {
    return conferenceId;
  }

  public OptionalValue<ConferenceDtfmOptions> getDtfmOptions() {
    return dtfmOptions;
  }

  public OptionalValue<MusicOnHoldType> getMusicOnHold() {
    return musicOnHold;
  }

  @Override
  public String toString() {
    return "ActionConnectConference{"
        + "conferenceId='"
        + conferenceId
        + '\''
        + ", dtfmOptions="
        + dtfmOptions
        + ", musicOnHold="
        + musicOnHold
        + "} "
        + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<String> conferenceId = OptionalValue.empty();
    OptionalValue<ConferenceDtfmOptions> dtfmOptions = OptionalValue.empty();
    OptionalValue<MusicOnHoldType> musicOnHold = OptionalValue.empty();

    public Builder<B> setConferenceId(String conferenceId) {
      this.conferenceId = OptionalValue.of(conferenceId);
      return this;
    }

    public Builder<B> setDtfmOptions(ConferenceDtfmOptions dtfmOptions) {
      this.dtfmOptions = OptionalValue.of(dtfmOptions);
      return this;
    }

    public Builder<B> setMusicOnHold(MusicOnHoldType musicOnHold) {
      this.musicOnHold = OptionalValue.of(musicOnHold);
      return this;
    }

    public ActionConnectConference build() {
      return new ActionConnectConference(conferenceId, dtfmOptions, musicOnHold);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
