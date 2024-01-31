package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.MusicOnHoldType;

/** Use to configure conference participant settings */
public class ConferenceManageParticipantRequestParameters {

  private final OptionalValue<ConferenceManageParticipantCommandType> command;
  private final OptionalValue<MusicOnHoldType> musicOnHold;

  private ConferenceManageParticipantRequestParameters(
      OptionalValue<ConferenceManageParticipantCommandType> command,
      OptionalValue<MusicOnHoldType> musicOnHold) {
    this.command = command;
    this.musicOnHold = musicOnHold;
  }

  /**
   * @see Builder#setCommand(ConferenceManageParticipantCommandType)
   */
  public OptionalValue<ConferenceManageParticipantCommandType> getCommand() {
    return command;
  }

  /**
   * @see Builder#setMusicOnHold(MusicOnHoldType) (MusicOnHoldType)
   */
  public OptionalValue<MusicOnHoldType> getMusicOnHold() {
    return musicOnHold;
  }

  @Override
  public String toString() {
    return "ConferenceManageParticipantRequestParameters{"
        + "command="
        + command
        + ", musicOnHold="
        + musicOnHold
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    OptionalValue<ConferenceManageParticipantCommandType> command = OptionalValue.empty();
    OptionalValue<MusicOnHoldType> musicOnHold = OptionalValue.empty();

    /**
     * @param command Action to apply on conference participant.
     * @return current builder
     */
    public Builder setCommand(ConferenceManageParticipantCommandType command) {
      this.command = OptionalValue.of(command);
      return this;
    }

    /**
     * @param musicOnHold If this optional parameter is included, plays music to the first
     *     participant in a conference while they're alone and waiting for other participants to
     *     join. If musicOnHold isn't specified, the user will only hear silence while alone in the
     *     conference. This property is only available to use with the onhold command.
     * @return current builder
     */
    public Builder setMusicOnHold(MusicOnHoldType musicOnHold) {
      this.musicOnHold = OptionalValue.of(musicOnHold);
      return this;
    }

    public ConferenceManageParticipantRequestParameters build() {
      return new ConferenceManageParticipantRequestParameters(command, musicOnHold);
    }
  }
}
