package com.sinch.sdk.domains.verification.models.webhooks;

import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.VerificationMethodType;
import com.sinch.sdk.domains.verification.models.VerificationReference;
import com.sinch.sdk.domains.verification.models.VerificationSourceType;
import com.sinch.sdk.domains.verification.models.VerificationStatusReasonType;
import com.sinch.sdk.domains.verification.models.VerificationStatusType;
import java.util.Optional;

/**
 * This event is received onto a POST request to the specified verification callback URL and
 * triggered when a verification has been completed and the result is known. It's used to report the
 * verification result to the developer's backend application. This callback event is only triggered
 * when the verification callback URL is specified in your dashboard.
 */
public class VerificationResultEvent extends VerificationEvent {

  private final VerificationStatusType status;
  private final VerificationStatusReasonType reason;
  private final VerificationSourceType source;

  public VerificationResultEvent(
      String id,
      VerificationMethodType method,
      Identity identity,
      VerificationReference reference,
      String custom,
      VerificationStatusType status,
      VerificationStatusReasonType reason,
      VerificationSourceType source) {
    super(id, method, identity, reference, custom);

    this.status = status;
    this.reason = reason;
    this.source = source;
  }

  /**
   * The status of the verification request
   *
   * @return Status value
   * @since 1.0
   */
  public VerificationStatusType getStatus() {
    return status;
  }

  /**
   * Displays the reason why a verification has FAILED, was DENIED, or was ABORTED
   *
   * @return reason value
   * @since 1.0
   */
  public Optional<VerificationStatusReasonType> getReason() {
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
