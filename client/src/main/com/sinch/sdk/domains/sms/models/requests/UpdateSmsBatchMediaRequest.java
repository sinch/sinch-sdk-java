package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.MediaBody;
import com.sinch.sdk.domains.sms.models.Parameters;
import java.time.Instant;
import java.util.Collection;

public class UpdateSmsBatchMediaRequest extends UpdateBaseBatchRequest<MediaBody> {
  private final OptionalValue<Parameters> parameters;
  private final OptionalValue<Boolean> strictValidation;

  public UpdateSmsBatchMediaRequest(
      OptionalValue<Collection<String>> toAdd,
      OptionalValue<Collection<String>> toRemove,
      OptionalValue<String> from,
      OptionalValue<MediaBody> body,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<Parameters> parameters,
      OptionalValue<Boolean> strictValidation) {
    super(toAdd, toRemove, from, body, deliveryReport, sendAt, expireAt, callbackUrl);
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
    return "UpdateSmsBatchMediaRequest{"
        + "parameters="
        + parameters
        + ", strictValidation="
        + strictValidation
        + "} "
        + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends UpdateBaseBatchRequest.Builder<MediaBody, Builder> {
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
     *     will be performed
     * @return current builder
     */
    public Builder setStrictValidation(Boolean strictValidation) {
      this.strictValidation = OptionalValue.of(strictValidation);
      return this;
    }

    public UpdateSmsBatchMediaRequest build() {
      return new UpdateSmsBatchMediaRequest(
          toAdd,
          toRemove,
          from,
          body,
          deliveryReportType,
          sendAt,
          expireAt,
          callbackUrl,
          parameters,
          strictValidation);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
