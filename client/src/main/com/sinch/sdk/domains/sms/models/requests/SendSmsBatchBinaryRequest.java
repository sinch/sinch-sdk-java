package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

public class SendSmsBatchBinaryRequest extends BaseBatch<String> {
  private final Boolean flashMessage;
  private final Boolean truncateConcat;
  private final Integer maxNumberOfMessageParts;
  private final Integer fromTon;
  private final Integer fromNpi;
  private final String udh;
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
   * @param flashMessage If sent as a flash message, displays true.
   * @param truncateConcat If set to true, the message was shortened when exceeding one part.
   * @param maxNumberOfMessageParts Displays the number of message parts set in the request.
   * @param fromTon The type of number for the sender number.
   * @param fromNpi Number Plan Indicator for the sender number.
   * @param udh The UDH header of a binary message HEX encoded. Max 140 bytes including the body.
   */
  public SendSmsBatchBinaryRequest(
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
      Boolean truncateConcat,
      Integer maxNumberOfMessageParts,
      Integer fromTon,
      Integer fromNpi,
      String udh) {
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
    this.truncateConcat = truncateConcat;
    this.maxNumberOfMessageParts = maxNumberOfMessageParts;
    this.fromTon = fromTon;
    this.fromNpi = fromNpi;
    this.udh = udh;
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

  public String getUdh() {
    return udh;
  }

  @Override
  public String toString() {
    return "SendSmsBatchBinaryRequest{"
        + "flashMessage="
        + flashMessage
        + ", truncateConcat="
        + truncateConcat
        + ", maxNumberOfMessageParts="
        + maxNumberOfMessageParts
        + ", fromTon="
        + fromTon
        + ", fromNpi="
        + fromNpi
        + ", udh='"
        + udh
        + '\''
        + ", base='"
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends BaseBatch.Builder<String, Builder> {
    private Boolean flashMessage;
    private Boolean truncateConcat;
    private Integer maxNumberOfMessageParts;
    private Integer fromTon;
    private Integer fromNpi;
    private String udh;

    private Builder() {}

    public Builder setFlashMessage(boolean flashMessage) {
      this.flashMessage = flashMessage;
      return this;
    }

    public Builder setTruncateConcat(boolean truncateConcat) {
      this.truncateConcat = truncateConcat;
      return this;
    }

    public Builder setMaxNumberOfMessageParts(int maxNumberOfMessageParts) {
      this.maxNumberOfMessageParts = maxNumberOfMessageParts;
      return this;
    }

    public Builder setFromTon(int fromTon) {
      this.fromTon = fromTon;
      return this;
    }

    public Builder setFromNpi(int fromNpi) {
      this.fromNpi = fromNpi;
      return this;
    }

    public Builder setUdh(String udh) {
      this.udh = udh;
      return this;
    }

    public SendSmsBatchBinaryRequest build() {
      return new SendSmsBatchBinaryRequest(
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
          truncateConcat,
          maxNumberOfMessageParts,
          fromTon,
          fromNpi,
          udh);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
