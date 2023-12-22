package com.sinch.sdk.domains.voice.models.requests;

import java.util.Optional;

/** Use to configure conference participant settings */
public class ConferenceManageParticipantRequestParameters {

  private final ConferenceManageParticipantCommandType command;
  private final MohClassType moh;

  private ConferenceManageParticipantRequestParameters(
      ConferenceManageParticipantCommandType command, MohClassType moh) {
    this.command = command;
    this.moh = moh;
  }

  public Optional<ConferenceManageParticipantCommandType> getCommand() {
    return Optional.ofNullable(command);
  }

  public Optional<MohClassType> getMoh() {
    return Optional.ofNullable(moh);
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

    ConferenceManageParticipantCommandType command;
    MohClassType moh;

    /**
     * @param command Action to apply on conference participant.
     * @return current builder
     */
    public Builder setCommand(ConferenceManageParticipantCommandType command) {
      this.command = command;
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
      this.moh = moh;
      return this;
    }

    public ConferenceManageParticipantRequestParameters build() {
      return new ConferenceManageParticipantRequestParameters(command, moh);
    }
  }
}
