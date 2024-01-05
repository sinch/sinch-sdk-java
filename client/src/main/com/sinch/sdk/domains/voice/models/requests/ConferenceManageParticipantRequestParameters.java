package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.core.models.OptionalValue;

/** Use to configure conference participant settings */
public class ConferenceManageParticipantRequestParameters {

  private final OptionalValue<ConferenceManageParticipantCommandType> command;
  private final OptionalValue<MohClassType> moh;

  private ConferenceManageParticipantRequestParameters(
      OptionalValue<ConferenceManageParticipantCommandType> command,
      OptionalValue<MohClassType> moh) {
    this.command = command;
    this.moh = moh;
  }

  public OptionalValue<ConferenceManageParticipantCommandType> getCommand() {
    return command;
  }

  public OptionalValue<MohClassType> getMoh() {
    return moh;
  }

  @Override
  public String toString() {
    return "ConferenceManageParticipantRequestParameters{"
        + "command="
        + command
        + ", moh="
        + moh
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    OptionalValue<ConferenceManageParticipantCommandType> command = OptionalValue.empty();
    OptionalValue<MohClassType> moh = OptionalValue.empty();

    /**
     * @param command Action to apply on conference participant.
     * @return current builder
     */
    public Builder setCommand(ConferenceManageParticipantCommandType command) {
      this.command = OptionalValue.of(command);
      return this;
    }

    /**
     * @param moh Means "music on hold". If this optional parameter is included, plays music to the
     *     first participant in a conference while they're alone and waiting for other participants
     *     to join. If moh isn't specified, the user will only hear silence while alone in the
     *     conference. This property is only available to use with the onhold command.
     * @return current builder
     */
    public Builder setMoh(MohClassType moh) {
      this.moh = OptionalValue.of(moh);
      return this;
    }

    public ConferenceManageParticipantRequestParameters build() {
      return new ConferenceManageParticipantRequestParameters(command, moh);
    }
  }
}
