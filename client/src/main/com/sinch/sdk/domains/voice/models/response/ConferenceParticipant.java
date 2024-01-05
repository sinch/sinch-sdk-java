package com.sinch.sdk.domains.voice.models.response;

import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParameters.Builder;

public class ConferenceParticipant {
  private final String cli;
  private final String id;
  private final Integer duration;
  private final Boolean muted;
  private final Boolean onhold;

  private ConferenceParticipant(
      String cli, String id, Integer duration, Boolean muted, Boolean onhold) {
    this.cli = cli;
    this.id = id;
    this.duration = duration;
    this.muted = muted;
    this.onhold = onhold;
  }

  public String getCli() {
    return cli;
  }

  public String getId() {
    return id;
  }

  public Integer getDuration() {
    return duration;
  }

  public Boolean getMuted() {
    return muted;
  }

  public Boolean getOnhold() {
    return onhold;
  }

  @Override
  public String toString() {
    return "ConferenceParticipant{"
        + "cli='"
        + cli
        + '\''
        + ", id='"
        + id
        + '\''
        + ", duration="
        + duration
        + ", muted="
        + muted
        + ", onhold="
        + onhold
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    String cli;
    String id;
    Integer duration;
    Boolean muted;
    Boolean onhold;

    /**
     * @param cli The phone number of the PSTN participant that was connected in the conference, or
     *     whatever was passed as CLI for data originated/terminated calls.
     * @return current builder
     */
    public Builder setCli(String cli) {
      this.cli = cli;
      return this;
    }

    /**
     * @param id The callId of the call leg that the participant joined the conference.
     * @return current builder
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * @param duration The number of seconds that the participant has been connected to the
     *     conference.
     * @return current builder
     */
    public Builder setDuration(Integer duration) {
      this.duration = duration;
      return this;
    }

    /**
     * @param muted Is participant is muted
     * @return current builder
     */
    public Builder setMuted(Boolean muted) {
      this.muted = muted;
      return this;
    }

    /**
     * @param onhold Is participant is on-hold
     * @return current builder
     */
    public Builder setOnhold(Boolean onhold) {
      this.onhold = onhold;
      return this;
    }

    public ConferenceParticipant build() {
      return new ConferenceParticipant(cli, id, duration, muted, onhold);
    }
  }
}
