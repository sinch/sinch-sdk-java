package com.sinch.sdk.domains.sms.models;

import java.time.Instant;
import java.util.Collection;

/**
 * BatchText type
 *
 * @since 1.0
 */
public class BatchText extends Batch<String> {
  private final Boolean flashMessage;
  private final Parameters parameters;
  private final Boolean truncateConcat;
  private final Integer maxNumberOfMessageParts;
  private final Integer fromTon;
  private final Integer fromNpi;

  /**
   * @param id Unique identifier for batch
   * @param to List of Phone numbers and group IDs that will receive the batch
   * @param from Sender number. Must be valid phone number, short code or alphanumeric. Required if
   *     Automatic Default Originator not configured.
   * @param canceled Indicates if the batch has been canceled or not.
   * @param body The message content
   * @param createdAt when batch was created
   * @param modifiedAt when batch was last updated
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
  public BatchText(
      String id,
      Collection<String> to,
      String from,
      Boolean canceled,
      String body,
      Instant createdAt,
      Instant modifiedAt,
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
        id,
        to,
        from,
        canceled,
        body,
        createdAt,
        modifiedAt,
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

  public Parameters getParameters() {
    return parameters;
  }

  public Boolean isFlashMessage() {
    return flashMessage;
  }

  public Boolean isTruncateConcat() {
    return truncateConcat;
  }

  public Integer getMaxNumberOfMessageParts() {
    return maxNumberOfMessageParts;
  }

  public Integer getFromTon() {
    return fromTon;
  }

  public Integer getFromNpi() {
    return fromNpi;
  }

  @Override
  public String toString() {
    return "BatchText{"
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

  public static class Builder extends Batch.Builder<String, Builder> {
    private Boolean flashMessage;
    private Parameters parameters;
    private Boolean truncateConcat;
    private Integer maxNumberOfMessageParts;
    private Integer fromTon;
    private Integer fromNpi;

    private Builder() {}

    public Builder setFlashMessage(Boolean flashMessage) {
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

    public BatchText build() {
      return new BatchText(
          id,
          to,
          from,
          canceled,
          body,
          createdAt,
          modifiedAt,
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
