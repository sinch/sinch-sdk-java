package com.sinch.sdk.domains.voice.models.response;

/** Information about a conference's participant */
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

  /**
   * The phone number of the PSTN participant that was connected in the conference, or whatever was
   * passed as CLI for data originated/terminated calls.
   *
   * @return The value
   */
  public String getCli() {
    return cli;
  }

  /**
   * The callId of the call leg that the participant joined the conference.
   *
   * @return Uniq identifier related toi the call
   */
  public String getId() {
    return id;
  }

  /**
   * The number of seconds that the participant has been connected to the conference
   *
   * @return Duration value
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * Is participant is muted or not
   *
   * @return Muted state
   */
  public Boolean getMuted() {
    return muted;
  }

  /**
   * Is participant is on hold or not
   *
   * @return The on hold state
   */
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

  /**
   * Create a builder instance
   *
   * @return Dedicated builder
   */
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
     * @see ConferenceParticipant#getCli() getter
     * @return Current builder
     */
    public Builder setCli(String cli) {
      this.cli = cli;
      return this;
    }

    /**
     * @see ConferenceParticipant#getId() getter
     * @return Current builder
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * @see ConferenceParticipant#getDuration() getter
     * @return Current builder
     */
    public Builder setDuration(Integer duration) {
      this.duration = duration;
      return this;
    }

    /**
     * @see ConferenceParticipant#getMuted() getter
     * @return Current builder
     */
    public Builder setMuted(Boolean muted) {
      this.muted = muted;
      return this;
    }

    /**
     * @see ConferenceParticipant#getOnhold() getter
     * @return Current builder
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
