package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.Parameters;
import java.time.Instant;
import java.util.Collection;

public class UpdateSmsBatchTextRequest extends UpdateBaseBatchRequest<String> {
  private final OptionalValue<Parameters> parameters;

  public UpdateSmsBatchTextRequest(
      OptionalValue<Collection<String>> toAdd,
      OptionalValue<Collection<String>> toRemove,
      OptionalValue<String> from,
      OptionalValue<String> body,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<Parameters> parameters) {
    super(toAdd, toRemove, from, body, deliveryReport, sendAt, expireAt, callbackUrl);
    this.parameters = parameters;
  }

  public OptionalValue<Parameters> getParameters() {
    return parameters;
  }

  @Override
  public String toString() {
    return "UpdateSmsBatchTextRequest{" + "parameters=" + parameters + "} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends UpdateBaseBatchRequest.Builder<String, Builder> {
    private OptionalValue<Parameters> parameters = OptionalValue.empty();

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

    public UpdateSmsBatchTextRequest build() {
      return new UpdateSmsBatchTextRequest(
          toAdd,
          toRemove,
          from,
          body,
          deliveryReportType,
          sendAt,
          expireAt,
          callbackUrl,
          parameters);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
