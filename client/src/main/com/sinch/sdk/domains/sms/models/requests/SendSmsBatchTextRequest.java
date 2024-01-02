package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.Parameters;
import java.time.Instant;
import java.util.Collection;

public class SendSmsBatchTextRequest extends BaseBatch<String> {
  private final OptionalValue<Boolean> flashMessage;
  private final OptionalValue<Parameters> parameters;
  private final OptionalValue<Boolean> truncateConcat;
  private final OptionalValue<Integer> maxNumberOfMessageParts;
  private final OptionalValue<Integer> fromTon;
  private final OptionalValue<Integer> fromNpi;

  private SendSmsBatchTextRequest(
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
      OptionalValue<Parameters> parameters,
      OptionalValue<Boolean> truncateConcat,
      OptionalValue<Integer> maxNumberOfMessageParts,
      OptionalValue<Integer> fromTon,
      OptionalValue<Integer> fromNpi) {
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

  public OptionalValue<Parameters> getParameters() {
    return parameters;
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
    private OptionalValue<Boolean> flashMessage = OptionalValue.empty();
    private OptionalValue<Parameters> parameters = OptionalValue.empty();
    private OptionalValue<Boolean> truncateConcat = OptionalValue.empty();
    private OptionalValue<Integer> maxNumberOfMessageParts = OptionalValue.empty();
    private OptionalValue<Integer> fromTon = OptionalValue.empty();
    private OptionalValue<Integer> fromNpi = OptionalValue.empty();

    private Builder() {}

    /**
     * @param flashMessage If sent as a flash message, displays true.
     * @return current builder
     */
    public Builder setFlashMessage(boolean flashMessage) {
      this.flashMessage = OptionalValue.of(flashMessage);
      return this;
    }

    /**
     * @param parameters Contains the parameters that will be used for customizing the message for
     *     each recipient.
     * @return current builder
     */
    public Builder setParameters(Parameters parameters) {
      this.parameters = OptionalValue.of(parameters);
      return this;
    }

    /**
     * @param truncateConcat If set to true, the message was shortened when exceeding one part.
     * @return current builder
     */
    public Builder setTruncateConcat(Boolean truncateConcat) {
      this.truncateConcat = OptionalValue.of(truncateConcat);
      return this;
    }

    /**
     * @param maxNumberOfMessageParts Displays the number of message parts set in the request.
     * @return current builder
     */
    public Builder setMaxNumberOfMessageParts(Integer maxNumberOfMessageParts) {
      this.maxNumberOfMessageParts = OptionalValue.of(maxNumberOfMessageParts);
      return this;
    }

    /**
     * @param fromTon The type of number for the sender number.
     * @return current builder
     */
    public Builder setFromTon(Integer fromTon) {
      this.fromTon = OptionalValue.of(fromTon);
      return this;
    }

    /**
     * @param fromNpi Number Plan Indicator for the sender number.
     * @return current builder
     */
    public Builder setFromNpi(Integer fromNpi) {
      this.fromNpi = OptionalValue.of(fromNpi);
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
