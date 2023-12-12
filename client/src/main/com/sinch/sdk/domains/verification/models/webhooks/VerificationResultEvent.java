package com.sinch.sdk.domains.verification.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinch.sdk.domains.verification.models.VerificationReportReasonType;
import com.sinch.sdk.domains.verification.models.VerificationReportStatusType;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import java.util.Optional;

public class VerificationResultEvent extends VerificationEvent {

  private final VerificationReportStatusType status;
  private final VerificationReportReasonType reason;
  private final VerificationSourceType source;

  /**
   * This event is a POST request to the specified verification callback URL and triggered when a verification has been completed and the result is known. It's used to report the verification result to the developer's backend application. This callback event is only triggered when the verification callback URL is specified in your dashboard.
   * @param id The ID of the verification request.
   * @param event The type of the event.
   * @param method The verification method
   * @param identity Specifies the type of endpoint that will be verified and the particular endpoint. number is currently the only supported endpoint type
   * @param reference The reference ID that was optionally passed together with the verification request
   * @param custom A custom string that can be provided during a verification request.
   * @param status The status of the verification request
   * @param reason Displays the reason why a verification has FAILED, was DENIED, or was ABORTED
   * @param source Free text that the client is sending, used to show if the call/SMS was intercepted or not.
   *     see <a href="https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationResultEvent/post">https://developers.sinch.com/docs/verification/api-reference/verification/tag/Verification-callbacks/#tag/Verification-callbacks/paths/VerificationResultEvent/post</a>
   *       @since 1.0
   */
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

  public VerificationReportStatusType getStatus() {
    return status;
  }

  public Optional<VerificationReportReasonType> getReason() {
    return Optional.ofNullable(reason);
  }

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
