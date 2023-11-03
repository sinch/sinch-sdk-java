package com.sinch.sdk.domains.sms.models;

import java.time.Instant;
import java.util.Collection;

/**
 * BatchBinary type
 *
 * @since 1.0
 */
public class BatchBinary extends Batch<String> {
  private final Boolean flashMessage;
  private final Boolean truncateConcat;
  private final Integer maxNumberOfMessageParts;
  private final Integer fromTon;
  private final Integer fromNpi;
  private final String udh;

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
   * @param feedbackEnabled If set to true, then feedback is expected after successful delivery. *
   * @param flashMessage If sent as a flash message, displays true.
   * @param truncateConcat If set to true, the message was shortened when exceeding one part.
   * @param maxNumberOfMessageParts Displays the number of message parts set in the request.
   * @param fromTon The type of number for the sender number.
   * @param fromNpi Number Plan Indicator for the sender number.
   * @param udh The UDH header of a binary message HEX encoded. Max 140 bytes including the body.
   */
  public BatchBinary(
      String id,
      Collection<String> to,
      String from,
      Boolean canceled,
      String body,
      Instant createdAt,
      Instant modifiedAt,
      DeliveryReport deliveryReport,
      Instant sendAt,
      Instant expireAt,
      String callbackUrl,
      String clientReference,
      Boolean feedbackEnabled,
      Boolean flashMessage,
      Boolean truncateConcat,
      Integer maxNumberOfMessageParts,
      Integer fromTon,
      Integer fromNpi,
      String udh) {
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
    this.truncateConcat = truncateConcat;
    this.maxNumberOfMessageParts = maxNumberOfMessageParts;
    this.fromTon = fromTon;
    this.fromNpi = fromNpi;
    this.udh = udh;
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

  public String getUdh() {
    return udh;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "BatchBinary{"
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
        + "} "
        + super.toString();
  }

  public static class Builder extends Batch.Builder<String, Builder> {

    private Boolean flashMessage;
    private Boolean truncateConcat;
    private Integer maxNumberOfMessageParts;
    private Integer fromTon;
    private Integer fromNpi;
    private String udh;

    private Builder() {}

    public Builder setFlashMessage(Boolean flashMessage) {
      this.flashMessage = flashMessage;
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

    public Builder setUdh(String udh) {
      this.udh = udh;
      return this;
    }

    public BatchBinary build() {
      return new BatchBinary(
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
          feedbackEnabled,
          flashMessage,
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
