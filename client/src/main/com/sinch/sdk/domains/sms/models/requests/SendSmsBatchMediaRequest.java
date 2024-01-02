package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.MediaBody;
import com.sinch.sdk.domains.sms.models.Parameters;
import java.time.Instant;
import java.util.Collection;

public class SendSmsBatchMediaRequest extends BaseBatch<MediaBody> {
  private final OptionalValue<Parameters> parameters;
  private final OptionalValue<Boolean> strictValidation;

  private SendSmsBatchMediaRequest(
      Collection<String> to,
      OptionalValue<String> from,
      MediaBody body,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<String> clientReference,
      OptionalValue<Boolean> feedbackEnabled,
      OptionalValue<Parameters> parameters,
      OptionalValue<Boolean> strictValidation) {
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
    this.parameters = parameters;
    this.strictValidation = strictValidation;
  }

  public OptionalValue<Parameters> getParameters() {
    return parameters;
  }

  public OptionalValue<Boolean> isStrictValidation() {
    return strictValidation;
  }

  @Override
  public String toString() {
    return "SendSmsBatchMediaRequest{"
        + "parameters="
        + parameters
        + ", strictValidation="
        + strictValidation
        + ", base='"
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends BaseBatch.Builder<MediaBody, Builder> {
    private OptionalValue<Parameters> parameters = OptionalValue.empty();
    private OptionalValue<Boolean> strictValidation = OptionalValue.empty();

    private Builder() {}

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
     * @param strictValidation Whether or not you want the media included in your message to be
     *     checked against Sinch MMS channel best practices. If set to true, your message will be
     *     rejected if it doesn't conform to the listed recommendations, otherwise no validation
     *     will be performed.
     * @return current builder
     */
    public Builder setStrictValidation(Boolean strictValidation) {
      this.strictValidation = OptionalValue.of(strictValidation);
      return this;
    }

    public SendSmsBatchMediaRequest build() {
      return new SendSmsBatchMediaRequest(
          to,
          from,
          body,
          deliveryReport,
          sendAt,
          expireAt,
          callbackUrl,
          clientReference,
          feedbackEnabled,
          parameters,
          strictValidation);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
