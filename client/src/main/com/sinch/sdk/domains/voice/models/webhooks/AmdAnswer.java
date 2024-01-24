package com.sinch.sdk.domains.voice.models.webhooks;

/**
 * If Answering Machine Detection (see <a
 * href="https://developers.sinch.com/docs/voice/api-reference/amd_v2/">AMD</a>) is enabled, this
 * object contains information about whether the call was answered by a machine.
 */
public class AmdAnswer {

  private final AmdAnswerStatusType status;
  private final AmdAnswerReasonType reason;
  private final Integer duration;

  private AmdAnswer(AmdAnswerStatusType status, AmdAnswerReasonType reason, Integer duration) {
    this.status = status;
    this.reason = reason;
    this.duration = duration;
  }

  /**
   * Get the status
   *
   * @return Status value
   */
  public AmdAnswerStatusType getStatus() {
    return status;
  }

  /**
   * Get the reason
   *
   * @return Reason value
   */
  public AmdAnswerReasonType getReason() {
    return reason;
  }

  /**
   * Get the length of the call
   *
   * @return Call length
   */
  public Integer getDuration() {
    return duration;
  }

  @Override
  public String toString() {
    return "AmdAnswer{"
        + "status="
        + status
        + ", reason="
        + reason
        + ", duration="
        + duration
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    AmdAnswerStatusType status;
    AmdAnswerReasonType reason;
    Integer duration;

    public Builder setStatus(AmdAnswerStatusType status) {
      this.status = status;
      return this;
    }

    public Builder setReason(AmdAnswerReasonType reason) {
      this.reason = reason;
      return this;
    }

    public Builder setDuration(Integer duration) {
      this.duration = duration;
      return this;
    }

    public AmdAnswer build() {
      return new AmdAnswer(status, reason, duration);
    }
  }
}
