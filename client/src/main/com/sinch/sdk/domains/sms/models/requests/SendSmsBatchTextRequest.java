package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.Parameters;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

public class SendSmsBatchTextRequest extends BaseBatch<String> {
  private final Boolean flashMessage;
  private final Parameters parameters;
  private final Boolean truncateConcat;
  private final Integer maxNumberOfMessageParts;
  private final Integer fromTon;
  private final Integer fromNpi;

  /**
   * @param to List of Phone numbers and group IDs that will receive the batch
   * @param from Sender number. Must be valid phone number, short code or alphanumeric. Required if
   *     Automatic Default Originator not configured.
   * @param body The message content
   * @param deliveryReport Request delivery report callback. Note that delivery reports can be
   *     fetched from the API regardless of this setting
   * @param sendAt If set in the future, the message will be delayed until send_at occurs. Must be
   *     before expire_at. If set in the past, messages will be sent immediately
   * @param expireAt If set, the system will stop trying to deliver the message at this point. Must
   *     be after send_at. Default and max is 3 days after send_at
   * @param callbackUrl Override the default callback URL for this batch. Must be valid URL.
   * @param clientReference The client identifier of a batch message. If set, the identifier will be
   *     added in the delivery report/callback of this batch
   * @param feedbackEnabled If set to true, then feedback is expected after successful delivery.
   * @param parameters Contains the parameters that will be used for customizing the message for
   *     each recipient.
   * @param flashMessage If sent as a flash message, displays true.
   * @param truncateConcat If set to true, the message was shortened when exceeding one part.
   * @param maxNumberOfMessageParts Displays the number of message parts set in the request.
   * @param fromTon The type of number for the sender number.
   * @param fromNpi Number Plan Indicator for the sender number.
   */
  public SendSmsBatchTextRequest(
      Collection<String> to,
      String from,
      String body,
      DeliveryReportType deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl,
      String clientReference,
      Boolean flashMessage,
      Boolean feedbackEnabled,
      Parameters parameters,
      Boolean truncateConcat,
      Integer maxNumberOfMessageParts,
      Integer fromTon,
      Integer fromNpi) {
    super(
        to,
        from,
        body,
        deliveryReport,
        sendAt,
        expireAt,
        callbackUrl,
        clientReference,
        feedbackEnabled);
    this.flashMessage = flashMessage;
    this.parameters = parameters;
    this.truncateConcat = truncateConcat;
    this.maxNumberOfMessageParts = maxNumberOfMessageParts;
    this.fromTon = fromTon;
    this.fromNpi = fromNpi;
  }

  public Optional<Parameters> getParameters() {
    return Optional.ofNullable(parameters);
  }

  public Optional<Boolean> isFlashMessage() {
    return Optional.ofNullable(flashMessage);
  }

  public Optional<Boolean> isTruncateConcat() {
    return Optional.ofNullable(truncateConcat);
  }

  public Optional<Integer> getMaxNumberOfMessageParts() {
    return Optional.ofNullable(maxNumberOfMessageParts);
  }

  public Optional<Integer> getFromTon() {
    return Optional.ofNullable(fromTon);
  }

  public Optional<Integer> getFromNpi() {
    return Optional.ofNullable(fromNpi);
  }

  @Override
  public String toString() {
    return "SendSmsBatchTextRequest{"
        + "flashMessage="
        + flashMessage
        + ", parameters="
        + parameters
        + ", truncateConcat="
        + truncateConcat
        + ", maxNumberOfMessageParts="
        + maxNumberOfMessageParts
        + ", fromTon="
        + fromTon
        + ", fromNpi="
        + fromNpi
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends BaseBatch.Builder<String, Builder> {
    private Boolean flashMessage;
    private Parameters parameters;
    private Boolean truncateConcat;
    private Integer maxNumberOfMessageParts;
    private Integer fromTon;
    private Integer fromNpi;

    private Builder() {}

    public Builder setFlashMessage(boolean flashMessage) {
      this.flashMessage = flashMessage;
      return this;
    }

    public Builder setParameters(Parameters parameters) {
      this.parameters = parameters;
      return this;
    }

    public Builder setTruncateConcat(Boolean truncateConcat) {
      this.truncateConcat = truncateConcat;
      return this;
    }

    public Builder setMaxNumberOfMessageParts(Integer maxNumberOfMessageParts) {
      this.maxNumberOfMessageParts = maxNumberOfMessageParts;
      return this;
    }

    public Builder setFromTon(Integer fromTon) {
      this.fromTon = fromTon;
      return this;
    }

    public Builder setFromNpi(Integer fromNpi) {
      this.fromNpi = fromNpi;
      return this;
    }

    public SendSmsBatchTextRequest build() {
      return new SendSmsBatchTextRequest(
          to,
          from,
          body,
          deliveryReport,
          sendAt,
          expireAt,
          callbackUrl,
          clientReference,
          flashMessage,
          feedbackEnabled,
          parameters,
          truncateConcat,
          maxNumberOfMessageParts,
          fromTon,
          fromNpi);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
