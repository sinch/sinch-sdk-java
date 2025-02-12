package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import java.time.Instant;
import java.util.Collection;

public class SendSmsBatchBinaryRequest extends BaseBatch<String> {
  private final OptionalValue<Boolean> flashMessage;
  private final OptionalValue<Boolean> truncateConcat;
  private final OptionalValue<Integer> maxNumberOfMessageParts;
  private final OptionalValue<Integer> fromTon;
  private final OptionalValue<Integer> fromNpi;
  private final OptionalValue<String> udh;

  private SendSmsBatchBinaryRequest(
      Collection<String> to,
      OptionalValue<String> from,
      String body,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<String> clientReference,
      OptionalValue<Boolean> flashMessage,
      OptionalValue<Boolean> feedbackEnabled,
      OptionalValue<Boolean> truncateConcat,
      OptionalValue<Integer> maxNumberOfMessageParts,
      OptionalValue<Integer> fromTon,
      OptionalValue<Integer> fromNpi,
      OptionalValue<String> udh) {
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

  public OptionalValue<Boolean> isFlashMessage() {
    return flashMessage;
  }

  public OptionalValue<Boolean> isTruncateConcat() {
    return truncateConcat;
  }

  public OptionalValue<Integer> getMaxNumberOfMessageParts() {
    return maxNumberOfMessageParts;
  }

  public OptionalValue<Integer> getFromTon() {
    return fromTon;
  }

  public OptionalValue<Integer> getFromNpi() {
    return fromNpi;
  }

  public OptionalValue<String> getUdh() {
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
    private OptionalValue<Boolean> flashMessage = OptionalValue.empty();
    private OptionalValue<Boolean> truncateConcat = OptionalValue.empty();
    private OptionalValue<Integer> maxNumberOfMessageParts = OptionalValue.empty();
    private OptionalValue<Integer> fromTon = OptionalValue.empty();
    private OptionalValue<Integer> fromNpi = OptionalValue.empty();
    private OptionalValue<String> udh = OptionalValue.empty();

    private Builder() {
      super();
    }

    /**
     * @param flashMessage If sent as a flash message, displays true.
     * @return current builder
     * @deprecated
     */
    public Builder setFlashMessage(boolean flashMessage) {
      this.flashMessage = OptionalValue.of(flashMessage);
      return this;
    }

    /**
     * @param truncateConcat If set to true, the message was shortened when exceeding one part.
     * @return current builder
     * @deprecated
     */
    public Builder setTruncateConcat(boolean truncateConcat) {
      this.truncateConcat = OptionalValue.of(truncateConcat);
      return this;
    }

    /**
     * @param maxNumberOfMessageParts Displays the number of message parts set in the request.
     * @return current builder
     * @deprecated
     */
    public Builder setMaxNumberOfMessageParts(int maxNumberOfMessageParts) {
      this.maxNumberOfMessageParts = OptionalValue.of(maxNumberOfMessageParts);
      return this;
    }

    /**
     * @param fromTon The type of number for the sender number.
     * @return current builder
     */
    public Builder setFromTon(int fromTon) {
      this.fromTon = OptionalValue.of(fromTon);
      return this;
    }

    /**
     * @param fromNpi Number Plan Indicator for the sender number.
     * @return current builder
     */
    public Builder setFromNpi(int fromNpi) {
      this.fromNpi = OptionalValue.of(fromNpi);
      return this;
    }

    /**
     * @param udh The UDH header of a binary message HEX encoded. Max 140 bytes including the body.
     * @return current builder
     */
    public Builder setUdh(String udh) {
      this.udh = OptionalValue.of(udh);
      return this;
    }

    @Override
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
