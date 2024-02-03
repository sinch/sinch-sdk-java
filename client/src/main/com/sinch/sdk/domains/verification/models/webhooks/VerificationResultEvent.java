package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinch.sdk.domains.verification.models.VerificationReportReasonType;
import com.sinch.sdk.domains.verification.models.VerificationReportStatusType;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import java.util.Optional;

/**
 * This event is received onto a POST request to the specified verification callback URL and
 * triggered when a verification has been completed and the result is known. It's used to report the
 * verification result to the developer's backend application. This callback event is only triggered
 * when the verification callback URL is specified in your dashboard.
 */
public class VerificationResultEvent extends VerificationEvent {

  private final VerificationReportStatusType status;
  private final VerificationReportReasonType reason;
  private final VerificationSourceType source;

  @JsonCreator
  VerificationResultEvent(
      @JsonProperty("id") String id,
      @JsonProperty("event") String event,
      @JsonProperty("method") String method,
      @JsonProperty("identity") jsonIdentity identity,
      @JsonProperty("reference") String reference,
      @JsonProperty("custom") String custom,
      @JsonProperty("status") String status,
      @JsonProperty("reason") String reason,
      @JsonProperty("source") String source) {
    super(id, event, method, identity, reference, custom);

    this.status = VerificationReportStatusType.from(status);
    this.reason = null != reason ? VerificationReportReasonType.from(reason) : null;
    this.source = null != source ? VerificationSourceType.from(source) : null;
  }

  /**
   * The status of the verification request
   *
   * @return Status value
   * @since 1.0
   */
  public VerificationReportStatusType getStatus() {
    return status;
  }

  /**
   * Displays the reason why a verification has FAILED, was DENIED, or was ABORTED
   *
   * @return reason value
   * @since 1.0
   */
  public Optional<VerificationReportReasonType> getReason() {
    return Optional.ofNullable(reason);
  }

  /**
   * Used to show if the call/SMS was intercepted or not
   *
   * @return Type value
   * @since 1.0
   */
  public Optional<VerificationSourceType> getSource() {
    return Optional.ofNullable(source);
  }

  @Override
  public String toString() {
    return "VerificationResultEvent{"
        + "status="
        + status
        + ", reason="
        + reason
        + ", source='"
        + source
        + '\''
        + "} "
        + super.toString();
  }
}
