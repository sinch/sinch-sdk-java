package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import java.time.Instant;
import java.util.Collection;

public class UpdateSmsBatchBinaryRequest extends UpdateBaseBatchRequest<String> {
  private final OptionalValue<String> udh;

  private UpdateSmsBatchBinaryRequest(
      OptionalValue<Collection<String>> toAdd,
      OptionalValue<Collection<String>> toRemove,
      OptionalValue<String> from,
      OptionalValue<String> body,
      OptionalValue<DeliveryReportType> deliveryReport,
      OptionalValue<Instant> sendAt,
      OptionalValue<Instant> expireAt,
      OptionalValue<String> callbackUrl,
      OptionalValue<String> udh) {
    super(toAdd, toRemove, from, body, deliveryReport, sendAt, expireAt, callbackUrl);
    this.udh = udh;
  }

  public OptionalValue<String> getUdh() {
    return udh;
  }

  @Override
  public String toString() {
    return "UpdateSmsBatchBinaryRequest{" + "udh='" + udh + '\'' + "} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends UpdateBaseBatchRequest.Builder<String, Builder> {

    private OptionalValue<String> udh;

    private Builder() {}

    /**
     * @param udh The UDH header of a binary message HEX encoded. Max 140 bytes including the body.
     * @return current builder
     */
    public Builder setUdh(String udh) {
      this.udh = OptionalValue.of(udh);
      return this;
    }

    public UpdateSmsBatchBinaryRequest build() {
      return new UpdateSmsBatchBinaryRequest(
          toAdd, toRemove, from, body, deliveryReportType, sendAt, expireAt, callbackUrl, udh);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
